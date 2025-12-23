package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsLocation;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
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
public class KSInitMediation extends AMPSChannelInitMediation {
    private static KSInitMediation instance;
    private String ipAddress;
    private boolean isInit = false;
    private boolean isCanUseShakeAd = true;

    public String getBidToken(String str) {
        try {
            KsScene build = new KsScene.Builder(Long.parseLong(str)).build();
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager == null) {
                return null;
            }
            return loadManager.getBidRequestToken(build);
        } catch (NumberFormatException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static synchronized KSInitMediation getInstance() {
        KSInitMediation kSInitMediation;
        synchronized (KSInitMediation.class) {
            try {
                if (instance == null) {
                    synchronized (KSInitMediation.class) {
                        instance = new KSInitMediation();
                    }
                }
                kSInitMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kSInitMediation;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return "KS";
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else if (this.isInit) {
            initSDKSuccess(iAMPSChannelInitCallBack);
        } else {
            initKSSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    public boolean isCanUseShakeAd() {
        return this.isCanUseShakeAd;
    }

    private void initKSSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, final IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        boolean z5;
        Map<String, Object> map;
        Object obj;
        Context context = AMPSSDK.getContext();
        if (context != null && aMPSInitAdapterConfig != null && !TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            final AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
            boolean z6 = true;
            if (privacyConfig != null) {
                z5 = privacyConfig.isCanUseWifiState();
                this.isCanUseShakeAd = privacyConfig.isCanUseShakeAd();
                this.ipAddress = privacyConfig.getIP();
            } else {
                z5 = true;
            }
            if (!aMPSInitAdapterConfig.isPersonalRecommend()) {
                KsAdSDK.setPersonalRecommend(false);
            }
            Map<String, Map<String, Object>> localExtraMap = aMPSInitAdapterConfig.getLocalExtraMap();
            if (localExtraMap != null && localExtraMap.containsKey(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_KS) && (map = localExtraMap.get(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_KS)) != null && map.containsKey(AMPSConstants.KS_LOCAL_EXTRA_KEY_SHOW_NOTIFICATION) && (obj = map.get(AMPSConstants.KS_LOCAL_EXTRA_KEY_SHOW_NOTIFICATION)) != null && (obj instanceof Boolean)) {
                z6 = ((Boolean) obj).booleanValue();
            }
            KsAdSDK.init(context, new SdkConfig.Builder().appId(aMPSInitAdapterConfig.getAppId()).appName(aMPSInitAdapterConfig.getAppName()).canReadNearbyWifiList(z5).customController(new KsCustomController() { // from class: xyz.adscope.amps.adapter.ks.KSInitMediation.2
                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canReadInstalledPackages() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseAppList() : super.canReadInstalledPackages();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canReadLocation() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseLocation() : super.canReadLocation();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseMacAddress() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWifiState() : super.canUseMacAddress();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseNetworkState() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWifiState() : super.canUseNetworkState();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseOaid() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseOaid() : super.canUseOaid();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUsePhoneState() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUsePhoneState() : super.canUsePhoneState();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public boolean canUseStoragePermission() {
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWriteExternal() : super.canUseStoragePermission();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public KsLocation getKsLocation() {
                    AMPSLocation location;
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    return (aMPSPrivacyConfig == null || (location = aMPSPrivacyConfig.getLocation()) == null) ? super.getKsLocation() : new KsLocation(location.getLatitude(), location.getLongitude());
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public String getAndroidId() {
                    if (canUsePhoneState()) {
                        return super.getAndroidId();
                    }
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null) {
                        return aMPSPrivacyConfig.getAndroidId();
                    }
                    return super.getAndroidId();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public String getImei() {
                    if (canUsePhoneState()) {
                        return super.getImei();
                    }
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null) {
                        String devImei = aMPSPrivacyConfig.getDevImei();
                        if (!TextUtils.isEmpty(devImei)) {
                            return devImei;
                        }
                    }
                    return super.getImei();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public String[] getImeis() {
                    String[] devImeiList;
                    if (canUsePhoneState()) {
                        return super.getImeis();
                    }
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null && (devImeiList = aMPSPrivacyConfig.getDevImeiList()) != null && devImeiList.length > 0) {
                        return devImeiList;
                    }
                    return super.getImeis();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public List<String> getInstalledPackages() {
                    try {
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (canReadInstalledPackages()) {
                        return super.getInstalledPackages();
                    }
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null) {
                        List<PackageInfo> appList = aMPSPrivacyConfig.getAppList();
                        ArrayList arrayList = new ArrayList();
                        if (appList != null && appList.size() > 0) {
                            for (int i6 = 0; i6 < appList.size(); i6++) {
                                arrayList.add(appList.get(i6).packageName);
                            }
                        }
                        return arrayList;
                    }
                    return super.getInstalledPackages();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public String getMacAddress() {
                    if (canUseMacAddress()) {
                        return super.getMacAddress();
                    }
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null) {
                        return aMPSPrivacyConfig.getMacAddress();
                    }
                    return super.getMacAddress();
                }

                @Override // com.kwad.sdk.api.KsCustomController
                public String getOaid() {
                    if (canUseOaid()) {
                        return super.getOaid();
                    }
                    AMPSPrivacyConfig aMPSPrivacyConfig = privacyConfig;
                    if (aMPSPrivacyConfig != null) {
                        return aMPSPrivacyConfig.getDevOaid();
                    }
                    return super.getOaid();
                }
            }).showNotification(z6).setStartCallback(new KsInitCallback() { // from class: xyz.adscope.amps.adapter.ks.KSInitMediation.1
                @Override // com.kwad.sdk.api.KsInitCallback
                public void onFail(int i6, String str) {
                    KSInitMediation.this.initSDKFail(iAMPSChannelInitCallBack, new AMPSError(i6 + "", str));
                }

                @Override // com.kwad.sdk.api.KsInitCallback
                public void onSuccess() {
                    KSInitMediation.this.isInit = true;
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK init success");
                    KSInitMediation.this.initSDKSuccess(iAMPSChannelInitCallBack);
                }
            }).build());
            KsAdSDK.start();
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
        initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return KsAdSDK.getSDKVersion();
    }
}
