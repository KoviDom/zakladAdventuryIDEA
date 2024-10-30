package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

/**
 * Testovací třída PrikazBojujTest slouží ke komplexnímu otestování třídy.
 * PrikazBojuj
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazBojujTest {

    private Batoh batoh;
    private Hrac hrac;
    private Hra hra;

    @Before
    public void setUp() {
        batoh = new Batoh(1);
        hrac = new Hrac(20,5,10,batoh);
        hra = new Hra();
    }

    /**
     * Test slouží k ověření zda-li se vypisují správné hlášky pří provádění příkazu bojuj.
     * Kontrola: Existence nepřítele, prohra v souboji a následný konec hry.
     */
    @Test
    public void testProvedPrikaz() {
        //Přesune hráče do vychodu z jeskyne a ověří zda-li tam skutečně je
        hra.zpracujPrikaz("jdi vychod_z_jeskyne");
        assertEquals("vychod_z_jeskyne", hra.getHerniPlan().getAktualniProstor().getNazev());

        //Kontrola jestli nepřítel je v prostoru
        Assert.assertEquals("Protivník [nepřítel] v prostoru není!", hra.zpracujPrikaz("bojuj nepřítel"));

        //Příkazy pro boj a ověření vypsané hlášky
        Assert.assertThat(hra.zpracujPrikaz("bojuj terorista"), containsString("Útok proveden:"));
        Assert.assertThat(hra.zpracujPrikaz("bojuj terorista"), containsString("Útok proveden:"));
        Assert.assertThat(hra.zpracujPrikaz("bojuj terorista"), containsString("Útok proveden:"));
        Assert.assertThat(hra.zpracujPrikaz("bojuj terorista"), containsString("Útok proveden:"));

        //Ověření, zda-li nastane konec, pokud hráč prohraje
        Assert.assertEquals("Protivník terorista tě porazil!", hra.zpracujPrikaz("bojuj terorista"));

        //Hra konci po prohranem souboji
        assertEquals(true, hra.konecHry());
    }
}
