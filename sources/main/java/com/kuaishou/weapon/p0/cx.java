package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cx {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cx f35946b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35947a;

    public static cx a(Context context) {
        if (f35946b == null) {
            synchronized (cx.class) {
                try {
                    if (f35946b == null) {
                        f35946b = new cx(context);
                    }
                } finally {
                }
            }
        }
        return f35946b;
    }

    private cx(Context context) {
        this.f35947a = context;
    }

    public void a(final int i6) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i7;
                try {
                    h a6 = h.a(cx.this.f35947a, "re_po_rt");
                    if (a6.b(df.f36012y, 0) == 1) {
                        long a7 = df.a(cx.this.f35947a).a(df.bh);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b6 = a6.b(df.f36013z, 8) * 3600000;
                        int b7 = a6.b(df.f36004q, 0);
                        if (a7 > 0 && currentTimeMillis - a7 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a7 >= b6 || (i7 = i6) == 106 || (i7 == 100 && b7 == 1)) {
                            cp.a(cx.this.f35947a, new ch(cx.this.f35947a, i6).a(ck.f35876i), ck.f35876i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
