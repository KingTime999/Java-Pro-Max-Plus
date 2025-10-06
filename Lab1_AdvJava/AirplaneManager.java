package Lab1_AdvJava;
import java.time.LocalTime;
import java.util.Scanner;

public class AirplaneManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== AIRPLANE MANAGEMENT SYSTEM ===");
        
        
        Airplane flight1 = createAirplaneFromInput(scanner, 1);
        Airplane flight2 = createAirplaneFromInput(scanner, 2);
        
        
        System.out.println("\n=== Initial Status ===");
        flight1.checkStatus();
        flight2.checkStatus();
        
        
        System.out.println("\n=== Delay Processing ===");
        processDelays(scanner, flight1, flight2);
        
        
        System.out.println("\n=== Update Information ===");
        updateFlightInfo(scanner, flight1, flight2);
        
        
        System.out.println("\n=== Final Status ===");
        System.out.println(flight1);
        System.out.println(flight2);
        
        scanner.close();
    }
    
    private static Airplane createAirplaneFromInput(Scanner scanner, int flightNumber) {
        System.out.println("\nEnter details for Flight " + flightNumber + ":");
        
        System.out.print("Flight Number: ");
        String number = scanner.nextLine();
        
        System.out.print("Destination: ");
        String destination = scanner.nextLine();
        
        System.out.print("Departure Hour (0-23): ");
        int hour = scanner.nextInt();
        
        System.out.print("Departure Minute (0-59): ");
        int minute = scanner.nextInt();
        scanner.nextLine(); 
        
        LocalTime departureTime = LocalTime.of(hour, minute);
        return new Airplane(number, destination, departureTime);
    }
    
    private static void processDelays(Scanner scanner, Airplane... flights) {
        for (Airplane flight : flights) {
            System.out.print("Enter delay time for " + flight.getFlightNumber() + " (minutes, 0 for no delay): ");
            int delay = scanner.nextInt();
            scanner.nextLine(); 
            
            if (delay > 0) {
                flight.delay(delay);
            }
            flight.checkStatus();
        }
    }
    
    private static void updateFlightInfo(Scanner scanner, Airplane... flights) {
        for (Airplane flight : flights) {
            System.out.println("\nUpdate " + flight.getFlightNumber() + ":");
            
            System.out.print("New destination (press Enter to keep current): ");
            String newDest = scanner.nextLine();
            if (!newDest.trim().isEmpty()) {
                flight.setDestination(newDest);
            }
            
            System.out.print("New delay to add (minutes, 0 for no change): ");
            int additionalDelay = scanner.nextInt();
            scanner.nextLine(); 
            
            if (additionalDelay > 0) {
                flight.delay(additionalDelay);
            }
        }
    }
}