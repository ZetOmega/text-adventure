
/**
 * Beschreiben Sie hier die Klasse Ruestung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ausruestung extends Gegenstand
{
    private int nutzen;

    /**
     * Konstruktor für Objekte der Klasse Ruestung
     */
    public Ausruestung(String pName, String pBeschreibung, int pNutzen)
    {
        super(pName, pBeschreibung);
        nutzen = pNutzen;
    }

    
    public int gibNutzen()
    {
        return nutzen;
    }
}
