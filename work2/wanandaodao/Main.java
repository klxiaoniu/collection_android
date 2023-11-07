package com.wanandaodao.zoo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author 晚安叨叨
 */
public class Main {
    public static void main(String[] args) {
        ChineseRuralDog dog1 = new ChineseRuralDog("狗1", 2, "雄", true);
        ChineseRuralDog dog2 = new ChineseRuralDog("狗2", 3, "雄", true);
        ChineseRuralDog dog3 = new ChineseRuralDog("狗3", 4, "雌", false);
        ChineseRuralDog dog4 = new ChineseRuralDog("狗4", 5, "雌", false);
        ChineseRuralDog dog5 = new ChineseRuralDog("狗5", 6, "雌", true);
        ChineseRuralDog dog6 = new ChineseRuralDog("狗6", 7, "雄", false);

        Cat cat1 = new Cat("猫1", 2, "雌");
        Cat cat2 = new Cat("猫2", 3, "雄");
        Cat cat3 = new Cat("猫3", 4, "雌");
        Cat cat4 = new Cat("猫4", 5, "雄");
        Cat cat5 = new Cat("猫5", 6, "雌");
        Cat cat6 = new Cat("猫6", 1, "雄");

        Customer cus1 = new Customer("张三", 2, LocalDate.of(2020, 3, 2));
        Customer cus2 = new Customer("李四", 3, LocalDate.now());
        Customer cus3 = new Customer("王五", 1, LocalDate.now());
        Customer cus4 = new Customer("赵六", 2, LocalDate.of(2020, 3, 5));
        Customer cus5 = new Customer("孙二", 3, LocalDate.of(2022, 3, 10));
        Customer cus6 = new Customer("李一", 4, LocalDate.of(2020, 5, 2));

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog1);
        animals.add(dog3);
        animals.add(cat2);
        animals.add(cat5);
        animals.add(cat6);

        ArrayList<Customer> customers = new ArrayList<>();

        MyAnimalShop myAnimalShop = new MyAnimalShop(500, 500, animals, customers, true);


        //买入两只动物
        myAnimalShop.buyNewAnimal(new ChineseRuralDog("狗7", 2, "雄", true));
        myAnimalShop.buyNewAnimal(new Cat("猫7", 2, "雄"));
        System.out.println("店铺余额为: " + myAnimalShop.getCloseBalance());
        System.out.println("当前店铺中所有动物为: ");
        for (int i = 0; i < myAnimalShop.getAnimalList().size(); i++) {
            System.out.println(myAnimalShop.getAnimalList().get(i).toString());
        }
        myAnimalShop.buyNewAnimal(cat1);
        System.out.println("店铺余额为: " + myAnimalShop.getCloseBalance());
        //余额为0无法继续购买动物
        try {
            myAnimalShop.buyNewAnimal(dog2);
        } catch (InsufficientBalanceException e) {
            e.printError();
        }

        try {
            myAnimalShop.treatCustomer(cus1, dog1);
            myAnimalShop.treatCustomer(cus2, dog3);
            myAnimalShop.treatCustomer(cus3, dog6);
            myAnimalShop.treatCustomer(cus4, cat1);
        } catch (AnimalNotFountException e) {
            e.printError();
        }
        System.out.println("当前店铺中所有动物为: ");
        for (int i = 0; i < myAnimalShop.getAnimalList().size(); i++) {
            System.out.println(myAnimalShop.getAnimalList().get(i).toString());
        }
        System.out.println("店铺余额为: " + myAnimalShop.getCloseBalance());
        System.out.println("当前店铺中所有接待过的顾客信息: ");
        for (int i = 0; i < myAnimalShop.getCustomerList().size(); i++) {
            System.out.println(myAnimalShop.getCustomerList().get(i).toString());
        }

        myAnimalShop.buyNewAnimal(dog1);
        //测试相同顾客
        try {
            myAnimalShop.treatCustomer(cus1, cat2);
            myAnimalShop.treatCustomer(cus2, cat5);
            myAnimalShop.treatCustomer(cus3, cat6);
        } catch (AnimalNotFountException e) {
            e.printError();
        }

        System.out.println("当前店铺中所有接待过的顾客信息: ");
        for (int i = 0; i < myAnimalShop.getCustomerList().size(); i++) {
            System.out.println(myAnimalShop.getCustomerList().get(i).toString());
        }

        //歇业
        myAnimalShop.goOutOfBusiness();
    }
}
