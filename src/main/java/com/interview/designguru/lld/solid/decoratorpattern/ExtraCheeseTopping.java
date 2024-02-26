package com.interview.designguru.lld.solid.decoratorpattern;

public class ExtraCheeseTopping  extends ToppingDecorator{

    BasePizza basePizza;
    public ExtraCheeseTopping(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 10;
    }
}
