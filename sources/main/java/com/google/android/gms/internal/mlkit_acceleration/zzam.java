package com.google.android.gms.internal.mlkit_acceleration;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final /* synthetic */ class zzam {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j6, Object obj2, Object obj3) {
        while (!a.a(unsafe, obj, j6, obj2, obj3)) {
            if (unsafe.getObject(obj, j6) != obj2) {
                return false;
            }
        }
        return true;
    }
}
