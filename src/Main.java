
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
class VehicleNode{     //Define class to contain Vehicle attributes into a node
    Vehicle vehicle;
    VehicleNode prev;
    VehicleNode next;

    public VehicleNode(Vehicle vehicle) { //Paramiterized constructor to pass Vehicle Object
        this.vehicle=vehicle;
        this.prev=null;
        this.next=null;
    }

}
class RentalManagement {
    VehicleNode head = null;
    VehicleNode back = null;
    CustomerNode cus_head = null;
    int totalVehicles = 0;
    int totalCusomers = 0;
    Scanner sc = new Scanner(System.in);

    public RentalManagement() {

    }

    public boolean isVehicleExisist(String vehicleID) { // Method to check whether the vehicle id is exist or not
        VehicleNode current = head;
        while (current != null) {
            if (current.vehicle.vehicle_id.equals(vehicleID)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isCustomerExsist(String customerID) {  // Method to check whether the customer id is exist or not
        CustomerNode current = cus_head;
        while (current != null) {
            if (current.cus.customerId.equals(customerID)) {
                return true;
            }
        }
        return false;
    }

    public void addVehicle(String vehicle_id, String brand, String model, String type, double chargePerDay) {
        Vehicle newVehicle = new Vehicle(vehicle_id, brand, model, type, chargePerDay);
        VehicleNode newVehicleNode = new VehicleNode(newVehicle);

        if (isVehicleExisist(vehicle_id)) {
            System.err.println("This Vehicle is Already Exist");
            return;
        }

        if (head == null) {
            head = newVehicleNode;
            back = newVehicleNode;
        } else {
            back.next = newVehicleNode;
            newVehicleNode.prev = back;
            back = newVehicleNode;
        }
        totalVehicles++;
    }

    public void deleteVehicle(String vehicleID) {
        VehicleNode current = head;

        if (!isVehicleExisist(vehicleID)) {
            System.err.println("Vehicle does not exisist");
            return;
        }
        while (current != null) {
            if (current.vehicle.vehicle_id.equals(vehicleID)) {
                if (current.prev != null) {
                    current = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current = current.prev;
                } else {
                    back = current.prev;
                }
                totalVehicles--;
                return;
            }
            current = current.next;
        }
    }

    public void editVehicle(String vehicleId, String brand, String model, String type, double chargePerDay) {
        VehicleNode current = head;

        if (!isVehicleExisist(vehicleId)) {
            System.err.println("Vehicle does not exist");
            return;
        }

        while (current != null) {
            if (current.vehicle.vehicle_id.equals(vehicleId)) {
                current.vehicle.vehicle_brand = brand;
                current.vehicle.vehicle_model = model;
                current.vehicle.vehicle_type = type;
                current.vehicle.chargePerDay = chargePerDay;
                System.out.println("Vehicle Edited Successfully!");
                System.out.println("------------------------------");
                break;
            }
            current = current.next;
        }
    }

    public void add_customer(String cusID, String cusName, String email, String phone) {
        if (isCustomerExsist(cusID)) {
            System.err.println("This ID : " + cusID + " already exist.");
            return;
        }

        Customer newCus = new Customer(cusID, cusName, email, phone);
        CustomerNode cusNode = new CustomerNode(newCus);
        if (cus_head == null) {
            cus_head = cusNode;
        } else {
            CustomerNode current = cus_head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = cusNode;
        }
        totalCusomers++;
    }

    public void rent_to_customer(String customerId, String vehicleId, String bookingId, LocalDate bookingDate){
        VehicleNode current_vehicle=head;
        boolean vehicle_found=false;
        while(current_vehicle != null){
            if(current_vehicle.vehicle.vehicle_id.equals(vehicleId)){
                vehicle_found=true;
                if(!current_vehicle.vehicle.available){
                    System.err.println("This vehicle is already Rented");
                    return;
                }
                current_vehicle.vehicle.available=false;
                current_vehicle.vehicle.rentDate=bookingDate;
                break;
            }
            current_vehicle=current_vehicle.next;
        }

        if(!vehicle_found){
            System.err.println("Vehicle not found!!!");
            return;
        }

        CustomerNode current_customer=cus_head;
        boolean customer_found=false;
        while(current_customer!=null){
            if(current_customer.cus.customerId.equals(customerId)){
                customer_found=true;
                break;
            }
        }

        if(!customer_found){
            System.err.println("Customer not found!!!");
            return;
        }

        current_vehicle.vehicle.customerId=customerId;

        System.out.println("Vehicle " + vehicleId + " rented to customer " + customerId + " with booking ID  "+ bookingId);
    }
    public void show_available_vehicle(){
        System.out.println("Available vehicles: \n");
        VehicleNode current = head;
        boolean availables = false;
        while(current != null){
            if(current.vehicle.available){
                availables = true;
                System.out.println("Vehicle ID: " + current.vehicle.vehicle_id);
                System.out.println("Model: "+current.vehicle.vehicle_brand+" "+ current.vehicle.vehicle_model);
                System.out.println("Type: " + current.vehicle.vehicle_type);
                System.out.println("---------------------");
            }
            current = current.next;
        }if(!availables){
            System.err.println("All cars are rented.");
        }
    }

}
public class Main {
    public static void main(String[] args) {


    }
}