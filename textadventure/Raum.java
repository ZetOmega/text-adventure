public class Raum {
    private String name;
    private String beschreibung;
    private Raum[] nachbarn;
    private Gegenstand[] voraussetzungen;
    private Gegner[] gegner;
    private NPC[] charaktere;

    public Raum(String pName, String pBeschreibung, Raum[] pNachbarn, 
                Gegenstand[] pVoraussetzungen, Gegner[] pGegner, NPC[] pCharaktere) {
        name = pName;
        beschreibung = pBeschreibung;
        nachbarn = pNachbarn;
        voraussetzungen = pVoraussetzungen;
        gegner = pGegner;
        charaktere = pCharaktere;            
    }

    public void setzeName(String pName) {
        name = pName;
    }

    public void setzeBeschreibung(String pBeschreibung) {
        beschreibung = pBeschreibung;
    }

    public void setzeNachbarn(Raum[] pNachbarn) {
        nachbarn = pNachbarn;
    }

    public void setzeNachbar(int pRichtung, Raum nachbar) {
        nachbarn[pRichtung] = nachbar;
    }

    public void setzeVoraussetzungen(Gegenstand[] pVoraussetzungen) {
        voraussetzungen = pVoraussetzungen;
    }

    public void setzeGegner(Gegner[] pGegner) {
        gegner = pGegner;
    }

    public void setzeCharaktere(NPC[] pCharaktere) {
        charaktere = pCharaktere;
    }

    public String gibName() {
        return name;
    }

    public String gibBeschreibung() {
        return beschreibung;
    }

    public Raum[] gibNachbarn() {
        return nachbarn;
    }

    public Raum gibNachbar(int pRichtung) {
        return nachbarn[pRichtung];
    }

    public Gegenstand[] gibVoraussetzungen() {
        return voraussetzungen;
    }

    public Gegner[] gibGegner() {
        return gegner;
    }

    public NPC[] gibCharaktere() {
        return charaktere;
    }

    public String gibInformationen() {
        String voraussetzungenText = 
        "Voraussetzungen--------------\n";
        for(int i = 0; i < voraussetzungen.length; i++) {
            voraussetzungenText += voraussetzungen[i].gibName();
            if(i < voraussetzungen.length - 1) {
                voraussetzungenText += "\n";
            }
        }
        return 
        "Name: " + name + "\n" +
        "Beschreibung: " + beschreibung + "\n" +
        voraussetzungenText;
    }

    public String gibNachbarinformationen() {
        return 
        nachbarn[0].gibInformationen() + "\n" +
        nachbarn[1].gibInformationen() + "\n" +
        nachbarn[2].gibInformationen() + "\n" +
        nachbarn[3].gibInformationen();
    }
}
