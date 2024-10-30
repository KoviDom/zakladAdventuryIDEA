package cz.vse.adventura.logika;

/**
 * Třída PrikazBojuj implementuje pro hru příkaz nápověda.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Dominik Kováč
 * @version pro školní rok 2020/2021
 */
public class PrikazBojuj implements IPrikaz{

    private static final String NAZEV = "bojuj";
    private final Hra hra;
    private final Hrac hrac;
    private final HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     * @param hra
     * @param hrac
     * @param herniPlan
     */
    public PrikazBojuj(Hra hra, Hrac hrac, HerniPlan herniPlan) {
        this.hra = hra;
        this.hrac = hrac;
        this.herniPlan = herniPlan;
    }

    /**
     * Provádí příkaz "bojuj". Hráč bojuje s protivníkem. Pokud protivník v prostoru
     * existuje, hráč na něj zaútočí. Pokud zadaný nepřítel v prostoru není vypíše se chybové hlášení.
     * Dále se ověřuje zda-li vyhrál hráč nebo protivník.
     * @param parametry počet parametrů závisí na konkrétním příkazu. (parametr obsahuje jméno nepřítele)
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            //Pokud není zadáno jméno nepřítele.
            return "Nevím s kým mám bojovat.";
        }

        String nazevPostavy = parametry[0];
        Nepritel nepritel = herniPlan.ziskejNepritele(nazevPostavy);

        String nazevNepritele = parametry[0];
        Prostor prostor = herniPlan.getAktualniProstor();

        if (prostor.getNepritel() == null) {
            //Pokud protivník v tomto prostoru není.
            return "V této místnosti nelze bojovat.";
        }

        if (!prostor.getNepritel().getNazev().equals(nazevNepritele)) {
            return "Protivník [" + nazevNepritele + "] v prostoru není!";
        }

        //Útok nepřítele a hráče
        this.hrac.odeberZivoty(nepritel);
        nepritel.odeberZivoty(this.hrac);

        if (this.hrac.getPocetZivotu() <= 0) {
            hra.setKonecHry(true);

            //Pokud hráč prohrál
            return "Protivník " + nepritel.getNazev() + " tě porazil!";
        }

        if (nepritel.getPocetZivotu() <= 0) {
            herniPlan.odstranNepritele(nepritel.getNazev());

            //Pokud nepřítel prohrál
            return "Protivník " +nepritel.getNazev() + " byl poražen! \n"
                    + "------------------------------------ \n"
                    + herniPlan.getAktualniProstor().dlouhyPopis();
        }

        //Info hlášení o průběhu souboje.
        return "Útok proveden: \n"
                + "Útokem proveden " + nepritel.getNazev() + " jsi mu ubral: " + (hrac.getSilaUtoku() - nepritel.getSilaObrany()) + " životů \n"
                + "Protivník [" + nepritel.getNazev() + "] ti svým útokem ubral: " + (nepritel.getSilaUtoku() - hrac.getSilaObrany()) + " životů \n"
                + "\n"
                + "--- Aktuální stav životů --- \n"
                + "Tvoje životy: " + hrac.getPocetZivotu() + "\n"
                + "Protivníkovi životy: " + nepritel.getPocetZivotu();
    }

    //------- Gettery
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
