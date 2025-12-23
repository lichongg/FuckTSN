package xyz.adscope.ad.publish.ad.video;

import android.content.Context;
import xyz.adscope.ad.c;
import xyz.adscope.ad.s2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class RewardVideoAd extends s2<IRewardVideoConfig, IRewardVideoListener> {
    @Override // xyz.adscope.ad.c2
    protected c b() {
        return c.VIDEO;
    }

    public RewardVideoAd(Context context, IRewardVideoConfig iRewardVideoConfig) {
        super(context, iRewardVideoConfig);
    }

    @Override // xyz.adscope.ad.c2
    public String getRequestSessionID() {
        return super.getRequestSessionID();
    }

    public void loadAd(IRewardVideoListener iRewardVideoListener) {
        super.a((RewardVideoAd) iRewardVideoListener);
    }

    public void showAd(Context context) {
        super.a(context);
    }
}
