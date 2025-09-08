package Lab1_AdvJava;

public class DigitsDescending {
    public static int sortDigitsDescending(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (digits[j] < digits[j + 1]) {

                    int temp = digits[j];
                    digits[j] = digits[j + 1];
                    digits[j + 1] = temp;
                }
            }
        }
        
        
        int result = 0;
        for (int digit : digits) {
            result = result * 10 + digit;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Input: 42145 → Output: " + sortDigitsDescending(42145));
        System.out.println("Input: 145263 → Output: " + sortDigitsDescending(145263));
        System.out.println("Input: 951730 → Output: " + sortDigitsDescending(951730));
        System.out.println("Input: 9338491 → Output: " + sortDigitsDescending(9338491));
    }
}