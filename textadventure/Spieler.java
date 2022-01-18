public class Spieler {
  private int lp;
  private int atk;
  private String name;
  private String beschreibung;
  private Ruestung ruestung;
  private Waffe waffe;
  
  public Spieler(int pLp, int pAtk, String pName, String pBeschreibung) {
    lp = pLp;
    atk = pAtk;
    name = pName;
    beschreibung = pBeschreibung;
    ruestung = null;
    waffe = null;
  }

  public void nimmSchaden(int pSchaden) {
    if(lp - pSchaden < 0) {
      lp = 0;
    } else {
      lp -= pSchaden;
    }
  }

  public int gibLp() {
    return lp;
  }

  public int machSchaden() {
    return atk;
  }

  public void erhoeheAtk(int pStaerke) {
    atk += pStaerke;
  }

  public int gibAtk() {
    return atk;
  }  

  public String gibName() {
    return name;
  }

  public String gibBeschreibung() {
    return beschreibung;
  }

  public Ruestung gibRuestung() {
    return ruestung;
  }

  public boolean hatRuestung() {
    return ruestung != null;
  }

  public Waffe gibWaffe() {
    return waffe;
  }

  public boolean hatWaffe() {
    return waffe != null;
  }

  public void setzeWaffe(Waffe pWaffe) {
    waffe = pWaffe;
  }

  public void setzeRuestung(Ruestung pRuestung) {
    ruestung = pRuestung;
  }

  public boolean istTot() {
    return lp == 0;
  }
}
