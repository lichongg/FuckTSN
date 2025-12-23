package xyz.adscope.amps.adapter.asnp;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.publish.ASNPAdSDK;
import xyz.adscope.ad.publish.ASNPConstants;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.ad.publish.IASNPCustomController;
import xyz.adscope.ad.publish.IInitCallback;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPInitMediation extends AMPSChannelInitMediation {
    private static ASNPInitMediation instance;
    private static List<IAMPSChannelInitCallBack> mCallBackList = new ArrayList();
    private boolean isInit = false;
    private boolean isInitIng = false;
    private String mApiKey;

    private void initASNPSDK(final AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Context context = AMPSSDK.getContext();
        if (context == null || aMPSInitAdapterConfig == null || TextUtils.isEmpty(aMPSInitAdapterConfig.getAppId())) {
            this.isInitIng = false;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_INIT_ERROR;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            return;
        }
        ASNPInitConfig.Builder builder = new ASNPInitConfig.Builder(aMPSInitAdapterConfig.getAppId());
        this.mApiKey = ASNPInitConfig.AD_SCOPE_ADN;
        builder.setDebugSetting(aMPSInitAdapterConfig.isDebug());
        Map<String, Map<String, Object>> localExtraMap = aMPSInitAdapterConfig.getLocalExtraMap();
        if (localExtraMap != null) {
            Map<String, Object> map = localExtraMap.containsKey(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_ASNP) ? localExtraMap.get(AMPSConstants.AMPS_LOCAL_EXTRA_DATA_ASNP) : null;
            if (map != null) {
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_API_KEY) && (obj7 = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_API_KEY)) != null && (obj7 instanceof String)) {
                    this.mApiKey = (String) obj7;
                }
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_USE_HTTPS) && (obj6 = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_USE_HTTPS)) != null && (obj6 instanceof Boolean)) {
                    builder.setUseHttps(((Boolean) obj6).booleanValue());
                }
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_USER_ID) && (obj5 = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_USER_ID)) != null && (obj5 instanceof String)) {
                    builder.setUserId((String) obj5);
                }
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_OPTION_FIELDS) && (obj4 = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_OPTION_FIELDS)) != null && (obj4 instanceof Map)) {
                    builder.setOptionFields((Map) obj4);
                }
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_CURRENCY) && (obj3 = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_CURRENCY)) != null && (obj3 instanceof List)) {
                    List list = (List) obj3;
                    if (list.size() > 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            builder.addCurrency((String) it.next());
                        }
                    }
                }
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_COUNTRY_CN) && (obj2 = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_COUNTRY_CN)) != null && (obj2 instanceof Integer)) {
                    builder.setCountryCN(((Integer) obj2).intValue());
                }
                if (map.containsKey(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_UI_MODEL) && (obj = map.get(AMPSConstants.ASNP_LOCAL_EXTRA_KEY_UI_MODEL)) != null && (obj instanceof Integer)) {
                    int intValue = ((Integer) obj).intValue();
                    ASNPConstants.UiModel uiModel = ASNPConstants.UiModel.UI_MODEL_AUTO;
                    if (intValue == 1) {
                        uiModel = ASNPConstants.UiModel.UI_MODEL_DARK;
                    } else if (intValue == 2) {
                        uiModel = ASNPConstants.UiModel.UI_MODEL_LIGHT;
                    }
                    builder.setUiModel(uiModel);
                }
            }
        }
        builder.setAdCustomController(new IASNPCustomController() { // from class: xyz.adscope.amps.adapter.asnp.ASNPInitMediation.1
            @Override // xyz.adscope.ad.publish.IASNPCustomController
            public String getOAID() {
                return aMPSInitAdapterConfig.getPrivacyConfig() != null ? aMPSInitAdapterConfig.getPrivacyConfig().getDevOaid() : super.getOAID();
            }

            @Override // xyz.adscope.ad.publish.IASNPCustomController
            public boolean isSupportPersonalized() {
                AMPSInitAdapterConfig aMPSInitAdapterConfig2 = aMPSInitAdapterConfig;
                return aMPSInitAdapterConfig2 != null ? aMPSInitAdapterConfig2.isPersonalRecommend() : super.isSupportPersonalized();
            }
        });
        ASNPAdSDK.getInstance().init(context, builder.build(), new IInitCallback() { // from class: xyz.adscope.amps.adapter.asnp.ASNPInitMediation.2
            @Override // xyz.adscope.ad.publish.IInitCallback
            public void alreadyInit() {
                ASNPInitMediation.this.isInitIng = false;
                ASNPInitMediation.this.isInit = true;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK init success");
                synchronized (this) {
                    try {
                        if (ASNPInitMediation.mCallBackList != null && ASNPInitMediation.mCallBackList.size() > 0) {
                            Iterator it2 = ASNPInitMediation.mCallBackList.iterator();
                            while (it2.hasNext()) {
                                ASNPInitMediation.this.initSDKSuccess((IAMPSChannelInitCallBack) it2.next());
                            }
                        }
                        ASNPInitMediation.mCallBackList.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // xyz.adscope.ad.publish.IInitCallback
            public void initFailed(int i6, String str) {
                try {
                    ASNPInitMediation.this.isInitIng = false;
                    synchronized (this) {
                        try {
                            if (ASNPInitMediation.mCallBackList != null && ASNPInitMediation.mCallBackList.size() > 0) {
                                Iterator it2 = ASNPInitMediation.mCallBackList.iterator();
                                while (it2.hasNext()) {
                                    ASNPInitMediation.this.initSDKFail((IAMPSChannelInitCallBack) it2.next(), new AMPSError(String.valueOf(i6), str));
                                }
                            }
                            ASNPInitMediation.mCallBackList.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }

            @Override // xyz.adscope.ad.publish.IInitCallback
            public void initSuccess() {
                ASNPInitMediation.this.isInitIng = false;
                ASNPInitMediation.this.isInit = true;
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK init success");
                synchronized (this) {
                    try {
                        if (ASNPInitMediation.mCallBackList != null && ASNPInitMediation.mCallBackList.size() > 0) {
                            Iterator it2 = ASNPInitMediation.mCallBackList.iterator();
                            while (it2.hasNext()) {
                                ASNPInitMediation.this.initSDKSuccess((IAMPSChannelInitCallBack) it2.next());
                            }
                        }
                        ASNPInitMediation.mCallBackList.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // xyz.adscope.ad.publish.IInitCallback
            public void initializing() {
            }
        });
    }

    public static synchronized ASNPInitMediation getInstance() {
        ASNPInitMediation aSNPInitMediation;
        synchronized (ASNPInitMediation.class) {
            try {
                if (instance == null) {
                    synchronized (ASNPInitMediation.class) {
                        instance = new ASNPInitMediation();
                    }
                }
                aSNPInitMediation = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aSNPInitMediation;
    }

    public String getApiKey() {
        return this.mApiKey;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkName() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_ASNP;
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (!SystemUtil.hasSdk(AMPSConstants.CHANNEL_SDK_ASNP_CLASSNAME)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_SDK_NOT_IMPORT;
            initSDKFail(iAMPSChannelInitCallBack, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        } else {
            if (this.isInit) {
                initSDKSuccess(iAMPSChannelInitCallBack);
                return;
            }
            if (iAMPSChannelInitCallBack != null) {
                mCallBackList.add(iAMPSChannelInitCallBack);
            }
            if (this.isInitIng) {
                return;
            }
            this.isInitIng = true;
            initASNPSDK(aMPSInitAdapterConfig, iAMPSChannelInitCallBack);
        }
    }

    @Override // xyz.adscope.amps.init.inter.AMPSChannelInitMediation
    public String getNetworkVersion() {
        return ASNPAdSDK.getInstance().getSDKVersionName();
    }
}
