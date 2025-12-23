package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cz {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cz f35956b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35957a;

    public static cz a(Context context) {
        if (f35956b == null) {
            synchronized (cz.class) {
                try {
                    if (f35956b == null) {
                        f35956b = new cz(context);
                    }
                } finally {
                }
            }
        }
        return f35956b;
    }

    private cz(Context context) {
        this.f35957a = context;
    }

    public void a(final int i6) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(cz.this.f35957a, "re_po_rt").b(df.G, 1) == 1) {
                        long a6 = df.a(cz.this.f35957a).a(df.bm);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b6 = r0.b(df.I, 12) * 3600000;
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
                            cp.a(cz.this.f35957a, new cj(cz.this.f35957a).a(ck.f35874g), ck.f35874g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
