package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class AbstrackKsSplashScreenAd implements KsSplashScreenAd {
    @Nullable
    @KsAdSdkDynamicApi
    public abstract View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    @Nullable
    @KsAdSdkDynamicApi
    public View getView(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return getView2(Wrapper.wrapContextIfNeed(context), splashScreenAdInteractionListener);
    }
}
