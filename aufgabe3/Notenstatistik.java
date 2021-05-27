// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * <code>Ganze,Zehntel</code> oder <code>Ganze.Zehntel</code>,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author Georgios Gerontidis
 * @version 10.5.2021
 */
public final class Notenstatistik {
    private Notenstatistik() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");
        int bestanden = 0;
        int durchgefallen = 0;
        double ges = 0;
        double besRef = 5.0;
        double sleRef = 1.0;
        double bes = 4.0;
        final int prozent = 100;
        while (EINGABE.hasNext()) {
            String note = EINGABE.next();

            //---------------------------------------------- Eingabe pruefen

            /* (1) die Zeichen im String note pruefen ... */
            if (note.length() == 3 && Character.isDigit(note.charAt(0))
                && (note.charAt(1) == '.' || note.charAt(1) == ',')
                && Character.isDigit(note.charAt(2))) {
                switch (note.charAt(0)) {
                case '1':
                case '2':
                case '3':
                    if (note.charAt(2) == '3' || note.charAt(2) == '7'
                        || note.charAt(2) == '0') {
                        bestanden++;
                    } else {
                        System.err.printf("Note %s wird Nachkommastelle "
                                            + "%c ignoriert!%n",
                                            note, note.charAt(2));
                        continue;
                    }
                    break;
                case '4':
                    if (note.charAt(2) == '0') {
                        bestanden++;
                    } else {
                        System.err.printf("Note %s wird Nachkommastelle "
                                            + "%c ignoriert!%n",
                                            note, note.charAt(2));
                        continue;
                    }
                    break;
                case '5':
                    if (note.charAt(2) == '0') {
                        durchgefallen++;
                    } else {
                        System.err.printf("Note %s wird Nachkommastelle "
                                            + "%c ignoriert!%n",
                                            note, note.charAt(2));
                        continue;
                    }
                    break;
                default:
                    System.err.printf("Note %s wird Vorkommastelle "
                                        + "%c ignoriert!%n",
                                        note, note.charAt(0));
                    continue;
                }
            } else {
                System.err.printf("Note %s wird wegen Formatfehler "
                                    + "ignoriert!%n", note);
                continue;
            }

            //------------------------------------------------ Note erfassen

            /* (2) Notensumme Bestandene, Anzahl Bestandene,
                         Anzahl Durchgefallene sowie
                         beste und schlechteste Note aktualisieren ... */
            String node = note.replace(',', '.');
            double nodeD = Double.parseDouble(node);
            if (nodeD <= bes)
                ges += nodeD;
            if (sleRef < nodeD)
                sleRef = nodeD;
            if (besRef > nodeD)
                besRef = nodeD;

        } // while

        //------------------------------------------ Notenstatistik ausgeben

        /* (3) Durchschnitt und Durchfallquote berechnen
                     und dann die gesamte Statistik ausgeben ... */
        int anzBerNoten = bestanden + durchgefallen;
        double dfq = (double) durchgefallen / anzBerNoten * 100;
        System.out.printf("Anzahl beruecksichtigter Noten: %d%n", anzBerNoten);
        System.out.printf("Anzahl Bestandene: %d%n", bestanden);
        System.out.printf("Beste Note: %.1f%n", besRef);
        System.out.printf("Schlechteste Note: %.1f%n", sleRef);
        System.out.printf("Durchschnitt Bestandene: %.1f%n", ges / bestanden);
        System.out.printf("Durchfallquote: %.1f%%%n", dfq);

    } // main
}