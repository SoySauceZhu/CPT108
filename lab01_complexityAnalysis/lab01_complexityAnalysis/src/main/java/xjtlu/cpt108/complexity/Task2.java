package xjtlu.cpt108.complexity;


import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        List<Map<String, List<Long>>> data = getData();

        String csvFilePath = "..\\output.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            Map<String, List<Long>> firstMap = data.get(0);
            String[] headers = firstMap.keySet().toArray(new String[0]);
            writer.writeNext(headers);

            for (Map<String, List<Long>> map : data) {
                String[] rowData = new String[headers.length];
                for (int i = 0; i < headers.length; i++) {
                    List<Long> list = map.get(headers[i]);
                    rowData[i] = list.toString().replaceAll("[\\[\\]]", "");
                }
                writer.writeNext(rowData);
            }

            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Map<String, List<Long>>> getData() {
        return new ArrayList<>(List.of(SortingHelper.ascending(), SortingHelper.descending(), SortingHelper.random(), SortingHelper.repeated(), SortingHelper.randomString()));
    }
}
