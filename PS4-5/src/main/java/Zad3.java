import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zad3 {

    public static Boolean[] zad3_szyfruj(Boolean[] wielomian, Boolean[] seed, Boolean[] message) {
        List<Boolean[]> wynik = new ArrayList<>();

        Boolean[] pierwszy = new Boolean[seed.length];
        int liczba_jedynek = 0;
        for (int i = 0; i < seed.length; i++)
            if (wielomian[i])
                if (seed[i])
                    liczba_jedynek++;


        for (int i = 0; i < seed.length - 1; i++) {
            pierwszy[i + 1] = seed[i];
        }
        if (message[0]) liczba_jedynek++;
        pierwszy[0] = (liczba_jedynek % 2) == 1;
        liczba_jedynek = 0;
        wynik.add(pierwszy);
//        System.out.println(pierwszy[0] + " " + pierwszy[1] + " " + pierwszy[2]);
//        System.out.println();
        for (int i = 0; i < message.length; i++) {
            Boolean[] tab = new Boolean[seed.length];
            for (int j = 0; j < seed.length; j++)
                if (wielomian[j])
                    if (wynik.get(i)[j])
                        liczba_jedynek++;

            for (int j = 0; j < seed.length - 1; j++) {
                tab[j + 1] = wynik.get(i)[j];
            }
            if (i != message.length - 1)
                if (message[i + 1]) liczba_jedynek++;
            tab[0] = (liczba_jedynek % 2) == 1;
            liczba_jedynek = 0;
            wynik.add(tab);
//            System.out.println(tab[0] + " " + tab[1] + " " + tab[2]);
        }

        Boolean[] zaszyfrowana = new Boolean[message.length];

        for (int i = 0; i < message.length; i++) {
            zaszyfrowana[i] = wynik.get(i)[0];
        }


        return zaszyfrowana;
    }

    public static Boolean[] zad3_deszyfruj(Boolean[] wielomian, Boolean[] seed, Boolean[] message) {
        List<Boolean[]> wynik = new ArrayList<>();

        Boolean[] pierwszy = new Boolean[seed.length];
        pierwszy[0] = message[0];
        for (int i = 0; i < seed.length - 1; i++) {
            pierwszy[i + 1] = seed[i];
        }
        wynik.add(pierwszy);

        for (int i = 0; i < message.length - 2; i++) {
            Boolean[] tab = new Boolean[seed.length];
            for (int j = 0; j < seed.length - 1; j++)
                tab[j + 1] = wynik.get(i)[j];

            if (i != message.length - 1)
                tab[0] = message[i + 1];

            wynik.add(tab);
        }
        wynik.add(0, seed);

        Boolean[] zdeszyfrowana = new Boolean[message.length];
        for (int i = 0; i < message.length; i++) {
            int liczba_jedynek = 0;
            for (int j = 0; j < seed.length; j++)
                if (wielomian[j])
                    if (wynik.get(i)[j])
                        liczba_jedynek++;
            if (message[i]) liczba_jedynek++;
            zdeszyfrowana[i] = (liczba_jedynek % 2) == 1;

        }


        return zdeszyfrowana;
    }

    static void saveToFileEncode() {
        Boolean[] message = new Boolean[0];
        Boolean[] wielomian;
        Boolean[] seed;
        Boolean[] wynik = null;
        int numer;
        File inputFile = new File("PS4-5/src/In03.txt");
        File outputFile = new File("PS4-5/src/Out03.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            wielomian = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            seed = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            numer = Integer.parseInt(bufferedReader.readLine());
            message = BinaryFileHandler.readFile(bufferedReader.readLine()).get(numer);
            wynik = zad3_szyfruj(wielomian, seed, message);
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write("Message: " + BinaryFileHandler.booleanToString(message) + "\n");
            fileWriter.write("Result: " + BinaryFileHandler.booleanToString(wynik));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
    }

    static void saveToFileDecode() {
        Boolean[] message = new Boolean[0];
        Boolean[] wielomian;
        Boolean[] seed;
        Boolean[] wynik = null;
        File inputFile = new File("PS4-5/src/In03Decode.txt");
        File outputFile = new File("PS4-5/src/Out03Decode.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            wielomian = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            seed = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            message = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            wynik = zad3_deszyfruj(wielomian, seed, message);
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write("Message: " + BinaryFileHandler.booleanToString(message) + "\n");
            fileWriter.write("Result: " + BinaryFileHandler.booleanToString(wynik));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
    }

}
