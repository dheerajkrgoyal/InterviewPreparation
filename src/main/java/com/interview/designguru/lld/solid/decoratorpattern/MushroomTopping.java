package com.interview.designguru.lld.solid.decoratorpattern;

public class MushroomTopping extends ToppingDecorator{

    BasePizza basePizza;

    public MushroomTopping(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
