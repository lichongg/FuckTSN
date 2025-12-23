package xyz.adscope.amps.init.inter;

import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSChannelInitMediation {
    public List getActivityStatus() {
        return null;
    }

    public List getMetaValutStatus() {
        return null;
    }

    public Map<String, Boolean> getPluginClassStatus() {
        return null;
    }

    public List getProviderStatus() {
        return null;
    }

    public List getServiceStatus() {
        return null;
    }

    public abstract void initSDK(AMPSInitAdapterConfig aMPSInitAdapterConfig, IAMPSChannelInitCallBack iAMPSChannelInitCallBack);

    public String getNetworkName() {
        return "";
    }

    public String getNetworkSDKClass() {
        return "";
    }

    public String getNetworkVersion() {
        return "";
    }

    public void initSDKFail(IAMPSChannelInitCallBack iAMPSChannelInitCallBack, AMPSError aMPSError) {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, getNetworkName() + "SDK init fail code:" + aMPSError.getCode() + "; message:" + aMPSError.getMessage());
        if (iAMPSChannelInitCallBack != null) {
            iAMPSChannelInitCallBack.failCallBack(aMPSError);
        }
    }

    public void initSDKSuccess(IAMPSChannelInitCallBack iAMPSChannelInitCallBack) {
        if (iAMPSChannelInitCallBack != null) {
            iAMPSChannelInitCallBack.successCallBack();
        }
    }
}
