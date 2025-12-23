package com.bytedance.android.livehostapi.platform;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface TokenRefreshCallback {
    void onFailed(Throwable th);

    void onSuccess(TokenInfo tokenInfo);
}
