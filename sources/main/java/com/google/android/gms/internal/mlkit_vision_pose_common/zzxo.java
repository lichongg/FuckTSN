package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzxo {
    private static final int[] zzb = {0, 0, 1, 2, 4, 8, 16};

    @VisibleForTesting
    public static final Random zza = new SecureRandom();

    public static boolean zza(zzxn zzxnVar) throws InterruptedException {
        int[] iArr = zzb;
        for (int i6 = 0; i6 < 7; i6++) {
            int i7 = iArr[i6];
            if (i7 > 0) {
                int i8 = i7 * 60000;
                Thread.sleep((i8 / 2) + zza.nextInt(i8));
            }
            try {
            } catch (zzxm e6) {
                e = e6;
                "retryWithRandomizedExponentialBackoff: ".concat(String.valueOf(e.getMessage()));
            } catch (IOException e7) {
                e = e7;
                "retryWithRandomizedExponentialBackoff: ".concat(String.valueOf(e.getMessage()));
            } catch (InterruptedException e8) {
                throw e8;
            }
            if (zzxnVar.zza()) {
                return true;
            }
        }
        return false;
    }
}
