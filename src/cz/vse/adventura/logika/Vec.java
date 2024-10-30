package cz.vse.adventura.logika;

/**
 * Třída Věc - reprezentuje věc
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Dominik Kováč
 *
 * @version pro školní rok 2020/2021
 */
public class Vec implements IVec {

    private final String nazev;
    private final boolean sebratelnost;
    private final int hodnotaSilyUtoku;
    private final int hodnotaPoctuZivotu;
    private final int hodnotaSilyObrany;

    /**
     * Konstruktor třídy
     * @param nazev
     * @param sebratelnost
     * @param hodnotaSilyUtoku
     * @param hodnotaPoctuZivotu
     * @param hodnotaSilyObrany
     */
    public Vec(String nazev, boolean sebratelnost, int hodnotaSilyUtoku, int hodnotaPoctuZivotu, int hodnotaSilyObrany) {
        this.nazev = nazev;
        this.sebratelnost = sebratelnost;
        this.hodnotaSilyUtoku = hodnotaSilyUtoku;
        this.hodnotaPoctuZivotu = hodnotaPoctuZivotu;
        this.hodnotaSilyObrany = hodnotaSilyObrany;
    }

    //------- Gettery
    public String getNazev() {
        return nazev;
    }

    public int getHodnotaSilyUtoku() {
        return hodnotaSilyUtoku;
    }

    public int getHodnotaPoctuZivotu() {
        return hodnotaPoctuZivotu;
    }

    public int getHodnotaSilyObrany() {
        return hodnotaSilyObrany;
    }

    /**
     * Metoda kontroluje, jestli je věc přenositelná.
     * @return boolean
     */
    public boolean isSebratelnost() {
        return sebratelnost;
    }
}
