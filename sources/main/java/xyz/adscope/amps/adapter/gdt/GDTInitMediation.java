package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.config.model.AMPSLocation;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTInitMediation extends AMPSChannelInitMediation {
    private static final int GDT_PERSONAL_RECOMMEND_CLOSE = 1;
    private static final int GDT_PERSONAL_RECOMMEND_OPEN = 0;
    private static GDTInitMediation instance;
    private AMPSPrivacyConfig ampsPrivacyConfig;
    private boolean isInit = false;
    private String userAgent;

    private void initGDTSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Map<String, Object> map;
        Object obj;
        AMPSLocation location;
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
        this.ampsPrivacyConfig = privacyConfig;
        if (privacyConfig != null) {
            boolean isCanUseAndroidId = privacyConfig.isCanUseAndroidId();
            boolean isCanUseMacAddress = this.ampsPrivacyConfig.isCanUseMacAddress();
            boolean isCanUseLocation = this.ampsPrivacyConfig.isCanUseLocation();
            boolean isCanUseIP = this.ampsPrivacyConfig.isCanUseIP();
            HashMap hashMap = new HashMap();
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, Boolean.valueOf(isCanUseAndroidId));
            hashMap.put("device_id", Boolean.valueOf(isCanUseAndroidId));
            hashMap.put("mac_address", Boolean.valueOf(isCanUseMacAddress));
            if (!isCanUseLocation) {
                hashMap.put("cell_id", Boolean.FALSE);
            }
            if (!isCanUseIP) {
                Boolean bool = Boolean.FALSE;
                hashMap.put("mipaddr", bool);
                hashMap.put("wipaddr", bool);
            }
            GlobalSetting.setAgreeReadPrivacyInfo(hashMap);
            GlobalSetting.setEnableCollectAppInstallStatus(this.ampsPrivacyConfig.isCanUseAppList());
            boolean isCanUseShakeAd = this.ampsPrivacyConfig.isCanUseShakeAd();
            HashMap hashMap2 = new HashMap();
            if (!isCanUseShakeAd) {
                hashMap2.put("shakable", "0");
            }
            if (!isCanUseLocation && (location = this.ampsPrivacyConfig.getLocation()) != null) {
                hashMap2.put(d.D, location.getLatitude() + "");
                hashMap2.put(d.C, location.getLongitude() + "");
                hashMap2.put("loc_time", System.currentTimeMillis() + "");
            }
            if (hashMap2.size() > 0) {
                GlobalSetting.setExtraUserData(hashMap2);
            }
        }
        Map<String, Map<String, Object>> localExtraMap = aMPSInitAdapterConfig.getLocalExtraMap();
        if (localExtraMap != null && localExtraMap.containsKey(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_GDT) && (map = localExtraMap.get(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_GDT)) != null && map.containsKey(AMPSConstants.GDT_LOCAL_EXTRA_KEY_CONV_OPTIMIZE_INFO) && (obj = map.get(AMPSConstants.GDT_LOCAL_EXTRA_KEY_CONV_OPTIMIZE_INFO)) != null && (obj instanceof Map)) {
            GlobalSetting.setConvOptimizeInfo((Map) obj);
        }
        String appId = aMPSInitAdapterConfig.getAppId();
        GlobalSetting.setPersonalizedState(!aMPSInitAdapterConfig.isPersonalRecommend() ? 1 : 0);
        GDTAdSdk.initWithoutStart(context, appId);
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTInitMediation.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
            }
        });
        this.isInit = true;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK init success");
        initSDKSuccess(iAMPSChannelInitCallBack);
    }

    public static synchronized GDTInitMediation getInstance() {
        GDTInitMediation gDTInitMediation;
        synchronized (GDTInitMediation.class) {
            try {
                if (instance == null) {
                    synchronized (GDTInitMediation.class) {
                        instance = new GDTInitMediation();
                    }
                }
                gDTInitMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gDTInitMediation;
    }

    public AMPSPrivacyConfig getAmpsPrivacyConfig() {
        return this.ampsPrivacyConfig;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    public String getUserAgent(Context context) {
        return context == null ? "" : !TextUtils.isEmpty(this.userAgent) ? this.userAgent : WebSettings.getDefaultUserAgent(context);
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initGDTSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return SDKStatus.getIntegrationSDKVersion();
    }
}
