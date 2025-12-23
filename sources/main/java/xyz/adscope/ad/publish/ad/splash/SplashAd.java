package xyz.adscope.ad.publish.ad.splash;

import android.content.Context;
import android.view.ViewGroup;
import xyz.adscope.ad.c;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.ad.t2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class SplashAd extends t2<ISplashAdConfig, IAdListener> {
    @Override // xyz.adscope.ad.c2
    protected c b() {
        return c.SPLASH;
    }

    public SplashAd(Context context, ISplashAdConfig iSplashAdConfig) {
        super(context, iSplashAdConfig);
    }

    @Override // xyz.adscope.ad.c2
    public String getRequestSessionID() {
        return super.getRequestSessionID();
    }

    public void loadAd(IAdListener iAdListener) {
        super.a((SplashAd) iAdListener);
    }

    public void showAd(ViewGroup viewGroup) {
        super.setAdContainer(viewGroup);
        super.a(viewGroup.getContext());
    }
}
