package com.bytedance.adsdk.lottie.model;

import android.graphics.Typeface;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private final String cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23354j;

    /* renamed from: r, reason: collision with root package name */
    private final float f23355r;
    private Typeface up;
    private final String xt;

    public String j() {
        return this.f23354j;
    }

    public String cw() {
        return this.cw;
    }

    public void j(Typeface typeface) {
        this.up = typeface;
    }

    public Typeface r() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    public cw(String str, String str2, String str3, float f6) {
        this.f23354j = str;
        this.xt = str2;
        this.cw = str3;
        this.f23355r = f6;
    }
}
