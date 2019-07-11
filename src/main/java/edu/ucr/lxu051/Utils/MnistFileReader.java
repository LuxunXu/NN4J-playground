package edu.ucr.lxu051.Utils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MnistFileReader {

    private final String trainImage = "train-images.idx3-ubyte";
    private final String trainLabel = "train-labels.idx1-ubyte";
    private final String testImage = "t10k-images.idx3-ubyte";
    private final String testLabel = "t10k-labels.idx1-ubyte";

    public MnistFileReader() {
    }

    public List<DataPoint> read(String dir, String tt) throws IOException {
        List<DataPoint> list = new ArrayList<>();
        String imageFile;
        String labelFile;
        if (tt.equalsIgnoreCase("train")) {
            imageFile = trainImage;
            labelFile = trainLabel;
        } else if (tt.equalsIgnoreCase("test")) {
            imageFile = testImage;
            labelFile = testLabel;
        } else {
            throw new IllegalArgumentException();
        }
        FileInputStream fis = new FileInputStream(dir + "/" + labelFile);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readInt()); // magic number
        int numOfItems = dis.readInt(); // number of items
        int[] labels = new int[numOfItems];
        for (int i = 0; i < numOfItems; i++) {
            labels[i] = dis.readUnsignedByte();
        }
        fis = new FileInputStream(dir + "/" + imageFile);
        dis = new DataInputStream(fis);
        System.out.println(dis.readInt()); // magic number
        System.out.println(dis.readInt()); // number of items
        int row = dis.readInt(); // row
        int col = dis.readInt(); // column
        for (int i = 0; i < numOfItems; i++) {
            if (i % 1000 == 0) {
                System.out.println(i);
            }
            double[] image = new double[row*col];
            for (int j = 0; j < row*col; j++) {
                image[j] = dis.readUnsignedByte();
            }
            list.add(new DataPoint(image, labels[i], row*col));
        }
        fis.close();
        dis.close();
        return list;
    }
}
