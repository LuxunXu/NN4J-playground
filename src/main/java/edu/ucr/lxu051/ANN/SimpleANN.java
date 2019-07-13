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
    private SimpleMatrix[] hlv; // hidden layer value
    private SimpleMatrix[] weights;
    private SimpleMatrix[][] weightsDeltas; //[num of training data points][]
    private SimpleMatrix[] biases;
    private SimpleMatrix[][] biasesDeltas; //[num of training data points][]
    private String activationFunction = "SIGMOID"; // {SIGMOID, RELU}
    private double learningRate = 0.05;

    public SimpleANN(int hln, int hlnn, int outputDim, int inputDim) {
        this.hln = hln;
        this.hlnn = hlnn;
        this.outputDim = outputDim;
        this.inputDim = inputDim;
        this.weights = new SimpleMatrix[hln+1];
        this.biases = new SimpleMatrix[hln+1];
        this.hlv = new SimpleMatrix[hln];
    }

    public void train(List<DataPoint> dataSet) {
        System.out.println("------------Training-----------");
        System.out.println("------------Initializing weights-----------");
        weights[0] = new SimpleMatrix(new Weights(hlnn, inputDim).getWeights());
        weights[hln] = new SimpleMatrix(new Weights(outputDim, hlnn).getWeights());
        for (int i = 1; i < hln; i++) {
            weights[i] = new SimpleMatrix(new Weights(hlnn, hlnn).getWeights());
        }
        biases[hln] = new SimpleMatrix(outputDim, 1, true, new Biases(outputDim).getBiases());
        for (int i = 0; i < hln; i++) {
            biases[i] =new SimpleMatrix(hlnn, 1, true, new Biases(hlnn).getBiases());
        }
        System.out.println(cost(dataSet.get(0).getLabel(), feedForward(dataSet.get(0))));
        System.out.println("------------BackPropagation-----------");
        this.weightsDeltas = new SimpleMatrix[dataSet.size()][];
        this.biasesDeltas = new SimpleMatrix[dataSet.size()][];
        for (int i = 0; i < dataSet.size(); i++) {
            backPropagation(dataSet.get(i), i);
        }
    }

    public SimpleMatrix sigmoid(SimpleMatrix a) {
        for (int i = 0; i < a.numRows(); i++) {
           a.set(i, 1.0 / (1.0 + Math.exp(-a.get(i))));
        }
        return a;
    }

    public SimpleMatrix feedForward(DataPoint dataPoint) {
        // first layer
        hlv[0] = sigmoid(weights[0].mult(dataPoint.getImage()).plus(biases[0]));
        // mid layers
        for (int j = 1; j < hln; j++) {
            hlv[j] = weights[j].mult(hlv[0]).plus(biases[j]);
        }
        // output layer
        SimpleMatrix outputValue = sigmoid(weights[hln].mult(hlv[hln-1]).plus(biases[hln]));
        System.out.printf(outputValue.toString());
        System.out.println();
        return outputValue;
    }

    public double cost(int label, SimpleMatrix output) {
        double cost = 0.0;
        for (int i = 0; i < outputDim; i++) {
            cost += Math.pow((label == i ? 1.0 : 0.0 - output.get(i)), 2);
        }
        return cost;
    }

    public boolean backPropagation(DataPoint dp, int index) {
        return true;
    }
}
