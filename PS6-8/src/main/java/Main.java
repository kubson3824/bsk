import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        BigInteger b = new BigInteger("133457799BBCDFF1", 16);
        BigInteger word = new BigInteger("0123456789ABCDEF", 16);
        List<BigInteger> keys = DES.generateKeys(b);
        List<BigInteger> words = new ArrayList<>();
        words.add(word);
        words.add(word);
        words.add(word);
        BigInteger wordToDecrypt = DES.encrypt(word, keys);
        DES.decrypt(wordToDecrypt, keys);
        List<BigInteger> bigIntegers = DES.encryptLoop(words, keys);
        bigIntegers.forEach(b2 -> System.out.println(b2.toString(16)));
//        DES.cipherFunction(new BigInteger("11110000101010101111000010101010",2), new BigInteger("000110110000001011101111111111000111000001110010", 2));
    }
}
