package bsk;

public class Main {

    public static void main(String[] args) {

        String inputString = "HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION";
        String key = "CONVENIENCE";

        String outputString;
        outputString = Zadanko3.encode(inputString, key);

        System.out.println(outputString);

    }


}
