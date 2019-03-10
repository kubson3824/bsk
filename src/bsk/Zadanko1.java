package bsk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
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

    public static String decode(String inputString, int n){
        StringBuilder outputString = new StringBuilder();

        char matrix[][] = new char[n][inputString.length()];
        for(int i=0;i<n;i++){
            for(int j=0; j<inputString.length(); j++){
                matrix[i][j]='~';
            }
        }

        //kierunek; dla true w dol, dla false w gore
        boolean direction=true;
        int i=0;
        int j=0;
        while(j<inputString.length()){
            if(direction){
                if(i<n-1){
                    matrix[i][j]='@';
                    i++;
                    j++;
                }else if(i==n-1){
                    matrix[i][j]='@';
                    direction=false;
                    i--;
                    j++;
                }
            }else if(!direction){
                if(i>0){
                    matrix[i][j]='@';
                    i--;
                    j++;
                }else if(i==0){
                    matrix[i][j]='@';
                    direction=true;
                    i++;
                    j++;
                }
            }
        }
        int size=0;
        for(int k=0;k<n;k++){
            for(int l=0; l<inputString.length(); l++){
                if(matrix[k][l]=='@'){
                    matrix[k][l]=inputString.charAt(size);
                    size++;
                }
            }
        }
        for(int k=0;k<n;k++){
            for(int l=0; l<inputString.length(); l++){
                System.out.print(matrix[k][l]+", ");
            }
            System.out.println();
        }
        for(int k=0;k<inputString.length();k++){
            for(int l=0; l<n; l++){
                if(matrix[l][k]!='~') {
                    outputString.append(matrix[l][k]);
                    }
                }
            }
        System.out.println(outputString);
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

    public static void saveDecodeToFile(){
        int n=0;
        String inputString="";
        String outputString="";

        File inputFile = new File("src/bsk/results/In01Decode.txt");
        File outputFile = new File("src/bsk/results/Out01Decode.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            n = scanner.nextInt();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            inputString = bufferedReader.readLine();
            inputString=bufferedReader.readLine();
            outputString=Zadanko1.decode(inputString,n);
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
