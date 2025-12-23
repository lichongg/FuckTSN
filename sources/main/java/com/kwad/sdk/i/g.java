package com.kwad.sdk.i;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private String LQ;
    private String aCk;
    private String aCl;
    private String aHo;
    private String aIk;
    private JSONObject aSM;
    private boolean aSN;
    private Map<String, String> and;
    private String appId;
    private JSONObject axq;
    private String sdkVersion;

    public static g MY() {
        return new g();
    }

    public final JSONObject MZ() {
        return this.aSM;
    }

    public final boolean Na() {
        return this.aSN;
    }

    public final String Nb() {
        return this.aHo;
    }

    public final JSONObject Nc() {
        return this.axq;
    }

    public final g bL(boolean z5) {
        this.aSN = z5;
        return this;
    }

    public final g gb(String str) {
        this.appId = str;
        return this;
    }

    public final g gc(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g gd(String str) {
        this.aCl = str;
        return this;
    }

    public final g ge(String str) {
        this.LQ = str;
        return this;
    }

    public final String getAndroidId() {
        return this.aIk;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.LQ;
    }

    public final String getImei() {
        return this.aCk;
    }

    public final String getOaid() {
        return this.aCl;
    }

    public final Map<String, String> getRequestHeader() {
        return this.and;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final g gf(String str) {
        this.aIk = str;
        return this;
    }

    public final g gg(String str) {
        this.aCk = str;
        return this;
    }

    public final g gh(String str) {
        this.aHo = str;
        return this;
    }

    public final g h(Map<String, String> map) {
        this.and = map;
        return this;
    }

    public final g m(JSONObject jSONObject) {
        this.aSM = jSONObject;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.axq = jSONObject;
        return this;
    }

    private g() {
    }
}
