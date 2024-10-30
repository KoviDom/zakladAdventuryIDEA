package cz.vse.adventura.logika;

/**
 * Třída Nůž - reprezentuje věc nůž
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Nůž" reprezentuje hráčovi věc nůž a dědí z třídy Věc.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class Nuz extends Vec {

    private final Prostor prostorKOtevreni;

    /**
     * Konstruktor třídy
     * @param nazev
     * @param sebratelnost
     * @param hodnotaSilyUtoku
     * @param hodnotaPoctuZivotu
     * @param hodnotaSilyObrany
     * @param prostorKOtevreni
     */
    public Nuz(String nazev, boolean sebratelnost, int hodnotaSilyUtoku, int hodnotaPoctuZivotu, int hodnotaSilyObrany, Prostor prostorKOtevreni) {
        super(nazev, sebratelnost, hodnotaSilyUtoku, hodnotaPoctuZivotu, hodnotaSilyObrany);
        this.prostorKOtevreni = prostorKOtevreni;
    }

    @Override
    public String provedSchopnost() {
        prostorKOtevreni.setOpustitelny(true);
        return "Poté co jsi se rozhlédnul, jestli nikdo není poblíž tebe jsi vzal nůž a použil jsi ho.";
    }
}
