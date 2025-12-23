package com.bytedance.sdk.component.cw.j;

/* loaded from: D:\Downloads\app\classes4.dex */
final class av {

    /* renamed from: j, reason: collision with root package name */
    static az f26083j;
    static long xt;

    static az j() {
        synchronized (av.class) {
            try {
                az azVar = f26083j;
                if (azVar == null) {
                    return new az();
                }
                f26083j = azVar.f26085m;
                azVar.f26085m = null;
                xt -= 8192;
                return azVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private av() {
    }

    static void j(az azVar) {
        if (azVar.f26085m == null && azVar.ae == null) {
            if (azVar.f26086r) {
                return;
            }
            synchronized (av.class) {
                try {
                    long j6 = xt;
                    if (j6 + 8192 > 65536) {
                        return;
                    }
                    xt = j6 + 8192;
                    azVar.f26085m = f26083j;
                    azVar.cw = 0;
                    azVar.xt = 0;
                    f26083j = azVar;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
