package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
    public static Pair<Integer, String> m(@NonNull AdTemplate adTemplate) {
        String K = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        int i6 = 2;
        if (TextUtils.isEmpty(K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int BQ = com.kwad.sdk.core.config.e.BQ();
        long j6 = 0;
        int i7 = 1;
        String str = "";
        if (BQ < 0) {
            File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(K);
            if (!w.O(cf)) {
                a.C0688a c0688a = new a.C0688a();
                if (com.kwad.sdk.core.diskcache.b.a.GP().a(K, c0688a)) {
                    i6 = 1;
                }
                str = c0688a.msg;
                i7 = i6;
            }
            if (cf != null) {
                j6 = cf.length();
            }
            adTemplate.setDownloadSize(j6);
        } else if (BQ > 0) {
            a.C0688a c0688a2 = new a.C0688a();
            f bR = com.kwad.sdk.core.videocache.c.a.bR(ServiceProvider.getContext());
            if (!bR.eL(K)) {
                if (bR.a(K, BQ * 1024, c0688a2, null)) {
                    i6 = 1;
                }
                i7 = i6;
            }
            str = c0688a2.msg;
            adTemplate.setDownloadSize(BQ * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i7), str);
    }
}
