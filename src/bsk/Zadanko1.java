package bsk;

import java.io.*;
import java.util.Scanner;

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

    public static void saveToFile(){
        int n=0;
        String inputString="";
        String outputString="";

        File inputFile = new File("src/bsk/results/In01.txt");
        File outputFile = new File("src/bsk/results/Out01.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            n = scanner.nextInt();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            inputString = bufferedReader.readLine();
            inputString=bufferedReader.readLine();
            outputString=Zadanko1.encode(inputString,n);
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: "+ e.getMessage());
        }
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
