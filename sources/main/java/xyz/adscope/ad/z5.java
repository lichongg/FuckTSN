package xyz.adscope.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class z5 extends xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c {
    @Override // xyz.adscope.ad.i6
    protected void d() {
        RenderModel renderModel = this.f55254d;
        if (renderModel == null || renderModel.f() == null) {
            return;
        }
        setText(this.f55254d.f().g());
    }

    public z5(@NonNull Context context) {
        super(context);
    }
}
