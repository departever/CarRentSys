package vehicle;

import com.google.gson.Gson;
import data.VehicleData;
import fuction.Show;

import java.util.List;

public class Truck extends Vehicle implements Show {

    public Truck() {
    }

    public Truck(String type, String brand, String id, Double perRent, String model, String state) {
        super("Truck", brand, id, perRent, model, state);
    }


    @Override
    public void exclusiveShow() {
        VehicleData data = new VehicleData();
        Vehicle[] vehicles = data.loadList().toArray(Vehicle[]::new);
        System.out.println("——————————货车清单如下———————————");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getType().equals("Truck")) {
                System.out.println(vehicles[i].toString());
            }
        }
        System.out.println("——————————————————————————————");
    }
}
