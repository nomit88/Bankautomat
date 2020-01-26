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

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
    
}
