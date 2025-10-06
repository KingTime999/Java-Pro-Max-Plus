package Lab1_AdvJava;

import java.time.LocalTime;

public class Airplane {
    private String flightNumber;
    private String destination;
    private LocalTime scheduledDeparture;
    private int delayTime; 
    

    public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.delayTime = 0;
    }
    

    public String getFlightNumber() {
        return flightNumber;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public LocalTime getScheduledDeparture() {
        return scheduledDeparture;
    }
    
    public int getDelayTime() {
        return delayTime;
    }
    

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void setScheduledDeparture(LocalTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }
    

    public void delay(int minutes) {
        if (minutes > 0) {
            this.delayTime += minutes;
            this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
            System.out.println("Flight " + flightNumber + " delayed by " + minutes + " minutes.");
        } else {
            System.out.println("Delay time must be positive!");
        }
    }
    

    public void checkStatus() {
        if (delayTime == 0) {
            System.out.println("Flight " + flightNumber + " to " + destination + 
                             " is on time. Departure: " + scheduledDeparture);
        } else {
            System.out.println("Flight " + flightNumber + " to " + destination + 
                             " is DELAYED by " + delayTime + " minutes. " +
                             "New departure: " + scheduledDeparture);
        }
    }
    


    public String toString() {
        return "Flight: " + flightNumber + 
               ", Destination: " + destination + 
               ", Scheduled: " + scheduledDeparture + 
               ", Delay: " + delayTime + " minutes";
    }
}