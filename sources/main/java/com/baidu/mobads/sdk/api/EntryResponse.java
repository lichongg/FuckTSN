package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface EntryResponse {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface EntryAdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i6);

        void onAdClick();

        void onAdUnionClick();
    }

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getTitle();

    @Deprecated
    boolean isAdAvailable();

    boolean isReady(Context context);

    void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryAdInteractionListener entryAdInteractionListener);

    void unionLogoClick();
}
