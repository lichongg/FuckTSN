package com.kwad.sdk.api.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseProxyReceiver extends BroadcastReceiver {
    private IReceiverProxy mDelegate;

    @NonNull
    protected abstract IReceiverProxy getDelegate(Context context);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegate == null) {
            this.mDelegate = getDelegate(Wrapper.wrapContextIfNeed(context));
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        this.mDelegate.onReceive(context, intent);
    }
}
