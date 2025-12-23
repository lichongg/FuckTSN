package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zad extends zac {
    protected final TaskCompletionSource zaa;

    protected abstract void zac(zabq zabqVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(@NonNull Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(@NonNull Exception exc) {
        this.zaa.trySetException(exc);
    }

    public zad(int i6, TaskCompletionSource taskCompletionSource) {
        super(i6);
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            zac(zabqVar);
        } catch (DeadObjectException e6) {
            zad(zai.zah(e6));
            throw e6;
        } catch (RemoteException e7) {
            zad(zai.zah(e7));
        } catch (RuntimeException e8) {
            this.zaa.trySetException(e8);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public void zag(@NonNull zaad zaadVar, boolean z5) {
    }
}
