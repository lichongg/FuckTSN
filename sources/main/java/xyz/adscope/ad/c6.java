package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.image.loader.IImageFillResult;
import xyz.adscope.common.v2.image.loader.ImageLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c6 extends a6 {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f54931f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements IImageFillResult {
        a() {
        }

        @Override // xyz.adscope.common.v2.image.loader.IImageFillResult
        public void onImageLoadFailed() {
            c6.this.f54931f.setImageResource(R.drawable.asnp_ad_logo);
        }

        @Override // xyz.adscope.common.v2.image.loader.IImageFillResult
        public void onImageLoaded() {
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a(RenderModel renderModel) {
        super.a(renderModel);
    }

    public c6(@NonNull Context context) {
        super(context);
    }

    private void b(ViewModel viewModel) {
        String j6 = viewModel.j();
        if (!TextUtils.isEmpty(j6)) {
            ImageLoader.getInstance().loadPermanentImage(this.f54931f, j6, false, new a());
        } else {
            this.f54931f.setImageResource(R.drawable.asnp_ad_logo);
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        RenderModel renderModel = this.f55727b;
        if (renderModel != null && renderModel.f() != null) {
            a(this.f55727b.f());
            b(this.f55727b.f());
        }
        super.a(aVar);
    }

    private void a(ViewModel viewModel) {
        if (viewModel != null) {
            ImageView imageView = new ImageView(getContext());
            this.f54931f = imageView;
            imageView.setId(1843);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(9);
            addView(this.f54931f, layoutParams);
            String p5 = viewModel.p();
            if (!TextUtils.isEmpty(p5)) {
                i6 i6Var = new i6(getContext());
                i6Var.setTextConfig(viewModel);
                i6Var.setText(p5);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams2.addRule(1, 1843);
                addView(i6Var, layoutParams2);
            }
            setPadding(3, 0, 3, 0);
        }
    }
}
