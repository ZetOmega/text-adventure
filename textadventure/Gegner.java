/**
 * Write a description of class Gegner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gegner extends NPC
{
    private int lp;
    private Ruestung ruestung;
    private Ausruestung ausruestung;
    private Waffe waffe;
    private int angriff;
    /**
     * Constructor for objects of class Gegner
     */
    public Gegner(String pName, String pBeschreibung, String pBelohnung, int pLp,
    Ausruestung pAusruestung, Waffe pWaffe, Ruestung pRuestung, int pAngriff)
    {
      super(pName, pBeschreibung, pBelohnung);
      lp = pLp;
      ausruestung = pAusruestung;
      ruestung = pRuestung;
      waffe = pWaffe;
      angriff = pAngriff;
    }

    /**
     * 
     */
    @Override public String zeigeInformationenAn()
    {
      String ausgabe = super.zeigeInformationenAn();
      ausgabe += "LP: " + lp + "\n";
      ausgabe += "Auruestung: " + ausruestung + "\n";
      ausgabe += "Ruestung: " + ruestung + "\n";
      ausgabe += "Waffe: " + waffe + "\n";
      ausgabe += "Angriff: " + angriff + "\n";
      return ausgabe;
    }
    
    public void nimmSchade(int pSchaden){
        lp -= pSchaden;
    }
    
    public int gibLP(){
        return lp;
    }
    
    public Ausruestung gibAusruestung(){
      return ausruestung;  
    }
    
    public Ruestung gibRuestung(){
      return ruestung;  
    }
    
    public Waffe gibWaffe(){
      return waffe;  
    }
    
    public int gibAngriff(){
        return angriff;
    }
    
    public void setzteAusruestung(Ausruestung neueAusruestung){
      ausruestung = neueAusruestung;
    }
    
    public void setzteRuestung(Ruestung neueRuestung){
      ruestung = neueRuestung;
    }
    
    public void setzteWaffe(Waffe neueWaffe){
      waffe = neueWaffe;
    }
    
    public boolean istTot(){
        if(lp <= 0){
            return true;
        } else{
            return false;
        }
        }

}
