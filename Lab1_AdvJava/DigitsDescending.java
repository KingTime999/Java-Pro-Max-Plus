package Lab1_AdvJava;
import java.util.Scanner;

public class DigitsDescending {
    public static int sortDigitsDescending(int num) {
        if (num == 0) {
            return 0;
        }
        
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (digits[j] < digits[j + 1]) {
                    char temp = digits[j];
                    digits[j] = digits[j + 1];
                    digits[j + 1] = temp;
                }
            }
        }
        return Integer.parseInt(new String(digits));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== DIGITS DESCENDING SORTER ===");
        System.out.println("Enter non-negative integers (enter -1 to exit)");
        
        while (true) {
            System.out.print("\nEnter a number: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
                continue;
            }
            
            int input = scanner.nextInt();
            if (input == -1) {
                System.out.println("Exiting program...");
                break;
            }
            
            if (input < 0) {
                System.out.println("Please enter a non-negative number!");
                continue;
            }
            int result = sortDigitsDescending(input);
            System.out.println("Input: " + input + " → Output: " + result);
        }
        
        scanner.close();
    }
}