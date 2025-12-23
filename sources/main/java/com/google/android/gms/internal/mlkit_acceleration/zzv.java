package com.google.android.gms.internal.mlkit_acceleration;

import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzv {
    public static Object zza(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void zzb(boolean z5, String str, @CheckForNull Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(zzag.zza(str, obj));
        }
    }
}
