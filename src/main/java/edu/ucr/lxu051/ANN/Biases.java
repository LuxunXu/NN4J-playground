package edu.ucr.lxu051.ANN;

import java.io.Serializable;

public class Biases implements Serializable {
    private double[] biases;

    public Biases(int size) {
        this.biases = new double[size];
    }

    public double[] getBiases() {
        return biases;
    }
}
