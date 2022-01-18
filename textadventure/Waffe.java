
/**
 * Beschreiben Sie hier die Klasse Ruestung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Waffe extends Gegenstand
{
    private int angriff;

    /**
     * Konstruktor für Objekte der Klasse Ruestung
     */
    public Waffe(String pName, String pBeschreibung, int pAngriff)
    {
        super(pName, pBeschreibung);
        angriff = pAngriff;
    }

    
    public int gibAngriff()
    {
        return angriff;
    }
}
