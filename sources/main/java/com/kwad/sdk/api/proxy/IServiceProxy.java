package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IServiceProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @Keep
    IBinder onBind(@NonNull Service service, Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    void onCreate(@NonNull Service service);

    @KsAdSdkDynamicApi
    @Keep
    void onDestroy(@NonNull Service service);

    @KsAdSdkDynamicApi
    @Keep
    void onRebind(@NonNull Service service, Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    int onStartCommand(@NonNull Service service, Intent intent, int i6, int i7);

    boolean onUnbind(Service service, Intent intent);
}
