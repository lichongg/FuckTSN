package xyz.adscope.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.VideoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.amps.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class a extends b {
    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.b
    protected int getDefaultCountDownTime() {
        return 0;
    }

    private void h() {
        setText("");
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.asnp_interaction_icon_close, null));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int min = Math.min(layoutParams.width, layoutParams.height);
        layoutParams.width = min;
        layoutParams.height = min;
        setLayoutParams(layoutParams);
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.b
    protected int getCountDownTime() {
        VideoModel d6;
        AssetModel assetModel = this.f55255e;
        return (assetModel == null || (d6 = assetModel.d()) == null || d6.c() <= 0) ? super.getCountDownTime() : d6.c();
    }

    public a(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.b
    protected void f() {
        h();
        RenderModel renderModel = this.f55254d;
        if (renderModel != null && renderModel.b() != null && this.f55254d.b().l()) {
            super.f();
        }
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.b
    protected void g() {
        h();
    }
}
