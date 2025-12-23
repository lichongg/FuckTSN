package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zak extends zap {
    private final SparseArray zad;

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i6 = 0; i6 < this.zad.size(); i6++) {
            zaj zai = zai(i6);
            if (zai != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zai.zaa);
                printWriter.println(":");
                zai.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void zac() {
        for (int i6 = 0; i6 < this.zad.size(); i6++) {
            zaj zai = zai(i6);
            if (zai != null) {
                zai.zab.connect();
            }
        }
    }

    @Nullable
    private final zaj zai(int i6) {
        if (this.zad.size() <= i6) {
            return null;
        }
        SparseArray sparseArray = this.zad;
        return (zaj) sparseArray.get(sparseArray.keyAt(i6));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void zab(ConnectionResult connectionResult, int i6) {
        if (i6 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zajVar = (zaj) this.zad.get(i6);
        if (zajVar != null) {
            zae(i6);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zajVar.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public final void zad(int i6, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        Preconditions.checkState(this.zad.indexOfKey(i6) < 0, "Already managing a GoogleApiClient with id " + i6);
        zam zamVar = (zam) this.zab.get();
        String.valueOf(zamVar);
        zaj zajVar = new zaj(this, i6, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zajVar);
        this.zad.put(i6, zajVar);
        if (this.zaa && zamVar == null) {
            "connecting ".concat(googleApiClient.toString());
            googleApiClient.connect();
        }
    }

    public final void zae(int i6) {
        zaj zajVar = (zaj) this.zad.get(i6);
        this.zad.remove(i6);
        if (zajVar != null) {
            zajVar.zab.unregisterConnectionFailedListener(zajVar);
            zajVar.zab.disconnect();
        }
    }

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.zad = new SparseArray();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zakVar != null) {
            return zakVar;
        }
        return new zak(fragment);
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        String.valueOf(this.zad);
        if (this.zab.get() == null) {
            for (int i6 = 0; i6 < this.zad.size(); i6++) {
                zaj zai = zai(i6);
                if (zai != null) {
                    zai.zab.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i6 = 0; i6 < this.zad.size(); i6++) {
            zaj zai = zai(i6);
            if (zai != null) {
                zai.zab.disconnect();
            }
        }
    }
}
