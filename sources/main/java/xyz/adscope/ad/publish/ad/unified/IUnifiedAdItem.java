package xyz.adscope.ad.publish.ad.unified;

import android.app.Activity;
import android.view.View;
import java.util.List;
import xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedMediaView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IUnifiedAdItem extends IBasicNativeAdItem {
    void bindAdActionView(List<View> list);

    void bindAdToMediaView(Activity activity, ASNPUnifiedMediaView aSNPUnifiedMediaView);

    void bindAdToRootContainer(Activity activity, ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer, List<View> list);

    void bindNegativeFeedbackView(View view, String[] strArr);

    String getActionButtonText();

    String getAdLogoUrl();

    ASNPUnifiedPattern getAdPattern();

    String getDesc();

    IUnifiedDownloadInfo getDownloadInfo();

    String getIconUrl();

    List<String> getImagesUrl();

    String getMainImageUrl();

    String getTitle();

    boolean isDownloadAd();

    void setBindAdListener(IUnifiedAdBindListener iUnifiedAdBindListener);
}
