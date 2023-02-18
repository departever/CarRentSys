package fuction;

import person.Manager;
import person.User;
import person.VIP;
import vehicle.Vehicle;

import static fuction.Util.*;

public class PersonMethod {
    public static void managerMethod(int choice) {
        Manager manager = new Manager();
        switch (choice) {
            case 1:
                Vehicle.showAllVehicle();
                Util.waitUser();
                Menu.showManagerMenu();
                managerMethod(scanner.nextInt());
                break;
            case 2:
                manager.insertVehicle();
                Util.waitUser();
                Menu.showManagerMenu();
                managerMethod(scanner.nextInt());
                break;
            case 3:
                manager.deleteVehicle();
                Util.waitUser();
                Menu.showManagerMenu();
                managerMethod(scanner.nextInt());
                break;
            case 4:
                manager.changeVehicle();
                Util.waitUser();
                Menu.showManagerMenu();
                managerMethod(scanner.nextInt());
                break;
            case 5:
                manager.lookTurnover();
                Util.waitUser();
                Menu.showManagerMenu();
                managerMethod(scanner.nextInt());
                break;
            case 6:
                manager.register();
                Util.waitUser();
                Menu.showManagerMenu();
                managerMethod(scanner.nextInt());
                break;
            case 7:
                System.out.println("退出成功！");
                Util.exit();
        }
    }

    public static void UserMethod(int choice, User user) {
        switch (choice) {
            case 1:
                //查看
                user.userShowAllVehicle();
                Util.waitUser();
                Menu.showUserMenu();
                UserMethod(scanner.nextInt(),user);
                break;
            case 2:
                //租车
                user.rentCar();
                Util.waitUser();
                Menu.showUserMenu();
                UserMethod(scanner.nextInt(),user);
                break;
            case 3:
                //换车
                user.changeCar();
                Util.waitUser();
                Menu.showUserMenu();
                UserMethod(scanner.nextInt(),user);
                break;
            case 4:
                //还车
                user.returnCar();
                Util.waitUser();
                Menu.showUserMenu();
                UserMethod(scanner.nextInt(),user);
            case 5:
                //升级VIP
                user.upgradeVIP(user);
                System.out.println("升级成功！请重新登录进入系统...");
                Util.exit();
            case 6:
                //修改密码
                user.changePassword(user);
                System.out.println("修改成功！请重新登录进入系统...");
                Util.exit();
            case 7:
                //退出
                System.out.println("退出成功！");
                Util.exit();
        }
    }

    public static void VIPMethod(int choice) {
        VIP vip = new VIP();
        switch (choice) {
            case 1:
                //查看全部车辆
                vip.userShowAllVehicle();
                Util.waitUser();
                Menu.showVIPMenu();
                VIPMethod(getChoice(1,7));
                break;
            case 2:
                //租车
                vip.rentCar();
                Util.waitUser();
                Menu.showVIPMenu();
                VIPMethod(getChoice(1,7));
                break;
            case 3:
                //换车
                vip.changeCar();
                Util.waitUser();
                Menu.showVIPMenu();
                VIPMethod(getChoice(1,7));
                break;
            case 4:
                //还车
                vip.returnCar();
                Util.waitUser();
                Menu.showVIPMenu();
                VIPMethod(getChoice(1,7));
                break;
            case 5:
                //模拟付款
                vip.simulatedPayment();
                Util.waitUser();
                Menu.showVIPMenu();
                VIPMethod(getChoice(1,7));
                break;
            case 6:
                //专属展示
                vip.show();
                Util.waitUser();
                Menu.showVIPMenu();
                VIPMethod(getChoice(1,7));
            case 7:
                //退出
                System.out.println("退出成功！");
                Util.exit();
        }
    }
}
