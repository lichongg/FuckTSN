package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class dd {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dd f35980b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35981a;

    public static dd a(Context context) {
        if (f35980b == null) {
            synchronized (dd.class) {
                try {
                    if (f35980b == null) {
                        f35980b = new dd(context);
                    }
                } finally {
                }
            }
        }
        return f35980b;
    }

    private dd(Context context) {
        this.f35981a = context;
    }

    public void a(final int i6) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(dd.this.f35981a, "re_po_rt").b(df.aC, 1) == 1) {
                        long a6 = df.a(dd.this.f35981a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b6 = r0.b(df.aE, 8) * 3600000;
                        if (a6 > 0 && currentTimeMillis - a6 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a6 >= b6 || i6 == 106) {
                            cp.a(dd.this.f35981a, new cn(dd.this.f35981a, i6).a(ck.f35869b), ck.f35869b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
