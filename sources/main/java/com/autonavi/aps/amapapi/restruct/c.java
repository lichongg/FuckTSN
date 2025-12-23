package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c extends a<d> {
    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* bridge */ /* synthetic */ void a(d dVar, long j6) {
        a2(dVar, j6);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(d dVar) {
        return a(dVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ int c(d dVar) {
        return b2(dVar);
    }

    private static String a(d dVar) {
        return dVar == null ? "" : dVar.b();
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(d dVar) {
        if (dVar == null) {
            return 99;
        }
        return dVar.f10047s;
    }

    /* renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(d dVar) {
        if (dVar == null) {
            return 0L;
        }
        return dVar.f10048t;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ long d(d dVar) {
        return c2(dVar);
    }

    public c(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d dVar, long j6) {
        if (dVar != null) {
            dVar.f10048t = j6;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long b() {
        return com.autonavi.aps.amapapi.config.a.f9967g;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long c() {
        return com.autonavi.aps.amapapi.config.a.f9968h;
    }
}
