package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.dynamic.r.qv;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTRatingBar2 extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    private static final int f25993g = (qv.xt("", 0.0f, true)[1] / 2) + 1;
    private static final int oq = (qv.xt("", 0.0f, true)[1] / 2) + 3;
    private double ae;
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    LinearLayout f25994j;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f25995m;

    /* renamed from: r, reason: collision with root package name */
    private float f25996r;
    private float tl;
    private Drawable up;
    LinearLayout xt;

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.cw, (int) this.f25996r));
        imageView.setPadding(1, f25993g, 1, oq);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.up;
    }

    public Drawable getStarFillDrawable() {
        return this.f25995m;
    }

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25994j = new LinearLayout(getContext());
        this.xt = new LinearLayout(getContext());
        this.f25994j.setOrientation(0);
        this.f25994j.setGravity(GravityCompat.START);
        this.xt.setOrientation(0);
        this.xt.setGravity(GravityCompat.START);
        this.up = kt.cw(context, "tt_star_thick");
        this.f25995m = kt.cw(context, "tt_star");
    }

    public void j(double d6, int i6, int i7, int i8) {
        float f6 = i7;
        this.cw = (int) tl.cw(getContext(), f6);
        this.f25996r = (int) tl.cw(getContext(), f6);
        this.ae = d6;
        this.tl = i8;
        removeAllViews();
        for (int i9 = 0; i9 < 5; i9++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i6, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.xt.addView(starImageView);
        }
        for (int i10 = 0; i10 < 5; i10++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.f25994j.addView(starImageView2);
        }
        addView(this.f25994j);
        addView(this.xt);
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        this.f25994j.measure(i6, i7);
        double d6 = this.ae;
        float f6 = this.cw;
        this.xt.measure(View.MeasureSpec.makeMeasureSpec((int) ((((int) d6) * f6) + 1.0f + ((f6 - 2.0f) * (d6 - ((int) d6)))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f25994j.getMeasuredHeight(), 1073741824));
        if (this.tl > 0.0f) {
            this.f25994j.setPadding(0, ((int) (r7.getMeasuredHeight() - this.tl)) / 2, 0, 0);
            this.xt.setPadding(0, ((int) (this.f25994j.getMeasuredHeight() - this.tl)) / 2, 0, 0);
        }
    }
}
