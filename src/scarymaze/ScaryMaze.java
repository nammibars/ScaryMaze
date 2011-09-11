/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scarymaze;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author avh4
 */
public class ScaryMaze extends JComponent implements MouseMotionListener {
    private Robot r;
    private Color BRIGHT_PINK = new Color(255, 60, 140);
    private Color DARK_BLUE = new Color (0, 51, 102);
    private Color GREEN = new Color (0, 255, 0);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        JFrame window = new JFrame("Maze Game");
        ScaryMaze game = new ScaryMaze();
        window.add(game);
        game.addMouseMotionListener(game);
        window.pack();
        window.setLocationRelativeTo(null); // Center on the screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    public ScaryMaze () throws AWTException {
        r = new Robot();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        g.setColor(BRIGHT_PINK);
        g.fillRect(0, 0, 1000, 800);
        g.setColor(DARK_BLUE);
        g.fillRect(100, 200, 500, 400);
        g.setColor(DARK_BLUE);
        g.fillRect(400, 350, 500, 100);
        g.setColor(GREEN);
        g.fillRect(900, 350, 25, 100);
        
        
        
        
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        Color c = r.getPixelColor(e.getXOnScreen(), e.getYOnScreen());
        System.out.println(c);
        if (colorsMatch(BRIGHT_PINK, c))
        {
            System.out.println("wall");
        }
        else if (c.equals(GREEN))
        {
            System.out.println("salvation");
        }
    }
    
    private boolean colorsMatch(Color a, Color b)
    {
        if (a.getRed() == b.getRed() && a.getGreen() == b.getGreen() && a.getBlue() == b.getBlue())
        {
            return true;
           
        }
        else {
            return false;
        }
  
    }
    
    
    
    
}
