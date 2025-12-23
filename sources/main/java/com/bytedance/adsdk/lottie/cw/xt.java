package com.bytedance.adsdk.lottie.cw;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements m {
    @Override // com.bytedance.adsdk.lottie.cw.m
    public r j(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new j(httpURLConnection);
    }
}
