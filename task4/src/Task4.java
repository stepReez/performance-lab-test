import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        String fileName = args[0];

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        numbers = numbers.stream().sorted().collect(Collectors.toList());

        int med = numbers.get(numbers.size() / 2);

        int answer = numbers.stream().mapToInt(number -> (Math.abs(number - med))).sum();

        System.out.println(answer);
    }
}