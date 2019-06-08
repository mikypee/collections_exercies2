package Autostrada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Autostrada autostrada = new Autostrada();
        String komenda;
        do {
            System.out.println("podaj komende: ");
            komenda = scanner.nextLine();

            String[] slowa = komenda.split(" ");
            if (slowa[0].equalsIgnoreCase("wjazd")) {
                if (slowa.length >= 3) {
                    String nrRej = slowa[1];
                    String slowoTypPojazdu = slowa[2];
                    try {
                        TypPojazdu typ = TypPojazdu.valueOf(slowoTypPojazdu.toUpperCase());
                        autostrada.wjazdPojazduNaAutostrade(nrRej, typ);
                    } catch (IllegalArgumentException iae) {
                        System.err.println("blad !!! zly typ pojazdu !");
                    }

                }
            } else if (slowa[0].equalsIgnoreCase("wyjazd")) {
                if (slowa.length >= 2) {
                    String nrRej = slowa[1];

                    System.out.println(autostrada.znajdzPojazd(nrRej));


                } else if (slowa[0].equalsIgnoreCase("sprawdz")) {
                    if (slowa.length >= 2) {
                        String nrRej = slowa[1];

                        System.out.println(autostrada.znajdzPojazd(nrRej));
                    }
                }
            }

        }
                while (!komenda.equalsIgnoreCase("zamknij")) ;
            }

    }
