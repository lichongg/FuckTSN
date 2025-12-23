package com.bytedance.adsdk.ugeno.j;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl implements ae {
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    private View f23694j;

    /* renamed from: m, reason: collision with root package name */
    private float f23695m;

    /* renamed from: r, reason: collision with root package name */
    private float f23696r;
    private float up;
    private float xt;

    public void j(float f6) {
        View view = this.f23694j;
        if (view == null) {
            return;
        }
        this.xt = f6;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f6);
        }
    }

    public void cw(float f6) {
        View view = this.f23694j;
        if (view == null) {
            return;
        }
        this.f23696r = f6;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRipple() {
        return this.cw;
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRubIn() {
        return this.f23695m;
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getShine() {
        return this.f23696r;
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getStretch() {
        return this.up;
    }

    public void r(float f6) {
        this.up = f6;
        this.f23694j.postInvalidate();
    }

    public void up(float f6) {
        this.f23695m = f6;
        this.f23694j.postInvalidate();
    }

    public void xt(float f6) {
        View view = this.f23694j;
        if (view == null) {
            return;
        }
        this.cw = f6;
        view.postInvalidate();
    }

    public tl(View view) {
        this.f23694j = view;
    }

    public float j() {
        return this.xt;
    }

    public void j(int i6) {
        View view = this.f23694j;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i6);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i6);
        }
    }
}
