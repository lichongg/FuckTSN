package com.bytedance.sdk.openadsdk.m.cw;

import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.m.cw.r;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt<T extends r> {
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private n f31605j;

    /* renamed from: r, reason: collision with root package name */
    private T f31606r;
    private boolean up = false;
    private String xt;

    public n j() {
        return this.f31605j;
    }

    public JSONObject cw() {
        if (this.cw == null) {
            this.cw = new JSONObject();
        }
        return this.cw;
    }

    public void j(boolean z5) {
        this.up = z5;
    }

    public T r() {
        return this.f31606r;
    }

    public boolean up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    public xt(n nVar, String str, JSONObject jSONObject, T t5) {
        this.f31605j = nVar;
        this.xt = str;
        this.cw = jSONObject;
        this.f31606r = t5;
    }
}
