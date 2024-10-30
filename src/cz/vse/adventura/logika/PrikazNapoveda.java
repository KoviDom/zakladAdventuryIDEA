package cz.vse.adventura.logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 *  
 */
class PrikazNapoveda implements IPrikaz {
    
    private static final String NAZEV = "napoveda";
    private SeznamPrikazu platnePrikazy;
    
    
     /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů,
    *                       které je možné ve hře použít,
    *                       aby je nápověda mohla zobrazit uživateli. 
    */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je dostat se z jeskyně do města. Cestou můžeš nacházet různé věci (předměty), které sebereš příkazem [seber 'název věci'].\n"
        + "Věci se ti poté uloží do inventáře, který lze vypsat příkazem [inventar]). Pokud budeš chtít věc použít, napiš do vstupu příkaz [pouzij 'název věci'].\n"
        + "Pokud si budeš chtít vypsat svoje statistiky, napiš příkaz [info]. K procházením místností slouží příkaz [jdi 'název místnosti'].\n"
        + "Při hraní hry lze také potkat různé nepřátelé. Při tomto setkání budeš muset nepřítele porazit. Na nepřítele zaútočíš příkazem [bojuj 'název nepřítele'].\n"
        + "Jestli budeš chtít hru ukončit, zadej příkaz [konec].\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
    }
    
     /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
      public String getNazev() {
        return NAZEV;
     }

}
