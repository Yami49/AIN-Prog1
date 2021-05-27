// IntVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * IntVar shows us how to with variable from Type int.

 * @author Georgios Gerontidis
 * @version 29.4.2021
 */
public final class IntVar {
    private IntVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {

        final int max = 0x7fffffff;
        final int min = 0x80000000;

        System.out.printf("Zwei ganze Zahlen zwischen %d und %d eingeben:\n",
                            min, max);

        int z1 = 0;
        int z2 = 0;
        int k = 0;
        try {
            z1 = EINGABE.nextInt();
            k++;
        } catch (Exception e) {
            System.out.println("Ungueltige Eingabe!");
        }

        if (k == 1) {
            try {
                z2 = EINGABE.nextInt();
                k++;
            } catch (Exception e) {
                System.out.println("Ungueltige Eingabe!");
            }
        }
        if (k == 2) {

            System.out.printf("%d ist oktal %o und hexadezimal %x\n",
                                z1, z1, z1);
            System.out.printf("%d ist oktal %o und hexadezimal %x\n",
                                z2, z2, z2);

            System.out.println("Arithmetischen/Logischen Operator waehlen:");
            String operator = EINGABE.next();
            switch (operator) {
            case "+":
                System.out.printf("%d + %d ist %d\n", z1, z2, z1 + z2);
                break;
            case "-":
                System.out.printf("%d - %d ist %d\n", z1, z2, z1 - z2);
                break;
            case "*":
                System.out.printf("%d * %d ist %d\n", z1, z2, z1 * z2);
                break;
            case "/":
                System.out.printf("%d / %d ist %d\n", z1, z2, z1 / z2);
                break;
            case "%":
                System.out.printf("%d %% %d ist %d\n", z1, z2, z1 % z2);
                break;
            case "==":
                System.out.printf("%d == %d ist %b\n", z1, z2, z1 == z2);
                break;
            case "!=":
                System.out.printf("%d != %d ist %b\n", z1, z2, z1 != z2);
                break;
            case "<":
                System.out.printf("%d < %d ist %b\n", z1, z2, z1 < z2);
                break;
            case "<=":
                System.out.printf("%d <= %d ist %b\n", z1, z2, z1 <= z2);
                break;
            case ">":
                System.out.printf("%d > %d ist %b\n", z1, z2, z1 > z2);
                break;
            case ">=":
                System.out.printf("%d >= %d ist %b\n", z1, z2, z1 >= z2);
                break;
            default:
                System.out.println("Ungueltiger Operator");
            }
        }
    }
}