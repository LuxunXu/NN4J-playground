package edu.ucr.lxu051.ANN;

import edu.ucr.lxu051.Utils.DataPoint;
import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class SimpleANN {

    private int hln; // hiddenLayerNum
    private int hlnn; // hiddenLayerNodeNum
    private int outputNum;
    private int inputNum;
    private Weights[] weights;
    private Biases[] biases;

    enum activationFunction {SIGMOID, RELU};
    enum initialWeights {RANDOM, ZERO};

    public SimpleANN(int hln, int hlnn, int outputNum, int inputNum) {
        this.hln = hln;
        this.hlnn = hlnn;
        this.outputNum = outputNum;
        this.inputNum = inputNum;
    }

    public void train(List<DataPoint> dataSet) {
        double[] d = new double[2];

    }
}
