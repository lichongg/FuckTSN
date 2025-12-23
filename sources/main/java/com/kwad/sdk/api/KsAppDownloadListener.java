package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsAppDownloadListener {
    @KsAdSdkApi
    @Keep
    void onDownloadFailed();

    @KsAdSdkApi
    @Keep
    void onDownloadFinished();

    @KsAdSdkApi
    @Keep
    void onDownloadStarted();

    @KsAdSdkApi
    @Keep
    void onIdle();

    @KsAdSdkApi
    @Keep
    void onInstalled();

    @KsAdSdkApi
    @Keep
    void onProgressUpdate(int i6);
}
