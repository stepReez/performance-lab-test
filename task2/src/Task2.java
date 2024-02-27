import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Task2 {
    public static void main(String[] args) {
        String fileName1 = args[0];
        String fileName2 = args[1];

        double[] center = new double[2];
        double radius = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            String line;

            line = reader.readLine();
            center = Arrays.stream(line.split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            radius = Double.parseDouble(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<double[]> points = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName2))) {
            String line;

            while ((line = reader.readLine()) != null) {
                points.add(Arrays.stream(line.split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        double[] finalCenter = center;
        double finalRadius = radius;

        points.forEach(x -> System.out.println(aPointOnCircle(finalCenter, x, finalRadius)));
    }

    public static int aPointOnCircle (double[] center, double[] point, double radius) {
        double distance = Math.sqrt(Math.pow(center[0] - point[0], 2) + Math.pow(center[1] - point[1], 2));

        if (radius == distance) {
            return 0;
        } else if (radius > distance) {
            return 1;
        } else {
            return 2;
        }
    }
}