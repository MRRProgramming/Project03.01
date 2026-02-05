import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        SubWord s1 = new SubWord("rattlesnake", "rattle", "snake");
        SubWord s2 = new SubWord("affection", "affect", "ion");

        ArrayList<SubWord> subwords = new ArrayList<>();
        subwords.add(s1);
        subwords.add(s2);
        subwords.add(new SubWord("basketball", "basket", "ball"));

        System.out.println("PRE SORT");
        for(SubWord subword : subwords) {
            System.out.println(subword);
        }
        Collections.sort(subwords);
        System.out.println("POST SORT");
        for(SubWord subword : subwords) {
            System.out.println(subword);
        }
        //System.out.println(subwords.get(0).compareTo("affect"));
    }
}
