
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StepImp extends BaseTest {
    BasePage basePage = new BasePage();
  public static  Reader reader;

    public static List<Path> findByFileExtension(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(fileExtension))
                    .collect(Collectors.toList());
        }
        return result;

    }
  public void ReadJsons(){
          try {
              Path path = Paths.get("src/test/java/JsonFiles");
              List<Path> paths = findByFileExtension(path, ".json");
              List<Elements> jsonElements = null;
              for (Path value : paths) {
                  reader = new BufferedReader(new FileReader(String.valueOf(value)));
                  jsonElements = new Gson().fromJson(reader, TypeToken.getParameterized(List.class, Elements.class).getType());

                  assert jsonElements != null;
                  jsonElements.parallelStream().forEach(a -> map.put(a.getKey(), a));

              }



          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      }


    public StepImp(){
    }

    @Step("<key> elementine tıkla")
    public void click(String key)  {
        ReadJsons();
        basePage.findElementBy(basePage.getByy(key)).click();
    }

    /*
    @Step("<key> elementine tıkla (Scrollable)")
    public void clickScrollabe(String key) throws FileNotFoundException {
        for(Elements a : jsonElements) {
            if(a.getKey().matches(key)) {
                basePage.findElementBy(basePage.getByScrollable(a.getType(), a.getValue())).click();
            }
        }
    }


    @Step("<elementType> <elementValue> <indexValue> elementine tıkla")
    public void clickWithIndex(String elementType,String elementValue,int indexValue){
        basePage.findElementBy(MobileBy.AndroidUIAutomator("new UiSelector()."+elementType+"(\""+elementValue+"\").index("+indexValue+")")).click();
    }
    @Step("<elementType> <elementValue> <index> elementine tıkla (Scrollable)")
    public void clickScrollableWithIndex(String elementType,String elementValue,int index){
        basePage.findElementBy(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector()."+elementType+"(\""+elementValue+"\")."+index+"")).click();

    }
     */

    @Step("<key> elementine <text> yazdır")
    public void sendKey(String key,String text)  {
        basePage.findElementBy(basePage.getByy(key)).sendKeys(text);
    }

    @Step("<seconds> miliSaniye Bekle")
    public void waitByMilliSeconds(int seconds) throws InterruptedException {
        basePage.waitBymilliSeconds(seconds);
    }

    @Step("<key> elementi ile <text> karşılaştır")
    public void textControl(String key,String text)  {
        Assert.assertEquals(basePage.findElementBy(basePage.getByy(key)).getText(),text);

    }


    @Step("<productNumber> Tane Ürün Ekle")
    public void addProductToList(int productNumber){
        int index=3;
        for(int i=1;i<=productNumber;i++) {
            String locator = "new UiSelector().className(\"android.view.View\").index("+index+").childSelector(new UiSelector().className(\"android.widget.Image\"))";
            System.out.println(locator);
            basePage.findElementBy(MobileBy.AndroidUIAutomator(locator)).click();
            index++;
        }
    }
@Step("Urunlerin Sayısını kontrol et <ExpectedProductText>")
    public void ListProductControl(String ExpectedProductText){
        String locater= "new UiSelector().text(\"3 ürün\")";
        String text = basePage.findElementBy(MobileBy.AndroidUIAutomator(locater)).getText();
    System.out.println(text);
        Assert.assertEquals("Urunler Listeye Eklenemedi.",ExpectedProductText,text);
    }

    @Step("<productNumber> Tane Ürün Sil")
    public void deleteProductToList(int productNumber) throws InterruptedException {
        int index=0;

        for(int i=1;i<=productNumber;i++){
            String locater = "new UiSelector().className(\"android.view.View\").instance("+index+").descriptionMatches(\"\")";
            basePage.findElementBy(MobileBy.AndroidUIAutomator(locater)).click();
            index++;
        }
        basePage.findElementBy(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sil\")")).click();
        waitByMilliSeconds(300);
        basePage.findElementBy(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Onayla\")")).click();
    }

    @Step("Sepetteki ürün sayısını Kontrol et <expected>")
    public void countControlInCart(String expected){
        String sayi = basePage.findElementBy(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"basket-item-count\")")).getText();
        System.out.println(sayi);

        Assert.assertEquals("Hata",expected,sayi);

    }

    @Step("<key> Elementinin görünürlük kontrolü")
    public void isElementVisible(String key)  {

                Assert.assertTrue("Element görünür değil", basePage.isElementVisible(basePage.findElementBy(basePage.getByy(key)), 10));


    }

    @Step("<key> Elementinin tıklanabilirlik kontrolü")
    public void isElementClickable(String key)  {

                Assert.assertTrue("Element görünür değil", basePage.isElementClickable((basePage.getByy(key)), 10));
            }
}
