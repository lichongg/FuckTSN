package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.internal.a0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcf extends zzcg {
    public static List zzc(int... iArr) {
        int length = iArr.length;
        return length == 0 ? Collections.EMPTY_LIST : new zzce(iArr, 0, length);
    }

    static /* bridge */ /* synthetic */ int zza(int[] iArr, int i6, int i7, int i8) {
        while (i7 < i8) {
            if (iArr[i7] == i6) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int zzb(int i6, int i7, int i8) {
        return Math.min(Math.max(i6, i7), a0.f49221j);
    }
}
