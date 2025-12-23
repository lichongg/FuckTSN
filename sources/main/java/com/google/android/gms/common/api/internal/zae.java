package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zae extends zai {
    protected final BaseImplementation.ApiMethodImpl zaa;

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(@NonNull Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(@NonNull Exception exc) {
        try {
            this.zaa.setFailedResult(new Status(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            this.zaa.run(zabqVar.zaf());
        } catch (RuntimeException e6) {
            zae(e6);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(@NonNull zaad zaadVar, boolean z5) {
        zaadVar.zac(this.zaa, z5);
    }

    public zae(int i6, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(i6);
        this.zaa = (BaseImplementation.ApiMethodImpl) Preconditions.checkNotNull(apiMethodImpl, "Null methods are not runnable.");
    }
}
