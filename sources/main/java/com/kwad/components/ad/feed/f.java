package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    public static String l(@NonNull AdTemplate adTemplate) {
        String str;
        String au = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.el(adTemplate));
        if (com.kwad.components.core.c.b.oc()) {
            if (adTemplate.fromCache) {
                str = "【cache】";
            } else {
                str = "";
            }
            return str + au;
        }
        return au;
    }
}
