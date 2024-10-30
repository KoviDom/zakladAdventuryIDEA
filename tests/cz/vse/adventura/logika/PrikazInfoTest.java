package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovací třída InfoTest slouží ke komplexnímu otestování třídy.
 * PrikazInfo
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazInfoTest {

    private Hrac hrac;
    private PrikazInfo prInfo;

    @Before
    public void setUp() {
        Batoh batoh = new Batoh(1);
        hrac = new Hrac(100,30, 10,batoh);
        prInfo = new PrikazInfo(hrac);
    }

    /**
     * Test slouží k ověření zda-li se vypisuje správné info o hráči
     */
    @Test
    public void testProvedPrikaz() {
        //Kontrola zda-li se vypíše správné info o hráči
        Assert.assertEquals(prInfo.provedPrikaz("info"), hrac.toString());
    }
}
