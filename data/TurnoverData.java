package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fuction.Turnover;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TurnoverData {
    Gson gson = new Gson();
    public String jsonFilePath = "data/TurnoverData.json";

    public TurnoverData() {
    }

    public List<Turnover> loadList() {
        try {
            var fr = new FileReader(jsonFilePath);
            return gson.fromJson(fr, new TypeToken<List<Turnover>>() {}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Turnover>();
        }
    }
}
