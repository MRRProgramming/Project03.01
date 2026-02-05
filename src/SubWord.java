/**
 * This class is used to define and construct SubWord Objects along with some of their methods
 */
public class SubWord implements Comparable<SubWord> {
    private String root, sub1, sub2;

    /**
     * Returns textual representation of a SubWrod object in the form:
     * root = sub1 + sub2
     * NOTE that if the JVM needs an object in a String form, if the programmer
     * has defined the toString method for that class, it is called automatically
     * @return A String version of a SubWord
     */
    public String toString()    {
        return root + " = " + sub1 + " + " + sub2;
    }

    public String getRoot() {
        return root;
    }

    public String getSub1() {
        return sub1;
    }

    public String getSub2() {
        return sub2;
    }

    /**
     * Constructs a SubWord object
     * @param r the root word
     * @param s1 the front sub
     * @param s2 the back sub
     */
    public SubWord(String r, String s1, String s2) {
        this.root = r;
        this.sub1 = s1;
        this.sub2 = s2;


    }

    /**
     * compares SubWord object to be used in sorting algorithms
     * @param o the input SubWord that is to be compared with
     * @return int difference between the lexicographical this.root and o.root
     */
    @Override
    public int compareTo(SubWord o) {
        return this.root.compareTo(o.root);
    }
}
