package fuction;

import com.google.gson.Gson;
import data.PersonData;
import data.TurnoverData;
import person.Person;
import vehicle.Vehicle;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;


public class Util {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * 注册
     */
    public static void register() {
        Gson gson = new Gson();
        PersonData personData = new PersonData();
        List<Person> ls = personData.loadList();
        Person person = new Person();
        System.out.println("请输入要注册的账号:");
        String account = scanner.next();
        System.out.println("请输入要注册的密码:");
        String password = scanner.next();
        for (int i = 0; i < ls.size(); i++) {
            if (account.equals(ls.get(i).getAccount())) {
                System.out.println("账号已存在,请重新输入");
                register();
            }
        }
        if (judgeLength(account) && judgeLength(password)) {
            person.setAccount(account);
            person.setPassword(password);
            ls.add(person);
            try (Writer r = new FileWriter(personData.jsonFilePath)) {
                String json = gson.toJson(ls);
                r.write(json);
            } catch (IOException e) {
                System.out.println("存储错误...");
            }
            System.out.println("保存成功！");
            Menu.menu();
        } else {
            System.out.println("账号或密码长度不在范围内...请重新输入");
            register();
        }
    }

    /**
     * 判断输入的数字&&选项选择
     */
    public static int getChoice(int min, int max) {
        String s;
        int i;
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        try {
            i = Integer.parseInt(String.valueOf(s));
        } catch (NumberFormatException e) {
            System.out.println("输入的不是数字，请重新输入...");
            return getChoice(min, max);
        }
        if (i > max || i < min) {
            System.out.println("数字不在范围内，请重新输入...");
            return getChoice(min, max);
        }
        return i;
    }

    /**
     * y/n选择器
     */
    public static boolean choose(char c) {
        if (c == 'y' || c == 'Y') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 询问是否展示车辆菜单
     */
    public static void askShowVehicle() {
        System.out.println("是否展示车辆清单？y");
        String s = scanner.next();
        if (s.length() > 1) {
            System.out.println("非法输入...");
            askShowVehicle();
        }
        char c = s.charAt(0);
        if (choose(c)) {
            Vehicle.showAllVehicle();
        }
    }

    /**
     * 整数选择
     */
    public static int inputNum() {
        int i = 0;
        String s = scanner.next();
        try {
            i = Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            System.out.println("输入的不是数字,请重新输入...");
        }
        return i;
    }

    /**
     * 浮点数选择
     */
    public static double inputDouble() {
        double i = 0.0;
        String s = scanner.next();
        try {
            i = Double.parseDouble(s);
        } catch (IllegalArgumentException e) {
            System.out.println("输入的不是数字,请重新输入...");
            inputDouble();
        }
        return i;
    }

    /**
     * 等待输入
     */
    public static void waitUser() {
        var scanner = new Scanner(System.in);
        System.out.println("输入任意字符回车以继续...");
        scanner.next();
    }

    /**
     * 车牌的正则表达式判断
     */
    public static String judgePlate() {
        String Id = scanner.next();
        String patten = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1}";
        boolean isMatch = Pattern.matches(patten, Id);
        if (isMatch) {
            return Id;
        }
        System.out.println("输入的不是车牌,请重新输入...");
        return judgePlate();
    }

    /**
     * 计算营业额
     */
    public static void checkTurnover(double turnover) {
        Gson gson = new Gson();
        TurnoverData turnoverData = new TurnoverData();
        List<Turnover> ls = turnoverData.loadList();
        double tv = ls.get(0).getTurnover() + turnover;
        ls.get(0).setTurnover(tv);
        try (Writer r = new FileWriter(turnoverData.jsonFilePath)) {
            String json = gson.toJson(ls);
            r.write(json);
        } catch (IOException e) {
            System.out.println("存储错误...");
        }
    }

    /**
     * 展示营业额
     *
     * @return
     */
    public static void showTurnover() {
        Gson gson = new Gson();
        TurnoverData turnoverData = new TurnoverData();
        List<Turnover> ls = turnoverData.loadList();
        System.out.println(ls.get(0).toString());
    }

    /**
     * 判断字符长度
     */
    public static boolean judgeLength(String s) {
        if (s.length() < 2 || s.length() > 8) {
            return false;
        }
        return true;
    }

    /**
     * 退出系统
     */
    public static void exit() {
        System.exit(0);
    }
}





