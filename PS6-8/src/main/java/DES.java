import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DES {

    //pamietac aby przy pobieraniu wartosci, obnizyc ja o 1
    public static int[] tab = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    public static int[] shifts = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
    public static int[] tab2={14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19 ,12, 4, 26, 8, 16, 7 ,27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
    public static int[] tabIp = {58, 50, 42, 34, 26, 18, 10 , 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    public static int[] tabIp2 = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43 ,11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
    public static int[] tabE = {32,  1,  2,  3,  4,  5, 4,  5,  6,  7,  8,  9, 8,  9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32,  1};
    public static int[] tabP = {16,  7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2,  8, 24, 14, 32, 27,  3,  9, 19, 13, 30,  6, 22, 11,  4, 25};
    public static int[][] s1 = {
            {14, 4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11,  9,  5,  3,  8},
            {4, 1, 14,  8, 13,  6, 2, 11, 15, 12,  9,  7,  3, 10,  5,  0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
    };
    public static int[][] s2 = {
            {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
            {3, 13,  4, 7, 15,  2,  8, 14, 12,  0, 1, 10,  6,  9, 11,  5},
            {0, 14, 7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15},
            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14,  9}
    };
    public static int[][] s3 = {
            {10, 0, 9, 14, 6, 3, 15, 5,  1, 13, 12, 7, 11, 4, 2,  8},
            {13, 7, 0, 9, 3,  4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14,  7},
            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
    };

    public static int[][] s4 = {
            {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14,  9},
            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
            {3, 15, 0, 6, 10, 1, 13, 8, 9,  4, 5, 11, 12, 7, 2, 14}
    };

    public static int[][] s5 = {
            {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
            {14, 11, 2, 12,  4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
    };

    public static int[][] s6 = {
            {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
    };

    public static int[][] s7 = {
            {4, 11, 2, 14, 15,  0, 8, 13 , 3, 12, 9 , 7,  5, 10, 6, 1},
            {13 , 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
    };

    public static int[][] s8 = {
            {13, 2, 8,  4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6 ,11, 0, 14, 9, 2},
            {7, 11, 4, 1, 9, 12, 14, 2,  0, 6, 10 ,13, 15, 3, 5, 8},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6 ,11}
    };
    public static int[][][] s = {s1, s2, s3, s4, s5, s6, s7, s8};

    public static List<BigInteger> generateKeys(BigInteger key){

        List<BigInteger> keys = new ArrayList<BigInteger>();
        BigInteger newKey = new BigInteger("0");
        BigInteger c= new BigInteger("0");
        BigInteger d= new BigInteger("0");

        //permutacja na tablicy tab(PC1)
        for(int i =0; i<56; i++) {
            if (key.testBit((tab[i] - 1))) {
                newKey = newKey.setBit(55-i);
            } else {
                newKey = newKey.clearBit(55-i);
            }
        }

        //dziele slowo na czesc lewa (c) i prawa (d) po 28 bitow
            c = newKey.shiftRight(28);
            BigInteger pom = c.shiftLeft(28);
            d = newKey.xor(pom);
//            System.out.println(newKey.toString(2));
//            System.out.println(c.toString(2));
//            System.out.println(d.toString(2));

        //przesuwam bity o liczbe w tablicy shifts i sprawdzam czy przy przesunieciu nie wychodze poza 28 bitow
        for(int i=0; i<16; i++){
            c=c.shiftLeft(shifts[i]);
            d=d.shiftLeft(shifts[i]);
            if(c.testBit(29)){
                c=c.clearBit(29);
                c=c.setBit(1);
                if(c.testBit(28)){
                    c=c.clearBit(28);
                    c=c.setBit(0);
                }
            }else{
                if(c.testBit(28)){
                    c=c.clearBit(28);
                    c=c.setBit(0);
                }
            }
            if(d.testBit(29)){
                d=d.clearBit(29);
                d=d.setBit(1);
                if(d.testBit(28)){
                    d=d.clearBit(28);
                    d=d.setBit(0);
                }
            }else{
                if(d.testBit(28)){
                    d=d.clearBit(28);
                    d=d.setBit(0);
                }
            }

//            System.out.println("c: "+c.toString(2));
//            System.out.println("d: "+d.toString(2));
            //lacze czesc lewa i prawa ( c i d)
            BigInteger pom2 = c.shiftLeft(28);
            BigInteger sum = pom2.add(d);
//            System.out.println("sum: "+sum.toString(2));
            BigInteger fin = new BigInteger("0");
            //permutacja na tablicy tab2(PC2)
            for(int j =0; j<48; j++) {
                if (sum.testBit((tab2[j] - 1))) {
                    fin = fin.setBit(47-j);
                } else {
                    fin = fin.clearBit(47-j);
                }
            }
            //dodaje klucz na liste
            keys.add(fin);
//            System.out.println("klucz: "+fin.toString(2));
        }
        return keys;
    }

    public static BigInteger cipherFunction(BigInteger r, BigInteger key){
        BigInteger result= new BigInteger("0");
        BigInteger e= new BigInteger("0");
        // permutacja po tablicy tabE, czesci prawej, po ktorej rozszerza sie z 32 do 48 bitow
        for(int i=0; i<48; i++){
            if (r.testBit((tabE[i] - 1))) {
                e = e.setBit(47-i);
            } else {
                e = e.clearBit(47-i);
            }
        }
        //xor z kluczem
        result=e.xor(key);
        BigInteger tabS[] = {new BigInteger("0"), new BigInteger("0"), new BigInteger("0"), new BigInteger("0"), new BigInteger("0"), new BigInteger("0"), new BigInteger("0"), new BigInteger("0")};
        int licznik=0;
//        System.out.println(result.toString(2));
        //dziele wyraz na 8 6-bitowych wyrazow
        for(int i=0;i<48;i++){
            if(result.testBit(i)){
                tabS[i/6] = tabS[i/6].setBit(i%6);
            }
        }
//        for(int i=0;i<8;i++){
//            System.out.println(tabS[i].toString(2));
//        }
        BigInteger tabSout[] = new BigInteger[8];
        //dziele 8 6-bitowych wyrazow na 8 4-bitowych wyrazow, sa w odwroconej kolejnosci bo potem latwiej je laczyc
        for(int i=0;i<8;i++){
            BigInteger row = new BigInteger("0");
            BigInteger col = new BigInteger("0");
            if(tabS[i].testBit(0)){
                row=row.setBit(0);
            }
            if(tabS[i].testBit(5)){
                row=row.setBit(1);
            }
            if(tabS[i].testBit(1)){
                col=col.setBit(0);
            }
            if(tabS[i].testBit(2)){
                col=col.setBit(1);
            }
            if(tabS[i].testBit(3)){
                col=col.setBit(2);
            }
            if(tabS[i].testBit(4)){
                col=col.setBit(3);
            }
            int rowInt=row.intValue();
            int colInt=col.intValue();
            String pom = Integer.toString(s[i][rowInt][colInt],10);

//            System.out.println(rowInt);
//            System.out.println(colInt);
//            System.out.println(pom);
//            System.out.println();

            tabSout[i]=new BigInteger(pom);

        }
//        for(int i=0;i<8;i++){
//            System.out.println(tabSout[i].toString(10));
//        }

        //lacze 8 4-bitowych wyrazow w jeden wyraz
        BigInteger tabsJoined = new BigInteger("0");
        for(int i =0;i<32;i++){
            if(tabSout[(i/4)].testBit(i%4)){
                tabsJoined=tabsJoined.setBit(i);
            }
        }
//        System.out.println(tabsJoined.toString(2));

        BigInteger finalRes = new BigInteger("0");
        //ostatnia permutacja na tablicy tabP
        for(int i=0; i<32; i++){
            if (tabsJoined.testBit((tabP[i] - 1))) {
                finalRes = finalRes.setBit(31-i);
            } else {
                finalRes = finalRes.clearBit(31-i);
            }
        }
//        System.out.println(finalRes.toString(2));
        return finalRes;
    }

    public static BigInteger encrypt(BigInteger word, List<BigInteger> keys){
        BigInteger a = new BigInteger("0");
        // permutacja na tablicy IP
//        System.out.println(word.toString(2));
        for(int i=0;i<64;i++){
            if(word.testBit(tabIp[i]-1)){
                a=a.setBit(63-i);
            }else{
                a=a.clearBit(63-i);
            }
        }
//        System.out.println(a.toString(2));
        BigInteger l = new BigInteger("0");
        BigInteger r = new BigInteger("0");
        BigInteger pom = new BigInteger("0");
        // dziele bit na 2 32-bitowe czesci lewa i prawa (l i r)
        l = a.shiftRight(32);
        pom = l.shiftLeft(32);
        r = a.xor(pom);
//        System.out.println(l.toString(2));
//        System.out.println(r.toString(2));
//        System.out.println(pom.toString(2));
        for(int i=0; i<16;i++){
            BigInteger pom2 = new BigInteger("0");
            //funkcja f i lewa czesc staje sie prawa z poprzedniej kolejki, a prawa to xor lewej czesci z wynikiem funkcji f
            pom2=cipherFunction(r, keys.get(i));
            pom=r;
            r=l.xor(pom2);
            l=pom;
//            System.out.println(l);
//            System.out.println(r);
//            System.out.println(pom2);
        }
        // ostatnia permutacja powinna byc bez zamiany, wiec zamieniam lewa z prawa xD
        BigInteger pom3 = new BigInteger("0");
        BigInteger pom4 = new BigInteger("0");
        pom3=l;
        l=r;
        r=pom3;
        //lacze 2 czesci
        l=l.shiftLeft(32);
        pom4=l.xor(r);
        BigInteger finalRes = new BigInteger("0");
        //ostatnia permutacja na tablicy IP2
        for(int i=0; i<64; i++){
            if(pom4.testBit(tabIp2[i]-1)){
                finalRes = finalRes.setBit(63-i);
            }else{
                finalRes = finalRes.clearBit(63-i);
            }
        }
        System.out.println(finalRes.toString(16));
        return finalRes;
    }
}
