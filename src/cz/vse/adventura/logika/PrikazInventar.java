package cz.vse.adventura.logika;

import java.util.Set;

/**
 * Třída PrikazInventář implementuje pro hru příkaz inventář.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazInventar implements IPrikaz{

    private static final String NAZEV = "inventar";
    private final Batoh batoh;

    /**
     * Konstruktor třídy
     * @param batoh
     */
    public PrikazInventar(Batoh batoh) {
        this.batoh = batoh;
    }

    /**
     * Provádí příkaz "inventář". Ověřuje se zda-li je batoh prázdný, podle toho výpíše hráči hlášku.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Set<String> batohKolekce = batoh.getVeci();

        if(batohKolekce.size() == 0) {
            //Pokud je batoh prázdný
            return "Kapacita batohu: " + batoh.getKapacitaBatohu() + " \n"
                    + "Batoh je prázdný!";
        }

        String seznamVeci = "Kapacita batohu: " + batoh.getKapacitaBatohu() + " \n"
                + "Věci v batohu: ";

        for (String vec:batohKolekce) {
            seznamVeci += vec + " ";
        }

        //Seznam věcí v batohu (inventáři)
        return seznamVeci;
    }

    //----- Getter
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
