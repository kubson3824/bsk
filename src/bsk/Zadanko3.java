package bsk;


import java.util.HashMap;
import java.util.Map;

public class Zadanko3 {

    public static String encode(String inputString, String key) {
        String outputString = new String();
        Map<Integer, Integer> code = sequenceFromKey(key);
        for (int i = 0; i < code.size(); i++) {
            for (int j = 0; i + (j * code.size()) < inputString.length(); j++) {
                outputString += inputString.charAt(code.get(i) + (j * code.size()));
            }
            outputString += " ";
        }
        return outputString;
    }

    private static Map<Integer, Integer> sequenceFromKey(String key) {
        char[] keyArray = key.toCharArray();
        Boolean[] map = new Boolean[key.length()];
        for (int i = 0; i < map.length; i++) {
            map[i] = false;
        }
        Map<Integer, Integer> result = new HashMap<>();
        char temp;
        for (int i = 0; i < key.length(); i++) {
            int min = i;
            for (int j = i; j < key.length(); j++) {
                if (keyArray[min] > keyArray[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = keyArray[i];
                keyArray[i] = keyArray[min];
                keyArray[min] = temp;
            }
        }
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.toCharArray()[i] == keyArray[j] && !map[j]) {
                    result.put(j, i);
                    map[j] = true;
                    break;
                }
            }
        }
        return result;
    }
}
