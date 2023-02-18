package fuction;

import data.PersonData;
import person.Manager;
import person.Person;
import person.User;
import person.VIP;

import java.util.List;

import static fuction.Util.*;


public class Login {
    public static void login() {
        System.out.println("请输入你的账号(长度2-8):");
        String account = scanner.next();
        System.out.println("请输入你的密码(长度2-8):");
        String password = scanner.next();
        if (judgeLength(account) && judgeLength(password)) {
            PersonData data = new PersonData();
            List<Person> ls = data.loadList();
            boolean flag = false;
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).getAccount().equals(account) && ls.get(i).getPassword().equals(password)) {
                    flag = true;
                    System.out.println("登录成功");
                    if (ls.get(i).getPower() == 0) {
                        User user = new User(account, password);
                        Menu.showUserMenu();
                        PersonMethod.UserMethod(getChoice(1, 7), user);
                    } else if (ls.get(i).getPower() == 1) {
                        VIP vip = new VIP(account, password);
                        Menu.showVIPMenu();
                        PersonMethod.VIPMethod(getChoice(1, 7));
                    } else if (ls.get(i).getPower() == 2) {
                        Manager manager = new Manager(account, password);
                        Menu.showManagerMenu();
                        PersonMethod.managerMethod(getChoice(1, 7));
                    }
                }
            }
            if (flag == false) {
                System.out.println("登录失败,请重新输入...");
                login();
            }
        } else {
            System.out.println("账号或密码的长度不在范围内...请重新输入");
            login();
        }
    }
}
