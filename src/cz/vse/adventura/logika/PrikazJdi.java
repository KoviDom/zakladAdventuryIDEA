package cz.vse.adventura.logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */
    public PrikazJdi(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        if (!plan.getAktualniProstor().isOpustitelny()) {
            return "V tuto chvíli se odtud nedostanu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        //Ověření, zda-li sousední prostor je k dispozici
        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        }
        //Podmínka, pokud se v místnosti nachází nepřítel
        if (plan.getAktualniProstor().getNepritel() != null) {
            return "Při souboji nelze jít do jiné místnosti";
        }

        plan.setAktualniProstor(sousedniProstor);

        //Ověření, zda-li není prostor město, pokud ano, tak nastane konec hry
        if(plan.getAktualniProstor().getNazev().equals("mesto")) {
            hra.setKonecHry(true);

            return  this.vratVítěznýEpilog() + "\n \n";
        }

        //Ověření, zda-li je v místnosti souboj
        if(plan.getAktualniProstor().getNepritel() == null) {
            return sousedniProstor.dlouhyPopis();
        }
        else {
            return plan.getAktualniProstor().bojovyPopis();
        }
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

    /**
     * Metoda vrací vítěznou zprávu pro hráče
     */
    public String vratVítěznýEpilog() {
        return "Úspěšně jsi dokončil svoji cestu z jeskyně a došel jsi do bezpečí. \n" +
                "Doufej, že nic podobného se ti nepřihodí znova.";
    }

}
