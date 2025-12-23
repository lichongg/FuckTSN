package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder zaa;

    @Nullable
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    @KeepForSdk
    protected RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z5, int i6) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z5;
        this.zad = i6;
    }

    @KeepForSdk
    protected abstract void registerListener(@NonNull A a6, @NonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    protected RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder) {
        this(listenerHolder, null, false, 0);
    }

    @KeepForSdk
    public void clearListener() {
        this.zaa.clear();
    }

    @Nullable
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    @Nullable
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }

    @KeepForSdk
    protected RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @NonNull Feature[] featureArr, boolean z5) {
        this(listenerHolder, featureArr, z5, 0);
    }
}
