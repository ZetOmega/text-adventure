public class Ruestung extends Gegenstand {
    private int def;

    public Ruestung(String pName, String pBeschreibung, int pDef) {
        super(pName, pBeschreibung);
        def = pDef;
    }

    public int gibVerteidigung() {
        return def;
    }
}
