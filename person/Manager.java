package person;

import com.google.gson.Gson;
import data.PersonData;
import data.VehicleData;
import fuction.Menu;
import fuction.Util;
import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static fuction.Util.*;

public class Manager extends Person {

    public Manager() {
        power = 2;
    }

    public Manager(String account, String password) {
        super(account, password);
        power = 2;
    }

    /**
     * 增加车辆
     */
    public boolean insertVehicle() {
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        Vehicle vehicle = new Vehicle();
        System.out.println("请输入要添加的车型:1.汽车 2.客车 3.货车");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Car car = new Car();
                car.setType("Car");
                System.out.println("请输入车牌:");
                car.setId(judgePlate());
                System.out.println("请输入品牌:");
                car.setBrand(scanner.next());
                System.out.println("请输入租金:");
                car.setPerRent(inputDouble());
                System.out.println("请输入型号:");
                car.setModel(scanner.next());
                car.setState("未租出");
                ls.add(car);
                try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                    String json = gson.toJson(ls);
                    r.write(json);
                } catch (IOException e) {
                    System.out.println("存储错误...");
                    return false;
                }
                System.out.println("保存成功！");
                break;
            case 2:
                Bus bus = new Bus();
                bus.setType("Bus");
                System.out.println("请输入车牌:");
                bus.setId(judgePlate());
                System.out.println("请输入品牌:");
                bus.setBrand(scanner.next());
                System.out.println("请输入租金:");
                bus.setPerRent(inputDouble());
                System.out.println("请输入型号:");
                bus.setModel(scanner.next());
                bus.setState("未租出");
                ls.add(bus);
                try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                    String json = gson.toJson(ls);
                    r.write(json);
                } catch (IOException e) {
                    System.out.println("存储错误...");
                    return false;
                }
                System.out.println("保存成功！");
                break;
            case 3:
                Truck truck = new Truck();
                truck.setType("Truck");
                System.out.println("请输入车牌:");
                truck.setId(judgePlate());
                System.out.println("请输入品牌:");
                truck.setBrand(scanner.next());
                System.out.println("请输入租金:");
                truck.setPerRent(inputDouble());
                System.out.println("请输入型号:");
                truck.setModel(scanner.next());
                truck.setState("未租出");
                ls.add(truck);
                try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                    String json = gson.toJson(ls);
                    r.write(json);
                } catch (IOException e) {
                    System.out.println("存储错误...");
                    return false;
                }
                System.out.println("保存成功！");
                break;
        }
        return true;
    }

    /**
     * 删除车辆
     */
    public void deleteVehicle() {
        boolean flag = false;
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        askShowVehicle();
        System.out.println("请输入要删除车辆的车牌号:");
        String Id = scanner.next();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equals(Id)) {
                System.out.println("要删除的车辆车牌是:" + ls.get(i).getId());
                ls.remove(ls.get(i));
                try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                    String json = gson.toJson(ls);
                    r.write(json);
                } catch (IOException e) {
                    System.out.println("存储错误...");
                }
                System.out.println("删除成功！");
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("输入的车牌不在列表内，请重新输入...");
            deleteVehicle();
        }
    }

    /**
     * 修改车辆
     */
    public void changeVehicle() {
        int flag = 0;
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        askShowVehicle();
        System.out.println("请输入要修改车辆的车牌号:");
        String id = judgePlate();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equals(id)) {
                flag = 1;
                System.out.println("要修改的车辆车牌是:" + ls.get(i).getId());
                System.out.println("是否确认？y");
                if (scanner.next().equals("y")) {
                    System.out.println("请输入要要修改成的车型:1.汽车 2.客车 3.货车");
                    int choice = getChoice(1, 3);
                    switch (choice) {
                        case 1:
                            ls.get(i).setType("Car");
                            break;
                        case 2:
                            ls.get(i).setType("Bus");
                            break;
                        case 3:
                            ls.get(i).setType("Truck");
                            break;
                    }
                    System.out.println("请输入车牌:");
                    ls.get(i).setId(judgePlate());
                    System.out.println("请输入品牌:");
                    ls.get(i).setBrand(scanner.next());
                    System.out.println("请输入租金:");
                    ls.get(i).setPerRent(scanner.nextDouble());
                    System.out.println("请输入车型:");
                    ls.get(i).setModel(scanner.next());
                    System.out.println("修改完成！");
                    try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                        String json = gson.toJson(ls);
                        r.write(json);
                    } catch (IOException e) {
                        System.out.println("存储错误...");
                    }
                } else {
                    System.out.println("取消修改！");
                }
            }
        }
        if (flag == 0) {
            System.out.println("输入的车牌有误...");
        }
    }

    /**
     * 查看营业额
     */
    public void lookTurnover() {
        System.out.println("———————————————");
        Util.showTurnover();
        System.out.println("———————————————");
    }

    /**
     * 管理员注册
     */
    public void register(){
            Gson gson = new Gson();
            PersonData personData = new PersonData();
            List<Person> ls = personData.loadList();
            Person person = new Manager();
            System.out.println("请输入要注册的管理员账号:");
            String account = scanner.next();
            System.out.println("请输入要注册的密码:");
            String password = scanner.next();
            for (int i = 0; i < ls.size(); i++) {
                if (account.equals(ls.get(i).getAccount())) {
                    System.out.println("账号已存在,请重新输入");
                    register();
                }
            }
            person.setAccount(account);
            person.setPassword(password);
            person.setPower(2);
            ls.add(person);
            var file = new File(personData.jsonFilePath);
            try (Writer r = new FileWriter(personData.jsonFilePath)) {
                String json = gson.toJson(ls);
                r.write(json);
            } catch (IOException e) {
                System.out.println("存储错误...");
            }
            System.out.println("保存成功！");
            Menu.menu();
    }
}
