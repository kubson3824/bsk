import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
//        BigInteger b = new BigInteger("53423416854",10);
//        List<BigInteger> keys = DES.generateKeys(b);
        DES.cipherFunction(new BigInteger("110101001010101010100101001", 2), new BigInteger("3132131"));
    }
}
