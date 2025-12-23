package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zaaw implements zabf {
    private final zabi zaa;
    private final Lock zab;
    private final Context zac;
    private final GoogleApiAvailabilityLight zad;

    @Nullable
    private ConnectionResult zae;
    private int zaf;
    private int zah;

    @Nullable
    private com.google.android.gms.signin.zae zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;

    @Nullable
    private IAccountAccessor zao;
    private boolean zap;
    private boolean zaq;

    @Nullable
    private final ClientSettings zar;
    private final Map zas;

    @Nullable
    private final Api.AbstractClientBuilder zat;
    private int zag = 0;
    private final Bundle zai = new Bundle();
    private final Set zaj = new HashSet();
    private final ArrayList zau = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final void zaA() {
        this.zam = false;
        this.zaa.zag.zad = Collections.EMPTY_SET;
        for (Api.AnyClientKey anyClientKey : this.zaj) {
            if (!this.zaa.zab.containsKey(anyClientKey)) {
                zabi zabiVar = this.zaa;
                zabiVar.zab.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    static /* bridge */ /* synthetic */ void zar(zaaw zaawVar, com.google.android.gms.signin.internal.zak zakVar) {
        if (zaawVar.zaG(0)) {
            ConnectionResult zaa = zakVar.zaa();
            if (!zaa.isSuccess()) {
                if (!zaawVar.zaI(zaa)) {
                    zaawVar.zaD(zaa);
                    return;
                } else {
                    zaawVar.zaA();
                    zaawVar.zaF();
                    return;
                }
            }
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult zaa2 = zavVar.zaa();
            if (!zaa2.isSuccess()) {
                String valueOf = String.valueOf(zaa2);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                zaawVar.zaD(zaa2);
                return;
            }
            zaawVar.zan = true;
            zaawVar.zao = (IAccountAccessor) Preconditions.checkNotNull(zavVar.zab());
            zaawVar.zap = zavVar.zac();
            zaawVar.zaq = zavVar.zad();
            zaawVar.zaF();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zag(@Nullable Bundle bundle) {
        if (zaG(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zaH()) {
                zaC();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zah(ConnectionResult connectionResult, Api api, boolean z5) {
        if (zaG(1)) {
            zaE(connectionResult, api, z5);
            if (zaH()) {
                zaC();
            }
        }
    }

    @GuardedBy("lock")
    private final void zaB(boolean z5) {
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z5) {
                zaeVar.zaa();
            }
            zaeVar.disconnect();
            this.zao = null;
        }
    }

    @GuardedBy("lock")
    private final void zaC() {
        this.zaa.zai();
        zabj.zaa().execute(new zaak(this));
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (this.zap) {
                zaeVar.zac((IAccountAccessor) Preconditions.checkNotNull(this.zao), this.zaq);
            }
            zaB(false);
        }
        Iterator it = this.zaa.zab.keySet().iterator();
        while (it.hasNext()) {
            ((Api.Client) Preconditions.checkNotNull((Api.Client) this.zaa.zaa.get((Api.AnyClientKey) it.next()))).disconnect();
        }
        this.zaa.zah.zab(this.zai.isEmpty() ? null : this.zai);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final void zaF() {
        if (this.zah != 0) {
            return;
        }
        if (!this.zam || this.zan) {
            ArrayList arrayList = new ArrayList();
            this.zag = 1;
            this.zah = this.zaa.zaa.size();
            for (Api.AnyClientKey anyClientKey : this.zaa.zaa.keySet()) {
                if (!this.zaa.zab.containsKey(anyClientKey)) {
                    arrayList.add((Api.Client) this.zaa.zaa.get(anyClientKey));
                } else if (zaH()) {
                    zaC();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.zau.add(zabj.zaa().submit(new zaap(this, arrayList)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final boolean zaG(int i6) {
        if (this.zag == i6) {
            return true;
        }
        this.zaa.zag.zaf();
        "Unexpected callback in ".concat(toString());
        zaJ(this.zag);
        zaJ(i6);
        new Exception();
        zaD(new ConnectionResult(8, null));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final boolean zaH() {
        int i6 = this.zah - 1;
        this.zah = i6;
        if (i6 > 0) {
            return false;
        }
        if (i6 < 0) {
            this.zaa.zag.zaf();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zaD(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult == null) {
            return true;
        }
        this.zaa.zaf = this.zaf;
        zaD(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final boolean zaI(ConnectionResult connectionResult) {
        return this.zal && !connectionResult.hasResolution();
    }

    private static final String zaJ(int i6) {
        return i6 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    static /* bridge */ /* synthetic */ Set zao(zaaw zaawVar) {
        ClientSettings clientSettings = zaawVar.zar;
        if (clientSettings == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map zad = zaawVar.zar.zad();
        for (Api api : zad.keySet()) {
            zabi zabiVar = zaawVar.zaa;
            if (!zabiVar.zab.containsKey(api.zab())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zab) zad.get(api)).zaa);
            }
        }
        return hashSet;
    }

    private final void zaz() {
        ArrayList arrayList = this.zau;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((Future) arrayList.get(i6)).cancel(true);
        }
        this.zau.clear();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zad() {
        this.zaa.zab.clear();
        this.zam = false;
        zaas zaasVar = null;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap hashMap = new HashMap();
        boolean z5 = false;
        for (Api api : this.zas.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull((Api.Client) this.zaa.zaa.get(api.zab()));
            z5 |= api.zac().getPriority() == 1;
            boolean booleanValue = ((Boolean) this.zas.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.zam = true;
                if (booleanValue) {
                    this.zaj.add(api.zab());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(client, new zaal(this, api, booleanValue));
        }
        if (z5) {
            this.zam = false;
        }
        if (this.zam) {
            Preconditions.checkNotNull(this.zar);
            Preconditions.checkNotNull(this.zat);
            this.zar.zae(Integer.valueOf(System.identityHashCode(this.zaa.zag)));
            zaat zaatVar = new zaat(this, zaasVar);
            Api.AbstractClientBuilder abstractClientBuilder = this.zat;
            Context context = this.zac;
            zabi zabiVar = this.zaa;
            ClientSettings clientSettings = this.zar;
            this.zak = abstractClientBuilder.buildClient(context, zabiVar.zag.getLooper(), clientSettings, (ClientSettings) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) zaatVar, (GoogleApiClient.OnConnectionFailedListener) zaatVar);
        }
        this.zah = this.zaa.zaa.size();
        this.zau.add(zabj.zaa().submit(new zaao(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final void zai(int i6) {
        zaD(new ConnectionResult(8, null));
    }

    public zaaw(zabi zabiVar, @Nullable ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, @Nullable Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabiVar;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final void zaD(ConnectionResult connectionResult) {
        zaz();
        zaB(!connectionResult.hasResolution());
        this.zaa.zak(connectionResult);
        this.zaa.zah.zaa(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public final void zaE(ConnectionResult connectionResult, Api api, boolean z5) {
        int priority = api.zac().getPriority();
        if ((!z5 || connectionResult.hasResolution() || this.zad.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) && (this.zae == null || priority < this.zaf)) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        zabi zabiVar = this.zaa;
        zabiVar.zab.put(api.zab(), connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("lock")
    public final boolean zaj() {
        zaz();
        zaB(true);
        this.zaa.zak(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
    }
}
