package xyz.adscope.ad.publish.ad.banner;

import android.content.Context;
import xyz.adscope.ad.c;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.ad.v3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class BannerAd extends v3<IBannerAdConfig, IAdListener> {
    @Override // xyz.adscope.ad.c2
    protected c b() {
        return c.BANNER;
    }

    public BannerAd(Context context, IBannerAdConfig iBannerAdConfig) {
        super(context, iBannerAdConfig);
    }

    @Override // xyz.adscope.ad.c2
    public String getRequestSessionID() {
        return super.getRequestSessionID();
    }

    public void loadAd(IAdListener iAdListener) {
        super.a((BannerAd) iAdListener);
    }
}
