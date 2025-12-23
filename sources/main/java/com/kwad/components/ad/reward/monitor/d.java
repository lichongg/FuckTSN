package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static void a(AdTemplate adTemplate, boolean z5, AdVideoPreCacheConfig adVideoPreCacheConfig) {
        adTemplate.setLoadDataTime(SystemClock.elapsedRealtime());
        adTemplate.setLoadFromCache(z5);
        long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        if (adVideoPreCacheSize > 0) {
            adTemplate.setDownloadType(3);
            adTemplate.setDownloadSize(adVideoPreCacheSize);
        } else if (adVideoPreCacheSize < 0) {
            adTemplate.setDownloadType(2);
        } else {
            adTemplate.setDownloadType(1);
            adTemplate.setDownloadSize(0L);
        }
    }
}
