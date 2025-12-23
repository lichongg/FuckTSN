package com.bytedance.sdk.openadsdk.core.l;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f29428j;

    /* renamed from: r, reason: collision with root package name */
    private int f29429r;
    private JSONObject up;
    private Map<String, String> xt;

    public JSONObject j() {
        return this.up;
    }

    public int xt() {
        return this.f29429r;
    }

    public byte[] cw() {
        return this.f29428j;
    }

    public void j(JSONObject jSONObject) {
        this.up = jSONObject;
    }

    public JSONObject r() {
        return this.cw;
    }

    public Map<String, String> up() {
        return this.xt;
    }

    public void xt(JSONObject jSONObject) {
        this.cw = jSONObject;
    }

    public void j(int i6) {
        this.f29429r = i6;
    }

    public void j(byte[] bArr) {
        this.f29428j = bArr;
    }

    public void j(Map<String, String> map) {
        this.xt = map;
    }
}
