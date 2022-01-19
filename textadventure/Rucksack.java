public class Rucksack {
    private int kapazitaet;
    private List<Gegenstand> items = new List<Gegenstand>();
    
    public Rucksack() {  
        kapazitaet = 1;
    }

    public Gegenstand gibAktuellesItem() {
        return items.getContent();
    }

    public String gibNameAktuellesItem() {
        return items.getContent().gibName();
    }

    public String gibBeschreibungAktuellesItem() {
        return items.getContent().gibBeschreibung();
    }

    public void naechstesItem() {
        items.next();
    }

    public void letztesItem() {
        items.toLast();
    }

    public void neuesItem(String name, String beschreibung)  {
        items.append(new Gegenstand(name, beschreibung));
    }

    public boolean istVoll() {
        return items.size() >= kapazitaet;
    }
}
