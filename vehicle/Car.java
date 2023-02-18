package vehicle;

import com.google.gson.Gson;
import data.VehicleData;
import fuction.Show;

import java.util.List;

public class Car extends Vehicle implements Show {

    public Car() {
    }

    public Car(String type, String brand, String id, Double perRent, String model, String state) {
        super("Car", brand, id, perRent, model, state);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void exclusiveShow() {
        VehicleData data = new VehicleData();
        Vehicle[] vehicles = data.loadList().toArray(Vehicle[]::new);
        System.out.println("——————————汽车清单如下———————————");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getType().equals("Car")) {
                System.out.println(vehicles[i].toString());
            }
        }
        System.out.println("——————————————————————————————");
    }
}
