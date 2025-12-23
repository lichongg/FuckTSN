package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference zaa;
    private final Api zab;
    private final boolean zac;

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        zabi zabiVar;
        Lock lock;
        Lock lock2;
        boolean zaG;
        boolean zaH;
        zaaw zaawVar = (zaaw) this.zaa.get();
        if (zaawVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        zabiVar = zaawVar.zaa;
        Preconditions.checkState(myLooper == zabiVar.zag.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = zaawVar.zab;
        lock.lock();
        try {
            zaG = zaawVar.zaG(0);
            if (zaG) {
                if (!connectionResult.isSuccess()) {
                    zaawVar.zaE(connectionResult, this.zab, this.zac);
                }
                zaH = zaawVar.zaH();
                if (zaH) {
                    zaawVar.zaF();
                }
            }
        } finally {
            lock2 = zaawVar.zab;
            lock2.unlock();
        }
    }

    public zaal(zaaw zaawVar, Api api, boolean z5) {
        this.zaa = new WeakReference(zaawVar);
        this.zab = api;
        this.zac = z5;
    }
}
