package person;

import com.google.gson.Gson;
import data.VehicleData;
import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.List;

import static fuction.Util.*;


public class VIP extends User {
    public VIP() {
        power = 1;
    }

    public VIP(String account, String password) {
        super(account, password);
        power = 1;
    }

    /**
     * VIP租车
     */
    public void rentCar(){
        System.out.println("|您是vip用户,享受9折租车优惠|");
        super.rentCar();
    }

    /**
     * 9折租金
     */
    public double Turnover(Vehicle vehicle, int day){
        double turnover = 0;
        turnover = vehicle.getPerRent() * day * 0.9;
        return turnover;
    }

    /**
     * 模拟付款
     */
    public void simulatedPayment(){
        System.out.println("本次付款仅为模拟");
        boolean flag = true;
        userShowAllVehicle();
        System.out.println("请输入你要租用的车牌号:");
        String Id = judgePlate();
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equals(Id) && ls.get(i).getState().equals("未租出")) {
                System.out.println("您要租用的车辆是" + ls.get(i).getBrand() + ls.get(i).getModel());
                System.out.println("请输入要租赁的天数:");
                int day = inputNum();
                double turnover = Turnover(ls.get(i), day);
                System.out.println("要支付的租金是:" + turnover + "元！");
                System.out.println("模拟完毕！");
            }
        }
        if (flag == false){
            System.out.println("该车辆已被租赁/输入的车牌不存在...");
        }
    }

    /**
     * 专属展示
     */
    public void show(){
        System.out.println("请选择您想查看的车型:1.汽车 2.客车 3.货车");
        int choice = getChoice(1,3);
        switch (choice){
            case 1:
                Car car = new Car();
                car.exclusiveShow();
                break;
            case 2:
                Bus bus = new Bus();
                bus.exclusiveShow();
                break;
            case 3:
                Truck truck = new Truck();
                truck.exclusiveShow();
                break;
        }
    }
}