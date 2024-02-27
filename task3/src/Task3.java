import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        String fileName1 = args[0];
        String fileName2 = args[1];
        String fileName3 = args[2];

        Gson gson = new Gson();
        Values value;
        List<Value> values;
        Tests test;
        List<Test> tests;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            value = gson.fromJson(reader, Values.class);
            values = value.getValues();
        } catch (IOException e) {
            e.printStackTrace();
            values = new ArrayList<>();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName2))){
            test = gson.fromJson(reader, Tests.class);
            tests = test.getTests();
        } catch (IOException e) {
            e.printStackTrace();
            tests = new ArrayList<>();
            test = new Tests();
        }

        testsRecourse(tests, values);

        try (FileWriter fw = new FileWriter(fileName3)){
            gson.toJson(test, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testsRecourse(List<Test> test, List<Value> values) {
        for (Test tests : test) {
            if (tests.getValues() != null) {
                testsRecourse(tests.getValues(), values);
                addValue(tests, values);
            } else {
                addValue(tests, values);
            }
        }

    }

    public static void addValue(Test test, List<Value> values) {
        int id = test.getId();
        for (Value value : values) {
            if (value.getId() == id) {
                test.setValue(value.getValue());
                break;
            }
        }
    }

    public static class Values {
        List<Value> values;

        public List<Value> getValues() {
            return values;
        }

        public void setValues(List<Value> values) {
            this.values = values;
        }
    }

    public static class Value {
        int id;
        String value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class Tests {
        List<Test> tests;

        public List<Test> getTests() {
            return tests;
        }

        public void setTests(List<Test> tests) {
            this.tests = tests;
        }
    }

    public static class Test {
        int id;
        String title;
        String value;
        List<Test> values;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<Test> getValues() {
            return values;
        }

        public void setValues(List<Test> values) {
            this.values = values;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", value='" + value + '\'' +
                    ", values=" + values +
                    '}';
        }
    }
}