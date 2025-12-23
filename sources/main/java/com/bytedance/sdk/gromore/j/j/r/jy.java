package com.bytedance.sdk.gromore.j.j.r;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy extends com.bytedance.sdk.openadsdk.i.cw.xt.vl {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private String f27465j;
    private int xt;

    public jy(String str) {
        this.f27465j = str;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
    public boolean up() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
    public String cw() {
        return !TextUtils.isEmpty(this.f27465j) ? this.f27465j : "";
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
    public int j() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
    public double r() {
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
    public int xt() {
        return this.xt;
    }

    public jy(String str, int i6, int i7) {
        this.f27465j = str;
        this.xt = i6;
        this.cw = i7;
    }
}
