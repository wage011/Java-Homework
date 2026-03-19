import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Compute {
    public static double[] readDataFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<Double> list = new ArrayList<>();

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(Double.valueOf(line));
                }
            }
            double[] data = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                data[i] = list.get(i);
            }

            return data;
        }
    }
}