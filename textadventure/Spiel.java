public class Spiel {
  private Raum[] raeume;
  public Spiel() {
    int anzahlRaeume = 15;
    String[] namen = {
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
      "Bücherei",
      "Lehrerzimmer",
      "Schulhof3",
      "Bioturm",
      "Zebra"
    };
    String[] beschreibungen = {
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
    };
    Gegner[][] gegner = {
               {},
               {},
               {},
               {},
               {
                new Gegner("Sky's Shadow", "",
               },
               {},
               {},
               {},
               {},
               {},
               {},
               {},
               {},
               {},
               {}
    };
    
    raeume = new Raum[anzahlRaeume];
    for(int i = 0; i < raeume.length; i++) {
      raeume[i] = new Raum(namen[i], beschreibungen[i]);
    }         
  }
}
