public class Waffe extends Gegenstand {
    private int schaden;

    public Waffe(String pName, String pBeschreibung, int pSchaden) {
        super(pName, pBeschreibung);
        schaden = pSchaden;
    }

    public int gibSchaden() {
        return schaden;
    }
}
