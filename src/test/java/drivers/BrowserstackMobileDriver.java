package drivers;

/*import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class,System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", config.userLogin());
        mutableCapabilities.setCapability("browserstack.key", config.userPassword());

        // Set URL of the application under test
        mutableCapabilities.setCapability("appURL", config.appURL());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("osVersion", config.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", config.project());
        mutableCapabilities.setCapability("build", config.build());
        mutableCapabilities.setCapability("name", config.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.browserURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }*/
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
        static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class,System.getProperties());

        @Override
        public WebDriver createDriver(Capabilities capabilities) {
            MutableCapabilities mutableCapabilities = new MutableCapabilities();
            mutableCapabilities.merge(capabilities);

            // Set your access credentials
            mutableCapabilities.setCapability("browserstack.user", config.browserstackUser());
            mutableCapabilities.setCapability("browserstack.key", config.browserstackKey());

            // Set URL of the application under test
            mutableCapabilities.setCapability("app", config.app());

            // Specify device and os_version for testing
            mutableCapabilities.setCapability("device", config.device());
            mutableCapabilities.setCapability("osVersion", config.osVersion());

            // Set other BrowserStack capabilities
            mutableCapabilities.setCapability("project", config.project());
            mutableCapabilities.setCapability("build", config.build());
            mutableCapabilities.setCapability("name", config.name());
            return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
        }

        public static URL getBrowserstackUrl() {
            try {
                return new URL(config.urlBrowserstack());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
