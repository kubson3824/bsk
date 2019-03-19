package bsk;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Zadanko4 {

    public static String encode(String inputString, Integer key0, Integer key1) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            int temp1 = alfabet.indexOf(inputString.charAt(i));
            result.append(alfabet.charAt((temp1 * key1 + key0) % alfabet.length()));
        }

        return result.toString();
    }

    public static String decode(String inputString, Integer key0, Integer key1) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String outputString = new String();
        int n = alfabet.length();
        int fi_n = 12;
        BigInteger keyOne = BigInteger.valueOf(key1);
        for (int i = 0; i < inputString.length(); i++) {
            int temp1 = alfabet.indexOf(inputString.charAt(i));
            BigInteger first_part =BigInteger.valueOf(temp1 + n - key0);
            BigInteger second_part =  keyOne.pow( fi_n - 1);
            BigInteger result = first_part.multiply(second_part).mod(BigInteger.valueOf(n));
            outputString += alfabet.charAt(Integer.valueOf(result.toString()));
        }
        return outputString;
    }

    public static void saveToFile() {
        Integer key0 = 0;
        Integer key1 = 0;
        String inputString = "";
        String outputString = "";

        File inputFile = new File("src/bsk/results/In04.txt");
        File outputFile = new File("src/bsk/results/Out04.txt");

        BufferedReader bufferedReader = null;
        try {
            Scanner scanner = new Scanner(inputFile);
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key0 = scanner.nextInt();
            key1 = scanner.nextInt();
            inputString = bufferedReader.readLine();
            inputString = bufferedReader.readLine();
        } catch (
                FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }

        outputString = encode(inputString, key0, key1);

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
        Integer key0 = 0;
        Integer key1 = 0;
        String inputString = "";
        String outputString = "";

        File inputFile = new File("src/bsk/results/In04Decode.txt");
        File outputFile = new File("src/bsk/results/Out04Decode.txt");

        BufferedReader bufferedReader = null;
        try {
            Scanner scanner = new Scanner(inputFile);
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            key0 = scanner.nextInt();
            key1 = scanner.nextInt();
            inputString = bufferedReader.readLine();
            inputString = bufferedReader.readLine();
        } catch (
                FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }

        outputString = decode(inputString, key0, key1);

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
