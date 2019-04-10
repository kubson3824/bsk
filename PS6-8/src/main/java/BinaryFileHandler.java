import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryFileHandler {

    public long getSize() {
        return size;
    }

    private long size = 0;

    public String writeBinaryFile(List<byte[]> bytesToWrite, String filePath) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        boolean lastByteFlag = false;
        byte[] lastByte = bytesToWrite.remove(bytesToWrite.size() - 1);
        if (size < bytesToWrite.size() * 8 && size > bytesToWrite.size() * 8 - 64) {
            lastByteFlag = true;
            long lastByteLength = size - bytesToWrite.size() * 8;
            for (int i = 0; i < lastByteLength; i++) {
                outputStream.write(lastByte[i]);
            }
        }
        for (byte[] bytes : bytesToWrite) {
            outputStream.write(bytes.clone());
        }
        outputStream.close();

        return "File was saved to " + filePath;
    }

    public List<byte[]> readBinaryFile(String filePath) throws IOException {
        List<byte[]> bytes = new ArrayList<byte[]>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStream inputStream = new BufferedInputStream(fileInputStream);
        size = fileInputStream.getChannel().size();
        byte[] buffer = new byte[8];
        while (inputStream.read(buffer) != -1) {
            bytes.add(buffer.clone());
            System.out.println(Arrays.toString(buffer));
        }
        inputStream.close();
        return bytes;

    }

}
