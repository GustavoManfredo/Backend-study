package factory.pack;

public class Ingredient {

    private String name;

    private Ingredient(){}

    protected Ingredient(String name){ this.name = name; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                '}';
    }

}
