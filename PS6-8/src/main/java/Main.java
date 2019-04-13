import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        BigInteger b = new BigInteger("AABB09182736CCDD",16); //2AAA951524A 101010101010101001010100010101001001001010
        BigInteger word = new BigInteger("45692AA5552B4B",16); //1000101011010010010101010100101010101010010101101001011
        List<BigInteger> keys = DES.generateKeys(b);
        DES.encrypt(word,keys);
//        DES.cipherFunction(new BigInteger("1010101010111011001000101010010101001",2), new BigInteger("11010001010100111101001010010101000010101001001", 2));
    }
}
