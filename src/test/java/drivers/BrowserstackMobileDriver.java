package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);
    static String userLogin = config.userLogin();
    static String userPassword = config.userPassword();
    static String appURL = config.appURL();
    static String deviceName = config.deviceName();
    static String osVersion = config.osVersion();
    static String browserURL = config.browserURL();


    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", userLogin);
        mutableCapabilities.setCapability("browserstack.key", userPassword);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", appURL);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", deviceName);
        mutableCapabilities.setCapability("os_version", osVersion);

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "QA.GURU lesson 12/21");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}