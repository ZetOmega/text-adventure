import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;
import java.awt.font.TextAttribute;

/**
  *
  * Oberflaeche zum RPG-Adventure
  *
  * @version 1.0 (Demo) vom 12.01.2019
  * @author Florian Lettl
  */

public class Gui extends JFrame {
  // Anfang Attribute
  private JLabel jlTitel = new JLabel();
  private JLabel jlName = new JLabel();
  private JTextField jtfName = new JTextField();
  private JButton jbStart = new JButton();
  private JButton jbEnde = new JButton();
  private JTextArea jtaAnzeige = new JTextArea("");
    private JScrollPane jtaAnzeigeScrollPane = new JScrollPane(jtaAnzeige);
  private JLabel jlLP = new JLabel();
  private JLabel jlLPAnzeige = new JLabel();
  private JLabel jlBefehl = new JLabel();
  private JTextField jtfBefehl = new JTextField();
  private JButton jbEingabe = new JButton();
  private JButton jBNord = new JButton();
  private JButton jbOst = new JButton();
  private JButton jbSued = new JButton();
  private JButton jbWest = new JButton();
  private JLabel jlBewegung = new JLabel();
  // Ende Attribute
  
  // Objektattribute
  Spiel s;
  // Ende Objektattribute
  
  public Gui() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 584; 
    int frameHeight = 567;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jlTitel.setBounds(8, 8, 257, 23);
    jlTitel.setText("Willkommen zum RPG-Adventure");
    Hashtable<TextAttribute, Object> jlTitel_map = new Hashtable<TextAttribute, Object>();
    jlTitel_map.put(TextAttribute.FAMILY, "Dialog");
    jlTitel_map.put(TextAttribute.SIZE, Integer.valueOf(16));
    jlTitel_map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    jlTitel_map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);    
    jlTitel.setFont(new Font(jlTitel_map));
    cp.add(jlTitel);
    jlName.setBounds(8, 40, 222, 20);
    jlName.setText("Wähle einen Namen für deinen Helden:");
    jlName.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(jlName);
    jtfName.setBounds(232, 40, 150, 20);
    cp.add(jtfName);
    jbStart.setBounds(392, 40, 163, 25);
    jbStart.setText("Das Abenteuer beginnen");
    jbStart.setMargin(new Insets(2, 2, 2, 2));
    jbStart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jbStart_ActionPerformed(evt);
      }
    });
    cp.add(jbStart);
    jbEnde.setBounds(392, 72, 163, 25);
    jbEnde.setText("Das Abenteuer beenden");
    jbEnde.setMargin(new Insets(2, 2, 2, 2));
    jbEnde.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jbEnde_ActionPerformed(evt);
      }
    });
    cp.add(jbEnde);
    jtaAnzeigeScrollPane.setBounds(8, 104, 377, 385);
    jtaAnzeige.setLineWrap(true);
    jtaAnzeige.setWrapStyleWord(true);
    cp.add(jtaAnzeigeScrollPane);
    jlLP.setBounds(8, 72, 189, 20);
    jlLP.setText("Lebenspunkte (aktuell / maximal):");
    jlLP.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(jlLP);
    jlLPAnzeige.setBounds(200, 72, 62, 20);
    jlLPAnzeige.setText("0 / 0");
    jlLPAnzeige.setHorizontalAlignment(SwingConstants.RIGHT);
    jlLPAnzeige.setFont(new Font("Dialog", Font.BOLD, 12));
    cp.add(jlLPAnzeige);
    jlBefehl.setBounds(8, 496, 102, 20);
    jlBefehl.setText("Was willst du tun?");
    jlBefehl.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(jlBefehl);
    jtfBefehl.setBounds(112, 496, 270, 20);
    cp.add(jtfBefehl);
    jbEingabe.setBounds(392, 496, 75, 25);
    jbEingabe.setText("Eingabe");
    jbEingabe.setMargin(new Insets(2, 2, 2, 2));
    jbEingabe.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jbEingabe_ActionPerformed(evt);
      }
    });
    cp.add(jbEingabe);
    jBNord.setBounds(416, 416, 27, 25);
    jBNord.setText("N");
    jBNord.setMargin(new Insets(2, 2, 2, 2));
    jBNord.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBNord_ActionPerformed(evt);
      }
    });
    cp.add(jBNord);
    jbOst.setBounds(432, 440, 27, 25);
    jbOst.setText("O");
    jbOst.setMargin(new Insets(2, 2, 2, 2));
    jbOst.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jbOst_ActionPerformed(evt);
      }
    });
    cp.add(jbOst);
    jbSued.setBounds(416, 464, 27, 25);
    jbSued.setText("S");
    jbSued.setMargin(new Insets(2, 2, 2, 2));
    jbSued.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jbSued_ActionPerformed(evt);
      }
    });
    cp.add(jbSued);
    jbWest.setBounds(400, 440, 27, 25);
    jbWest.setText("W");
    jbWest.setMargin(new Insets(2, 2, 2, 2));
    jbWest.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jbWest_ActionPerformed(evt);
      }
    });
    cp.add(jbWest);
    jlBewegung.setBounds(392, 392, 78, 20);
    jlBewegung.setText("Gehe nach...");
    jlBewegung.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(jlBewegung);
    // Ende Komponenten
    
    setVisible(true);
    
    this.initialisieren();
  } // end of public Gui
  
  // Anfang Methoden
  
  // --- Methoden zum Starten und Beenden des Spiels ---
  
  // Oberflaeche initialisieren
  private void initialisieren() {
    this.jbEnde.setEnabled(false);
    this.jbEingabe.setEnabled(false);
    this.jBNord.setEnabled(false);
    this.jbOst.setEnabled(false);
    this.jbSued.setEnabled(false);
    this.jbWest.setEnabled(false);
  }
  
  // Spiel starten
  public void jbStart_ActionPerformed(ActionEvent evt) {
    String name = jtfName.getText();
    if (name.equals("")) {
      JOptionPane.showMessageDialog(null,"Bitte einen Namen für den Helden angeben!");
    } else {
      // Spiel initialisieren
      s = new Spiel(name);
      
      // Anzeigen anpassen
      jlLPAnzeige.setText(s.zeigeSpielerLP());
      jtaAnzeige.append(s.zeigeStartinformationen());
           
      // Buttons anpassen
      this.jbStart.setEnabled(false);
      this.jbEnde.setEnabled(true);
      this.jbEingabe.setEnabled(true);
      this.jBNord.setEnabled(true);
      this.jbOst.setEnabled(true);
      this.jbSued.setEnabled(true);
      this.jbWest.setEnabled(true);
    } // end of if-else
  } // end of jbStart_ActionPerformed

  // Spiel beenden
  public void jbEnde_ActionPerformed(ActionEvent evt) {
    // Anzeigen zuruecksetzen
    jlLPAnzeige.setText("0 / 0");
    jtaAnzeige.setText("");
    
    // Buttons anpassen
    this.jbStart.setEnabled(true);
    this.jbEnde.setEnabled(false);
    this.jbEingabe.setEnabled(false);
    this.jBNord.setEnabled(false);
    this.jbOst.setEnabled(false);
    this.jbSued.setEnabled(false);
    this.jbWest.setEnabled(false);
  } // end of jbEnde_ActionPerformed
  
  // --- Methoden zur Durchfuehrung des Spiels ---

  // Befehle eingeben
  public void jbEingabe_ActionPerformed(ActionEvent evt) {
    String befehl = jtfBefehl.getText();
    if (befehl.equals("")) {
      JOptionPane.showMessageDialog(null,"Bitte einen Befehl (z. B. /h für die Hilfe) eingeben!");
    } else {
      jtaAnzeige.append(s.befehlAuswerten(befehl));
    } // end of if-else
  } // end of jbEingabe_ActionPerformed

  // Durch Raeume navigieren
  public void jBNord_ActionPerformed(ActionEvent evt) {
    jtaAnzeige.append(s.befehlAuswerten("N"));
  } // end of jBNord_ActionPerformed

  public void jbOst_ActionPerformed(ActionEvent evt) {
    jtaAnzeige.append(s.befehlAuswerten("O"));
  } // end of jbOst_ActionPerformed

  public void jbSued_ActionPerformed(ActionEvent evt) {
    jtaAnzeige.append(s.befehlAuswerten("S"));
  } // end of jbSued_ActionPerformed

  public void jbWest_ActionPerformed(ActionEvent evt) {
    jtaAnzeige.append(s.befehlAuswerten("W"));
  } // end of jbWest_ActionPerformed
  
  // Ende Methoden

  public static void main(String[] args) {
    new Gui();
  } // end of main

} // end of class Gui
