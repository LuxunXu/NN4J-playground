package edu.ucr.lxu051.ANN;

import java.io.Serializable;
import java.util.Random;

public class Weights implements Serializable {
    private double[] weights;
    private long seed = 1;

    public Weights(int size) {
        Random rnd = new Random();
        rnd.setSeed(seed);
        this.weights = new double[size];
        for (int i = 0; i < size; i++) {
            this.weights[i] = rnd.nextDouble();
        }
    }

    public double[] getWeights() {
        return weights;
    }

}
