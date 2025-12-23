package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    final /* synthetic */ GoogleApiManager zaa;
    private final Api.Client zab;
    private final ApiKey zac;

    @Nullable
    private IAccountAccessor zad = null;

    @Nullable
    private Set zae = null;
    private boolean zaf = false;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.zaa = googleApiManager;
        this.zab = client;
        this.zac = apiKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zah() {
        IAccountAccessor iAccountAccessor;
        if (!this.zaf || (iAccountAccessor = this.zad) == null) {
            return;
        }
        this.zab.getRemoteService(iAccountAccessor, this.zae);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        this.zaa.zar.post(new zabt(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void zae(ConnectionResult connectionResult) {
        Map map;
        map = this.zaa.zan;
        zabq zabqVar = (zabq) map.get(this.zac);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void zaf(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
        } else {
            this.zad = iAccountAccessor;
            this.zae = set;
            zah();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void zag(int i6) {
        Map map;
        boolean z5;
        map = this.zaa.zan;
        zabq zabqVar = (zabq) map.get(this.zac);
        if (zabqVar != null) {
            z5 = zabqVar.zaj;
            if (z5) {
                zabqVar.zas(new ConnectionResult(17));
            } else {
                zabqVar.onConnectionSuspended(i6);
            }
        }
    }
}
