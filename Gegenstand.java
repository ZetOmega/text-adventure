public class Gegenstand {
    private String name;
    private String beschreibung;

    public Gegenstand(String pName, String pBeschreibung) {
        name = pName;
        beschreibung = pBeschreibung;
    }

    public String gibName() {
        return name;
    }
    
    public String gibBeschreibung() {
        return beschreibung;
    }
}
