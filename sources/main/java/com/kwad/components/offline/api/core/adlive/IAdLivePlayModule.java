package com.kwad.components.offline.api.core.adlive;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IAdLivePlayModule {
    void addInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor);

    LiveShopItemInfo getCurrentShowShopItemInfo();

    long getPlayDuration();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener);

    void registerAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener);

    void release();

    void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor);

    void resume();

    void setAudioEnabled(boolean z5, boolean z6);

    void setForceGetAudioFocus(boolean z5);

    void skipToEnd();

    void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener);

    void unRegisterAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener);
}
