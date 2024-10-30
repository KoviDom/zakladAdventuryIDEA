package cz.vse.adventura.logika;

/**
 * Třída Nepřítel - reprezentuje hráče
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Nepřítel" reprezentuje hráčovi nepřítele a dědí z třídy Postava.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class Nepritel extends Postava{

    /**
     * Konstruktor třídy.
     * @param nazev
     * @param pocetZivotu
     * @param silaUtoku
     * @param silaObrany
     */
    public Nepritel(String nazev, int pocetZivotu, int silaUtoku, int silaObrany) {
        super(nazev, pocetZivotu, silaUtoku, silaObrany);
    }

}
