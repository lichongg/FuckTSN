package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.student.App;
import com.bxkj.student.R;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class CardListMenuItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Paint f20956e = new Paint(1);

    /* renamed from: f, reason: collision with root package name */
    private final int f20957f;

    /* renamed from: g, reason: collision with root package name */
    private final float f20958g;

    /* renamed from: h, reason: collision with root package name */
    private int f20959h;

    /* renamed from: i, reason: collision with root package name */
    private final int f20960i;

    /* renamed from: j, reason: collision with root package name */
    private final int f20961j;

    /* renamed from: k, reason: collision with root package name */
    private final int f20962k;

    private final boolean b(RecyclerView recyclerView, int i6) {
        if (i6 == 0) {
            return true;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemViewType(i6)) : null;
        return !g0.g(valueOf, recyclerView.getAdapter() != null ? Integer.valueOf(r4.getItemViewType(i6 - 1)) : null);
    }

    private final GradientDrawable a(int i6) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i6 == 0) {
            float f6 = this.f20958g;
            fArr = new float[]{f6, f6, f6, f6, f6, f6, f6, f6};
        } else if (i6 == 1) {
            float f7 = this.f20958g;
            fArr = new float[]{f7, f7, f7, f7, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i6 != 2) {
            float f8 = this.f20958g;
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
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null || adapter.getItemViewType(childAdapterPosition) != 0) {
            boolean b6 = b(parent, childAdapterPosition);
            boolean c6 = c(parent, childAdapterPosition);
            if (b6) {
                outRect.top = this.f20957f;
            }
            if (c6) {
                outRect.bottom = this.f20957f;
            } else {
                outRect.bottom = this.f20960i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c6, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Canvas canvas;
        g0.p(c6, "c");
        g0.p(parent, "parent");
        g0.p(state, "state");
        super.onDraw(c6, parent, state);
        int childCount = parent.getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null || adapter.getItemViewType(i6) != 0) {
                View childAt = parent.getChildAt(i6);
                int childAdapterPosition = parent.getChildAdapterPosition(childAt);
                boolean b6 = b(parent, childAdapterPosition);
                boolean c7 = c(parent, childAdapterPosition);
                GradientDrawable a6 = a((b6 && c7) ? 0 : (!b6 || c7) ? (!c7 || b6) ? 2 : 3 : 1);
                a6.setBounds(childAt.getLeft(), !b6 ? childAt.getTop() : childAt.getTop() - this.f20957f, childAt.getLeft() + childAt.getWidth(), childAt.getBottom() + (!c7 ? this.f20960i : this.f20957f));
                a6.draw(c6);
                if (!c7) {
                    this.f20956e.setColor(ContextCompat.getColor(parent.getContext(), this.f20959h));
                    this.f20956e.setStrokeWidth(this.f20960i);
                    canvas = c6;
                    canvas.drawLine(childAt.getLeft() + this.f20961j, childAt.getBottom() + this.f20960i, childAt.getRight() - this.f20962k, childAt.getBottom() + this.f20960i, this.f20956e);
                    i6++;
                    c6 = canvas;
                }
            }
            canvas = c6;
            i6++;
            c6 = canvas;
        }
    }

    public CardListMenuItemDecoration() {
        App.a aVar = App.f17573d;
        this.f20957f = u.a(10.0f, aVar.a());
        this.f20958g = u.a(10.0f, aVar.a());
        this.f20959h = R.color.defaultBackgroundColor;
        this.f20960i = u.a(1.0f, aVar.a());
        this.f20961j = u.a(55.0f, aVar.a());
        this.f20962k = u.a(10.0f, aVar.a());
    }

    private final boolean c(RecyclerView recyclerView, int i6) {
        int i7;
        Integer num;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i7 = adapter.getItemCount() - 1;
        } else {
            i7 = 0;
        }
        if (i6 == i7) {
            return true;
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Integer num2 = null;
        if (adapter2 != null) {
            num = Integer.valueOf(adapter2.getItemViewType(i6));
        } else {
            num = null;
        }
        RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
        if (adapter3 != null) {
            num2 = Integer.valueOf(adapter3.getItemViewType(i6 + 1));
        }
        return !g0.g(num, num2);
    }
}
