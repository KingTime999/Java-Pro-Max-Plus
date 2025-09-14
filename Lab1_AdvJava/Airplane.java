package Lab1_AdvJava;

import java.time.LocalTime;

public class Airplane {
    // 1. Khai báo các thuộc tính
    private String flightNumber;
    private String destination;
    private LocalTime scheduledDeparture;
    private int delayTime; // thời gian delay tính bằng phút
    
    // 2. Constructor
    public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.delayTime = 0; // mặc định không delay
    }
    
    // 3. Getter methods
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
    
    // 4. Setter methods
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void setScheduledDeparture(LocalTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }
    
    // 5. Phương thức delay chuyến bay
    public void delay(int minutes) {
        if (minutes > 0) {
            this.delayTime += minutes; // cộng dồn thời gian delay
            this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
            System.out.println("Flight " + flightNumber + " delayed by " + minutes + " minutes.");
        } else {
            System.out.println("Delay time must be positive!");
        }
    }
    
    // 6. Phương thức kiểm tra trạng thái chuyến bay
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
    
    // 7. Phương thức toString để hiển thị thông tin
    @Override
    public String toString() {
        return "Flight: " + flightNumber + 
               ", Destination: " + destination + 
               ", Scheduled: " + scheduledDeparture + 
               ", Delay: " + delayTime + " minutes";
    }
}