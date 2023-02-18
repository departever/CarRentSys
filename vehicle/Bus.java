package vehicle;

import com.google.gson.Gson;
import data.VehicleData;
import fuction.Show;

import java.util.List;

public class Bus extends Vehicle implements Show {

    public Bus() {
    }

    public Bus(String type, String brand, String id, Double perRent, String model, String state) {
        super("Bus", brand, id, perRent, model, state);
    }


    @Override
    public void exclusiveShow() {
        VehicleData data = new VehicleData();
        Vehicle[] vehicles = data.loadList().toArray(Vehicle[]::new);
        System.out.println("——————————客车清单如下———————————");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getType().equals("Bus")) {
                System.out.println(vehicles[i].toString());
            }
        }
        System.out.println("——————————————————————————————");
    }
}
