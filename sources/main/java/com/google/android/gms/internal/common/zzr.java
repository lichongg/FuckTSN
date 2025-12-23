package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NullMarked
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzr extends zzp {
    public static boolean zza(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
