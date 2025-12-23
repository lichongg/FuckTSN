package com.beizi.fusion.model;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdPlusConfig {

    @JsonNode(key = "adUrl")
    private String adUrl;

    @JsonNode(key = "h5RedirectBlackList")
    private List<String> h5RedirectBlackList;

    @JsonNode(key = "version")
    private String version;

    public static AdPlusConfig objectFromData(String str) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(str, AdPlusConfig.class);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public String getAdUrl() {
        return this.adUrl;
    }

    public List<String> getH5RedirectBlackList() {
        return this.h5RedirectBlackList;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAdUrl(String str) {
        this.adUrl = str;
    }

    public void setH5RedirectBlackList(List<String> list) {
        this.h5RedirectBlackList = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public static AdPlusConfig objectFromData(String str, String str2) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), AdPlusConfig.class);
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
