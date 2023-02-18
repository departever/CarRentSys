package person;

import fuction.Login;
import fuction.Menu;
import fuction.Util;
import vehicle.Vehicle;

import static fuction.Util.*;

public class Tour {
    public Tour() {
    }

    public static void tourMethod(){
        Menu.showTourMenu();
        int choose = getChoice(1,4);
        switch (choose) {
            case 1:
                //查看车辆
                Vehicle.showAllVehicle();
                Util.waitUser();
                tourMethod();
                break;
            case 2:
                //登录
                Login.login();
                break;
            case 3:
                //回到主界面
                Menu.showMainMenu();
                choose = Util.getChoice(1,4);
                switch (choose){
                    case 1:
                        //登录
                        Login.login();
                    case 2:
                        //注册
                        Util.register();
                    case 3:
                        //游客
                        tourMethod();
                    case 4:
                        System.exit(0);
                }
                break;
            case 4:
                System.out.println("退出成功！");
                Util.exit();
        }
    }
}
