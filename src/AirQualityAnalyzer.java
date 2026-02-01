/*
 * Project: Air Quality Analyzer & Alert System
 * Description:
 * A simple Java console application that analyzes AQI data from a CSV file.
 * Designed for educational and data analysis purposes.
 */

import java.io.*;
import java.util.*;

public class AirQualityAnalyzer {

    // File path for CSV input
    private static final String DATA_FILE = "data/aqi_sample.csv";
    // AQI threshold for alerts
    private static final int AQI_ALERT_THRESHOLD = 100;

    public static void main(String[] args) {
        List<Integer> aqiValues = readAQIData(DATA_FILE);
        if (aqiValues.isEmpty()) {
            System.out.println("No data found. Please check the CSV file.");
            return;
        }

        int maxAQI = Collections.max(aqiValues);
        int minAQI = Collections.min(aqiValues);
        double avgAQI = aqiValues.stream()
                                 .mapToInt(Integer::intValue)
                                 .average()
                                 .orElse(0);

        System.out.println("=== Air Quality Analysis ===");
        System.out.println("Days recorded: " + aqiValues.size());
        System.out.println("Maximum AQI: " + maxAQI);
        System.out.println("Minimum AQI: " + minAQI);
        System.out.printf("Average AQI: %.2f\n", avgAQI);

        // Alert for unsafe AQI
        for (int i = 0; i < aqiValues.size(); i++) {
            if (aqiValues.get(i) > AQI_ALERT_THRESHOLD) {
                System.out.println("⚠️  Day " + (i + 1)
                        + " AQI is unhealthy: " + aqiValues.get(i));
            }
        }

        System.out.println("Analysis complete. Data can be used for research or local awareness.");
    }

    // Reads AQI data from CSV file
    private static List<Integer> readAQIData(String filePath) {
        List<Integer> aqiList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int aqi = Integer.parseInt(line.trim());
                    aqiList.add(aqi);
                } catch (NumberFormatException e) {
                    // Skip invalid lines
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return aqiList;
    }
}
