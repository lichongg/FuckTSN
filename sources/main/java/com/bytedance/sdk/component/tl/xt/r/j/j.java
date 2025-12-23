package com.bytedance.sdk.component.tl.xt.r.j;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.tl.j.xt {
    private long ae;
    private byte cw;

    /* renamed from: g, reason: collision with root package name */
    private String f26794g;

    /* renamed from: j, reason: collision with root package name */
    protected JSONObject f26795j;

    /* renamed from: m, reason: collision with root package name */
    private long f26796m;
    private byte oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private byte f26797r;
    private String tl;
    private long up;
    private int vl;
    private xt xt;

    public j(String str, JSONObject jSONObject) {
        this.f26794g = str;
        this.f26795j = jSONObject;
    }

    public static com.bytedance.sdk.component.tl.j.xt r(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("priority");
            j jVar = new j();
            jVar.j((byte) optInt);
            jVar.xt((byte) optInt2);
            jVar.j(jSONObject.optJSONObject("event"));
            jVar.j(jSONObject.optString("localId"));
            jVar.xt(jSONObject.optString("genTime"));
            jVar.j(jSONObject.optInt("channel"));
            return jVar;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public synchronized JSONObject ae() {
        xt xtVar;
        try {
            if (this.f26795j == null && (xtVar = this.xt) != null) {
                this.f26795j = xtVar.j(oq());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f26795j;
    }

    public void cw(String str) {
        this.qv = str;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public xt j() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public byte xt() {
        return this.oq;
    }

    public void cw(byte b6) {
        this.oq = b6;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public long g() {
        return this.f26796m;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void j(JSONObject jSONObject) {
        this.f26795j = jSONObject;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public String m() {
        if (TextUtils.isEmpty(this.f26794g)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f26794g);
            jSONObject.put("event", ae());
            jSONObject.put("genTime", qv());
            jSONObject.put("priority", (int) this.f26797r);
            jSONObject.put("type", (int) this.cw);
            jSONObject.put("channel", this.vl);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String oq() {
        return this.qv;
    }

    public String qv() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public long tl() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public byte up() {
        return this.f26797r;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void xt(String str) {
        this.tl = str;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public String cw() {
        return this.f26794g;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void j(byte b6) {
        this.cw = b6;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void xt(long j6) {
        this.f26796m = j6;
    }

    public j(String str, xt xtVar) {
        this.f26794g = str;
        this.xt = xtVar;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void cw(long j6) {
        this.ae = j6;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void j(String str) {
        this.f26794g = str;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void xt(byte b6) {
        this.f26797r = b6;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void j(long j6) {
        this.up = j6;
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public void j(int i6) {
        this.vl = i6;
    }

    private j() {
    }

    @Override // com.bytedance.sdk.component.tl.j.xt
    public byte r() {
        return this.cw;
    }
}
