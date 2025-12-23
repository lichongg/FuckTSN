package com.google.mlkit.common;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MlKit {
    private MlKit() {
    }

    public static void initialize(@NonNull Context context) {
        MlKitContext.zza(context);
    }
}
