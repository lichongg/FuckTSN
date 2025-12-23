package com.kwad.sdk.commercial.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    private static void a(AdTemplate adTemplate, boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.1d).b(d.be(adTemplate)).O("ad_sdk_download_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bg(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(3).setAdTemplate(adTemplate));
    }

    public static void bh(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(4).setAdTemplate(adTemplate));
    }

    public static void bi(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(5).setAdTemplate(adTemplate));
    }

    public static void bj(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void bk(AdTemplate adTemplate) {
        int i6;
        b cv = b.DT().cv(7);
        if (adTemplate.mInstallApkFormUser) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        a(adTemplate, cv.cw(i6).setAdTemplate(adTemplate));
    }

    public static void bl(AdTemplate adTemplate) {
        int i6;
        b cv = b.DT().cv(8);
        int i7 = 2;
        if (adTemplate.mInstallApkFormUser) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        b cw = cv.cw(i6);
        if (adTemplate.mInstallApkFromSDK) {
            i7 = 1;
        } else if (!adTemplate.mClickOpenAppStore) {
            i7 = 0;
        }
        a(adTemplate, cw.cx(i7).setAdTemplate(adTemplate));
    }

    public static void bm(AdTemplate adTemplate) {
        int i6;
        b cv = b.DT().cv(10);
        if (adTemplate.mInstallApkFromSDK) {
            i6 = 1;
        } else if (adTemplate.mClickOpenAppStore) {
            i6 = 2;
        } else {
            i6 = 0;
        }
        a(adTemplate, cv.cx(i6).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i6, String str) {
        a(adTemplate, true, b.DT().cv(6).setAdTemplate(adTemplate).setErrorCode(i6).setErrorMsg(str));
    }

    public static void i(AdTemplate adTemplate, int i6, String str) {
        int i7;
        b cv = b.DT().cv(9);
        if (adTemplate.mInstallApkFormUser) {
            i7 = 1;
        } else {
            i7 = 2;
        }
        a(adTemplate, true, cv.cw(i7).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    public static void k(AdTemplate adTemplate, long j6) {
        a(adTemplate, b.DT().cv(2).ar(j6).setAdTemplate(adTemplate));
    }

    public static void x(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(1).setAdTemplate(adTemplate));
    }
}
