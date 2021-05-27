// Klausurergebnis.java
package aufgabe4;

import java.util.Locale;
import java.util.Scanner;
/**
 * Klausurergebnis erstellt eine Notenstatistik.
 * <p>
 * Das Programm liest Noten als Strings ein und bestimmt die beste und
 * die schlechteste Note, den Durchschnitt der Bestandenen sowie
 * die Durchfallquote in Prozent.
 * Das Programm ber&uuml;cksichtigt dabei nur die laut Noten.istZulaessig
 * erlaubten Noten. Andere Noten werden unter Ausgabe einer Warnung ignoriert.
 * Welche Noten besser und schlechter sind, welche als bestanden oder
 * durchgefallen gelten und wie die String-Darstellung der Noten aussieht,
 * wird mit Methoden der Klasse Noten bestimmt.
 * </p>
 * Das Programm gibt als Klausurergebnis folgende Werte aus:
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote</li>
 * </ul>
 *
 * @author Georgios Gerontidis
 * @version 10.5.2021
 */
public final class Klausurergebnis {
    private Klausurergebnis() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    private static double bes = Noten.SCHLECHTESTE;
    private static double sle = Noten.BESTE;
    private static double ges = 0;
    private static int bestanden = 0;
    private static int durchgefallen = 0;
    private static double tmpNoteD;

    /**
     * Start punkt vom Programm.
     * @param args wird verwendet um noten von der Kommandozeile zu lesen
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);

        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();

            //---------------------------------------------- Eingabe pruefen

            /* (1) note pruefen ... */
            if (!Noten.istZulaessig(note)) {
                System.err.printf("Unzulaessige Note %s"
                                    + " wird ignoriert!%n", note);
                continue;
            }

            //------------------------------------------------ Note erfassen

            /* (2) Notensumme Bestandene, Anzahl Bestandene,
                         Anzahl Durchgefallene sowie
                         beste und schlechteste Note aktualisieren ... */
            tmpNoteD = Noten.toDouble(note);

            if (Noten.istBestanden(tmpNoteD))
                ges += tmpNoteD;
            if (Noten.istBestanden(tmpNoteD))
                bestanden++;
            else
                durchgefallen++;

            bes = Noten.bessere(tmpNoteD, bes);
            sle = Noten.schlechtere(tmpNoteD, sle);

        } // while

        //------------------------------------------ Notenstatistik ausgeben

        /* (3) Durchschnitt und Durchfallquote berechnen
                     und dann die gesamte Statistik ausgeben ... */
        final int hundert = 100;
        int anzBerNoten = bestanden + durchgefallen;
        double dfq = (double) durchgefallen / anzBerNoten * hundert;
        System.out.printf("Anzahl beruecksichtigter Noten: %d%n", anzBerNoten);
        System.out.printf("Anzahl Bestandene: %d%n", bestanden);
        System.out.printf("Beste Note: %.1f%n", bes);
        System.out.printf("Schlechteste Note: %.1f%n", sle);
        System.out.printf("Durchschnitt Bestandene: %.1f%n", ges / bestanden);
        System.out.printf("Durchfallquote: %.1f%%%n", dfq);

    } // main
}

