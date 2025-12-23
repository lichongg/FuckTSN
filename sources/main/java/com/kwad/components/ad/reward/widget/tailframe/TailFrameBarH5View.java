package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView gC;
    protected TextView gD;
    protected ValueAnimator lJ;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void lu() {
        if (this.lJ != null) {
            lv();
            this.lJ.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.lJ = ofFloat;
        ofFloat.setDuration(1200L);
        this.lJ.setRepeatCount(-1);
        this.lJ.setRepeatMode(1);
        this.lJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.gD.setScaleY(floatValue);
                TailFrameBarH5View.this.gD.setScaleX(floatValue);
            }
        });
        this.lJ.start();
    }

    public final void g(boolean z5, boolean z6) {
        f(getContext(), z5 ? z6 ? R.layout.ksad_video_tf_bar_h5_portrait_vertical : R.layout.ksad_video_tf_bar_h5_portrait_horizontal : R.layout.ksad_video_tf_bar_h5_landscape);
    }

    public TextView getH5OpenBtn() {
        return this.gD;
    }

    public final void lv() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.lJ.cancel();
        this.lJ.end();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    private void f(Context context, int i6) {
        m.inflate(context, i6, this);
        this.gC = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.gD = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    public final void j(@NonNull AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        this.gC.setText(com.kwad.sdk.core.response.b.a.au(el));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aE(el));
        lu();
    }
}
