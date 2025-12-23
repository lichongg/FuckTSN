package xyz.adscope.amps.inner;

import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.base.AMPSBaseBiddingResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSAdBiddingListener {
    void onC2SBiddingFail(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult);

    void onC2SBiddingSuccess(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult);

    void onS2SBiddingFail(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult);

    void onS2SBiddingSuccess(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult);
}
