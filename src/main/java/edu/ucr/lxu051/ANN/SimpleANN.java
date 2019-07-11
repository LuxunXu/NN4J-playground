package edu.ucr.lxu051.ANN;

import edu.ucr.lxu051.Utils.DataPoint;
import org.ejml.simple.SimpleMatrix;

import java.io.*;
import java.util.List;

public class SimpleANN implements Serializable {

    private int hln; // hiddenLayerNum
    private int hlnn; // hiddenLayerNodeNum
    private int outputDim; // output dimension
    private int inputDim; // input dimension
    private double[][] hlv; // hidden layer value
    private Weights[] weights;
    private Biases[] biases;
    private String activationFunction = "SIGMOID"; // {SIGMOID, RELU}

    public SimpleANN(int hln, int hlnn, int outputDim, int inputDim) {
        this.hln = hln;
        this.hlnn = hlnn;
        this.outputDim = outputDim;
        this.inputDim = inputDim;
        this.weights = new Weights[hln+1];
        this.biases = new Biases[hln+1];
        this.hlv = new double[hln][hlnn];
    }

    public void train(List<DataPoint> dataSet) {
        System.out.println("------------Training-----------");
        System.out.println("------------Initializing weights-----------");
        weights[0] = new Weights(inputDim*hlnn);
        weights[hln] = new Weights(outputDim*hlnn);
        for (int i = 1; i < hln; i++) {
            weights[i] = new Weights(hlnn*hlnn);
        }
        biases[hln] = new Biases(outputDim);
        for (int i = 0; i < hln; i++) {
            biases[i] = new Biases(hlnn);
        }
        genResult(dataSet.get(0));
        System.out.println("------------BackPropagation-----------");
    }

    public double dot(double[] a, double[] b) {
        assert a.length == b.length;
        double ans = 0.0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i] * b[i];
        }
        return ans;
    }

    public double sigmoid(double a) {
        return 1.0 / (1.0 + Math.exp(-a));
    }

    public double[] genResult(DataPoint dataPoint) {
        // first layer
        double[] outputValue = new double[outputDim];
        for (int i = 0; i < hlnn; i++) {
            hlv[0][i] = sigmoid(dot(dataPoint.getImage(), weights[0].getWeights()) - biases[0].getBiases()[i]);
        }
        // mid layers
        for (int j = 1; j < hln; j++) {
            for (int i = 0; i < hlnn; i++) {
                hlv[j][i] = sigmoid(dot(hlv[j-1], weights[j].getWeights()) - biases[j].getBiases()[i]);
            }
        }
        for (int i = 0; i < outputDim; i++) {
            outputValue[i] = sigmoid(dot(hlv[hln-1], weights[hln].getWeights()) - biases[hln].getBiases()[i]);
            System.out.print(outputValue[i] + " ");
        }
        System.out.println();
        return outputValue;
    }

    public double cost(int label, double[] output) {
        double cost = 0.0;
        for (int i = 0; i < outputDim; i++) {
            cost += Math.pow((label == i ? 1.0 : 0.0 - output[i]), 2);
        }
        return Math.sqrt(cost);
    }
}
