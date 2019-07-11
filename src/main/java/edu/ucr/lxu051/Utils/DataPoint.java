package edu.ucr.lxu051.Utils;

public class DataPoint {
    private int inputNum;
    private byte[] image;
    private byte label;

    public DataPoint(byte[] image, byte label, int inputNum) {
        assert image.length == inputNum;
        this.inputNum = inputNum;
        this.image = image;
        this.label = label;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte getLabel() {
        return label;
    }

    public void setLabel(byte label) {
        this.label = label;
    }
}
