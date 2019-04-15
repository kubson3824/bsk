import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler();
        List<byte[]> plik = binaryFileHandler.readBinaryFile("edytowany2.bin");
        BigInteger key = new BigInteger("133457799BBCDFF1", 16);
        List<BigInteger> keys = DES.generateKeys(key);
        List<BigInteger> words = new ArrayList<>();
        for (byte[] bytes : plik) {
            BigInteger newWord = new BigInteger(bytes);
            words.add(newWord);
//            System.out.println(Arrays.toString(newWord.toByteArray()));
        }

        //ZAKODOWANIE
        List<BigInteger> encryptedWords = DES.encryptLoop(words, keys);
        List<byte[]> output = new ArrayList<>();
        System.out.println("Zakodowane: ");
        for (BigInteger word : encryptedWords) {
            System.out.println(word.toString(16));
            System.out.println(Arrays.toString(word.toByteArray()));
            if (word.toByteArray()[0] != 0) {
                System.out.println(Arrays.toString(word.toByteArray()));
                output.add(word.toByteArray());
            } else {
                System.out.println(Arrays.toString(Arrays.copyOfRange(word.toByteArray(), 1, 9)));
                output.add(Arrays.copyOfRange(word.toByteArray(), 1, 9));
            }
        }
        System.out.println(binaryFileHandler.writeEncryptedBinaryFile(output, "zaszyfrowany.bin"));


        //TODO Tutaj coś zaczyna się psuć po części
        List<byte[]> plik_zaszyfrowany = binaryFileHandler.readBinaryFile("zaszyfrowany.bin");
        List<BigInteger> wordsToDecrypt = new ArrayList<>();
        System.out.println("Po odczytaniu z pliku:");
        for (byte[] bytes : plik_zaszyfrowany) {
            byte[] temp = new byte[9];
            temp[0] = 0;
            System.arraycopy(bytes, 0, temp, 1, 8);
            BigInteger wordAsBig = new BigInteger(temp);
            wordsToDecrypt.add(wordAsBig);
        }

        List<BigInteger> decryptedWords = DES.decryptLoop(wordsToDecrypt, keys);
//        encryptedWords.forEach(System.out::println);
        List<byte[]> decrypted_output = new ArrayList<>();
        for (BigInteger word : decryptedWords) {
            decrypted_output.add(Arrays.copyOfRange(word.toByteArray(), 1, 9));
        }
        System.out.println(binaryFileHandler.writeDecryptedBinaryFile(decrypted_output, "odszyfrowany.bin"));

    }
}
