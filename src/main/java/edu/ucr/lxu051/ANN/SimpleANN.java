package edu.ucr.lxu051.ANN;

import edu.ucr.lxu051.Utils.DataPoint;
import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class SimpleANN {

    private int hln; // hiddenLayerNum
    private int hlnn; // hiddenLayerNodeNum
    private int outputNum;
    private

    enum activationFunction {SIGMOID, RELU};
    enum initialWeights {RANDOM, ZERO};

    public SimpleANN(int hln, int hlnn, int on) {
        this.hln = hln;
        this.hlnn = hlnn;
        this.outputNum = on;
    }

    public void train(List<DataPoint> dataSet) {
        double[] d = new double[2];
        SimpleMatrix a = new SimpleMatrix(2, 1, true, d);
        a.dot(a);
    }
}
