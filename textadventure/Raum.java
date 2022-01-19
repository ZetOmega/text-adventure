public class Raum {
  private String name;
  private String beschreibung;
  private List<Raum> nachbarn;
  private List<Gegenstand> voraussetzungen;
  private List<Gegner> gegner;
  private List<NPC> charaktere;

  public Raum(String pName, String pBeschreibung, Gegenstand[] pVoraussetzungen, 
                     Gegner[] pGegner, NPC[] pCharaktere) {
    name = pName;
    beschreibung = pBeschreibung;
    nachbarn = new List<Raum>();
    voraussetzungen = new List<Gegenstand>();
    for(Gegenstand gegenstand : pVoraussetzungen) {
      voraussetzungen.append(gegenstand);
    }
    gegner = new List<Gegner>();
    for(Gegner neuerGegner : pGegner) {
      gegner.append(neuerGegner);
    }
    charaktere = new List<NPC>();
    for(NPC npc : pCharaktere) {
      charaktere.append(npc);
    }          
  }

  public void setzeName(String pName) {
    name = pName;
  }

  public void setzeBeschreibung(String pBeschreibung) {
    beschreibung = pBeschreibung;
  }

  public void fuegeNachbarnHinzu(List<Raum> pNachbarn) {
    nachbarn.concat(pNachbarn);
  }

  public void setzeNachbar(int pRichtung, Raum pNachbar) {
    nachbarn.toFirst();
    int count = pRichtung;
    while(nachbarn.hasAccess() && count >= 0) {
      count--;
      nachbarn.next();
    }
    nachbarn.insert(pNachbar);
  }

  public void fuegeVoraussetzungenHinzu(List<Gegenstand> pVoraussetzungen) {
    voraussetzungen.concat(pVoraussetzungen);
  }

  public void fuegeGegnerHinzu(List<Gegner> pGegner) {
    gegner.concat(pGegner);
  }

  public void fuegeCharaktereHinzu(List<NPC> pCharaktere) {
    charaktere.concat(pCharaktere);
  }

  public String gibName() {
    return name;
  }

  public String gibBeschreibung() {
    return beschreibung;
  }

  public List<Raum> gibNachbarn() {
    return nachbarn;
  }

  public Raum gibNachbar(int pRichtung) {
    int count = pRichtung;
    while(nachbarn.hasAccess() && count != 0) {
      count--;
      nachbarn.next();
    }
    return nachbarn.getContent();
  }

  public List<Gegenstand> gibVoraussetzungen() {
    return voraussetzungen;
  }

  public List<Gegner> gibGegner() {
    return gegner;
  }

  public List<NPC> gibCharaktere() {
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
