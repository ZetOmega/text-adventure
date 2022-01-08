
/**
 * @author(Marc Rennefort)
 * @version (5.1.2022)
 */
public class NPC
{
    // instance variables - replace the example below with your own
    private String name;
    private String beschreibung;
    private String belohnung;
    /**
     * Constructor for objects of class NPC
     */
    public NPC(String pName, String pBeschreibung, String pBelohnung)
    {
        name = pName;
        beschreibung = pBeschreibung;
        belohnung = pBelohnung;
    }
    
    public String zeigeInformationenAn(){
        String ausgabe = "Name: " + name + "\n";
        ausgabe += "Beschreibung: " + beschreibung + "\n";
        ausgabe += "Belohnung: " + belohnung + "\n";
        return ausgabe;
    }

    /**
     * 
     */
    public String gibName()
    {
        return name;
    }
    
    /**
     * 
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }
    
    /**
     * 
     */
    public String gibBelohnung()
    {
        return belohnung;
    }
}
