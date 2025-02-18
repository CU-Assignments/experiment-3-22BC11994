import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a number: ");
        try {
            // Reading input from the user
            String input = scanner.nextLine();
            double number = Double.parseDouble(input);

            // Check if the number is negative
            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
            }

            // Calculate and print the square root of the number
            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is " + squareRoot);

        } catch (NumberFormatException e) {
            // Handle invalid non-numeric inputs
            System.out.println("Error: Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            // Handle case where the user enters a negative number
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected errors
            System.out.println("Error: An unexpected error occurred.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
