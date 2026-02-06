import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  Scans through a .txt file and extracts words that can be split into two sub-words
 *  Creates an ArrayList of all possible SubWords and prints them in the console
 *  Also creates an ArrayList of all possible Sub3Words -- which are words that can be split
 *  into 3 sub-words and prints them in console as well
 *  @version 02.05.2026
 *  @ author mradhakrishnan
 *  Flint session: https://app.flintk12.com/activities/algorithm-helpe-1ae606/sessions/df4be1a9-fd3b-4c67-bc62-363ada6042da
 */
public class SubWordFinder implements WordFinder {
    //private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String alpha = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<ArrayList<String>> dictionary;

    /**
     * Constructs a SubWordFinder Object
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<>());
        }
        populateDictionary();
    }

    /**
     * opens scrabble file
     * iterates & reads though all lines in the file SCRABBLE_WORDS (1).txt
     * store word in its appropriate bucket in dictionary
     * Sorts each array in dictionary lexicographically
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("new_scrabble.txt"));
            while (in.hasNextLine()) {
                String temp = in.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (ArrayList<String> words : dictionary)
            Collections.sort(words);
    }

    /**
     * Gets all SubWord objects that can be pulled from this dictionary
     *
     * @return an ArrayList of all SubWords
     */
    public ArrayList<SubWord> getSubWords() {
        // iterate through all words in dictionary
        // split each word min 2-letters in front + remainder
        // split remainder + 2-letters in back
        // with EVERY split, call inDictionary
        // aardvark: aa-rdvark, aar-dvark, aard-vark, aardv-ark, aardva-rk
        // add a new SubWord object to an ArrayList to return if found
        ArrayList<SubWord> results = new ArrayList<>();
        for (ArrayList<String> buckets : dictionary) {
            for (String word : buckets) {
                for (int i = 2; i < word.length() - 1; i++) {
                    String word1 = word.substring(0, i);
                    String word2 = word.substring(i);
                    if (inDictionary(word1) && inDictionary(word2)) {
                        results.add(new SubWord(word, word1, word2));
                    }

                }
            }
        }
        return results;
    }

    /**
     * Chechs if a word is valid by identifying whether it is present in the ArrayList dictionary
     *
     * @param word The item to be searched for in dictionary
     * @return a boolean value showing whether the word is in dictionary
     */
    public boolean inDictionary(String word) {
        ArrayList<String> bucket = dictionary.get(alpha.indexOf(word.charAt(0)));
        // TODO: Override binarySearch

        int start = 0;
        int end = bucket.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (bucket.get(mid).equals(word)) {
                return true;
            }
            if (word.compareTo(bucket.get(mid)) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
        //return Collections.binarySearch(bucket, word) >= 0;
    }

    /**
     * main method for class RomanToDecimal
     *
     * @param args command line argument
     */
    public static void main(String[] args) {
        //long startTime = System.nanoTime();
        SubWordFinder app = new SubWordFinder();
        ArrayList<SubWord> subwords = app.getSubWords();
        //app.printDictionary();
        for (SubWord word : subwords) System.out.println(word);
        //app.printDictionary();
        //long endTime = System.nanoTime();
        //System.out.println("\nThe total time you had to wait was " + (endTime - startTime));
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to print words with 3, 4, or even 5 sub-words? " +
                    "\n(3 = 3subs, 4 = 4subs, 5 = 5subs, 0 = no): ");
            String input = in.nextLine().trim();

            if (input.equals("0")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else if (input.equals("3")) {
                // Print your results here
                // TODO: Your code to find and print
                ArrayList<Sub3Word> sub3Words = new ArrayList<>();
                for (ArrayList<String> bucket : app.dictionary) {
                    for (String root : bucket) {
                        if (root.length() < 6) continue;
                        for (int i = 2; i < root.length() - 3; i++) {
                            for (int j = i + 2; j < root.length() - 1; j++) {

                                String word1 = root.substring(0, i);
                                String word2 = root.substring(i, j);
                                String word3 = root.substring(j);
                                if (app.inDictionary(word1) && app.inDictionary(word2) && app.inDictionary(word3)) {
                                    sub3Words.add(new Sub3Word(root, word1, word2, word3));
                                }
                            }
                        }
                    }
                }
                for (Sub3Word word : sub3Words) {
                    System.out.println(word);
                }
            } else if (input.equals("4")) {
                ArrayList<Sub4Word> sub4Words = new ArrayList<>();
                for (ArrayList<String> bucket : app.dictionary) {
                    for (String root : bucket) {
                        if (root.length() < 8) continue;
                        for (int i = 2; i < root.length() - 5; i++) {
                            for (int j = i + 2; j < root.length() - 3; j++) {
                                for (int k = j + 2; k < root.length() - 1; k++) {
                                    String word1 = root.substring(0, i);
                                    String word2 = root.substring(i, j);
                                    String word3 = root.substring(j, k);
                                    String word4 = root.substring(k);
                                    if (app.inDictionary(word1) && app.inDictionary(word2) && app.inDictionary(word3) && app.inDictionary(word4)) {
                                        sub4Words.add(new Sub4Word(root, word1, word2, word3, word4));
                                    }
                                }
                            }
                        }
                    }
                }
                for (Sub4Word word : sub4Words) {
                    System.out.println(word);
                }
            }
            else if (input.equals("5")) {
                ArrayList<Sub5Word> sub5Words = new ArrayList<>();
                for (ArrayList<String> bucket : app.dictionary) {
                    for (String root : bucket) {
                        if (root.length() < 10) continue;
                        for (int i = 2; i < root.length() - 7; i++) {
                            String word1 = root.substring(0, i);
                            if (!app.inDictionary(word1)) continue;
                            for (int j = i + 2; j < root.length() - 5; j++) {
                                String word2 = root.substring(i, j);
                                if (!app.inDictionary(word2)) continue;
                                for (int k = j + 2; k < root.length() - 3; k++) {
                                    String word3 = root.substring(j, k);
                                    if (!app.inDictionary(word3)) continue;
                                    for (int l = k + 2; l < root.length() - 1; l++) {
                                        String word4 = root.substring(k,l);
                                        String word5 = root.substring(l);
                                        if (app.inDictionary(word4) && app.inDictionary(word5)) {
                                            sub5Words.add(new Sub5Word(root, word1, word2, word3, word4, word5));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for (Sub5Word word : sub5Words) {
                    System.out.println(word);
                }
            }
            else {
                System.out.println("Invalid input. Please try again.");
                // Loop continues, asks again
            }
        }

        in.close();

    }
}
    /*
    public void printDictionary() {
        for(ArrayList<String> bucket : dictionary) {
            System.out.println(bucket);
        }
    }
}
     */
