package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: j, reason: collision with root package name */
    private List<List<View>> f31963j;
    private List<Integer> xt;

    public FlowLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f31963j = new ArrayList();
        this.xt = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        vl.r("TAG", "onLayout");
        this.f31963j.clear();
        this.xt.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            i11++;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if ((measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) * i11 > (width - getPaddingLeft()) - getPaddingRight()) {
                this.xt.add(Integer.valueOf(i10));
                this.f31963j.add(arrayList);
                i10 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                arrayList = new ArrayList();
                i11 = 1;
            }
            i10 = Math.max(i10, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.xt.add(Integer.valueOf(i10));
        this.f31963j.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f31963j.size();
        for (int i13 = 0; i13 < size; i13++) {
            List<View> list = this.f31963j.get(i13);
            int intValue = this.xt.get(i13).intValue();
            for (int i14 = 0; i14 < list.size(); i14++) {
                View view = list.get(i14);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i15 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i16 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i15, i16, view.getMeasuredWidth() + i15, view.getMeasuredHeight() + i16);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            measureChild(childAt, i6, i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i13 = childCount;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i14 = i11 + measuredWidth;
            if (i14 - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
                i9 = Math.max(i9, i11);
                i10 += i12;
                i11 = measuredWidth;
            } else {
                measuredHeight = Math.max(i12, measuredHeight);
                i11 = i14;
            }
            i12 = measuredHeight;
            if (i8 == i13 - 1) {
                i10 += i12;
                i9 = Math.max(i11, i9);
            }
            i8++;
            childCount = i13;
        }
        vl.r("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
        vl.r("TAG", "width = " + i9 + ", height = " + i10);
        if (mode != 1073741824) {
            size = getPaddingRight() + i9 + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i10 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
