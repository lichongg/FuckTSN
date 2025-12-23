package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class BaselineLayout extends ViewGroup {
    private int baseline;

    public BaselineLayout(Context context) {
        super(context, null, 0);
        this.baseline = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.baseline = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i8 - i6) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.baseline != -1 && childAt.getBaseline() != -1) {
                    i10 = (this.baseline + paddingTop) - childAt.getBaseline();
                } else {
                    i10 = paddingTop;
                }
                childAt.layout(i12, i10, measuredWidth + i12, measuredHeight + i10);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i6, i7);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i11 = Math.max(i11, baseline);
                    i12 = Math.max(i12, childAt.getMeasuredHeight() - baseline);
                }
                i9 = Math.max(i9, childAt.getMeasuredWidth());
                i8 = Math.max(i8, childAt.getMeasuredHeight());
                i10 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
            }
        }
        if (i11 != -1) {
            i8 = Math.max(i8, Math.max(i12, getPaddingBottom()) + i11);
            this.baseline = i11;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i9, getSuggestedMinimumWidth()), i6, i10), View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumHeight()), i7, i10 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.baseline = -1;
    }
}
