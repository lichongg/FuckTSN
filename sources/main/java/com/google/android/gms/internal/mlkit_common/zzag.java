package com.google.android.gms.internal.mlkit_common;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzag {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(obj2) + " and " + String.valueOf(obj3) + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(obj));
    }

    zzag(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }
}
