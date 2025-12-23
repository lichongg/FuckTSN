package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static List<c> avA = null;
    private static a avB = null;
    private static Map<String, com.kwad.sdk.commercial.c.c> avC = null;
    private static float avu = -1.0f;
    private static double avv = -1.0d;
    private static final AtomicBoolean avw = new AtomicBoolean();
    private static final AtomicBoolean avx = new AtomicBoolean();
    private static boolean avy;
    private static volatile boolean avz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @WorkerThread
        boolean CI();

        @WorkerThread
        boolean CJ();

        @WorkerThread
        JSONObject CK();

        String CL();

        @WorkerThread
        void j(String str, String str2, boolean z5);
    }

    public static synchronized void a(final a aVar, final boolean z5) {
        synchronized (b.class) {
            if (avy) {
                return;
            }
            avy = true;
            avB = aVar;
            h.execute(new bg() { // from class: com.kwad.sdk.commercial.b.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    try {
                        b.b(a.this, z5);
                        b.DQ();
                        b.avw.set(true);
                        b.ow();
                    } catch (Throwable th) {
                        b.avx.set(true);
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    Object obj = jSONArray.get(i6);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a6 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = avC.get(a6);
                        if (cVar2 != null) {
                            cVar2.awc = true;
                            cVar2.avZ = Double.parseDouble(str);
                        } else {
                            cVar.awc = true;
                            cVar.avZ = Double.parseDouble(str);
                            avC.put(a6, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static synchronized void d(c cVar) {
        synchronized (b.class) {
            try {
                if (com.kwad.framework.a.a.oz.booleanValue()) {
                    if (cVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                        com.kwad.sdk.core.d.c.e("KCLogReporter", "reportItem: " + cVar);
                    } else {
                        com.kwad.sdk.core.d.c.d("KCLogReporter", "reportItem: " + cVar);
                    }
                }
                if (avw.get()) {
                    b(cVar);
                } else {
                    if (!avx.get()) {
                        c(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_reward_check_result", "check_type").b(BusinessType.AD_REWARD).z(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.5d).O("ad_sdk_webview_track", "scene_id").b(BusinessType.AD_WEBVIEW).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DQ() {
        try {
            avC = new HashMap();
            JSONObject CK = avB.CK();
            if (CK == null) {
                return;
            }
            Iterator<String> keys = CK.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = CK.optJSONObject(next);
                if (optJSONObject != null) {
                    a(next, optJSONObject.optJSONArray("ratio"));
                    b(next, optJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void c(c cVar) {
        if (avA == null) {
            avA = new CopyOnWriteArrayList();
        }
        avA.add(cVar);
    }

    public static void e(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z5 ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.4
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_load", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_load", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_preload", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_preload", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_show", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_show", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.9
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_view_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_view_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.10
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_template_data_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_template_data_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void ow() {
        synchronized (b.class) {
            try {
                List<c> list = avA;
                if (list == null) {
                    return;
                }
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                avA.clear();
                avA = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void p(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_errorcode_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(com.kwad.sdk.commercial.c.a.this).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_errorcode_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).O("ad_video_load_perf", "video_load_perf").cG("ad_video_load_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void u(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).O("ad_video_load_failed", "video_load_failed").cG("ad_video_load_failed").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void v(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_sdk_aggregation_monitor", "ranger").cG("ad_sdk_aggregation_monitor").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).O("ad_sdk_reward_performance", "reward_type").b(BusinessType.AD_REWARD).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_reward_performance", "page_status").b(BusinessType.AD_REWARD).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_block_info", "block").a(com.kwai.adclient.kscommerciallogger.model.b.beS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_image_load_perf", "image_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_thread_monitor", "thread_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void w(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_wayne_player_vse_monitor", NotificationCompat.CATEGORY_STATUS).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void x(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_installer_info", NotificationCompat.CATEGORY_STATUS).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void y(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_uaid_data_performance", NotificationCompat.CATEGORY_STATUS).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z5) {
            str = "ad_sdk_reward_page_show";
        } else {
            str = "ad_sdk_fullscreen_page_show";
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(str, "page_status").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bep));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    Object obj = jSONArray.get(i6);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a6 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = avC.get(a6);
                        if (cVar2 != null) {
                            cVar2.awb = true;
                            cVar2.avY = Double.parseDouble(str);
                        } else {
                            cVar.awb = true;
                            cVar.avY = Double.parseDouble(str);
                            avC.put(a6, cVar);
                        }
                    }
                }
            } catch (JSONException e6) {
                ServiceProvider.reportSdkCaughtException(e6);
            }
        }
    }

    public static void f(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z5) {
            str = "ad_sdk_reward_play_error";
        } else {
            str = "ad_sdk_fullscreen_play_error";
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(str, "reward_type").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(final boolean z5, final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    double d6;
                    c cF = c.DS().cF(ILoggerReporter.Category.APM_LOG);
                    if (z5) {
                        d6 = 1.0d;
                    } else {
                        d6 = 0.01d;
                    }
                    b.d(cF.i(d6).O("ad_sdk_splash_single_cache", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z5 ? 1.0d : 0.01d).O("ad_sdk_splash_single_cache", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z5) {
            str = "ad_sdk_reward_callback_interaction";
        } else {
            str = "ad_sdk_fullscreen_callback_interaction";
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(str, "callback_type").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(c cVar) {
        c.a To;
        if (avz) {
            com.kwad.sdk.commercial.c.b a6 = a(cVar);
            if (avu == -1.0f) {
                avu = new Random().nextFloat();
            }
            if (avv == -1.0d) {
                avv = new Random().nextFloat();
            }
            if ((avB.CJ() || avu <= a6.avY) && bx.aA(BuildConfig.VERSION_NAME, a6.awa)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(cVar.category, cVar))) {
                        To = c.a.Tn();
                    } else {
                        To = c.a.To();
                    }
                    com.kwai.adclient.kscommerciallogger.a.Te().a(To.c(cVar.avK).b(cVar.avL).hN(TextUtils.isEmpty(cVar.tag) ? cVar.eventId : cVar.tag).b(cVar.avM).hO(cVar.eventId).A(a(cVar.msg, a6)).Tp());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    public static void c(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(str).i(0.001d).O("ad_sdk_local_warmup", "warm_up").b(BusinessType.OTHER).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int lastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && lastIndexOf != -1) {
                bVar.awa = str.substring(lastIndexOf + 1);
                return str.substring(0, lastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static void g(JSONObject jSONObject) {
        String str;
        try {
            int optInt = jSONObject.optInt("load_status");
            if (optInt != 3 && optInt != 4 && optInt != 7) {
                str = ILoggerReporter.Category.APM_LOG;
                d(c.DS().cF(str).i(1.0d).j(0.1d).k(0.001d).O("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.bez).h(jSONObject));
            }
            str = ILoggerReporter.Category.ERROR_LOG;
            d(c.DS().cF(str).i(1.0d).j(0.1d).k(0.001d).O("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.bez).h(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @NonNull
    private static com.kwad.sdk.commercial.c.b a(c cVar) {
        double d6;
        double d7;
        String str;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.c cVar3;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            Boolean bool = com.kwad.framework.a.a.oz;
            if (bool.booleanValue()) {
                bVar.avY = cVar.avI;
            } else {
                bVar.avY = cVar.avH;
            }
            bVar.avZ = cVar.avJ;
            if (!avC.containsKey(cVar.eventId) || (cVar3 = avC.get(cVar.eventId)) == null) {
                d6 = -1.0d;
                d7 = -1.0d;
            } else {
                d6 = cVar3.awb ? cVar3.avY : -1.0d;
                d7 = cVar3.awc ? cVar3.avZ : -1.0d;
                if (!TextUtils.isEmpty(cVar3.awa)) {
                    bVar.awa = cVar3.awa;
                }
            }
            if (TextUtils.isEmpty(cVar.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = cVar.eventId;
            if (!TextUtils.isEmpty(cVar.primaryKey)) {
                if (cVar.msg.has(cVar.primaryKey)) {
                    str = str2 + "_" + cVar.msg.opt(cVar.primaryKey);
                } else {
                    str = str2 + "_" + cVar.primaryKey;
                }
                if (avC.containsKey(str) && (cVar2 = avC.get(str)) != null) {
                    if (cVar2.awb) {
                        d6 = cVar2.avY;
                    }
                    if (cVar2.awc) {
                        d7 = cVar2.avZ;
                    }
                    if (!TextUtils.isEmpty(cVar2.awa)) {
                        bVar.awa = cVar2.awa;
                    }
                }
            }
            if (d6 != -1.0d) {
                bVar.avY = d6;
            }
            if (d7 != -1.0d) {
                bVar.avZ = d7;
            } else {
                bVar.avZ = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BK();
            }
            cVar.avH = bVar.avY;
            cVar.avJ = bVar.avZ;
            return bVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z5) {
        boolean CI = aVar.CI();
        avz = CI;
        if (CI) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "publish_type", 0);
            aa.putValue(jSONObject, "plug_sdk", z5 ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a Te = com.kwai.adclient.kscommerciallogger.a.Te();
            com.kwad.sdk.commercial.a aVar2 = new com.kwad.sdk.commercial.a();
            com.kwai.adclient.kscommerciallogger.a.b bVar = new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.b.3
                private void N(String str, String str2) {
                    a.this.j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void M(@NonNull String str, @NonNull String str2) {
                    N(str, str2);
                }
            };
            Boolean bool = com.kwad.framework.a.a.oz;
            Te.a(aVar2, bVar, jSONObject, bool.booleanValue(), bool.booleanValue());
            com.kwad.sdk.commercial.h.a.Ea().cS(aVar.CL());
        }
    }

    public static void b(boolean z5, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z5) {
            str = "ad_sdk_reward_download_error";
        } else {
            str = "ad_sdk_fullscreen_download_error";
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(str, "download_type").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beM));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.DS().cF(str).i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).O("union_web_cache_load_event", "state").b(BusinessType.WEB_CACHE).z(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(String str, c cVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || avv >= cVar.avJ) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        String str2;
        try {
            if (ILoggerReporter.Category.ERROR_LOG.equals(str)) {
                str2 = "ad_sdk_init_error_performance";
            } else {
                str2 = "ad_sdk_init_performance";
            }
            d(c.DS().cF(str).i(0.001d).O(str2, "init_status").b(BusinessType.AD_SDK_INIT).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).O("ad_perf_monitor_net_success", "network_monitor").z(jVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z5, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        String str;
        if (z5) {
            str = "ad_sdk_reward_load";
        } else {
            str = "ad_sdk_fullscreen_load";
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(str, "load_status").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(i iVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_perf_monitor_net_error", "network_monitor").z(iVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_union_kv_fail_rate", "kv").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z5, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(str, "reward_type").b(z5 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(str).i(0.001d).O("ad_sdk_resource_warmup", "warm_up").b(BusinessType.OTHER).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.DS().cF(str).i(1.0E-4d).O("union_web_cache_download_event", "state").b(BusinessType.WEB_CACHE).z(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(c.DS().cF(str).i(1.0d).O("union_webview_load_event", "state").z(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d6 = webViewCommercialMsg.rate;
            if (d6 >= 0.0d) {
                aa.putValue(webViewCommercialMsg.msg, "ratio", d6);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(c.DS().cF(str).i(webViewCommercialMsg.rate).O(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).b(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).h(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            aa.putValue(jSONObject, "ratio", bVar.avY);
            double d6 = bVar.avY;
            if (d6 > 0.0d) {
                aa.putValue(jSONObject, "ratio_count", a(1.0d, d6, 0));
            }
            aa.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.oz.booleanValue() ? 1 : 0);
            aa.putValue(jSONObject, "convert_ratio", bVar.avZ);
            double d7 = bVar.avZ;
            if (d7 > 0.0d) {
                aa.putValue(jSONObject, "convert_ratio_count", a(1.0d, d7, 0));
            }
            return jSONObject;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return jSONObject;
        }
    }

    private static double a(double d6, double d7, int i6) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d7)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
