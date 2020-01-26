package bankautomat;

/**
 * 
 * @author Timon Kindler & Lars Flury
 */
public class Geldkassette {
    
    int menge;
    int note;

    public Geldkassette() {
        
    }
    
    
    public Geldkassette(int menge, int note){
        this.menge = menge;
        this.note = note;
    }

    /**
     * Gibt die verfügbare Menge dieser Note zurück
     * @return 
     */
    public int getMenge() {
        return menge;
    }
    
    /**
     * Setzt die Menge an Hand des Übergabeparameters zurück
     * @param menge Die Menge, welche gesetzt werden soll
     */
    public void setMenge(int menge) {
        this.menge = menge;
    }

    /**
     * Gibt die Note zurück
     * @return die Note
     */
    public int getNote() {
        return note;
    }

    /**
     * Setzt die Note an Hand des Übergabeparameters zurück
     * @param note Die Note, welche gesetzt werden soll
     */
    public void setNote(int note) {
        this.note = note;
    }
    
    
    
}
