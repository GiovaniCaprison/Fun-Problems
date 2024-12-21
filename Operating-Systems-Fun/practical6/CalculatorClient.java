import java.rmi.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Connect to the Calculator Service
            String name = "rmi://localhost/CalculatorService";
            Calculator calc = (Calculator) Naming.lookup(name);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.println("Enter second number: ");
            int num2 = scanner.nextInt();

            // Perform addition
            int result = calc.add(num1, num2);

            // Display the result
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

