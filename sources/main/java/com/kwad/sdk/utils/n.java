package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n {
    public static long aYW = -1;

    public static void eK(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = aYW;
            adTemplate.mOutClickTimeParam = aYW;
        }
    }

    public static void eL(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void eM(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long eN(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j6 = adTemplate.mOutClickTimeParam;
        return j6 > 0 ? j6 : adTemplate.mVisibleTimeParam;
    }
}
