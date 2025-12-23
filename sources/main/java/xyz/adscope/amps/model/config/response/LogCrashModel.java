package xyz.adscope.amps.model.config.response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LogCrashModel {
    private int close;
    private String url;

    public int getClose() {
        return this.close;
    }

    public String getUrl() {
        return this.url;
    }

    public void setClose(int i6) {
        this.close = i6;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "{\"close\":" + this.close + ", \"url\":\"" + this.url + "\"}";
    }
}
