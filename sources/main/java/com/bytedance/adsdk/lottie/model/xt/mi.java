package com.bytedance.adsdk.lottie.model.xt;

import com.bytedance.adsdk.lottie.j.j.tj;

/* loaded from: D:\Downloads\app\classes3.dex */
public class mi implements cw {
    private final com.bytedance.adsdk.lottie.model.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23465j;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f23466m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.xt f23467r;
    private final com.bytedance.adsdk.lottie.model.j.xt up;
    private final j xt;

    public enum j {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static j j(int i6) {
            if (i6 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i6 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i6)));
        }
    }

    public String j() {
        return this.f23465j;
    }

    public com.bytedance.adsdk.lottie.model.j.xt cw() {
        return this.cw;
    }

    public j getType() {
        return this.xt;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new tj(cwVar, this);
    }

    public com.bytedance.adsdk.lottie.model.j.xt r() {
        return this.up;
    }

    public String toString() {
        return "Trim Path: {start: " + this.cw + ", end: " + this.f23467r + ", offset: " + this.up + "}";
    }

    public boolean up() {
        return this.f23466m;
    }

    public com.bytedance.adsdk.lottie.model.j.xt xt() {
        return this.f23467r;
    }

    public mi(String str, j jVar, com.bytedance.adsdk.lottie.model.j.xt xtVar, com.bytedance.adsdk.lottie.model.j.xt xtVar2, com.bytedance.adsdk.lottie.model.j.xt xtVar3, boolean z5) {
        this.f23465j = str;
        this.xt = jVar;
        this.cw = xtVar;
        this.f23467r = xtVar2;
        this.up = xtVar3;
        this.f23466m = z5;
    }
}
