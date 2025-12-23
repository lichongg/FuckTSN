package com.bytedance.sdk.openadsdk.live;

import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface ILiveAdCustomConfig {
    String convertToEnterFromMerge(int i6);

    String convertToEnterMethod(int i6, boolean z5);

    Object invoke(int i6, Bundle bundle);

    void onEventV3(String str, JSONObject jSONObject);

    int openLR(String str);
}
