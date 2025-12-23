package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ICompletedRemoteView {
    @KsAdSdkDynamicApi
    @Keep
    RemoteViews build();

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(@DrawableRes int i6);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    @Keep
    void setInstallText(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setName(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setSize(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setStatus(String str);
}
