package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")
public interface BrowserstackConfig extends Config {
    String userLogin();

    String userPassword();

    String appURL();

    String deviceName();

    String osVersion();

    String browserURL();
}
