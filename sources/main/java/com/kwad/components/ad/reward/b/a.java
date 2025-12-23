package com.kwad.components.ad.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends d implements View.OnClickListener {
    private TextView fv;
    private final ViewGroup jI;
    private TextView ko;
    private int[] tJ;
    private View tK;
    private ImageView tL;
    private TextView tM;
    private Button tN;

    @Nullable
    private b tO;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.reward.b.a$1, reason: invalid class name */
    final class AnonymousClass1 extends bg {
        final /* synthetic */ r tP;
        final /* synthetic */ long tQ;

        AnonymousClass1(r rVar, long j6) {
            this.tP = rVar;
            this.tQ = j6;
        }

        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            a aVar = a.this;
            final Animator a6 = a.a(aVar, aVar.tK);
            a6.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a6.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.tP.getAdTemplate(), Opcodes.RET, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.tL, AnonymousClass1.this.tQ).start();
                    bw.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.hQ();
                        }
                    }, null, AnonymousClass1.this.tQ);
                }
            });
            a6.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.reward.b.a$a, reason: collision with other inner class name */
    static class C0581a {
        private CharSequence tW;
        private CharSequence tX;
        private CharSequence tY;
        private CharSequence title;

        public final CharSequence Q(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.tW));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        @Nullable
        private static C0581a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0581a(couponInfo);
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence hR() {
            return this.tX;
        }

        public final CharSequence hS() {
            return this.tY;
        }

        private C0581a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.tW = couponInfo.displayValue;
            if (!TextUtils.isEmpty(couponInfo.displayBase)) {
                this.tX = String.format("满%s可用", couponInfo.displayBase);
            } else {
                this.tX = "";
            }
            this.tY = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0581a Q(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(e.el(adTemplate));
            if (cV == null || (list = cV.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(cV.couponList.get(0));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void hT();

        void hU();
    }

    static /* synthetic */ Animator a(a aVar, View view) {
        return o(view);
    }

    private static Animator o(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    static /* synthetic */ Animator a(a aVar, ImageView imageView, long j6) {
        return a(imageView, j6);
    }

    private void d(ViewGroup viewGroup) {
        this.tK = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.tL = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.ko = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.tM = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.fv = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.tN = button;
        button.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ() {
        final Animator p5 = p(this.tK);
        p5.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                p5.removeListener(this);
                if (a.this.tO != null) {
                    a.this.tO.hU();
                }
            }
        });
        p5.start();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.jI;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.tN) || (bVar = this.tO) == null) {
            return;
        }
        bVar.hT();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.tJ = iArr;
        ViewGroup viewGroup2 = (ViewGroup) m.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.jI = viewGroup2;
        d(viewGroup2);
    }

    private Animator p(View view) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        int[] I;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.tJ;
        if (iArr != null && iArr.length >= 2 && (I = com.kwad.sdk.c.a.a.I(view)) != null) {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator = ObjectAnimator.ofFloat(view, "translationX", this.tJ[0] - I[0]);
            objectAnimator2 = ObjectAnimator.ofFloat(view, "translationY", this.tJ[1] - I[1]);
            objectAnimator.setInterpolator(create2);
            objectAnimator2.setInterpolator(create2);
        } else {
            objectAnimator = null;
            objectAnimator2 = null;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator, objectAnimator2);
            return animatorSet2;
        }
        animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        return animatorSet2;
    }

    public final void a(@Nullable b bVar) {
        this.tO = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0581a.Q(rVar.getAdTemplate()));
        this.jI.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.hI()));
    }

    private void a(C0581a c0581a) {
        if (c0581a == null) {
            return;
        }
        TextView textView = this.ko;
        if (textView != null) {
            textView.setText(c0581a.getTitle());
        }
        TextView textView2 = this.tM;
        if (textView2 != null) {
            textView2.setText(c0581a.Q(this.jI.getContext()));
        }
        TextView textView3 = this.fv;
        if (textView3 != null) {
            textView3.setText(c0581a.hR());
        }
        Button button = this.tN;
        if (button != null) {
            button.setText(c0581a.hS());
        }
    }

    private static Animator a(ImageView imageView, long j6) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j6);
        return ofFloat;
    }
}
