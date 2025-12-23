package xyz.adscope.amps.inner;

import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSBaseAdAdapterListener<T> {
    void onAdClicked(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdDismiss(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError);

    void onAdLoaded(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdShow(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdShowFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError);
}
