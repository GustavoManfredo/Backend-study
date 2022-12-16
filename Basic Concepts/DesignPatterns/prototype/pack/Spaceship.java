package prototype.pack;

public class Spaceship implements Prototype {

    private String name;
    private Integer crew;
    private Double fuel;

    public Spaceship(String name, Integer crew, Double fuel) {
        this.name = name;
        this.crew = crew;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    public Double getFuel() {
        return fuel;
    }

    public void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "name='" + name + '\'' +
                ", crew=" + crew +
                ", fuel=" + fuel +
                '}';
    }

    @Override
    public Prototype createClone(){
        return new Spaceship(name, crew, fuel);
    }
}
