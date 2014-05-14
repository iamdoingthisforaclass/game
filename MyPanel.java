import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class panel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyPanel extends JPanel
{
    Image[][]levelImages;
    int height;
    int width;    
    public MyPanel(Image[][]images,int height, int width){
        setLevel(images, height, width);
    }

    public void paintComponent(Graphics g){
        int xmod=0;
        int ymod=0;
        for(int h = 0; h < height; h++)
        {
            xmod=0;
            for(int w = 0; w < width; w++)
            {
                g.drawImage(levelImages[h][w],width+xmod,height+ymod,this);
                xmod+=32;
            }
            ymod+=32;
        }
    }   

    public void setLevel(Image[][]images,int height, int width){
        levelImages=images;
        this.height=height;
        this.width=width;        
        repaint();
    }
}
