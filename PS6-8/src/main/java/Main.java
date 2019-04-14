import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        BigInteger b = new BigInteger("AABB09182736CCDD",16);
        BigInteger word = new BigInteger("123456ABCD132536",16);
        List<BigInteger> keys = DES.generateKeys(b);
        DES.encrypt(word,keys);
//        DES.cipherFunction(new BigInteger("100101100010011000101010010101001",2), new BigInteger("427e2530e5af", 16));
    }
}
