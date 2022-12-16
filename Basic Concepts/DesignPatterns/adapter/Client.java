package adapter;

import adapter.pack.Adaptee;
import adapter.pack.Adapter;
import adapter.pack.Target;

public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        target.request();
    }
}
