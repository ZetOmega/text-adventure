public class Spiel {
  private Raum[] raeume;
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
      "", //0. Busbahnhof  
      "", //1. Schulhof 1 
      "", //2. Neubau
      "", //3. Sporthalle
      "Hier wuetet Sky's Shadow", //4. Musik & Kunst
      "", //5. Aula
      "", //6. Mensa
      "", //7. Schulhof 2
      "", //8. Pavillion
      "", //9. PZ
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
        new Gegenstand("5. Aula Schluessel", "Gewaehrt dir Zugang zur 5. Aula"), //5. Aula
      }, 
      {}, //6. Mensa
      {}, //7. Schulhof 2
      {}, //8. Pavillion
      {}, //9. PZ
      {}, //10. Buecherei
      {
        new Gegenstand("11. Lehrerzimmer Schluessel", "Gewaehrt dir Zugang zum 11. Lehrerzimmer"), //11. Lehrerzimmer
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
    Gegenstand[] gegnerBelohnungen = {
      null, //0. Busbahnhof
      null, //1. Schulhof 1
      null, //2. Neubau
      null, //3. Sporthalle
      new Gegenstand("Aula Schluessel", "Gewaehrt dir Zugang zur Aula"),  //4. Musik & Kunst
      null, //5. Aula
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
