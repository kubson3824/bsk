import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler();
        List<byte[]> plik = binaryFileHandler.readBinaryFile("edytowany2.bin");
        BigInteger key = new BigInteger("133457799BBCDFF1", 16);
        List<BigInteger> keys = DES.generateKeys(key);
        List<BigInteger> words = new ArrayList<>();
        for (byte[] bytes : plik) {
            words.add(new BigInteger(bytes));
        }

        List<String> encryptedWords = DES.encryptLoop(words, keys);
        List<byte[]> output = new ArrayList<>();
        encryptedWords.forEach(System.out::println);
        System.out.println(binaryFileHandler.writeBinaryFile(output, "out1.bin"));

    }
}
