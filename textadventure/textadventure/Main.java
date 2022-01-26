public class Main{
    public Main(){
        new GUI("GUI");

    }
public static void main(String[] args) {
    //new Main();
    Spiel spiel = new Spiel();
    List<String> aktionen = spiel.gibAktionen();
    for(String aktion : aktionen) {
        System.out.println(aktion);
    }
  }
}
