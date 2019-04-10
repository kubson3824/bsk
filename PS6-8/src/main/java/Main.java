import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        BigInteger b = new BigInteger("5");
        List<BigInteger> keys = DES.generateKeys(b);
    }
}
