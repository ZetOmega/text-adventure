public class Ausruestung extends Gegenstand {
    private int nutzen;

    public Ausruestung(String pName, String pBeschreibung, int pNutzen) {
        super(pName, pBeschreibung);
        nutzen = pNutzen;
    }
    
    public int gibNutzen() {
        return nutzen;
    }
}
