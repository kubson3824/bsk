package bsk;

public class Zadanko5 {

    public static String encode(String word, String key) {
        StringBuilder output = new StringBuilder();
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < word.length(); i++) {
            output.append(alfabet.charAt((alfabet.indexOf(word.charAt(i)) + alfabet.indexOf(key.charAt(i))) % alfabet.length()));
        }
        return output.toString();
    }

    public static String decode(String code, String key) {
        StringBuilder output = new StringBuilder();
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < code.length(); i++) {
            output.append(alfabet.charAt(Math.floorMod(alfabet.indexOf(code.charAt(i)) - alfabet.indexOf(key.charAt(i)), alfabet.length())));
        }
        return output.toString();
    }
}
