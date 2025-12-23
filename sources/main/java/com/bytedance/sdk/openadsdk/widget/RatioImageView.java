package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RatioImageView extends ImageView {

    /* renamed from: j, reason: collision with root package name */
    private float f31964j;

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void setRatio(float f6) {
        this.f31964j = f6;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        int i8 = getLayoutParams().width;
        int i9 = getLayoutParams().height;
        float f6 = this.f31964j;
        if (f6 > 0.0f) {
            if (i8 == -2) {
                size = (int) (size2 * f6);
                mode = 1073741824;
            } else if (i9 == -2) {
                size2 = (int) (size / f6);
                mode2 = 1073741824;
            }
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }
}
