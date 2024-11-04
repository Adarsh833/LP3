import java.util.Scanner;

public class Fibonacci {
    private static int stepCount = 0; 
    public static int fibonacci(int n) {
        stepCount++; 

        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the position of the Fibonacci number to calculate: ");
        int n = scanner.nextInt(); 
        
        stepCount = 0; 

        int result = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        System.out.println("Number of steps taken: " + stepCount);
        
        scanner.close();
    }
}
