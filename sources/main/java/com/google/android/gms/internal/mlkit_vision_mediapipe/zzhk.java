package com.google.android.gms.internal.mlkit_vision_mediapipe;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhk {
    private static native boolean zzb(Context context, String str);

    public static synchronized boolean zza(Context context) {
        boolean zzb;
        synchronized (zzhk.class) {
            zzb = zzb(context, context.getCacheDir().getAbsolutePath());
        }
        return zzb;
    }
}
