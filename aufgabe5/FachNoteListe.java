//FachNoteListe.java
package aufgabe5;
/**
 * @author Georgios Gerontidis
 * @version 11.5.2021
 */
public final class FachNoteListe {
    private Element head = null; // leere Liste

    /**
     * Fügt ein neues element in die Liste ein.
     * @param n ist Objekt vom Typ FachNote
     * @return Liste mit dem neuen element n
     */
    public FachNoteListe insert(/* final IntList this, */ FachNote n) {
        this.head = new Element(this.head, n);
        return this;
    }

    private static final class Element {
        private final Element next; // Verkettung
        private final FachNote n; // Wert des Listenelements

        private Element(/* final Element this, */ Element e, FachNote n) {
            this.next = e;
            this.n = n;
        }

    }

    /**
     * Unterklasse Iterator.
     */
    public final class Iterator {
        // private IntList IntList.this;
        private Element current = FachNoteListe.this.head;
        /**
         * Instanzmethode die prüft ob es noch ein Element in der
         * this Liste gibt.
         * @return true wenn es ein nächstes Element besitztz, ansonsten falls
         */
        public boolean hasNext(/* final Iterator this */) {
            return this.current != null;
        }

        /**
         * Instanzmethode die den Zeiger auf das nächste Element seztzt.
         * @return nächstes Element der this Liste
         */
        public FachNote next(/* final Iterator this */) {
            if (this.current == null) {
                throw new java.util.NoSuchElementException();
            }
            Element e = this.current;
            this.current = this.current.next;
            return e.n;
        }
    }
}