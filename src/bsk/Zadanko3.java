package bsk;


import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Zadanko3 {

    public static String encode2B(String inputString, String key) {
        StringBuilder outputString = new StringBuilder();
        Map<Integer, Integer> code = sequenceFromKey(key);
        for (int i = 0; i < code.size(); i++) {
            for (int j = 0; i + (j * code.size()) < inputString.length(); j++) {
                if (code.get(i) + j * code.size() >= inputString.length()) {
                    continue;
                }
                outputString.append(inputString.charAt(code.get(i) + (j * code.size())));
            }
        }
        return outputString.toString();
    }

    private static Map<Integer, Integer> sequenceFromKey(String key) {
        char[] keyArray = key.toCharArray();
        Boolean[] map = new Boolean[key.length()];
        for (int i = 0; i < map.length; i++) {
            map[i] = false;
        }
        Map<Integer, Integer> result = new HashMap<>();
        char temp;
        for (int i = 0; i < key.length(); i++) {
            int min = i;
            for (int j = i; j < key.length(); j++) {
                if (keyArray[min] > keyArray[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = keyArray[i];
                keyArray[i] = keyArray[min];
                keyArray[min] = temp;
            }
        }
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.toCharArray()[i] == keyArray[j] && !map[j]) {
                    result.put(j, i);
                    map[j] = true;
                    break;
                }
            }
        }
        return result;
    }

    public static String encode2C(String inputString, String key) {
        String outputString = new String();
        Map<Integer, Integer> code = sequenceFromKey(key);


        Integer liczba_znakow_w_bloku = ((1 + key.length()) * key.length()) / 2;
        Integer liczba_blokow = inputString.length() / liczba_znakow_w_bloku + 1;

        Boolean[][] blok_przykladowy = new Boolean[key.length()][key.length()];
        for (int i = 0; i < blok_przykladowy.length; i++) {
            for (int j = 0; j < blok_przykladowy.length; j++) {
                blok_przykladowy[i][j] = false;
            }
        }
        for (int i = 0; i < blok_przykladowy.length; i++) {
            for (int j = 0; j <= code.get(i); j++) {
                blok_przykladowy[i][j] = true;
            }
        }


        List<Character[][]> bloki_znakow = new LinkedList<>();
        for (int i = 0; i < liczba_blokow; i++)
            bloki_znakow.add(new Character[key.length()][key.length()]);

        int pozycja_w_napisie = 0;
        for (Character[][] blok : bloki_znakow) {
            for (int i = 0; i < blok_przykladowy.length; i++) {
                for (int j = 0; j < blok_przykladowy.length; j++) {
                    if (pozycja_w_napisie >= inputString.length()) break;
                    if (blok_przykladowy[i][j] == true) {
                        blok[i][j] = inputString.charAt(pozycja_w_napisie);
                        pozycja_w_napisie++;
                    }
                }
            }
        }


        pozycja_w_napisie = 0;
        for (Character[][] blok : bloki_znakow) {
            for (int i = 0; i < code.size(); i++) {
                int kolumna = code.get(i);
                for (int j = 0; j < blok_przykladowy.length; j++) {
                    if (blok_przykladowy[j][kolumna]) {
                        if (blok[j][kolumna] == null) continue;
                        outputString += blok[j][kolumna];
                        pozycja_w_napisie++;
                    }
                }
            }
        }


        return outputString;
    }

    public static String decode2C(String inputString, String key) {
        String outputString = new String();
        Map<Integer, Integer> code = sequenceFromKey(key);

        Integer liczba_znakow_w_bloku = ((1 + key.length()) * key.length()) / 2;
        Integer liczba_blokow = inputString.length() / liczba_znakow_w_bloku + 1;
        Integer liczba_znakow = inputString.length();
        Integer liczba_znakow_w_ostatnim_bloku = inputString.length() % liczba_znakow_w_bloku;

        Boolean[][] blok_przykladowy = new Boolean[key.length()][key.length()];
        for (int i = 0; i < blok_przykladowy.length; i++) {
            for (int j = 0; j < blok_przykladowy.length; j++) {
                blok_przykladowy[i][j] = false;
            }
        }
        int liczba_uzytych_znakow = 0;
        for (int i = 0; i < blok_przykladowy.length; i++) {
            for (int j = 0; j <= code.get(i); j++) {
                if (liczba_uzytych_znakow >= liczba_znakow) break;
                blok_przykladowy[i][j] = true;
                liczba_uzytych_znakow++;
            }
        }
        Boolean[][] ostatni_blok_przykladowy = new Boolean[key.length()][key.length()];
        for (int i = 0; i < ostatni_blok_przykladowy.length; i++) {
            for (int j = 0; j < ostatni_blok_przykladowy.length; j++) {
                ostatni_blok_przykladowy[i][j] = false;
            }
        }

        if (liczba_blokow > 1) {
            int liczba_uzytych_znakow_w_ostatnim_bloku = 0;
            for (int i = 0; i < blok_przykladowy.length; i++) {
                for (int j = 0; j <= code.get(i); j++) {
                    if (liczba_uzytych_znakow_w_ostatnim_bloku >= liczba_znakow_w_ostatnim_bloku) break;
                    ostatni_blok_przykladowy[i][j] = true;
                    liczba_uzytych_znakow_w_ostatnim_bloku++;
                }
            }
        }

        List<Character[][]> bloki_znakow = new LinkedList<>();
        for (int i = 0; i < liczba_blokow; i++)
            bloki_znakow.add(new Character[key.length()][key.length()]);


        int pozycja_w_napisie = 0;
        for (Character[][] blok : bloki_znakow) {

            if (blok == bloki_znakow.get(bloki_znakow.size() - 1) && liczba_blokow > 1) {
                for (int i = 0; i < blok_przykladowy.length; i++) {
                    int kolumna = code.get(i);
                    for (int j = 0; j < blok_przykladowy.length; j++) {
                        if (pozycja_w_napisie >= inputString.length()) break;
                        if (ostatni_blok_przykladowy[j][kolumna] == true) {
                            blok[j][kolumna] = inputString.charAt(pozycja_w_napisie);
                            pozycja_w_napisie++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < blok_przykladowy.length; i++) {
                    int kolumna = code.get(i);
                    for (int j = 0; j < blok_przykladowy.length; j++) {
                        if (pozycja_w_napisie >= inputString.length()) break;
                        if (blok_przykladowy[j][kolumna] == true) {
                            blok[j][kolumna] = inputString.charAt(pozycja_w_napisie);
                            pozycja_w_napisie++;
                        }
                    }
                }
            }
        }

        for (Character[][] blok : bloki_znakow) {
            for (int i = 0; i < blok_przykladowy.length; i++) {
                for (int j = 0; j < blok_przykladowy.length; j++) {
                    if (blok[i][j] != null) outputString += blok[i][j];
                }
            }
        }

        return outputString;
    }

    public static void saveToFile() {
        String key = "";
        String inputString = "";
        String outputString = "";
        String outputString2 = "";

        File inputFile = new File("src/bsk/results/In03.txt");
        File outputFile = new File("src/bsk/results/Out03.txt");
        File outputFile2 = new File("src/bsk/results/Out03v2.txt");

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
        outputString = encode2B(inputString, key);
        outputString2 = encode2C(inputString, key);

        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            FileWriter fileWriter2 = new FileWriter(outputFile2);
            fileWriter.write(outputString);
            fileWriter2.write(outputString2);
            fileWriter.close();
            fileWriter2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error with file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }

    }

}
