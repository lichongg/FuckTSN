package xyz.adscope.amps.adapter.bd;

import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDInitMediation extends AMPSChannelInitMediation {
    private static BDInitMediation instance;
    private static boolean isInit;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initBDSDK(xyz.adscope.amps.init.AMPSInitAdapterConfig r12, final xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack r13) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.bd.BDInitMediation.initBDSDK(xyz.adscope.amps.init.AMPSInitAdapterConfig, xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack):void");
    }

    public int getLossReason(int i6) {
        if (i6 == 1) {
            return 203;
        }
        if (i6 != 2) {
            return i6 != 3 ? 900 : 100;
        }
        return 201;
    }

    public LinkedHashMap<String, Object> getWinInfo(AMPSBidResult aMPSBidResult) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        if (aMPSBidResult == null) {
            return linkedHashMap;
        }
        linkedHashMap.put("ecpm", Integer.valueOf(aMPSBidResult.getEcpm()));
        linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdn(aMPSBidResult.getChannelName())));
        linkedHashMap.put("ad_t", 7);
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put("bid_t", Integer.valueOf(getAdnType(aMPSBidResult.getBidType())));
        linkedHashMap.put("is_s", 2);
        linkedHashMap.put("is_c", 2);
        linkedHashMap.put(MediationConstant.KEY_REASON, Integer.valueOf(getLossReason(aMPSBidResult.getReason())));
        return linkedHashMap;
    }

    public static synchronized BDInitMediation getInstance() {
        BDInitMediation bDInitMediation;
        synchronized (BDInitMediation.class) {
            try {
                if (instance == null) {
                    synchronized (BDInitMediation.class) {
                        instance = new BDInitMediation();
                    }
                }
                bDInitMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bDInitMediation;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return "BD";
    }

    public LinkedHashMap<String, Object> getSecondInfo(AMPSBidResult aMPSBidResult) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        if (aMPSBidResult == null) {
            return linkedHashMap;
        }
        linkedHashMap.put("ecpm", Integer.valueOf(aMPSBidResult.getEcpm()));
        linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(getAdn(aMPSBidResult.getChannelName())));
        linkedHashMap.put("ad_t", 7);
        linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put("bid_t", Integer.valueOf(getAdnType(aMPSBidResult.getBidType())));
        return linkedHashMap;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_BAIDU_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initBDSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    private int getAdn(String str) {
        str.getClass();
        switch (str) {
            case "1012":
                return 2;
            case "1013":
            case "1022":
                return 1;
            case "1018":
                return 9;
            case "1019":
                return 3;
            default:
                return 10;
        }
    }

    private int getAdnType(String str) {
        str.getClass();
        if (!str.equals(AMPSConstants.BiddingType.BIDDING_TYPE_C2S)) {
            return 10;
        }
        return 3;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return AdSettings.getSDKVersion();
    }
}
