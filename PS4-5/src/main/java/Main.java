import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Boolean[]> booleans = Zad1.zad1(new Boolean[]{true, false, true}, new Boolean[]{true, false, false}, 20);//wielomiax x3 + x1 +1 , seed = 100
        for (Boolean[] aBoolean : booleans) {
            for (Boolean aBoolean1 : aBoolean) {
                System.out.print(aBoolean1 + " ");
            }
            System.out.println();
        }
        return;
    }
}
