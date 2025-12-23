package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcf {
    private static final zzch zza = zzb(zzch.zzd);

    private static zzch zzb(String[] strArr) {
        zzcn zzcnVar;
        try {
            zzcnVar = zzco.zza;
        } catch (NoClassDefFoundError unused) {
            zzcnVar = null;
        }
        if (zzcnVar != null) {
            return zzcnVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzch) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
