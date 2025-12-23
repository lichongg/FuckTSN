package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.adsdk.ugeno.m.r;
import com.bytedance.adsdk.ugeno.m.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class UGRatingBar extends FrameLayout {
    private Context ae;
    private double cw;

    /* renamed from: j, reason: collision with root package name */
    private float f23843j;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f23844m;

    /* renamed from: r, reason: collision with root package name */
    private float f23845r;
    private cw tl;
    private LinearLayout up;
    private float xt;

    public void j(double d6, int i6, int i7, float f6, int i8) {
        removeAllViews();
        this.up.removeAllViews();
        this.f23844m.removeAllViews();
        this.f23843j = (int) tl.j(this.ae, f6);
        this.xt = (int) tl.j(this.ae, f6);
        this.cw = d6;
        this.f23845r = i8;
        for (int i9 = 0; i9 < 5; i9++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(r.xt(this.ae, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i6, PorterDuff.Mode.SRC_IN);
            this.f23844m.addView(starImageView);
        }
        for (int i10 = 0; i10 < 5; i10++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(r.xt(this.ae, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i7);
            this.up.addView(starImageView2);
        }
        addView(this.up);
        addView(this.f23844m);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.f23843j, (int) this.xt);
        float f6 = this.f23845r;
        layoutParams.leftMargin = (int) f6;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) f6;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.tl;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.tl;
        if (cwVar != null) {
            cwVar.j(i6, i7);
        }
        super.onMeasure(i6, i7);
        this.up.measure(i6, i7);
        double floor = Math.floor(this.cw);
        this.f23844m.measure(View.MeasureSpec.makeMeasureSpec((int) (((r0 + r0 + r2) * floor) + this.f23845r + ((this.cw - floor) * this.f23843j)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.up.getMeasuredHeight(), 1073741824));
    }

    public UGRatingBar(Context context) {
        super(context);
        this.ae = context;
        this.up = new LinearLayout(context);
        this.f23844m = new LinearLayout(context);
        this.up.setOrientation(0);
        this.up.setGravity(GravityCompat.START);
        this.f23844m.setOrientation(0);
        this.f23844m.setGravity(GravityCompat.START);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.tl;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.tl;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        cw cwVar = this.tl;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.tl;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }

    public void j(cw cwVar) {
        this.tl = cwVar;
    }
}
