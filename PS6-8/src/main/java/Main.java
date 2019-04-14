import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler();
        List<byte[]> plik = binaryFileHandler.readBinaryFile("edytowany2.bin");
        BigInteger key = new BigInteger("133457799BBCDFF1", 16);
//        BigInteger word = new BigInteger("0123456789ABCDEF", 16);
        List<BigInteger> keys = DES.generateKeys(key);
        List<BigInteger> words = new ArrayList<>();
        for (byte[] bytes : plik) {
            words.add(new BigInteger(bytes));
        }
//        BigInteger wordToDecrypt = DES.encrypt(word, keys);
//        DES.decrypt(wordToDecrypt, keys);
        List<BigInteger> encryptedWords = DES.encryptLoop(words, keys);
        List<byte[]> output = new ArrayList<>();
        for (BigInteger word : encryptedWords) {
            output.add(word.toByteArray());
        }
        System.out.println(binaryFileHandler.writeBinaryFile(output, "out1.bin"));
//        String napis = "fd";
//        napis.getBytes();
        encryptedWords.forEach(k -> System.out.println(k.toString(16)));
//        DES.cipherFunction(new BigInteger("11110000101010101111000010101010",2), new BigInteger("000110110000001011101111111111000111000001110010", 2));
    }
}
