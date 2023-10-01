package lastpencil;

public class InputValidator {
    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input.replace("-", "a"));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isValidName(String name) {
        return name.matches("John|Jack");
    }

    public static boolean isValidNumberToRemove(String number) {
        return number.matches("[1-3]");
    }

    public static boolean isWithinBounds(int number, int max) {
        return number <= max;
    }
}