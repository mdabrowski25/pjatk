package pl.pjwstk.cw3;

public class Main {
    public static void main(String[] args) {
        //1
        exercise1();
        //2
        exercise2();
        //3
        char myChar = 103;
        System.out.println(myChar);

        if ((myChar & 0b01) == 1) {
            System.out.println("liczba niepatrzysta");
        } else {
            System.out.println("parzysta");
        }



        if ((myChar & 0b01) == 1){
            System.out.println("bit 0 rowny 1");
        }

        String s = Integer.toBinaryString(myChar);

        int n = 3;
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (((myChar >> n) & 0b01) == 1){
                System.out.println("bit " + n + " rowny 1");
            }
            n += 3;
        }
    }

    private static void exercise2() {
        int variable1 = 218;
        int result;
        System.out.println(variable1 & 0b0101100);
    }

    private static void exercise1() {
        System.out.println(0b10100101111);
        System.out.println(02457);
        System.out.println(0x52F);
    }
}
