package com.bykv.vk.component.ttvideo.mediakit.net;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface DNSCompletionListener {
    void onCancelled();

    void onCompletion(JSONObject jSONObject, Error error);

    void onRetry(Error error);
}
