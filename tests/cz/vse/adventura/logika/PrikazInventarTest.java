package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * Testovací třída PrikazInventarTest slouží ke komplexnímu otestování třídy.
 * PrikazInventar
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazInventarTest {

    private Batoh batoh;
    private PrikazInventar prInventar;

    @Before
    public void setUp() {
        batoh = new Batoh(1);
        prInventar = new PrikazInventar(batoh);
    }

    /**
     * Test slouží k ověření, zda-li se vypisuje správné info z inventáře.
     * Pokud je batoh prazdný, výpis obsahuje: Batoh je prázdný!
     * Pokud je v batohu věc, výpis obsahuje: Věci v batohu:
     */
    @Test
    public void testProvedPrikaz() {
        //Pokud je batoh prázdný
        Assert.assertThat(prInventar.provedPrikaz("inventar"), containsString("Batoh je prázdný!"));

        //Přidá věc do batohu
        batoh.pridejVecDoBatohu("vec");
        //Pokud je v batohu věc, změní se hláška
        Assert.assertThat(prInventar.provedPrikaz("inventar"), containsString("Věci v batohu: vec"));
    }
}
