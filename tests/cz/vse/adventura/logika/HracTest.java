package cz.vse.adventura.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Testovací třída HracTest slouží ke komplexnímu otestování třídy.
 * <p>
 * Hráč
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class HracTest {

    private static final int POCET_ZIVOTU = 1;
    private static final int SILA_UTOKU = 2;
    private static final int SILA_OBRANY = 3;

    private Hrac hrac;

    @Before
    public void setUp() {
        Batoh batoh = new Batoh(1);
        hrac = new Hrac(POCET_ZIVOTU, SILA_UTOKU, SILA_OBRANY, batoh);
    }

    @Test
    public void zpracujVec() {
        // příprava
        final int hodnotaSilyUtoku = 2;
        final int hodnotaPoctuZivotu = 3;
        final int hodnotaSilyObrany = 4;
        final Vec vec = new Vec("vec", true, hodnotaSilyUtoku, hodnotaPoctuZivotu, hodnotaSilyObrany);

        // vykonání testované metody
        hrac.zpracujVec(vec);

        // ověření, že metoda fungovala správně
        Assert.assertThat(hrac.getSilaUtoku(), is(SILA_UTOKU + hodnotaSilyUtoku));
        Assert.assertThat(hrac.getPocetZivotu(), is(POCET_ZIVOTU + hodnotaPoctuZivotu));
        Assert.assertThat(hrac.getSilaObrany(), is(SILA_OBRANY + hodnotaSilyObrany));
    }
}
