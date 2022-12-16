package factory.pack;

import java.util.List;

public abstract class Pizza {

    protected List<Ingredient> ingredients;

    protected Pizza(){}

    public List<Ingredient> getIngredients() { return ingredients; }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                '}';
    }
}
