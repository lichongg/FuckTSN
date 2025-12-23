package xyz.adscope.amps.model.config.request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UserModel {
    private String id = "";
    private String province = "";
    private String city = "";
    private String region = "";
    private String customData = "";
    private String ext = "";

    public String getCity() {
        return this.city;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getExt() {
        return this.ext;
    }

    public String getId() {
        return this.id;
    }

    public String getProvince() {
        return this.province;
    }

    public String getRegion() {
        return this.region;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\",\"province\":\"" + this.province + "\",\"city\":\"" + this.city + "\",\"region\":\"" + this.region + "\", \"customData\":\"" + this.customData + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
