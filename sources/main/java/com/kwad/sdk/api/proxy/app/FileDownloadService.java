package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class FileDownloadService {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Keep
    public static class SeparateProcessService extends BaseProxyService {
        @Override // com.kwad.sdk.api.proxy.BaseProxyService
        @NonNull
        public IServiceProxy getDelegate(Context context) {
            return (IServiceProxy) Loader.get().newComponentProxy(context, SeparateProcessService.class, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Keep
    public static class SharedMainProcessService extends BaseProxyService {
        @Override // com.kwad.sdk.api.proxy.BaseProxyService
        @NonNull
        public IServiceProxy getDelegate(Context context) {
            return (IServiceProxy) Loader.get().newComponentProxy(context, SharedMainProcessService.class, this);
        }
    }
}
