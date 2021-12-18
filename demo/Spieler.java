/**
  *
  * Objekte der Klasse Spieler verwalten eine Hauptfigur im RPG-Adventure.
  *
  * @version 1.0 (Demo) vom 12.01.2019
  * @author Florian Lettl
  */

public class Spieler {
  
  // Anfang Attribute
  private String name;
  private int lpMax;
  private int lpAktuell;
  private int angriff;
  private int abwehr;
  // Ende Attribute
  
  /**
    * Konstruktor
    *
    * @param pName Name der Spielfigur
    */
  public Spieler(String pName) {
    name = pName;
    lpMax = 100;
    lpAktuell = 100;
    angriff = 5;
    abwehr = 5;
  }

  // Anfang Methoden
  
  // Ende Methoden
  
  // Anfang Methoden - Setter / Getter
  public String getName() {
    return name;
  }

  public int getLPMax() {
    return lpMax;
  }

  public int getLPAktuell() {
    return lpAktuell;
  }

  public int getAngriff() {
    return angriff;
  }

  public int getAbwehr() {
    return abwehr;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLPMax(int lpMax) {
    this.lpMax = lpMax;
  }

  public void setLPAktuell(int lpAktuell) {
    this.lpAktuell = lpAktuell;
  }

  public void setAngriff(int angriff) {
    this.angriff = angriff;
  }

  public void setAbwehr(int abwehr) {
    this.abwehr = abwehr;
  }
  // Ende Methoden - Setter / Getter
} // end of Spieler
