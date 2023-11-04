import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    private LocalDate date;
    private double remainder;
    private double remainder0;
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private boolean isOpen = true;

    public MyAnimalShop(double remainder, LocalDate date) {
        this.remainder = remainder;
        this.date = date;
        remainder0 = remainder;
    }

    /**
     * 买入新宠物
     */
    public void buyNewAnimal(Animal animal) {
        if (!isOpen) {
            System.out.println("宠物店歇业中");
            return;
        }
        try {
            if (remainder < animal.priceIn) {
                throw new InsufficientBalanceException("余额不足！");
            } else {
                remainder -= animal.priceIn;
                animals.add(animal);
                System.out.println("--------买入成功--------");
                System.out.println("新动物信息：\n" + animal.toString());
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

    }
    /**
     * 招待客人卖出宠物
     */
    public void treatCustomer(Customer customer, Animal animal) {
        if (!isOpen) {
            System.out.println("宠物店歇业中");
            return;
        }
        try {
            if (animals.isEmpty()) {
                throw new AnimalNotFoundException("店内暂无动物");
            } else {
                if (customer.getTimes() == 0) {
                    customers.add(customer);
                }
                customer.setTimes(customer.getTimes() + 1);
                customer.setLastArriveDate(date);
                animals.toString();
                remainder += animal.priceOut;
                animals.remove(animal);
                System.out.println("--------交易成功--------");
                System.out.println("顾客信息：\n" + customer);
                System.out.println("卖出的宠物信息：\n" + animal);
            }
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() {
        System.out.println("-------------------");
        System.out.println("今日顾客" + date);
        for (Customer customer : customers) {
            if (customer.getLastArriveDate() == date) {
                System.out.println(customer.toString());
            }
        }
        System.out.println("今日盈利：" + (remainder - remainder0));
        date = date.plusDays(1);//歇业后日期加一天
        remainder0 = remainder;
        this.isOpen = false;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }
}
