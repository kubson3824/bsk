import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class BinaryFileHandler {

    static List<Boolean[]> readFile(String filePath) {
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

    private static Boolean[] bytesToBooleans(byte[] bytes) {
        Boolean[] bools = new Boolean[bytes.length * 8];
        byte[] pos = new byte[]{(byte) 0x80, 0x40, 0x20, 0x10, 0x8, 0x4, 0x2, 0x1};

        for (int i = 0; i < bytes.length; i++) {
            for (int j = i * 8, k = 0; k < 8; j++, k++) {
                bools[j] = (bytes[i] & pos[k]) != 0;
            }
        }

        return bools;
    }

    static Boolean[] stringToBoolean(String readLine) {
        Boolean[] result = new Boolean[readLine.length()];
        for (int i = 0; i < readLine.length(); i++) {
            result[i] = readLine.charAt(i) == '1';
        }

        return result;
    }

    static String booleanToString(Boolean[] inputArray) {
        StringBuilder result = new StringBuilder();
        for (Boolean b : inputArray) {
            result.append(b ? "1" : "0");
        }
        return result.toString();
    }
}
