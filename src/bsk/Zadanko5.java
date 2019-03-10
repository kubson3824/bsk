package bsk;

import java.io.*;
import java.util.Scanner;

public class Zadanko5 {

    public static String encode(String word, String key) {
        StringBuilder output = new StringBuilder();
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < word.length(); i++) {
            output.append(alfabet.charAt((alfabet.indexOf(word.charAt(i)) + alfabet.indexOf(key.charAt(i % key.length()))) % alfabet.length()));
            System.out.println(output.toString());
        }
        return output.toString();
    }

    public static String decode(String code, String key) {
        StringBuilder output = new StringBuilder();
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < code.length(); i++) {
            output.append(alfabet.charAt(Math.floorMod(alfabet.indexOf(code.charAt(i)) - alfabet.indexOf(key.charAt(i % key.length())), alfabet.length())));
        }
        return output.toString();
    }

    public static void saveToFile(){
        String key="";
        String inputString="";
        String outputString="";

        File inputFile = new File("src/bsk/results/In05.txt");
        File outputFile = new File("src/bsk/results/Out05.txt");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key=bufferedReader.readLine();
            inputString=bufferedReader.readLine();
        } catch (
                FileNotFoundException e) {
            System.out.println("Error with file: "+ e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Error with file: "+ e.getMessage());
        }

        outputString=encode(inputString, key);

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

        File inputFile = new File("src/bsk/results/In05Decode.txt");
        File outputFile = new File("src/bsk/results/Out05Decode.txt");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key=bufferedReader.readLine();
            inputString=bufferedReader.readLine();
        } catch (
                FileNotFoundException e) {
            System.out.println("Error with file: "+ e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Error with file: "+ e.getMessage());
        }

        outputString=decode(inputString, key);

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
