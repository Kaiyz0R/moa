package moa.classifiers.knn;
import java.util.*;

public class KNN {
    public static int knn(List<double[]> trainingSet, double[] newInst, int k) {
        PriorityQueue<double[]> nearestNeighbors = new PriorityQueue<>(
                k, Comparator.comparingDouble(inst -> distance(inst, newInst))
        );

        for (double[] inst : trainingSet) {
            nearestNeighbors.offer(inst);
            if (nearestNeighbors.size() > k) {
                nearestNeighbors.poll();
            }
        }

        int numTrue = 0;
        int numFalse = 0;
        for (double[] inst : nearestNeighbors) {
            if (inst[inst.length-1] == 1.0) {
                numTrue++;
            } else {
                numFalse++;
            }
        }
        return numTrue > numFalse ? 1 : 0;
    }

    private static double distance(double[] inst1, double[] inst2) {
        double sum = 0.0;
        for (int i = 0; i < inst1.length - 1; i++) {
            double diff = inst1[i] - inst2[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }
}
