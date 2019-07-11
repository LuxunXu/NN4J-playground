package edu.ucr.lxu051;

import edu.ucr.lxu051.ANN.SimpleANN;
import edu.ucr.lxu051.Utils.DataPoint;
import edu.ucr.lxu051.Utils.MnistFileReader;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        train();
//        SimpleANN simpleANN = (SimpleANN) load("MnistData/Exp/training(2,16)");
    }

    public static SimpleANN train() throws IOException {
        SimpleANN simpleANN = new SimpleANN(2, 16, 10, 28*28);
        MnistFileReader mnistFileReader = new MnistFileReader();
        List<DataPoint> trainingData = mnistFileReader.read("MnistData", "test");
        simpleANN.train(trainingData);
        save("MnistData/Exp/training(2,16)", simpleANN);
        return simpleANN;
    }


    public static Object load(String fileName) {
        try {
            Object obj = null;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            obj = is.readObject();
            is.close();
            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void save(String fileName, Object obj) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
