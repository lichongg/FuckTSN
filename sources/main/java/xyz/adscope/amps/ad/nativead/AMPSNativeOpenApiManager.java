package xyz.adscope.amps.ad.nativead;

import android.content.Context;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.report.AMPSEventReportCode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSNativeOpenApiManager extends AMPSBaseOpenApiManager implements AMPSNativeAdAdapterListener<AMPSNativeAdExpressInfo> {
    private AMPSNativeLoadEventListener ampsNativeLoadEventListener;

    public AMPSNativeOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSNativeLoadEventListener aMPSNativeLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSNativeLoadEventListener);
        this.ampsNativeLoadEventListener = aMPSNativeLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener
    public void onRender() {
        uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER, "", "", 0L);
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener
    public void onRenderFail(AMPSError aMPSError) {
        String str;
        AdSourceModel winAdSourceModel = getWinAdSourceModel();
        String str2 = "";
        if (winAdSourceModel == null) {
            str = "";
        } else {
            str = winAdSourceModel.getErrorCode();
        }
        if (winAdSourceModel != null) {
            str2 = winAdSourceModel.getErrorMsg();
        }
        uploadLog(winAdSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER_FAIL, str, str2, 0L);
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener
    public void onRenderSuccess() {
        uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER_SUCCESS, "", "", 0L);
    }
}
