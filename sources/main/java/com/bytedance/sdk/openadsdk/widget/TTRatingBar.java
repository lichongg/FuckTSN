package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTRatingBar extends LinearLayout {
    private Drawable ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f31972g;

    /* renamed from: j, reason: collision with root package name */
    private int f31973j;

    /* renamed from: m, reason: collision with root package name */
    private float f31974m;

    /* renamed from: r, reason: collision with root package name */
    private float f31975r;
    private Drawable tl;
    private float up;
    private int xt;

    private void j(Context context) {
        setOrientation(0);
        this.ae = kt.cw(context, "tt_star_empty_bg");
        this.tl = kt.cw(context, "tt_star_full_bg");
        this.f31972g = kt.cw(context, "tt_star_empty_bg");
        this.f31975r = j(context, 15.0f);
        this.up = j(context, 15.0f);
        this.f31974m = j(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f31975r), Math.round(this.up)));
        imageView.setPadding(0, 0, Math.round(this.f31974m), 0);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.ae;
    }

    public int getStarEmptyNum() {
        return this.cw;
    }

    public Drawable getStarFillDrawable() {
        return this.tl;
    }

    public int getStarFillNum() {
        return this.f31973j;
    }

    public Drawable getStarHalfDrawable() {
        return this.f31972g;
    }

    public int getStarHalfNum() {
        return this.xt;
    }

    public float getStarImageHeight() {
        return this.up;
    }

    public float getStarImagePadding() {
        return this.f31974m;
    }

    public float getStarImageWidth() {
        return this.f31975r;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.ae = drawable;
    }

    public void setStarEmptyNum(int i6) {
        this.cw = i6;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.tl = drawable;
    }

    public void setStarFillNum(int i6) {
        this.f31973j = i6;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f31972g = drawable;
    }

    public void setStarHalfNum(int i6) {
        this.xt = i6;
    }

    public void setStarImageHeight(float f6) {
        this.up = f6;
    }

    public void setStarImagePadding(float f6) {
        this.f31974m = f6;
    }

    public void setStarImageWidth(float f6) {
        this.f31975r = f6;
    }

    public TTRatingBar(Context context) {
        super(context);
        this.f31973j = 5;
        this.xt = 0;
        this.cw = 0;
        j(context);
    }

    private int j(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void j() {
        removeAllViews();
        for (int i6 = 0; i6 < getStarFillNum(); i6++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i7 = 0; i7 < getStarHalfNum(); i7++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i8 = 0; i8 < getStarEmptyNum(); i8++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }
}
