package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface IStandalonePreviewView {
    View getView();

    void release();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z5);

    void show();

    void stream();
}
