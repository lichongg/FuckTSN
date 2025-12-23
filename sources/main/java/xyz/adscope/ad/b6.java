package xyz.adscope.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b6 extends o6 implements j3 {
    @Override // xyz.adscope.ad.j3
    public void a(i3 i3Var) {
        RenderModel renderModel = this.f55757b;
        if (renderModel == null || renderModel.b() == null) {
            return;
        }
        i3Var.a((i3) this.f55757b.b());
    }

    @Override // xyz.adscope.ad.j3
    public String getActionType() {
        RenderModel renderModel = this.f55757b;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f55757b.b().e();
    }

    @Override // xyz.adscope.ad.j3
    public String getInteractionType() {
        RenderModel renderModel = this.f55757b;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f55757b.b().a();
    }

    public b6(@NonNull Context context) {
        super(context);
    }
}
