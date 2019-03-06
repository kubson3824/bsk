package bsk;

public class Zadanko4 {

    public static String encode(String inputString, Integer offset) {
        Integer n = 26;
        String result = new String();
        for (int i = 0; i < inputString.length(); i++) {
            if ((char) (inputString.charAt(i) + offset) > 'Z') {
                result += (char) (inputString.charAt(i) + offset + -26);
            } else {
                result += (char) (inputString.charAt(i) + offset);
            }
        }
        return result;
    }
}
