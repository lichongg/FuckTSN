package xyz.adscope.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.List;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.publish.ad.unified.ASNPUnifiedPattern;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdBindListener;
import xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedMediaView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface h3 extends r2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static h3 a(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
            return new m4(context, bidModel, a2Var, b1Var);
        }
    }

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
