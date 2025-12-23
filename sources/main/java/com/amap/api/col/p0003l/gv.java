package com.amap.api.col.p0003l;

import android.os.Build;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum gv {
    MIUI(q4.u("IeGlhb21p")),
    Flyme(q4.u("IbWVpenU")),
    RH(q4.u("IaHVhd2Vp")),
    ColorOS(q4.u("Ib3Bwbw")),
    FuntouchOS(q4.u("Idml2bw")),
    SmartisanOS(q4.u("Mc21hcnRpc2Fu")),
    AmigoOS(q4.u("IYW1pZ28")),
    EUI(q4.u("IbGV0dg")),
    Sense(q4.u("EaHRj")),
    LG(q4.u("EbGdl")),
    Google(q4.u("IZ29vZ2xl")),
    NubiaUI(q4.u("IbnViaWE")),
    Other("");


    /* renamed from: n, reason: collision with root package name */
    private String f6383n;

    /* renamed from: o, reason: collision with root package name */
    private int f6384o;

    /* renamed from: p, reason: collision with root package name */
    private String f6385p;

    /* renamed from: q, reason: collision with root package name */
    private String f6386q;

    /* renamed from: r, reason: collision with root package name */
    private String f6387r = Build.MANUFACTURER;

    public final String a() {
        return this.f6383n;
    }

    public final String b() {
        return this.f6385p;
    }

    public final void a(int i6) {
        this.f6384o = i6;
    }

    public final void b(String str) {
        this.f6386q = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f6384o + ", versionName='" + this.f6386q + "',ma=" + this.f6383n + "',manufacturer=" + this.f6387r + "'}";
    }

    gv(String str) {
        this.f6383n = str;
    }

    public final void a(String str) {
        this.f6385p = str;
    }
}
