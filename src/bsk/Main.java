package bsk;

public class Main {

    public static void main(String[] args) {

        Zadanko4.saveToFile();
        System.out.println(Zadanko4.decode("YHKGQLGMJFNXBMLRLQXYZCKQXSXBSLRHP", 7, 17));

        System.out.println(Zadanko2.encode("TOP_SECRET_MESSAGE", "3-4-1-5-2"));

    }
}
