package edu.ucr.lxu051.Utils;

import org.ejml.simple.SimpleMatrix;

import java.io.Serializable;

public class DataPoint implements Serializable {
    private int inputNum;
    private SimpleMatrix image;
    private int label;

    public DataPoint(double[] image, int label, int inputNum) {
        assert image.length == inputNum;
        this.inputNum = inputNum;
        this.image = new SimpleMatrix(image.length, 1, true, image);
        this.label = label;
    }

    public SimpleMatrix getImage() {
        return image;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(byte label) {
        this.label = label;
    }
}
