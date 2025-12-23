package com.google.android.gms.internal.mlkit_vision_pose_common;

import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzav {
    static int zza(int i6) {
        return (int) (Integer.rotateLeft((int) (i6 * (-862048943)), 15) * 461845907);
    }

    static int zzb(@CheckForNull Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
