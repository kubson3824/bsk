import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileHandler {

    public String writeBinaryFile(List<byte[]> bytesToWrite, String filePath) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        for (byte[] bytes : bytesToWrite) {
//            System.out.println(Arrays.toString(bytes));
            outputStream.write(bytes.clone());
        }
        outputStream.close();

        return "File was saved to " + filePath;
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
        for (byte[] aByte : bytes) {
//            System.out.println(Arrays.toString(aByte));
        }
        inputStream.close();
        return bytes;

    }

}
