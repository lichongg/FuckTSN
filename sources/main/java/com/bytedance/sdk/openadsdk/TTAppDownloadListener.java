package com.bytedance.sdk.openadsdk;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTAppDownloadListener {
    void onDownloadActive(long j6, long j7, String str, String str2);

    void onDownloadFailed(long j6, long j7, String str, String str2);

    void onDownloadFinished(long j6, String str, String str2);

    void onDownloadPaused(long j6, long j7, String str, String str2);

    void onIdle();

    void onInstalled(String str, String str2);
}
