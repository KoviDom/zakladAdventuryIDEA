package cz.vse.adventura.logika;


import java.util.HashMap;
import java.util.Map;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Map<String, Vec> veci;
    private Map<String, Nepritel> nepritel;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        veci = new HashMap<>();
        nepritel = new HashMap<>();
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor klec = new Prostor("klec", "Po omráčení od teroristy ses probudil a rozhlídnul se kolem sebe, kde jsi. Zjistil jsi, že jsi v zamčené kleci a bez svých věcí, ale pobliž tvoji klecy jsi uviděl svůj nůž a rozhodl ses, že se ti může hodit.\nPokud to sebereš a použiješ dokážeš odemknout zámek od kleci.", false);
        Prostor jeskyne = new Prostor("jeskyne", "Poté co jsi se dostal ven a sebral jsi pistoli i zapalovač, ses podíval po okolí jsi zjistil, že se můžeš vydat buď do tunelu nebo jít k východu do jeskyně.\nTeď je tvoje rozhodnutí na tobě.");
        Prostor vychodZJeskyne = new Prostor("vychod_z_jeskyne", "Po vítězství proti teroristovi (doporucuji sebrat jeho pistol) se procházíš po jeskyni, vidíš východ a jdeš do lesa.\n");
        Prostor tunel = new Prostor("tunel","Šel jsi do tunelu, ale v tunelu je strašná tma, ale v batohu máš zapalovač.\nPoužij zapalovač a tím pádem se bezpečně dostaneš na druhou stranu do chalupy.");
        Prostor chalupa = new Prostor("chalupa","Po konci tunelu vidíš chalupu, ve které vidíš, že se tam svítí, ale dávej pozor může tam být nepřítel.\nPoté můžeš jít lesem. ale nejprve si vem radší bundu, která ti přidá i nějaké dobré obranné staty. K tomu po souboji s bezdomovcem si můžeš vzít pistoli pro všechny případy (velice to doporučuji).");
        Prostor les = new Prostor("les","Šel jsi do lesa a zjistil jsi, že je venku strašná zima a tma.\nPoté, co sis obléknul bundu (z chalupy) jsi šel směrem k potoku.");
        Prostor potok = new Prostor("potok","Vyšel jsi z lesa k potoku a objevil jsi rybu, můžeš ji sebrat a hned sníst a doplnit si životy. Rozhlížíš se kolem sebe a vidíš dvě cesty, jedna vede k údolí a druhá k jezeru.\nRozhodnutí je na tobě, kam půjdeš.");
        Prostor udoli = new Prostor("udoli","Zvítězil jsi nad vlkem!\nNyní můžeš vstoupit do města a budeš v bezpečí.");
        Prostor jezero = new Prostor("jezero","Zvítězil jsi nad medvědem!\nNyní můžeš vstoupit do města a budeš v bezpečí.");
        Prostor mesto = new Prostor("mesto","");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        klec.setVychod(jeskyne);
        jeskyne.setVychod(vychodZJeskyne);
        jeskyne.setVychod(tunel);
        vychodZJeskyne.setVychod(les);
        vychodZJeskyne.setVychod(jeskyne);
        tunel.setVychod(chalupa);
        tunel.setVychod(jeskyne);
        chalupa.setVychod(tunel);
        chalupa.setVychod(les);
        les.setVychod(potok);
        les.setVychod(vychodZJeskyne);
        les.setVychod(chalupa);
        potok.setVychod(les);
        potok.setVychod(jezero);
        potok.setVychod(udoli);
        jezero.setVychod(potok);
        jezero.setVychod(udoli);
        jezero.setVychod(mesto);
        udoli.setVychod(potok);
        udoli.setVychod(jezero);
        udoli.setVychod(mesto);

        // pridavani veci
        Vec bunda = new Vec("bunda",true,0,5,5);
        chalupa.pridejVec(bunda);
        this.pridejVec(bunda);
        Vec zapalovac = new Vec("zapalovac",true,5,0,5);
        jeskyne.pridejVec(zapalovac);
        this.pridejVec(zapalovac);
        Nuz nuz = new Nuz("nuz",true,10,0,0, klec);
        klec.pridejVec(nuz);
        this.pridejVec(nuz);
        Vec ryba = new Vec("ryba", true,0,20,0);
        potok.pridejVec(ryba);
        this.pridejVec(ryba);
        Vec pistol = new Vec("pistol",true,25,0,0);
        jeskyne.pridejVec(pistol);
        vychodZJeskyne.pridejVec(pistol);
        chalupa.pridejVec(pistol);
        this.pridejVec(pistol);
        Vec brokovnice = new Vec("brokovnice", true,50,0,0);
        vychodZJeskyne.pridejVec(brokovnice);
        this.pridejVec(brokovnice);

        // pridavani postav(nepratel)
        Nepritel terorista = new Nepritel("terorista",10,20,10);
        vychodZJeskyne.setNepritel(terorista);
        this.pridejNepritele(terorista);
        Nepritel vlk = new Nepritel("vlk",30,20,10);
        udoli.setNepritel(vlk);
        this.pridejNepritele(vlk);
        Nepritel medved = new Nepritel("medved",50,30,20);
        jezero.setNepritel(medved);
        this.pridejNepritele(medved);
        Nepritel bezdomovec = new Nepritel("bezdomovec",10,10,10);
        chalupa.setNepritel(bezdomovec);
        this.pridejNepritele(bezdomovec);

        aktualniProstor = klec;  // hra začíná v jeskyni
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    public void pridejVec(Vec vec) {
        veci.put(vec.getNazev(), vec);
    }

    public Vec ziskejVec(String nazevVeci) {
        return veci.get(nazevVeci);
    }

    public void odstranVec(String nazevVeci) {
        veci.remove(nazevVeci);
    }

    public void pridejNepritele(Nepritel nepritel) {
        this.nepritel.put(nepritel.getNazev(), nepritel);
    }

    public Nepritel ziskejNepritele(String nazevPostavy) {
        return nepritel.get(nazevPostavy);
    }

    public void odstranNepritele(String nazevNepritele) {
        nepritel.remove(nazevNepritele);

        Prostor prostor = getAktualniProstor();
        prostor.setNepritel(null);
    }
}
