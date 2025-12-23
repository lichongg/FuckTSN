package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cy {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cy f35950b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35951a;

    public static cy a(Context context) {
        if (f35950b == null) {
            synchronized (cy.class) {
                try {
                    if (f35950b == null) {
                        f35950b = new cy(context);
                    }
                } finally {
                }
            }
        }
        return f35950b;
    }

    private cy(Context context) {
        this.f35951a = context;
    }

    public void a(final int i6) {
        try {
            h a6 = h.a(this.f35951a, "re_po_rt");
            final boolean e6 = a6.e("a1_p_s_p_s");
            final boolean e7 = a6.e("a1_p_s_p_s_c_b");
            if ((e6 || e7) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i7;
                        try {
                            h a7 = h.a(cy.this.f35951a, "re_po_rt");
                            if (a7.b(df.f36002o, 0) == 1) {
                                if (e6 || e7) {
                                    long a8 = df.a(cy.this.f35951a).a(df.bi);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b6 = a7.b(df.f36003p, 8) * 3600000;
                                    int b7 = a7.b(df.f36004q, 0);
                                    if (a8 > 0 && currentTimeMillis - a8 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(hours);
                                        if (list.contains(sb.toString())) {
                                            return;
                                        }
                                    }
                                    if (currentTimeMillis - a8 >= b6 || (((i7 = i6) == 100 && b7 == 1) || i7 == 106)) {
                                        cp.a(cy.this.f35951a, new ci(cy.this.f35951a, i6).a(ck.f35871d), ck.f35871d, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
