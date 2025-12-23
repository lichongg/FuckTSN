package xyz.adscope.amps.ad.nativead.adapter;

import android.view.View;
import xyz.adscope.amps.base.AMPSBaseListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSNativeAdExpressListener implements AMPSBaseListener {
    public abstract void onAdClicked();

    public abstract void onAdClosed(View view);

    public abstract void onAdShow();

    public abstract void onRenderFail(View view, String str, int i6);

    public abstract void onRenderSuccess(View view, float f6, float f7);
}
