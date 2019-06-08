package Autostrada;

import NieMoznaZnalezcPojazduException.NieMoznaZnalezcPojazduException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Autostrada {
    //mapa w ktorej przechowujemy pojazdy
    // dla quicksearcha jest nrrej
    private Map<String, InformacjaOPojezdzie> mapaPojazdow = new HashMap<>();

    void wjazdPojazduNaAutostrade(String nrRej, TypPojazdu typPojazdu) {
        InformacjaOPojezdzie informacjaOPojezdzie = new InformacjaOPojezdzie(nrRej, typPojazdu, LocalDateTime.now());
        mapaPojazdow.put(nrRej, informacjaOPojezdzie);
        System.out.println("Pojazd: " + informacjaOPojezdzie + ", wjechal na autostrade.");
    }

    public InformacjaOPojezdzie znajdzPojazd(String nrRej) {
        if (mapaPojazdow.containsKey(nrRej)) {
            System.out.println("pojazd wciaz znajduje sie na autostradzie");
            return mapaPojazdow.get(nrRej);
        }
        throw new NieMoznaZnalezcPojazduException();
    }

    public Double wyjazdPojazdu(String nrRej) {
        if (!mapaPojazdow.containsKey(nrRej)) {
            throw new NieMoznaZnalezcPojazduException();
        }
        InformacjaOPojezdzie informacjaOPojezdzie = mapaPojazdow.get(nrRej);
        Duration dlugoscPrzejazdu = Duration.between(informacjaOPojezdzie.getDataWjazdu(),LocalDateTime.now());
        double doZaplaty = 0.0;
        switch (informacjaOPojezdzie.getTypPojazdu()) {
            case CAR:
                doZaplaty = dlugoscPrzejazdu.getSeconds() * 0.3;
                break;
            case TRACK:
                doZaplaty = dlugoscPrzejazdu.getSeconds() * 0.2;
                break;
            case MOTORCYCLE:
                doZaplaty = dlugoscPrzejazdu.getSeconds() * 0.5;
                break;
        }
         mapaPojazdow.remove(nrRej);
        System.out.println("Pojazd: " + nrRej + " opuszcza autostrade, do zaplaty:  " + doZaplaty);
        return doZaplaty;
    }


}


