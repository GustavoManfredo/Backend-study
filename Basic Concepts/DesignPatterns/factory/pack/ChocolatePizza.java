package factory.pack;

import java.util.List;

public class ChocolatePizza extends Pizza{

    protected ChocolatePizza() {
        this.ingredients = List.of(
                new Ingredient("Chocolate"),
                new Ingredient("Heavy Cream"),
                new Ingredient("Dark chocolate shavings")
        );
    }
}
