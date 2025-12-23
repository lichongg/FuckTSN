package xyz.adscope.amps.report.model.request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UserModel {
    private String customData;
    private String ext;
    private String userId;

    public UserModel() {
        this.userId = "";
        this.customData = "";
        this.ext = "";
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getExt() {
        return this.ext;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "{\"userId\":\"" + this.userId + "\", \"customData\":\"" + this.customData + "\", \"ext\":\"" + this.ext + "\"}";
    }

    public UserModel(UserModel userModel) {
        this.userId = "";
        this.customData = "";
        this.ext = "";
        this.userId = userModel.getUserId();
        this.customData = userModel.getCustomData();
        this.ext = userModel.getExt();
    }
}
