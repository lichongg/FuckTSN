package xyz.adscope.amps.model.config.request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SdkModel {
    private String version = "";
    private String ext = "";

    public String getExt() {
        return this.ext;
    }

    public String getVersion() {
        return this.version;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"version\":\"" + this.version + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
