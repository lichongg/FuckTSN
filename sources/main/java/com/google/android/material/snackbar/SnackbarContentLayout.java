package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i6, int i7) {
        this.messageView.setAlpha(0.0f);
        long j6 = i7;
        long j7 = i6;
        this.messageView.animate().alpha(1.0f).setDuration(j6).setInterpolator(this.contentInterpolator).setStartDelay(j7).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j6).setInterpolator(this.contentInterpolator).setStartDelay(j7).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i6, int i7) {
        this.messageView.setAlpha(1.0f);
        long j6 = i7;
        long j7 = i6;
        this.messageView.animate().alpha(0.0f).setDuration(j6).setInterpolator(this.contentInterpolator).setStartDelay(j7).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j6).setInterpolator(this.contentInterpolator).setStartDelay(j7).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public void setMaxInlineActionWidth(int i6) {
        this.maxInlineActionWidth = i6;
    }

    void updateActionTextColorAlphaIfNeeded(float f6) {
        if (f6 != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f6));
        }
    }

    private static void updateTopBottomPadding(@NonNull View view, int i6, int i7) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i6, ViewCompat.getPaddingEnd(view), i7);
        } else {
            view.setPadding(view.getPaddingLeft(), i6, view.getPaddingRight(), i7);
        }
    }

    private boolean updateViewsWithinLayout(int i6, int i7, int i8) {
        boolean z5;
        if (i6 != getOrientation()) {
            setOrientation(i6);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.messageView.getPaddingTop() == i7 && this.messageView.getPaddingBottom() == i8) {
            return z5;
        }
        updateTopBottomPadding(this.messageView, i7, i8);
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        boolean z5;
        super.onMeasure(i6, i7);
        if (getOrientation() != 1) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            Layout layout = this.messageView.getLayout();
            if (layout != null && layout.getLineCount() > 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5 && this.maxInlineActionWidth > 0 && this.actionView.getMeasuredWidth() > this.maxInlineActionWidth) {
                if (!updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    return;
                }
            } else {
                if (!z5) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (!updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                    return;
                }
            }
            super.onMeasure(i6, i7);
        }
    }
}
