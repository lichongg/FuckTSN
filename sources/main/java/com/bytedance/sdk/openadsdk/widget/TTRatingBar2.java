package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTRatingBar2 extends FrameLayout {
    private int ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f31976g;

    /* renamed from: j, reason: collision with root package name */
    LinearLayout f31977j;

    /* renamed from: m, reason: collision with root package name */
    private int f31978m;
    private Drawable oq;
    private Drawable qv;

    /* renamed from: r, reason: collision with root package name */
    private int f31979r;
    private int tl;
    private double up;
    LinearLayout xt;

    public void j(int i6, int i7) {
        this.cw = i7;
        this.f31979r = i6;
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cw, this.f31979r);
        layoutParams.leftMargin = this.f31978m;
        layoutParams.topMargin = this.ae;
        layoutParams.rightMargin = this.tl;
        layoutParams.bottomMargin = this.f31976g;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public Drawable getEmptyStarDrawable() {
        return this.oq;
    }

    public Drawable getFillStarDrawable() {
        return this.qv;
    }

    public void setRating(double d6) {
        this.up = d6;
    }

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31977j = new LinearLayout(getContext());
        this.xt = new LinearLayout(getContext());
        this.f31977j.setOrientation(0);
        this.f31977j.setGravity(GravityCompat.START);
        this.xt.setOrientation(0);
        this.xt.setGravity(GravityCompat.START);
        this.oq = kt.cw(context, "tt_ratingbar_empty_star2");
        this.qv = kt.cw(context, "tt_ratingbar_full_star2");
    }

    public void j() {
        removeAllViews();
        for (int i6 = 0; i6 < 5; i6++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.xt.addView(starImageView);
        }
        for (int i7 = 0; i7 < 5; i7++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.f31977j.addView(starImageView2);
        }
        addView(this.f31977j);
        addView(this.xt);
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        this.f31977j.measure(i6, i7);
        double floor = Math.floor(this.up);
        int i8 = this.f31978m;
        int i9 = this.tl + i8;
        this.xt.measure(View.MeasureSpec.makeMeasureSpec((int) (((i9 + r2) * floor) + i8 + ((this.up - floor) * this.cw)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f31977j.getMeasuredHeight(), 1073741824));
    }

    public void j(int i6, int i7, int i8, int i9) {
        this.f31978m = i6;
        this.ae = i7;
        this.tl = i8;
        this.f31976g = i9;
    }
}
