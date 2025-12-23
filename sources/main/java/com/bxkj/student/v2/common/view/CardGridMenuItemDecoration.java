package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.student.App;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class CardGridMenuItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: e, reason: collision with root package name */
    private final float f20954e;

    /* renamed from: f, reason: collision with root package name */
    private final int f20955f;

    private final boolean b(GridLayoutManager.SpanSizeLookup spanSizeLookup, int i6, int i7) {
        if (1 <= i7) {
            for (int i8 = 1; spanSizeLookup.getSpanSize(i6 - i8) == 1; i8++) {
                if (i8 != i7) {
                }
            }
            return false;
        }
        return true;
    }

    private final GradientDrawable a(int i6) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i6 == 0) {
            float f6 = this.f20954e;
            fArr = new float[]{f6, f6, f6, f6, f6, f6, f6, f6};
        } else if (i6 == 1) {
            float f7 = this.f20954e;
            fArr = new float[]{f7, f7, f7, f7, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i6 != 2) {
            float f8 = this.f20954e;
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f8, f8, f8, f8};
        } else {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        g0.p(outRect, "outRect");
        g0.p(view, "view");
        g0.p(parent, "parent");
        g0.p(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        g0.n(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
        if (spanSizeLookup.getSpanSize(childAdapterPosition) != 1) {
            return;
        }
        int spanCount = gridLayoutManager.getSpanCount();
        g0.m(spanSizeLookup);
        boolean b6 = b(spanSizeLookup, childAdapterPosition, spanCount);
        boolean c6 = c(spanSizeLookup, childAdapterPosition, spanCount);
        if (!b6) {
            outRect.top = this.f20955f;
        }
        if (c6) {
            return;
        }
        outRect.bottom = this.f20955f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c6, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        g0.p(c6, "c");
        g0.p(parent, "parent");
        g0.p(state, "state");
        int childCount = parent.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = parent.getChildAt(i6);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            g0.n(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanSize = spanSizeLookup.getSpanSize(childAdapterPosition);
            int spanIndex = spanSizeLookup.getSpanIndex(childAdapterPosition, spanCount);
            int i7 = 1;
            if (spanSize == 1 && spanIndex == 0) {
                g0.m(spanSizeLookup);
                boolean c7 = c(spanSizeLookup, childAdapterPosition, spanCount);
                boolean b6 = b(spanSizeLookup, childAdapterPosition, spanCount);
                if (b6) {
                    i7 = c7 ? 2 : 3;
                } else if (!c7) {
                    i7 = 0;
                }
                GradientDrawable a6 = a(i7);
                int left = childAt.getLeft();
                int top2 = b6 ? childAt.getTop() : childAt.getTop() - this.f20955f;
                int left2 = childAt.getLeft() + (childAt.getWidth() * spanCount);
                int bottom = childAt.getBottom();
                if (!c7) {
                    bottom += this.f20955f;
                }
                a6.setBounds(left, top2, left2, bottom);
                a6.draw(c6);
            }
        }
    }

    public CardGridMenuItemDecoration() {
        App.a aVar = App.f17573d;
        this.f20954e = u.a(10.0f, aVar.a());
        this.f20955f = u.a(15.0f, aVar.a());
    }

    private final boolean c(GridLayoutManager.SpanSizeLookup spanSizeLookup, int i6, int i7) {
        int spanGroupIndex = spanSizeLookup.getSpanGroupIndex(i6, i7);
        if (1 <= i7) {
            int i8 = 1;
            while (true) {
                int i9 = i6 + i8;
                if (spanSizeLookup.getSpanGroupIndex(i9, i7) != spanGroupIndex) {
                    if (spanSizeLookup.getSpanSize(i9) == 1) {
                        return true;
                    }
                    return false;
                }
                if (i8 == i7) {
                    break;
                }
                i8++;
            }
        }
        return true;
    }
}
