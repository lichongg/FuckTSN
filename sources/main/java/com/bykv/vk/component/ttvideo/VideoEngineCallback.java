package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.utils.Error;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface VideoEngineCallback {
    public static final int AFTER_FIRST_FRAME = 1;
    public static final int BEFORE_FIRST_FRAME = 0;
    public static final int BUFFERING_TYPE_DECODER = 1;
    public static final int BUFFERING_TYPE_NET = 0;

    void onBufferEnd(int i6);

    void onBufferStart(int i6, int i7, int i8);

    void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i6);

    void onCompletion(TTVideoEngine tTVideoEngine);

    void onError(Error error);

    void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i6);

    void onMDLHitCache(String str, long j6);

    void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i6);

    void onPrepare(TTVideoEngine tTVideoEngine);

    void onPrepared(TTVideoEngine tTVideoEngine);

    void onRenderSeekComplete(int i6);

    void onRenderStart(TTVideoEngine tTVideoEngine);

    void onRetry(int i6);

    void onUseMDLCacheEnd();

    void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i6, int i7);
}
