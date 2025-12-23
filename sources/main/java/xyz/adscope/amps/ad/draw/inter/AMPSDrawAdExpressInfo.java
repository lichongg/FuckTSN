package xyz.adscope.amps.ad.draw.inter;

import android.view.View;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSDrawAdExpressInfo {
    void destroy();

    View getDrawView();

    void render();

    void setAMPSDrawAdExpressInfoListener(AMPSDrawAdExpressListener aMPSDrawAdExpressListener);

    void setAMPSDrawAdVideoListener(AMPSDrawAdVideoListener aMPSDrawAdVideoListener);
}
