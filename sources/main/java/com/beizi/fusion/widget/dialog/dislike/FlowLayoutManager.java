package com.beizi.fusion.widget.dialog.dislike;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: e, reason: collision with root package name */
    private static final String f13995e = "FlowLayoutManager";

    /* renamed from: b, reason: collision with root package name */
    protected int f13997b;

    /* renamed from: c, reason: collision with root package name */
    protected int f13998c;

    /* renamed from: f, reason: collision with root package name */
    private int f14000f;

    /* renamed from: g, reason: collision with root package name */
    private int f14001g;

    /* renamed from: h, reason: collision with root package name */
    private int f14002h;

    /* renamed from: i, reason: collision with root package name */
    private int f14003i;

    /* renamed from: a, reason: collision with root package name */
    final FlowLayoutManager f13996a = this;

    /* renamed from: j, reason: collision with root package name */
    private int f14004j = 0;

    /* renamed from: d, reason: collision with root package name */
    protected int f13999d = 0;

    /* renamed from: k, reason: collision with root package name */
    private b f14005k = new b();

    /* renamed from: l, reason: collision with root package name */
    private List<b> f14006l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private SparseArray<Rect> f14007m = new SparseArray<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f14008a;

        /* renamed from: b, reason: collision with root package name */
        View f14009b;

        /* renamed from: c, reason: collision with root package name */
        Rect f14010c;

        public a(int i6, View view, Rect rect) {
            this.f14008a = i6;
            this.f14009b = view;
            this.f14010c = rect;
        }

        public void a(Rect rect) {
            this.f14010c = rect;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        float f14012a;

        /* renamed from: b, reason: collision with root package name */
        float f14013b;

        /* renamed from: c, reason: collision with root package name */
        List<a> f14014c = new ArrayList();

        public void a(float f6) {
            this.f14012a = f6;
        }

        public b() {
        }

        public void a(a aVar) {
            this.f14014c.add(aVar);
        }

        public void b(float f6) {
            this.f14013b = f6;
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.f14004j, getWidth() - getPaddingRight(), this.f14004j + (getHeight() - getPaddingBottom()));
        for (int i6 = 0; i6 < this.f14006l.size(); i6++) {
            b bVar = this.f14006l.get(i6);
            float f6 = bVar.f14012a;
            List<a> list = bVar.f14014c;
            for (int i7 = 0; i7 < list.size(); i7++) {
                View view = list.get(i7).f14009b;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i7).f14010c;
                int i8 = rect.left;
                int i9 = rect.top;
                int i10 = this.f14004j;
                layoutDecoratedWithMargins(view, i8, i9 - i10, rect.right, rect.bottom - i10);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.f13999d = 0;
        int i6 = this.f14001g;
        this.f14005k = new b();
        this.f14006l.clear();
        this.f14007m.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.f14004j = 0;
            return;
        }
        if (getChildCount() == 0 && state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        if (getChildCount() == 0) {
            this.f13997b = getWidth();
            this.f13998c = getHeight();
            this.f14000f = getPaddingLeft();
            this.f14002h = getPaddingRight();
            this.f14001g = getPaddingTop();
            this.f14003i = (this.f13997b - this.f14000f) - this.f14002h;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < getItemCount(); i9++) {
            View viewForPosition = recycler.getViewForPosition(i9);
            if (8 != viewForPosition.getVisibility()) {
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int i10 = i7 + decoratedMeasuredWidth;
                if (i10 <= this.f14003i) {
                    int i11 = this.f14000f + i7;
                    Rect rect = this.f14007m.get(i9);
                    if (rect == null) {
                        rect = new Rect();
                    }
                    rect.set(i11, i6, decoratedMeasuredWidth + i11, i6 + decoratedMeasuredHeight);
                    this.f14007m.put(i9, rect);
                    i8 = Math.max(i8, decoratedMeasuredHeight);
                    this.f14005k.a(new a(decoratedMeasuredHeight, viewForPosition, rect));
                    this.f14005k.a(i6);
                    this.f14005k.b(i8);
                    i7 = i10;
                } else {
                    a();
                    i6 += i8;
                    this.f13999d += i8;
                    int i12 = this.f14000f;
                    Rect rect2 = this.f14007m.get(i9);
                    if (rect2 == null) {
                        rect2 = new Rect();
                    }
                    rect2.set(i12, i6, i12 + decoratedMeasuredWidth, i6 + decoratedMeasuredHeight);
                    this.f14007m.put(i9, rect2);
                    this.f14005k.a(new a(decoratedMeasuredHeight, viewForPosition, rect2));
                    this.f14005k.a(i6);
                    this.f14005k.b(decoratedMeasuredHeight);
                    i7 = decoratedMeasuredWidth;
                    i8 = decoratedMeasuredHeight;
                }
                if (i9 == getItemCount() - 1) {
                    a();
                    this.f13999d += i8;
                }
            }
        }
        this.f13999d = Math.max(this.f13999d, b());
        a(recycler, state);
    }

    private int b() {
        return (this.f13996a.getHeight() - this.f13996a.getPaddingBottom()) - this.f13996a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i6, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i7 = this.f14004j;
        if (i7 + i6 < 0) {
            i6 = -i7;
        } else if (i7 + i6 > this.f13999d - b()) {
            i6 = (this.f13999d - b()) - this.f14004j;
        }
        this.f14004j += i6;
        offsetChildrenVertical(-i6);
        a(recycler, state);
        return i6;
    }

    private void a() {
        List<a> list = this.f14005k.f14014c;
        for (int i6 = 0; i6 < list.size(); i6++) {
            a aVar = list.get(i6);
            int position = getPosition(aVar.f14009b);
            float f6 = this.f14007m.get(position).top;
            b bVar = this.f14005k;
            if (f6 < bVar.f14012a + ((bVar.f14013b - list.get(i6).f14008a) / 2.0f)) {
                Rect rect = this.f14007m.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i7 = this.f14007m.get(position).left;
                b bVar2 = this.f14005k;
                int i8 = (int) (bVar2.f14012a + ((bVar2.f14013b - list.get(i6).f14008a) / 2.0f));
                int i9 = this.f14007m.get(position).right;
                b bVar3 = this.f14005k;
                rect.set(i7, i8, i9, (int) (bVar3.f14012a + ((bVar3.f14013b - list.get(i6).f14008a) / 2.0f) + getDecoratedMeasuredHeight(r3)));
                this.f14007m.put(position, rect);
                aVar.a(rect);
                list.set(i6, aVar);
            }
        }
        b bVar4 = this.f14005k;
        bVar4.f14014c = list;
        this.f14006l.add(bVar4);
        this.f14005k = new b();
    }
}
