public class Raum {
  private String name;
  private String beschreibung;
  private Raum[] nachbarn;
  private List<Gegenstand> belohnung;
  private List<Gegenstand> voraussetzungen;
  private List<Gegner> gegner;
  private List<NPC> charaktere;

  public Raum(String pName, String pBeschreibung, Gegenstand[] pBelohnung, Gegenstand[] pVoraussetzungen, 
                     Gegner[] pGegner, NPC[] pCharaktere) {
    name = pName;
    beschreibung = pBeschreibung;
    nachbarn = new Raum[4];
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
    belohnung = new List<Gegenstand>();
    for(Gegenstand neueBelohnung : pBelohnung) {
      charaktere.append(neueBelohnung);
    }
  }

  public void setzeName(String pName) {
    name = pName;
  }

  public void setzeBeschreibung(String pBeschreibung) {
    beschreibung = pBeschreibung;
  }

  public void setzeNachbar(Raum pRaum, int pRichtung) {
    nachbarn[pRichtung] = pRaum;
  }

  public void setzeNachbarn(Raum[] pRaeume, int[] pRichtungen) {
    for(int i = 0; i < pRaeume.length; i++) {
      nachbarn[pRichtungen[i]] = pRaeume[i];
    }
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

  public Gegenstand[] gibBelohnung(){
    return belohnung;
  }

  public Raum[] gibNachbarn() {
    return nachbarn;
  }

  public Raum gibNachbar(int pRichtung) {
    return nachbarn[pRichtung];
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
    Gegenstand[] voraussetzungenArr = new Gegenstand[voraussetzungen.size()];
    voraussetzungen.toFirst();
    for(int i = 0; i < voraussetzungen.size(); i++) {
      voraussetzungenArr[i] = voraussetzungen.getContent();
      voraussetzungen.next();
    }
    String voraussetzungenText = 
    "Voraussetzungen--------------\n";
    for(int i = 0; i < voraussetzungenArr.length; i++) {
      voraussetzungenText += voraussetzungenArr[i].gibName();
      if(i < voraussetzungenArr.length - 1) {
        voraussetzungenText += "\n";
      }
    }
    return 
    "Name: " + name + "\n" +
    "Beschreibung: " + beschreibung + "\n" +
    voraussetzungenText;
  }

  public String gibNachbarinformationen() {
    return nachbarn[0].gibInformationen() + "\n" +
           nachbarn[1].gibInformationen() + "\n" +
           nachbarn[2].gibInformationen() + "\n" +
           nachbarn[3].gibInformationen() + "\n";
  }
}
