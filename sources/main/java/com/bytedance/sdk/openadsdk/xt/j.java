package com.bytedance.sdk.openadsdk.xt;

import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private long f31991j;

    /* renamed from: r, reason: collision with root package name */
    private long f31992r;
    private long up;
    private String xt;

    public String j() {
        return this.xt;
    }

    public String xt() {
        return this.cw;
    }

    public long cw() {
        return this.f31992r;
    }

    public long j(String str) {
        File file = new File(str, this.cw);
        return file.exists() ? file.lastModified() : System.currentTimeMillis();
    }

    public JSONObject up() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.f31991j);
            jSONObject.put("url", this.xt);
            jSONObject.put("file_hash", this.cw);
            jSONObject.put("effective_time", this.f31992r);
            jSONObject.put("expiration_time", this.up);
            return jSONObject;
        } catch (Exception e6) {
            vl.xt("BrandVideo", e6.getMessage());
            return jSONObject;
        }
    }

    public boolean xt(String str) {
        File file = new File(str, this.cw);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public j(JSONObject jSONObject) {
        this.f31991j = jSONObject.optLong("cid");
        this.xt = jSONObject.optString("url");
        this.cw = jSONObject.optString("file_hash");
        this.f31992r = jSONObject.optLong("effective_time");
        this.up = jSONObject.optLong("expiration_time");
    }

    public boolean r() {
        if (System.currentTimeMillis() >= this.up) {
            return true;
        }
        return false;
    }
}
