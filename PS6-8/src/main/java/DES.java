import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DES {

    //pamietac aby przy pobieraniu wartosci, obnizyc ja o 1
    public static int[] tab = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    public static int[] shifts = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};

    public static List<BigInteger> generateKeys(BigInteger key){
        List<BigInteger> keys = new ArrayList<BigInteger>();
        BigInteger newKey = new BigInteger("0");
        BigInteger c= new BigInteger("0");
        BigInteger d= new BigInteger("0");
        int max = 55;
        for(int i =0; i<56; i++) {
            if (key.testBit((tab[i] - 1))) {
                newKey = newKey.setBit(55-i);
            } else {
                newKey = newKey.clearBit(55-i);
            }
        }
        if(newKey.testBit(55)){

        }
        c = newKey.shiftRight(28);
        BigInteger pom = c.shiftLeft(28);
        d= newKey.subtract(pom);
        System.out.println(newKey);
        System.out.println(newKey.toString(2));
        System.out.println(c);
        System.out.println(d);

        for(int i=0; i<16; i++){
            c=c.shiftLeft(shifts[i]);
            d=d.shiftLeft(shifts[i]);
            if(c.testBit(28)){
                c=c.clearBit(28);
            }
            if(d.testBit(28)){
                d=d.clearBit(28);
            }
            if(c.testBit(29)){
                c=c.clearBit(29);
            }
            if(d.testBit(29)){
                d=d.clearBit(29);
            }
            BigInteger pom2 = c.shiftLeft(28);
            BigInteger sum = pom2.add(d);
            keys.add(sum);
            System.out.println(sum.toString(2));
        }
        return keys;
    }
}
