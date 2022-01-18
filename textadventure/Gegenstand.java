
/**
 * Beschreiben Sie hier die Klasse Gegenstand.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Gegenstand
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name;
    private String beschreibung;

    /**
     * Konstruktor für Objekte der Klasse Gegenstand
     */
    public Gegenstand(String pName, String pBeschreibung)
    {
        name = pName;
        beschreibung = pBeschreibung;
    }

    
    public String gibName()
    {
        return name;
    }
    
    public String gibBeschreibung()
    {
        return beschreibung;
    }
}
