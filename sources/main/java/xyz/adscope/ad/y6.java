package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import xyz.adscope.ad.g3;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.o0;
import xyz.adscope.ad.publish.ad.nativead.INativeAdItem;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener;
import xyz.adscope.ad.publish.ad.nativead.INativeNegativeFeedbackListener;
import xyz.adscope.ad.publish.ad.nativead.INativeRenderListener;
import xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class y6 extends o0<g3> implements INativeAdItem {

    /* renamed from: b, reason: collision with root package name */
    private final b f56194b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends o0.a implements x3 {

        /* renamed from: e, reason: collision with root package name */
        private INativeRenderListener f56195e;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(INativeRenderListener iNativeRenderListener) {
            this.f56195e = iNativeRenderListener;
        }

        @Override // xyz.adscope.ad.x3
        public void a(View view) {
            INativeRenderListener iNativeRenderListener = this.f56195e;
            if (iNativeRenderListener != null) {
                iNativeRenderListener.renderSuccess(view);
            }
        }

        @Override // xyz.adscope.ad.x3
        public void a(k4 k4Var) {
            INativeRenderListener iNativeRenderListener = this.f56195e;
            if (iNativeRenderListener != null) {
                iNativeRenderListener.renderFailed();
            }
        }
    }

    @Override // xyz.adscope.ad.publish.ad.nativead.INativeAdItem
    public View getExpressView() {
        T t5 = this.f55745a;
        if (t5 != 0) {
            return ((g3) t5).getExpressView();
        }
        return null;
    }

    @Override // xyz.adscope.ad.publish.ad.nativead.INativeAdItem
    public void renderAdView(INativeRenderListener iNativeRenderListener) {
        this.f56194b.a(iNativeRenderListener);
        ((g3) this.f55745a).a((x3) this.f56194b);
        ((g3) this.f55745a).a();
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setExpressListener(INativeExpressListener iNativeExpressListener) {
        this.f56194b.a(iNativeExpressListener);
        ((g3) this.f55745a).a((x2) this.f56194b);
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setInteractiveListener(INativeInteractiveListener iNativeInteractiveListener) {
        this.f56194b.a(iNativeInteractiveListener);
        ((g3) this.f55745a).a((k3) this.f56194b);
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setNegativeFeedbackListener(INativeNegativeFeedbackListener iNativeNegativeFeedbackListener) {
        this.f56194b.a(iNativeNegativeFeedbackListener);
        ((g3) this.f55745a).a((t3) this.f56194b);
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setVideoPlayListener(INativeVideoPlayListener iNativeVideoPlayListener) {
        this.f56194b.a(iNativeVideoPlayListener);
        ((g3) this.f55745a).a((f4) this.f56194b);
    }

    public y6(s3 s3Var) {
        super(s3Var.getContext(), s3Var.a(), s3Var.b(), s3Var.c());
        this.f56194b = new b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.ad.o0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g3 a(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        return g3.a.a(context, bidModel, a2Var, b1Var);
    }
}
