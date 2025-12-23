package xyz.adscope.amps.adapter.gm;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
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
public class GMInitMediation extends AMPSChannelInitMediation {
    private static GMInitMediation instance;
    private static List<IAMPSChannelInitCallBack> mCallBackList = new ArrayList();
    private boolean isInit = false;
    private boolean isInitIng = false;

    private static TTAdConfig buildConfig(final AMPSInitAdapterConfig aMPSInitAdapterConfig) {
        Map<String, Map<String, Object>> localExtraMap;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        TTAdConfig.Builder builder = new TTAdConfig.Builder();
        builder.appId(aMPSInitAdapterConfig.getAppId());
        builder.debug(aMPSInitAdapterConfig.isDebug());
        builder.supportMultiProcess(false);
        builder.useMediation(true);
        builder.data(getData(aMPSInitAdapterConfig));
        final AMPSPrivacyConfig privacyConfig = aMPSInitAdapterConfig.getPrivacyConfig();
        builder.customController(new TTCustomController() { // from class: xyz.adscope.amps.adapter.gm.GMInitMediation.2
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseAppList() : super.alist();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.getDevOaid() : super.getDevOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public MediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: xyz.adscope.amps.adapter.gm.GMInitMediation.2.2
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isCanUseOaid() {
                        AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                        return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseOaid() : super.isCanUseOaid();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        return aMPSInitAdapterConfig != null ? !r0.isPersonalRecommend() : super.isLimitPersonalAds();
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseAndroidId() : super.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseLocation() : super.isCanUseLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseRecordAudio() : super.isCanUsePermissionRecordAudio();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUsePhoneState() : super.isCanUsePhoneState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWifiState() : super.isCanUseWifiState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                return aMPSPrivacyConfig != null ? aMPSPrivacyConfig.isCanUseWriteExternal() : super.isCanUseWriteExternal();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public Map<String, Object> userPrivacyConfig() {
                AMPSInitAdapterConfig aMPSInitAdapterConfig2;
                Map<String, Map<String, Object>> localExtraMap2;
                Object obj8;
                try {
                    aMPSInitAdapterConfig2 = aMPSInitAdapterConfig;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (aMPSInitAdapterConfig2 != null && (localExtraMap2 = aMPSInitAdapterConfig2.getLocalExtraMap()) != null) {
                    Map<String, Object> map = localExtraMap2.containsKey(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_CSJ) ? localExtraMap2.get(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_CSJ) : null;
                    if (map != null) {
                        if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_USER_PRIVACY_CONFIG) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_USER_PRIVACY_CONFIG)) != null && (obj8 instanceof Map)) {
                            return (Map) obj8;
                        }
                        return super.userPrivacyConfig();
                    }
                }
                return super.userPrivacyConfig();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getAndroidId() {
                if (isCanUseAndroidId()) {
                    return super.getAndroidId();
                }
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                if (aMPSPrivacyConfig != null) {
                    return aMPSPrivacyConfig.getAndroidId();
                }
                return super.getAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            @Nullable
            public String getDevImei() {
                if (isCanUsePhoneState()) {
                    return super.getDevImei();
                }
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                if (aMPSPrivacyConfig != null) {
                    String devImei = aMPSPrivacyConfig.getDevImei();
                    if (!TextUtils.isEmpty(devImei)) {
                        return devImei;
                    }
                }
                return super.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            @Nullable
            public String getMacAddress() {
                if (isCanUseWifiState()) {
                    return super.getMacAddress();
                }
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                if (aMPSPrivacyConfig != null) {
                    String macAddress = aMPSPrivacyConfig.getMacAddress();
                    if (!TextUtils.isEmpty(macAddress)) {
                        return macAddress;
                    }
                }
                return super.getMacAddress();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            @Nullable
            public LocationProvider getTTLocation() {
                final AMPSLocation location;
                if (isCanUseLocation()) {
                    return super.getTTLocation();
                }
                AMPSPrivacyConfig aMPSPrivacyConfig = AMPSPrivacyConfig.this;
                if (aMPSPrivacyConfig != null && (location = aMPSPrivacyConfig.getLocation()) != null) {
                    return new LocationProvider() { // from class: xyz.adscope.amps.adapter.gm.GMInitMediation.2.1
                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLatitude() {
                            AMPSLocation aMPSLocation = location;
                            if (aMPSLocation != null) {
                                return aMPSLocation.getLatitude();
                            }
                            return 0.0d;
                        }

                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLongitude() {
                            AMPSLocation aMPSLocation = location;
                            if (aMPSLocation != null) {
                                return aMPSLocation.getLongitude();
                            }
                            return 0.0d;
                        }
                    };
                }
                return super.getTTLocation();
            }
        });
        try {
            localExtraMap = aMPSInitAdapterConfig.getLocalExtraMap();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (localExtraMap != null) {
            final Map<String, Object> map = localExtraMap.containsKey(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_CSJ) ? localExtraMap.get(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_CSJ) : null;
            if (map != null) {
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_PAID) && (obj7 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_PAID)) != null && (obj7 instanceof Boolean)) {
                    builder.paid(((Boolean) obj7).booleanValue());
                }
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_KEYWORDS) && (obj6 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_KEYWORDS)) != null && (obj6 instanceof String)) {
                    builder.keywords((String) obj6);
                }
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_TITLE_BAR_THEME) && (obj5 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_TITLE_BAR_THEME)) != null && (obj5 instanceof Integer)) {
                    builder.titleBarTheme(((Integer) obj5).intValue());
                }
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_ALLOW_SHOW_NOTIFY) && (obj4 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_ALLOW_SHOW_NOTIFY)) != null && (obj4 instanceof Boolean)) {
                    builder.allowShowNotify(((Boolean) obj4).booleanValue());
                }
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_DIRECT_DOWNLOAD_NETWORK_TYPE) && (obj3 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_DIRECT_DOWNLOAD_NETWORK_TYPE)) != null && obj3.getClass().isArray()) {
                    int[] iArr = (int[]) obj3;
                    if (iArr.length > 0) {
                        builder.directDownloadNetworkType(iArr);
                    }
                }
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_AGE_GROUP) && (obj2 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_AGE_GROUP)) != null && (obj2 instanceof Integer)) {
                    builder.setAgeGroup(((Integer) obj2).intValue());
                }
                if (map.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_THEME_STATUS) && (obj = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_THEME_STATUS)) != null && (obj instanceof Integer)) {
                    builder.themeStatus(((Integer) obj).intValue());
                }
                builder.setMediationConfig(new IMediationConfig() { // from class: xyz.adscope.amps.adapter.gm.GMInitMediation.3
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    @Nullable
                    public JSONObject getCustomLocalConfig() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    public boolean getHttps() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    @Nullable
                    public Map<String, Object> getLocalExtra() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    @Nullable
                    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    public boolean isOpenAdnTest() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    @Nullable
                    public String getOpensdkVer() {
                        Object obj8;
                        Map map2 = map;
                        if (map2 != null && map2.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_OPEN_SDK_VER) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_OPEN_SDK_VER)) != null && (obj8 instanceof String)) {
                            return (String) obj8;
                        }
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    @Nullable
                    public String getPublisherDid() {
                        Object obj8;
                        Map map2 = map;
                        if (map2 != null && map2.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_PUBLISHER_DID) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_PUBLISHER_DID)) != null && (obj8 instanceof String)) {
                            return (String) obj8;
                        }
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    public boolean isSupportH265() {
                        Object obj8;
                        Map map2 = map;
                        if (map2 != null && map2.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_SUPPORT_H265) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_SUPPORT_H265)) != null && (obj8 instanceof Boolean)) {
                            return ((Boolean) obj8).booleanValue();
                        }
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    public boolean isSupportSplashZoomout() {
                        Object obj8;
                        Map map2 = map;
                        if (map2 != null && map2.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_SUPPORT_SPLASH_ZOOM_OUT) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_SUPPORT_SPLASH_ZOOM_OUT)) != null && (obj8 instanceof Boolean)) {
                            return ((Boolean) obj8).booleanValue();
                        }
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    public boolean isWxInstalled() {
                        Object obj8;
                        Map map2 = map;
                        if (map2 != null && map2.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_WX_INSTALLED) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_WX_INSTALLED)) != null && (obj8 instanceof Boolean)) {
                            return ((Boolean) obj8).booleanValue();
                        }
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
                    @Nullable
                    public String wxAppId() {
                        Object obj8;
                        Map map2 = map;
                        if (map2 != null && map2.containsKey(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_WX_APP_ID) && (obj8 = map.get(AMPSConstants.CSJ_LOCAL_EXTRA_KEY_WX_APP_ID)) != null && (obj8 instanceof String)) {
                            return (String) obj8;
                        }
                        return null;
                    }
                });
                return builder.build();
            }
        }
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e A[Catch: Exception -> 0x009d, TRY_ENTER, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:9:0x001d, B:11:0x0025, B:13:0x002d, B:15:0x0031, B:17:0x0036, B:18:0x003b, B:21:0x004a, B:24:0x005a, B:27:0x006e, B:28:0x0075, B:30:0x0083, B:33:0x008b, B:36:0x0090, B:38:0x0095, B:39:0x0098, B:43:0x0072), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:9:0x001d, B:11:0x0025, B:13:0x002d, B:15:0x0031, B:17:0x0036, B:18:0x003b, B:21:0x004a, B:24:0x005a, B:27:0x006e, B:28:0x0075, B:30:0x0083, B:33:0x008b, B:36:0x0090, B:38:0x0095, B:39:0x0098, B:43:0x0072), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:9:0x001d, B:11:0x0025, B:13:0x002d, B:15:0x0031, B:17:0x0036, B:18:0x003b, B:21:0x004a, B:24:0x005a, B:27:0x006e, B:28:0x0075, B:30:0x0083, B:33:0x008b, B:36:0x0090, B:38:0x0095, B:39:0x0098, B:43:0x0072), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:9:0x001d, B:11:0x0025, B:13:0x002d, B:15:0x0031, B:17:0x0036, B:18:0x003b, B:21:0x004a, B:24:0x005a, B:27:0x006e, B:28:0x0075, B:30:0x0083, B:33:0x008b, B:36:0x0090, B:38:0x0095, B:39:0x0098, B:43:0x0072), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:9:0x001d, B:11:0x0025, B:13:0x002d, B:15:0x0031, B:17:0x0036, B:18:0x003b, B:21:0x004a, B:24:0x005a, B:27:0x006e, B:28:0x0075, B:30:0x0083, B:33:0x008b, B:36:0x0090, B:38:0x0095, B:39:0x0098, B:43:0x0072), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getData(xyz.adscope.amps.init.AMPSInitAdapterConfig r10) {
        /*
            java.lang.String r0 = "name"
            java.util.Map r1 = r10.getLocalExtraMap()     // Catch: java.lang.Exception -> L9d
            r2 = 0
            if (r1 == 0) goto L1a
            java.lang.String r3 = xyz.adscope.amps.common.AMPSConstants.AMPS_LOCAL_EXTRA_DATA_CSJ     // Catch: java.lang.Exception -> L9d
            boolean r3 = r1.containsKey(r3)     // Catch: java.lang.Exception -> L9d
            if (r3 == 0) goto L1a
            java.lang.String r3 = xyz.adscope.amps.common.AMPSConstants.AMPS_LOCAL_EXTRA_DATA_CSJ     // Catch: java.lang.Exception -> L9d
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Exception -> L9d
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Exception -> L9d
            goto L1b
        L1a:
            r1 = r2
        L1b:
            if (r1 == 0) goto L34
            java.lang.String r3 = xyz.adscope.amps.common.AMPSConstants.CSJ_LOCAL_EXTRA_DATA     // Catch: java.lang.Exception -> L9d
            boolean r3 = r1.containsKey(r3)     // Catch: java.lang.Exception -> L9d
            if (r3 == 0) goto L34
            java.lang.String r3 = xyz.adscope.amps.common.AMPSConstants.CSJ_LOCAL_EXTRA_DATA     // Catch: java.lang.Exception -> L9d
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Exception -> L9d
            if (r1 == 0) goto L34
            boolean r3 = r1 instanceof org.json.JSONArray     // Catch: java.lang.Exception -> L9d
            if (r3 == 0) goto L34
            r2 = r1
            org.json.JSONArray r2 = (org.json.JSONArray) r2     // Catch: java.lang.Exception -> L9d
        L34:
            if (r2 != 0) goto L3b
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> L9d
            r2.<init>()     // Catch: java.lang.Exception -> L9d
        L3b:
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L9d
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L9d
            java.lang.String r4 = "is_shake_ads"
            java.lang.String r5 = "personal_ads_type"
            r6 = 0
            if (r3 != 0) goto L59
            boolean r3 = r1.contains(r5)     // Catch: java.lang.Exception -> L9d
            boolean r1 = r1.contains(r4)     // Catch: java.lang.Exception -> L9d
            if (r1 == 0) goto L58
            r6 = 1
            r6 = r3
            r1 = 1
            goto L5a
        L58:
            r6 = r3
        L59:
            r1 = 0
        L5a:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L9d
            r3.<init>()     // Catch: java.lang.Exception -> L9d
            r3.put(r0, r5)     // Catch: java.lang.Exception -> L9d
            boolean r5 = r10.isPersonalRecommend()     // Catch: java.lang.Exception -> L9d
            java.lang.String r7 = "1"
            java.lang.String r8 = "0"
            java.lang.String r9 = "value"
            if (r5 != 0) goto L72
            r3.put(r9, r8)     // Catch: java.lang.Exception -> L9d
            goto L75
        L72:
            r3.put(r9, r7)     // Catch: java.lang.Exception -> L9d
        L75:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L9d
            r5.<init>()     // Catch: java.lang.Exception -> L9d
            r5.put(r0, r4)     // Catch: java.lang.Exception -> L9d
            xyz.adscope.amps.config.AMPSPrivacyConfig r10 = r10.getPrivacyConfig()     // Catch: java.lang.Exception -> L9d
            if (r10 == 0) goto L8e
            boolean r10 = r10.isCanUseShakeAd()     // Catch: java.lang.Exception -> L9d
            if (r10 == 0) goto L8a
            goto L8b
        L8a:
            r7 = r8
        L8b:
            r5.put(r9, r7)     // Catch: java.lang.Exception -> L9d
        L8e:
            if (r6 != 0) goto L93
            r2.put(r3)     // Catch: java.lang.Exception -> L9d
        L93:
            if (r1 != 0) goto L98
            r2.put(r5)     // Catch: java.lang.Exception -> L9d
        L98:
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Exception -> L9d
            return r10
        L9d:
            r10 = move-exception
            r10.printStackTrace()
            java.lang.String r10 = ""
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.gm.GMInitMediation.getData(xyz.adscope.amps.init.AMPSInitAdapterConfig):java.lang.String");
    }

    public static synchronized GMInitMediation getInstance() {
        GMInitMediation gMInitMediation;
        synchronized (GMInitMediation.class) {
            try {
                if (instance == null) {
                    synchronized (GMInitMediation.class) {
                        instance = new GMInitMediation();
                    }
                }
                gMInitMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gMInitMediation;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GM;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk("com.bytedance.sdk.openadsdk.TTAdSdk")) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else {
            if (TTAdSdk.isSdkReady() || this.isInit) {
                initSDKSuccess(iAMPSChannelInitCallBack);
                return;
            }
            if (iAMPSChannelInitCallBack != null) {
                mCallBackList.add(iAMPSChannelInitCallBack);
            }
            this.isInitIng = true;
            initCSJSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    public static TTAdManager get() {
        return TTAdSdk.getAdManager();
    }

    private void initCSJSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Context context = AMPSSDK.getContext();
        if (context != null && aMPSInitAdapterConfig != null && !TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            TTAdSdk.init(context, buildConfig(aMPSInitAdapterConfig));
            TTAdSdk.start(new TTAdSdk.Callback() { // from class: xyz.adscope.amps.adapter.gm.GMInitMediation.1
                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void fail(int i6, String str) {
                    try {
                        GMInitMediation.this.isInitIng = false;
                        synchronized (this) {
                            try {
                                if (GMInitMediation.mCallBackList != null && GMInitMediation.mCallBackList.size() > 0) {
                                    Iterator it = GMInitMediation.mCallBackList.iterator();
                                    while (it.hasNext()) {
                                        GMInitMediation.this.initSDKFail((IAMPSChannelInitCallBack) it.next(), new AMPSError(String.valueOf(i6), str));
                                    }
                                }
                                GMInitMediation.mCallBackList.clear();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                public void success() {
                    try {
                        GMInitMediation.this.isInitIng = false;
                        GMInitMediation.this.isInit = true;
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK init success");
                        synchronized (this) {
                            try {
                                if (GMInitMediation.mCallBackList != null && GMInitMediation.mCallBackList.size() > 0) {
                                    Iterator it = GMInitMediation.mCallBackList.iterator();
                                    while (it.hasNext()) {
                                        GMInitMediation.this.initSDKSuccess((IAMPSChannelInitCallBack) it.next());
                                    }
                                }
                                GMInitMediation.mCallBackList.clear();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        } else {
            this.isInitIng = false;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        }
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        if (TTAdSdk.getAdManager() != null) {
            return TTAdSdk.getAdManager().getSDKVersion();
        }
        return "6.8.1.7";
    }
}
