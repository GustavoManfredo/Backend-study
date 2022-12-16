package facade.pack;

public class FacadeSystem {
    // Ocultando a complexidade do sistema
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;

    public FacadeSystem(){
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
    }

    public void method(){
        subsystemA.methodA();
        subsystemB.methodB();
    }
}
