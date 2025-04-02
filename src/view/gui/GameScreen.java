package view.gui;

import controller.KeyboardListener;
import controller.MyMouseListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class GameScreen extends JPanel {
    
    private Random random;
    private GameWindow gameWindow;
    private Dimension size;
    
    private final int PANEL_WIDTH = 1138;
    private final int PANEL_HEIGHT = 640;

    private MyMouseListener myMouseListener;
    private KeyboardListener keyboardListener;

    public GameScreen(GameWindow gameWindow) 
    {   
        this.gameWindow = gameWindow;
        setPanelSize();
        random = new Random();
    }
    
    public void initInputs(){
        myMouseListener = new MyMouseListener(gameWindow);
        keyboardListener = new KeyboardListener();
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);
    
        requestFocus();
    
    }
    
    public void setPanelSize(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    @Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);

    ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("assets/background_V2.png"));
    if (imageIcon.getImage() == null) {
        System.out.println("Immagine non trovata: assets/background_V2.png");
    } else {
        System.out.println("Immagine caricata correttamente!");
        g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    gameWindow.getRender().renderGame(g);
}
    
    /* 
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("src/assets/background_V2.png");
        g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        
        gameWindow.getRender().renderGame(g);

        //
        
//      g.drawImage(sprites.get(103), 0, 0, null);
//      g.drawImage(img.getSubimage(32*0, 32*10, 32, 32), 32, 0, null);
//      g.drawImage(img.getSubimage(32*1, 32*8, 32, 32), 0, 32, null);
//      g.drawImage(img.getSubimage(32*2, 32*8, 32, 32), 32, 32, null);
//      g.drawImage(img.getSubimage(32*1, 32*9, 32, 32), 0, 64, null);
//      g.drawImage(img.getSubimage(32*2, 32*9, 32, 32), 32, 64, null);
//      g.drawImage(img.getSubimage(32*1, 32*10, 32, 32), 0, 96, null);
//      g.drawImage(img.getSubimage(32*2, 32*10, 32, 32), 32, 96, null);
    }
     /* 
     private Color getRndColor()
     {
         //return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
         int r = random.nextInt(255);
         int g = random.nextInt(255);
         int b = random.nextInt(255);
         return new Color(r,g,b);
      }
     */
}   