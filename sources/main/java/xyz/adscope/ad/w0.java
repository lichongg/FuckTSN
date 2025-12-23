package xyz.adscope.ad;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link.LinkModel;
import xyz.adscope.ad.y1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class w0 extends f2 {
    @Override // xyz.adscope.ad.f2, xyz.adscope.ad.w2
    public void a(View view, int i6) {
        this.f56204a.a(y1.a.AD_CLICK, view);
    }

    @Override // xyz.adscope.ad.f2
    protected void a(LinkModel linkModel, View view, int i6) {
        if (linkModel != null) {
            String d6 = linkModel.d();
            if (TextUtils.isEmpty(d6)) {
                return;
            }
            n4.a(view.getContext(), d6, (Bundle) null);
        }
    }
}
