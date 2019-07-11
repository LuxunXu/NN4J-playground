package edu.ucr.lxu051.Utils;

import java.io.Serializable;

public class DataPoint implements Serializable {
    private int inputNum;
    private double[] image;
    private int label;

    public DataPoint(double[] image, int label, int inputNum) {
        assert image.length == inputNum;
        this.inputNum = inputNum;
        this.image = image;
        this.label = label;
    }

    public double[] getImage() {
        return image;
    }

    public void setImage(double[] image) {
        this.image = image;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(byte label) {
        this.label = label;
    }
}
