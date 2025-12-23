package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.t.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAuthorIconView extends FrameLayout implements ca.a {
    private View DQ;
    private View DR;
    private final ca bQ;
    private ViewGroup ej;
    private KSCornerImageView ek;
    private KSCornerImageView el;
    private KSCornerImageView em;
    private KSCornerImageView en;
    private TextView eo;
    private ImageView ep;
    private View eq;
    private View er;
    private View es;
    private View et;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.bQ = new ca(this);
        A(context);
    }

    private static Animator a(View view, int i6) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(create);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(create2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    private void A(@NonNull Context context) {
        m.inflate(context, R.layout.ksad_author_icon, this);
        this.ej = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.el = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.ek = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.em = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.en = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.eo = (TextView) findViewById(R.id.ksad_fans_count);
        this.DR = findViewById(R.id.ksad_fans_hot_icon);
        this.DQ = findViewById(R.id.ksad_author_btn_follow);
        this.ep = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.er = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.eq = findViewById(R.id.ksad_top_layout);
        this.et = findViewById(R.id.ksad_author_icon_layout);
        this.es = findViewById(R.id.ksad_top_flag_layout);
    }

    private static ValueAnimator.AnimatorUpdateListener b(final View view, final boolean z5) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i6 = (int) floatValue;
                    layoutParams.width = i6;
                    if (!z5) {
                        layoutParams.height = i6;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void j(AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        String co = a.co(el);
        if (!TextUtils.isEmpty(co)) {
            KSImageLoader.loadImage(this.el, co, adTemplate);
        }
        int bf = a.bf(el);
        if (a.cR(e.el(adTemplate))) {
            this.eo.setText("直播中");
            this.DR.setVisibility(8);
            this.DQ.setVisibility(8);
            if (bf == 8) {
                this.es.setVisibility(8);
                this.ep.setVisibility(8);
                this.er.setVisibility(0);
            } else {
                this.er.setVisibility(8);
                this.ep.setVisibility(0);
                this.er.setVisibility(8);
            }
        } else {
            this.eo.setText(a.cM(el));
        }
        this.bQ.sendEmptyMessageAtTime(1, 500L);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQ = new ca(this);
        A(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.bQ = new ca(this);
        A(context);
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.bQ = new ca(this);
        A(context);
    }

    private static Animator a(View view, boolean z5) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f6 = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f6);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f6);
        ofFloat.addUpdateListener(b(view, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f6, width);
        ofFloat2.addUpdateListener(b(view, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator a(View view, long j6) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        ofFloat.addUpdateListener(b(view, false));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j6);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public final void a(com.kwad.components.core.widget.e eVar) {
        j.a(eVar, this);
        this.ep.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.em.getBackground());
        a(eVar, this.ek.getBackground());
        a(eVar, this.en.getBackground());
        a(eVar, this.ej.getBackground());
    }

    private void a(com.kwad.components.core.widget.e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.wf());
        }
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator a6 = a((View) this.em, 900L);
        final Animator a7 = a((View) this.en, 1000L);
        final Animator a8 = a((View) this.el, false);
        final Animator a9 = a(this.eq, 500);
        if (a9 != null && a6 != null && a7 != null && a8 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(a8, a6, a7);
            animatorSet.start();
            a8.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a6.start();
                    a7.start();
                    a8.start();
                    a9.start();
                }
            });
            return;
        }
        this.bQ.sendEmptyMessageDelayed(1, 500L);
    }
}
