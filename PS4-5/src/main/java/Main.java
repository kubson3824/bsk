import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Boolean[]> booleans = Zad1.zad1(new Boolean[]{true, false, true}, new Boolean[]{true, false, false}, 20);//wielomiax x3 + x1 +1 , seed = 100
//        for (Boolean[] aBoolean : booleans) {
//            for (Boolean aBoolean1 : aBoolean) {
//                System.out.print(aBoolean1 + " ");
//            }
//            System.out.println();
//        }

        Boolean[] zad2_szyfruj = Zad2.zad2_szyfruj(new Boolean[]{true, false, true}, new Boolean[]{true, false, false}, new Boolean[]{true, false, false, false});
        for (Boolean aBoolean : zad2_szyfruj) {
            System.out.print(aBoolean + " ");
        }
        System.out.println();

        Boolean[] zad2_deszyfruj = Zad2.zad2_deszyfruj(new Boolean[]{true, false, true}, new Boolean[]{true, false, false}, zad2_szyfruj);
        for (Boolean aBoolean : zad2_deszyfruj) {
            System.out.print(aBoolean + " ");
        }

        return;
    }
}
