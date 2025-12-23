package com.kwad.sdk.core.response.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.cm;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static boolean a(AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        return (smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(smallAppJumpInfo.originId) || TextUtils.isEmpty(smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z5) {
        return ((z5 && aF(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bp.isNullString(aS(adInfo))) ? false : true;
    }

    public static int bA(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i6 = adInfo.status;
        if (i6 == 0) {
            return 1;
        }
        if (1 == i6 || 2 == i6 || 3 == i6 || 4 == i6) {
            return 2;
        }
        return 8 == i6 ? 3 : 0;
    }

    public static boolean bK(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z5 = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (bN(adInfo) && z5) {
                return true;
            }
        }
        return false;
    }

    private static boolean bO(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i6 = playableStyleInfo.playableOrientation;
        return i6 == 0 || i6 == 2;
    }

    private static boolean bP(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i6 = playableStyleInfo.playableOrientation;
        return i6 == 0 || i6 == 1;
    }

    public static boolean bX(AdInfo adInfo) {
        AdInfo.AdBannerInfo adBannerInfo;
        return (adInfo == null || (adBannerInfo = adInfo.adBannerInfo) == null || adBannerInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bY(AdInfo adInfo) {
        AdInfo.AdBannerInfo adBannerInfo;
        if (adInfo == null || (adBannerInfo = adInfo.adBannerInfo) == null) {
            return false;
        }
        int i6 = adBannerInfo.videoAutoPlayType;
        return i6 == 1 || i6 == 0;
    }

    public static boolean bZ(AdInfo adInfo) {
        AdInfo.AdBannerInfo adBannerInfo;
        return (adInfo == null || (adBannerInfo = adInfo.adBannerInfo) == null || adBannerInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean bo(AdInfo adInfo) {
        return new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() != 0;
    }

    @NonNull
    private static int[] bq(@NonNull AdInfo adInfo) {
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split.length >= 3) {
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                    iArr[2] = Integer.parseInt(split[2]);
                    return iArr;
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
                return iArr;
            }
        }
        return iArr;
    }

    public static boolean cE(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean ca(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean cb(AdInfo adInfo) {
        AdInfo.AdDrawInfo adDrawInfo;
        return (adInfo == null || (adDrawInfo = adInfo.adDrawInfo) == null || adDrawInfo.videoSoundType != 1) ? false : true;
    }

    public static boolean cc(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i6 = adFeedInfo.videoAutoPlayType;
        return i6 == 1 || i6 == 0;
    }

    public static boolean cd(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean ce(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 3) ? false : true;
    }

    public static String cl(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2 && !cQ(e.el(adTemplate)) && !cR(e.el(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo el = e.el(adTemplate);
        return TextUtils.isEmpty(el.adBaseInfo.installAppLabel) ? "立即安装" : el.adBaseInfo.installAppLabel;
    }

    public static boolean cm(AdTemplate adTemplate) {
        return e.el(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    public static String cn(AdTemplate adTemplate) {
        return e.el(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    public static String co(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !aF(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static boolean du(AdInfo adInfo) {
        try {
            AdMatrixInfo.StyleComponentInfo styleComponentInfo = adInfo.adMatrixInfo.adDataV2.styleComponentInfo;
            if (styleComponentInfo != null) {
                return styleComponentInfo.styleComponentFlag;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String H(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static String IQ() {
        return "继续下载";
    }

    public static long J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature N(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        return ap.T(list) ? list.get(0) : new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static boolean S(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean T(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    @Nullable
    public static List<Integer> U(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.dynamicAdStyleInfo.slideInfo.angle;
    }

    public static boolean V(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static float aA(@NonNull AdInfo adInfo) {
        int i6 = adInfo.adBaseInfo.appScore;
        if (i6 <= 0) {
            return 0.0f;
        }
        return i6 / 10.0f;
    }

    public static boolean aB(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aC(@NonNull AdInfo adInfo) {
        float f6 = adInfo.adBaseInfo.appScore;
        if (f6 < 30.0f) {
            return 3.0f;
        }
        if (f6 < 35.0f) {
            return 3.5f;
        }
        if (f6 < 40.0f) {
            return 4.0f;
        }
        return f6 < 45.0f ? 4.5f : 5.0f;
    }

    public static String aD(AdInfo adInfo) {
        return bp.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aE(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        return TextUtils.isEmpty(str) ? aF(adInfo) ? "立即下载" : "查看详情" : str;
    }

    public static boolean aG(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int aH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aO(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static boolean aP(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && aF(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aQ(@NonNull AdInfo adInfo) {
        int i6 = adInfo.adBaseInfo.adOperationType;
        int i7 = 1;
        if (i6 != 1) {
            i7 = 2;
            if (i6 != 2) {
                return 0;
            }
        }
        return i7;
    }

    public static int aR(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aS(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : aj.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.h5Url, aB(adInfo));
    }

    public static int aT(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aU(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aV(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aX(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static String aZ(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    public static String ac(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long ad(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int ae(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long af(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long ag(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    private static int ah(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean ai(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int aj(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static long al(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return r4.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long am(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int an(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean ao(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ap(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean aq(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ar(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean at(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aO(adInfo) && aN(adInfo) == 1) || cX(adInfo)) ? false : true;
        }
        return false;
    }

    public static String au(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String av(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    private static String aw(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String ax(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ay(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String az(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static int bB(AdInfo adInfo) {
        return adInfo.status;
    }

    @Nullable
    public static String bC(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String bD(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String bE(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bF(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    @Nullable
    public static String bG(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bH(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bI(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bJ(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static long bL(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bM(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    @Nullable
    public static String bQ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String bR(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String bS(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    @Nullable
    public static String bT(AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.serverExt) == null) {
            return null;
        }
        return str;
    }

    @Nullable
    public static String bU(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.adExt;
    }

    public static boolean bV(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bW(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    @NonNull
    public static List<String> ba(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int be = be(adInfo);
        if (be == 2 || be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    public static int be(AdInfo adInfo) {
        int i6 = adInfo.adMaterialInfo.materialType;
        int i7 = 1;
        if (i6 != 1) {
            i7 = 2;
            if (i6 != 2) {
                if (i6 != 5) {
                    return i6 != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i7;
    }

    public static int bf(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static int bg(AdInfo adInfo) {
        AdInfo.AdLiveTypeInfo adLiveTypeInfo;
        AdInfo.AdDrawInfo adDrawInfo = adInfo.adDrawInfo;
        if (adDrawInfo == null || (adLiveTypeInfo = adDrawInfo.liveTypeInfo) == null) {
            return 7;
        }
        return adLiveTypeInfo.actionbarCardType;
    }

    public static String bh(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bi(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static boolean bj(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bk(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpAppMkt;
    }

    public static int bl(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpTimeOut;
    }

    public static boolean bm(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bn(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    @Nullable
    public static List<Integer> bp(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static String bv(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bw(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bx(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static boolean bz(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int cA(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static boolean cB(@NonNull AdInfo adInfo) {
        int i6 = adInfo.adSplashInfo.skipType;
        return i6 == 2 || i6 == 3;
    }

    public static boolean cD(@Nullable AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cF(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    public static int cG(@NonNull AdInfo adInfo) {
        double d6 = adInfo.adSplashInfo.impressionLimitSize;
        if (d6 <= 0.0d || d6 > 1.0d) {
            d6 = 0.699999988079071d;
        }
        return ((int) d6) * 100;
    }

    public static boolean cH(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String cI(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cJ(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 3;
    }

    public static boolean cK(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cL(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 1;
    }

    @Nullable
    public static String cM(@NonNull AdInfo adInfo) {
        int i6 = adInfo.advertiserInfo.fansCount;
        if (i6 >= 200 && i6 < 10000) {
            return String.valueOf(i6);
        }
        if (i6 < 10000) {
            return null;
        }
        double d6 = i6 / 10000.0d;
        return new DecimalFormat(cm.f10901d).format(d6) + IAdInterListener.AdReqParam.WIDTH;
    }

    public static String cN(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cO(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean cP(@NonNull AdInfo adInfo) {
        int i6 = adInfo.adStyleConfInfo.innerAdType;
        return i6 == 4 || i6 == 5;
    }

    @Deprecated
    public static boolean cQ(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 7;
    }

    public static boolean cR(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && cp(adInfo) != 0;
    }

    public static String cT(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return aj.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, aB(adInfo));
    }

    public static String cU(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo cV(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cW(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean cZ(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            return true;
        }
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
        return false;
    }

    public static boolean cf(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        return (hVar == null || !hVar.BR()) && !TextUtils.isEmpty(aS(adInfo)) && adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse == 1;
    }

    @NonNull
    public static String cg(@NonNull AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        return TextUtils.isEmpty(str) ? "浏览页面" : str;
    }

    public static int ch(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    public static int ci(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    public static int cj(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    public static boolean ck(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        AdInfo.H5Config h5Config;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null || (h5Config = adBaseInfo.apiExpParam) == null) {
            return false;
        }
        return h5Config.deeplinkOptimizeSwitch;
    }

    @NonNull
    public static String cm(@NonNull AdInfo adInfo) {
        String aw = aw(adInfo);
        return TextUtils.isEmpty(aw) ? "可爱的广告君" : aw;
    }

    @NonNull
    public static String cn(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static long cp(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String cq(@NonNull AdInfo adInfo) {
        return bp.isNullString(adInfo.adConversionInfo.liveServiceToken) ? "" : adInfo.adConversionInfo.liveServiceToken;
    }

    public static long cr(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    @NonNull
    public static String cs(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo ct(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cu(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean cv(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int cw(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int cx(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cy(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String cz(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    @Deprecated
    public static String dF(int i6) {
        return t(i6, "下载中  %s%%");
    }

    public static String dG(int i6) {
        return "继续下载 " + i6 + "%";
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if ((java.lang.System.currentTimeMillis() - r2) > (r6 * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean da(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r8) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r8.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.ag.QF()
            r0 = 1
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L15
        L13:
            r1 = 1
            goto L2e
        L15:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r8 = r8.adStyleConfInfo
            int r8 = r8.adPushIntervalTime
            long r6 = (long) r8
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 > 0) goto L20
            r6 = 900(0x384, double:4.447E-321)
        L20:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L2e
            goto L13
        L2e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "isPushAdEnable intervalEnable: "
            r8.<init>(r0)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "AdInfoHelper"
            com.kwad.sdk.core.d.c.d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.da(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int db(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    private static boolean dd(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long de(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean df(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean dg(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static boolean dh(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifySwitch;
    }

    public static long di(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifyAdvanceMs;
    }

    private static List<String> dk(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int be = be(adInfo);
        if (be == 2 || be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    public static String dm(AdInfo adInfo) {
        return adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId;
    }

    public static boolean dn(@NonNull AdInfo adInfo) {
        int i6 = adInfo.adMaterialInfo.derivativeMaterialType;
        return i6 == 6 || i6 == 2;
    }

    /* renamed from: do, reason: not valid java name */
    public static int m121do(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.campaignType;
    }

    public static int dp(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.ocpcActionType;
    }

    public static int dq(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.industryFirstLevelId;
    }

    public static int dr(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adConversionInfo.webUriSourceType;
    }

    public static int ds(AdInfo adInfo) {
        return adInfo.adBannerInfo.videoAutoPlayType;
    }

    public static boolean dt(AdInfo adInfo) {
        return adInfo.adBannerInfo.isSupportCarousel;
    }

    public static String dv(AdInfo adInfo) {
        try {
            AdMatrixInfo.StyleComponentInfo styleComponentInfo = adInfo.adMatrixInfo.adDataV2.styleComponentInfo;
            if (styleComponentInfo != null) {
                AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo = styleComponentInfo.playCardInfo;
                long j6 = componentTemplateInfo != null ? componentTemplateInfo.pageId : 0L;
                AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo2 = styleComponentInfo.endCardInfo;
                return AdMatrixInfo.ComponentParam.obtain().setPageId(Long.valueOf(j6)).setEndCardPageId(Long.valueOf(componentTemplateInfo2 != null ? componentTemplateInfo2.pageId : 0L)).toJson().toString();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean dw(AdInfo adInfo) {
        return adInfo.ksUaPattern;
    }

    public static boolean dx(AdInfo adInfo) {
        return adInfo.unionMark;
    }

    public static String t(int i6, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i6));
    }

    public static String K(@NonNull AdInfo adInfo) {
        return aV(adInfo).materialUrl;
    }

    public static int L(@NonNull AdInfo adInfo) {
        if (be(adInfo) == 2) {
            return aU(adInfo).videoDuration;
        }
        return aV(adInfo).videoDuration;
    }

    public static long M(@NonNull AdInfo adInfo) {
        int i6;
        if (be(adInfo) == 2) {
            i6 = aU(adInfo).videoDuration;
        } else {
            i6 = aV(adInfo).videoDuration;
        }
        return i6 * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String O(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = be(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L35
            r3 = 2
            if (r0 == r3) goto L12
            if (r0 == r1) goto L12
            r2 = 8
            if (r0 == r2) goto L58
            goto L7b
        L12:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1a
            java.lang.String r5 = r4.firstFrame
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1a
            java.lang.String r6 = r4.firstFrame
            return r6
        L35:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L3d
            java.lang.String r4 = r3.firstFrame
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3d
            java.lang.String r6 = r3.firstFrame
            return r6
        L58:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L60
            java.lang.String r2 = r0.firstFrame
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L60
            java.lang.String r6 = r0.firstFrame
            return r6
        L7b:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static int Q(@NonNull AdInfo adInfo) {
        return aV(adInfo).videoWidth;
    }

    public static int R(@NonNull AdInfo adInfo) {
        return aV(adInfo).videoHeight;
    }

    public static boolean W(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (aV.videoWidth <= aV.videoHeight) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String X(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = be(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L41
            r3 = 2
            if (r0 == r3) goto L13
            if (r0 == r1) goto L13
            r2 = 8
            if (r0 == r2) goto L64
            goto L87
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1b
            java.lang.String r5 = r4.materialUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L36
            java.lang.String r6 = r4.materialUrl
            return r6
        L36:
            java.lang.String r5 = r4.coverUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1b
            java.lang.String r6 = r4.coverUrl
            return r6
        L41:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L64
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L49
            java.lang.String r4 = r3.coverUrl
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L49
            java.lang.String r6 = r3.coverUrl
            return r6
        L64:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L6c
            java.lang.String r2 = r0.coverUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6c
            java.lang.String r6 = r0.coverUrl
            return r6
        L87:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String Y(@NonNull AdInfo adInfo) {
        int be = be(adInfo);
        if (be != 1) {
            if (be != 2 && be != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aX(adInfo).blurBackgroundUrl;
    }

    private static int Z(@NonNull AdInfo adInfo) {
        return aV(adInfo).width;
    }

    public static boolean aF(@NonNull AdInfo adInfo) {
        if (aQ(adInfo) == 1) {
            return true;
        }
        return false;
    }

    public static boolean aW(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aU;
        if (bc(adInfo)) {
            aU = aV(adInfo);
        } else {
            aU = aU(adInfo);
        }
        if (aU.height > aU.width) {
            return true;
        }
        return false;
    }

    public static boolean aY(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (aV.height > aV.width) {
            return true;
        }
        return false;
    }

    private static int aa(@NonNull AdInfo adInfo) {
        return aV(adInfo).height;
    }

    public static long ab(@NonNull AdInfo adInfo) {
        return aV(adInfo).photoId;
    }

    public static boolean ak(@NonNull AdInfo adInfo) {
        if (ah(adInfo) != 0) {
            return true;
        }
        return false;
    }

    public static boolean as(@NonNull AdInfo adInfo) {
        if (!aF(adInfo) && at(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean bN(AdInfo adInfo) {
        if (aq.isOrientationPortrait()) {
            return bP(adInfo);
        }
        return bO(adInfo);
    }

    @NonNull
    public static String bb(@NonNull AdInfo adInfo) {
        if (bc(adInfo)) {
            return K(adInfo);
        }
        List<String> ba = ba(adInfo);
        if (ba.size() > 0) {
            return ba.get(0);
        }
        return "";
    }

    public static boolean bc(@NonNull AdInfo adInfo) {
        if (be(adInfo) == 1) {
            return true;
        }
        return false;
    }

    public static boolean bd(@NonNull AdInfo adInfo) {
        if (aU(adInfo).featureType == 2) {
            return true;
        }
        return false;
    }

    public static int br(@NonNull AdInfo adInfo) {
        int i6 = bq(adInfo)[0];
        if (i6 > 0) {
            return i6;
        }
        return 3;
    }

    public static int bs(@NonNull AdInfo adInfo) {
        int i6 = bq(adInfo)[1];
        if (i6 <= 0) {
            i6 = 3;
        }
        return i6 + br(adInfo);
    }

    public static int bt(@NonNull AdInfo adInfo) {
        int i6 = bq(adInfo)[2];
        if (i6 <= 0) {
            i6 = 3;
        }
        return i6 + bs(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b bu(@NonNull AdInfo adInfo) {
        boolean z5;
        String O = O(adInfo);
        int Q = Q(adInfo);
        int R = R(adInfo);
        if (!bp.isNullString(O) && !bp.hp(O) && Q != 0 && R != 0) {
            z5 = false;
        } else {
            O = X(adInfo);
            Q = Z(adInfo);
            R = aa(adInfo);
            z5 = true;
        }
        String str = O;
        int i6 = Q;
        int i7 = R;
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z5 + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, i6, i7, true, z5);
    }

    public static int by(AdInfo adInfo) {
        if (aF(adInfo)) {
            AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
            if (complianceInfo == null) {
                return -1;
            }
            return complianceInfo.materialJumpType;
        }
        AdInfo.UnDownloadRegionConf unDownloadRegionConf = adInfo.unDownloadConf.unDownloadRegionConf;
        if (unDownloadRegionConf == null) {
            return -1;
        }
        return unDownloadRegionConf.materialJumpType;
    }

    public static boolean cC(@Nullable AdInfo adInfo) {
        if (!cD(adInfo)) {
            return false;
        }
        int i6 = adInfo.adSplashInfo.skipType;
        if (i6 != 0 && i6 != 2) {
            return false;
        }
        return true;
    }

    public static boolean cS(@NonNull AdInfo adInfo) {
        if (!cR(adInfo) && !cQ(adInfo)) {
            return false;
        }
        return true;
    }

    public static boolean cX(@NonNull AdInfo adInfo) {
        if (aF(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cY(@NonNull AdInfo adInfo) {
        if (cX(adInfo) && ag(adInfo) < M(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean dc(@NonNull AdInfo adInfo) {
        if (cR(adInfo) && !TextUtils.isEmpty(b.ep(adInfo)) && !dd(adInfo)) {
            return true;
        }
        return false;
    }

    public static KSAdInfoData dj(AdInfo adInfo) {
        KSAdInfoData interactionType = KSAdInfoData.obtain().setAdDescription(au(adInfo)).setProductName(ax(adInfo)).setAdSource(aD(adInfo)).setVideoUrl(K(adInfo)).setMaterialType(be(adInfo)).setAppIconUrl(co(adInfo)).setAppName(av(adInfo)).setImageList(dk(adInfo)).setVideoCoverImageUrl(dl(adInfo)).setInteractionType(aQ(adInfo));
        try {
            interactionType.setCreativeId(J(adInfo));
        } catch (Throwable unused) {
        }
        return interactionType;
    }

    private static String dl(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (!TextUtils.isEmpty(aV.coverUrl)) {
            return aV.coverUrl;
        }
        return null;
    }

    @Nullable
    public static SpannableString b(AdInfo adInfo, @ColorInt int i6) {
        String format;
        int indexOf;
        String cM = cM(adInfo);
        if (cM == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", cM)).indexOf(cM)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i6), indexOf, cM.length() + indexOf, 18);
        return spannableString;
    }

    @Deprecated
    public static boolean co(@NonNull AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo dt = b.dt(adTemplate);
        return (dt == null || dt.isEmpty() || el.adStyleConfInfo.innerAdType != 2) ? false : true;
    }

    @NonNull
    public static String cl(@NonNull AdInfo adInfo) {
        String ax;
        if (aF(adInfo)) {
            ax = av(adInfo);
        } else {
            ax = ax(adInfo);
        }
        if (TextUtils.isEmpty(ax)) {
            ax = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(ax) ? "可爱的广告君" : ax;
    }
}
