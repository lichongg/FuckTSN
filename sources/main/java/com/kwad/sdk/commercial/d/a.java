package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).b(com.kwad.sdk.commercial.d.be(adTemplate)).O("ad_convert_method_call", "method_name").z(aVar));
    }

    public static void bA(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownloadPage"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bB(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownloadPause"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bC(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownloadResume"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bD(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownloadNoNet"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bE(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDoNoting"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bF(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toOpenAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bG(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toOpenDeeplinkDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bH(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toH5PageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bI(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toMiddlePageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bJ(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toSmallAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bo(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("adClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bp(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("startH5Page"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bq(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("dplinkStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void br(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("smallAppSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bs(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("appstoreStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bt(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("disableClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bu(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toVideoH5Web"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bv(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownload"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bw(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toOpenApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bx(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toInstallApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void by(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownloadDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bz(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("toDownloadThirdDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(AdTemplate adTemplate, boolean z5) {
        try {
            a(adTemplate, b.DV().cJ("adUserClick").bn(z5));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
