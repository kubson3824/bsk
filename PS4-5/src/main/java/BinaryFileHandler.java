import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileHandler {

    public static List<Boolean[]> readFile(String filePath) {
        List<Boolean[]> result = new ArrayList<>();
        try (
                InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))
        ) {
            byte[] buffer = new byte[1];
            while (inputStream.read(buffer) != -1) {
                if (buffer[0] != 0) {
                    result.add(bytesToBooleans(buffer));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean[] bytesToBooleans(byte[] bytes) {
        Boolean[] bools = new Boolean[bytes.length * 8];
        byte[] pos = new byte[]{(byte) 0x80, 0x40, 0x20, 0x10, 0x8, 0x4, 0x2, 0x1};

        for (int i = 0; i < bytes.length; i++) {
            for (int j = i * 8, k = 0; k < 8; j++, k++) {
                bools[j] = (bytes[i] & pos[k]) != 0;
            }
        }

        return bools;
    }
}
