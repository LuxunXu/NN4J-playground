package edu.ucr.lxu051.Utils;

import java.util.ArrayList;
import java.util.List;

public class MnistFileReader {

    private final String trainImage = "train-images.idx3-ubyte";
    private final String trainLabel = "train-labels.idx1-ubyte";
    private final String testImage = "t10k-images.idx3-ubyte";
    private final String testLabel = "t10k-labels.idx1-ubyte";

    public MnistFileReader() {
    }

    public List<DataPoint> read(String dir) {
        List<DataPoint> list = new ArrayList<>();
        
        return list;
    }
}
