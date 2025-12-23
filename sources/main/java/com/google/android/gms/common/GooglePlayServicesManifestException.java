package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepName
/* loaded from: D:\Downloads\app\classes5.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int zza;

    public int getActualVersion() {
        return this.zza;
    }

    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public GooglePlayServicesManifestException(int i6, @NonNull String str) {
        super(str);
        this.zza = i6;
    }
}
