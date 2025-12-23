package xyz.adscope.amps.ad.unified.inter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSBaseTransformEntry implements AMPSUnifiedNativeItem, AMPSAppDetail, AMPSUnifiedOptimizeController {
    protected int ecpm;
    protected AMPSUnifiedAdEventListener mAdEventListener;
    protected AMPSUnifiedNativeAdapter mAdapter;
    protected Context mContext;
    protected AMPSUnifiedDownloadListener mDownloadListener;
    protected AMPSUnifiedNegativeFeedbackListener mNegativeFeedbackListener;
    protected AMPSVideoConfig mVideoConfig;

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void destroy() {
        this.mContext = null;
        this.mAdapter = null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getActionButtonText() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public AMPSUnifiedPattern getAdPattern() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public View getAdSourceLogo() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getAdSourceLogoUrl() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppDescription() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public AMPSAppDetail getAppDetail() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppDeveloper() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppIconUrl() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppName() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppPackageName() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppPermissionInfo() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppPrice() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppPrivacyPolicy() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppScore() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppSize() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getAppVersion() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getDesc() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
    public String getDownloadCountDesc() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public Map<String, Object> getExtras() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getIconUrl() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public int getImageHeight() {
        return 0;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public int getImageWidth() {
        return 0;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public List<String> getImagesUrl() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getMainImageUrl() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public AMPSUnifiedView getMainImageView() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public List<AMPSUnifiedView> getMainImageViews() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public View getNativeExpressAdView() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public AMPSUnifiedOptimizeController getOptimizeController() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedOptimizeController
    public View getOptimizeShakeView(int i6, int i7) {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedOptimizeController
    public View getOptimizeSlideView(int i6, int i7, int i8) {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getTitle() {
        return null;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public boolean isExpressAd() {
        return false;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public boolean isValid() {
        return false;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public boolean isViewObject() {
        return false;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public String getAdSource() {
        AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter = this.mAdapter;
        if (aMPSUnifiedNativeAdapter == null) {
            return null;
        }
        return aMPSUnifiedNativeAdapter.getSeatId();
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public int getECPM() {
        return this.ecpm;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void setDownloadListener(AMPSUnifiedDownloadListener aMPSUnifiedDownloadListener) {
        this.mDownloadListener = aMPSUnifiedDownloadListener;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void setNativeAdEventListener(AMPSUnifiedAdEventListener aMPSUnifiedAdEventListener) {
        this.mAdEventListener = aMPSUnifiedAdEventListener;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void setNegativeFeedbackListener(AMPSUnifiedNegativeFeedbackListener aMPSUnifiedNegativeFeedbackListener) {
        this.mNegativeFeedbackListener = aMPSUnifiedNegativeFeedbackListener;
    }

    public AMPSBaseTransformEntry(Context context, int i6, AMPSVideoConfig aMPSVideoConfig, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
        if (context != null) {
            this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.ecpm = i6;
        this.mVideoConfig = aMPSVideoConfig;
        this.mAdapter = aMPSUnifiedNativeAdapter;
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void pause() {
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void render() {
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void resume() {
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void setNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
    }

    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
    public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
    }
}
