package edu.ucr.lxu051.Utils;

public class DataPoint {
    private byte[] image;
    private byte label;

    public DataPoint(byte[] image, byte label) {
        assert image.length == 784;
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
