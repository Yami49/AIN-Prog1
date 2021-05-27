//Note.java
package aufgabe5;
/**
 * @author Georgios Gerontidis
 * @version 11.5.2021
 */
public final class Note {

    private final int note;

    private Note(int note) {
        this.note = note;
    }

    /** Konstante Klassenvariable mit der besten Note. */
    public static final Note BESTE = new Note(10);

    /** Konstante Klassenvariable mit der schlechtesten Note. */
    public static final Note SCHLECHTESTE = new Note(50);

    /**
     * Öffentliche Fabrikmethode die die Note auf zulässigkeit prüft.
     * @param note Integer mit der Note
     * @return note wenn sie im gültigen Wertebereich liegt(HTWG)
     * @throws IllegalArgumentException bei Unzulässiger Note
     */
    public static Note valueOf(int note) {
        switch (note) {
        case 10:
            return new Note(10);
        case 13:
            return new Note(13);
        case 17:
            return new Note(17);
        case 20:
            return new Note(20);
        case 23:
            return new Note(23);
        case 27:
            return new Note(27);
        case 30:
            return new Note(30);
        case 33:
            return new Note(33);
        case 37:
            return new Note(37);
        case 40:
            return new Note(40);
        case 50:
            return new Note(50);
        default:
            throw new IllegalArgumentException("Unzulässige Note " + note);
        }
    }

    /**
     * Öffentliche Frabrikmethode die den eingegeben String
     * in das gültige Format umwandelt.
     * @param noteS String der geprüft wird
     * @return ein Objekt vom Typ Note
     */
    public static Note valueOf(String noteS) {
        if (noteS.length() == 3 && Character.isDigit(noteS.charAt(0))
                && (noteS.charAt(1) == '.' || noteS.charAt(1) == ',')
                && Character.isDigit(noteS.charAt(2))) {
            noteS = noteS.replace(',', '.');
            return valueOf((int) (Double.valueOf(noteS) * 10));
        } else {
            throw new IllegalArgumentException("Unzulässige Note " + noteS);
        }
    }

    /**
     * Liefert die im Objekt gespeicherte Note.
     * @return this.note
     */
    public int intValue() {
        return this.note;
    }

    /**
     * Prüft ob die Note Bestanden ist.
     * @return true wenn Bestanden, ansonsten false
     */
    public boolean istBestanden() {
        return this.note <= 40;
    }

    @Override
    public String toString(/* final Note this*/) {
        String node = String.valueOf(Double.valueOf(note) / 10);
        String node1 = node.replace(',', '.');
        return node1;
    }

    @Override
    public boolean equals(/* final Note this*/ Object o) {
        if (o instanceof Note) {
            Note that = (Note) o;
            return this.note == that.note;
        }
        return false;
    }

    @Override
    public int hashCode(/* final Note this*/) {
        return this.note;
    }
}