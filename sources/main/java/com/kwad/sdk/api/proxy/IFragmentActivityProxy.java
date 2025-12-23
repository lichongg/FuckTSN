package com.kwad.sdk.api.proxy;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class IFragmentActivityProxy extends IActivityProxy {
    private BaseProxyFragmentActivity mProxyFragmentActivity;

    @KsAdSdkDynamicApi
    @Keep
    public final KsFragmentManager getSupportFragmentManager() {
        return this.mProxyFragmentActivity.getSupportFragmentManager2();
    }

    void setProxyFragmentActivity(BaseProxyFragmentActivity baseProxyFragmentActivity) {
        this.mProxyFragmentActivity = baseProxyFragmentActivity;
    }

    public void onAttachFragment(KsFragment ksFragment) {
    }
}
