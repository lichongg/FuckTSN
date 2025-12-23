package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTDislikeToast extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private Handler f28879j;
    private TextView xt;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void j(Context context) {
        TextView textView = new TextView(context);
        this.xt = textView;
        textView.setClickable(false);
        this.xt.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int j6 = com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(getContext(), 20.0f);
        int j7 = com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(getContext(), 12.0f);
        this.xt.setPadding(j6, j7, j6, j7);
        this.xt.setLayoutParams(layoutParams);
        this.xt.setTextColor(-1);
        this.xt.setTextSize(16.0f);
        this.xt.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(getContext(), 6.0f));
        this.xt.setBackgroundDrawable(gradientDrawable);
        addView(this.xt);
    }

    public void cw() {
        setVisibility(8);
        this.f28879j.removeCallbacksAndMessages(null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f28879j = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        j(context);
    }

    public void xt() {
        try {
            j(kt.j(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public void j(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28879j.removeCallbacksAndMessages(null);
        this.f28879j.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.xt != null) {
                    TTDislikeToast.this.xt.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.f28879j.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void j() {
        j(kt.j(getContext(), "tt_dislike_feedback_success"));
    }
}
