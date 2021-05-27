// Histogramm.java
package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author Georgios Gerontidis
 * @version 9.5.2021
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {

        /*  (1) hier ein Feld von Zaehlern definieren */
        int[] counter = {0, 0, 0, 0, 0, 0};
        final int max = 6;
        final int min = 1;
        final int five = 5;

        //---------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            int number = EINGABE.nextInt();

            /*  hier Anweisungen fuer das
                         Pruefen und Zaehlen der Eingabe schreiben */
            if (number >= min && number <= max) {
                counter[--number]++;
            } else {
                System.out.printf("Falsche Eingabe wird ignoriert: %d\n",
                                    number);
            }
        }

        //------------------------------------------------ Histogramm ausgeben

        /*  hier Anweisungen fuer die Histogrammausgabe schreiben */
        System.out.println("Histogramm");
        for (int i = 0; i < max; i++) {
            int j = 0;
            while (j < counter[i]) {
                if ((j + 1) % five == 0) {
                    System.out.print("$");
                } else {
                    System.out.print((i + 1));
                }
                j++;
            }
            System.out.printf("(%d)\n", counter[i]);
        }
    }
}