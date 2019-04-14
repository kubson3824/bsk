import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        BigInteger b = new BigInteger("0001001100110100010101110111100110011011101111001101111111110001",2);
        BigInteger word = new BigInteger("123456ABCD132536",16);
        List<BigInteger> keys = DES.generateKeys(b);
        List<BigInteger> correctKeys = new ArrayList<BigInteger>();
        correctKeys.add(new BigInteger("194cd072de8c", 16));
        correctKeys.add(new BigInteger("4568581abcce", 16));
        correctKeys.add(new BigInteger("06eda4acf5b5", 16));
        correctKeys.add(new BigInteger("da2d032b6ee3", 16));
        correctKeys.add(new BigInteger("69a629fec913", 16));
        correctKeys.add(new BigInteger("c1948e87475e", 16));
        correctKeys.add(new BigInteger("708ad2ddb3c0", 16));
        correctKeys.add(new BigInteger("34f822f0c66d", 16));
        correctKeys.add(new BigInteger("84bb4473dccc", 16));
        correctKeys.add(new BigInteger("02765708b5bf", 16));
        correctKeys.add(new BigInteger("6d5560af7ca5", 16));
        correctKeys.add(new BigInteger("c2c1e96a4bf3", 16));
        correctKeys.add(new BigInteger("99c31397c91f", 16));
        correctKeys.add(new BigInteger("251b8bc717d0", 16));
        correctKeys.add(new BigInteger("3330c5d9a36d", 16));
        correctKeys.add(new BigInteger("181c5d75c66d", 16));
        DES.encrypt(word,keys);
//        DES.cipherFunction(new BigInteger("100101100010011000101010010101001",2), new BigInteger("427e2530e5af", 16));
    }
}
