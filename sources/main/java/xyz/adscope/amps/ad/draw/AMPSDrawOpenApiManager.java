package xyz.adscope.amps.ad.draw;

import android.content.Context;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.report.AMPSEventReportCode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSDrawOpenApiManager extends AMPSBaseOpenApiManager implements AMPSDrawAdAdapterListener<AMPSDrawAdExpressInfo> {
    private AMPSDrawLoadEventListener ampsDrawLoadEventListener;

    public AMPSDrawOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSDrawLoadEventListener aMPSDrawLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSDrawLoadEventListener);
        this.ampsDrawLoadEventListener = aMPSDrawLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener
    public void onRender() {
        uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER, "", "", 0L);
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener
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

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener
    public void onRenderSuccess() {
        uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER_SUCCESS, "", "", 0L);
    }
}
