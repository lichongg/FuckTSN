package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zam {
    private final int zaa;
    private final ConnectionResult zab;

    final int zaa() {
        return this.zaa;
    }

    final ConnectionResult zab() {
        return this.zab;
    }

    zam(ConnectionResult connectionResult, int i6) {
        Preconditions.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = i6;
    }
}
