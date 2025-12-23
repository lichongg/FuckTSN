package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.internal.ViewUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static ExecutorService axm = GlobalThreadPools.Js();
    public static JSONObject axn;
    public static boolean axo;

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.cj(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void bR(AdTemplate adTemplate) {
        q(adTemplate, 4);
    }

    public static void bX(@Nullable AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void bY(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        axm.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.C0675a c0675a = new a.C0675a();
                c0675a.awZ = AdTemplate.this.downLoadType;
                com.kwad.sdk.core.adlog.c.b dg = new com.kwad.sdk.core.adlog.c.b().b(c0675a).dg(AdTemplate.this.downloadSource);
                c.a(AdTemplate.this, dg);
                c.a(AdTemplate.this, 31, dg.EM(), jSONObject);
                AdInfo el = e.el(AdTemplate.this);
                as.av(el.downloadFilePath, el.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0675a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        axm.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = e.el(AdTemplate.this);
                int aw = as.aw(el.downloadId, com.kwad.sdk.core.response.b.a.ay(el));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.downloadSource = adTemplate2.downloadSource;
                aVar.aya = aw;
                aVar.ayb = adTemplate2.installFrom;
                aVar.a(new a.C0675a());
                a.C0675a c0675a = aVar.Pk;
                AdTemplate adTemplate3 = AdTemplate.this;
                c0675a.awZ = adTemplate3.downLoadType;
                c.a(adTemplate3, 32, aVar, jSONObject);
            }
        });
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i6) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i6 == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayr = i6;
        aVar.a(new a.C0675a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.Pl = i6;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, aVar, (JSONObject) null);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axZ = i6;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i6) {
        h(adTemplate, i6, 0);
    }

    public static void l(@Nullable AdTemplate adTemplate, long j6) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.EK().av(j6), (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axJ = i6;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i6) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayf = com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate));
        a(adTemplate, i6, aVar, new JSONObject());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i6, String str) {
            this.code = i6;
            this.msg = str;
        }
    }

    private static boolean G(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(adInfo);
        if (TextUtils.isEmpty(ay)) {
            return false;
        }
        return as.ap(fVar.getContext(), ay);
    }

    public static boolean b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo el = e.el(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dr(Ey());
        com.kwad.sdk.core.adlog.c.a EM = bVar.EM();
        if (adTemplate.fromCache) {
            EM.a(h.cj(adTemplate));
        }
        EM.aym = G(el) ? 1 : 0;
        return a(adTemplate, 1, EM, jSONObject);
    }

    public static void bS(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new a.C0675a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void bT(AdTemplate adTemplate) {
        q(adTemplate, 36);
    }

    public static void bU(AdTemplate adTemplate) {
        q(adTemplate, 38);
    }

    public static void bV(AdTemplate adTemplate) {
        q(adTemplate, 41);
    }

    public static void bW(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayf = com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate));
        a(adTemplate, ViewUtils.EDGE_TO_EDGE_FLAGS, aVar, new JSONObject());
    }

    public static void bZ(@Nullable AdTemplate adTemplate) {
        q(adTemplate, 58);
    }

    public static void c(@Nullable AdTemplate adTemplate, String str, int i6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axX = i6;
        if (!str.equals("")) {
            aVar.axY = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, aVar, (JSONObject) null);
    }

    public static void ca(AdTemplate adTemplate) {
        q(adTemplate, 914);
    }

    public static void cb(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bA(e.el(adTemplate));
        com.kwad.sdk.core.d.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, aVar, (JSONObject) null);
    }

    public static void cc(AdTemplate adTemplate) {
        q(adTemplate, 722);
    }

    public static void cd(AdTemplate adTemplate) {
        q(adTemplate, 721);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a EM = bVar.EM();
        EM.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, EM, jSONObject);
    }

    public static void f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, boolean z5) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0675a c0675a = new a.C0675a();
        if (z5) {
            c0675a.axd = 1;
        } else {
            c0675a.axd = 2;
        }
        aVar.a(c0675a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 451, jSONObject);
    }

    public static void o(AdTemplate adTemplate, int i6) {
        a(adTemplate, i6, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i6) {
        e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(i6));
    }

    private static void q(AdTemplate adTemplate, int i6) {
        a(adTemplate, i6, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    private static int Ey() {
        if (aq.isOrientationPortrait()) {
            return 2;
        }
        return 1;
    }

    private static boolean ce(AdTemplate adTemplate) {
        if (e.ed(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null && fVar.aR(adTemplate)) {
            return true;
        }
        return false;
    }

    public static void l(AdTemplate adTemplate, int i6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axK = i6;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 450, jSONObject);
    }

    public static void m(AdTemplate adTemplate, long j6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axO = j6;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i6, int i7) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axM = 69;
        aVar.ayh = i6;
        aVar.ayi = i7;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z5) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0675a c0675a = new a.C0675a();
        c0675a.axa = 2;
        bVar.b(c0675a);
        if (z5) {
            bVar.dm(33);
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.EM(), (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, long j6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayk = j6;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i6, @Nullable aj.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.mI = i6;
        int i7 = adTemplate.swipeAngle;
        if (i7 != 0) {
            aVar2.ayv = i7;
        }
        if (aVar != null) {
            aVar2.mK = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a EM = bVar.EM();
        EM.e(adTemplate, null, null);
        a(adTemplate, 140, EM, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, 451, bVar != null ? bVar.EM() : null, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axL = 1;
        a.C0675a c0675a = new a.C0675a();
        aVar.Pk = c0675a;
        c0675a.templateId = "101";
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i6, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayf = com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate));
        aVar.axM = 93;
        a(adTemplate, 140, aVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i6, JSONObject jSONObject) {
        a(adTemplate, i6, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static void i(AdTemplate adTemplate, boolean z5) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0675a c0675a = new a.C0675a();
        c0675a.axa = 1;
        bVar.b(c0675a);
        if (z5) {
            bVar.dm(33);
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.EM(), (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.EM() : null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, @Nullable JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.EM() : null, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate, int i6, int i7) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayl = i6;
        aVar.Pm = i7;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, long j6, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0675a c0675a = new a.C0675a();
        if (j6 != -1) {
            c0675a.duration = j6;
            aVar.Pk = c0675a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0675a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate, boolean z5) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0675a c0675a = new a.C0675a();
        if (z5) {
            c0675a.axd = 1;
        } else {
            c0675a.axd = 2;
        }
        aVar.a(c0675a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i6, long j6, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axL = i6;
        a.C0675a c0675a = new a.C0675a();
        c0675a.duration = j6;
        aVar.Pk = c0675a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i6, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.axX = i6;
        if (!str.equals("")) {
            aVar.axY = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i6, long j6, int i7, long j7, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.yU = j6;
        aVar.ayo = i7;
        aVar.axL = i6;
        a.C0675a c0675a = new a.C0675a();
        c0675a.duration = j7;
        aVar.Pk = c0675a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i6, @Nullable JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().df(i6));
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0675a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo el = e.el(adTemplate);
        String str = el.downloadFilePath;
        if (str == null) {
            return;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(el);
        String hf = as.hf(str);
        if (hf == null || TextUtils.isEmpty(hf) || hf.equals(ay)) {
            return;
        }
        bVar.du(hf);
        bVar.dt(ay);
        el.adBaseInfo.appPackageName = hf;
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.ayc = aVar.toJson().toString();
        aVar2.a(new a.C0675a());
        aVar2.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i6, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.axX = i6;
        if (!str.equals("")) {
            aVar.axY = str;
        }
        a(adTemplate, 320, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j6) {
        aVar.ayj = j6;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i6, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axJ = i6;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i6, AdExposureFailedReason adExposureFailedReason) {
        if (i6 == 0 || i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5 || i6 == -9999 || i6 == 6) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.axP = i6;
            if (adExposureFailedReason != null) {
                aVar.axQ = adExposureFailedReason.winEcpm;
                try {
                    int i7 = adExposureFailedReason.adnType;
                    aVar.adnType = i7;
                    if (i7 == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.axR = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.axS = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.axT = adExposureFailedReason.adRequestId;
                    }
                    aVar.axU = adExposureFailedReason.isShow;
                    aVar.axV = adExposureFailedReason.isClick;
                    aVar.adnMaterialType = adExposureFailedReason.adnMaterialType;
                    aVar.adnMaterialUrl = adExposureFailedReason.adnMaterialUrl;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i6, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.Pj = str;
        a(adTemplate, i6, aVar, jSONObject);
    }

    public static boolean a(@Nullable AdTemplate adTemplate, int i6, @Nullable com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !ce(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.ayn = com.kwad.sdk.core.response.b.a.aT(e.el(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i6 == 2 && axo) {
            if (aVar.Pk == null) {
                aVar.Pk = new a.C0675a();
            }
            aVar.Pk.axg = axn;
        }
        if (i6 == 1 && e.ef(adTemplate) == 4 && com.kwad.sdk.core.response.b.a.du(e.el(adTemplate))) {
            if (aVar.Pk == null) {
                aVar.Pk = new a.C0675a();
            }
            aVar.Pk.axf = com.kwad.sdk.core.response.b.a.dv(e.el(adTemplate));
        }
        aVar.adTemplate = adTemplate;
        aVar.awx = i6;
        aVar.axI = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        com.kwad.sdk.core.d.c.d("AdReportManager", sb.toString());
        b.a(aVar);
        return true;
    }
}
