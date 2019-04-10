import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BinaryFileHandler handler = new BinaryFileHandler();
        List<byte[]> bytes = handler.readBinaryFile("test3.bin");
        for (byte[] aByte : bytes) {
            System.out.println(Arrays.toString(aByte));
        }
        System.out.println(handler.writeBinaryFile(bytes, "Out1.bin"));
    }
}
