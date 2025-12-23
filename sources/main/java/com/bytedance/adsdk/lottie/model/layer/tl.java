package com.bytedance.adsdk.lottie.model.layer;

import java.util.List;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {
    private final String ae;
    private final float av;
    private final float az;
    private final String cw;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f23399f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.vl f23400g;

    /* renamed from: i, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.oq f23401i;

    /* renamed from: j, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.model.xt.cw> f23402j;
    private final float jy;
    private final List<com.bytedance.adsdk.lottie.m.j<Float>> kt;

    /* renamed from: m, reason: collision with root package name */
    private final long f23403m;
    private final com.bytedance.adsdk.lottie.model.j.xt mi;
    private final int oq;
    private final int qv;

    /* renamed from: r, reason: collision with root package name */
    private final long f23404r;
    private final xt tj;
    private final List<com.bytedance.adsdk.lottie.model.xt.tl> tl;
    private final j up;

    /* renamed from: v, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.xt.j f23405v;
    private final int vl;

    /* renamed from: w, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.qv f23406w;
    private final float ws;

    /* renamed from: x, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.r.oq f23407x;
    private final com.bytedance.adsdk.lottie.m xt;

    public enum j {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum xt {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public tl(List<com.bytedance.adsdk.lottie.model.xt.cw> list, com.bytedance.adsdk.lottie.m mVar, String str, long j6, j jVar, long j7, String str2, List<com.bytedance.adsdk.lottie.model.xt.tl> list2, com.bytedance.adsdk.lottie.model.j.vl vlVar, int i6, int i7, int i8, float f6, float f7, float f8, float f9, com.bytedance.adsdk.lottie.model.j.oq oqVar, com.bytedance.adsdk.lottie.model.j.qv qvVar, List<com.bytedance.adsdk.lottie.m.j<Float>> list3, xt xtVar, com.bytedance.adsdk.lottie.model.j.xt xtVar2, boolean z5, com.bytedance.adsdk.lottie.model.xt.j jVar2, com.bytedance.adsdk.lottie.r.oq oqVar2) {
        this.f23402j = list;
        this.xt = mVar;
        this.cw = str;
        this.f23404r = j6;
        this.up = jVar;
        this.f23403m = j7;
        this.ae = str2;
        this.tl = list2;
        this.f23400g = vlVar;
        this.oq = i6;
        this.qv = i7;
        this.vl = i8;
        this.jy = f6;
        this.ws = f7;
        this.az = f8;
        this.av = f9;
        this.f23401i = oqVar;
        this.f23406w = qvVar;
        this.kt = list3;
        this.tj = xtVar;
        this.mi = xtVar2;
        this.f23399f = z5;
        this.f23405v = jVar2;
        this.f23407x = oqVar2;
    }

    com.bytedance.adsdk.lottie.m j() {
        return this.xt;
    }

    public String ae() {
        return this.ae;
    }

    int av() {
        return this.vl;
    }

    com.bytedance.adsdk.lottie.model.j.vl az() {
        return this.f23400g;
    }

    float cw() {
        return this.ws / this.xt.w();
    }

    public boolean f() {
        return this.f23399f;
    }

    float g() {
        return this.av;
    }

    int i() {
        return this.qv;
    }

    public String j(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(m());
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        tl j6 = this.xt.j(jy());
        if (j6 != null) {
            sb.append("\t\tParents: ");
            sb.append(j6.m());
            tl j7 = this.xt.j(j6.jy());
            while (j7 != null) {
                sb.append("->");
                sb.append(j7.m());
                j7 = this.xt.j(j7.jy());
            }
            sb.append(str);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        if (!oq().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(oq().size());
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        if (w() != 0 && i() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(w()), Integer.valueOf(i()), Integer.valueOf(av())));
        }
        if (!this.f23402j.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.bytedance.adsdk.lottie.model.xt.cw cwVar : this.f23402j) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(cwVar);
                sb.append(com.snail.antifake.deviceid.e.f37542d);
            }
        }
        return sb.toString();
    }

    long jy() {
        return this.f23403m;
    }

    com.bytedance.adsdk.lottie.model.j.qv kt() {
        return this.f23406w;
    }

    public String m() {
        return this.cw;
    }

    com.bytedance.adsdk.lottie.model.j.oq mi() {
        return this.f23401i;
    }

    List<com.bytedance.adsdk.lottie.model.xt.tl> oq() {
        return this.tl;
    }

    public j qv() {
        return this.up;
    }

    List<com.bytedance.adsdk.lottie.m.j<Float>> r() {
        return this.kt;
    }

    com.bytedance.adsdk.lottie.model.j.xt tj() {
        return this.mi;
    }

    float tl() {
        return this.az;
    }

    public String toString() {
        return j("");
    }

    public long up() {
        return this.f23404r;
    }

    public com.bytedance.adsdk.lottie.model.xt.j v() {
        return this.f23405v;
    }

    xt vl() {
        return this.tj;
    }

    int w() {
        return this.oq;
    }

    List<com.bytedance.adsdk.lottie.model.xt.cw> ws() {
        return this.f23402j;
    }

    public com.bytedance.adsdk.lottie.r.oq x() {
        return this.f23407x;
    }

    float xt() {
        return this.jy;
    }
}
