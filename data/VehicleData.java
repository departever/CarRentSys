package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleData {
    Gson gson = new Gson();
    public String jsonFilePath = "./data/VehicleData.json";

    public VehicleData() {
    }

    public List<Vehicle> loadList() {
        try {
            var fr = new FileReader(jsonFilePath);
            return gson.fromJson(fr, new TypeToken<List<Vehicle>>() {}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Vehicle>();
        }
    }
}
