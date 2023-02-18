package person;

import vehicle.Vehicle;

public class Person {
    protected String account;

    protected String password;

    protected int power;

    public Person() {
    }

    public Person(String account, String password, int power) {
        this.account = account;
        this.password = password;
        this.power = power;
    }

    public Person(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Person{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", power=" + power +
                '}';
    }

    public static void showVehicles(){
        Vehicle.showAllVehicle();
    }
}
