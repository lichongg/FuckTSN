package com.bytedance.sdk.openadsdk.core.component.splash.cw.j;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends j {
    private int ae;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.xt.xt f28661g;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28662m;
    private long oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private int f28663r;
    private boolean tl;
    private String up;

    public ae() {
        this.f28663r = -1;
        this.up = "unknown";
        this.f28662m = false;
        this.tl = false;
        this.qv = -1;
    }

    public void cw(int i6) {
        this.qv = i6;
    }

    public void j(String str) {
        this.up = str;
    }

    public int r() {
        return this.f28663r;
    }

    public void xt(int i6) {
        this.f28663r = i6;
    }

    public int ae() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.j.j
    public long cw() {
        return this.oq;
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.xt g() {
        return this.f28661g;
    }

    public void j(boolean z5) {
        this.f28662m = z5;
    }

    public boolean m() {
        return this.f28662m;
    }

    public void r(int i6) {
        this.ae = i6;
    }

    public boolean tl() {
        return this.tl;
    }

    public String up() {
        return TextUtils.isEmpty(this.up) ? "unknown" : this.up;
    }

    public void xt(boolean z5) {
        this.tl = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        this.f28661g = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.j.j
    public void j(long j6) {
        this.oq = j6;
    }

    public ae(int i6, String str, boolean z5) {
        this.f28662m = false;
        this.qv = -1;
        this.f28663r = i6;
        this.up = str;
        this.tl = z5;
    }
}
