package com.bxkj.student.common.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class UniversalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: f, reason: collision with root package name */
    private static final String f17784f = "UniversalItemDecoration";

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, b> f17785e = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends b {

        /* renamed from: e, reason: collision with root package name */
        private Paint f17786e;

        /* renamed from: f, reason: collision with root package name */
        public int f17787f = ViewCompat.MEASURED_STATE_MASK;

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration.b
        public void a(Canvas c6, int leftZ, int topZ, int rightZ, int bottomZ) {
            this.f17786e.setColor(this.f17787f);
            c6.drawRect(leftZ, topZ, rightZ, bottomZ, this.f17786e);
        }

        public a() {
            Paint paint = new Paint(1);
            this.f17786e = paint;
            paint.setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public int f17788a;

        /* renamed from: b, reason: collision with root package name */
        public int f17789b;

        /* renamed from: c, reason: collision with root package name */
        public int f17790c;

        /* renamed from: d, reason: collision with root package name */
        public int f17791d;

        public abstract void a(Canvas c6, int leftZ, int topZ, int rightZ, int bottomZ);
    }

    public abstract b a(int position);

    public static int b(String s5, int defValue) {
        try {
            return Integer.parseInt(s5);
        } catch (Exception unused) {
            return defValue;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        b a6 = a(childAdapterPosition);
        if (a6 != null) {
            outRect.set(a6.f17788a, a6.f17790c, a6.f17789b, a6.f17791d);
        }
        this.f17785e.put(Integer.valueOf(childAdapterPosition), a6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c6, RecyclerView parent, RecyclerView.State state) {
        Canvas canvas;
        int i6;
        int i7;
        int i8;
        super.onDraw(c6, parent, state);
        int childCount = parent.getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = parent.getChildAt(i9);
            b bVar = this.f17785e.get(Integer.valueOf(b(childAt.getTag().toString(), 0)));
            if (bVar == null) {
                canvas = c6;
            } else {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i10 = bVar.f17791d;
                if (i10 != 0) {
                    canvas = c6;
                    bVar.a(canvas, left - bVar.f17788a, bottom, right + bVar.f17789b, i10 + bottom);
                    i6 = bottom;
                } else {
                    canvas = c6;
                    i6 = bottom;
                }
                int i11 = bVar.f17790c;
                if (i11 != 0) {
                    bVar.a(canvas, left - bVar.f17788a, top2 - i11, right + bVar.f17789b, top2);
                    i7 = top2;
                } else {
                    i7 = top2;
                }
                int i12 = bVar.f17788a;
                if (i12 != 0) {
                    i8 = i6;
                    bVar.a(canvas, left - i12, i7, left, i8);
                } else {
                    i8 = i6;
                }
                int i13 = bVar.f17789b;
                if (i13 != 0) {
                    bVar.a(canvas, right, i7, right + i13, i8);
                }
            }
            i9++;
            c6 = canvas;
        }
    }
}
