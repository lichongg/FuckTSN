package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes6.dex */
public class dc {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dc f35976b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35977a;

    public static dc a(Context context) {
        if (f35976b == null) {
            synchronized (dc.class) {
                try {
                    if (f35976b == null) {
                        f35976b = new dc(context);
                    }
                } finally {
                }
            }
        }
        return f35976b;
    }

    private dc(Context context) {
        this.f35977a = context;
    }

    public void a(final int i6) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a6 = h.a(dc.this.f35977a, "re_po_rt");
                    if (a6.b(df.ap, 1) == 1) {
                        long a7 = df.a(dc.this.f35977a).a(df.bl);
                        long currentTimeMillis = System.currentTimeMillis();
                        int b6 = a6.b(df.as, 0);
                        long j6 = currentTimeMillis - a7;
                        if (j6 >= a6.b(df.ar, 6) * 3600000 || (i6 == 100 && b6 == 1 && j6 >= 14400000)) {
                            cg.a(dc.this.f35977a, new bw(dc.this.f35977a, i6, false).a(ck.f35872e), ck.f35872e, true);
                            df.a(dc.this.f35977a).a(df.bl, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
