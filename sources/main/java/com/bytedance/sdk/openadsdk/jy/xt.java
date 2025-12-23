package com.bytedance.sdk.openadsdk.jy;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private Map<String, String> cw;

    /* renamed from: j, reason: collision with root package name */
    private Uri f31549j;
    private String xt;

    public Map<String, String> cw() {
        return this.cw;
    }

    public Uri j() {
        return this.f31549j;
    }

    public String xt() {
        return this.xt;
    }

    public xt(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.f31549j = webResourceRequest.getUrl();
            this.xt = webResourceRequest.getMethod();
            this.cw = webResourceRequest.getRequestHeaders();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f31549j = Uri.parse(str);
            this.xt = "GET";
        }
    }
}
