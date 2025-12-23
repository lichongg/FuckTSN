package com.bxkj.student.v2.ui.sports.v3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import androidx.core.content.ContextCompat;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V3AcThreetwooneBinding;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3ThreeTwoOneActivity extends BaseActivity<V3AcThreetwooneBinding, BaseViewModel> {
    private int U = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.g0.p(animation, "animation");
            super.onAnimationEnd(animation);
            V4SportActivity v4SportActivity = (V4SportActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V4SportActivity.class);
            if (v4SportActivity != null) {
                v4SportActivity.P();
            }
            V3ThreeTwoOneActivity.this.finish();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            kotlin.jvm.internal.g0.p(animation, "animation");
            super.onAnimationRepeat(animation);
            V3ThreeTwoOneActivity.this.U--;
            int i6 = V3ThreeTwoOneActivity.this.U;
            if (i6 == 0) {
                V3ThreeTwoOneActivity.this.L().tvNumber.setText("GO");
                n0.a.f50398a.b(V3ThreeTwoOneActivity.this.H(), R.raw.go);
            } else if (i6 == 1) {
                V3ThreeTwoOneActivity.this.L().tvNumber.setText("1");
                n0.a.f50398a.b(V3ThreeTwoOneActivity.this.H(), R.raw.countdown1);
            } else {
                if (i6 != 2) {
                    return;
                }
                V3ThreeTwoOneActivity.this.L().tvNumber.setText("2");
                n0.a.f50398a.b(V3ThreeTwoOneActivity.this.H(), R.raw.countdown2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.g0.p(animation, "animation");
            super.onAnimationStart(animation);
            V3ThreeTwoOneActivity.this.L().tvNumber.setText("3");
            n0.a.f50398a.b(V3ThreeTwoOneActivity.this.H(), R.raw.countdown3);
        }
    }

    private final void M() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(L().tvNumber, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        kotlin.jvm.internal.g0.o(ofPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setRepeatCount(3);
        this.U = 3;
        ofPropertyValuesHolder.addListener(new a());
        ofPropertyValuesHolder.start();
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        int k6 = com.bxkj.base.v2.common.utils.c0.f16887a.k(com.bxkj.student.v2.common.data.i.f20657a.B(), "runType");
        int i6 = k6 != 0 ? k6 != 2 ? R.color.v3_tab_color2_no_translation : R.color.v3_tab_color1_no_translation : R.color.v3_tab_color3_no_translation;
        L().rlThreetwoone.setBackgroundResource(i6);
        com.bxkj.student.common.utils.k.g(this, ContextCompat.getColor(H(), i6));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        M();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
