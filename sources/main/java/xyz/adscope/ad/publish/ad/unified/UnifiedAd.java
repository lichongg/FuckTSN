package xyz.adscope.ad.publish.ad.unified;

import android.content.Context;
import xyz.adscope.ad.c;
import xyz.adscope.ad.c2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UnifiedAd extends c2<IUnifiedAdConfig, IUnifiedAdListener> {
    @Override // xyz.adscope.ad.c2
    protected c b() {
        return c.UNIFIED;
    }

    public UnifiedAd(Context context, IUnifiedAdConfig iUnifiedAdConfig) {
        super(context, iUnifiedAdConfig);
    }

    @Override // xyz.adscope.ad.c2
    public String getRequestSessionID() {
        return super.getRequestSessionID();
    }

    public void loadAd(IUnifiedAdListener iUnifiedAdListener) {
        super.a(iUnifiedAdListener);
    }
}
