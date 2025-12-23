package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static C0673a awv;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a, reason: collision with other inner class name */
    public static class C0673a extends com.kwad.sdk.core.response.a.a {
        public List<String> aww;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static C0673a Ed() {
        String BS = ((h) ServiceProvider.get(h.class)).BS();
        if (!TextUtils.isEmpty(BS)) {
            awv = (C0673a) aa.b(BS, new c<C0673a>() { // from class: com.kwad.sdk.commercial.j.a.1
                private static C0673a Ee() {
                    return new C0673a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ C0673a Ef() {
                    return Ee();
                }
            });
        }
        return awv;
    }

    private static void a(AdTemplate adTemplate, boolean z5, b bVar) {
        if (da(bVar.awp)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z5 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.001d).b(d.be(adTemplate)).O("ad_sdk_track_performance", NotificationCompat.CATEGORY_STATUS).z(bVar));
    }

    private static boolean da(String str) {
        C0673a Ed;
        List<String> list;
        if (TextUtils.isEmpty(str) || (Ed = Ed()) == null || (list = Ed.aww) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void n(AdTemplate adTemplate, int i6, String str) {
        try {
            a(adTemplate, b.Eg().cG(4).cH(i6).db(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i6, String str) {
        try {
            a(adTemplate, b.Eg().cG(1).cH(i6).db(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).b(d.be(adTemplate)).O("ad_sdk_macro_check_performance", "error_name").z(com.kwad.sdk.commercial.i.a.Ec().cT(str).cV(str2).cW(str3).cU(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i6, String str, int i7, int i8) {
        try {
            a(adTemplate, b.Eg().cG(2).cH(i6).db(str).cI(i8).setErrorCode(i7).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i6, String str, String str2, int i7, String str3, int i8) {
        try {
            a(adTemplate, true, b.Eg().cG(3).cH(i6).db(str).dc(str2).setErrorCode(i7).setErrorMsg(str3).cI(i8).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
