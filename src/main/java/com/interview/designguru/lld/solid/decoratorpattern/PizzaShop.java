package com.interview.designguru.lld.solid.decoratorpattern;

public class PizzaShop {

    public static void main(String[] args) {
        BasePizza farmHouse = new FarmHouse();
        BasePizza extraCheeseFarmHouse = new ExtraCheeseTopping(farmHouse);
        BasePizza mushroomExtraCheeseFarmHouse = new MushroomTopping(extraCheeseFarmHouse);

        System.out.println(mushroomExtraCheeseFarmHouse.cost());
    }
}
