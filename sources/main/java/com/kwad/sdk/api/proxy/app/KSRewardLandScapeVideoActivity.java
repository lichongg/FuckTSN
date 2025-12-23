package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSRewardLandScapeVideoActivity extends BaseProxyActivity {
    @Override // com.kwad.sdk.api.proxy.BaseProxyActivity
    @NonNull
    public IActivityProxy getDelegate(Context context) {
        return (IActivityProxy) Loader.get().newComponentProxy(context, KSRewardLandScapeVideoActivity.class, this);
    }
}
