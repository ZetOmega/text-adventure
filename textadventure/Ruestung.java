
/**
 * Beschreiben Sie hier die Klasse Ruestung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ruestung extends Gegenstand
{
    private int verteidigung;

    /**
     * Konstruktor für Objekte der Klasse Ruestung
     */
    public Ruestung(String pName, String pBeschreibung, int pVerteidigung)
    {
        super(pName, pBeschreibung);
        verteidigung = pVerteidigung;
    }

    
    public int gibVerteidigung()
    {
        return verteidigung;
    }
}
