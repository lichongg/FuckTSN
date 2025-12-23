package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ax;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    final RecyclerView Vb;
    final RecyclerView.LayoutManager Vc;

    private View a(int i6, int i7, boolean z5, boolean z6) {
        OrientationHelper createVerticalHelper = this.Vc.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.Vc) : OrientationHelper.createHorizontalHelper(this.Vc);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i8 = i7 > i6 ? 1 : -1;
        while (i6 != i7) {
            View childAt = this.Vc.getChildAt(i6);
            int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i6 += i8;
        }
        return null;
    }

    public final int findFirstVisibleItemPosition() {
        View a6 = a(0, this.Vc.getChildCount(), false, true);
        if (a6 == null) {
            return -1;
        }
        return this.Vb.getChildAdapterPosition(a6);
    }

    public final int findLastVisibleItemPosition() {
        View a6 = a(this.Vc.getChildCount() - 1, -1, false, true);
        if (a6 == null) {
            return -1;
        }
        return this.Vb.getChildAdapterPosition(a6);
    }

    private f(RecyclerView recyclerView) {
        this.Vb = recyclerView;
        this.Vc = recyclerView.getLayoutManager();
    }

    public static f b(RecyclerView recyclerView) {
        ax.checkNotNull(recyclerView);
        return new f(recyclerView);
    }
}
