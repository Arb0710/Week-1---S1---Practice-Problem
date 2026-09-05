import java.util.Random;

public class P3_BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println(String.format("%-8s | %-10s | %-11s | %-8s | %-12s", "Person", "Height (m)", "Weight (kg)", "BMI", "Status"));
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.println(String.format("Person %-2d | %-10.2f | %-11.2f | %-8.2f | %-12s", (i + 1), heights[i], weights[i], bmi, status));
        }
    }

    public static void main(String[] args) {
        // Live Demo with sample data
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.72, 1.68, 1.78};
        double[] weights = {70.0, 90.0, 68.0, 50.0, 82.0, 45.0, 110.0, 75.0, 62.0, 85.0};

        printWellnessReport(heights, weights);
    }
}
