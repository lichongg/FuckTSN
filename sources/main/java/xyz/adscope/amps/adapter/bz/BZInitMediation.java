package xyz.adscope.amps.adapter.bz;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.BeiZiCustomController;
import com.beizi.fusion.BeiZis;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.model.AMPSLocation;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BZInitMediation extends AMPSChannelInitMediation {
    private static BZInitMediation instance;
    private boolean isInit = false;

    private String getLossReason(int i6) {
        return i6 != 1 ? i6 != 3 ? "999" : "2" : "1";
    }

    public Map<String, String> getLossInfo(AMPSBidResult aMPSBidResult) {
        if (aMPSBidResult == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("winPrice", String.valueOf(aMPSBidResult.getEcpm()));
            hashMap.put("adnId", aMPSBidResult.getChannelName());
            hashMap.put("lossReason", getLossReason(aMPSBidResult.getReason()));
            return hashMap;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getWinInfo(AMPSBidResult aMPSBidResult) {
        if (aMPSBidResult == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("winPrice", String.valueOf(aMPSBidResult.getWinPrice()));
            hashMap.put("highestLossPrice", String.valueOf(aMPSBidResult.getEcpm()));
            hashMap.put("adnId", aMPSBidResult.getChannelName());
            hashMap.put(AMPSConstants.BZ_LOCAL_EXTRA_KEY_AUCTION_EXT, String.valueOf(aMPSBidResult.getWinPrice()));
            return hashMap;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static synchronized BZInitMediation getInstance() {
        BZInitMediation bZInitMediation;
        synchronized (BZInitMediation.class) {
            try {
                if (instance == null) {
                    synchronized (BZInitMediation.class) {
                        instance = new BZInitMediation();
                    }
                }
                bZInitMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bZInitMediation;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_BZ;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_BZ_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initBZSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    private void initBZSDK(final AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Map<String, Object> map;
        Context context = AMPSSDK.getContext();
        if (context != null && aMPSInitAdapterConfig != null && !TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            Map<String, Map<String, Object>> localExtraMap = aMPSInitAdapterConfig.getLocalExtraMap();
            if (localExtraMap != null) {
                if (localExtraMap.containsKey("bzLocalExtraData")) {
                    map = localExtraMap.get("bzLocalExtraData");
                } else {
                    map = null;
                }
                if (map != null) {
                    BeiZis.setAnyCustomExt(map);
                }
            }
            BeiZis.init(context, aMPSInitAdapterConfig.getAppId(), new BeiZiCustomController() { // from class: xyz.adscope.amps.adapter.bz.BZInitMediation.1
                @Override // com.beizi.fusion.BeiZiCustomController
                public boolean forbidSensor() {
                    return aMPSInitAdapterConfig.getPrivacyConfig() != null ? !aMPSInitAdapterConfig.getPrivacyConfig().isCanUseShakeAd() : super.forbidSensor();
                }

                @Override // com.beizi.fusion.BeiZiCustomController
                public String getDevOaid() {
                    return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().getDevOaid() : super.getDevOaid();
                }

                @Override // com.beizi.fusion.BeiZiCustomController
                public BeiZiLocation getLocation() {
                    AMPSLocation location;
                    String str;
                    if (aMPSInitAdapterConfig.getPrivacyConfig() == null || (location = aMPSInitAdapterConfig.getPrivacyConfig().getLocation()) == null) {
                        return super.getLocation();
                    }
                    BeiZiLocation beiZiLocation = new BeiZiLocation();
                    beiZiLocation.setLatitude(location.getLatitude() + "");
                    beiZiLocation.setLongitude(location.getLongitude() + "");
                    int type = location.getType();
                    if (type == 0) {
                        str = "GCJ-02";
                    } else {
                        if (type != 1) {
                            if (type == 2) {
                                str = "BAIDU";
                            }
                            beiZiLocation.setTime(System.currentTimeMillis());
                            return beiZiLocation;
                        }
                        str = "WGS-84";
                    }
                    beiZiLocation.setType(str);
                    beiZiLocation.setTime(System.currentTimeMillis());
                    return beiZiLocation;
                }

                @Override // com.beizi.fusion.BeiZiCustomController
                public boolean isCanUseLocation() {
                    return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUseLocation() : super.isCanUseLocation();
                }

                @Override // com.beizi.fusion.BeiZiCustomController
                public boolean isCanUseOaid() {
                    return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUseOaid() : super.isCanUseOaid();
                }

                @Override // com.beizi.fusion.BeiZiCustomController
                public boolean isCanUsePhoneState() {
                    return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUsePhoneState() : super.isCanUsePhoneState();
                }

                @Override // com.beizi.fusion.BeiZiCustomController
                public boolean isCanUseWifiState() {
                    return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().isCanUseWifiState() : super.isCanUseWifiState();
                }
            });
            if (!aMPSInitAdapterConfig.isPersonalRecommend()) {
                BeiZis.setSupportPersonalized(false);
            }
            this.isInit = true;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK init success");
            initSDKSuccess(iAMPSChannelInitCallBack);
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
        initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return BeiZis.getSdkVersion();
    }
}
