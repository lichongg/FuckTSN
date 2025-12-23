package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder.ListenerKey zaa;

    @KeepForSdk
    protected abstract void unregisterListener(@NonNull A a6, @NonNull TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;

    @NonNull
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa;
    }

    @KeepForSdk
    protected UnregisterListenerMethod(@NonNull ListenerHolder.ListenerKey<L> listenerKey) {
        this.zaa = listenerKey;
    }
}
