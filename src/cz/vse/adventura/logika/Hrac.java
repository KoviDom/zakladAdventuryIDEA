package cz.vse.adventura.logika;

/**
 * Třída Hráč - reprezentuje hráče
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Hrac" reprezentuje hráče a dědí z třídy Postava.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class Hrac extends Postava{

    private Batoh batoh;

    /**
     * Konstruktor třídy
     * @param pocetZivotu
     * @param silaUtoku
     * @param silaObrany
     * @param batoh
     */
    public Hrac(int pocetZivotu, int silaUtoku, int silaObrany, Batoh batoh) {
        super("Hráč", pocetZivotu, silaUtoku, silaObrany);
        this.batoh = batoh;
    }

    /**
     * Metoda pro zpracování věci a následném zvýšení hodnot statů hráče.
     * @param vec
     */
    public void zpracujVec(Vec vec) {
        this.setSilaUtoku(this.getSilaUtoku() + vec.getHodnotaSilyUtoku());
        this.setPocetZivotu(this.getPocetZivotu() + vec.getHodnotaPoctuZivotu());
        this.setSilaObrany(this.getSilaObrany() + vec.getHodnotaSilyObrany());
    }

    public void odeberVec(Vec vec) {
        this.setSilaUtoku(this.getSilaUtoku() - vec.getHodnotaSilyUtoku());
        this.setPocetZivotu(this.getPocetZivotu() - vec.getHodnotaPoctuZivotu());
        this.setSilaObrany(this.getSilaObrany() - vec.getHodnotaSilyObrany());
    }

    //---- Gettery
    public Batoh getBatoh() {
        return batoh;
    }

    //--------- ToString
    public String toString() {
        return "Počet životů: " + this.getPocetZivotu() + "\n"
                + "Síla Útoku: " + this.getSilaUtoku() + "\n"
                + "Síla Obrany: " + this.getSilaObrany() + "\n";
    }

}
