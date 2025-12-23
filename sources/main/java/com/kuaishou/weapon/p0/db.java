package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class db {

    /* renamed from: b, reason: collision with root package name */
    private static volatile db f35971b;

    /* renamed from: a, reason: collision with root package name */
    private Context f35972a;

    public static db a(Context context) {
        if (f35971b == null) {
            synchronized (db.class) {
                try {
                    if (f35971b == null) {
                        f35971b = new db(context);
                    }
                } finally {
                }
            }
        }
        return f35971b;
    }

    private db(Context context) {
        this.f35972a = context;
    }

    public void a(final int i6, final int i7) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                int i8;
                try {
                    h a6 = h.a(db.this.f35972a, "re_po_rt");
                    if (a6.b(df.P, 1) == 1) {
                        long a7 = df.a(db.this.f35972a).a(df.bj);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b6 = a6.b(df.R, 1) * 3600000;
                        long b7 = a6.b(df.S, 5) * 60000;
                        int b8 = a6.b(df.T, 0);
                        if (a7 > 0 && currentTimeMillis - a7 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        long j6 = currentTimeMillis - a7;
                        if (j6 >= b6 || (((i8 = i6) == 100 && b8 == 1) || i8 == 106 || (i8 != 100 && i8 > 0 && j6 >= b7))) {
                            cp.a(db.this.f35972a, new cl(db.this.f35972a, i6, i7).a(ck.f35870c), ck.f35870c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
