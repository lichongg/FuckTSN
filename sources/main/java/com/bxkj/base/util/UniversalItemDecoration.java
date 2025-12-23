package com.bxkj.base.util;

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
    private static final String f16561f = "UniversalItemDecoration";

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, b> f16562e = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends b {

        /* renamed from: e, reason: collision with root package name */
        private Paint f16563e;

        /* renamed from: f, reason: collision with root package name */
        public int f16564f = ViewCompat.MEASURED_STATE_MASK;

        @Override // com.bxkj.base.util.UniversalItemDecoration.b
        public void a(Canvas canvas, int i6, int i7, int i8, int i9) {
            this.f16563e.setColor(this.f16564f);
            canvas.drawRect(i6, i7, i8, i9, this.f16563e);
        }

        public a() {
            Paint paint = new Paint(1);
            this.f16563e = paint;
            paint.setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public int f16565a;

        /* renamed from: b, reason: collision with root package name */
        public int f16566b;

        /* renamed from: c, reason: collision with root package name */
        public int f16567c;

        /* renamed from: d, reason: collision with root package name */
        public int f16568d;

        public abstract void a(Canvas canvas, int i6, int i7, int i8, int i9);
    }

    public abstract b a(int i6);

    public static int b(String str, int i6) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i6;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        view.setTag(Integer.valueOf(childAdapterPosition));
        b a6 = a(childAdapterPosition);
        if (a6 != null) {
            rect.set(a6.f16565a, a6.f16567c, a6.f16566b, a6.f16568d);
        }
        this.f16562e.put(Integer.valueOf(childAdapterPosition), a6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Canvas canvas2;
        int i6;
        int i7;
        int i8;
        super.onDraw(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = recyclerView.getChildAt(i9);
            b bVar = this.f16562e.get(Integer.valueOf(b(childAt.getTag().toString(), 0)));
            if (bVar == null) {
                canvas2 = canvas;
            } else {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i10 = bVar.f16568d;
                if (i10 != 0) {
                    canvas2 = canvas;
                    bVar.a(canvas2, left - bVar.f16565a, bottom, right + bVar.f16566b, i10 + bottom);
                    i6 = bottom;
                } else {
                    canvas2 = canvas;
                    i6 = bottom;
                }
                int i11 = bVar.f16567c;
                if (i11 != 0) {
                    bVar.a(canvas2, left - bVar.f16565a, top2 - i11, right + bVar.f16566b, top2);
                    i7 = top2;
                } else {
                    i7 = top2;
                }
                int i12 = bVar.f16565a;
                if (i12 != 0) {
                    i8 = i6;
                    bVar.a(canvas2, left - i12, i7, left, i8);
                } else {
                    i8 = i6;
                }
                int i13 = bVar.f16566b;
                if (i13 != 0) {
                    bVar.a(canvas2, right, i7, right + i13, i8);
                }
            }
            i9++;
            canvas = canvas2;
        }
    }
}
