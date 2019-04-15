import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler();
        List<byte[]> plik = binaryFileHandler.readBinaryFile("test2.bin");
        BigInteger key = new BigInteger("F33457799BBCDFF1", 16);
        List<BigInteger> keys = DES.generateKeys(key);
        List<BigInteger> words = bytesListToBigIntList(plik);

        //ZAKODOWANIE
        List<BigInteger> encryptedWords = DES.encryptLoop(words, keys);
        List<String> encryptedWordsStrings = new ArrayList<>();

        List<byte[]> encrypted_output = stringsListToBytesList(encryptedWordsStrings, encryptedWords);

        System.out.println(binaryFileHandler.writeEncryptedBinaryFile(encrypted_output, "zaszyfrowany.bin"));

        //DESZYFROWANIE
        List<byte[]> plik_zaszyfrowany = binaryFileHandler.readToDecryptBinaryFile("zaszyfrowany.bin");
        List<BigInteger> wordsToDecrypt = bytesListToBigIntList(plik_zaszyfrowany);

        List<String> decryptedWordsStrings = new ArrayList<>();
        List<BigInteger> decryptedWords = DES.decryptLoop(wordsToDecrypt, keys);
        List<byte[]> decrypted_output = stringsListToBytesList(decryptedWordsStrings, decryptedWords);

        System.out.println(binaryFileHandler.writeDecryptedBinaryFile(decrypted_output, "odszyfrowany.bin"));

    }

    private static List<BigInteger> bytesListToBigIntList(List<byte[]> plik_zaszyfrowany) {
        List<BigInteger> wordsToDecrypt = new ArrayList<>();
        for (byte[] bytes : plik_zaszyfrowany) {
            String s = new String("");
            for (int i = 0; i < bytes.length; i++) {
                String kawalek = Integer.toString(Byte.toUnsignedInt(bytes[i]), 2);
                if (kawalek.length() < 8) {
                    for (int j = kawalek.length(); j < 8; j++) {
                        kawalek = "0" + kawalek;
                    }
                }
                s += kawalek;
            }
            BigInteger newWord = new BigInteger(s, 2);
            wordsToDecrypt.add(newWord);
        }
        return wordsToDecrypt;
    }

    private static List<byte[]> stringsListToBytesList(List<String> decryptedWordsStrings, List<BigInteger> decryptedWords) {
        decryptedWords.forEach(dW -> {
            String kawalek = dW.toString(2);
            if (kawalek.length() < 64) {
                for (int j = kawalek.length(); j < 64; j++) {
                    kawalek = "0" + kawalek;
                }
            }
            decryptedWordsStrings.add(kawalek);
        });

        List<byte[]> decrypted_output = new ArrayList<>();
        decryptedWordsStrings.forEach(s -> {
            Boolean[] stringToBoolean = BinaryFileHandler.stringToBoolean(s);
            byte[] bytes = BinaryFileHandler.booleanToByte(stringToBoolean);
            decrypted_output.add(bytes);
        });
        return decrypted_output;
    }


}
