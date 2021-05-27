package aufgabe4;
/**
 * @author Georgios Gerontidis
 * @version 10.5.2021
 */
public final class Noten {
    private Noten() { }

    /** Öffentliche Konstante Klassenvariable BESTE mit der besten Note. */
    public static final double BESTE = 1.0;

    /** Öffentliche Konstante Klassenvariable SCHLECHTESTE
     * mit der schlechtesten Note. */
    public static final double SCHLECHTESTE = 5.0;

    /**
     * Prueft einen String auf zulässigkeit.
     * @param note wird auf zulässigkeit geprüft(A3)
     * @return true wenn note zulässig, ansonsten false
     */
    public static boolean istZulaessig(String note) {
        if (note.length() == 3 && Character.isDigit(note.charAt(0))
                && (note.charAt(1) == '.' || note.charAt(1) == ',')
                && Character.isDigit(note.charAt(2))) {
            switch (note.charAt(0)) {
            case '1':
            case '2':
            case '3':
                return note.charAt(2) == '3'
                        || note.charAt(2) == '7'
                        || note.charAt(2) == '0';
            case '4':
                return note.charAt(2) == '0';
            case '5':
                return note.charAt(2) == '0';
            default:
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Konvertiert String in korrekte double-Darstellung.
     * @param note wird zuerst auf zulässigkeit geprüft und dann konvertiert
     * @return Gleitkommazahl
     * @throws IllegalArgumentException wenn note nicht zulässig ist
     */
    public static double toDouble(String note) {
        if (!istZulaessig(note))
            throw new IllegalArgumentException();
        note = note.replace(',', '.');
        double noteD = Double.parseDouble(note);
        return noteD;
    }

    /**
     * Prüft ob eine note im gültigen Wertebereich des HTWG-Systems liegt
     * und Formatiert diese in String-Darstellung.
     * @param note double-Wert der in eine String Objekt konvertiert wird
     * @return String im korrekten Format
     * @throws IllegalArgumentException wenn note wenn außerhalb HTWG-System
     */
    public static String toString(double note) {
        if (note >= BESTE && note <= SCHLECHTESTE) {
            String noteS = String.valueOf(note);
            noteS = noteS.replace(',', '.');
            return String.format("%.1f", noteS);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Prüft eine note darauf, ob Sie bestanden ist oder durchgefallen.
     * @param note double
     * @return true wenn note kleiner gleich 4.0 ist, ansonsten false
     */
    public static boolean istBestanden(double note) {
        return note <= 4.0;
    }

    /**
     * Prüft zwei noten darauf, welche besser ist (min).
     * @param m ertse double note
     * @param n zweite double note
     * @return die bessere note(minimum)
     */
    public static double bessere(double m, double n) {
        return m < n ? m : n;
    }

    /**
     * Prüft zwei noten, darauf welche schlechter ist (max).
     * @param m erste double note
     * @param n zweite double note
     * @return die schlechtere note (maximum)
     */
    public static double schlechtere(double m, double n) {
        return m > n ? m : n;
    }
}