package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy
 *
 * Batoh
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class BatohTest {

    private Batoh batoh;

    @Before
    public void setUp() {
        batoh = new Batoh(1);
    }

    /**
     * Test dokazuje, že lze přidat do Batohu věci, dokud je dostatečná kapacita.
     */
    @Test
    public void testPridejVecDoBatohu() {
        //Přídávání věcí do batohu
        batoh.pridejVecDoBatohu("vec1");
        batoh.pridejVecDoBatohu("vec2");

        //Kontrola velikosti kolekce věcí
        Assert.assertThat(batoh.getVeci().size(), is(1));
    }

    /**
     * Test dokazuje, ze lze odstranit věc z batohu.
     */
    @Test
    public void testOdstranVecZBatohu() {
        //Přidá a odstraní věc z batohu
        batoh.pridejVecDoBatohu("vec1");
        batoh.odstranVecZBatohu("vec1");

        //Kontrola velikosti kolekce věcí
        Assert.assertThat(batoh.getVeci().size(), is(0));
    }
}
