// Notenspiegel.java
package aufgabe5;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Notenspiegel liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Noten
 * in eine verkettete Liste ein und gibt dann einen Notenspiegel aus.
 * @author Georgios Gerontidis
 * @version 11.5.2021
 */
public final class Notenspiegel {
    private Notenspiegel() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        //Erzeuge Wertobjekt vom Typ FachNoteListe(einfach verkettete Liste)
        FachNoteListe liste = new FachNoteListe(); // leere Liste

        //--------------------------------------------- Notenspiegel einlesen
        System.err.printf(
            "Faecher mit Noten zwischen %d und %d eingeben "
            + "(Ende mit Strg-D):%n",
            Note.BESTE.intValue(), Note.SCHLECHTESTE.intValue());
        int lngth = 0;
        while (EINGABE.hasNext()) {
            try {
                //------------------------------------ Fach und Note einlesen

                /* (1) erst das Fach mit next() einlesen,
                             dann mit hasNextInt() pruefen,
                             ob die Note als ganze Zahl vorliegt,
                             und die Note je nachdem mit nextInt()
                             oder next() einlesen und schliesslich
                             in ein Wertobjekt verpacken */

                //Fach mit next() einlesen
                String fach = EINGABE.next();
                //Bestimmt die Laenge vom laengsten Fach
                if (lngth < fach.length())
                    lngth = fach.length();

                //erzeuge nite vom Typ Note
                Note note;
                //mit hasNextint() pruefen ob die Note eine Zahl ist
                if (EINGABE.hasNextInt()) {
                    //Fabrikmethode valueOf(int) zum einlesen
                    note = Note.valueOf(EINGABE.nextInt());
                } else {
                    //Fabrikmethode valueOf(String) zum einlesen
                    note = Note.valueOf(EINGABE.next());
                }
                //erzeuge neues Wertobjekt vom Typ FachNote
                FachNote element = new FachNote(fach, note);
                //--------------------- neue Fachnote in Notenliste eintragen

                /* (2) ein neues FachNote-Objekt erzeugen
                             und am Listenanfang einfuegen */
                liste.insert(element);

            } catch (IllegalArgumentException x) {
                System.err.printf("Eingabefehler: %s%n", x.getMessage());
                continue;
            } catch (NoSuchElementException x) {
                System.err.println("Fach ohne Note ignoriert!");
                break;
            }
        }

        //--------------------------------------------- Notenspiegel ausgeben

        /* (3) tabellarischen Notenspiegel
                     mit der Ueberschrift NOTENSPIEGEL ausgeben */
        final int abstand = 4;
        //laengstes Fach
        lngth = lngth + abstand;
        System.out.println("NOTENSPIEGEL");

        FachNoteListe.Iterator i = liste.new Iterator();

        while (i.hasNext()) {
            FachNote element = i.next();
            System.out.print(element.fach);
            int j = element.fach.length();
            while (j < lngth) {
                System.out.print(" ");
                j++;
            }
            System.out.print(element.note.toString());
            System.out.print("    ");
            if (element.note.equals(Note.BESTE)) {
                System.out.println("mit Bestnote bestanden");
            } else if (element.note.istBestanden()) {
                System.out.println("bestanden");
            } else {
                System.out.println("nicht Bestanden");
            }
        }
    } // main
}

