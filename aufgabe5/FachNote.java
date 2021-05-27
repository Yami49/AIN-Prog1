//FachNote.java
package aufgabe5;
/**
 * @author Georgios Gerontidis
 * @version 11.5.2021
 */
public final class FachNote {

    /** Konstante Instanzvariable fach mit dem Fach vom Typ String.*/
    public final String fach;
    /** Konstante Instanzvariable note mit der Note vom Typ Note.*/
    public final Note note;

    /**
     * Konstruktor zum initialisieren der Fachnote.
     * @param fach zum speichern des Faches
     * @param note zum speichern der Note
     */
    public FachNote(String fach, Note note) {
        if (fach == null || note == null || fach.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.fach = fach;
        this.note = note;
    }
}