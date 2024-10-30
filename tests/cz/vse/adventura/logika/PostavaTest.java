package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Testovací třída HracTest slouží ke komplexnímu otestování třídy.
 * Hrac
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PostavaTest {

    private Postava postava;
    private Hrac hrac;
    private Nepritel nepritel;

    @Before
    public void setUp() {
        Batoh batoh = new Batoh(1);
        postava = new Postava("postava",1,1,10);
        hrac = new Hrac(1,1,1, batoh);
        nepritel = new Nepritel("nepřítel",1,1,1);
    }

    /**
     * Test slouží k ověření, zda-li se odeberou životy, při souboji.
     */
    @Test
    public void testOdeberŽivoty() {
        //Odebere životy
        postava.odeberZivoty(nepritel);

        //Ověření zda-li životy byly odebrány
        Assert.assertThat(postava.getPocetZivotu(), is(10));
    }
}
