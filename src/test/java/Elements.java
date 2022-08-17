import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Elements {

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("key")
    @Expose
    private String key;


  public Elements(String key, String type, String value){
      this.key=key;
      this.type=type;
      this.value=value;
  }


    public void setValue(String value) {
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }

    public void setType(String type) {
        this.type=type;
    }
    public String getType(){
        return this.type;
    }

    public void setKey(String key) {
        this.key=key;
    }
    public String getKey(){
        return this.key;
    }




}
