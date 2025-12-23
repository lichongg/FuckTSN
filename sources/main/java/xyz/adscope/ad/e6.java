package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.status.StatusTitleModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e6 extends xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c implements c4 {

    /* renamed from: h, reason: collision with root package name */
    private boolean f55127h;

    @Override // xyz.adscope.ad.i6
    protected void d() {
        RenderModel renderModel = this.f55254d;
        if (renderModel == null || renderModel.f() == null) {
            super.d();
            return;
        }
        StatusTitleModel l6 = this.f55254d.f().l();
        if (l6 != null) {
            String str = "";
            if (this.f55127h) {
                StatusParamModel a6 = l6.a();
                if (a6 != null) {
                    str = a6.b();
                }
            } else {
                StatusParamModel b6 = l6.b();
                if (b6 != null) {
                    str = b6.b();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setText(str);
        }
    }

    @Override // xyz.adscope.ad.c4
    public void setRenderWithDownload(boolean z5) {
        this.f55127h = z5;
    }

    public e6(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.c4
    public void a(String str) {
    }
}
