package com.bykv.vk.component.ttvideo.mediakit.medialoader;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface AVMDLDataLoaderListener {
    String getCheckSumInfo(String str);

    long getInt64Value(int i6, long j6);

    String getStringValue(int i6, long j6, String str);

    void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo);
}
