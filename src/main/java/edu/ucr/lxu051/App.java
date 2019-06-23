package edu.ucr.lxu051;

import edu.ucr.lxu051.Utils.DrawingPanel;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        DrawingPanel panel = new DrawingPanel(1920, 1080);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setGridLines(true);
        Graphics brush = panel.getGraphics();

    }
}
