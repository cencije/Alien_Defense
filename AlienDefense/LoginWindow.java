import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
/**
 * Auto Generated Java Class.
 */
public class LoginWindow extends JPanel implements ActionListener {
  
  private AlienDefenseMain main;
  JFrame mainFrame, noNameFrame;
  JLabel dummyLabel, lblName, lblNoName;
  JButton btnSubmit, btnCancel, btnOkay;
  JTextField tfName;
  private Color menuColor = new Color(52, 63, 71);
  
  public void createGUI(int x, int y, int width, int height, AlienDefenseMain game) {
    main = game;
    mainFrame = new JFrame();
    
    mainFrame.getContentPane().setBackground(menuColor);
    mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
    mainFrame.setBounds(x,y, width,height);
    mainFrame.getContentPane().setLayout(new BorderLayout());
    mainFrame.setResizable(false);
    mainFrame.setTitle("Login");
    
    lblName = new JLabel("Name:");
    lblName.setFont(new Font("Serif", Font.BOLD, 16));
    lblName.setForeground(Color.WHITE);
    lblName.setBounds(5, 1, 45, 30);
    mainFrame.add(lblName);
    
    tfName = new JTextField("", 30);
    tfName.setBounds(55, 1, 140, 30);
    tfName.setEditable(true);
    mainFrame.add(tfName);
    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(width/10, 28, 80, 30);
    btnSubmit.addActionListener(this);
    mainFrame.add(btnSubmit);
    
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(width/2, 28, 80, 30);
    btnCancel.addActionListener(this);
    mainFrame.add(btnCancel);
    
    dummyLabel = new JLabel("");
    mainFrame.add(dummyLabel);
    
    mainFrame.setVisible(false);
    mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    mainFrame.setUndecorated(true);
    mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    
  }
  public void createWarningBox(int x, int y, int width, int height, AlienDefenseMain game) {
    main = game;
    noNameFrame = new JFrame();
    noNameFrame.setTitle("Not Logged In");
    noNameFrame.getContentPane().setBackground(menuColor);
    noNameFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
    noNameFrame.setBounds(x, y, width, height);
    noNameFrame.getContentPane().setLayout(new BorderLayout());
    noNameFrame.setResizable(false);
    
    lblNoName = new JLabel("Please log in to continue:");
    lblNoName.setFont(new Font("Serif", Font.BOLD, 16));
    lblNoName.setForeground(Color.WHITE);
    lblNoName.setBounds(5, 1, 250, 30);
    noNameFrame.add(lblNoName);
    btnOkay = new JButton("Okay");
    btnOkay.setBounds(50, 25, 80, 30);
    btnOkay.addActionListener(this);
    noNameFrame.add(btnOkay);
    
    dummyLabel = new JLabel("");
    noNameFrame.add(dummyLabel);
    
    noNameFrame.setVisible(false);
    noNameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    noNameFrame.setUndecorated(true);
    noNameFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    
  }
  
  public void makeVisibleLogin() { mainFrame.setVisible(true);}
  public void makeVisibleNoName() { noNameFrame.setVisible(true);}
  public void actionPerformed(ActionEvent evt) {
    if (evt.getActionCommand().equals("Cancel")) {
      main.showScreen(0);
      mainFrame.dispose();
    }
    if (evt.getActionCommand().equals("Submit")) {
      String typedName = tfName.getText();
      main.setPlayerName(typedName);
      main.showScreen(0);
      mainFrame.dispose();
    }
    if (evt.getActionCommand().equals("Okay")) {
      main.showScreen(0);
      noNameFrame.dispose();
    }
  }
}
