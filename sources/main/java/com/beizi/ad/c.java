package com.beizi.ad;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f11408a = new c(320, 50, "320x50_mb");

    /* renamed from: b, reason: collision with root package name */
    public static final c f11409b = new c(468, 60, "468x60_as");

    /* renamed from: c, reason: collision with root package name */
    public static final c f11410c = new c(320, 100, "320x100_as");

    /* renamed from: d, reason: collision with root package name */
    public static final c f11411d = new c(728, 90, "728x90_as");

    /* renamed from: e, reason: collision with root package name */
    public static final c f11412e = new c(300, 250, "300x250_as");

    /* renamed from: f, reason: collision with root package name */
    public static final c f11413f = new c(160, 600, "160x600_as");

    /* renamed from: g, reason: collision with root package name */
    public static final c f11414g = new c(-1, -2, "smart_banner");

    /* renamed from: h, reason: collision with root package name */
    public static final c f11415h = new c(-3, -4, "fluid");

    /* renamed from: i, reason: collision with root package name */
    public static final c f11416i = new c(-3, 0, "search_v2");

    /* renamed from: j, reason: collision with root package name */
    private final int f11417j;

    /* renamed from: k, reason: collision with root package name */
    private final int f11418k;

    /* renamed from: l, reason: collision with root package name */
    private final String f11419l;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = -1
            if (r3 != r1) goto Lb
            java.lang.String r1 = "FULL"
            goto Lf
        Lb:
            java.lang.String r1 = java.lang.String.valueOf(r3)
        Lf:
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            r1 = -2
            if (r4 != r1) goto L1d
            java.lang.String r1 = "AUTO"
            goto L21
        L1d:
            java.lang.String r1 = java.lang.String.valueOf(r4)
        L21:
            r0.append(r1)
            java.lang.String r1 = "_as"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.c.<init>(int, int):void");
    }

    public int a() {
        return this.f11418k;
    }

    public int b() {
        return this.f11417j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11417j == cVar.f11417j && this.f11418k == cVar.f11418k && this.f11419l.equals(cVar.f11419l);
    }

    private c(int i6, int i7, String str) {
        if (i6 < 0 && i6 != -1 && i6 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i6);
        }
        if (i7 >= 0 || i7 == -2 || i7 == -4) {
            this.f11417j = i6;
            this.f11418k = i7;
            this.f11419l = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i7);
        }
    }

    public int a(Context context) {
        int i6 = this.f11418k;
        if (i6 == -4 || i6 == -3) {
            return -1;
        }
        return i6 != -2 ? (int) TypedValue.applyDimension(1, i6, context.getResources().getDisplayMetrics()) : context.getResources().getDisplayMetrics().heightPixels;
    }

    public int b(Context context) {
        int i6 = this.f11417j;
        if (i6 == -4 || i6 == -3) {
            return -1;
        }
        return i6 != -1 ? (int) TypedValue.applyDimension(1, i6, context.getResources().getDisplayMetrics()) : context.getResources().getDisplayMetrics().widthPixels;
    }

    public int hashCode() {
        return this.f11419l.hashCode();
    }

    public String toString() {
        return this.f11419l;
    }
}
