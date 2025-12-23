package xyz.adscope.amps.ad.unified.inter;

import android.app.Activity;
import android.view.View;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSUnifiedNativeItem {
    void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, AMPSUnifiedVideoListener aMPSUnifiedVideoListener);

    void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2);

    void destroy();

    String getActionButtonText();

    AMPSUnifiedPattern getAdPattern();

    String getAdSource();

    View getAdSourceLogo();

    String getAdSourceLogoUrl();

    AMPSAppDetail getAppDetail();

    String getDesc();

    int getECPM();

    Map<String, Object> getExtras();

    String getIconUrl();

    int getImageHeight();

    int getImageWidth();

    List<String> getImagesUrl();

    String getMainImageUrl();

    AMPSUnifiedView getMainImageView();

    List<AMPSUnifiedView> getMainImageViews();

    View getNativeExpressAdView();

    AMPSUnifiedOptimizeController getOptimizeController();

    String getTitle();

    boolean isExpressAd();

    boolean isValid();

    boolean isViewObject();

    void pause();

    void render();

    void resume();

    void setDownloadListener(AMPSUnifiedDownloadListener aMPSUnifiedDownloadListener);

    void setNativeAdEventListener(AMPSUnifiedAdEventListener aMPSUnifiedAdEventListener);

    void setNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener);

    void setNegativeFeedbackListener(AMPSUnifiedNegativeFeedbackListener aMPSUnifiedNegativeFeedbackListener);
}
