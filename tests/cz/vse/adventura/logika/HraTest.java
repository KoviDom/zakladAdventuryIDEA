package cz.vse.adventura.logika;

import cz.vse.adventura.logika.Hra;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        //Kontrola místnosti
        assertEquals("klec", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("seber nuz");

        //Kontrola zda-li věc byla sebrána
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(1));

        hra1.zpracujPrikaz("pouzij nuz");
        //Kontrola zda-li věc byla použita
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(0));

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi jeskyne");
        assertEquals("jeskyne", hra1.getHerniPlan().getAktualniProstor().getNazev());

        //Kontrola zda-li věc byla sebrána
        hra1.zpracujPrikaz("seber zapalovac");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(1));

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi tunel");
        assertEquals("tunel", hra1.getHerniPlan().getAktualniProstor().getNazev());

        //Použití věci.
        hra1.zpracujPrikaz("pouzij zapalovac");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(0));

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi chalupa");
        assertEquals("chalupa", hra1.getHerniPlan().getAktualniProstor().getNazev());

        //Použití věci.
        hra1.zpracujPrikaz("pouzij pistol");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(0));

        //Boj
        hra1.zpracujPrikaz("bojuj terorista");

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi chalupa");
        assertEquals("chalupa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("seber bunda");

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi les");
        assertEquals("les", hra1.getHerniPlan().getAktualniProstor().getNazev());

        //Použití věci.
        hra1.zpracujPrikaz("pouzij bunda");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(0));

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi potok");
        assertEquals("potok", hra1.getHerniPlan().getAktualniProstor().getNazev());

        //Sebrání a použití věci
        hra1.zpracujPrikaz("seber ryba");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(1));
        hra1.zpracujPrikaz("pouzij ryba");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(0));

        //Kontrola místnosti
        hra1.zpracujPrikaz("jdi udoli");
        assertEquals("udoli", hra1.getHerniPlan().getAktualniProstor().getNazev());

        //Použití věci.
        hra1.zpracujPrikaz("pouzij pistol");
        Assert.assertThat(hra1.getHrac().getBatoh().getVeci().size(), is(0));

        //Boj
        hra1.zpracujPrikaz("bojuj vlk");
        hra1.zpracujPrikaz("bojuj vlk");

        //Přechod místnosti
        hra1.zpracujPrikaz("jdi mesto");

        //Kontrola dohrání hry
        assertEquals(true, hra1.konecHry());
    }
}
