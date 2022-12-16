package singleton.pack;

import java.util.Objects;

public class ConfigurationApi {
    private static ConfigurationApi instance;

    private ConfigurationApi(){}

    public static ConfigurationApi getInstance(){
        if (Objects.isNull(instance)){
            synchronized (ConfigurationApi.class){
                if (Objects.isNull(instance)){
                    instance = new ConfigurationApi();
                }
            }
        }
        return instance;
    }
}
