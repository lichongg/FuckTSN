package com.google.android.gms.internal.mlkit_vision_mediapipe;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdx {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzeb zzb;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.mlkit_vision_mediapipe.zzeb] */
    static {
        zzec zzecVar;
        int i6 = 0;
        while (true) {
            if (i6 >= 2) {
                zzecVar = new zzec();
                break;
            }
            zzecVar = null;
            try {
                zzecVar = (zzeb) Class.forName(zza[i6]).asSubclass(zzeb.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzecVar != null) {
                break;
            } else {
                i6++;
            }
        }
        zzb = zzecVar;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i6) {
        zzdy.zza(cls, "target");
        return zzb.zza(cls, 2);
    }

    public static StackTraceElement[] zzb(Class cls, int i6, int i7) {
        if (i6 > 0 || i6 == -1) {
            return zzb.zzb(cls, i6, 2);
        }
        throw new IllegalArgumentException("invalid maximum depth: 0");
    }
}
