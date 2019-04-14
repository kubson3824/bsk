import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String []args){
        BigInteger b = new BigInteger("133457799BBCDFF1", 16);
        BigInteger word = new BigInteger("0123456789ABCDEF", 16);
        List<BigInteger> keys = DES.generateKeys(b);
        DES.encrypt(word, keys);
//        DES.cipherFunction(new BigInteger("11110000101010101111000010101010",2), new BigInteger("000110110000001011101111111111000111000001110010", 2));
    }
}
