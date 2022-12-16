package strategy.pack;

public class Person {

    private String registry;
    private Integer age;

    public Person(String registry, Integer age){
        this.registry = registry;
        this.age = age;
    }

    public Integer getAge(){
        return  age;
    }

    public String getRegistry(){
        return registry;
    }

}
