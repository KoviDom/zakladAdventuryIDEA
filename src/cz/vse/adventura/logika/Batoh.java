package cz.vse.adventura.logika;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Trida Batoh - popisuje uložný prostor hráče
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Batoh" reprezentuje věc, do které vkládají věci.
 * V batohu je kontrolována kapacita a věci se mohou z batohu i brát.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */

public class Batoh {

    private int kapacitaBatohu;
    private Set<String> veci;

    /**
     *Konstruktor třídy s parametrem kapacita batohu.
     */
    public Batoh(int kapacitaBatohu) {
        this.kapacitaBatohu = kapacitaBatohu;
        this.veci = new HashSet<>();
    }

    /**
     * Metoda pro přidání věci do batohu.
     * @param vec
     */

    //Jestli počet věci + 1 není větší než kapacita batohu (tj. jestli batoh není plný), věc se přidá k věcem
    public void pridejVecDoBatohu(String vec) {
        if (!((this.veci.size() + 1) > this.getKapacitaBatohu())) {
            veci.add(vec);
        }
    }

    /**
     * Metoda pro zobrazení kolekce věcí batohu.
     * @return veci
     */
    public Set<String> zobrazBatoh() {
        return veci;
    }

    /**
     * Metoda pro vrácení věci podle názvu.
     * @param nazevVeci
     * @return vec
     */
    public String vratVec(String nazevVeci) {
        for (String vec : this.veci) {
            if (vec.equals(nazevVeci)) {
                return vec;
            }
        }

        return null;
    }

    /**
     *Metoda odstranění věcí z batohu z kolekce.
     * @param nazevVeci
     */
    public void odstranVecZBatohu(String nazevVeci) {
        veci.remove(nazevVeci);
    }

    /**
     * Metoda pro zvýšení kapacity batohu.
     */
    public void zvysKapacituBatohu() {
        this. kapacitaBatohu++;
    }

    //------ Gettery
    public int getKapacitaBatohu() {
        return kapacitaBatohu;
    }
    //------ Settery
    public void setKapacitaBatohu(int kapacitaBatohu) {
        this.kapacitaBatohu = kapacitaBatohu;
    }
    //------ Gettery
    public Set<String> getVeci() {
        return veci;
    }
    //------ Settery
    public void setVeci(Set<String> veci) {
        this.veci = veci;
    }
}
