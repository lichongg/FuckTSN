package com.amap.api.col.s;

import android.os.Build;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum da {
    MIUI(j1.t("IeGlhb21p")),
    Flyme(j1.t("IbWVpenU")),
    RH(j1.t("IaHVhd2Vp")),
    ColorOS(j1.t("Ib3Bwbw")),
    FuntouchOS(j1.t("Idml2bw")),
    SmartisanOS(j1.t("Mc21hcnRpc2Fu")),
    AmigoOS(j1.t("IYW1pZ28")),
    EUI(j1.t("IbGV0dg")),
    Sense(j1.t("EaHRj")),
    LG(j1.t("EbGdl")),
    Google(j1.t("IZ29vZ2xl")),
    NubiaUI(j1.t("IbnViaWE")),
    Other("");


    /* renamed from: n, reason: collision with root package name */
    private String f8004n;

    /* renamed from: o, reason: collision with root package name */
    private int f8005o;

    /* renamed from: p, reason: collision with root package name */
    private String f8006p;

    /* renamed from: q, reason: collision with root package name */
    private String f8007q;

    /* renamed from: r, reason: collision with root package name */
    private String f8008r = Build.MANUFACTURER;

    public final String a() {
        return this.f8004n;
    }

    public final String b() {
        return this.f8006p;
    }

    public final void a(int i6) {
        this.f8005o = i6;
    }

    public final void b(String str) {
        this.f8007q = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f8005o + ", versionName='" + this.f8007q + "',ma=" + this.f8004n + "',manufacturer=" + this.f8008r + "'}";
    }

    da(String str) {
        this.f8004n = str;
    }

    public final void a(String str) {
        this.f8006p = str;
    }
}
