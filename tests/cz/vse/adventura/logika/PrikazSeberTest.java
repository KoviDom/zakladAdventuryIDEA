package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovací třída PrikazSeberTest slouží ke komplexnímu otestování třídy.
 * PrikazSeber
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazSeberTest {

    private Batoh batoh;
    private PrikazSeber prSeber;
    private PrikazJdi prJdi;
    private Hra hra;

    @Before
    public void setUp() {
        batoh = new Batoh(1);
        hra = new Hra();
        prSeber = new PrikazSeber(hra.getHerniPlan(), batoh);
        prJdi = new PrikazJdi(hra.getHerniPlan(), hra);
    }

    /**
     * Test slouží k ověření, zda-li se vypisují správné hlášky pří provádění příkazu seber.
     * Kontrola: sebrání, kapacita batohu, existence věci v prostoru.
     */
    @Test
    public void testProvedPrikaz() {
        //Věc není v prostoru
        Assert.assertEquals("Věc vec v prostoru není!", prSeber.provedPrikaz("vec"));

        //Věc sebrána
        Assert.assertEquals("Sebral jsi věc pistol!", prSeber.provedPrikaz("pistol"));

        //Nachystání prostoru s rybou.
        Prostor prostor = new Prostor("prostor", "popis");
        String ryba = "ryba";
        prostor.pridejVec(new Vec(ryba, true, 0, 0, 0));
        hra.getHerniPlan().setAktualniProstor(prostor);

        batoh.setKapacitaBatohu(0);
        //Věc nelze sebrat kvůli překročené kapacitě
        Assert.assertEquals("Byla překročená kapacita batohu, věc " + ryba + " již nelze přidat!", prSeber.provedPrikaz(ryba));
    }
}
