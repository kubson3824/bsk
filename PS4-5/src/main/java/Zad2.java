import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zad2 {

    public static Boolean[] zad2_szyfruj(Boolean[] wielomian, Boolean[] seed, Boolean[] message) {
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


        for (int i = 0; i < message.length; i++) {
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

        Boolean[] zaszyfrowana = new Boolean[message.length];

        for (int i = 0; i < message.length; i++) {
            int jedynki = 0;
            if (wynik.get(i)[0]) jedynki++;
            if (message[i]) jedynki++;
            zaszyfrowana[i] = (jedynki % 2) == 1;
        }


        return zaszyfrowana;
    }


//    public static Boolean[] zad2_deszyfruj(Boolean[] wielomian, Boolean[] seed, Boolean[] message) {
//        List<Boolean[]> wynik = new ArrayList<>();
//
//        Boolean[] pierwszy = new Boolean[seed.length];
//        int liczba_jedynek = 0;
//        for (int i = 0; i < seed.length; i++)
//            if (wielomian[i])
//                if (seed[i])
//                    liczba_jedynek++;
//
//
//        for (int i = 0; i < seed.length - 1; i++) {
//            pierwszy[i + 1] = seed[i];
//        }
//        pierwszy[0] = (liczba_jedynek % 2) == 1;
//        liczba_jedynek = 0;
//        wynik.add(pierwszy);
//
//
//        for (int i = 0; i < message.length; i++) {
//            Boolean[] tab = new Boolean[seed.length];
//            for (int j = 0; j < seed.length; j++)
//                if (wielomian[j])
//                    if (wynik.get(i)[j])
//                        liczba_jedynek++;
//
//            for (int j = 0; j < seed.length - 1; j++) {
//                tab[j + 1] = wynik.get(i)[j];
//            }
//            tab[0] = (liczba_jedynek % 2) == 1;
//            liczba_jedynek = 0;
//            wynik.add(tab);
//        }
//
//        Boolean[] zdeszyfrowana = new Boolean[message.length];
//        for (int i = 0; i < message.length; i++) {
//            int jedynki = 0;
//            if (wynik.get(i)[0]) jedynki++;
//            if (message[i]) jedynki++;
//            zdeszyfrowana[i] = (jedynki % 2) == 1;
//        }
//
//        return zdeszyfrowana;
//    }

    static void saveToFile() {
        Boolean[] message;
        Boolean[] wielomian;
        Boolean[] seed;
        Boolean[] wynik = null;
        File inputFile = new File("src/In02.txt");
        File outputFile = new File("src/Out02.bin");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            wielomian = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            seed = BinaryFileHandler.stringToBoolean(bufferedReader.readLine());
            message = BinaryFileHandler.readFile(bufferedReader.readLine());
            wynik = zad2_szyfruj(wielomian, seed, message);
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
        try {
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
            outputStream.write(BinaryFileHandler.booleanToByte(wynik));
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }
    }
}
