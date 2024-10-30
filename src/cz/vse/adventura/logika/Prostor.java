package cz.vse.adventura.logika;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private final Map<String, Vec> veci;
    private Nepritel nepritel;
    private boolean opustitelny;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this(nazev, popis, true);
    }

    public Prostor(String nazev, String popis, boolean opustitelny) {
        this.nazev = nazev;
        this.popis = popis;
        this.opustitelny = opustitelny;
        vychody = new HashSet<>();
        veci = new HashMap<>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }


    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + nazev + "\n"
                + popis + ".\n"
                + popisVychodu() + "\n"
                + popisVeci();
    }

    /**
     * Vrací bojový popis při účasti protivníka v dané místnosti.
     * @return Bojový popis
     */
    public String bojovyPopis() {
        return "Vstoupil jsi do " + this.nazev + "\n"
                + "Pro další postup v tvojí cestě budeš muset zdolat protivníka: " + this.nepritel.getNazev();
    }

    /**
     * Vrací textový řetězec, který popisuje postavy, například:
     * "postavy: medved ".
     *
     * @return Popis postavy - nazvy postav
     */
    private String popisNepratel() {
        String vracenyText = "nepritel: " + this.nepritel;

        return vracenyText;
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    private String popisVeci() {
        String vracenyText = "věci:";
        for (String nazevVeci : veci.keySet()) {
            vracenyText += " " + nazevVeci;
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /**
     * Metoda, která přidá věc do kolekce
     *
     * @param vec
     */
    public void pridejVec(Vec vec) {
        veci.put(vec.getNazev(), vec);
    }

    /**
     * Metoda, která kontroluje, zda-li věc existuje v kolekci
     *
     * @param nazevVeci
     * @return true/false
     */
    public boolean vecExistuje(String nazevVeci) {
        return veci.containsKey(nazevVeci);
    }

    /**
     * Metoda pro získání věci, z kolekce
     *
     * @param nazevVeci
     * @return Vec
     */
    public Vec ziskejVec(String nazevVeci) {
        return veci.get(nazevVeci);
    }

    /**
     * Metoda, pro odstranění věci z kolekce
     *
     * @param nazevVeci
     */
    public void odstranVec(String nazevVeci) {
        veci.remove(nazevVeci);
    }

    /**
     * Metodu, pro získání nepřítele z kolekce
     *
     * @return Nepritel
     */
    public Nepritel getNepritel() {
        return this.nepritel;
    }

    /**
     * getter isOpustitelny
     *
     * @return opustitelny
     */
    public boolean isOpustitelny() {
        return opustitelny;
    }

    /**
     * Metoda, pro ověření zda-li existuje nepřítel
     *
     * @param nazevNepritele
     * @return boolean
     */
    public boolean nepritelExistuje(String nazevNepritele) {
        if(this.nepritel.equals(nazevNepritele)) {
            return true;
        }

        return false;
    }

    //---- Settry ----
    public void setNepritel(Nepritel nepritel) {
        this.nepritel = nepritel;
    }

    public boolean setOpustitelny(boolean opustitelny) {
        return this.opustitelny = opustitelny;
    }
}
