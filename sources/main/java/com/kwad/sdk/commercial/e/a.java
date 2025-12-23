package com.kwad.sdk.commercial.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static void a(@Nullable SceneImpl sceneImpl, long j6, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(d.ct(sceneImpl.getAdStyle())).O("ad_sdk_ad_parse_performance", "default").z(c.DX().cO(str).setPosId(sceneImpl.posId).setLlsid(j6)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bM(@NonNull AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (e.ev(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo el = e.el(adTemplate);
            int i6 = el.adBaseInfo.adOperationType;
            if (i6 == 1) {
                String cU = com.kwad.sdk.core.response.b.a.cU(el);
                if (bw.hA(cU)) {
                    c(adTemplate, "download_url", cU);
                }
            } else if (i6 == 2) {
                String aS = com.kwad.sdk.core.response.b.a.aS(el);
                if (bw.hA(aS)) {
                    c(adTemplate, "h5_url", aS);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature N = com.kwad.sdk.core.response.b.a.N(el);
            int i7 = N.featureType;
            String str = N.materialUrl;
            if (i7 == 1) {
                if (bw.hA(str)) {
                    c(adTemplate, "video_url", str);
                    return;
                }
                return;
            }
            if (i7 == 2) {
                if (bw.hA(str)) {
                    c(adTemplate, "image_url", str);
                }
            } else if (i7 == 3) {
                long cp = com.kwad.sdk.core.response.b.a.cp(el);
                String bh = com.kwad.sdk.core.response.b.a.bh(el);
                if (cp == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(bh)) {
                    c(adTemplate, "live_stream_id", bh);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }

    public static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(d.be(adTemplate)).O("ad_sdk_ad_data_performance", "error_name").z(b.DW().cM(str).cN(str2).setAdTemplate(adTemplate)));
    }

    public static void a(@Nullable SceneImpl sceneImpl, long j6, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(d.ct(sceneImpl.getAdStyle())).O("ad_sdk_ad_parse_performance", "default").z(c.DX().cO(str).cP(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j6)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
