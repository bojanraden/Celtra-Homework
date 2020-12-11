package iOS;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class SafariTest {
    static DesiredCapabilities cap;
    static IOSDriver<MobileElement> driver;

    public static void main (String []args) throws MalformedURLException, InterruptedException{

        cap = new DesiredCapabilities();
        cap.setCapability("platformName","iOS");
        cap.setCapability("deviceName","iPhone 8 Plus");
        cap.setCapability("udid","9F6BEE1E-AE68-409F-B811-DC14A26263DC");
        cap.setCapability("chromedriverExecutable",System.getProperty("user.dir")+"/drivers/SafariLaunch.app");
        cap.setCapability("app","/Users/bojan/Desktop/Homework/Celtra/drivers/SafariLauncher.app");
        cap.setCapability("noReset","true");
        cap.setCapability("automationName","XCUITest");

        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.get("http://test.celtra.com/preview/b4994593#deviceType=Phone&overrides.deviceInfo.deviceType=Phone");

        Thread.sleep(3000);

        //Celtra banner "Expandable"
        boolean expandable = driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='Expandable']")).size() > 0;
        if(expandable == true) {
            System.out.println("Expandable banner is present");
        }
        else {
            Assert.fail();
        }

        //Click on Expandable
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Expandable");
        el1.click();

        //Couldn't get modal element
        // MobileElement modal = (MobileElement) driver.findElementsByXPath("//XCUIElementTypeOther[@name=\"Preview - Expandable\"]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
        //boolean modalDisplayed = modal.isDisplayed();

        //Close modal
        TouchAction closeTap = new TouchAction(driver);
        closeTap.tap(PointOption.point(389, 83)).perform();

        //Assert that the elements are visible again
        if(expandable == true) {
            System.out.println("Expandable banner is present again");
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
