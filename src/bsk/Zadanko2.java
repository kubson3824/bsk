package bsk;

import java.io.*;
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

    public static String encode(String inputString, String keyString) {
        List<Integer> key = stringToArray(keyString);
        String outputString = new String();
        for (int i = 0; i <= (inputString.length() / key.size() + 1) * key.size(); i++) {
            if ((i / key.size()) * key.size() + key.get(i % key.size()) >= inputString.length()) {
                continue;
            }
            outputString += inputString.charAt((i / key.size()) * key.size() + key.get(i % key.size()));
        }
        return outputString;
    }

    public static String decode(String inputString, String keyString) {
        List<Integer> key = stringToArray(keyString);
        StringBuilder outputString = new StringBuilder();
        Character[] characters = new Character[((inputString.length() / key.size()) + 1) * key.size()];

        int i = 0;
        int z = 0;
        while (i < inputString.length()) {
            for (Integer index : key) {
                if (inputString.length() > index + z) {
                    characters[index + z] = inputString.charAt(i);
                    i++;
                }
            }
            z += key.size();
        }
        for (int j = 0; j < characters.length; j++) {
            if (characters[j] == null) continue;
            outputString.append(characters[j]);
        }
        return outputString.toString();
    }

    public static void saveToFile() {
        String key = "";
        String inputString = "";
        String outputString = "";
//        List<Integer> keys = new ArrayList<>();

        File inputFile = new File("src/bsk/results/In02.txt");
        File outputFile = new File("src/bsk/results/Out02.txt");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key = bufferedReader.readLine();
            inputString = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }

//        keys= stringToArray(key);
        outputString = encode(inputString, key);

        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(outputString);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
    }

    public static void saveDecodeToFile() {
        String key = "";
        String inputString = "";
        String outputString = "";

        File inputFile = new File("src/bsk/results/In02Decode.txt");
        File outputFile = new File("src/bsk/results/Out02Decode.txt");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key = bufferedReader.readLine();
            inputString = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
        outputString = decode(inputString, key);

        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(outputString);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
    }
}
