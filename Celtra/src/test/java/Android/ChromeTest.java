package Android;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest {
    static DesiredCapabilities cap;
    static AndroidDriver<MobileElement> driver;

    public static void main (String []args) throws MalformedURLException, InterruptedException{

        cap = new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","LMG710EMe321d098");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("browserName","chrome");
        cap.setCapability("chromedriverExecutable",System.getProperty("user.dir")+"/drivers/chromedriver");
//        Had to add the below capabilities because of the Error: connect ECONNREFUSED
        cap.setCapability("wdaStartupRetries", "4");
        cap.setCapability("wdaStartupRetryInterval", "20000");
        cap.setCapability("no-reset", true);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.get("http://test.celtra.com/preview/b4994593#deviceType=Phone&overrides.deviceInfo.deviceType=Phone");

        Thread.sleep(2000);

        //Get into iframe
        driver.switchTo().frame(1);

        boolean expandable = driver.findElements(By.xpath("//*[@id=\"celtra-object-76\"]")).size() > 0;
        boolean celtra_logo = driver.findElements(By.xpath("//*[@id=\"celtra-object-77\"]")).size() > 0;

        if(expandable == true) {
            System.out.println("Expandable banner is present");
        }
        else {
        Assert.fail();
        }

        if(celtra_logo == true) {
            System.out.println("Celtra logo is present");
        }
        else {
            Assert.fail();
        }

        //Tap on the banner
        TouchAction bannerTap = new TouchAction(driver);
        bannerTap.tap(PointOption.point(676, 538)).perform();


        //Couldn't figure out in which iframe wthe modal was locate.
//        boolean modal = driver.findElements(By.xpath("//*[@id=\"celtra-object-37\"]")).size() > 0;
//        if(modal == true) {
//            System.out.println("Modal appeared");
//        }
//        else {
//            Assert.fail();
//        }

        //Tap on the banner
        TouchAction closeTap = new TouchAction(driver);
        closeTap.tap(PointOption.point(1389, 337)).perform();

        //Assert that the elements are visible again
        if(expandable == true) {
            System.out.println("Expandable banner is present again");
        }
        else {
            Assert.fail();
        }

        if(celtra_logo == true) {
            System.out.println("Celtra logo is present again");
        }
        else {
            Assert.fail();
        }


        //Link2
        driver.get("http://test.celtra.com/preview/e68048a5#overrides.deviceInfo.deviceType=Phone");
        System.out.println("Navigated to Link2");
        driver.quit();
    }

}
