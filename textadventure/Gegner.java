public class Gegner extends NPC {
  private int lp;
  private int angriff;
  private Ruestung ruestung;
  private Waffe waffe;

  public Gegner(String pName, String pBeschreibung, Ausruestung pBelohnung, int pLp,
    Waffe pWaffe, Ruestung pRuestung, int pAngriff) {
    super(pName, pBeschreibung, pBelohnung);
    lp = pLp;
    angriff = pAngriff;
    ruestung = pRuestung;
    waffe = pWaffe;
  }

  @Override public String zeigeInformationenAn() {
    String ausgabe = super.zeigeInformationenAn();
    ausgabe += "LP: " + lp + "\n";
    ausgabe += "Ruestung: " + ruestung + "\n";
    ausgabe += "Waffe: " + waffe + "\n";
    ausgabe += "Angriff: " + angriff + "\n";
    return ausgabe;
  }
    
  public void nimmSchaden(int pSchaden) {
    if(lp - pSchaden < 0) {
      lp = 0;
    } else {
      lp -= pSchaden;
    }
  }
    
  public int gibLP() {
    return lp;
  }
    
  public Ruestung gibRuestung() {
    return ruestung;  
  }
    
  public Waffe gibWaffe() {
    return waffe;  
  }
    
  public int gibAngriff() {
    return angriff;
  }

  public void setzeRuestung(Ruestung pRuestung) {
    ruestung = pRuestung;
  }
    
  public void setzeWaffe(Waffe pWaffe) {
    waffe = pWaffe;
  }
    
  public boolean istTot() {
    return lp ==0;
  }
}
