import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryFileHandler {

    public String writeEncryptedBinaryFile(List<byte[]> bytesToWrite, String filePath) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        PrintWriter printWriter = new PrintWriter("logi.txt");

        for (byte[] bytes : bytesToWrite) {
            printWriter.println(Arrays.toString(bytes));
            outputStream.write(bytes.clone());
        }
        outputStream.close();

        return "File was saved to " + filePath;
    }

    public String writeDecryptedBinaryFile(List<byte[]> bytesToWrite, String filePath) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        for (int i = 0; i < bytesToWrite.size(); i++) {
            if (i == bytesToWrite.size() - 1) {
                int j = 7;
                while (j > 0) {
                    if (bytesToWrite.get(i)[j - 1] == -128 && bytesToWrite.get(i)[j] == 0) {
                        for (int k = 0; k < j - 1; k++) {
                            outputStream.write(bytesToWrite.get(i)[k]);
                        }
                        break;
                    }
                    j--;

                }
            } else {
                outputStream.write(bytesToWrite.get(i).clone());
            }
        }
        outputStream.close();

        return "File was saved to " + filePath;
    }

    public List<byte[]> readToDecryptBinaryFile(String filePath) throws IOException {
        List<byte[]> bytes = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStream inputStream = new BufferedInputStream(fileInputStream);
        byte[] buffer = new byte[8];
        while (inputStream.read(buffer) != -1) {
            bytes.add(buffer.clone());
//            System.out.println(Arrays.toString(buffer));
        }
        inputStream.close();
        return bytes;
    }

    public List<byte[]> readBinaryFile(String filePath) throws IOException {
        List<byte[]> bytes = new ArrayList<>();

        boolean bonus_block = false;

        FileInputStream fileInputStream = new FileInputStream(filePath);
//        System.out.println(fileInputStream.available());
        InputStream inputStream = new BufferedInputStream(fileInputStream);
        if (inputStream.available() % 8 == 0) {
            bonus_block = true;
        }
        int last_byte_length = -1;
        byte[] buffer = new byte[8];
        while (inputStream.read(buffer) != -1) {
//            System.out.println(inputStream.available());
            if (inputStream.available() > 0 && inputStream.available() < 8) {
                last_byte_length = inputStream.available();
            }
            if ((inputStream.available() == 0 && last_byte_length != -1) || (bonus_block && inputStream.available() == 0)) {
                if (last_byte_length == -1) {
                    bytes.add(buffer);
                    last_byte_length = 0;
                }
                byte[] last_block = new byte[8];
                for (int i = 0; i < last_byte_length; i++) {
                    last_block[i] = buffer[i];
                }
                for (int i = last_byte_length; i < 8; i++) {
                    if (i == last_byte_length) {
                        last_block[i] = (byte) 128;
                    } else {
                        last_block[i] = 0;
                    }
                }
                bytes.add(last_block);
            } else {
                bytes.add(buffer.clone());
            }
        }
        inputStream.close();
        return bytes;

    }


    static byte[] booleanToByte(Boolean[] booleans) {
        byte[] result = new byte[booleans.length / 8];
        for (int entry = 0; entry < result.length; entry++) {
            for (int bit = 0; bit < 8; bit++) {
                if (booleans[entry * 8 + bit]) {
                    result[entry] |= (128 >> bit);
                }
            }
        }
        return result;
    }

    static Boolean[] stringToBoolean(String readLine) {
        Boolean[] result = new Boolean[readLine.length()];
        for (int i = 0; i < readLine.length(); i++) {
            result[i] = readLine.charAt(i) == '1';
        }

        return result;
    }

}
