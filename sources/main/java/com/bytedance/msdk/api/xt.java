package com.bytedance.msdk.api;

import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f24406j;

    /* renamed from: m, reason: collision with root package name */
    private String f24407m;

    /* renamed from: r, reason: collision with root package name */
    private String f24408r;
    private int up;
    private String xt;

    @Nullable
    public String cw() {
        return this.xt;
    }

    @Nullable
    public String j() {
        return this.f24408r;
    }

    @Nullable
    public String r() {
        return this.cw;
    }

    public int up() {
        return this.up;
    }

    @Nullable
    public String xt() {
        return this.f24406j;
    }

    public xt cw(String str) {
        this.xt = str;
        return this;
    }

    public xt j(String str) {
        this.f24408r = str;
        return this;
    }

    @Nullable
    public String m() {
        return this.f24407m;
    }

    public xt r(String str) {
        this.cw = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.f24406j + "', adnName='" + this.xt + "', customAdnName='" + this.cw + "', adType='" + this.f24408r + "', errCode=" + this.up + ", errMsg=" + this.f24407m + '}';
    }

    public xt up(String str) {
        this.f24407m = str;
        return this;
    }

    public xt xt(String str) {
        this.f24406j = str;
        return this;
    }

    public xt j(int i6) {
        this.up = i6;
        return this;
    }
}
