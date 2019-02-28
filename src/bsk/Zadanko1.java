package bsk;

public class Zadanko1 {
    public static String encode(String inputString, int n) {
        StringBuilder outputString = new StringBuilder();

        for (int i = 0; 2 * (n - 1) * i < inputString.length(); i++) {
            outputString.append(inputString.charAt(2 * (n - 1) * i));
        }

        for (int k = 1; k < n - 1; k++) {
            for (int i = 0; 2 * (n - 1) * i - k < inputString.length(); i++) {
                if (2 * (n - 1) * i - k > 0 && 2 * (n - 1) * i - k < inputString.length()) {
                    outputString.append(inputString.charAt(2 * (n - 1) * i - k));
                }
                if (2 * (n - 1) * i + k < inputString.length() && 2 * (n - 1) * i + k > 0) {
                    outputString.append(inputString.charAt(2 * (n - 1) * i + k));
                }
            }
        }
        for (int i = 0; 2 * (n - 1) * i + n - 1 < inputString.length(); i++) {
            outputString.append(inputString.charAt(2 * (n - 1) * i + n - 1));
        }
        return outputString.toString();
    }
}
