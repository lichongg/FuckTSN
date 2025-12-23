package com.bytedance.android.live.base.api.outer;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface ILiveStatusListener {
    void onError(String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z5);

    void onPrepare();

    void onRoomInvalid();

    void onVideoSizeChanged(int i6, int i7);
}
