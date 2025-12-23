package com.bytedance.sdk.openadsdk.mediation.bridge;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface IMediationCustomizeVideo {
    String getVideoUrl();

    void reportVideoAutoStart();

    void reportVideoBreak(long j6);

    void reportVideoContinue(long j6);

    void reportVideoError(long j6, int i6, int i7);

    void reportVideoFinish();

    void reportVideoPause(long j6);

    void reportVideoStart();

    void reportVideoStartError(int i6, int i7);
}
