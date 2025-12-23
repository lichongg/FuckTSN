package xyz.adscope.ad;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class s6 extends f1 {
    public s6(@NonNull Context context, OptimizeModel optimizeModel) {
        super(context, optimizeModel);
    }

    @Override // xyz.adscope.ad.f1
    public void a() {
        c();
        if (this.f55132c instanceof ViewGroup) {
            ((ViewGroup) this.f55132c).addView(this, new ViewGroup.LayoutParams(1, 1));
        }
    }
}
