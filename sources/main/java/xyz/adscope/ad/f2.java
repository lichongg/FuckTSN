package xyz.adscope.ad;

import android.view.View;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link.LinkModel;
import xyz.adscope.ad.y1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class f2 extends z1 {
    @Override // xyz.adscope.ad.w2
    public void a(View view, int i6) {
        this.f56204a.a(y1.a.AD_CLICK, view);
        NativeModel nativeModel = this.f56207d;
        a(nativeModel != null ? nativeModel.c() : null, view, i6);
    }

    protected abstract void a(LinkModel linkModel, View view, int i6);
}
