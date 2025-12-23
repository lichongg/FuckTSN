package com.kuaishou.weapon.p0;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* loaded from: D:\Downloads\app\classes6.dex */
public class de {

    /* renamed from: b, reason: collision with root package name */
    private static volatile de f35984b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35985a;

    public static de a(Context context) {
        if (f35984b == null) {
            synchronized (de.class) {
                try {
                    if (f35984b == null) {
                        f35984b = new de(context);
                    }
                } finally {
                }
            }
        }
        return f35984b;
    }

    private de(Context context) {
        this.f35985a = context;
    }

    public void a(final int i6) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(de.this.f35985a, "re_po_rt").b(df.B, 0) == 1) {
                        long a6 = df.a(de.this.f35985a).a(df.bn);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a6 >= r1.b(df.E, 2) * 3600000 || i6 == 106) {
                            try {
                                String a7 = new co(de.this.f35985a).a(ck.f35875h);
                                int intValue = Integer.valueOf(ck.f35875h).intValue();
                                if (a7 != null && a7.length() > 10) {
                                    new bc(de.this.f35985a, a7, intValue).a(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable unused) {
                            }
                            df.a(de.this.f35985a).a(df.bn, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
