package factory.pack;

import java.util.List;

public class PepperoniPizza extends Pizza{

    protected PepperoniPizza() {
        this.ingredients = List.of(
                new Ingredient("Tomato"),
                new Ingredient("Cheese"),
                new Ingredient("Salt"),
                new Ingredient("Oregano"),
                new Ingredient("Pepperoni"),
                new Ingredient("Onion")
        );
    }
}
