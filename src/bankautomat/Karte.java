/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

/**
 * Die Klasse Karte.
 *
 * @author Timon Kindler & Lars Flury
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

    /**
     * Gibt die verbleibenden Versuche um die Karte zu entsperren zurück. Und
     * reduziert den pinccount um 1.
     *
     * @return die verbleibenden Versuche um die Karte zu entsperren
     */
    public int getPincount() {
        pincount--;
        return pincount;
    }

    /**
     * Setzt den pincount auf 3 zurück
     */
    public void resetPincount() {
        pincount = 3;
    }

    /**
     * Der Konstrucktor dieser Klasse.
     *
     * @param name Der Name des Karteninhabers
     * @param vorname Der Vorname des Karteninhabers
     * @param iban Die iban der Karte
     * @param bankbezeichnung Die Bankbezeichnung der Bank diser Karte
     * @param kartennummer Die Krtennummer der Karte
     * @param gueltigBis Bis wann die Karte noch gültig ist.
     * @param pincode Der Pincode der Karte.
     */
    public Karte(String name, String vorname, String iban, String bankbezeichnung, int kartennummer, String gueltigBis, int pincode) {
        this.name = name;
        this.vorname = vorname;
        this.iban = iban;
        this.bankbezeichnung = bankbezeichnung;
        this.kartennummer = kartennummer;
        this.gueltigBis = gueltigBis;
        this.pincode = pincode;
    }

    /**
     * Gibt den Pincode als int zurück
     *
     * @return der Pincode als int
     */
    public int getPincode() {
        return pincode;
    }

    /**
     * Setzt den Pincode
     *
     * @param pincode der neue Pincode
     */
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    /**
     * Gibt den Namen des Karteninhabers zurück.
     *
     * @return Namen des Karteninhabers
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Vornamen des Karteninhabers zurück.
     *
     * @return Vornamen des Karteninhabers
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Gibt die Iban der karte zurück.
     *
     * @return die Iban der karte
     */
    public String getIban() {
        return iban;
    }

    /**
     * Gibt die Bankbezeichnung der Bank diser Karte zurück
     *
     * @return die Bankbezeichnung der Bank diser Karte
     */
    public String getBankbezeichnung() {
        return bankbezeichnung;
    }
    /**
     * Gibt die Kartennummer diser Karte zurück
     * @return  die Kartennummer diser Karte
     */
    public int getKartennummer() {
        return kartennummer;
    }
    /**
     * Gibt zurück bis wann diese Karte noch gültig ist
     * @return bis wann diese Karte noch gültig
     */
    public String getGueltigBis() {
        return gueltigBis;
    }

}
