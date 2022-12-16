package prototype;

import prototype.pack.Spaceship;

public class Prototype {
    public static void main(String[] args) {
        Spaceship apollo = new Spaceship("Apollo", 5, 14.4d);
        System.out.println(apollo);

        Spaceship clone1 = (Spaceship)apollo.createClone();
        Spaceship clone2 = (Spaceship)apollo.createClone();
        Spaceship clone3 = (Spaceship)apollo.createClone();

        clone1.setName("Apollo 11");
        clone1.setCrew(11);
        clone1.setFuel(20.2d);
        clone2.setName("Apollo 12");
        clone2.setCrew(8);
        clone2.setFuel(19.3d);
        clone3.setName("Apollo 13");
        clone3.setCrew(17);
        clone3.setFuel(60.1d);

        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println(clone3);
    }
}
