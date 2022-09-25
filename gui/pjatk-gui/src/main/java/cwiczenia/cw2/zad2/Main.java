package cwiczenia.cw2.zad2;

public class Main {
    public static void main(String[] args) {
        Spiewak s1 = new Spiewak("Eminem") {
            @Override
            String spiewaj() {
                return "DADAOIPHJFWPlksafhjpoqfwjpqfe";
            }
        };
        Spiewak s2 = new Spiewak("Eagles") {
            @Override
            String spiewaj() {
                return "null";
            }
        };
        Spiewak s3 = new Spiewak("Dżem") {
            @Override
            String spiewaj() {
                return "nFSQsfaqopegjkepoegqwjewqbojwebwvwevwergb";
            }
        };

        Spiewak[] sp = {s1, s2, s3};

        for (Spiewak s : sp) System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}