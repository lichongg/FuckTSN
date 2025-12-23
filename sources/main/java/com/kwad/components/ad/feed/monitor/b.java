package com.kwad.components.ad.feed.monitor;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.aa;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static void a(AdTemplate adTemplate, int i6, int i7, String str, String str2, long j6) {
        if (i7 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i7 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        b(new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i6).setResourceLoadDuration(j6).setMaterialType(i7).setMaterialUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate), i6 == 2);
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar, boolean z5) {
        try {
            com.kwad.sdk.commercial.b.d(c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 0.01d : 0.001d).O("ad_sdk_feed_load", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_FEED).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("reportFeedPageLineLog", e6.toString());
        }
    }

    public static void c(AdTemplate adTemplate, int i6, int i7) {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "feedLoadOptimizeType", e.EQ());
        aa.putValue(jSONObject, "feedLoadOptimizeExternalEnable", e.ET());
        aa.putValue(jSONObject, "isExternal", l.Cf().Bk());
        a(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setLoadType(adTemplate.loadType).setMaterialType(com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.el(adTemplate))).setRenderType(i6).setExpectedRenderType(i7).setAbParams(jSONObject.toString()).setAdTemplate(adTemplate));
    }

    public static void B(int i6) {
        a(new FeedPageInfo().setStatus(1).setAdNum(i6));
    }

    public static void C(int i6) {
        a(new FeedPageInfo().setStatus(2).setAdNum(i6));
    }

    public static void ch() {
        a("ad_sdk_feed_adnum_monitor", new FeedErrorInfo(), 1.0E-4d);
    }

    public static void ci() {
        com.kwad.sdk.commercial.b.g(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed"));
    }

    public static void e(int i6, String str) {
        b(new FeedPageInfo().setStatus(9).setErrorCode(i6).setErrorMsg(str), true);
    }

    public static void f(int i6, String str) {
        b(new FeedPageInfo().setStatus(10).setLoadStatus(i6).setErrorMsg(str), i6 == 2);
    }

    public static void g(int i6, String str) {
        a("ad_sdk_feed_request_monitor", (FeedErrorInfo) new FeedErrorInfo().setErrorCode(i6).setErrorMsg(str), 1.0d);
    }

    public static void n(AdTemplate adTemplate) {
        a(new FeedPageInfo().setStatus(11).setAdTemplate(adTemplate));
    }

    public static void o(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.g(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").setAdTemplate(adTemplate));
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_feed_callback", "callback_type").b(BusinessType.AD_FEED).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.e("reportFeedCallback", e6.toString());
        }
    }

    public static void a(AdTemplate adTemplate, int i6, int i7, long j6, String str) {
        b(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.el(adTemplate))).setRenderType(i6).setLoadType(adTemplate.loadType).setExpectedRenderType(i7).setErrorMsg(str).setRenderDuration(j6).setAdTemplate(adTemplate), (i6 == 2 || i6 == 3) ? false : true);
    }

    private static List<FeedPageInfo.a> c(List<KsFeedAd> list) {
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            if (ksFeedAd instanceof com.kwad.components.ad.feed.c) {
                AdInfo el = com.kwad.sdk.core.response.b.e.el(((com.kwad.components.ad.feed.c) ksFeedAd).getAdTemplate());
                arrayList.add(new FeedPageInfo.a().i(com.kwad.sdk.core.response.b.a.J(el)).D(com.kwad.sdk.core.response.b.a.be(el)).t(com.kwad.sdk.core.response.b.a.bb(el)));
            }
        }
        return arrayList;
    }

    public static void b(int i6, int i7, AdTemplate adTemplate) {
        a("ad_sdk_feed_showType_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i6).setFeedType(i7).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(int i6, long j6) {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "feedLoadOptimizeType", e.EQ());
        aa.putValue(jSONObject, "feedLoadOptimizeExternalEnable", e.ET());
        aa.putValue(jSONObject, "isExternal", l.Cf().Bk());
        a(new FeedPageInfo().setStatus(6).setAdNum(i6).setLoadDataDuration(j6).setAbParams(jSONObject.toString()));
    }

    public static void a(AdTemplate adTemplate, int i6, long j6) {
        a(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.el(adTemplate))).setRenderType(i6).setConvertDuration(j6).setAdTemplate(adTemplate));
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar) {
        b(aVar, false);
    }

    public static void a(int i6, AdTemplate adTemplate, String str, int i7) {
        b(new FeedPageInfo().setCallbackType(i6).setMaterialType(com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.el(adTemplate))).setMaterialUrl(str).setRenderType(i7).setAdTemplate(adTemplate));
    }

    public static void a(long j6, List<KsFeedAd> list) {
        if (list == null || list.size() == 0 || !(list.get(0) instanceof com.kwad.components.ad.feed.c)) {
            return;
        }
        b(new FeedPageInfo().setCallbackType(1).setPosId(j6).setMaterialInfoList(c(list)).setAdTemplate(((com.kwad.components.ad.feed.c) list.get(0)).getAdTemplate()));
    }

    private static void a(String str, FeedErrorInfo feedErrorInfo, double d6) {
        try {
            com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).b(BusinessType.AD_FEED).O(str, "default").cG(str).a(com.kwai.adclient.kscommerciallogger.model.a.bez).z(feedErrorInfo).i(d6));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.d("reportFeedError", e6.toString());
        }
    }

    public static void a(long j6, int i6, int i7, AdTemplate adTemplate) {
        a("ad_sdk_feed_width_monitor", (FeedErrorInfo) new FeedErrorInfo().setWidth(j6).setMaterialType(i6).setFeedType(i7).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(int i6, int i7, AdTemplate adTemplate, int i8) {
        a("ad_sdk_feed_h5_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i7).setErrorType(i8).setErrorCode(i6).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.g(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j6, int i6) {
        com.kwad.sdk.commercial.b.g(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i6).setDurationMs(j6).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j6) {
        com.kwad.sdk.commercial.b.g(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j6).setUrl(str).setAdTemplate(adTemplate));
    }
}
