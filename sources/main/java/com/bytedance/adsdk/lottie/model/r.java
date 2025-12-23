package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.model.xt.av;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    private final double cw;

    /* renamed from: j, reason: collision with root package name */
    private final List<av> f23438j;

    /* renamed from: m, reason: collision with root package name */
    private final String f23439m;

    /* renamed from: r, reason: collision with root package name */
    private final double f23440r;
    private final String up;
    private final char xt;

    public static int j(char c6, String str, String str2) {
        return (((c6 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public int hashCode() {
        return j(this.xt, this.f23439m, this.up);
    }

    public double xt() {
        return this.f23440r;
    }

    public r(List<av> list, char c6, double d6, double d7, String str, String str2) {
        this.f23438j = list;
        this.xt = c6;
        this.cw = d6;
        this.f23440r = d7;
        this.up = str;
        this.f23439m = str2;
    }

    public List<av> j() {
        return this.f23438j;
    }
}
