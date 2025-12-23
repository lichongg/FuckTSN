package com.bytedance.sdk.openadsdk.m.cw;

import com.baidu.mobads.sdk.internal.d;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends j {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private String f31596j;

    /* renamed from: m, reason: collision with root package name */
    private String f31597m;

    /* renamed from: r, reason: collision with root package name */
    private int f31598r;
    private String up;
    private long xt;

    public void j(String str) {
        this.f31596j = str;
    }

    public void xt(long j6) {
        this.cw = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f31596j);
            jSONObject.put("preload_size", this.xt);
            jSONObject.put(d.f10986b, this.cw);
            jSONObject.put("error_code", this.f31598r);
            jSONObject.put("error_message", this.up);
            jSONObject.put("error_message_server", this.f31597m);
            j(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void cw(String str) {
        this.f31597m = str;
    }

    public void j(long j6) {
        this.xt = j6;
    }

    public void xt(String str) {
        this.up = str;
    }

    public void j(int i6) {
        this.f31598r = i6;
    }
}
