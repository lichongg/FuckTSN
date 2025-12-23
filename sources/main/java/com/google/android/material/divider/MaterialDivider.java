package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;

    @ColorInt
    private int color;

    @NonNull
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    public void setDividerColor(@ColorInt int i6) {
        if (this.color != i6) {
            this.color = i6;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(i6));
            invalidate();
        }
    }

    public void setDividerInsetEnd(@Px int i6) {
        this.insetEnd = i6;
    }

    public void setDividerInsetStart(@Px int i6) {
        this.insetStart = i6;
    }

    public void setDividerThickness(@Px int i6) {
        if (this.thickness != i6) {
            this.thickness = i6;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.divider.MaterialDivider.DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            com.google.android.material.shape.MaterialShapeDrawable r7 = new com.google.android.material.shape.MaterialShapeDrawable
            r7.<init>()
            r6.dividerDrawable = r7
            int[] r2 = com.google.android.material.R.styleable.MaterialDivider
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialDivider_dividerThickness
            android.content.res.Resources r1 = r6.getResources()
            int r2 = com.google.android.material.R.dimen.material_divider_thickness
            int r1 = r1.getDimensionPixelSize(r2)
            int r9 = r8.getDimensionPixelSize(r9, r1)
            r6.thickness = r9
            int r9 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetStart
            int r9 = r8.getDimensionPixelOffset(r9, r7)
            r6.insetStart = r9
            int r9 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetEnd
            int r7 = r8.getDimensionPixelOffset(r9, r7)
            r6.insetEnd = r7
            int r7 = com.google.android.material.R.styleable.MaterialDivider_dividerColor
            android.content.res.ColorStateList r7 = com.google.android.material.resources.MaterialResources.getColorStateList(r0, r8, r7)
            int r7 = r7.getDefaultColor()
            r6.setDividerColor(r7)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        int i6;
        int width;
        int i7;
        super.onDraw(canvas);
        boolean z5 = true;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            z5 = false;
        }
        if (z5) {
            i6 = this.insetEnd;
        } else {
            i6 = this.insetStart;
        }
        if (z5) {
            width = getWidth();
            i7 = this.insetStart;
        } else {
            width = getWidth();
            i7 = this.insetEnd;
        }
        this.dividerDrawable.setBounds(i6, 0, width - i7, getBottom() - getTop());
        this.dividerDrawable.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i7);
        int measuredHeight = getMeasuredHeight();
        if (mode != Integer.MIN_VALUE && mode != 0) {
            return;
        }
        int i8 = this.thickness;
        if (i8 > 0 && measuredHeight != i8) {
            measuredHeight = i8;
        }
        setMeasuredDimension(getMeasuredWidth(), measuredHeight);
    }

    public void setDividerColorResource(@ColorRes int i6) {
        setDividerColor(ContextCompat.getColor(getContext(), i6));
    }

    public void setDividerInsetEndResource(@DimenRes int i6) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i6));
    }

    public void setDividerInsetStartResource(@DimenRes int i6) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i6));
    }

    public void setDividerThicknessResource(@DimenRes int i6) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i6));
    }
}
