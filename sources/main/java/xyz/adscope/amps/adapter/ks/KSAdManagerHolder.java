package xyz.adscope.amps.adapter.ks;

import com.kwad.sdk.api.BaseKSAd;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdnName;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSAdManagerHolder {
    public static void sendLossNotification(BaseKSAd baseKSAd, AMPSBidResult aMPSBidResult) {
        if (baseKSAd == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("KSSDK sendLossNotification reason:");
        sb.append(aMPSBidResult != null ? Integer.valueOf(aMPSBidResult.getReason()) : "null");
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, sb.toString());
        int i6 = (aMPSBidResult == null || aMPSBidResult.getReason() != 1) ? 0 : 2;
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        if (aMPSBidResult != null) {
            adExposureFailedReason.setWinEcpm(aMPSBidResult.getEcpm());
            int transferAdnType = transferAdnType(aMPSBidResult.getChannelName());
            adExposureFailedReason.setAdnType(transferAdnType);
            if (2 == transferAdnType) {
                adExposureFailedReason.setAdnName(transferAdnName(aMPSBidResult.getChannelName()));
            }
        }
        if (baseKSAd instanceof KsSplashScreenAd) {
            ((KsSplashScreenAd) baseKSAd).reportAdExposureFailed(i6, adExposureFailedReason);
            return;
        }
        if (baseKSAd instanceof KsFeedAd) {
            ((KsFeedAd) baseKSAd).reportAdExposureFailed(i6, adExposureFailedReason);
            return;
        }
        if (baseKSAd instanceof KsInterstitialAd) {
            ((KsInterstitialAd) baseKSAd).reportAdExposureFailed(i6, adExposureFailedReason);
        } else if (baseKSAd instanceof KsRewardVideoAd) {
            ((KsRewardVideoAd) baseKSAd).reportAdExposureFailed(i6, adExposureFailedReason);
        } else if (baseKSAd instanceof KsDrawAd) {
            ((KsDrawAd) baseKSAd).reportAdExposureFailed(i6, adExposureFailedReason);
        }
    }

    public static void sendWinNotification(BaseKSAd baseKSAd, int i6) {
        if (baseKSAd == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK sendWinNotification ecpm:" + i6);
        if (baseKSAd instanceof KsSplashScreenAd) {
            ((KsSplashScreenAd) baseKSAd).setBidEcpm(i6, i6 - 1);
            return;
        }
        if (baseKSAd instanceof KsFeedAd) {
            ((KsFeedAd) baseKSAd).setBidEcpm(i6, i6 - 1);
            return;
        }
        if (baseKSAd instanceof KsInterstitialAd) {
            ((KsInterstitialAd) baseKSAd).setBidEcpm(i6, i6 - 1);
        } else if (baseKSAd instanceof KsRewardVideoAd) {
            ((KsRewardVideoAd) baseKSAd).setBidEcpm(i6, i6 - 1);
        } else if (baseKSAd instanceof KsDrawAd) {
            ((KsDrawAd) baseKSAd).setBidEcpm(i6, i6 - 1);
        }
    }

    private static int transferAdnType(String str) {
        return "1019".equals(str) ? 1 : 2;
    }

    private static String transferAdnName(String str) {
        str.getClass();
        switch (str) {
            case "1012":
                return AdnName.GUANGDIANTONG;
            case "1013":
            case "1022":
                return AdnName.CHUANSHANJIA;
            case "1018":
                return "baidu";
            default:
                return "other";
        }
    }
}
