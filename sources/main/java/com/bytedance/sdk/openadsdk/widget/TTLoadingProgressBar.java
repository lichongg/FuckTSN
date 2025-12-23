package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTLoadingProgressBar extends LinearLayout {
    private View cw;

    /* renamed from: j, reason: collision with root package name */
    private View f31971j;
    private ImageView xt;

    public View getProgressBar() {
        return this.f31971j;
    }

    public ImageView getProgressIcon() {
        return this.xt;
    }

    public void setProgress(int i6) {
        if (this.xt.getVisibility() == 0 && i6 > 3) {
            ((LinearLayout.LayoutParams) this.xt.getLayoutParams()).leftMargin = j(this.f31971j.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f31971j.getLayoutParams();
        float f6 = i6 / 100.0f;
        layoutParams.weight = f6;
        this.f31971j.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cw.getLayoutParams();
        layoutParams2.weight = 1.0f - f6;
        this.cw.setLayoutParams(layoutParams2);
        requestLayout();
    }

    private int j(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
