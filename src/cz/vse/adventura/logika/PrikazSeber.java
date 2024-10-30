package cz.vse.adventura.logika;

/**
 *Třída PrikazSeber implementuje pro hru příkaz seber.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazSeber implements IPrikaz{

    private static final String NAZEV = "seber";
    private final HerniPlan herniPlan;
    private final Batoh batoh;

    /**
     * Konstruktor třídy
     * @param herniPlan
     * @param batoh
     */
    public PrikazSeber(HerniPlan herniPlan, Batoh batoh) {
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevim, co mam sebrat.";
        } else if (parametry.length != 1) {
            return "Není možné sebrat na jednou více věcí. Specifikuj pouze jednu.";
        }

        String nazevVeci = parametry[0];
        Prostor prostor = herniPlan.getAktualniProstor();
        if (!prostor.vecExistuje(nazevVeci)) {
            //V prostoru věc není
            return "Věc " + nazevVeci + " v prostoru není!";
        }

        if ((batoh.getVeci().size() + 1) > batoh.getKapacitaBatohu()) {
            //Kapacita batohu byla překročena
            return "Byla překročená kapacita batohu, věc " + nazevVeci + " již nelze přidat!";
        }

        Vec vec = prostor.ziskejVec(nazevVeci);

        if (vec.isSebratelnost()) {
            prostor.odstranVec(nazevVeci);
            batoh.pridejVecDoBatohu(nazevVeci);

            //Věc byla sebrána
            return "Sebral jsi věc " + nazevVeci + "!";
        }

        //Věc nelze přenést z místnosti
        return "Tuto věc není možné přenést.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }



}
