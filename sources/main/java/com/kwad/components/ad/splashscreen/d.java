package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static int Fi;
    private String Fj;
    private int Fk = 2;

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i6) {
        d dVar = new d();
        Fi = i6;
        if (adInfo != null && cVar != null) {
            if (i6 == 1 || i6 == 4) {
                dVar.Z(a(adTemplate, adInfo, cVar));
            } else if (i6 == 10) {
                if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                    int pB = cVar.pB();
                    if (pB == 2) {
                        dVar.Z(a(adTemplate, adInfo, pB, 0));
                    } else {
                        dVar.Z("扭动或点击" + a(adTemplate, adInfo, pB, 0));
                    }
                } else {
                    try {
                        String dH = com.kwad.sdk.core.response.b.b.dH(adInfo);
                        if (TextUtils.isEmpty(dH)) {
                            dVar.Z("或点击跳转详情页或第三方应用");
                        } else {
                            dVar.Z("扭动或点击" + dH);
                        }
                    } catch (Exception unused) {
                        dVar.Z("或点击跳转详情页或第三方应用");
                    }
                }
            } else if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                dVar.Z("或点击" + a(adTemplate, adInfo, cVar.pB(), 0));
            } else {
                String a6 = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FO);
                if (TextUtils.isEmpty(a6)) {
                    a6 = "点击跳转详情页或第三方应用";
                }
                dVar.Z("或" + a6);
            }
        }
        dVar.aj(com.kwad.sdk.core.response.b.b.dK(adInfo));
        return dVar;
    }

    private void Z(String str) {
        this.Fj = str;
    }

    private void aj(int i6) {
        this.Fk = i6;
    }

    public final String lA() {
        return this.Fj;
    }

    public final int lB() {
        return this.Fk;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i6, int i7) {
        String aE = com.kwad.sdk.core.response.b.a.aE(adInfo);
        if (i6 == 2) {
            return i7 + "%";
        }
        if (i6 == 4) {
            return "继续下载";
        }
        if (i6 != 8) {
            return i6 != 12 ? aE : com.kwad.sdk.core.response.b.a.ac(adInfo);
        }
        return com.kwad.sdk.core.response.b.a.cl(adTemplate);
    }

    private static String a(AdInfo adInfo, int i6) {
        if (i6 == 1) {
            if (com.kwad.sdk.core.response.b.b.dH(adInfo) == null) {
                return "";
            }
            return com.kwad.sdk.core.response.b.b.dH(adInfo);
        }
        if (i6 != 4 || com.kwad.sdk.core.response.b.b.dI(adInfo) == null) {
            return "";
        }
        return com.kwad.sdk.core.response.b.b.dI(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return a(adTemplate, adInfo, cVar.pB(), 0);
        }
        String a6 = a(adInfo, Fi);
        return TextUtils.isEmpty(a6) ? "点击跳转详情页或第三方应用" : a6;
    }
}
