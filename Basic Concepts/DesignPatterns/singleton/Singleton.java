package singleton;

import singleton.pack.ConfigurationApi;

public class Singleton {
    public static void main(String[] args) {
        var configuration = ConfigurationApi.getInstance();

        System.out.println(configuration);
    }
}
