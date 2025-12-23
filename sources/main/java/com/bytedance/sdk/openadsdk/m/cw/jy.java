package com.bytedance.sdk.openadsdk.m.cw;

import com.baidu.mobads.sdk.internal.d;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy extends j {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private String f31592j;

    /* renamed from: r, reason: collision with root package name */
    private long f31593r;
    private long xt;

    public void j(String str) {
        this.f31592j = str;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f31592j);
            jSONObject.put("preload_size", this.xt);
            jSONObject.put(d.f10986b, this.cw);
            jSONObject.put("local_cache", this.f31593r);
            j(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void cw(long j6) {
        this.f31593r = j6;
    }

    public void j(long j6) {
        this.xt = j6;
    }

    public void xt(long j6) {
        this.cw = j6;
    }
}
