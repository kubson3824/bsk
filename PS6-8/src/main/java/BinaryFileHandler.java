import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryFileHandler {

    public String writeBinaryFile(List<byte[]> bytesToWrite, String filePath) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        for (byte[] bytes : bytesToWrite) {
            outputStream.write(bytes.clone());
        }
        outputStream.close();

        return "File was saved to " + filePath;
    }

    public List<byte[]> readBinaryFile(String filePath) throws IOException {
        List<byte[]> bytes = new ArrayList<byte[]>();

        InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] buffer = new byte[8];
        while (inputStream.read(buffer) != -1) {
            bytes.add(buffer.clone());
            System.out.println(Arrays.toString(buffer));
        }
        inputStream.close();

        return bytes;

    }

}
