package xyz.adscope.amps.ad.unified;

import java.util.List;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSUnifiedNativeLoadEventListener implements AMPSLoadEventListener {
    public abstract void onAmpsAdFailed(AMPSError aMPSError);

    public abstract void onAmpsAdLoad(List<AMPSUnifiedNativeItem> list);
}
