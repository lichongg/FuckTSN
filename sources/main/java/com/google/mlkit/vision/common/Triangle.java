package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Triangle<T> {
    private final zzp zza;

    @NonNull
    public List<T> getAllPoints() {
        return this.zza;
    }

    @KeepForSdk
    public Triangle(@NonNull T t5, @NonNull T t6, @NonNull T t7) {
        this.zza = zzp.zzj(t5, t6, t7);
    }
}
