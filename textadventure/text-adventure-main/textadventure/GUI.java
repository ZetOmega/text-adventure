import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.LinkedList;  
import java.util.List;  

/** @version 0.2 from 26.01.2022
  * @philipp.klei 
  */

public class GUI extends JFrame {
  private Canvas displayCanvas = new Canvas();
  private JTextArea storyArea = new JTextArea("");
    private JScrollPane storyAreaScrollPane = new JScrollPane(storyArea);
  private JToolBar jToolBar1 = new JToolBar();
  private JButton ausfuehren = new JButton();
  private JComboBox<String> actionDropdown = new JComboBox<String>();
  private Canvas minimapCanvas = new Canvas();
  private JList inventarListe = new JList();
    private DefaultListModel inventarListeModel = new DefaultListModel();
    private JScrollPane inventarListeScrollPane = new JScrollPane(inventarListe);
  private JTextArea attributeArea = new JTextArea("");
    private JScrollPane attributeAreaScrollPane = new JScrollPane(attributeArea);
  Spiel spiel = new Spiel("testSpieler");

  public GUI (String title) {
    super (title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 720; 
    int frameHeight = 750;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    displayCanvas.setBounds(184, 192, 505, 505);
    cp.add(displayCanvas);
    storyAreaScrollPane.setBounds(184, 8, 505, 137);
    cp.add(storyAreaScrollPane);

    jToolBar1.setBounds(152, 432, 1, 9);
    cp.add(jToolBar1);
    ausfuehren.setBounds(601, 153, 91, 28);
    ausfuehren.setText("ausfuehren");
    ausfuehren.setMargin(new Insets(2, 2, 2, 2));
    ausfuehren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        ausfuehren_ActionPerformed(evt);
      }
    });
    cp.add(ausfuehren); 
    actionDropdown.setBounds(184, 153, 406, 28);
    cp.add(actionDropdown);
    minimapCanvas.setBounds(8, 8, 161, 129);
    cp.add(minimapCanvas);
    inventarListe.setModel(inventarListeModel);
    inventarListeScrollPane.setBounds(8, 192, 161, 505);
    cp.add(inventarListeScrollPane);
    attributeAreaScrollPane.setBounds(8, 153, 161, 28);
    cp.add(attributeAreaScrollPane);
    setResizable(false);
    setVisible(true);
  }
  
  public void dropdownRefresh(){
    actionDropdown.removeAllItems()  
    JComboBox<String> temp = new JComboBox<String>(); /*hier muss: spiel.gibAktionen()*/
    actionDropdown.add(temp);
  }
  
  public void ausfuehren_ActionPerformed(ActionEvent evt) {
    getSelectedItem();
  }
  
  public static void Main(String[] args){
    GUI gui = new GUI("TextAdenture");
        
  }
}
                                                                   
