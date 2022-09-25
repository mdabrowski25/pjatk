package cwiczenia.cw2.zad2;

public abstract class Spiewak {
    private static int counter = 1;
    protected String name;
    protected int startNumber;

    public Spiewak(String name) {
        this.name = name;
        this.startNumber = counter++;
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "Spiewak{" +
                "name='" + name + '\'' +
                ", startNumber=" + startNumber +
                '}';
    }

    public static Spiewak najglosniej(Spiewak[] array) {
        int spiewakArrayNumber = 0;
        int numberOfUpperCaseLetters = 0;

        for (int i = 0; i < array.length; i++) {
            int countUpperCaseLetters = 0;
            char[] chars = array[i].spiewaj().toCharArray();

            for (int i1 = 0; i1 < chars.length; i1++) {
                if (chars[i1] >= 65 && chars[i1] < 90) {
                    countUpperCaseLetters++;
                }
            }

            if (countUpperCaseLetters > numberOfUpperCaseLetters) {
                spiewakArrayNumber = i;
                numberOfUpperCaseLetters = countUpperCaseLetters;
            }
        }
        return array[spiewakArrayNumber];
    }
}
