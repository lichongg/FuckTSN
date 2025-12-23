package com.beizi.fusion;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface NativeAdListener extends a {
    void onAdClick();

    void onAdClosed();

    void onAdClosed(View view);

    void onAdFailed(int i6);

    void onAdLoaded(View view);

    void onAdShown();
}
