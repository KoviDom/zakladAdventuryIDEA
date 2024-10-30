package cz.vse.adventura.logika;

/**
 * Tato třída PrikazPouzij implementuje pro hru příkaz pouzij.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazPouzij implements IPrikaz{

    private static final String NAZEV = "pouzij";
    private final Batoh batoh;
    private final Hrac hrac;
    private final HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     * @param batoh
     * @param hrac
     * @param herniPlan
     */
    public PrikazPouzij(Batoh batoh, Hrac hrac, HerniPlan herniPlan) {
        this.batoh = batoh;
        this.hrac = hrac;
        this.herniPlan = herniPlan;
    }

    /**
     * Provádí příkaz "použij". Pomocí tohoto příkazu, lze použít předmět z batohu/inventáře.
     * Ověřuje se zda-li věc byla zadána nebo její existence v batohu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu (parametry název věci).
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            //Nebyl zadán název věci
            return "Nevím jaký předmět mám použít!";
        }

        String nazevVeci = parametry[0];
        Vec pouzivanaVec = herniPlan.ziskejVec(nazevVeci);

        if(pouzivanaVec == null) {
            //Věc neexistuje v prostoru
            return "Věc " + nazevVeci + " nebyla nalezena v prostoru.";
        }

        pouzivanaVec = herniPlan.ziskejVec(batoh.vratVec(nazevVeci));

        if (pouzivanaVec == null) {
            //Věc neexistuje v batohu
            return "Věc " + nazevVeci + " nebyla nalezena v batohu.";
        }

        hrac.zpracujVec(pouzivanaVec);
        //Pokud existuje popis k použití věci, uloží se do proměnné (pokud neexistuje, Optional bude prázdný)
        String popisPouzitiVeci = pouzivanaVec.provedSchopnost();
        batoh.odstranVecZBatohu(nazevVeci);

        //Věc byla použita
        return popisPouzitiVeci;
    }

    //--- Getter
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
