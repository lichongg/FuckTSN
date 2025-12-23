package com.beizi.ad.internal.view;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface c {
    void destroy();

    boolean failed();

    int getCreativeHeight();

    int getCreativeWidth();

    int getRefreshInterval();

    View getView();

    void onDestroy();

    void onPause();

    void onResume();

    void visible();
}
