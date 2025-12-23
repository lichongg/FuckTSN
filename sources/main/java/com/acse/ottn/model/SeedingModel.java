package com.acse.ottn.model;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SeedingModel implements Serializable {
    private String app = "";
    private String deeplink;
    private String link;

    public String getApp() {
        return this.app;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getLink() {
        return this.link;
    }

    public void setApp(String str) {
        this.app = str;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setLink(String str) {
        this.link = str;
    }
}
