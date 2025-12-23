package com.google.android.gms.internal.base;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zan {
    @ChecksSdkIntAtLeast(api = 33)
    static boolean zaa() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
