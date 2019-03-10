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
        for (int i = 0; i <= (inputString.length()/key.size() + 1)*key.size(); i++) {
            if ((i / key.size()) * key.size() + key.get(i % key.size()) >= inputString.length()) {
                continue;
            }
            outputString += inputString.charAt((i / key.size()) * key.size() + key.get(i % key.size()));
        }
        return outputString;
    }

    public static String decode(String inputString, String keyString){
        List<Integer> key = stringToArray(keyString);
        String outputString = new String();
        for (int i=0; i<(inputString.length()/key.size() + 1)*key.size();i++){
            outputString+='*';
        }
        for (int i = 0; i < inputString.length(); i++) {
            if(key.get(i % key.size()) + (i / key.size()) * key.size()<outputString.length()) {
                outputString = customReplace(outputString, key.get(i % key.size()) + (i / key.size()) * key.size(), inputString.charAt(i));
                System.out.println(outputString);
            }
        }
        System.out.println(outputString);
        return outputString;
    }

    public static String customReplace(String word, int position, char letterToReplace){
        String wordReplaced = word.substring(0,position) + letterToReplace + word.substring(position + 1);
        return wordReplaced;
    }

    public static void saveToFile(){
        String key="";
        String inputString="";
        String outputString="";
//        List<Integer> keys = new ArrayList<>();

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

//        keys= stringToArray(key);
        outputString = encode(inputString, key);

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
    public static void saveDecodeToFile(){
        String key="";
        String inputString="";
        String outputString="";

        File inputFile = new File("src/bsk/results/In02Decode.txt");
        File outputFile = new File("src/bsk/results/Out02Decode.txt");

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
        outputString = decode(inputString, key);

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
