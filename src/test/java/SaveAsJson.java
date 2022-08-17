

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import io.grpc.internal.JsonUtil;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveAsJson {

    public static String hesabımButton = "new UiSelector().description(\"Hesabım\")";
    public static String girisYapButton = "new UiSelector().text(\"Giriş yap\")";
    public static String emailBox = "new UiSelector().className(\"android.widget.EditText\")";
    public static String btnButton = "new UiSelector().resourceId(\"btnLogin\")";
    public static String passwordBox = "new UiSelector().resourceId(\"txtPassword\")";
    public static String btnButton2 = "new UiSelector().resourceId(\"btnEmailSelect\")";
    public static String logintxt = "new UiSelector().resourceId(\"android:id/message\")";
    public static String tamamButton = "new UiSelector().resourceId(\"android:id/button1\")";
    public static String HesabımEkranınıKapat = "new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/ivToolbarBack\")";
    public static String goToList = "new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/nav_graph_my_list\")";
    public static String createListButton = "new UiSelector().resourceId(\"createListButton\")";
    public static String listName = "new UiSelector().resourceId(\"listName\")";
    public static String isAlarmEnabled = "new UiSelector().resourceId(\"isAlarmEnabled\")";
    public static String Oluşturveürünekle = "new UiSelector().text(\"Oluştur ve ürün ekle\")";
    public static String Devamet = "new UiScrollable(new UiSelector().className(\"android.webkit.WebView\").childSelector(new UiSelector().className(\"android.view.View\"))" +
            ".scrollable(true)).scrollIntoView(new UiSelector().text(\"Devam et\")).scrollForward()";
    public static String ListDeneme = "new UiSelector().text(\"ListDeneme\")";
    public static String Düzenle = "new UiSelector().text(\"Düzenle\")";
    public static String Sepeteekle = "new UiSelector().className(\"android.widget.Button\").text(\"Sepete ekle\")";
    public static String Sepetim = "new UiSelector().text(\"Sepetim\")";
    public static String ÜrünKaldır = "new UiSelector().description(\"Ürünü Kaldır\")";
    public static String Sepetinşuanboş = "new UiSelector().text(\"Sepetin şu an boş\")";
    public static String Home = "new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/nav_graph_home\")";
    public static String Çıkışyap = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Çıkış yap\"))";


    public static void main(String[] args) throws IOException {

        Elements obj1 = new Elements("HesabımButton","UiSelector",hesabımButton);
        Elements obj2 = new Elements("girisYapButton","UiSelector",girisYapButton);
        Elements obj3 = new Elements("emailBox","UiSelector",emailBox);
        Elements obj4 = new Elements("btnButton","UiSelector",btnButton);
        Elements obj5 = new Elements("passwordBox","UiSelector",passwordBox);
        Elements obj6 = new Elements("btnButton2","UiSelector",btnButton2);
        Elements obj7 = new Elements("logintxt","UiSelector",logintxt);
        Elements obj8= new Elements("tamamButton","UiSelector",tamamButton);
        Elements obj9= new Elements("HesabımEkranınıKapat","UiSelector",HesabımEkranınıKapat);
        Elements obj10= new Elements("goToList","UiSelector",goToList);
        Elements obj11= new Elements("createListButton","UiSelector",createListButton);
        Elements obj12= new Elements("listName","UiSelector",listName);
        Elements obj13= new Elements("isAlarmEnabled","UiSelector",isAlarmEnabled);
        Elements obj14= new Elements("Oluşturveürünekle","UiSelector",Oluşturveürünekle);
        Elements obj15= new Elements("Devamet","UiSelector",Devamet);
        Elements obj16= new Elements("ListDeneme","UiSelector",ListDeneme);
        Elements obj17= new Elements("Düzenle","UiSelector",Düzenle);
        Elements obj18 = new Elements("Sepeteekle","text",Sepeteekle);
        Elements obj19=new Elements("Sepetim","UiSelector",Sepetim);
        Elements obj20=new Elements("ÜrünKaldır","UiSelector",ÜrünKaldır);
        Elements obj21=new Elements("Sepetinşuanboş","UiSelector",Sepetinşuanboş);
        Elements obj22 = new Elements("Home","UiSelector",Home);
        Elements obj23 = new Elements("Çıkışyap","UiSelector",Çıkışyap);



        Elements hobj1 = new Elements("HesabımButton","UiSelector",hesabımButton);
        Elements hobj2 = new Elements("goToList","UiSelector",goToList);
        Elements hobj3 = new Elements("Çıkışyap","UiSelector",Çıkışyap);

        Elements aobj1= new Elements("girisYapButton","UiSelector",girisYapButton);
        Elements aobj2 = new Elements("logintxt","UiSelector",logintxt);
        Elements aobj3 = new Elements("tamamButton","UiSelector",tamamButton);
        Elements aobj4 = new Elements("HesabımEkranınıKapat","UiSelector",HesabımEkranınıKapat);



        Elements lobj1 = new Elements("emailBox","UiSelector",emailBox);
        Elements lobj2 = new Elements("passwordBox","UiSelector",passwordBox);
        Elements lobj3 = new Elements("btnButton","UiSelector",btnButton);
        Elements lobj4 = new Elements("passwordBox","UiSelector",passwordBox);
        Elements lobj5 = new Elements("btnButton2","UiSelector",btnButton2);


        Elements liobj1  = new Elements("createListButton","UiSelector",createListButton);
        Elements liobj2  = new Elements("listName","UiSelector",listName);
        Elements liobj3  = new Elements("isAlarmEnabled","UiSelector",isAlarmEnabled);
        Elements liobj4  = new Elements("Oluşturveürünekle","UiSelector",Oluşturveürünekle);
        Elements liobj5  = new Elements("Devamet","UiSelector",Devamet);
        Elements liobj6  = new Elements("ListDeneme","UiSelector",ListDeneme);
        Elements liobj7  = new Elements("Düzenle","UiSelector",Düzenle);
        Elements liobj8 = new Elements("Sepeteekle","text",Sepeteekle);
        Elements liobj9 = new Elements("Sepetim","UiSelector",Sepetim);

        Elements cobj1 = new Elements("ÜrünKaldır","UiSelector",ÜrünKaldır);
        Elements cobj2 = new Elements("Sepetinşuanboş","UiSelector",Sepetinşuanboş);
        Elements cobj3 = new Elements("Home","UiSelector",Home);



        List<Object>listAccount = new ArrayList<>(Arrays.asList(aobj1,aobj2,aobj3,aobj4));
        List<Object>listLogin = new ArrayList<>(Arrays.asList(lobj1,lobj2,lobj3,lobj4,lobj5));
        List<Object>listList = new ArrayList<>(Arrays.asList(liobj1,liobj2,liobj3,liobj4,liobj5,liobj6,liobj7,liobj8,liobj9));
        List<Object>listCart = new ArrayList<>(Arrays.asList(cobj1,cobj2,cobj3));
        List<Object> listHome = new ArrayList<>(Arrays.asList(hobj1,hobj2,hobj3));


 //       List<Object> list = new ArrayList<>(Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6, obj7,obj8,obj9,obj10,obj11,obj12,obj13,obj14,obj15,obj16,obj17,obj18,obj19,obj20,obj21,obj22,obj23));







        Writer writer = new FileWriter("src/test/java/JsonFiles/HomePage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(listHome, writer);
        } catch (Exception e) {
        }
        writer.close();


         writer = new FileWriter("src/test/java/JsonFiles/AccountPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(listAccount, writer);
        } catch (Exception e) {
        }
        writer.close();




         writer = new FileWriter("src/test/java/JsonFiles/LoginPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(listLogin, writer);
        } catch (Exception e) {
        }
        writer.close();



        writer = new FileWriter("src/test/java/JsonFiles/ListPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(listList, writer);
        } catch (Exception e) {
        }
        writer.close();


        writer = new FileWriter("src/test/java/JsonFiles/CartPage.json");
        try {
            Gson gson1 = (new GsonBuilder()).setPrettyPrinting().create();
            gson1.toJson(listCart, writer);
        } catch (Exception e) {
        }
        writer.close();
    }
}