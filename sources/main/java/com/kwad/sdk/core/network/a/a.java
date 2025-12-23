package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static AdHttpProxy aFm;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.network.a.a$a, reason: collision with other inner class name */
    public static class C0688a {
        public String msg;
    }

    private static boolean HC() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.BL();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0688a c0688a, long j6, boolean z5, AdHttpResponseListener adHttpResponseListener) {
        AdHttpProxy aVar;
        boolean HC = HC();
        AdHttpProxy adHttpProxy = aFm;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "isAdCacheEnable:" + HC);
            if (HC) {
                aVar = g.AI();
            } else {
                aVar = new com.kwad.sdk.core.network.c.a();
            }
            adHttpProxy = aVar;
            aFm = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.oz.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j6 + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j6, z5, adHttpResponseListener);
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", Log.getStackTraceString(e6));
            c0688a.msg = e6.getMessage();
            return false;
        }
    }
}
