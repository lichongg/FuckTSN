package xyz.adscope.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.Collections;
import java.util.List;
import xyz.adscope.ad.h3;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.o0;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener;
import xyz.adscope.ad.publish.ad.nativead.INativeNegativeFeedbackListener;
import xyz.adscope.ad.publish.ad.nativead.INativeVideoPlayListener;
import xyz.adscope.ad.publish.ad.unified.ASNPUnifiedPattern;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdBindListener;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem;
import xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedMediaView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d7 extends o0<h3> implements IUnifiedAdItem {

    /* renamed from: b, reason: collision with root package name */
    private final b f55085b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends o0.a {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public void bindAdActionView(List<View> list) {
        T t5 = this.f55745a;
        if (t5 != 0) {
            ((h3) t5).bindAdActionView(list);
        }
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public void bindAdToMediaView(Activity activity, ASNPUnifiedMediaView aSNPUnifiedMediaView) {
        T t5 = this.f55745a;
        if (t5 != 0) {
            ((h3) t5).bindAdToMediaView(activity, aSNPUnifiedMediaView);
        }
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public void bindAdToRootContainer(Activity activity, ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer, List<View> list) {
        T t5 = this.f55745a;
        if (t5 != 0) {
            ((h3) t5).bindAdToRootContainer(activity, aSNPUnifiedExpressContainer, list);
        }
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public void bindNegativeFeedbackView(View view, String[] strArr) {
        T t5 = this.f55745a;
        if (t5 != 0) {
            ((h3) t5).bindNegativeFeedbackView(view, strArr);
        }
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public String getActionButtonText() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getActionButtonText() : "";
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public String getAdLogoUrl() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getAdLogoUrl() : "";
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public ASNPUnifiedPattern getAdPattern() {
        T t5 = this.f55745a;
        if (t5 != 0) {
            return ((h3) t5).getAdPattern();
        }
        return null;
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public String getDesc() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getDesc() : "";
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public IUnifiedDownloadInfo getDownloadInfo() {
        T t5 = this.f55745a;
        if (t5 != 0) {
            return ((h3) t5).getDownloadInfo();
        }
        return null;
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public String getIconUrl() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getIconUrl() : "";
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public List<String> getImagesUrl() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getImagesUrl() : Collections.EMPTY_LIST;
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public String getMainImageUrl() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getMainImageUrl() : "";
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public String getTitle() {
        T t5 = this.f55745a;
        return t5 != 0 ? ((h3) t5).getTitle() : "";
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public boolean isDownloadAd() {
        T t5 = this.f55745a;
        if (t5 != 0) {
            return ((h3) t5).isDownloadAd();
        }
        return false;
    }

    @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem
    public void setBindAdListener(IUnifiedAdBindListener iUnifiedAdBindListener) {
        T t5 = this.f55745a;
        if (t5 != 0) {
            ((h3) t5).setBindAdListener(iUnifiedAdBindListener);
        }
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setExpressListener(INativeExpressListener iNativeExpressListener) {
        this.f55085b.a(iNativeExpressListener);
        ((h3) this.f55745a).a((x2) this.f55085b);
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setInteractiveListener(INativeInteractiveListener iNativeInteractiveListener) {
        this.f55085b.a(iNativeInteractiveListener);
        ((h3) this.f55745a).a((k3) this.f55085b);
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setNegativeFeedbackListener(INativeNegativeFeedbackListener iNativeNegativeFeedbackListener) {
        this.f55085b.a(iNativeNegativeFeedbackListener);
        ((h3) this.f55745a).a((t3) this.f55085b);
    }

    @Override // xyz.adscope.ad.ad.nativead.basic.IBasicNativeAdItem
    public void setVideoPlayListener(INativeVideoPlayListener iNativeVideoPlayListener) {
        this.f55085b.a(iNativeVideoPlayListener);
        ((h3) this.f55745a).a((f4) this.f55085b);
    }

    public d7(s3 s3Var) {
        super(s3Var.getContext(), s3Var.a(), s3Var.b(), s3Var.c());
        this.f55085b = new b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.ad.o0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h3 a(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        return h3.a.a(context, bidModel, a2Var, b1Var);
    }
}
