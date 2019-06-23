package edu.ucr.lxu051;

import edu.ucr.lxu051.Utils.DrawingPanel;
import java.awt.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        testRead();
    }

    public static void testDraw() {
        DrawingPanel panel = new DrawingPanel(1920, 1080);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setGridLines(true);
        Graphics brush = panel.getGraphics();
    }

    public static void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("data/t10k-labels.idx1-ubyte");
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readInt()); // magic number
        System.out.println(dis.readInt()); // number of items
        System.out.println(dis.readUnsignedByte()); // label
        System.out.println(dis.readUnsignedByte());
        System.out.println(dis.readUnsignedByte());
        System.out.println(dis.readUnsignedByte());
    }
}
