
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Vehicle{  //define Class for vehicle to declare its attributes
    String vehicle_id;
    String vehicle_brand;
    String vehicle_model;
    String vehicle_type;
    boolean available;
    double chargePerDay;
    String customerId;
    LocalDate rentDate;
    LocalDate returnDate;

    public Vehicle(String vehicle_id,String vehicle_brand,String vehicle_model,String vehicle_type,double chargePerDay){  //Parameterized constructor for pass the values
        this.vehicle_id=vehicle_id;
        this.vehicle_brand=vehicle_brand;
        this.vehicle_model=vehicle_model;
        this.vehicle_type=vehicle_type;
        this.chargePerDay=chargePerDay;
        this.available=true;
    }

}
public class Main {
    public static void main(String[] args) {


    }
}