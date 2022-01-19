public class Rucksack{

    List<Gegenstand> inhalt = new List<Gegenstand>();
    
    public Rucksack(){  

    }

    public Gegenstand gibAktuellesItem()   {

        return inhalt.getContent();
    }

    public String gibNameAktuellesItem()   {

        return inhalt.getContent().gibName();
    }

    public String gibBeschreibungAktuellesItem()   {

        return inhalt.getContent().gibBeschreibung();
    }

    public void naechstesItem() {

        inhalt.next();
    }

    public void letztesItem()   {

        inhalt.toLast();
    }

    public void neuesItem(String name, String beschreibung)  {

        inhalt.append(new Gegenstand(name, beschreibung) );//TODO fixen

    }
    
}
