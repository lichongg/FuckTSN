package com.kwad.sdk.m;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements IServiceProxy {
    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return null;
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(@NonNull Service service, Intent intent, int i6, int i7) {
        if (service instanceof BaseProxyService) {
            return ((BaseProxyService) service).superOnStartCommand(intent, i6, i7);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public boolean onUnbind(Service service, Intent intent) {
        if (service instanceof BaseProxyService) {
            return ((BaseProxyService) service).superOnUnbind(intent);
        }
        throw new RuntimeException(service + " must be AbstractServiceProxy");
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(@NonNull Service service) {
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
    }

    @Override // com.kwad.sdk.api.proxy.IServiceProxy
    public void onRebind(@NonNull Service service, Intent intent) {
    }
}
