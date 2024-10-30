package cz.vse.adventura.logika;

/**
 * Tato třída PrikazInfo implementuje pro hru příkaz info.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazInfo implements IPrikaz{

    private static final String NAZEV = "info";
    private final Hrac hrac;

    /**
     * Konstruktor třídy
     * @param hrac
     */
    public PrikazInfo(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Provádí příkaz "info". Uživateli vypíše informace o jeho statech.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, kterou vypíše hra hráči.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return hrac.toString();
    }

    //---- Getter
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
