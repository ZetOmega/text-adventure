public class Spiel {
  private Raum[] raeume;
  private int aktuellerRaum;
  private Spieler spieler;
  
  public Spiel(String pSpielerName) {
    String[] raumNamen = { //Bestimmt Anzahl der Raeume
      "Busbahnhof",
      "Schulhof 1",
      "Neubau",
      "Sporthalle",
      "Musik & Kunst",
      "Aula",
      "Mensa",
      "Schulhof 2",
      "Pavillion",
      "PZ",
      "Buecherei",
      "Lehrerzimmer",
      "Schulhof 3",
      "Bioturm",
      "Zebra"
    };
    int anzahlRaeume = raumNamen.length;
    String[] raumBeschreibungen = {
      "Willkommen in Odenthal! Ich bin der Stonebreaker und ich fuehre dich durch die Welt von Odenthal City.\n Du bist gerade aus dem Bus ausgestiegen und befindest dich nun vor der Schule auf dem Busbahnhof.\n Ich gebe dir zur Hilfe eine Karte, die du wahrscheinlich schon oben links gesehen hast, damit du dich nicht verlaeufst.\n Mit Hilfe der obenstehenden Befehlszeile kannst du deine Aktionen auswaehlen und anschliessend mit dem Button durch einen Klick ausfuehren, wie z.B. jetzt zum Schulhof 1. Wir hoeren uns bestimmt nochmal, bis spaeter.", //0. Busbahnhof  
      "Herzlichen Glueckwunsch du hast den Schluessel zum Neubau gefunden!\n Jetzt kannst du auch den Neubau erkunden, doch weisst du wo er ist?\n Viel Glueck beim Suchen.", //1. Schulhof 1 
      "", //2. Neubau
      "", //3. Sporthalle
      "Vorsicht! Sky's Shadow hat dich bemerkt. Besiege ihn um an einen besonderen Gegenstand zu gelangen.\n Doch du musst dich beeilen, denn dein Gegner schiesst zurueck", //4. Musik & Kunst
      "Ach! Dieser Raum ist immer noch so gross wie frueher ... Huch, was macht denn die Schulleitung hier?\n Galileo Galilei ist anscheinend nicht so erfreut, dass wir ihn stoeren. Pass auf er greift dich an!\n Jetzt zeig der Schulleitung, wer hier der bessere Kaempfer ist!", //5. Aula
      "", //6. Mensa
      "", //7. Schulhof 2
      "", //8. Pavillion
      "Willkommen am wichtigsten Ort, falls ein kleiner Hunger auftritt. Hier gibt es auch Spinde, in denen man seine Sportsachen verstauen kann, doch sag nicht, dass der Schluessel noch auf dem Busbahnhof liegt.\n Ich wuerde mich an deiner Stelle beeilen den Schluessel zu finden, bevor er geklaut wird.", //9. PZ
      "", //10. Buecherei
      "", //11. Lehrerzimmer
      "", //12. Schulhof 3
      "", //13. Bioturm
      "", //14. Zebra
    };
    Gegenstand[][] raumVoraussetzungen = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {}, //4. Musik & Kunst 
      {
        new Gegenstand("Aula Schluessel", "Gewaehrt dir Zugang zur Aula"), //5. Aula
      }, 
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {
        new Gegenstand("Lehrerzimmer Schluessel", "Gewaehrt dir Zugang zum Lehrerzimmer"), //11. Lehrerzimmer
      }, 
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra   
    };
    NPC[][] raumCharaktere = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {}, //4. Musik & Kunst
      {}, //5. Aula
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {}, //11. Lehrerzimmer
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra
    };
    String[][] gegnerNamen = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {
        "Sky's Shadow Saenger",
        "Sky's Shadow Gitarist",
        "Sky's Shadow Schlagzeuger",
        "Sky's Shadow Geiger"
      }, //4. Musik & Kunst
      {
        "Galileo Galilei"
      }, //5. Aula
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {}, //11. Lehrerzimmer
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra
    };
    String[][] gegnerBeschreibungen = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {
        "Eine Band wie es sie noch nie gegeben hat! Lass dich nicht von den Toenen erschlagen",
        "Eine Band wie es sie noch nie gegeben hat! Lass dich nicht von den Toenen erschlagen",
        "Eine Band wie es sie noch nie gegeben hat! Lass dich nicht von den Toenen erschlagen",
        "Eine Band wie es sie noch nie gegeben hat! Lass dich nicht von den Toenen erschlagen"
      }, //4. Musik & Kunst
      {
        "Ein uberpuenktlicher und ueberkorrekter Schulleiter, dessen einzige Schwaeche der Verlust seines Terminkalenders waere."
      }, //5. Aula
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {}, //11. Lehrerzimmer
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra
    };
    Gegenstand[] gegnerBelohnungen = {
      null, //0. Busbahnhof
      null, //1. Schulhof 1
      null, //2. Neubau
      null, //3. Sporthalle
      new Gegenstand("Aula Schluessel", "Gewaehrt dir Zugang zur Aula"),  //4. Musik & Kunst
      new Gegenstand("Lehrerzimmer Schluessel","Gewaehrt dir Zugang zum Lehrerzimmer"), //5. Aula
      null, //6. Mensa
      null, //7. Schulhof 2
      null, //8. Pavillion
      null, //9. PZ
      null, //10. Buecherei
      null, //11. Lehrerzimmer
      null, //12. Schulhof 3
      null, //13. Bioturm
      null, //14. Zebra
    };
    Waffe[][] gegnerWaffen = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {
        new Waffe("Mikrofon", "Nimm dich in acht! Schaedigt dein Gehoer!", 5),
        new Waffe("Gitarre", "Besaitet dich mit seiner Gitarre", 5),
        new Waffe("Schlagzeug", "Lass dich nicht tot trommeln", 5),
        new Waffe("Geige", "Was ist das? Man weiß es nicht genau aber fest steht es klingt schrecklich", 5)
      },
      {}, //5. Aula
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {}, //11. Lehrerzimmer
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra
    };

    Ruestung[][] gegnerRuestungen = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {
        new Ruestung("Gucci Pullover", "Kaum zu glauben, dass man mit so einer Musik so viel Geld verdient", 0),
        new Ruestung("Kleidung", "Ganz normale Kleidung... hier gibt's nichts zu sehen", 0),
        new Ruestung("Kleidung", "Ganz normale Kleidung... hier gibt's nichts zu sehen", 0),
        new Ruestung("Kleidung", "Ganz normale Kleidung... hier gibt's nichts zu sehen", 0)
      }, //4. Musik & Kunst
      {}, //5. Aula
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {}, //11. Lehrerzimmer
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra
    };

    Gegner[][] gegner = new Gegner[anzahlRaeume][4];

    for(int i = 0; i < gegner.length; i++) {
      for(int k = 0; k < gegner[i].length; k++) {
        gegner[i][k] = new Gegner(gegnerNamen[i][k], gegnerBeschreibungen[i][k], null, 100, gegnerWaffen[i][k], gegnerRuestungen[i][k], gegnerWaffen[i][k].gibSchaden());
        if(k == 0) {
          gegner[i][k].setzeBelohnung(gegnerBelohnungen[i]);
        }
      }
    }

    Raum[][] raumNachbarn = {
      {
        raeume[1]
      }, //0. Busbahnhof
      {
        raeume[0],
        raeume[2],
        raeume[5],
        raeume[7]
      },  //1. Schulhof 1
      {
        raeume[1],
        raeume[3],
        raeume[4]
      }, //2. Neubau
      {
        raeume[2]
      }, //3. Sporthalle
      {
        raeume[2]
      }, //4. Musik & Kunst
      {
        raeume[1],
        raeume[6],
        raeume[9]
      }, //5. Aula
      {
        raeume[5]
      }, //6. Mensa
      {
        raeume[1],
        raeume[8],
        raeume[9],
        raeume[12]
      }, //7. Schulhof 2
      {
        raeume[7]
      }, //8. Pavillion
      {
        raeume[5],
        raeume[7],
        raeume[10],
        raeume[11]
      }, //9. PZ
      {
        raeume[9]
      }, //10. Buecherei
      {
        raeume[9],
        raeume[13]
      }, //11. Lehrerzimmer
      {
        raeume[7],
        raeume[13],
        raeume[14]
      }, //12. Schulhof 3
      {
        raeume[11],
        raeume[12]
      }, //13. Bioturm
      {
        raeume[12]
      }, //14. Zebra
    };
    
    raeume = new Raum[anzahlRaeume];
    for(int i = 0; i < raeume.length; i++) {
      raeume[i] = new Raum(raumNamen[i], raumBeschreibungen[i], raumVoraussetzungen[i], gegner[i], raumCharaktere[i]);
    }

    //0 - Norden
    //1 - Osten
    //2 - Sueden
    //3 - Westen

    raeume[0].setzeNachbarn(raumNachbarn[0], new int[]{0});
    raeume[1].setzeNachbarn(raumNachbarn[1], new int[]{2,3,1,0});
    raeume[2].setzeNachbarn(raumNachbarn[2], new int[]{1,3,0});
    raeume[3].setzeNachbarn(raumNachbarn[3], new int[]{1});
    raeume[4].setzeNachbarn(raumNachbarn[4], new int[]{2});
    raeume[5].setzeNachbarn(raumNachbarn[5], new int[]{3,1,0});
    raeume[6].setzeNachbarn(raumNachbarn[6], new int[]{3});
    raeume[7].setzeNachbarn(raumNachbarn[7], new int[]{2,3,1,0});
    raeume[8].setzeNachbarn(raumNachbarn[8], new int[]{1});
    raeume[9].setzeNachbarn(raumNachbarn[9], new int[]{2, 3, 1, 0});
    raeume[10].setzeNachbarn(raumNachbarn[10], new int[]{3});
    raeume[11].setzeNachbarn(raumNachbarn[11], new int[]{2, 0});
    raeume[12].setzeNachbarn(raumNachbarn[12], new int[]{2, 1, 0});
    raeume[13].setzeNachbarn(raumNachbarn[13], new int[]{2, 3});
    raeume[14].setzeNachbarn(raumNachbarn[14], new int[]{2});

    spieler = new Spieler(100, new Waffe("Faeuste", "Schlag sie alle windelweich!", 10), pSpielerName, "Zeig was du kannst");
    
    aktuellerRaum = 0;          
  }
  
  public List<String> gibAktionen() {
    List<String> aktionen = new List<String>();
    
    for(int i = 0; i < raumNachbarn[aktuellerRaum].length; i++) {
      aktionen.append("Gehe in " + raumNachbarn[aktuellerRaum][i] + ".");
    }
    List<Gegner> gegner = raeume[aktuellerRaum].gibGegner();
    while(gegner.hasAccess()) {
      aktionen.append("Greife " + (NPC)gegner.getContent().gibName() + " an.");
      gegner.next();
    }
  }
  
  public int aktuellerRaum() {
    return aktuellerRaum;
  }
  
  public void setzeAktuellenRaum(int pNeuerRaum) {
    aktuellerRaum = pNeuerRaum;  
  }
  
  public String kaempfen()  {
    angSpieler = spieler.gibAngriff;
    GegnerLp = gegner.gibLp;
    GegnerLp = GegnerLp - angSpieler;
    
    if(gegner.gibLp <= 0 && spieler.gibLp > 0) {
      return "Spieler hat gewonnen";
    }
    else if(gegner.gibLp > 0 && spieler.gibLp <= 0) {
      return "Gegner hat gewonnen";
    }
    else if(gegner.gibLp <= 0 && spieler.gibLp <= 0) {
      return "Unentschieden";
    }
    else{
      return "Spiel nochmal";
    }
    
  }
}

/*
  String[][] gegnerNamen = {
      {}, //0. Busbahnhof
      {}, //1. Schulhof 1
      {}, //2. Neubau
      {}, //3. Sporthalle
      {}, //4. Musik & Kunst
      {}, //5. Aula
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {}, //11. Lehrerzimmer
      {}, //12. Schulhof 3
      {}, //13. Bioturm
      {}, //14. Zebra
  };
*/

