package com.kwad.sdk.core.track;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static List<String> a(AdTemplate adTemplate, int i6, @NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo el = e.el(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = el.adTrackInfoList;
        if (!ap.L(list2)) {
            List<String> a6 = a(i6, aVar, arrayList, el, list2);
            if (a6 == null) {
                Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdInfo.AdTrackInfo next = it.next();
                    if (next.type == i6 && (list = next.urls) != null) {
                        arrayList.addAll(list);
                        break;
                    }
                }
            } else {
                return a6;
            }
        }
        return arrayList;
    }

    private static boolean dK(int i6) {
        return i6 >= 200 && i6 < 300;
    }

    public static void e(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo el = e.el(adTemplate);
        int i6 = aVar.awx;
        List<String> a6 = a(adTemplate, i6, aVar);
        if (ap.L(a6)) {
            return;
        }
        boolean dw = com.kwad.sdk.core.response.b.a.dw(el);
        boolean dx = com.kwad.sdk.core.response.b.a.dx(el);
        for (String str : a6) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i6, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i6, str);
                return;
            }
            if (bw.hA(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i6, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap hashMap = null;
            String a7 = ai.a(ServiceProvider.getContext(), str, i6 == 2 ? aVar.mK : null, com.kwad.sdk.core.response.b.a.aB(e.el(adTemplate)));
            ai.f(adTemplate, str, a7);
            AdHttpProxy AI = g.AI();
            int i7 = AI instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + dw);
            if (dw) {
                com.kwad.sdk.core.i.c j6 = com.kwad.sdk.core.i.a.j(dw, dx);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + j6);
                if (j6 != null) {
                    hashMap = new HashMap();
                    hashMap.put("User-Agent", j6.JS());
                }
            }
            com.kwad.sdk.core.network.c doGetWithoutResponse = AI.doGetWithoutResponse(a7, hashMap, !dw);
            if (dK(doGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i6);
                com.kwad.sdk.commercial.j.a.a(adTemplate, i6, str, doGetWithoutResponse.code, i7);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i6, str, a7, d.cu(doGetWithoutResponse.code), doGetWithoutResponse.aEk, i7);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r4.addAll(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.String> a(int r2, com.kwad.sdk.core.adlog.c.a r3, java.util.List<java.lang.String> r4, com.kwad.sdk.core.response.model.AdInfo r5, java.util.List<com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo> r6) {
        /*
            r0 = 402(0x192, float:5.63E-43)
            if (r2 != r0) goto L4f
            boolean r2 = com.kwad.sdk.core.response.b.a.bo(r5)
            if (r2 == 0) goto L4f
            java.lang.String r2 = r3.Pj     // Catch: java.lang.Throwable -> L4e
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L4e
            if (r2 != 0) goto L20
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r3.Pj     // Catch: java.lang.Throwable -> L4e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = "photoPlaySecond"
            int r2 = r2.optInt(r3)     // Catch: java.lang.Throwable -> L4e
            goto L22
        L20:
            int r2 = r3.axJ     // Catch: java.lang.Throwable -> L4e
        L22:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r5 = r5.adBaseInfo     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = r5.videoPlayedNSConfig     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Throwable -> L4e
        L2f:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L4e
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo r6 = (com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo) r6     // Catch: java.lang.Throwable -> L4e
            int r0 = r6.type     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L4e
            int r1 = r3.optInt(r1)     // Catch: java.lang.Throwable -> L4e
            if (r0 != r1) goto L2f
            java.util.List<java.lang.String> r6 = r6.urls     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L2f
            r4.addAll(r6)     // Catch: java.lang.Throwable -> L4e
        L4e:
            return r4
        L4f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.track.a.a(int, com.kwad.sdk.core.adlog.c.a, java.util.List, com.kwad.sdk.core.response.model.AdInfo, java.util.List):java.util.List");
    }
}
