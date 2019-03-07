package bsk;

public class Zadanko4 {

    public static String encode(String inputString, Integer key0, Integer key1) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            int temp1 = alfabet.indexOf(inputString.charAt(i)) + 1;
            result.append(alfabet.charAt((temp1 * key1 + key0) % alfabet.length()));
        }

        return result.toString();
    }
}
