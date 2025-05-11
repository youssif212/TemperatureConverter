public class TemperatureUtils {

    public static double convertTemperature(double value, String from, String to) {
        //دا من أي وحدة ل سيلزيوس
        if (from.equals("Fahrenheit")) {
            value = (value - 32) * 5 / 9;
        } else if (from.equals("Kelvin")) {
            value = value - 273.15;
        }

        //دا تحويل من سيليزيوس بقا لأي وحدة
        if (to.equals("Fahrenheit")) {
            return value * 9 / 5 + 32;
        } else if (to.equals("Kelvin")) {
            return value + 273.15;
        } else {
            return value; // دا عشان لو اليوزر عملها من سيليزوس ل سيليزيوس
        }
    }
}