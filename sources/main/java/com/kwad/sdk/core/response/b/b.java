package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bp;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static Random aIN = new Random();

    public static boolean dA(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dB(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dC(@NonNull AdInfo adInfo) {
        if (dD(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dD(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String dF(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.subtitle;
        } catch (Exception unused) {
            return "摇一摇";
        }
    }

    public static long dG(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dK(@NonNull AdInfo adInfo) {
        try {
            int i6 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i6 != 2) {
                return 1;
            }
            return i6;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return 1;
        }
    }

    public static boolean dL(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean dM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean dP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean dQ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean dS(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean dU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean dV(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 10;
    }

    public static boolean dW(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 9;
    }

    public static boolean dX(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 12;
    }

    public static boolean dY(@NonNull AdInfo adInfo) {
        try {
            int i6 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i6 == 4 || i6 == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dZ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static AdMatrixInfo.RotateInfo dl(@NonNull AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cP(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dm(@NonNull AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cQ(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    public static boolean dy(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dz(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean ea(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static boolean ec(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static int a(boolean z5, @NonNull AdInfo adInfo) {
        return z5 ? adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType : adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    private static boolean cO(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.cm(adTemplate) || !dD(e.el(adTemplate))) ? false : true;
    }

    public static boolean dA(AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        return (g(el) || e.ex(adTemplate) || cv(adTemplate).cardType == 4 || e.el(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || el.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo dB(@NonNull AdTemplate adTemplate) {
        return e.el(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static long dD(@NonNull AdTemplate adTemplate) {
        long j6 = cr(adTemplate).installedActivateInfo.showTime;
        if (j6 > 0) {
            return j6;
        }
        return 0L;
    }

    public static String dE(AdTemplate adTemplate) {
        return cr(adTemplate).topFloorTKInfo.templateId;
    }

    public static String dG(AdTemplate adTemplate) {
        return cr(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String dH(AdTemplate adTemplate) {
        return cr(adTemplate).videoImageTKInfo.templateId;
    }

    public static String dI(AdTemplate adTemplate) {
        return cr(adTemplate).fullScreenInfo.templateId;
    }

    public static String dJ(AdTemplate adTemplate) {
        return cr(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String dL(AdTemplate adTemplate) {
        return cr(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String dM(AdTemplate adTemplate) {
        return cr(adTemplate).bannerTKInfo.templateId;
    }

    public static String dN(AdTemplate adTemplate) {
        return cr(adTemplate).interstitialCardInfo.templateId;
    }

    public static String dO(AdTemplate adTemplate) {
        return cr(adTemplate).confirmTKInfo.templateId;
    }

    public static String dP(AdTemplate adTemplate) {
        return cr(adTemplate).activityTKInfo.templateId;
    }

    public static String dQ(AdTemplate adTemplate) {
        return cr(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dR(AdTemplate adTemplate) {
        return cr(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String dS(AdTemplate adTemplate) {
        return cr(adTemplate).pushTKInfo.templateId;
    }

    public static String dT(AdTemplate adTemplate) {
        return cr(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String dU(AdTemplate adTemplate) {
        return cr(adTemplate).feedTKCardInfo.templateId;
    }

    public static String dV(AdTemplate adTemplate) {
        return cr(adTemplate).drawTKCardInfo.templateId;
    }

    public static AdMatrixInfo.AdBannerTKInfo dy(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean dz(AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        return (g(el) || e.ex(adTemplate) || cv(adTemplate).cardType == 4 || e.el(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType > 0 || el.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static long eb(@NonNull AdInfo adInfo) {
        try {
            long j6 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j6 <= 0) {
                return 1500L;
            }
            return j6;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static float ed(@NonNull AdInfo adInfo) {
        int i6;
        try {
            i6 = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            i6 = 7;
        }
        return i6;
    }

    public static float ee(@NonNull AdInfo adInfo) {
        int i6;
        try {
            i6 = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            i6 = 7;
        }
        return i6;
    }

    public static String ef(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String eg(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String eh(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String ei(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts ej(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts ek(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean el(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean em(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static int eo(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String ep(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean ey(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).cg(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.cX(adInfo) || a.bK(adInfo)) ? false : true;
    }

    @Nullable
    public static String cA(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, cz(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    public static long cB(@NonNull AdTemplate adTemplate) {
        return m(adTemplate, cz(adTemplate).templateId);
    }

    public static long cC(@NonNull AdTemplate adTemplate) {
        return cz(adTemplate).changeTime * 1000;
    }

    public static int cD(@NonNull AdTemplate adTemplate) {
        return cz(adTemplate).maxTimesPerDay;
    }

    public static long cE(@NonNull AdTemplate adTemplate) {
        return cz(adTemplate).intervalTime;
    }

    public static boolean cF(@NonNull AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        if (!a.aF(el) && a.at(el)) {
            return true;
        }
        return false;
    }

    public static boolean cG(@NonNull AdTemplate adTemplate) {
        if (TextUtils.isEmpty(cA(adTemplate)) || cB(adTemplate) <= 0) {
            return false;
        }
        return aq.isOrientationPortrait();
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cH(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String cI(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, cH(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo cJ(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String cK(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, cJ(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    public static boolean cL(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cK(adTemplate))) {
            return true;
        }
        return false;
    }

    @Nullable
    private static String cM(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, e.el(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    public static String cN(@NonNull AdTemplate adTemplate) {
        if (cO(adTemplate)) {
            return cM(adTemplate);
        }
        return a.aS(e.el(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cP(@NonNull AdTemplate adTemplate) {
        if (cR(adTemplate)) {
            return cp(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return cp(adTemplate).adDataV2.feedInfo;
    }

    @NonNull
    private static AdMatrixInfo.NativeMatrixAdInfo cQ(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.nativeAdInfo;
    }

    private static boolean cR(@NonNull AdTemplate adTemplate) {
        if (a.cR(e.el(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cS(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String cT(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, cP(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    private static AdMatrixInfo.FeedTKInfo cU(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.feedTKCardInfo;
    }

    @Nullable
    public static String cV(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, cS(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    @Nullable
    public static boolean cW(@NonNull AdTemplate adTemplate) {
        if (cP(adTemplate).interactionInfo.interactiveStyle == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public static boolean cX(@NonNull AdTemplate adTemplate) {
        return cP(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int cY(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cP(adTemplate).interactionInfo;
        if (adInteractionInfo != null && (shakeInfo = adInteractionInfo.shakeInfo) != null) {
            return shakeInfo.acceleration;
        }
        return 0;
    }

    @Nullable
    public static boolean cZ(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cQ(adTemplate).interactionInfo;
        if (adInteractionInfo != null && (shakeInfo = adInteractionInfo.shakeInfo) != null) {
            return shakeInfo.enable;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo cp(@NonNull AdTemplate adTemplate) {
        if (e.ed(adTemplate)) {
            return e.el(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cq(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).styles.templateList;
    }

    @NonNull
    public static AdMatrixInfo.AdDataV2 cr(@NonNull AdTemplate adTemplate) {
        return e.el(adTemplate).adMatrixInfo.adDataV2;
    }

    public static FeedSlideConf cs(@NonNull AdTemplate adTemplate) {
        String str;
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData l6 = l(adTemplate, cP(adTemplate).templateId);
        if (l6 != null) {
            str = l6.data;
        } else {
            str = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo ct(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String cu(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, cp(adTemplate).adDataV2.splashActionBarInfo.templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew cv(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String cw(@NonNull AdTemplate adTemplate) {
        boolean z5;
        AdInfo el = e.el(adTemplate);
        int ef = e.ef(adTemplate);
        if (!e.eF(adTemplate) && ef != 2) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (a.cR(el)) {
            return "";
        }
        if (z5 && a.co(adTemplate)) {
            AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, dt(adTemplate).templateId);
            if (k6 == null) {
                return "";
            }
            return k6.templateUrl;
        }
        AdMatrixInfo.MatrixTemplate k7 = k(adTemplate, cv(adTemplate).templateId);
        if (k7 == null) {
            return "";
        }
        return k7.templateUrl;
    }

    public static long cx(@NonNull AdTemplate adTemplate) {
        return cv(adTemplate).maxTimeOut;
    }

    public static boolean cy(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cw(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo cz(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static boolean dC(@NonNull AdTemplate adTemplate) {
        return cr(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static String dF(AdTemplate adTemplate) {
        return cr(adTemplate).neoTKInfo.templateId;
    }

    public static String dK(AdTemplate adTemplate) {
        return cr(adTemplate).splashPlayCardTKInfo.templateId;
    }

    @Nullable
    public static int da(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cQ(adTemplate).interactionInfo;
        if (adInteractionInfo != null && (shakeInfo = adInteractionInfo.shakeInfo) != null) {
            return shakeInfo.acceleration;
        }
        return 0;
    }

    public static double db(@NonNull AdTemplate adTemplate) {
        return e.el(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean dc(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cT(adTemplate))) {
            return true;
        }
        return false;
    }

    public static boolean dd(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cU(adTemplate).templateId)) {
            return true;
        }
        return false;
    }

    public static boolean de(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(dV(adTemplate))) {
            return true;
        }
        return false;
    }

    public static String df(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo cU = cU(adTemplate);
        if (TextUtils.isEmpty(cU.templateId)) {
            return "ksad-feed-card";
        }
        return cU.templateId;
    }

    public static boolean dg(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cV(adTemplate))) {
            return true;
        }
        return false;
    }

    public static float dh(@NonNull AdTemplate adTemplate) {
        int i6;
        try {
            i6 = e.el(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            i6 = 7;
        }
        if (i6 > 0) {
            return i6;
        }
        return 7.0f;
    }

    public static boolean di(@NonNull AdTemplate adTemplate) {
        try {
            if (e.el(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType != 1) {
                return false;
            }
            return true;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return false;
        }
    }

    public static float dj(@NonNull AdTemplate adTemplate) {
        int i6;
        try {
            i6 = e.el(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            i6 = 7;
        }
        return i6;
    }

    public static AdMatrixInfo.RotateInfo dk(@NonNull AdTemplate adTemplate) {
        try {
            return e.el(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate dn(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    /* renamed from: do, reason: not valid java name */
    public static String m122do(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, dn(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    public static boolean dp(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(m122do(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate dq(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String dr(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = k(adTemplate, dq(adTemplate).templateId);
        if (k6 != null) {
            return k6.templateUrl;
        }
        return "";
    }

    public static boolean ds(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(dr(adTemplate))) {
            return true;
        }
        return false;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dt(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo du(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dv(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dw(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dx(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static boolean en(@NonNull AdInfo adInfo) {
        if (a.bK(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) {
            return false;
        }
        return true;
    }

    public static boolean eq(@NonNull AdInfo adInfo) {
        if (a.bd(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate k(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cp(adTemplate).styles.templateList) {
            if (bp.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    private static AdMatrixInfo.TemplateData l(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cp(adTemplate).adDataV2.templateDataList) {
            if (bp.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l6 = l(adTemplate, str);
        if (l6 != null) {
            return l6.templateDelayTime;
        }
        return 0L;
    }
}
