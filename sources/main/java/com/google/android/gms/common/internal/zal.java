package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zal {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public zal(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }

    public final int zaa(Context context, int i6) {
        return this.zaa.get(i6, -1);
    }

    public final void zac() {
        this.zaa.clear();
    }

    @ResultIgnorabilityUnspecified
    public final int zab(@NonNull Context context, @NonNull Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i6 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zaa = zaa(context, minApkVersion);
        if (zaa != -1) {
            return zaa;
        }
        int i7 = 0;
        while (true) {
            if (i7 < this.zaa.size()) {
                int keyAt = this.zaa.keyAt(i7);
                if (keyAt > minApkVersion && this.zaa.get(keyAt) == 0) {
                    break;
                }
                i7++;
            } else {
                i6 = -1;
                break;
            }
        }
        if (i6 == -1) {
            i6 = this.zab.isGooglePlayServicesAvailable(context, minApkVersion);
        }
        this.zaa.put(minApkVersion, i6);
        return i6;
    }
}
