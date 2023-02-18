package fuction;

public class Turnover {
    private double turnover;

    public Turnover() {
    }

    public Turnover(double turnover) {
        this.turnover = turnover;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "营业额是:" + turnover + "元";
    }
}
