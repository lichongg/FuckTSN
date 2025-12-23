package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    private static final String f42937f = "FlowLayout";

    /* renamed from: g, reason: collision with root package name */
    private static final int f42938g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f42939h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final int f42940i = 1;

    /* renamed from: a, reason: collision with root package name */
    protected List<List<View>> f42941a;

    /* renamed from: b, reason: collision with root package name */
    protected List<Integer> f42942b;

    /* renamed from: c, reason: collision with root package name */
    protected List<Integer> f42943c;

    /* renamed from: d, reason: collision with root package name */
    private int f42944d;

    /* renamed from: e, reason: collision with root package name */
    private List<View> f42945e;

    public FlowLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42941a = new ArrayList();
        this.f42942b = new ArrayList();
        this.f42943c = new ArrayList();
        this.f42945e = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f42944d = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        int paddingLeft;
        this.f42941a.clear();
        this.f42942b.clear();
        this.f42943c.clear();
        this.f42945e.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i12 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f42942b.add(Integer.valueOf(i11));
                    this.f42941a.add(this.f42945e);
                    this.f42943c.add(Integer.valueOf(i12));
                    i11 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f42945e = new ArrayList();
                    i12 = 0;
                }
                i12 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i11 = Math.max(i11, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f42945e.add(childAt);
            }
        }
        this.f42942b.add(Integer.valueOf(i11));
        this.f42943c.add(Integer.valueOf(i12));
        this.f42941a.add(this.f42945e);
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f42941a.size();
        for (int i14 = 0; i14 < size; i14++) {
            this.f42945e = this.f42941a.get(i14);
            int intValue = this.f42942b.get(i14).intValue();
            int intValue2 = this.f42943c.get(i14).intValue();
            int i15 = this.f42944d;
            if (i15 != -1) {
                if (i15 == 0) {
                    i10 = (width - intValue2) / 2;
                    paddingLeft = getPaddingLeft();
                } else if (i15 == 1) {
                    i10 = width - intValue2;
                    paddingLeft = getPaddingLeft();
                }
                paddingLeft2 = i10 + paddingLeft;
            } else {
                paddingLeft2 = getPaddingLeft();
            }
            for (int i16 = 0; i16 < this.f42945e.size(); i16++) {
                View view = this.f42945e.get(i16);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i17 = marginLayoutParams2.leftMargin + paddingLeft2;
                    int i18 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i17, i18, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i18);
                    paddingLeft2 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int paddingRight;
        int i8;
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                if (i9 == childCount - 1) {
                    i10 = Math.max(i11, i10);
                    i13 += i12;
                }
                i8 = size;
            } else {
                measureChild(childAt, i6, i7);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i8 = size;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i14 = i11 + measuredWidth;
                if (i14 > (i8 - getPaddingLeft()) - getPaddingRight()) {
                    i10 = Math.max(i10, i11);
                    i13 += i12;
                } else {
                    measuredHeight = Math.max(i12, measuredHeight);
                    measuredWidth = i14;
                }
                if (i9 == childCount - 1) {
                    i10 = Math.max(measuredWidth, i10);
                    i13 += measuredHeight;
                }
                i12 = measuredHeight;
                i11 = measuredWidth;
            }
            i9++;
            size = i8;
        }
        int i15 = size;
        if (mode == 1073741824) {
            paddingRight = i15;
        } else {
            paddingRight = getPaddingRight() + i10 + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i13 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingRight, size2);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
