package cz.vse.adventura.logika;

import cz.vse.adventura.logika.Hra;
import cz.vse.adventura.logika.PrikazJdi;
import cz.vse.adventura.logika.PrikazKonec;
import cz.vse.adventura.logika.SeznamPrikazu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy  
 * SeznamPrikazu
 * 
 * @author    Luboš Pavlíček
 * @version   pro školní rok 2016/2017
 */
public class SeznamPrikazuTest
{
    private Hra hra;
    private Batoh batoh;
    private Hrac hrac;
    private PrikazKonec prKonec;
    private PrikazJdi prJdi;
    private PrikazSeber prSeber;
    private PrikazInfo prInfo;

    @Before
    public void setUp() {
        hra = new Hra();
        batoh = new Batoh(1);
        hrac = new Hrac(100,1000,100,batoh);
        prKonec = new PrikazKonec(hra);
        prSeber = new PrikazSeber(hra.getHerniPlan(), batoh);
        prJdi = new PrikazJdi(hra.getHerniPlan(), hra);
        prInfo = new PrikazInfo(hrac);
    }

    @Test
    public void testVlozeniVybrani() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prSeber);
        seznPrikazu.vlozPrikaz(prInfo);

        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        assertEquals(null, seznPrikazu.vratPrikaz("napoveda"));
        assertEquals(prInfo, seznPrikazu.vratPrikaz("info"));
        assertEquals(null, seznPrikazu.vratPrikaz("inventar"));
        assertEquals(null, seznPrikazu.vratPrikaz("bojuj"));
        assertEquals(prSeber, seznPrikazu.vratPrikaz("seber"));
        assertEquals(null, seznPrikazu.vratPrikaz("pouzij"));
    }
    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prSeber);
        seznPrikazu.vlozPrikaz(prInfo);

        assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("jdi"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("napoveda"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("info"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("inventar"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Inventar"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("bojuj"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("seber"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }

    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prSeber);

        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(true, nazvy.contains("seber"));
    }
    
}
