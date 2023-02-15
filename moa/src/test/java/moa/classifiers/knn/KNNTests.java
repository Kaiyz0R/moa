package moa.classifiers.knn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KNNTests {

    @Test
    public void testKNN() {
        List<double[]> trainingSet = new ArrayList<>();
        trainingSet.add(new double[] {0.5, 0.5, 1.0});
        trainingSet.add(new double[] {0.7, 0.6, 1.0});
        trainingSet.add(new double[] {0.2, 0.3, 0.0});
        trainingSet.add(new double[] {0.4, 0.2, 0.0});

        double[] newInst = new double[] {0.6, 0.4};
        int k = 3;

        int result = KNN.knn(trainingSet, newInst, k);
        assertEquals(0, result);
    }
}
