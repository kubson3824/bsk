package bsk;

import java.util.ArrayList;
import java.util.List;

public class Zadanko2 {

    public static List<Integer> stringToArray(String keyString) {
        String[] array = keyString.split("-");
        List<Integer> result = new ArrayList<>();
        for (String s : array) {
            result.add(Integer.parseInt(s) - 1);
        }
        return result;
    }

    public static String encode(String inputString, List<Integer> key) {
        String outputString = new String();
        for (int i = 0; i <= inputString.length(); i++) {
            if ((i / key.size()) * key.size() + key.get(i % key.size()) >= inputString.length()) {
                continue;
            }
            outputString += inputString.charAt((i / key.size()) * key.size() + key.get(i % key.size()));
        }
        return outputString;
    }
}
