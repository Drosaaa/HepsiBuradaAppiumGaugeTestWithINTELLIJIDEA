import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;


public class BasePage extends BaseTest {
    FluentWait<AndroidDriver<MobileElement>> wait;
    public BasePage(){
        wait = setFluentWait(15);
    }

    WebElement findElementBy(String type,String locater){

       return wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector()."+type+"(\""+locater+"\")")));
    }

    WebElement findElementBy2(String type,String locater,String type2,String locater2){
        return wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector()."+type+"(\""+locater+"\")."+type2+"(\""+locater2+"\")")));
    }

    public WebElement findElementBy(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    WebElement findElementWithScroll(String type,String locater){
      return BaseTest.driver.findElement(MobileBy.AndroidUIAutomator(
              "new UiScrollable(new UiSelector().scrollable(true))" +
                      ".scrollIntoView(new UiSelector()."+type+"(\""+locater+"\"))"));
    }


    public void click(String type,String locater){
        findElementBy(type, locater).click();
    }


    public void sendKeys(String type,String locater,String text){
        findElementBy(type,locater).sendKeys(text);
    }


    public void pressEnter(){
        BaseTest.driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }

    public void pressSearchFromKeyboard(){
        BaseTest.driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }


    public void waitBymilliSeconds(int Seconds) throws InterruptedException {
        Thread.sleep(Seconds+1000);
    }

    public boolean isElementVisible(WebElement webElement, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOf(webElement));
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public FluentWait<AndroidDriver<MobileElement>> setFluentWait(long timeout){

        return new FluentWait<>(BaseTest.driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }



    public By getByScrollable(String elementType,String elementValue){
        By locater = null;
        switch (elementType){
            case "resourceId":locater=MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().resourceId(\""+elementValue+"\")).scrollForward()");
                break;
            case "className":locater=MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().className(\""+elementValue+"\")).scrollForward()");
                break;
            case "text":locater=MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\""+elementValue+"\")).scrollForward()");
                break;
            case "description":locater=MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().description(\""+elementValue+"\")).scrollForward()");
                break;
            default:System.out.println("Element Bulunamadı");

        }
        return locater;
    }

    public By getBy(String elementType,String elementValue){
        By locater = null;
        switch (elementType){
            case "resourceId":locater=MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\""+elementValue+"\")");
                break;
            case "className":locater=MobileBy.AndroidUIAutomator("new UiSelector().className(\""+elementValue+"\")");
                break;
            case "text":locater=MobileBy.AndroidUIAutomator("new UiSelector().text(\""+elementValue+"\")");
                break;
            case "description":locater=MobileBy.AndroidUIAutomator("new UiSelector().description(\""+elementValue+"\")");
                break;

            default:System.out.println("Element Bulunamadı");
        }
        return locater;
    }


    public By getByy(String key){
        By locater = null;
        if(!map.containsKey(key)){
            throw new NullPointerException(key + " elementi Bulunamadı");
        }
        Elements elements = map.get(key);
        String value = elements.getValue();
        switch (elements.getType().trim()){
            case "xpath":locater=MobileBy.xpath(elements.getValue());
                break;
            case "UiSelector":locater=MobileBy.AndroidUIAutomator(elements.getValue());
                break;
            case "id":locater=MobileBy.id(elements.getValue());
                break;
            default:System.out.println("Element Bulunamadı");
            Assert.fail(key + " elementinin " + elements.getType() + " tipi hatalı");
        }
        return locater;
    }


}
