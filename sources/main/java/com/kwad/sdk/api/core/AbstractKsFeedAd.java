package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class AbstractKsFeedAd implements KsFeedAd {
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getFeedView2(Context context);

    @Override // com.kwad.sdk.api.KsFeedAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getFeedView(Context context) {
        return getFeedView2(Wrapper.wrapContextIfNeed(context));
    }
}
