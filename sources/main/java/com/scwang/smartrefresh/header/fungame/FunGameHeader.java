package com.scwang.smartrefresh.header.fungame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.R;
import com.scwang.smartrefresh.layout.util.c;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FunGameHeader extends FunGameBase implements e {

    /* renamed from: l, reason: collision with root package name */
    protected float f37106l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f37107m;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f37108n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f37109o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f37110p;

    /* renamed from: q, reason: collision with root package name */
    private int f37111q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f37112r;

    /* renamed from: s, reason: collision with root package name */
    private String f37113s;

    /* renamed from: t, reason: collision with root package name */
    private String f37114t;

    /* renamed from: u, reason: collision with root package name */
    private int f37115u;

    /* renamed from: v, reason: collision with root package name */
    private int f37116v;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FunGameHeader.this.f37109o.setVisibility(8);
            FunGameHeader.this.f37110p.setVisibility(8);
            FunGameHeader.this.f37108n.setVisibility(8);
            FunGameHeader.this.I();
        }
    }

    public FunGameHeader(Context context) {
        super(context);
        this.f37106l = 1.0f;
        this.f37112r = false;
        this.f37113s = "下拉即将展开";
        this.f37114t = "拖动控制游戏";
        H(context, null);
    }

    public void J() {
        this.f37112r = false;
        TextView textView = this.f37109o;
        textView.setTranslationY(textView.getTranslationY() + this.f37111q);
        TextView textView2 = this.f37110p;
        textView2.setTranslationY(textView2.getTranslationY() - this.f37111q);
        this.f37108n.setAlpha(1.0f);
        this.f37109o.setVisibility(0);
        this.f37110p.setVisibility(0);
        this.f37108n.setVisibility(0);
    }

    private TextView F(Context context, String str, int i6, int i7) {
        TextView textView = new TextView(context);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setBackgroundColor(-1);
        textView.setGravity(i7 | 1);
        textView.setTextSize(0, i6);
        textView.setText(str);
        return textView;
    }

    private void G(long j6) {
        TextView textView = this.f37109o;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), -this.f37111q);
        TextView textView2 = this.f37110p;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", textView2.getTranslationY(), this.f37111q);
        RelativeLayout relativeLayout = this.f37108n;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(relativeLayout, "alpha", relativeLayout.getAlpha(), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(800L);
        animatorSet.setStartDelay(j6);
        animatorSet.start();
        animatorSet.addListener(new a());
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameHeader);
        int i6 = R.styleable.FunGameHeader_fgvMaskTopText;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f37113s = obtainStyledAttributes.getString(i6);
        }
        int i7 = R.styleable.FunGameHeader_fgvMaskBottomText;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.f37114t = obtainStyledAttributes.getString(i7);
        }
        this.f37115u = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        this.f37116v = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        int i8 = R.styleable.FunGameHeader_fgvBottomTextSize;
        this.f37115u = obtainStyledAttributes.getDimensionPixelSize(i8, this.f37115u);
        this.f37116v = obtainStyledAttributes.getDimensionPixelSize(i8, this.f37116v);
        obtainStyledAttributes.recycle();
        this.f37107m = new RelativeLayout(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f37108n = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#3A3A3A"));
        this.f37109o = F(context, this.f37113s, this.f37115u, 80);
        this.f37110p = F(context, this.f37114t, this.f37116v, 48);
        this.f37106l = Math.max(1, c.b(0.5f));
    }

    public void K() {
        if (this.f37112r) {
            return;
        }
        G(200L);
        this.f37112r = true;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    public int d(h hVar, boolean z5) {
        if (!this.f37101g) {
            J();
        }
        return super.d(hVar, z5);
    }

    public void setBottomMaskViewText(String str) {
        this.f37114t = str;
        this.f37110p.setText(str);
    }

    public void setTopMaskViewText(String str) {
        this.f37113s = str;
        this.f37109o.setText(str);
    }

    private void E() {
        if (getChildCount() < 2 && !isInEditMode()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f37096b);
            addView(this.f37108n, layoutParams);
            addView(this.f37107m, layoutParams);
            this.f37111q = (int) (this.f37096b * 0.5f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f37111q);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f37111q);
            layoutParams3.topMargin = this.f37096b - this.f37111q;
            this.f37107m.addView(this.f37109o, layoutParams2);
            this.f37107m.addView(this.f37110p, layoutParams3);
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    public void h(h hVar, int i6, int i7) {
        super.h(hVar, i6, i7);
        K();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    public void q(g gVar, int i6, int i7) {
        super.q(gVar, i6, i7);
        E();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            this.f37109o.setTextColor(iArr[0]);
            this.f37110p.setTextColor(iArr[0]);
            if (iArr.length > 1) {
                this.f37108n.setBackgroundColor(com.scwang.smartrefresh.layout.util.a.A(iArr[1], 200));
                this.f37109o.setBackgroundColor(com.scwang.smartrefresh.layout.util.a.A(iArr[1], 200));
                this.f37110p.setBackgroundColor(com.scwang.smartrefresh.layout.util.a.A(iArr[1], 200));
            }
        }
    }

    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37106l = 1.0f;
        this.f37112r = false;
        this.f37113s = "下拉即将展开";
        this.f37114t = "拖动控制游戏";
        H(context, attributeSet);
    }

    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37106l = 1.0f;
        this.f37112r = false;
        this.f37113s = "下拉即将展开";
        this.f37114t = "拖动控制游戏";
        H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f37106l = 1.0f;
        this.f37112r = false;
        this.f37113s = "下拉即将展开";
        this.f37114t = "拖动控制游戏";
        H(context, attributeSet);
    }

    protected void I() {
    }
}
