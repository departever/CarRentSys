package fuction;

import person.Tour;

public class Menu {
    public static void showMainMenu(){
        System.out.println("------欢迎使用梦鸿租车系统------");
        System.out.println("1.登录");//1
        System.out.println("2.注册");//1
        System.out.println("3.游客模式");//1
        System.out.println("4.退出");//1
        System.out.print("请输入选项(1-4)：");
    }

    public static void showUserMenu(){
        System.out.println("------普通用户------");
        System.out.println("1.查看车辆");//1
        System.out.println("2.租车");//1
        System.out.println("3.换车");//1
        System.out.println("4.还车");//1
        System.out.println("5.升级VIP");//1
        System.out.println("6.修改密码");//1
        System.out.println("7.退出");//1
        System.out.print("请输入选项(1-7)：");
    }

    public static void showManagerMenu(){
        System.out.println("------管理员------");
        System.out.println("1.查看车辆");//1
        System.out.println("2.添加车辆");//1
        System.out.println("3.删除车辆");//1
        System.out.println("4.修改车辆");//1
        System.out.println("5.查看营业额");//1
        System.out.println("6.注册管理员");//1
        System.out.println("7.退出");//1
        System.out.print("请输入选项(1-7)：");
    }

    public static void showVIPMenu(){
        System.out.println("------VIP用户------");
        System.out.println("1.查看车辆");//1
        System.out.println("2.租车(9折)");//1
        System.out.println("3.换车");//1
        System.out.println("4.还车");//1
        System.out.println("5.模拟付款");//1
        System.out.println("6.指定车型展示");//1
        System.out.println("7.退出");//1
        System.out.print("请输入选项(1-7)：");
    }

    public static void showTourMenu(){
        System.out.println("------游客模式------");
        System.out.println("1.查看车辆");//1
        System.out.println("2.登录");//1
        System.out.println("3.回到主界面");//1
        System.out.println("4.退出");//1
        System.out.print("请输入选项(1-4)：");
    }

    public static void menu(){
        Menu.showMainMenu();
        int choice = Util.getChoice(1, 4);
        switch (choice){
            case 1:
                //登录
                Login.login();
            case 2:
                //注册
                Util.register();
            case 3:
                //游客
                Tour.tourMethod();
            case 4:
                System.out.println("退出成功！");
                System.exit(0);
        }
    }
}
