
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
class Customer{ //define Class for Customer to declare its attributes
    String customerId;
    String cus_name;
    String cus_email;
    String telephone;

    public Customer(String cus_id, String cus_name,String cus_email,String cus_tp){ //Parameterized constructor for pass the values
        this.customerId=cus_id;
        this.cus_name=cus_name;
        this.cus_email=cus_email;
        this.telephone=cus_tp;
    }
}

class CustomerNode{ //Define class to contain Customer attributes into a node
    Customer cus;
    CustomerNode next;

    public CustomerNode(Customer cus){ //Paramiterized constructor to pass Customer Object
        this.cus=cus;
        this.next=null;
    }

}
public class Main {
    public static void main(String[] args) {


    }
}