package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bp;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int awS;

    @NonNull
    private final com.kwad.sdk.core.adlog.c.a awT;
    private final AdTemplate mAdTemplate;

    private void a(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i6 = aVar.ayp;
        if (i6 >= 0) {
            putBody("adOrder", i6);
        }
        int i7 = aVar.Pi;
        if (i7 >= 0) {
            putBody("adInterstitialSource", i7);
        }
        if (!TextUtils.isEmpty(aVar.axN)) {
            putBody("adRenderArea", aVar.axN);
        }
        putBody("adxResult", aVar.adxResult);
        int i8 = aVar.ayt;
        if (i8 != 0) {
            putBody("fingerSwipeType", i8);
        }
        int i9 = aVar.ayu;
        if (i9 != 0) {
            putBody("fingerSwipeDistance", i9);
        }
        int i10 = aVar.aym;
        if (i10 != -1) {
            putBody("installStatus", i10);
        }
        C0675a c0675a = aVar.Pk;
        if (c0675a != null) {
            putBody("clientExtData", c0675a.toJson().toString());
        }
        String str2 = aVar.ayx;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i11 = aVar.Pm;
        if (i11 != -1) {
            putBody("triggerType", i11);
        }
        int i12 = aVar.Pl;
        if (i12 != 0) {
            putBody("photoSizeStyle", i12);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    public static class C0675a extends com.kwad.sdk.core.response.a.a {
        public int awU;
        public String awV;
        public String awW;
        public String awY;
        public int awZ;
        public int axa;
        public int axb;
        public int axc;
        public int axd;
        public boolean axe;
        public String axf;
        public JSONObject axg;
        public int axi;
        public int axj;

        @Nullable
        public AdTrackLog axk;
        public String templateId;
        public int awX = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int axh = 0;
        public int showLiveStyle = -1;

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.BP()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.axk = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.axk);
            }
            return this.axk;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i6 = this.awX;
            if (i6 != -1) {
                aa.putValue(jSONObject, "shield_reason", i6);
            }
            long j6 = this.duration;
            if (j6 != -1) {
                aa.putValue(jSONObject, "duration", j6);
            }
            int i7 = this.showLiveStatus;
            if (i7 != -1) {
                aa.putValue(jSONObject, "show_live_status", i7);
            }
            int i8 = this.showLiveStyle;
            if (i8 != -1) {
                aa.putValue(jSONObject, "show_live_style", i8);
            }
            AdTrackLog adTrackLog = this.axk;
            if (adTrackLog != null) {
                aa.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.axg;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.axg.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void Ew() {
        JSONObject jSONObject = this.awT.axI;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        aa.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void b(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i6 = aVar.mI;
        if (i6 != 0) {
            putBody("itemClickType", i6);
        }
        if (!TextUtils.isEmpty(aVar.Pj)) {
            putBody("payload", aVar.Pj);
        }
        int i7 = aVar.aye;
        if (i7 != 0) {
            putBody("adAggPageSource", i7);
        }
        int i8 = aVar.ayp;
        if (i8 >= 0) {
            putBody("adOrder", i8);
        }
        int i9 = aVar.Pi;
        if (i9 >= 0) {
            putBody("adInterstitialSource", i9);
        }
        int i10 = aVar.Pm;
        if (i10 != -1) {
            putBody("triggerType", i10);
        }
        int i11 = aVar.ayw;
        if (i11 != 0) {
            putBody("cardCloseType", i11);
        }
        putBody("adxResult", aVar.adxResult);
        double d6 = aVar.mL;
        if (d6 > 0.0d) {
            putBody("splashShakeAcceleration", d6);
        }
        if (!TextUtils.isEmpty(aVar.ayq)) {
            putBody("splashInteractionRotateAngle", aVar.ayq);
        }
        int i12 = aVar.ayt;
        if (i12 != 0) {
            putBody("fingerSwipeType", i12);
        }
        int i13 = aVar.ayu;
        if (i13 != 0) {
            putBody("fingerSwipeDistance", i13);
        }
        long j6 = aVar.yU;
        if (j6 > 0) {
            putBody("playedDuration", j6);
        }
        int i14 = aVar.ayo;
        if (i14 > 0) {
            putBody("playedRate", i14);
        }
        String str2 = aVar.ayx;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i15 = aVar.axW;
        if (i15 != -1) {
            putBody("retainCodeType", i15);
        }
        C0675a c0675a = aVar.Pk;
        if (c0675a != null) {
            putBody("clientExtData", c0675a.toJson().toString());
        }
        int i16 = aVar.ayv;
        if (i16 != 0) {
            putBody("finger_swiper_angle", i16);
        }
        int i17 = aVar.Pl;
        if (i17 != 0) {
            putBody("photoSizeStyle", i17);
        }
    }

    private void c(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i6 = aVar.axL;
        if (i6 != 0) {
            putBody("itemCloseType", i6);
        }
        int i7 = aVar.axJ;
        if (i7 > 0) {
            putBody("photoPlaySecond", i7);
        }
        int i8 = aVar.axK;
        if (i8 != 0) {
            putBody("awardReceiveStage", i8);
        }
        int i9 = aVar.axM;
        if (i9 != 0) {
            putBody("elementType", i9);
        }
        if (!TextUtils.isEmpty(aVar.Pj)) {
            putBody("payload", aVar.Pj);
        }
        C0675a c0675a = aVar.Pk;
        if (c0675a != null) {
            putBody("clientExtData", c0675a.toJson().toString());
        }
        int i10 = aVar.axX;
        if (i10 > 0) {
            putBody("deeplinkType", i10);
        }
        if (!TextUtils.isEmpty(aVar.axY)) {
            putBody("deeplinkAppName", aVar.axY);
        }
        int i11 = aVar.axZ;
        if (i11 != 0) {
            putBody("deeplinkFailedReason", i11);
        }
        int i12 = aVar.downloadSource;
        if (i12 > 0) {
            putBody("downloadSource", i12);
        }
        int i13 = aVar.ayw;
        if (i13 != 0) {
            putBody("cardCloseType", i13);
        }
        int i14 = aVar.aya;
        if (i14 > 0) {
            putBody("isPackageChanged", i14);
        }
        putBody("installedFrom", aVar.ayb);
        putBody("isChangedEndcard", aVar.ayd);
        int i15 = aVar.aye;
        if (i15 != 0) {
            putBody("adAggPageSource", i15);
        }
        String str2 = aVar.ayc;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!bp.isNullString(aVar.ayg)) {
            putBody("installedPackageName", aVar.ayg);
        }
        if (!bp.isNullString(aVar.ayf)) {
            putBody("serverPackageName", aVar.ayf);
        }
        int i16 = aVar.ayi;
        if (i16 > 0) {
            putBody("closeButtonClickTime", i16);
        }
        int i17 = aVar.ayh;
        if (i17 > 0) {
            putBody("closeButtonImpressionTime", i17);
        }
        int i18 = aVar.downloadStatus;
        if (i18 >= 0) {
            putBody("downloadStatus", i18);
        }
        long j6 = aVar.ayj;
        if (j6 > 0) {
            putBody("landingPageLoadedDuration", j6);
        }
        long j7 = aVar.PL;
        if (j7 > 0) {
            putBody("leaveTime", j7);
        }
        long j8 = aVar.ayk;
        if (j8 > 0) {
            putBody("adItemClickBackDuration", j8);
        }
        int i19 = aVar.axW;
        if (i19 != -1) {
            putBody("retainCodeType", i19);
        }
        long j9 = aVar.axO;
        if (j9 > -1) {
            putBody("highestLossPrice", j9);
        }
        int i20 = aVar.axP;
        if (i20 >= 0 || i20 == -9999) {
            putBody("impFailReason", i20);
        }
        long j10 = aVar.axQ;
        if (j10 > -1 || j10 == -9999) {
            putBody("winEcpm", j10);
        }
        int i21 = aVar.adnType;
        if (i21 > 0 || i21 == -9999) {
            putBody("adnType", i21);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.axR)) {
            putBody("adnAdvertiser", aVar.axR);
        }
        if (!TextUtils.isEmpty(aVar.axS)) {
            putBody("adnTitle", aVar.axS);
        }
        if (!TextUtils.isEmpty(aVar.axT)) {
            putBody("adnRequestId", aVar.axT);
        }
        putBody("adnShowType", aVar.axU);
        putBody("adnClickType", aVar.axV);
        putBody("adnMaterialType", aVar.adnMaterialType);
        if (!TextUtils.isEmpty(aVar.adnMaterialUrl)) {
            putBody("adnMaterialUrl", aVar.adnMaterialUrl);
        }
        putBody("downloadCardType", aVar.ayn);
        putBody("landingPageType", aVar.To);
        int i22 = aVar.Pi;
        if (i22 >= 0) {
            putBody("adInterstitialSource", i22);
        }
        int i23 = aVar.ayr;
        if (i23 > 0) {
            putBody("downloadInstallType", i23);
        }
        int i24 = aVar.ayt;
        if (i24 != 0) {
            putBody("fingerSwipeType", i24);
        }
        int i25 = aVar.ayu;
        if (i25 != 0) {
            putBody("fingerSwipeDistance", i25);
        }
        int i26 = aVar.ays;
        if (i26 > 0) {
            putBody("businessSceneType", i26);
        }
        long j11 = aVar.yU;
        if (j11 > 0) {
            putBody("playedDuration", j11);
        }
        int i27 = aVar.ayo;
        if (i27 > 0) {
            putBody("playedRate", i27);
        }
        int i28 = aVar.ayl;
        if (i28 != -1) {
            putBody("appStorePageType", i28);
        }
        int i29 = aVar.Pm;
        if (i29 != -1) {
            putBody("triggerType", i29);
        }
        int i30 = aVar.Pl;
        if (i30 != 0) {
            putBody("photoSizeStyle", i30);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    public a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        this.awT = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.awS = aVar.awx;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        String replaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo el = e.el(this.mAdTemplate);
        int i6 = this.awS;
        if (i6 == 1) {
            String str = el.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).BE()) {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aR(e.el(this.mAdTemplate))));
            } else {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            replaceFirst = replaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.awT);
            a(replaceFirst, this.mAdTemplate, this.awT);
        } else if (i6 == 2) {
            replaceFirst = aj.ao(context, aj.a(el.adBaseInfo.clickUrl, this.awT.mK)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.awT);
            a(replaceFirst, this.mAdTemplate, this.awT);
        } else {
            replaceFirst = el.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i6)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.awT);
        }
        Ew();
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    private void a(String str, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i6 = adTemplate.mInitVoiceStatus;
        if (i6 != 0) {
            putBody("initVoiceStatus", i6);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i7 = aVar.aye;
        if (i7 != 0) {
            putBody("adAggPageSource", i7);
        }
        if (TextUtils.isEmpty(aVar.Pj)) {
            return;
        }
        putBody("payload", aVar.Pj);
    }
}
