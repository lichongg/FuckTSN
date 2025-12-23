package com.beizi.fusion.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class S2SBiddingConfig {

    @JsonNode(key = "appKey")
    private String appKey;

    @JsonNode(key = "secret")
    private String secret;

    @JsonNode(key = "url")
    private String url;

    public String getAppKey() {
        return this.appKey;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
