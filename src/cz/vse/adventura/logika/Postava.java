package cz.vse.adventura.logika;

/**
 * Třída Postava popisuje postavu
 *
 * Tato třída je součástí jednoduché textové hry.
 * "Postava" (reprezentuje člověka) tato třída slouží jako nadtřída třídám Hráč a Nepřítel.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class Postava {

    private final String nazev;
    private int pocetZivotu;
    private int silaUtoku;
    private int silaObrany;


    /**
     * Konstruktor třídy
     * @param nazev
     * @param pocetZivotu
     * @param silaUtoku
     * @param silaObrany
     */
    public Postava(String nazev, int pocetZivotu, int silaUtoku, int silaObrany) {
        this.nazev = nazev;
        this.pocetZivotu = pocetZivotu;
        this.silaUtoku = silaUtoku;
        this.silaObrany = silaObrany;
    }

    //------ Gettery
    public String getNazev() {
        return nazev;
    }

    public int getPocetZivotu() {
        return pocetZivotu;
    }

    public int getSilaUtoku() {
        return silaUtoku;
    }

    public int getSilaObrany() {
        return silaObrany;
    }

    //------ Settery
    public void setPocetZivotu(int pocetZivotu) {
        this.pocetZivotu = pocetZivotu;
    }

    public void setSilaUtoku(int silaUtoku) {
        this.silaUtoku = silaUtoku;
    }

    public void setSilaObrany(int silaObrany) {
        this.silaObrany = silaObrany;
    }

    /**
     * Metoda, která odebírá životy.
     * @param postava
     */

    public void odeberZivoty(Postava postava) {
        this.setPocetZivotu(this.pocetZivotu - (postava.getSilaUtoku() - this.silaObrany));
    }


}
