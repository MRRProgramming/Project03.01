public class Sub4Word {
    /**
     * This class is used to define and construct Sub4Word Objects along with some of their methods
     */

    private String root, sub1, sub2, sub3, sub4;

    /**
     * Returns textual representation of a Sub4Word object in the form:
     * root = sub1 + sub2 + sub 3 + sub4
     * NOTE that if the JVM needs an object in a String form, if the programmer
     * has defined the toString method for that class, it is called automatically
     *
     * @return A String version of a SubWord
     */
    public String toString() {
        return root + " = " + sub1 + " + " + sub2 + " + " + sub3 + " + " + sub4;
    }

    /**
     * Constructs a SubWord object
     *
     * @param r  the root word
     * @param s1 the front sub
     * @param s2 the 2nd sub
     * @param s3 the 3rd sub
     * @param s4 the back sub
     */
    public Sub4Word(String r, String s1, String s2, String s3, String s4) {
        this.root = r;
        this.sub1 = s1;
        this.sub2 = s2;
        this.sub3 = s3;
        this.sub4 = s1;


    }
}
