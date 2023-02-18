package person;

import com.google.gson.Gson;
import data.PersonData;
import data.VehicleData;
import fuction.Util;
import vehicle.Vehicle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static fuction.Util.*;
import static java.lang.Thread.sleep;

public class User extends Person {
    public User() {
        power = 0;
    }

    public User(String account, String password) {
        super(account, password);
        power = 0;
    }

    /**
     * 展示车辆
     */
    public void userShowAllVehicle() {
        Vehicle.showAllVehicle();
    }

    /**
     * 租车
     */
    public void rentCar() {
        int flag = 0;
        askShowVehicle();
        System.out.println("请输入你要租用的车牌号:");
        String Id = judgePlate();
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equals(Id) && ls.get(i).getState().equals("未租出")) {
                System.out.println("要租用的车辆是" + ls.get(i).getBrand() + ls.get(i).getModel());
                System.out.println("请输入要租赁的天数:");
                int day = inputNum();
                double turnover = Turnover(ls.get(i), day);
                System.out.println("要支付的租金是:" + turnover + "元！");
                System.out.print("输入y确认租赁:");
                if (scanner.next().equals("y")) {
                    Util.checkTurnover(turnover);
                    ls.get(i).setState("已租出");
                    try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                        String json = gson.toJson(ls);
                        r.write(json);
                    } catch (IOException e) {
                        System.out.println("存储错误...");
                    }
                    flag = 1;
                    System.out.println("租赁成功！");
                } else {
                    flag = 1;
                    System.out.println("租赁失败...");
                }
            }
        }
        if (flag == 0){
            System.out.println("输入的车牌暂时不在系统内...请重新选择");
            rentCar();
        }
    }

    /**
     * 换车
     */
    public void changeCar() {
        int flag = 0, j = 0;
        Vehicle vehicle = new Vehicle();
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        askShowVehicle();
        System.out.println("请输入要归还更换的车牌号");
        String backId = judgePlate();
        for (j = 0; j < ls.size(); j++) {
            if (ls.get(j).getId().equals(backId) && ls.get(j).getState().equals("已租出")) {
                flag = 1;
                vehicle = ls.get(j);
                break;
            }
        }
        if (flag == 1) {
            Vehicle.showAllVehicle();
            System.out.println("请输入想换的车牌号:");
            String wantId = judgePlate();
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).getId().equals(wantId) && ls.get(i).getState().equals("未租出")) {
                    if (ls.get(i).getPerRent() > vehicle.getPerRent()) {
                        System.out.println("要更换的车辆租金更高，暂不给予更换...");
                    } else {
                        ls.get(j).setState("未租出");
                        ls.get(i).setState("已租出");
                        try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                            String json = gson.toJson(ls);
                            r.write(json);
                        } catch (IOException e) {
                            System.out.println("存储错误...");
                        }
                        System.out.println("更换成功！感谢使用...");
                    }
                } else if (ls.get(i).getId().equals(wantId) && ls.get(i).getState().equals("已租出")){
                    System.out.println("该车辆已被租赁...");
                    break;
                }
            }
        } else {
            System.out.println("找不到你的车牌/你没有租赁过这辆车...");
        }
    }

    /**
     * 还车
     */
    public void returnCar() {
        int flag = 0, i;
        askShowVehicle();
        System.out.println("请输入你要归还的车牌:");
        String backId = judgePlate();
        Gson gson = new Gson();
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> ls = vehicleData.loadList();
        for (i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equals(backId) && ls.get(i).getState().equals("已租出")) {
                flag = 1;
            }
        }
        if (flag == 1) {
            for (i = 0; i < ls.size(); i++) {
                if (ls.get(i).getId().equals(backId)) {
                    break;
                }
            }
            System.out.println("你要归还的车辆是" + ls.get(i).getBrand() + ls.get(i).getModel());
            new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            ls.get(i).setState("未租出");
            try (Writer r = new FileWriter(vehicleData.jsonFilePath)) {
                String json = gson.toJson(ls);
                r.write(json);
            } catch (IOException e) {
                System.out.println("存储错误...");
            }
            System.out.println("归还成功！");
        } else {
            System.out.println("你没有在系统内租赁过该车辆...");
        }
    }

    /**
     * 计算租车金额
     */
    public double Turnover(Vehicle vehicle, int day) {
        double turnover = 0;
        turnover = vehicle.getPerRent() * day;
        return turnover;
    }

    /**
     * 升级VIP
     */
     public void upgradeVIP(User user){
         int flag = 0;
         System.out.println("是否确认购买VIP资格？y");
         String s = scanner.next();
         if (s.length() > 1) {
             System.out.println("长度不符合要求...");
             upgradeVIP(user);
         }
         if (choose(s.charAt(0))) {
             Gson gson = new Gson();
             PersonData personData = new PersonData();
             List<Person> ls = personData.loadList();
             for (int i = 0; i < ls.size(); i++) {
                 if (ls.get(i).getPower() == 0 && ls.get(i).getAccount().equals(user.account)) {
                     ls.get(i).setPower(1);
                     flag = 1;
                     var file = new File(personData.jsonFilePath);
                     try (Writer r = new FileWriter(personData.jsonFilePath)) {
                         String json = gson.toJson(ls);
                         r.write(json);
                     } catch (IOException e) {
                         System.out.println("存储错误...");
                     }
                     break;
                 }
             }
             if (flag == 0){
                 System.out.println("已是更高等级用户...");
             }
         } else {
             System.out.println("取消升级...");
         }
     }

    /**
     * 修改密码
     */
     public void changePassword(User user){
         System.out.println("请输入你要修改的密码:");
         String pwd = scanner.next();
         if (judgeLength(pwd)){
             PersonData personData = new PersonData();
             Gson gson = new Gson();
             List<Person> ls = personData.loadList();
             for (int i = 0; i < ls.size(); i++) {
                 if (ls.get(i).getAccount().equals(user.account)){
                     ls.get(i).setPassword(pwd);
                 }
             }
             try (Writer r = new FileWriter(personData.jsonFilePath)) {
                 String json = gson.toJson(ls);
                 r.write(json);
             } catch (IOException e) {
                 System.out.println("存储错误...");
             }
         } else {
             System.out.println("密码长度不在范围内...请重新输入");
             changePassword(user);
         }
     }
}