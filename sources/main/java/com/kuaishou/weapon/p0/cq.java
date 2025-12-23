package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    static cq f35915a;

    /* renamed from: b, reason: collision with root package name */
    static cq f35916b;

    /* renamed from: c, reason: collision with root package name */
    static cq f35917c;

    /* renamed from: d, reason: collision with root package name */
    private long f35918d;

    /* renamed from: e, reason: collision with root package name */
    private a f35919e;

    public long a() {
        return this.f35918d;
    }

    enum a {
        DWORD(4),
        QWORD(8);


        /* renamed from: c, reason: collision with root package name */
        int f35923c;

        a(int i6) {
            this.f35923c = i6;
        }
    }

    private static void c() {
        f35915a = new cq();
        f35916b = new cq();
        f35917c = new cq();
        cq cqVar = f35916b;
        a aVar = a.DWORD;
        cqVar.a(aVar);
        int i6 = Build.VERSION.SDK_INT;
        if (cr.a()) {
            cq cqVar2 = f35915a;
            a aVar2 = a.QWORD;
            cqVar2.a(aVar2);
            f35917c.a(aVar2);
            switch (i6) {
                case 21:
                    f35915a.a(40L);
                    f35915a.a(aVar2);
                    f35917c.a(32L);
                    f35917c.a(aVar2);
                    f35916b.a(56L);
                    return;
                case 22:
                    f35915a.a(52L);
                    f35917c.a(44L);
                    f35916b.a(20L);
                    return;
                case 23:
                    f35915a.a(48L);
                    f35917c.a(40L);
                    f35916b.a(12L);
                    return;
                case 24:
                case 25:
                    f35915a.a(48L);
                    f35917c.a(40L);
                    f35916b.a(4L);
                    return;
                case 26:
                case 27:
                    f35915a.a(40L);
                    f35917c.a(32L);
                    f35916b.a(4L);
                    return;
                case 28:
                case 29:
                    f35915a.a(32L);
                    f35917c.a(24L);
                    f35916b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i6 + " is not supported now : (");
            }
        }
        f35915a.a(aVar);
        f35917c.a(aVar);
        switch (i6) {
            case 21:
                f35915a.a(40L);
                cq cqVar3 = f35915a;
                a aVar3 = a.QWORD;
                cqVar3.a(aVar3);
                f35917c.a(32L);
                f35917c.a(aVar3);
                f35916b.a(56L);
                return;
            case 22:
                f35915a.a(44L);
                f35917c.a(40L);
                f35916b.a(20L);
                return;
            case 23:
                f35915a.a(36L);
                f35917c.a(32L);
                f35916b.a(12L);
                return;
            case 24:
            case 25:
                f35915a.a(32L);
                f35917c.a(28L);
                f35916b.a(4L);
                return;
            case 26:
            case 27:
                f35915a.a(28L);
                f35917c.a(24L);
                f35916b.a(4L);
                return;
            case 28:
            case 29:
                f35915a.a(24L);
                f35917c.a(20L);
                f35916b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i6 + " is not supported now : (");
        }
    }

    public void a(long j6) {
        this.f35918d = j6;
    }

    public a b() {
        return this.f35919e;
    }

    static {
        c();
    }

    public void a(a aVar) {
        this.f35919e = aVar;
    }
}
