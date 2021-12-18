/**
  *
  * Objekte der Klasse Spiel verwalten ein RPG-Adventure.
  * Ein Spiel kennt den Spieler und den Raum, in dem dieser aktuell ist.
  *
  * @version 1.0 (Demo) vom 12.01.2019
  * @author Florian Lettl
  */

public class Spiel {
  
  // Anfang Attribute
  private Spieler spieler;
  private Raum aktuellerRaum;
  // Ende Attribute 
  
  /**
    * Konstruktor
    *
    * @param pSpielername Name des Spielers
    */
  public Spiel(String pSpielername) {
    // Spielfigur erzeugen
    spieler = new Spieler(pSpielername);
    
    // Welt (Raeume) erzeugen
    String[] namen = {
      /**--**/ "Einganshalle", // Startraum
      /**01**/ "PZ",
      /**02**/ "Pavillon",
      /**03**/ "Bücherei",
      /**04**/ "WC"
    };
    String[] beschreibungen = {
      /**--**/ "Hier startet das große Abenteuer!",
      /**01**/ "Hier gibt es so gut wie alles und gleichzeitig auch wieder nichts.",
      /**02**/ "Achtung, morgendliche Gefahr, über den Haufen gerannt zu werden! (Hier könnte z. B. ein Bossgegner darauf warten, besiegt zu werden.)",
      /**03**/ "Suchst du nach Informationen, bist du hier genau richtig! (Hier könnte z. B. ein NPC einen wichtigen Gegenstand überreichen, nachdem man eine Aufgabe gelöst hat.)",
      /**04**/ "Ein Ort des Grauens... (Hier könnte z. B. eine Sackgasse sein, die man mit dem Verlust einiger Lebenspunkte wieder verlassen kann.)"
    };
    
    Raum[] raeume = new Raum[namen.length];
    for (int i = 0; i < namen.length; i++) {
      raeume[i] = new Raum(namen[i], beschreibungen[i]);
    } // end of for
    
    // Nachbarschaftsbeziehungen der Raeume setzen
    this.verbindeRaeume(raeume[0], raeume[1], 0); // Eingangshalle -N-> PZ
    this.verbindeRaeume(raeume[0], raeume[4], 2); // Eingangshalle -S-> WC
    this.verbindeRaeume(raeume[1], raeume[3], 1); // PZ -O-> Buecherei
    this.verbindeRaeume(raeume[1], raeume[2], 3); // PZ -W-> Pavillon
      
    // Startraum setzen
    aktuellerRaum = raeume[0];
  }

  // ---------------
  // Anfang Methoden
  // ---------------
  
  /**
    * Die Methode wertet einen eingegebenen Befehl aus.
    * Dazu wird je nach Befehl die entsprechende private Verarbeitungsmethode
    * aufgerufen.
    *
    * @param pBefehl Befehl, der ausgewertet werden soll
    * @return Ergebnis der Befehlsausfuehrung zur Anzeige
    */
  public String befehlAuswerten(String pBefehl) {
    String result;
    switch (pBefehl) {
      //Befehle per Eingabe
      case "/h": 
        result = this.hilfeAnzeigen();
        break;
      
      // Bewegungen per Button
      case "N": 
        result = this.raumWechseln(0);
        break;
      case "O": 
        result = this.raumWechseln(1);
        break;
      case "S": 
        result = this.raumWechseln(2);
        break;
      case "W": 
        result = this.raumWechseln(3);
        break;
        
      // Platz fuer weitere Befehle  
        
      default: 
        result = "Bitte nur zulässige Befehle eingeben. /h -> Hilfe";
    } // end of switch
    return result;
  }

  /**
    * Methode, die wichtige Informationen zum Start des Spiels erzeugt
    *
    * @return Informationen, die beim Spielstart angezeigt werden
    */
  public String zeigeStartinformationen() {
    String result = "--- Wichtige Informationen zum Start des Spiels ---\n";
    result += "Mit dem Befehl /h kannst du die Hilfe anzeigen lassen!\n";
    // weitere wichtige Informationen (Anleitung, Steuerung, Hintergrundgeschichte, ...)
    result += "Spieler " + spieler.getName() + ", möge dein Abenteuer nun beginnen!\n";
    result += "Deine Lebenspunkte (aktuell / maximal): " + this.zeigeSpielerLP() + "\n";
    result += "Deine Statuswerte: ANG " + spieler.getAngriff() + " - ABW " + spieler.getAbwehr() + "\n";
    result += this.zeigeRauminformationen();
    return result;
  }

  /**
    * Methode, die den aktuellen Stand der LP des Spielers in der Form "aktuell / max" ausgibt
    *
    * @return LP in der Form "aktuell / max"
    */
  public String zeigeSpielerLP() {
    return spieler.getLPAktuell() + " / " + spieler.getLPMax();
  }
  
  // --------------------------------------------------------------
  // private Methoden zur Abarbeitung der moeglichen Eingabebefehle
  // --------------------------------------------------------------
  
  /**
    * Methode, die die Anzeige der spielinternen Hilfe erzeugt
    *
    * @return Anzeige der Hilfe
    */
  private String hilfeAnzeigen() {
    String result = "----- Hilfe -----\n";
    result += "Bewege dich mit den vier Richtungsbuttons oder gib einen Befehl an.\n";
    result += "Übersicht über mögliche Befehle:\n";
    result += "/h -> zeigt die Hilfe an\n";
    result += "--- Hilfe Ende ---\n";
    return result;
  }
  
  /**
    *
    * Methode, die wichtige Informationen zum aktuellen Raum anzeigt
    *
    * @return Informationen zum aktuellen Raum
    */
  private String zeigeRauminformationen() {
    String result = "--------------------------------------------------\n";
    result += "Du befindest dich aktuell in folgendem Raum: >>" + aktuellerRaum.getName() + "<<\n";
    result += aktuellerRaum.getBeschreibung() + "\n";
    result += "Du kannst den Raum in folgenden Richtungen verlassen:\n";
    result += aktuellerRaum.gibNachbarinformationenAlsString();
    return result;
  }

  /**
    * Die Methode prueft, ob man vom aktuellen Raum aus in einer Richtung in einen
    * Nachbarraum gelangt. Ist dies der Fall, wird der Raum gewechselt und die
    * Informationen zum neuen Raum werden erstellt. Andernfalls wird ein entsprechender
    * Hinweis angezeigt.
    * (Setter fuer aktuellerRaum)
    *
    * @param pIndex Richtung, in die man gehen moechte (0->N, 1->O, 2->S, 3->W)
    * @return neue Rauminformationen oder Fehlermeldung
    */
  private String raumWechseln(int pIndex) {
    if (aktuellerRaum.getNachbar(pIndex) != null) {
      aktuellerRaum = aktuellerRaum.getNachbar(pIndex);
      return this.zeigeRauminformationen();
    } else {
      return "Stop! Du läufst sonst gegen eine Wand... Kein Weg in dieser Richtung!\n";
    } // end of if-else
  }
  
  // ---------------------
  // private Hilfsmethoden
  // ---------------------
  
  /**
    * Die Methode prueft, ob man vom aktuellen Raum aus in einer Richtung in einen
    * Nachbarraum gelangt. Ist dies der Fall, wird der Raum gewechselt und die
    * Informationen zum neuen Raum werden erstellt. Andernfalls wird ein entsprechender
    * Hinweis angezeigt.
    * (Setter fuer aktuellerRaum)
    *
    * @param r1 erster Raum
    * @param r2 zweiter Raum
    * @param pRichtung Richtung der Verbindung vom ersten zum zweiten Raum
    * Hinweis: Richtung vom zweiten zum ersten Raum - mathematisch (pRichtung+2)%4
    */
  private void verbindeRaeume(Raum r1, Raum r2, int pRichtung) {
    r1.setNachbar(r2,pRichtung);
    r2.setNachbar(r1,(pRichtung + 2) % 4);
  }

  // -------------  
  // Ende Methoden
  // -------------
} // end of Spiel
