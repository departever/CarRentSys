package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import person.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PersonData {
    Gson gson = new Gson();
    public String jsonFilePath = "./data/PersonData.json";

    public PersonData() {
    }

    public List<Person> loadList() {
        try {
            var fr = new FileReader(jsonFilePath);
            return gson.fromJson(fr, new TypeToken<List<Person>>() {}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Person>();
        }
    }
}
