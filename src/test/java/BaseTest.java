import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static AndroidDriver<MobileElement> driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    public static Map<String,Elements> map = new HashMap<>();


    @BeforeSpec
    public void setUp() throws MalformedURLException {
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability("deviceName", "emulator-5554");
        d.setCapability("platformName", "android");
        d.setCapability("appPackage", "com.pozitron.hepsiburada");
        d.setCapability("appActivity", "com.hepsiburada.ui.home.BottomNavigationActivity");
        d.setCapability("noReset", "true");
        d.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(url,d);
        // driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
        logger.info("Android Driver Started");

    }

    @AfterSpec
    public void tearDown(){
        driver.quit();
        logger.info("Android Driver Downed");
    }


}
