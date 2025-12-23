package com.bytedance.sdk.openadsdk.core.tj;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class nd {
    public Bundle az;
    public int cw;

    /* renamed from: g, reason: collision with root package name */
    public long f30362g;
    public long oq;
    public long qv;

    /* renamed from: r, reason: collision with root package name */
    public int f30365r;
    public String xt;
    private String av = com.bytedance.sdk.openadsdk.core.rn.uf.tl();

    /* renamed from: j, reason: collision with root package name */
    public int f30363j = -1;
    public JSONArray up = null;

    /* renamed from: m, reason: collision with root package name */
    public int f30364m = 1;
    public long ae = System.currentTimeMillis();
    public long tl = System.currentTimeMillis();
    public JSONObject vl = null;
    public int jy = -1;
    public com.bytedance.sdk.openadsdk.core.ch ws = com.bytedance.sdk.openadsdk.core.ch.j("");

    public nd j() {
        nd ndVar = new nd();
        ndVar.f30363j = this.f30363j;
        ndVar.up = this.up;
        ndVar.f30364m = this.f30364m;
        ndVar.ae = this.ae;
        ndVar.f30362g = this.f30362g;
        ndVar.oq = this.oq;
        ndVar.qv = this.qv;
        ndVar.jy = this.jy;
        return ndVar;
    }

    public String xt() {
        return this.av;
    }

    public void j(String str) {
        this.av = str;
    }

    public void j(String str, boolean z5) {
        com.bytedance.sdk.openadsdk.core.ch chVar;
        if (!z5 || (chVar = this.ws) == null || str == null) {
            return;
        }
        chVar.xt("cst_".concat(str));
    }

    public void j(String str, long j6, boolean z5) {
        com.bytedance.sdk.openadsdk.core.ch chVar;
        if (!z5 || (chVar = this.ws) == null || str == null) {
            return;
        }
        chVar.j("cst_".concat(str), j6);
    }
}
