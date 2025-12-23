package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RLRecyclerView extends SwipeRefreshLayout {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f11124a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f11125b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f11126c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f11127d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NormalItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final int f11128a;

        /* renamed from: b, reason: collision with root package name */
        private final int f11129b;

        /* renamed from: c, reason: collision with root package name */
        private final int f11130c;

        /* renamed from: d, reason: collision with root package name */
        private final int f11131d;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.left = this.f11128a;
            rect.top = this.f11129b;
            rect.right = this.f11130c;
            rect.bottom = this.f11131d;
        }

        public NormalItemDecoration(int i6, int i7, int i8, int i9) {
            this.f11128a = i6;
            this.f11129b = i7;
            this.f11130c = i8;
            this.f11131d = i9;
        }
    }

    public RLRecyclerView(Context context) {
        super(context);
        this.f11126c = new int[2];
        this.f11127d = new int[2];
        a(context);
    }

    private void a(Context context) {
        this.f11124a = new RecyclerView(context);
        addView(this.f11124a, new ViewGroup.LayoutParams(-1, -1));
    }

    private int b(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i6 = iArr[0];
        for (int i7 : iArr) {
            if (i7 > i6) {
                i6 = i7;
            }
        }
        return i6;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int[] findVisibleItemPositions() {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView == null) {
            return null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.f11127d[0] = gridLayoutManager.findFirstVisibleItemPosition();
            this.f11127d[1] = gridLayoutManager.findLastVisibleItemPosition();
            return this.f11127d;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.f11127d[0] = linearLayoutManager.findFirstVisibleItemPosition();
            this.f11127d[1] = linearLayoutManager.findLastVisibleItemPosition();
            return this.f11127d;
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return null;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        if (this.f11125b == null) {
            this.f11125b = new int[staggeredGridLayoutManager.getSpanCount()];
        }
        staggeredGridLayoutManager.findFirstVisibleItemPositions(this.f11125b);
        this.f11127d[0] = a(this.f11125b);
        staggeredGridLayoutManager.findLastVisibleItemPositions(this.f11125b);
        this.f11127d[1] = b(this.f11125b);
        return this.f11127d;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        this.f11126c[0] = layoutManager.getItemCount();
        this.f11126c[1] = layoutManager.getChildCount();
        return this.f11126c;
    }

    public View getRvChildAt(int i6) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i6);
        }
        return null;
    }

    public int getRvChildCount() {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(View view) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i6) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i6);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setItemDecoration(int i6, int i7, int i8, int i9) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i6, i7, i8, i9));
        }
    }

    public void setLayoutManager(int i6, int i7, int i8) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            if (1 == i6) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else if (2 == i6) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i7));
            } else if (3 == i6) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i7, i8));
            }
        }
    }

    public void setRecyclerViewPadding(int i6, int i7, int i8, int i9) {
        RecyclerView recyclerView = this.f11124a;
        if (recyclerView != null) {
            recyclerView.setPadding(i6, i7, i8, i9);
        }
    }

    private int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i6 = iArr[0];
        for (int i7 : iArr) {
            if (i7 < i6) {
                i6 = i7;
            }
        }
        return i6;
    }

    public RLRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11126c = new int[2];
        this.f11127d = new int[2];
        a(context);
    }
}
