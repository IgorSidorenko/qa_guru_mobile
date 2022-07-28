package config;

/*import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface BrowserstackConfig extends Config {
    @Key("user")
    String userLogin();
    @Key("key")
    String userPassword();
    String appURL();
    String device();
    String osVersion();
    String project();
    String build();
    String name();
    String browserURL();
    String appPath();
}*/
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")

public interface BrowserstackConfig extends Config {

    @Key("user")
    String browserstackUser();
    @Key("key")
    String browserstackKey();
    String app();
    String device();
    String osVersion();
    String project();
    String build();
    String name();
    String urlBrowserstack();
    String appPath();
}