package com.umeng.analytics.pro;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bq extends bx {

    /* renamed from: a, reason: collision with root package name */
    public static final int f41051a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f41052b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f41053c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f41054d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f41055e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f41056f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f41057g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f41058h = 7;

    /* renamed from: j, reason: collision with root package name */
    private static final cv f41059j = new cv("TApplicationException");

    /* renamed from: k, reason: collision with root package name */
    private static final cl f41060k = new cl(CrashHianalyticsData.MESSAGE, (byte) 11, 1);

    /* renamed from: l, reason: collision with root package name */
    private static final cl f41061l = new cl("type", (byte) 8, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final long f41062m = 1;

    /* renamed from: i, reason: collision with root package name */
    protected int f41063i;

    public bq() {
        this.f41063i = 0;
    }

    public int a() {
        return this.f41063i;
    }

    public static bq a(cq cqVar) throws bx {
        cqVar.j();
        String str = null;
        int i6 = 0;
        while (true) {
            cl l6 = cqVar.l();
            byte b6 = l6.f41141b;
            if (b6 == 0) {
                cqVar.k();
                return new bq(i6, str);
            }
            short s5 = l6.f41142c;
            if (s5 != 1) {
                if (s5 != 2) {
                    ct.a(cqVar, b6);
                } else if (b6 == 8) {
                    i6 = cqVar.w();
                } else {
                    ct.a(cqVar, b6);
                }
            } else if (b6 == 11) {
                str = cqVar.z();
            } else {
                ct.a(cqVar, b6);
            }
            cqVar.m();
        }
    }

    public void b(cq cqVar) throws bx {
        cqVar.a(f41059j);
        if (getMessage() != null) {
            cqVar.a(f41060k);
            cqVar.a(getMessage());
            cqVar.c();
        }
        cqVar.a(f41061l);
        cqVar.a(this.f41063i);
        cqVar.c();
        cqVar.d();
        cqVar.b();
    }

    public bq(int i6) {
        this.f41063i = i6;
    }

    public bq(int i6, String str) {
        super(str);
        this.f41063i = i6;
    }

    public bq(String str) {
        super(str);
        this.f41063i = 0;
    }
}
