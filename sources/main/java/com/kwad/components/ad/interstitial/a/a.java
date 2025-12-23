package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static boolean s(@NonNull AdTemplate adTemplate) {
        boolean z5;
        f bR;
        String K = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        if (TextUtils.isEmpty(K)) {
            b.eQ().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.eQ().x(adTemplate);
        int BQ = com.kwad.sdk.core.config.e.BQ();
        long j6 = 0;
        String str = "";
        if (BQ < 0) {
            File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(K);
            if (w.O(cf)) {
                z5 = true;
            } else {
                a.C0688a c0688a = new a.C0688a();
                z5 = com.kwad.sdk.core.diskcache.b.a.GP().a(K, c0688a);
                str = c0688a.msg;
            }
            if (cf != null) {
                j6 = cf.length();
            }
            adTemplate.setDownloadSize(j6);
            adTemplate.setDownloadType(2);
        } else if (BQ > 0) {
            a.C0688a c0688a2 = new a.C0688a();
            if (com.kwad.sdk.core.config.e.Ge() == 1) {
                bR = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0);
            } else if (com.kwad.sdk.core.config.e.Ge() == 2) {
                bR = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1);
            } else {
                bR = com.kwad.sdk.core.videocache.c.a.bR(ServiceProvider.getContext());
            }
            if (!bR.eL(K)) {
                z5 = bR.a(K, BQ * 1024, c0688a2, null);
            } else {
                z5 = true;
            }
            str = c0688a2.msg;
            adTemplate.setDownloadSize(BQ * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            z5 = true;
        }
        if (!z5) {
            adTemplate.setDownloadStatus(2);
            b.eQ().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.eW();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
            return z5;
        }
        adTemplate.setDownloadStatus(1);
        return z5;
    }
}
