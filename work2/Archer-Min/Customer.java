import java.time.LocalDate;

public class Customer {
    private int times;
    private LocalDate lastArriveDate;

    public Customer(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimes() {
        this.times++;
    }

    public LocalDate getLastArriveDate() {
        return lastArriveDate;
    }

    public void setLastArriveDate(LocalDate lastArriveDate) {
        this.lastArriveDate = lastArriveDate;
    }

    private String name;

    public int getTimes() {
        return times;
    }

    @Override
    public String toString() {
        return "顾客姓名：" + name + ",到店次数：" + times + "最近到店时间：" + lastArriveDate;
    }
}
