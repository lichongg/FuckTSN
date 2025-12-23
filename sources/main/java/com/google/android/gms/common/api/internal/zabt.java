package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zabt implements Runnable {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zabu zab;

    zabt(zabu zabuVar, ConnectionResult connectionResult) {
        this.zab = zabuVar;
        this.zaa = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        ApiKey apiKey;
        Api.Client client;
        Api.Client client2;
        Api.Client client3;
        Api.Client client4;
        zabu zabuVar = this.zab;
        map = zabuVar.zaa.zan;
        apiKey = zabuVar.zac;
        zabq zabqVar = (zabq) map.get(apiKey);
        if (zabqVar == null) {
            return;
        }
        if (!this.zaa.isSuccess()) {
            zabqVar.zar(this.zaa, null);
            return;
        }
        this.zab.zaf = true;
        client = this.zab.zab;
        if (client.requiresSignIn()) {
            this.zab.zah();
            return;
        }
        try {
            zabu zabuVar2 = this.zab;
            client3 = zabuVar2.zab;
            client4 = zabuVar2.zab;
            client3.getRemoteService(null, client4.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException unused) {
            client2 = this.zab.zab;
            client2.disconnect("Failed to get service from broker.");
            zabqVar.zar(new ConnectionResult(10), null);
        }
    }
}
