package com.kwad.components.ad.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    @WorkerThread
    public static boolean a(@NonNull AdTemplate adTemplate, boolean z5, final AdVideoPreCacheConfig adVideoPreCacheConfig, final a aVar) {
        String str;
        boolean z6;
        boolean a6;
        String K = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return false;
        }
        final long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        if (adVideoPreCacheSize > 0) {
            long j6 = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0688a c0688a = new a.C0688a();
            f bR = com.kwad.sdk.core.videocache.c.a.bR(ServiceProvider.getContext());
            if (bR.eK(K)) {
                a(aVar);
                a6 = true;
            } else {
                a6 = bR.a(K, j6, c0688a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.d.b.1
                    private boolean cg = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j7, long j8) {
                        if ((j7 >= adVideoPreCacheSize || j7 >= j8) && !this.cg) {
                            this.cg = true;
                            b.a(aVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }
                });
            }
            str = c0688a.msg;
            z6 = a6;
        } else {
            str = "";
            if (adVideoPreCacheSize < 0) {
                File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(K);
                if (w.O(cf)) {
                    z6 = true;
                } else {
                    a.C0688a c0688a2 = new a.C0688a();
                    z6 = com.kwad.sdk.core.diskcache.b.a.GP().a(K, c0688a2);
                    str = c0688a2.msg;
                }
                adTemplate.setDownloadSize(cf != null ? cf.length() : 0L);
                if (z6) {
                    a(aVar);
                }
            } else {
                a(aVar);
                z6 = true;
            }
        }
        if (z6) {
            k.m(K, adVideoPreCacheConfig.getAdVideoPreCacheSize());
            return z6;
        }
        c.a(z5, adTemplate, str);
        com.kwad.components.ad.reward.monitor.b.a(z5, adTemplate);
        a(aVar, str);
        return z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.af();
    }

    private static void a(a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.ag();
    }
}
