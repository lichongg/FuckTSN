package com.bykv.vk.component.ttvideo.medialoader;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface MediaLoaderListener {
    long getInt64Value(int i6, long j6);

    void onDataLoaderError(int i6, String str);

    void onLogInfo(int i6, String str, JSONObject jSONObject);

    void onNotify(int i6, long j6, long j7, String str);

    void onSwitchLoaderType(int i6, String str);
}
