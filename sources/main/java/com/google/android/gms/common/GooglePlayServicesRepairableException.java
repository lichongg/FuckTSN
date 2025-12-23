package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zza;

    public int getConnectionStatusCode() {
        return this.zza;
    }

    public GooglePlayServicesRepairableException(int i6, @NonNull String str, @NonNull Intent intent) {
        super(str, intent);
        this.zza = i6;
    }
}
