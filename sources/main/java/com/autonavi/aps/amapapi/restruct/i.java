package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.l9;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i extends a<l9> {
    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* bridge */ /* synthetic */ void a(l9 l9Var, long j6) {
        a2(l9Var, j6);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(l9 l9Var) {
        return a(l9Var);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ int c(l9 l9Var) {
        return b2(l9Var);
    }

    private static String a(l9 l9Var) {
        return l9Var == null ? "" : l9Var.b();
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(l9 l9Var) {
        if (l9Var == null) {
            return -113;
        }
        return l9Var.f6747c;
    }

    /* renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(l9 l9Var) {
        if (l9Var == null) {
            return 0L;
        }
        return l9Var.f6750f;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ long d(l9 l9Var) {
        return c2(l9Var);
    }

    public i(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(l9 l9Var, long j6) {
        if (l9Var != null) {
            l9Var.f6750f = j6;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long b() {
        return com.autonavi.aps.amapapi.config.a.f9965e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long c() {
        return com.autonavi.aps.amapapi.config.a.f9966f;
    }
}
