package factory;

import factory.pack.PizzaFactory;

public class Factory {
    public static void main(String[] args) {
        var pizza = PizzaFactory.getInstance(false);

        System.out.println(pizza);
    }
}
