package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.t.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private ValueAnimator gm;
    private a go;
    private ImageView gp;
    private TextView gq;
    private TextView gr;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void ba();

        void bb();
    }

    public DrawCardH5(Context context) {
        super(context);
        B(context);
    }

    public final void bT() {
        d(0, this.mHeight);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.gp = (ImageView) findViewById(R.id.ksad_card_close);
        this.gq = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.gr = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void bV() {
        d(this.mHeight, 0);
    }

    private void bl() {
        ValueAnimator valueAnimator = this.gm;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.gm.cancel();
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo el = e.el(adTemplate);
        this.go = aVar;
        this.gq.setText(com.kwad.sdk.core.response.b.a.au(el));
        this.gr.setText(com.kwad.sdk.core.response.b.a.aE(el));
        this.gp.setOnClickListener(this);
        this.gr.setOnClickListener(this);
        this.mLogoView.aP(adTemplate);
        setOnClickListener(this);
        this.gq.measure(View.MeasureSpec.makeMeasureSpec((com.kwad.sdk.utils.m.getScreenWidth(this.mContext) - (com.kwad.sdk.c.a.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.c.a.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.c.a.a.a(this.mContext, 100.0f) + this.gq.getMeasuredHeight();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gp) {
            com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (DrawCardH5.this.go != null) {
                        DrawCardH5.this.go.bb();
                    }
                }
            }));
            return;
        }
        bV();
        a aVar = this.go;
        if (aVar != null) {
            aVar.ba();
        }
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    private void d(int i6, int i7) {
        bl();
        ValueAnimator b6 = o.b(this, i6, i7);
        this.gm = b6;
        b6.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gm.setDuration(300L);
        this.gm.start();
    }

    public final void release() {
        bl();
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        B(context);
    }
}
