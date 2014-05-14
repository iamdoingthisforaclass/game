import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * Creates a top-level window.
 * 
 * @version 1
 */
public class GameMain extends JPanel
{    
    //Game attributes
    private String level="Levels/level1.txt";
    private int levelHeight=10;
    private int levelWidth=20;
    private String gameName="Thing";
    private String gameIconURL="GameIcon.png";
    private String spike="Spike.png";
    private String ground="Ground.png";
    private String air="Air.png";
    private String end="End.png";
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

    public void start()
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
        frame.setSize(680, 380);
        frame.setVisible(true); 
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

    public void loadImages()
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
                        case 's':
                        levelImages[h][w] = getImage(spike);
                        break;
                        case 'g':
                        levelImages[h][w] = getImage(ground);
                        break;
                        case '.':
                        levelImages[h][w] = getImage(air);
                        break;
                        case 'e':
                        levelImages[h][w] = getImage(end);
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