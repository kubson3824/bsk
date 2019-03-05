package bsk;

public class Main {

    public static void main(String[] args) {

//        String inputString = "CRYPTOGRAPHY";
//        String key = "CONVENIENCE";

        String inputString = "ALA_MA_KOTA";
        String key = "ALA";

        String outputString;
        outputString = Zadanko3.encode2B(inputString, key);

        System.out.println(outputString);

    }


}
