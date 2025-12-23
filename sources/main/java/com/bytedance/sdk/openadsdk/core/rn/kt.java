package com.bytedance.sdk.openadsdk.core.rn;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class kt {
    public static void j(final Uri uri, final com.bytedance.sdk.openadsdk.core.rn rnVar) {
        if (rnVar == null || !rnVar.j(uri)) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.kt.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.rn.this.xt(uri);
                }
            });
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.xt("WebView", "TTAndroidObj handleUri exception: ".concat(String.valueOf(e6)));
        }
    }

    public static void j(final com.bytedance.sdk.component.jy.cw cwVar, final int i6, final boolean z5) {
        if (cwVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rn.kt.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = com.bytedance.sdk.component.jy.cw.this.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/");
                sb.append(i6);
                if (z5) {
                    sb.append("/");
                    sb.append(uf.g());
                }
                com.bytedance.sdk.component.jy.cw.this.setUserAgentString(sb.toString());
            }
        });
    }
}
