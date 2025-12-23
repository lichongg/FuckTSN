package com.bytedance.sdk.openadsdk.core.nativeexpress.xt;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.r.oq;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j {

    /* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j$j, reason: collision with other inner class name */
    public interface InterfaceC0467j {
        com.bytedance.sdk.component.adexpress.j.xt.j j(String str, oq.j jVar, String str2);

        boolean j();
    }

    public static com.bytedance.sdk.component.adexpress.j.xt.j j(WebView webView, n nVar, String str, InterfaceC0467j interfaceC0467j) {
        h hVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        oq.j j6 = oq.j(str);
        boolean z5 = interfaceC0467j != null && interfaceC0467j.j();
        if (j6 != oq.j.IMAGE && z5 && nVar != null) {
            Iterator<h> it = nVar.fp().iterator();
            while (it.hasNext()) {
                hVar = it.next();
                if (!TextUtils.isEmpty(hVar.j()) && !TextUtils.isEmpty(str)) {
                    String j7 = hVar.j();
                    if (j7.startsWith(b.f50155b)) {
                        j7 = j7.replaceFirst(b.f50155b, b.f50154a);
                    }
                    if ((str.startsWith(b.f50155b) ? str.replaceFirst(b.f50155b, b.f50154a) : str).equals(j7)) {
                        break;
                    }
                }
            }
        }
        hVar = null;
        if (j6 == oq.j.IMAGE) {
            com.bytedance.sdk.component.adexpress.j.xt.j jVar = new com.bytedance.sdk.component.adexpress.j.xt.j();
            jVar.j(5);
            jVar.j(j(str, xt.j(nVar, str)));
            return jVar;
        }
        if (hVar == null) {
            if (interfaceC0467j == null) {
                return null;
            }
            return interfaceC0467j.j(str, j6, "");
        }
        com.bytedance.sdk.component.adexpress.j.xt.j jVar2 = new com.bytedance.sdk.component.adexpress.j.xt.j();
        jVar2.j(j(str, hVar.ae()));
        jVar2.j(5);
        return jVar2;
    }

    private static WebResourceResponse j(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream j6 = com.bytedance.sdk.openadsdk.g.xt.j(str, str2);
            if (j6 == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(oq.j.IMAGE.getType(), "utf-8", j6);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("Access-Control-Allow-Origin", "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
                vl.cw("CacheInterceptUtil", "get image WebResourceResponse error", th);
                return webResourceResponse;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
