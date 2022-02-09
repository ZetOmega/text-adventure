public class Spieler {
  private int lp;
  private String name;
  private String beschreibung;
  private Ruestung ruestung;
  private Waffe waffe;
  private int i[] = new int[6];
  
  public Spieler(int pLp, Waffe pWaffe, String pName, String pBeschreibung) {
    lp = pLp;
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

  public void machSchaden(){
    Random random = new Random();
     
        
        for(int k = 0; k < )
        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
  }

  public int gibLp() {
    return lp;
  }

  public int gibSchaden() {
    return waffe.gibSchaden();
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
