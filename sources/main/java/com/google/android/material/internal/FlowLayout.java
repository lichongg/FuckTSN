package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int getMeasuredDimension(int i6, int i7, int i8) {
        return i7 != Integer.MIN_VALUE ? i7 != 1073741824 ? i8 : i6 : Math.min(i8, i6);
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    protected int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        int i11 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i11 - getPaddingRight();
        int i12 = paddingTop;
        int i13 = 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i6, i7);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = marginLayoutParams.leftMargin;
                    i9 = marginLayoutParams.rightMargin;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int i15 = paddingLeft;
                if (paddingLeft + i8 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i10 = i15;
                } else {
                    i10 = getPaddingLeft();
                    i12 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i10 + i8 + childAt.getMeasuredWidth();
                int measuredHeight = i12 + childAt.getMeasuredHeight();
                if (measuredWidth > i13) {
                    i13 = measuredWidth;
                }
                paddingLeft = i10 + i8 + i9 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i14 == getChildCount() - 1) {
                    i13 += i9;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i13 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i6) {
        this.itemSpacing = i6;
    }

    protected void setLineSpacing(int i6) {
        this.lineSpacing = i6;
    }

    public void setSingleLine(boolean z5) {
        this.singleLine = z5;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        boolean z6;
        int paddingLeft;
        int paddingRight;
        int i10;
        int i11;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z6) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i12 = (i8 - i6) - paddingRight;
        int i13 = paddingLeft;
        int i14 = paddingTop;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i11 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i10 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                int measuredWidth = i13 + i11 + childAt.getMeasuredWidth();
                if (!this.singleLine && measuredWidth > i12) {
                    i14 = this.lineSpacing + paddingTop;
                    this.rowCount++;
                    i13 = paddingLeft;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int i16 = i13 + i11;
                int measuredWidth2 = childAt.getMeasuredWidth() + i16;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z6) {
                    childAt.layout(i12 - measuredWidth2, i14, (i12 - i13) - i11, measuredHeight);
                } else {
                    childAt.layout(i16, i14, measuredWidth2, measuredHeight);
                }
                i13 += i11 + i10 + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
