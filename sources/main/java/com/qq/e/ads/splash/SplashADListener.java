package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j6);

    void onADPresent();

    void onADTick(long j6);

    void onNoAD(AdError adError);
}
