import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Zad1 {

    private static List<Boolean[]> zad1(Boolean[] wielomian, Boolean[] seed, Integer n) {
        //wielomian true false true, seed true false false
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
        pierwszy[0] = (liczba_jedynek % 2) == 1;
        liczba_jedynek = 0;
        wynik.add(pierwszy);


        for (int i = 0; i < n - 1; i++) {
            Boolean[] tab = new Boolean[seed.length];
            for (int j = 0; j < seed.length; j++)
                if (wielomian[j])
                    if (wynik.get(i)[j])
                        liczba_jedynek++;

            for (int j = 0; j < seed.length - 1; j++) {
                tab[j + 1] = wynik.get(i)[j];
            }
            tab[0] = (liczba_jedynek % 2) == 1;
            liczba_jedynek = 0;
            wynik.add(tab);
        }

        return wynik;
    }

    static void saveToFile() {
        int n;
        Boolean[] wielomian;
        Boolean[] seed;
        List<Boolean[]> wynik = null;
        File inputFile = new File("src/In01.txt");
        File outputFile = new File("src/Out01.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            n = Integer.parseInt(bufferedReader.readLine());
            wielomian = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            seed = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            wynik = zad1(wielomian, seed, n);
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for (Boolean[] booleans : wynik) {
                fileWriter.write(BinaryFileHandler.booleanToString(booleans));
                fileWriter.write('\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
    }

}
