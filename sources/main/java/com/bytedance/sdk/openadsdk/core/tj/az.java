package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az {
    private double ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30223j;

    /* renamed from: m, reason: collision with root package name */
    private double f30224m;

    /* renamed from: r, reason: collision with root package name */
    private double f30225r;
    private String up;
    private String xt;

    public int cw() {
        return this.cw;
    }

    public int j() {
        return this.f30223j;
    }

    public String xt() {
        return this.xt;
    }

    public double ae() {
        return this.ae;
    }

    public void cw(double d6) {
        this.ae = d6;
    }

    public void j(int i6) {
        this.f30223j = i6;
    }

    public double m() {
        return this.f30224m;
    }

    public double r() {
        return this.f30225r;
    }

    public boolean tl() {
        return !TextUtils.isEmpty(this.up);
    }

    public String up() {
        return this.up;
    }

    public void xt(int i6) {
        this.cw = i6;
    }

    public void j(String str) {
        this.xt = str;
    }

    public void xt(String str) {
        this.up = str;
    }

    public void j(double d6) {
        this.f30225r = d6;
    }

    public void xt(double d6) {
        this.f30224m = d6;
    }
}
