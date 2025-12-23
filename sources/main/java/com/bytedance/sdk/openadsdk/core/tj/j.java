package com.bytedance.sdk.openadsdk.core.tj;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30306j;

    /* renamed from: m, reason: collision with root package name */
    private long f30307m;

    /* renamed from: r, reason: collision with root package name */
    private List<n> f30308r = new ArrayList();
    private JSONObject up;
    private int xt;

    public void j(String str) {
        this.f30306j = str;
    }

    public void xt(String str) {
        this.cw = str;
    }

    public JSONObject cw() {
        return this.up;
    }

    public int j() {
        return this.xt;
    }

    public List<n> xt() {
        return this.f30308r;
    }

    public void j(int i6) {
        this.xt = i6;
    }

    public void j(n nVar) {
        this.f30308r.add(nVar);
    }

    public void j(List<n> list) {
        this.f30308r = list;
    }

    public void j(JSONObject jSONObject) {
        this.up = jSONObject;
    }

    public void j(long j6) {
        this.f30307m = j6;
    }
}
