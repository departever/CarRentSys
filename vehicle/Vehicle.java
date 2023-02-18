package vehicle;

import data.VehicleData;

public class Vehicle {
    private String type;//种类

    private String brand;//品牌

    private String id;//车牌

    private Double perRent;//日租金

    private String model;//型号

    private String state;//出租状态

    public Vehicle() {
    }

    public Vehicle(String type, String brand, String id, Double perRent, String model, String state) {
        this.type = type;
        this.brand = brand;
        this.id = id;
        this.perRent = perRent;
        this.model = model;
        this.state = state;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPerRent() {
        return perRent;
    }

    public void setPerRent(Double perRent) {
        this.perRent = perRent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return type + "|" + brand + "|" + id + "|" + "租金:" + perRent + "元" + "|" + "型号:" + model + "|" + state;
    }

    /**
     * 查看车辆
     */
    public static void showAllVehicle() {
        VehicleData data = new VehicleData();
        Vehicle[] vehicles = data.loadList().toArray(Vehicle[]::new);
        System.out.println("————————————————车辆信息如下————————————————");
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].toString());
        }
        System.out.println("——————————————————展示完毕—————————————————");
    }
}
