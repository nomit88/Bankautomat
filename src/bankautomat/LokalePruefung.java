package bankautomat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class LokalePruefung implements Pruefung {

    Boolean pruefungsresultat = false;

    /**
     * Prüft ob die Karte abgelaufen ist pruefungsresultat ist true wenn die
     * Karte noch gülltig ist & false wenn sie abgelaufen ist.
     *
     * @param karte
     */
    @Override
    public void fuehrePruefungDurch(String iban) {
        DBHelper dBHelper  = new DBHelper();
        Karte karte = dBHelper.getKarte(iban);
        
        DateFormat dateFormat = new SimpleDateFormat("yy"); 
        int year = Integer.parseInt(dateFormat.format(Calendar.getInstance().getTime()));

        String[] karteDate = karte.getGueltigBis().split("/");
        if (year > Integer.parseInt(karteDate[1])) {
            pruefungsresultat = false;
        } else if (year == Integer.parseInt(karteDate[1])) {
            if (LocalDateTime.now().getMonth().getValue() > Integer.parseInt(karteDate[0])) {
                pruefungsresultat = false;
            }else{
                pruefungsresultat = true;
            }
        } else {
            pruefungsresultat = true;
        }
    }

    /**
     * Gibt das Prüfungsresultat zurück
     * @return das Prüfungsresultat
     */
    @Override
    public boolean pruefungsresultat() {
        return pruefungsresultat;
    }
}
