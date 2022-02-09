public class NPC {
    private String name;
    private String beschreibung;
    private Gegenstand belohnung;

    public NPC(String pName, String pBeschreibung, Gegenstand pBelohnung) {
        name = pName;
        beschreibung = pBeschreibung;
        belohnung = pBelohnung;
    }
    
    public String zeigeInformationenAn() {
        String ausgabe = "Name: " + name + "\n";
        ausgabe += "Beschreibung: " + beschreibung + "\n";
        ausgabe += "Belohnung: " + belohnung + "\n";
        return ausgabe;
    }

    public String gibName() {
        return name;
    }
    
    public String gibBeschreibung() {
        return beschreibung;
    }
    
    public Gegenstand gibBelohnung() {
        return belohnung;
    }

    public void setzeBelohnung(Gegenstand pBelohnung) {
        belohnung = pBelohnung;
    }
}
