package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends r {

    /* renamed from: m, reason: collision with root package name */
    private float f25568m;

    /* renamed from: r, reason: collision with root package name */
    private j f25569r;
    private float up;

    private class j {
        private View xt;

        public j(View view) {
            this.xt = view;
        }

        public void j(int i6) {
            if (!"top".equals(oq.this.xt.j())) {
                ViewGroup.LayoutParams layoutParams = this.xt.getLayoutParams();
                layoutParams.height = i6;
                this.xt.setLayoutParams(layoutParams);
                this.xt.requestLayout();
                return;
            }
            if (oq.this.cw instanceof ViewGroup) {
                for (int i7 = 0; i7 < ((ViewGroup) oq.this.cw).getChildCount(); i7++) {
                    ((ViewGroup) oq.this.cw).getChildAt(i7).setTranslationY(i6 - oq.this.up);
                }
            }
            oq oqVar = oq.this;
            oqVar.cw.setTranslationY(oqVar.up - i6);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    List<ObjectAnimator> j() {
        int i6;
        String str;
        View view = this.cw;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicBaseWidget)) {
            this.cw = (View) this.cw.getParent();
        }
        this.cw.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "alpha", 0.0f, 1.0f).setDuration((int) (this.xt.oq() * 1000.0d));
        this.f25569r = new j(this.cw);
        final int i7 = this.cw.getLayoutParams().height;
        this.up = i7;
        this.f25568m = this.cw.getLayoutParams().width;
        if (ScrollClickView.DIR_LEFT.equals(this.xt.j()) || "right".equals(this.xt.j())) {
            i6 = (int) this.f25568m;
            str = "width";
        } else {
            str = "height";
            i6 = i7;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.f25569r, str, 0, i6).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        arrayList.add(j(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.j.oq.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z5) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                oq.this.f25569r.j(i7);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z5) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return arrayList;
    }

    public oq(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
