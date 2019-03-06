package bsk;

public class Main {

    public static void main(String[] args) {

//        String inputString = "CRYPTOGRAPHY";
//        String key = "CONVENIENCE";

        String inputString = "CRYPTOGRAPHY";
        String key = "BREAKBREAKBR";

        String outputString;
        outputString = Zadanko5.encode(inputString, key);

        System.out.println(outputString);

    }


}
