package edu.ucr.lxu051.ANN;

import java.io.Serializable;
import java.util.Random;

public class Weights implements Serializable {
    private double[][] weights;

    public Weights(int dim, int size) {
        Random rnd = new Random();
        Random rndPolar = new Random();
        this.weights = new double[dim][size];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < size; j++) {
                if (rndPolar.nextBoolean()) {
                    this.weights[i][j] = rnd.nextDouble() * 0.1;
                }
                this.weights[i][j] = rnd.nextDouble() * -0.1;
            }
        }
    }

    public double[][] getWeights() {
        return weights;
    }

}
