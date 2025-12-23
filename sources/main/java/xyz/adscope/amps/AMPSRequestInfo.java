package xyz.adscope.amps;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSRequestInfo {
    protected String appId;
    protected String className;
    protected String spaceId;

    public abstract void formatAdResource(String str);

    public String getAppId() {
        return this.appId;
    }

    public String getClassName() {
        return this.className;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public AMPSRequestInfo(String str, String str2) {
        this.appId = str;
        this.spaceId = str2;
    }
}
