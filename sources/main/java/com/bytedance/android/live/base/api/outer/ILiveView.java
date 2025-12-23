package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface ILiveView {
    View getView();

    void onDislike();

    void openLive();

    void release();

    void reportShow();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z5);

    void show();

    void stream();
}
