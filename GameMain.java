import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * 2 Player Mario and Luigi game
 * Zach- Luigi
 * Pranav - Mario
 * Ryan - Yoshi
 * Bryce - Goomba
 * Greg - Red Koopa
 * Ross - Green Koopa
 * Saran - Peach
 * Mr. Page - Bowser
 * Bowser Fire Balls - Object First Books
 * Fire Balls - BlueJ Colored Pictures
 * ""(easy project) - Growth Mushrooms
 * "Huffman" - Poison Mushroom
 */
public class GameMain extends JPanel
{    
    //Game attributes
    private String level="Levels/level1.txt";
    private int levelHeight=10;
    private int levelWidth=20;
    private String gameName="POOOOOOOOOOOOOOOOP";
    private String gameIconURL="GameIcon.png";
    private String brick= "brick.png";
    private String air= "Air.png";
    private String pow= "powblock.png";
    private String c1 = "cloud1.png";
    private String c2 = "cloud2.png";
    private String c3 = "cloud3.png";
    private String c4 = "cloud4.png";
    private String c5 = "cloud5.png";
    private String p1 = "p1.png";
    private String p2 = "p2.png";
    private String y = "yoshi.png";
    private String gL = "goombaL.png";
    private String gR = "goombaR.png";
    private String koopaG = "koopa troopa g.png";
    private String koopaR = "koopa troopa r.png";
    private String Peach = "saran.png";
    private final Color SKY = new Color(153, 217, 234);
    //Other Fields
    private Graphics panelGraphics;
    private MyPanel panel;
    private JFrame frame;
    private Image[][]levelImages;
    public GameMain()
    {        
        start();
    }

    public static void main(String[] args)
    {   
        try{
            GameMain game=new GameMain();
        }
        catch(Exception e){
            System.err.println("Error: "+e);
        }
    }

    private void start()
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
            {
                public void run(){
                    startGameGUI();
                }
            }
        );
    }

    /**
     * Method startGame - Builds top level window for the game.
     * This method is private & should only be invoked from main().
     */    
    private  void startGameGUI()
    {
        frame = new JFrame(gameName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(getImage(gameIconURL));
        loadImages();
        panel=new MyPanel(levelImages,levelHeight,levelWidth); 
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(680, 370);
        frame.setVisible(true); 
        frame.setBackground(SKY);
    }

    private Image getImage(String url) 
    {
        java.net.URL imgURL =     
            GameMain.class.getResource
            ("images/"+url);
        if (imgURL != null) 
        {
            return new ImageIcon(imgURL).getImage();
        } 
        else 
        {
            return null;
        }
    }

    public Image randomCloud()
    {
        return getImage("cloud" + (int)(Math.random() * 5 + 1) + ".png");
    }

    private void loadImages()
    {
        try{
            Scanner scan=new Scanner(new File(level));        
            levelImages=new Image[levelHeight][levelWidth];
            for(int h = 0; h < levelHeight; h++)
            {
                String line = scan.nextLine();
                for(int w = 0; w < levelWidth; w++)
                {
                    char c = line.charAt(w);
                    switch(c)
                    {
                        case 'b':
                        levelImages[h][w] = getImage(brick);
                        break;
                        case '.':
                        levelImages[h][w] = getImage(air);
                        break;
                        case 'p':
                        levelImages[h][w] = getImage(pow);
                        break;
                        case 'c':
                        levelImages[h][w] = randomCloud();
                        break;
                        case 'g':
                        levelImages[h][w] = getImage(gL);
                        break;
                        case 'h':
                        levelImages[h][w] = getImage(gR);
                        break;
                        case 'm':
                        levelImages[h][w] = getImage(p1);
                        break;
                        case 'l':
                        levelImages[h][w] = getImage(p2);
                        break;
                        case 'k':
                        levelImages[h][w] = getImage(koopaG);
                        break;
                        case 'r':
                        levelImages[h][w] = getImage(koopaR);
                        break;
                        case 's':
                        levelImages[h][w] = getImage(Peach);
                        break;
                        case 'y':
                        levelImages[h][w] = getImage(y);
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.err.println("Error: " +e);
        }
        catch(Exception e){
            System.err.println("Error: " +e);
        }
    }
}