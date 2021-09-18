/**
 * TAO XU 9/17/21
 * You shouldn't use any if-else statements
 * Put comments in your code
 * Follow freedom of information and gilligans island rule
 * Discussed with: XXX
 **/

public class DrawRocket {
    //Make below variable a class constant used only by this class (DO NOT CHANGE THE NAME OF THE VARIABLE)
    public static Integer SIZE = 3; // DO NOT REMOVE THIS LINE

    public static void main(String[] args) {
        draw1();
        draw2();
        draw3();
        draw4();
        draw2();
        draw4();
        draw3();
        draw2();
        draw1();
    }

    public static void draw1() {
        for (int line = 1; line <= (SIZE * 2 - 1); line++) {
            System.out.print(" ");
            for (int i = 1; i <= (SIZE * 2 - 1) - line; i++){
                System.out.print(" ");
            }
            for (int j = 1; j <= line; j++) {
                System.out.print("/");
            }
            System.out.print("**");
            for (int k = 1; k <= line; k++) {
                System.out.print("\\");
            }
            System.out.println(" ");
        }
    }

    public static void draw2() {
        System.out.print("+");
        for (int i = 1; i <= SIZE * 2; i++) {
            System.out.print("=*");
        }
        System.out.println("+");
    }

    public static void draw3() {
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");
            for (int a = 1; a <= 2; a++) {
                for (int b = 1; b <= SIZE - line; b++) {
                    System.out.print(".");
                }
                for (int c = 1; c <= line; c++) {
                    System.out.print("/\\");
                }
                for (int b = 1; b <= SIZE - line; b++) {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }
    }

    public static void draw4() {
        for (int line = SIZE; line >= 1; line--) {
            System.out.print("|");
            for (int a = 1; a <= 2; a++) {
                for (int b = 1; b <= SIZE - line; b++) {
                    System.out.print(".");
                }
                for (int c = 1; c <= line; c++) {
                    System.out.print("\\/");
                }
                for (int b = 1; b <= SIZE - line; b++) {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }
    }
}
