package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SplashPlayDefaultInfoView extends FrameLayout {
    private KSCornerImageView IY;
    private ImageView IZ;
    private TextView Ja;
    private TextView fv;
    private TextView ko;

    public SplashPlayDefaultInfoView(@NonNull Context context) {
        super(context);
        ne();
    }

    public final void a(AdTemplate adTemplate, float f6) {
        AdInfo el = e.el(adTemplate);
        a(com.kwad.sdk.core.response.b.a.dn(el) ? c.c(f6) : c.nc());
        this.IY.setRadius(com.kwad.sdk.c.a.a.a(getContext(), r5.nd()));
        KSImageLoader.loadImage(this.IY, com.kwad.sdk.core.response.b.a.co(el), adTemplate);
        this.ko.setText(com.kwad.sdk.core.response.b.a.cl(el));
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.au(el))) {
            this.fv.setVisibility(8);
        } else {
            this.fv.setText(com.kwad.sdk.core.response.b.a.au(el));
        }
    }

    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        ne();
    }

    private void ne() {
        View.inflate(getContext(), R.layout.ksad_play_card_default_info, this);
        this.IY = (KSCornerImageView) findViewById(R.id.ksad_splash_default_icon);
        this.ko = (TextView) findViewById(R.id.ksad_splash_default_title);
        this.IZ = (ImageView) findViewById(R.id.ksad_splash_default_img);
        this.fv = (TextView) findViewById(R.id.ksad_splash_default_desc);
        this.Ja = (TextView) findViewById(R.id.ksad_splash_default_tips);
    }

    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        ne();
    }

    @RequiresApi(api = 21)
    public SplashPlayDefaultInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        ne();
    }

    private void a(c cVar) {
        ak.a(this, cVar.W(getContext()));
        ak.a(this.IY, cVar.X(getContext()));
        ak.a(this.ko, cVar.Y(getContext()));
        ak.a(this.IZ, cVar.Z(getContext()));
        ak.a(this.fv, cVar.aa(getContext()));
        ak.a(this.Ja, cVar.ab(getContext()));
        this.ko.setTextSize(0, cVar.ac(getContext()));
        this.fv.setTextSize(0, cVar.ad(getContext()));
        this.Ja.setTextSize(0, cVar.ae(getContext()));
    }
}
