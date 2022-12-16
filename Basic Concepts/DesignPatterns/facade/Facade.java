package facade;

import facade.pack.FacadeSystem;

public class Facade {
    public static void main(String[] args) {
        FacadeSystem facade = new FacadeSystem();

        facade.method();
    }
}
