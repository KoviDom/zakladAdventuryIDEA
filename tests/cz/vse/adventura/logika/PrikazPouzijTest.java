package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Testovací třída PrikazPouzijTest slouží ke komplexnímu otestování třídy
 * PrikazPouzij
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazPouzijTest {

    private Batoh batoh;
    private PrikazPouzij prPouzij;
    private PrikazSeber prSeber;
    private Hrac hrac;
    private Hra hra;

    @Before
    public void setUp() {
        batoh = new Batoh(1);
        hrac = new Hrac(10,30, 1,batoh);
        hra = new Hra();
        prSeber = new PrikazSeber(hra.getHerniPlan(), batoh);
        prPouzij = new PrikazPouzij(batoh, hrac, hra.getHerniPlan());
    }

    /**
     * Test slouží k ověření, zda-li se vypisují správné hlášky pří provádění příkazu použij.
     * Kontrola: Existence věci, použití a odebrání z batohu
     */
    @Test
    public void testProvedPrikaz() {
        //Věc není v batohu
        Assert.assertEquals("Věc zapalovac nebyla nalezena v batohu.", prPouzij.provedPrikaz("zapalovac"));

        //Věc použita
        Assert.assertEquals("Sebral jsi věc zapalovac!", prSeber.provedPrikaz("zapalovac"));
        Assert.assertEquals("Věc byla použita.", prPouzij.provedPrikaz("zapalovac"));

        //Kontrola odebrání věci z batohu
        Assert.assertThat(batoh.getVeci().size(), is(0));
    }
}
