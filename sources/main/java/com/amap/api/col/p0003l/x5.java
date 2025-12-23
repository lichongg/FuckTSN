package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x5 {

    /* renamed from: a, reason: collision with root package name */
    private p4 f7667a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, x5> f7668a = new HashMap();
    }

    public static x5 a(p4 p4Var) {
        if (a.f7668a.get(p4Var.a()) == null) {
            a.f7668a.put(p4Var.a(), new x5(p4Var));
        }
        return a.f7668a.get(p4Var.a());
    }

    public final void b(Context context, boolean z5, boolean z6) {
        a6.b(context, this.f7667a, "sckey", String.valueOf(z5));
        if (z5) {
            a6.b(context, this.f7667a, "scisf", String.valueOf(z6));
        }
    }

    public final boolean c(Context context) {
        try {
            return Boolean.parseBoolean(a6.a(context, this.f7667a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean d(Context context) {
        try {
            return Boolean.parseBoolean(a6.a(context, this.f7667a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }

    private x5(p4 p4Var) {
        this.f7667a = p4Var;
    }
}
