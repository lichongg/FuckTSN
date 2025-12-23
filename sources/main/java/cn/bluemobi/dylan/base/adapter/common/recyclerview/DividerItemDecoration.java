package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f1150g = {R.attr.listDivider};

    /* renamed from: h, reason: collision with root package name */
    public static final int f1151h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final int f1152i = 1;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f1153e;

    /* renamed from: f, reason: collision with root package name */
    private int f1154f;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i6, RecyclerView recyclerView) {
        if (this.f1154f == 1) {
            rect.set(0, 0, 0, this.f1153e.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f1153e.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.f1154f == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setOrientation(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.f1154f = i6;
    }

    public DividerItemDecoration(Context context, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1150g);
        this.f1153e = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(i6);
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = recyclerView.getChildAt(i6);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            this.f1153e.setBounds(right, paddingTop, this.f1153e.getIntrinsicHeight() + right, height);
            this.f1153e.draw(canvas);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = recyclerView.getChildAt(i6);
            new RecyclerView(recyclerView.getContext());
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f1153e.setBounds(paddingLeft, bottom, width, this.f1153e.getIntrinsicHeight() + bottom);
            this.f1153e.draw(canvas);
        }
    }
}
