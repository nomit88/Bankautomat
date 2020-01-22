/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

/**
 *
 * @author timon.kindler
 */
public class Karte {

    private String name;
    private String vorname;
    private String iban;
    private String bankbezeichnung;
    private int kartennummer;
    private String gueltigBis;
    private int pincode;
    private int pincount = 3;

    public int getPincount() {
        pincount--; 
        return pincount;
    }

    public Karte(String name, String vorname, String iban, String bankbezeichnung, int kartennummer, String gueltigBis, int pincode) {
        this.name = name;
        this.vorname = vorname;
        this.iban = iban;
        this.bankbezeichnung = bankbezeichnung;
        this.kartennummer = kartennummer;
        this.gueltigBis = gueltigBis;
        this.pincode = pincode;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getIban() {
        return iban;
    }

    public String getBankbezeichnung() {
        return bankbezeichnung;
    }

    public int getKartennummer() {
        return kartennummer;
    }

    public String getGueltigBis() {
        return gueltigBis;
    }
    
         


}
