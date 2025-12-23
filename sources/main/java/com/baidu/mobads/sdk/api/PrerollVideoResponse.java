package com.baidu.mobads.sdk.api;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface PrerollVideoResponse {
    public static final String GIF = "gif";
    public static final String NORMAL = "normal";
    public static final String VIDEO = "video";

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getDesc();

    String getIconUrl();

    String getImageUrl();

    String getMaterialType();

    String getTitle();

    String getVideoUrl();

    void handleClick(View view);

    void handleClick(View view, int i6);

    void recordImpression(View view);
}
