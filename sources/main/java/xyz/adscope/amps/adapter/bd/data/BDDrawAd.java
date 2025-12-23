package xyz.adscope.amps.adapter.bd.data;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.NativeResponse;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.bd.BDDrawAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDDrawAd implements AMPSDrawAdExpressInfo {
    private AMPSDrawAdExpressListener mAmpsDrawAdExpressListener;
    public BDDrawAdapter mBDDrawAdapter;
    public Context mContext;
    private View mDrawView;
    public NativeResponse mNativeResponse;

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void destroy() {
        this.mNativeResponse = null;
        this.mDrawView = null;
        this.mContext = null;
        this.mAmpsDrawAdExpressListener = null;
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public View getDrawView() {
        NativeResponse nativeResponse = this.mNativeResponse;
        if (nativeResponse == null || !nativeResponse.isAdAvailable(this.mContext)) {
            return null;
        }
        return this.mDrawView;
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void render() {
        View renderView = this.mBDDrawAdapter.renderView(this.mNativeResponse);
        this.mDrawView = renderView;
        if (renderView != null) {
            BDDrawAdapter bDDrawAdapter = this.mBDDrawAdapter;
            if (bDDrawAdapter != null) {
                bDDrawAdapter.onRender();
            }
            AMPSDrawAdExpressListener aMPSDrawAdExpressListener = this.mAmpsDrawAdExpressListener;
            if (aMPSDrawAdExpressListener != null) {
                aMPSDrawAdExpressListener.onRenderSuccess(getDrawView(), 0.0f, 0.0f);
                return;
            }
            return;
        }
        BDDrawAdapter bDDrawAdapter2 = this.mBDDrawAdapter;
        if (bDDrawAdapter2 != null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
            bDDrawAdapter2.onRenderFail(new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        }
        AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = this.mAmpsDrawAdExpressListener;
        if (aMPSDrawAdExpressListener2 != null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum2 = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
            aMPSDrawAdExpressListener2.onRenderFail(null, channelErrorEnum2.getErrorMsg(), Integer.parseInt(channelErrorEnum2.getErrorCode()));
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdExpressInfoListener(AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        this.mAmpsDrawAdExpressListener = aMPSDrawAdExpressListener;
        BDDrawAdapter bDDrawAdapter = this.mBDDrawAdapter;
        if (bDDrawAdapter != null) {
            bDDrawAdapter.setAMPSDrawAdExpressListener(aMPSDrawAdExpressListener);
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdVideoListener(AMPSDrawAdVideoListener aMPSDrawAdVideoListener) {
        BDDrawAdapter bDDrawAdapter = this.mBDDrawAdapter;
        if (bDDrawAdapter != null) {
            bDDrawAdapter.setAMPSDrawAdVideoListener(aMPSDrawAdVideoListener);
        }
    }

    public BDDrawAd(NativeResponse nativeResponse, BDDrawAdapter bDDrawAdapter, Context context) {
        this.mNativeResponse = nativeResponse;
        this.mBDDrawAdapter = bDDrawAdapter;
        this.mContext = context;
    }
}
