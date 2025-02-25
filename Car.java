import java.util.ArrayList;

/** 
 * Used as a container for Passenger objects 
 * It implements CarRequirements interface
*/
public class Car {
    
    /** Attributes */
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /** Constructor */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>();
    }
    
    /** Display Car class as string for car capacity readability */
    public String toString() {
        return "with capacity of " + maxCapacity;
    }

    /** Getter for the maximum capacity of the car */
    public int getCapacity() {
        return maxCapacity;
    }

    /** Getter for the number of remaining seats in the car */
    public int seatsRemaining() {
        return maxCapacity - passengersOnboard.size();
    }
    
    /**
     * Add passenger to car if there's available seat
     * @param p Passenger to be added
     * @return True if the passenger was successfully added, otherwise false
     */
    public boolean addPassenger(Passenger p) {
        if (maxCapacity > passengersOnboard.size()) {
            passengersOnboard.add(p);
            System.out.println("\nPassenger " + p + " aboarded the car.");
            return true;
        } else {
            System.out.println("\nNo available seats.");
            return false;
        }
    }

    /**
     * Removes a passenger from the car
     * @param p The passenger to be removed
     * @return True if the passenger was successfully removed, otherwise false
     */
    public boolean removePassenger(Passenger p) {
        if (passengersOnboard.contains(p)) {
            passengersOnboard.remove(p);
            System.out.println("\nPassenger " + p + " is removed from the car.");
            return true;
        } else {
            System.out.println("\nPassenger " + p + " can't be removed.");
            return false;
        }
    }
 
    /**
     * Prints out a list of all Passengers aboard the car
     * If there is no one on board, prints message
     */
    public void printManifest() {
        if (passengersOnboard.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("Passenger(s) onboard:");
            for (Passenger p : passengersOnboard) {
                System.out.println( "- " + p.getName());
            }
        }
    }

    /**
     * Test Car class using main
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTest Car class");
        Car myCar = new Car(1);
        Passenger Kaia = new Passenger("Kaia");
        Passenger John = new Passenger("John");
        myCar.removePassenger(John); // should not remove John
        myCar.addPassenger(Kaia);
        myCar.removePassenger(Kaia);
        myCar.printManifest(); // should print empty car
        myCar.addPassenger(Kaia);
        myCar.addPassenger(John); // should not add
        myCar.printManifest();

    }


}
