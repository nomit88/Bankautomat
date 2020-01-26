/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

/**
 *
 * @author Lars
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
