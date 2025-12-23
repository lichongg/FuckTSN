package com.baidu.mobads.sdk.internal.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.baidu.mobads.sdk.internal.av;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11115a = 100;

    /* renamed from: b, reason: collision with root package name */
    private static final float f11116b = 100.0f;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f11117g = av.a((Class<?>) OrientationHelper.class, "getLayoutManager", (Class<?>[]) new Class[0]);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private OrientationHelper f11118c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private RecyclerView.LayoutManager f11119d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private OrientationHelper f11120e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private RecyclerView.LayoutManager f11121f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f11122h;

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, c(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @NonNull
    private OrientationHelper c(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.f11118c == null || this.f11119d != layoutManager) {
            this.f11119d = layoutManager;
            this.f11118c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f11118c;
    }

    @NonNull
    private OrientationHelper d(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (this.f11120e == null || this.f11121f != layoutManager) {
            this.f11121f = layoutManager;
            this.f11120e = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f11120e;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f11122h) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForScrolling(int i6) {
                return Math.min(100, super.calculateTimeForScrolling(i6));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (PagerSnapHelper.this.f11122h == null || PagerSnapHelper.this.f11122h.getLayoutManager() == null) {
                    return;
                }
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f11122h.getLayoutManager(), view);
                int i6 = calculateDistanceToFinalSnap[0];
                int i7 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i6), Math.abs(i7)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i6, i7, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onStop() {
                RecyclerView.LayoutManager layoutManager2;
                super.onStop();
                if (PagerSnapHelper.f11117g && PagerSnapHelper.this.f11122h != null && PagerSnapHelper.this.f11122h.getScrollState() != 0 && (layoutManager2 = PagerSnapHelper.this.f11122h.getLayoutManager()) != null && layoutManager2.getChildCount() <= 1) {
                    PagerSnapHelper.this.f11122h.stopScroll();
                }
            }
        };
    }

    private boolean a(RecyclerView.LayoutManager layoutManager, int i6, int i7) {
        return layoutManager.canScrollHorizontally() ? i6 > 0 : i7 > 0;
    }

    @Nullable
    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return c(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return d(layoutManager);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.f11122h == recyclerView) {
            return;
        }
        this.f11122h = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i6, int i7) {
        OrientationHelper b6;
        int i8;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (b6 = b(layoutManager)) == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        int i9 = Integer.MIN_VALUE;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = layoutManager.getChildAt(i11);
            if (childAt != null) {
                int a6 = a(layoutManager, childAt, b6);
                if (a6 <= 0 && a6 > i9) {
                    view2 = childAt;
                    i9 = a6;
                }
                if (a6 >= 0 && a6 < i10) {
                    view = childAt;
                    i10 = a6;
                }
            }
        }
        boolean a7 = a(layoutManager, i6, i7);
        if (a7 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!a7 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (a7) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        if (a(layoutManager) == a7) {
            i8 = -1;
        } else {
            i8 = 1;
        }
        int i12 = position + i8;
        if (i12 < 0 || i12 >= itemCount) {
            return -1;
        }
        return i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    private int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    @Nullable
    private View a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = layoutManager.getChildAt(i7);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i6) {
                view = childAt;
                i6 = abs;
            }
        }
        return view;
    }
}
