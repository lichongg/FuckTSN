package com.bxkj.base.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExpandedLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: r, reason: collision with root package name */
    private static final int f16544r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static final int f16545s = 1;

    /* renamed from: t, reason: collision with root package name */
    private static final int f16546t = 100;

    /* renamed from: n, reason: collision with root package name */
    private final int[] f16547n;

    /* renamed from: o, reason: collision with root package name */
    private int f16548o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f16549p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f16550q;

    public ExpandedLinearLayoutManager(Context context) {
        super(context);
        this.f16547n = new int[2];
        this.f16548o = 100;
        this.f16550q = new int[2];
    }

    private void a(RecyclerView.Recycler recycler, int i6, int i7, int i8, int[] iArr) {
        View viewForPosition = recycler.getViewForPosition(i6);
        if (viewForPosition != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            viewForPosition.measure(i7, ViewGroup.getChildMeasureSpec(i8, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
            iArr[0] = viewForPosition.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            iArr[1] = viewForPosition.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            recycler.recycleView(viewForPosition);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(androidx.recyclerview.widget.RecyclerView.Recycler r10, androidx.recyclerview.widget.RecyclerView.State r11, int r12, int r13) {
        /*
            r9 = this;
            android.view.View.MeasureSpec.getMode(r12)
            int r1 = android.view.View.MeasureSpec.getMode(r13)
            android.view.View.MeasureSpec.getSize(r12)
            int r13 = android.view.View.MeasureSpec.getSize(r13)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "state:"
            r0.append(r2)
            java.lang.String r11 = r11.toString()
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.orhanobut.logger.j.c(r11)
            r11 = 0
            r4 = 0
            r8 = 0
        L29:
            int r0 = r9.getItemCount()
            if (r4 >= r0) goto L65
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r11)     // Catch: java.lang.IndexOutOfBoundsException -> L3f
            int[] r7 = r9.f16550q     // Catch: java.lang.IndexOutOfBoundsException -> L3f
            r2 = r9
            r3 = r10
            r5 = r12
            r2.a(r3, r4, r5, r6, r7)     // Catch: java.lang.IndexOutOfBoundsException -> L3c
            goto L47
        L3c:
            r0 = move-exception
        L3d:
            r10 = r0
            goto L44
        L3f:
            r0 = move-exception
            r2 = r9
            r3 = r10
            r5 = r12
            goto L3d
        L44:
            r10.printStackTrace()
        L47:
            int r10 = r9.getOrientation()
            r12 = 1
            if (r10 != 0) goto L57
            int[] r10 = r2.f16550q
            r0 = r10[r11]
            if (r4 != 0) goto L60
            r8 = r10[r12]
            goto L60
        L57:
            int[] r10 = r2.f16550q
            r12 = r10[r12]
            int r8 = r8 + r12
            if (r4 != 0) goto L60
            r10 = r10[r11]
        L60:
            int r4 = r4 + 1
            r10 = r3
            r12 = r5
            goto L29
        L65:
            r2 = r9
            r5 = r12
            r10 = 1073741824(0x40000000, float:2.0)
            if (r1 == r10) goto L6c
            r13 = r8
        L6c:
            r9.setMeasuredDimension(r5, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.ExpandedLinearLayoutManager.onMeasure(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, int):void");
    }

    public ExpandedLinearLayoutManager(Context context, int i6, boolean z5) {
        super(context, i6, z5);
        this.f16547n = new int[2];
        this.f16548o = 100;
        this.f16550q = new int[2];
    }
}
