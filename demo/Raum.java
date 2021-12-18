/**
  *
  * Objekte der Klasse Raum verwalten einen Raum im RPG-Adventure.
  * Jeder Raum hat bis zu vier Nachbarraeume (N, O, S, W).
  *
  * @version 1.0 (Demo) vom 12.01.2019
  * @author 
  */

public class Raum {
  
  // Anfang Attribute
  private String name;
  private String beschreibung;
  private Raum[] nachbarn = new Raum[4];  // in der Reihenfolge: N, O, S, W
  // Ende Attribute
  
  /**
    * Konstruktor
    *
    * @param pName         Name des Raums
    * @param pBeschreibung Kurzbeschreibung / Motto des Raums
    */
  public Raum(String pName, String pBeschreibung) {
    name = pName;
    beschreibung = pBeschreibung;
    for (int i = 0; i < 4; i++) {
      nachbarn[i] = null;
    } // end of for
  }

  // Anfang Methoden
  
  /**
    * Methode, die eine Anzeige aller Nachbarraeume erzeugt
    *
    * @return Anzeige der Nachbarraeume
    */
  public String gibNachbarinformationenAlsString() {
    String result = "";
    String[] richtung = {">> nach Norden: ", ">> nach Osten: ", ">> nach Süden: ", ">> nach Westen: "};
    for (int i = 0; i < 4; i++) {
      if (nachbarn[i] != null) {
         result = result + richtung[i] + this.getNachbar(i).getName() + "\n";
      } // end of if
    } // end of for
    if (result == "") {
      result = "Muharharhar... Du bist gefangen und hast verloren!\n";
    } // end of if
    return result;
  }

  
  // Ende Methoden
  
  // Anfang Methoden - Setter / Getter
  public Raum[] getNachbarn() {
    return nachbarn;
  }
  
  public Raum getNachbar(int pIndex) { // Getter fuer Nachbar an Index i
    if (pIndex >= 0 && pIndex <= 3) {
      return nachbarn[pIndex];
    } else {
      return null;
    } // end of if-else
  }

  public void setNachbarn(Raum[] nachbarn) {
    this.nachbarn = nachbarn;
  }
  
  public void setNachbar(Raum pNachbar, int pIndex) { // Setter fuer Nachbar an Index i
    if (pNachbar != null && pIndex >= 0 && pIndex <= 3) {
      nachbarn[pIndex] = pNachbar;
    } 
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }
  // Ende Methoden - Setter / Getter
} // end of Raum
