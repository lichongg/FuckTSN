package xyz.adscope.ad.ad.nativead.basic;

import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener;
import xyz.adscope.ad.publish.ad.nativead.INativeNegativeFeedbackListener;
import xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IBasicNativeAdItem {
    void destroyAd();

    IBidding getBidding();

    void setExpressListener(INativeExpressListener iNativeExpressListener);

    void setInteractiveListener(INativeInteractiveListener iNativeInteractiveListener);

    void setNegativeFeedbackListener(INativeNegativeFeedbackListener iNativeNegativeFeedbackListener);

    void setVideoPlayListener(INativeVideoPlayListener iNativeVideoPlayListener);
}
