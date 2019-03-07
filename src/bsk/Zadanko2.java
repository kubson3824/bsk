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

    public static void saveToFile(){
        String key="";
        String inputString="";
        String outputString="";
        List<Integer> keys = new ArrayList<>();

        File inputFile = new File("src/bsk/results/In02.txt");
        File outputFile = new File("src/bsk/results/Out02.txt");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key = bufferedReader.readLine();
            inputString=bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: "+ e.getMessage());
        }

        keys= stringToArray(key);
        outputString=encode(inputString,keys);

        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(outputString);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: "+ e.getMessage());
        }
    }
}
