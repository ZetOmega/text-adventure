
/**
 * Write a description of class Gegner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gegner extends NPC
{
    private int lp;
    //private Gegenstand ausruestung;
    //private Gegenstand waffe;
    private int angriff;
    /**
     * Constructor for objects of class Gegner
     */
    public Gegner(String pName, String pBeschreibung, String pBelohnung, int pLp,
    int pAngriff)
    {
      super(pName, pBeschreibung, pBelohnung);
      lp = pLp;
      //ausruestung = pAusruestung;
      //waffe = pWaffe;
      angriff = pAngriff;
    }

    /**
     * 
     */
    @Override public String zeigeInformationenAn()
    {
      String ausgabe = super.zeigeInformationenAn();
      ausgabe += "LP: " + lp + "\n";
      //ausgabe += "Auruestung: " + ausruestung + "\n";
      //ausgabe += "Waffe: " + waffe + "\n";
      ausgabe += "Angriff: " + angriff + "\n";
      return ausgabe;
    }
    
    public void nimmSchade(int pSchaden){
        lp -= pSchaden;
    }
    
    public int greifeAn(){
        return 0;
    }
    
    public int gibLP(){
        return lp;
    }
    
    //public Gegenstand gibAusruestung(){
    //  return ausruestung;  
    //}
    
    //public Gegenstand gibWaffe(){
    //  return waffe;  
    //}
    
    public int gibAngriff(){
        return angriff;
    }
    
    //public void setzteAusruestung(Gegenstand neueAusruestung){
    //  ausruestung = neueAustruestung;
    //}
    
    //public void setzteWaffe(Gegenstand neueWaffe){
    //  waffe = neueWaffe;
    //}
    
    public boolean istTot(){
        if(lp <= 0){
            return true;
        } else{
            return false;
        }
        }

}
