import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boolean[] wielomian = new Boolean[]{false, false, false, true, true};
        Boolean[] seed = new Boolean[]{true, true, true, false, false};
        Boolean[] message = new Boolean[]{true, false, true, true};
        List<Boolean[]> messages = BinaryFileHandler.readFile("PS4-5/test.bin");


//        List<Boolean[]> booleans = Zad1.zad1(wielomian, seed, 16);//wielomiax x3 + x1 +1 , seed = 100
//        for (Boolean[] aBoolean : booleans) {
//            for (Boolean aBoolean1 : aBoolean) {
//                System.out.print(aBoolean1 ? "1" : "0");
//            }
//            System.out.println();
//        }

//        Boolean[] zad2_szyfruj = Zad2.zad2_szyfruj(wielomian, seed, message);
//        for (Boolean aBoolean : zad2_szyfruj) {
//            System.out.print(aBoolean? "1" : "0");
//        }
//        System.out.println();

//        Boolean[] zad2_deszyfruj = Zad2.zad2_deszyfruj(wielomian, seed, zad2_szyfruj);
//        for (Boolean aBoolean : zad2_deszyfruj) {
//            System.out.print(aBoolean? "1" : "0");
//        }
//        Boolean[] zad3_szyfruj = Zad3.zad3_szyfruj(wielomian, seed, message);
//        for (Boolean aBoolean : zad3_szyfruj) {
//            System.out.print(aBoolean? "1" : "0");
//        }
//        System.out.println();
//
//        Boolean[] zad3_deszyfruj = Zad3.zad3_deszyfruj(wielomian, seed, zad3_szyfruj);
//        for (Boolean aBoolean : zad3_deszyfruj) {
//            System.out.print(aBoolean ? "1" : "0");
//        }
//        System.out.println();

        return;
    }
}
