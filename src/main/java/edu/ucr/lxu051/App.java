package edu.ucr.lxu051;

import edu.ucr.lxu051.Utils.DrawingPanel;
import java.awt.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App {

    public static final int SCALE = 20;

    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        drawPic(testDraw(), testRead());
    }

    public static Graphics testDraw() {
        DrawingPanel panel = new DrawingPanel(28 * SCALE, 28 * SCALE);
        panel.setBackground(Color.WHITE);
        panel.setGridLines(true);
        Graphics brush = panel.getGraphics();
        return brush;
    }

    public static int[] testRead() throws IOException {
        String fileName = "train-images.idx3-ubyte";
        FileInputStream fis = new FileInputStream("MnistData/" + fileName);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readInt()); // magic number
        System.out.println(dis.readInt()); // number of items
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        int[] pic = new int[784];
        for (int i = 0; i < 784; i++) {
            pic[i] = dis.readUnsignedByte();
        }
        return pic;
    }

    public static void drawPic(Graphics g, int[] pic) {
        for (int i = 0; i < 784; i++) {
            int pixel = pic[i];
            if (pixel != 0) {
                int color = 256 - pixel;
                Color newColor = new Color(color, color, color);
                g.setColor(newColor);
                g.fillRect(i % 28 * SCALE, i / 28 * SCALE, SCALE, SCALE);
            }
        }
    }
}
