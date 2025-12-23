package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private static boolean PE;
    private static final b PF = new b() { // from class: com.kwad.components.core.e.d.d.3
        long PL;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.PL = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.PL != 0) {
                com.kwad.sdk.core.adlog.c.n(getAdTemplate(), System.currentTimeMillis() - this.PL);
            }
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.PF);
            setAdTemplate(null);
            this.PL = 0L;
        }
    };

    public static int a(final a.C0616a c0616a, int i6) {
        Context context = c0616a.getContext();
        final AdTemplate adTemplate = c0616a.getAdTemplate();
        String a6 = a(c0616a, adTemplate);
        if (TextUtils.isEmpty(a6)) {
            return 0;
        }
        final AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity ej = m.ej(context);
        if (ej == null || !com.kwad.sdk.core.response.b.a.T(el) || c0616a.pf()) {
            final String a7 = a(a6, c0616a, el);
            final int i7 = 1;
            return com.kwad.sdk.core.download.a.b.a(context, a7, new b.a() { // from class: com.kwad.components.core.e.d.d.1
                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                    if (pV()) {
                        a.C0675a c0675a = new a.C0675a();
                        aVar.Pk = c0675a;
                        c0675a.axe = true;
                    }
                    com.kwad.sdk.core.adlog.c.b(AdTemplate.this, "", i7, aVar);
                    com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a7, bw.s(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onPreStart() {
                    com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a7);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    com.kwad.sdk.core.adlog.c.a pq = c0616a.pq();
                    if (pV()) {
                        if (pq.Pk == null) {
                            pq.Pk = new a.C0675a();
                        }
                        pq.Pk.axe = true;
                    }
                    com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a7);
                    com.kwad.sdk.core.adlog.c.a(AdTemplate.this, "", i7, pq);
                    d.a(AdTemplate.this, a7, i7);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void pU() {
                    com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a7);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final boolean pV() {
                    return com.kwad.sdk.core.response.b.a.ck(el);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    com.kwad.components.core.proxy.launchdialog.e.sc().aF(AdTemplate.this);
                    d.PF.setAdTemplate(AdTemplate.this);
                    com.kwad.sdk.core.c.b.Ho();
                    com.kwad.sdk.core.c.b.a(d.PF);
                    com.kwad.sdk.core.adlog.c.axn = d.an(a7);
                    com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a7);
                }
            });
        }
        c0616a.ay(1);
        com.kwad.components.core.e.e.e.a(ej, c0616a);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aA(boolean z5) {
        PE = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject an(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void az(boolean z5) {
        com.kwad.sdk.core.adlog.c.axo = z5;
    }

    private static String b(a.C0616a c0616a, AdInfo adInfo, String str) {
        long j6 = c0616a.getAdTemplate().getmCurPlayTime();
        if (j6 > 0) {
            j6 = Math.max(j6 - com.kwad.sdk.core.response.b.a.bn(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j6)).toString();
    }

    private static boolean pS() {
        return PE;
    }

    private static String l(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static String a(String str, a.C0616a c0616a, AdInfo adInfo) {
        AdTemplate adTemplate = c0616a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bm(adInfo)) {
            str = b(c0616a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cR(adInfo)) {
            str = a(c0616a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cJ(adInfo) || com.kwad.sdk.core.response.b.a.cP(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0616a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String a(a.C0616a c0616a, AdTemplate adTemplate) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : el.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0616a.dZ()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0616a.pj()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + el.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cT(el);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i6) {
        if (pS()) {
            return;
        }
        aA(true);
        int Fo = com.kwad.sdk.core.config.e.Fo();
        com.kwad.sdk.core.config.e.Fp();
        int abs = Math.abs(Fo);
        if (abs > 0) {
            bw.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.aA(false);
                    com.kwad.sdk.core.c.b.Ho();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "", i6);
                    com.kwad.sdk.commercial.f.a.j(AdTemplate.this, str);
                }
            }, null, abs * 1000);
        } else {
            aA(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(com.kwad.components.core.e.d.a.C0616a r3, com.kwad.sdk.core.response.model.AdInfo r4, java.lang.String r5) {
        /*
            boolean r0 = com.kwad.sdk.core.response.b.a.bj(r4)
            if (r0 != 0) goto L7
            return r5
        L7:
            java.util.concurrent.Callable r0 = r3.pe()
            if (r0 == 0) goto L14
            java.lang.Object r0 = r0.call()     // Catch: java.lang.Exception -> L14
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L14
            goto L15
        L14:
            r0 = 0
        L15:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L1f
            java.lang.String r0 = r3.pd()
        L1f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "__simpleItemId__"
            java.lang.String r2 = "__itemId__"
            if (r3 == 0) goto L3c
            boolean r3 = r5.contains(r2)
            if (r3 != 0) goto L37
            boolean r3 = r5.contains(r1)
            if (r3 == 0) goto L36
            goto L37
        L36:
            return r5
        L37:
            java.lang.String r3 = com.kwad.sdk.core.response.b.a.cT(r4)
            return r3
        L3c:
            long r3 = com.kwad.components.core.e.b.a.ai(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L45
            goto L46
        L45:
            r3 = r0
        L46:
            java.lang.String r4 = r5.replaceAll(r2, r0)
            java.lang.String r3 = r4.replaceAll(r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.e.d.d.a(com.kwad.components.core.e.d.a$a, com.kwad.sdk.core.response.model.AdInfo, java.lang.String):java.lang.String");
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i6 = 0;
        if (!as.ap(context, "com.smile.gifmaker") && as.ap(context, "com.kuaishou.nebula")) {
            i6 = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i6, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i6, String str2) {
        return (!TextUtils.isEmpty(str2) && (i6 == 0 || i6 == 3)) ? l(str, str2) : str;
    }
}
