package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener;
import xyz.adscope.ad.publish.ad.nativead.INativeNegativeFeedbackListener;
import xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener;
import xyz.adscope.ad.r2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class o0<T extends r2> implements IBasicNativeAdItem {

    /* renamed from: a, reason: collision with root package name */
    protected final T f55745a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class a implements f4, k3, t3 {

        /* renamed from: a, reason: collision with root package name */
        private INativeExpressListener f55746a;

        /* renamed from: b, reason: collision with root package name */
        private INativeInteractiveListener f55747b;

        /* renamed from: c, reason: collision with root package name */
        private INativeVideoPlayListener f55748c;

        /* renamed from: d, reason: collision with root package name */
        private INativeNegativeFeedbackListener f55749d;

        public void a(INativeExpressListener iNativeExpressListener) {
            this.f55746a = iNativeExpressListener;
        }

        public void a(INativeInteractiveListener iNativeInteractiveListener) {
            this.f55747b = iNativeInteractiveListener;
        }

        @Override // xyz.adscope.ad.x2
        public void onAdClosed() {
            INativeExpressListener iNativeExpressListener = this.f55746a;
            if (iNativeExpressListener != null) {
                iNativeExpressListener.onAdClosed();
            }
        }

        @Override // xyz.adscope.ad.x2
        public void onAdExposure() {
            INativeExpressListener iNativeExpressListener = this.f55746a;
            if (iNativeExpressListener != null) {
                iNativeExpressListener.onAdExposure();
            }
        }

        @Override // xyz.adscope.ad.x2
        public void onAdShown() {
            INativeExpressListener iNativeExpressListener = this.f55746a;
            if (iNativeExpressListener != null) {
                iNativeExpressListener.onAdShown();
            }
        }

        @Override // xyz.adscope.ad.f4
        public void onVideoPlay() {
            INativeVideoPlayListener iNativeVideoPlayListener = this.f55748c;
            if (iNativeVideoPlayListener != null) {
                iNativeVideoPlayListener.onVideoPlay();
            }
        }

        @Override // xyz.adscope.ad.f4
        public void onVideoPlayCompleted() {
            INativeVideoPlayListener iNativeVideoPlayListener = this.f55748c;
            if (iNativeVideoPlayListener != null) {
                iNativeVideoPlayListener.onVideoPlayCompleted();
            }
        }

        @Override // xyz.adscope.ad.f4
        public void onVideoPlayFailed() {
            INativeVideoPlayListener iNativeVideoPlayListener = this.f55748c;
            if (iNativeVideoPlayListener != null) {
                iNativeVideoPlayListener.onVideoPlayFailed();
            }
        }

        protected a() {
        }

        public void a(INativeVideoPlayListener iNativeVideoPlayListener) {
            this.f55748c = iNativeVideoPlayListener;
        }

        public void a(INativeNegativeFeedbackListener iNativeNegativeFeedbackListener) {
            this.f55749d = iNativeNegativeFeedbackListener;
        }

        @Override // xyz.adscope.ad.k3
        public void a() {
            INativeInteractiveListener iNativeInteractiveListener = this.f55747b;
            if (iNativeInteractiveListener != null) {
                iNativeInteractiveListener.onAdClicked();
            }
        }

        @Override // xyz.adscope.ad.t3
        public void a(String str) {
            if (this.f55746a != null) {
                this.f55749d.onNegativeFeedback();
            }
        }
    }

    protected abstract T a(Context context, BidModel bidModel, a2 a2Var, b1 b1Var);

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void destroyAd() {
        T t5 = this.f55745a;
        if (t5 != null) {
            t5.destroyAd();
        }
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public IBidding getBidding() {
        return this.f55745a.getBidding();
    }

    public o0(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        this.f55745a = a(context, bidModel, a2Var, b1Var);
    }
}
