package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, zaj {

    @Nullable
    private static volatile Executor zaa;
    private final ClientSettings zab;
    private final Set zac;

    @Nullable
    private final Account zad;

    @KeepForSdk
    @VisibleForTesting
    protected GmsClient(@NonNull Context context, @NonNull Handler handler, int i6, @NonNull ClientSettings clientSettings) {
        super(context, handler, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i6, null, null);
        this.zab = (ClientSettings) Preconditions.checkNotNull(clientSettings);
        this.zad = clientSettings.getAccount();
        this.zac = zaa(clientSettings.getAllRequestedScopes());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    @KeepForSdk
    protected Executor getBindServiceExecutor() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    public final Account getAccount() {
        return this.zad;
    }

    @NonNull
    @KeepForSdk
    protected final ClientSettings getClientSettings() {
        return this.zab;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    @KeepForSdk
    protected final Set<Scope> getScopes() {
        return this.zac;
    }

    private final Set zaa(@NonNull Set set) {
        Set<Scope> validateScopes = validateScopes(set);
        Iterator<Scope> it = validateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    @KeepForSdk
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        if (requiresSignIn()) {
            return this.zac;
        }
        return Collections.EMPTY_SET;
    }

    @KeepForSdk
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, int i6, @NonNull ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i6, clientSettings, null, null);
    }

    @KeepForSdk
    @Deprecated
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, int i6, @NonNull ClientSettings clientSettings, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i6, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    @KeepForSdk
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, int i6, @NonNull ClientSettings clientSettings, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i6, clientSettings, (ConnectionCallbacks) Preconditions.checkNotNull(connectionCallbacks), (OnConnectionFailedListener) Preconditions.checkNotNull(onConnectionFailedListener));
    }

    @VisibleForTesting
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailability googleApiAvailability, int i6, @NonNull ClientSettings clientSettings, @Nullable ConnectionCallbacks connectionCallbacks, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i6, connectionCallbacks == null ? null : new zah(connectionCallbacks), onConnectionFailedListener != null ? new zai(onConnectionFailedListener) : null, clientSettings.zac());
        this.zab = clientSettings;
        this.zad = clientSettings.getAccount();
        this.zac = zaa(clientSettings.getAllRequestedScopes());
    }

    @NonNull
    @KeepForSdk
    protected Set<Scope> validateScopes(@NonNull Set<Scope> set) {
        return set;
    }
}
