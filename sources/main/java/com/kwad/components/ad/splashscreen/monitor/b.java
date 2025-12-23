package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    private static volatile b FT;

    public static void a(@NonNull AdTemplate adTemplate, int i6, long j6, long j7) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j6;
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i6).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j7).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i6, long j6, long j7) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i6).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j7).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setUrl(com.kwad.sdk.core.response.b.a.bc(el) ? com.kwad.sdk.core.response.b.a.K(el) : com.kwad.sdk.core.response.b.a.aU(el).materialUrl).setAdTemplate(adTemplate));
    }

    public static void c(boolean z5, int i6, String str, long j6) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(4).setType(z5 ? 2 : 1).setErrorCode(i6).setErrorMsg(str).setPosId(j6));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i6, String str) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setUrl(com.kwad.sdk.core.response.b.a.bc(el) ? com.kwad.sdk.core.response.b.a.K(el) : com.kwad.sdk.core.response.b.a.aU(el).materialUrl).setErrorCode(i6).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(el) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, long j6) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j6).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void f(long j6, long j7) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j7).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPosId(j6));
    }

    public static void k(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        while (true) {
            int i6 = 1;
            if (!it.hasNext()) {
                com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setMaterialTypes(arrayList3).setStatus(1).setPosId(adResultData.getPosId()));
                return;
            }
            AdTemplate next = it.next();
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.J(com.kwad.sdk.core.response.b.e.el(next))));
            arrayList2.add(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(next)));
            if (com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.el(next))) {
                i6 = 2;
            }
            arrayList3.add(Integer.valueOf(i6));
        }
    }

    public static b lZ() {
        if (FT == null) {
            synchronized (b.class) {
                try {
                    if (FT == null) {
                        FT = new b();
                    }
                } finally {
                }
            }
        }
        return FT;
    }

    public static void u(long j6) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(1).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPosId(j6));
    }

    public static void v(long j6) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(1).setPosId(j6));
    }

    public static void ai(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(4).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void aj(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(200).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void ak(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(201).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void al(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(204).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void am(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(205).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void an(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(206).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void ao(@NonNull AdTemplate adTemplate) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(207).setCreativeId(com.kwad.sdk.core.response.b.a.J(el));
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(creativeId.setType(i6).setAdTemplate(adTemplate));
    }

    public static void ap(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z5;
        int i6;
        AdMatrixInfo.SplashPlayCardTKInfo dv = com.kwad.sdk.core.response.b.b.dv(adTemplate);
        boolean z6 = true;
        if (TextUtils.isEmpty(dv.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z5 = true;
        } else {
            str = "";
            z5 = false;
        }
        if (dv.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i6 = dv.renderType;
        } else {
            i6 = -1;
            z6 = z5;
        }
        if (!z6) {
            return;
        }
        com.kwad.sdk.commercial.b.o(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i6).setAdTemplate(adTemplate));
    }

    public static void g(@NonNull AdTemplate adTemplate, long j6) {
        int i6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(5);
        if (bd) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        com.kwad.sdk.commercial.b.m(status.setType(i6).setCostTime(j6).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long dG;
        StyleTemplate c6 = c(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateId(c6.templateId).setTemplateVersionCode(c6.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            dG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            dG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(dG).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void f(@NonNull AdTemplate adTemplate, long j6) {
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(1).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setType(com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(adTemplate)) ? 2 : 1).setCostTime(j6).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i6, String str) {
        String K;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean bd = com.kwad.sdk.core.response.b.a.bd(el);
        SplashMonitorInfo type = new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setType(bd ? 2 : 1);
        if (bd) {
            K = com.kwad.sdk.core.response.b.a.aU(el).materialUrl;
        } else {
            K = com.kwad.sdk.core.response.b.a.K(el);
        }
        com.kwad.sdk.commercial.b.m(type.setUrl(K).setErrorCode(i6).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long dG;
        StyleTemplate c6 = c(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(c6.templateId).setTemplateVersionCode(c6.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setErrorMsg(str);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            dG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            dG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(errorMsg.setTkDefaultTimeout(dG).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull List<AdTemplate> list, long j6, long j7) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(it.next())));
        }
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j6).setCount(list.size()).setPosId(j7));
    }

    public static void b(int i6, String str, long j6) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3).setErrorCode(i6).setErrorMsg(str).setPosId(j6));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dG;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            dG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            dG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(dG).setAdTemplate(adTemplate));
    }

    public static void b(boolean z5, int i6, String str, long j6) {
        com.kwad.sdk.commercial.b.p(new SplashMonitorInfo().setStatus(4).setType(z5 ? 2 : 1).setErrorCode(i6).setErrorMsg(str).setPosId(j6));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j6, int i6, int i7) {
        String str;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(el)) {
            str = com.kwad.sdk.core.response.b.a.K(el);
        } else {
            str = com.kwad.sdk.core.response.b.a.aU(el).materialUrl;
        }
        File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(com.kwad.sdk.core.response.b.a.aZ(el));
        com.kwad.sdk.commercial.b.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setCostTime(j6).setCacheValidTime(el.adPreloadInfo.validityPeriod * 1000).setSize((cf == null || !cf.exists()) ? 0L : cf.length()).setUrl(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(el) ? 1 : 2).setType(i6).setRequestType(i7).setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate, int i6, int i7) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3001).setMaterialType(i6).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setUrl(com.kwad.sdk.core.response.b.a.aU(el).materialUrl).setShowType(i7).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dG;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            dG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            dG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(dG).setAdTemplate(adTemplate));
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dK(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k6 != null) {
            styleTemplate.templateId = k6.templateId;
            styleTemplate.templateMd5 = k6.templateMd5;
            styleTemplate.templateUrl = k6.templateUrl;
            styleTemplate.templateVersionCode = (int) k6.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void b(AdTemplate adTemplate, int i6, int i7, int i8, long j6, long j7) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3003).setMaterialType(i6).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setUrl(com.kwad.sdk.core.response.b.a.aU(el).materialUrl).setShowType(i7).setLoadType(i8).setCostTime(j6).setShowDurationMs(j7).setAdTemplate(adTemplate));
    }

    public static void a(long j6, List<String> list, List<Integer> list2) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setStatus(2).setPosId(j6));
    }

    public static void a(long j6, List<String> list, List<Integer> list2, int i6, int i7, int i8, int i9) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setUpdateType(i6).setClearCount(i7).setClearImageCount(i8).setClearVideoCount(i9).setStatus(3).setPosId(j6));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j6, long j7, long j8) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(2).setType(com.kwad.sdk.core.response.b.a.bd(el) ? 2 : 1).setCostTime(j6).setAddLoadTime(j7).setRequestLoadTime(j8).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j6, boolean z5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j6;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setViewSource(z5 ? 1 : 2).setLoadDataTime(elapsedRealtime).setType(com.kwad.sdk.core.response.b.a.bd(el) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, boolean z5, boolean z6, boolean z7) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(202).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setType(com.kwad.sdk.core.response.b.a.bd(el) ? 2 : 1).setRootVisible(z5).setParentVisible(z6).setHasUnbind(z7).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j6, boolean z5, boolean z6) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(203).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setLoadDataTime(SystemClock.elapsedRealtime() - j6).setRootVisible(z5).setParentVisible(z6).setType(com.kwad.sdk.core.response.b.a.bd(el) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, boolean z5) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z5 ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(com.kwad.sdk.core.response.b.e.el(adTemplate))).setErrorMsg(str).setViewSource(z5 ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dG;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate));
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            dG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            dG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(tkRenderType.setTkDefaultTimeout(dG).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i6, long j6, int i7, long j7, long j8, long j9, long j10, long j11) {
        long dG;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            dG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            dG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(dG).setSoSource(i6).setSoLoadTime(j6).setOfflineSource(i7).setOfflineLoadTime(j7).setTkFileLoadTime(j8).setTkInitTime(j9).setTkRenderTime(j10).setTkTotalTime(j11).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i6, int i7, int i8, long j6, long j7) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3002).setMaterialType(i6).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(el)).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setUrl(com.kwad.sdk.core.response.b.a.aU(el).materialUrl).setShowType(i7).setLoadType(i8).setCostTime(j6).setShowDurationMs(j7).setAdTemplate(adTemplate));
    }
}
