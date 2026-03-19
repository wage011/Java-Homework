import java.util.Arrays;

public class Statistic {

    public static double max(double[] a) {
        double maxVal = a[0];
        for (double v : a) {
            if (v > maxVal) maxVal = v;
        }
        return maxVal;
    }
    public static double min(double[] a) {
        double minVal = a[0];
        for (double v : a) {
            if (v < minVal) minVal = v;
        }
        return minVal;
    }
    public static double mean(double[] a) {
        double sum = 0;
        for (double v : a) {
            sum += v;
        }
        return sum / a.length;
    }
    public static double variance(double[] a) {
        double meanVal = mean(a);
        double sum = 0;
        for (double v : a) {
            sum += Math.pow(v - meanVal, 2);
        }
        return sum / a.length;
    }
    public static double select(double[] a, int k) {
        double[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        return copy[copy.length - k];
    }
    public static int[] histogram(double[] a, double[] b) {
        int[] hist = new int[b.length - 1];
        for (double val : a) {
            for (int i = 0; i < b.length - 1; i++) {
                if (val >= b[i] && val < b[i + 1]) {
                    hist[i]++;
                    break;
                }
                if (i == b.length - 2 && val == b[i + 1]) {
                    hist[i]++;
                    break;
                }
            }
        }
        return hist;
    }
}