package xyz.adscope.ad.publish.ad.nativead;

import android.content.Context;
import xyz.adscope.ad.c;
import xyz.adscope.ad.c2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class NativeAd extends c2<INativeAdConfig, INativeAdListener> {
    @Override // xyz.adscope.ad.c2
    protected c b() {
        return c.NATIVE;
    }

    public NativeAd(Context context, INativeAdConfig iNativeAdConfig) {
        super(context, iNativeAdConfig);
    }

    @Override // xyz.adscope.ad.c2
    public String getRequestSessionID() {
        return super.getRequestSessionID();
    }

    public void loadAd(INativeAdListener iNativeAdListener) {
        super.a(iNativeAdListener);
    }
}
