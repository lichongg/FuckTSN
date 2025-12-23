package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<Task> sTaskComparator = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.view;
            if ((recyclerView == null) != (task2.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z5 = task.immediate;
            if (z5 != task2.immediate) {
                return z5 ? -1 : 1;
            }
            int i6 = task2.viewVelocity - task.viewVelocity;
            if (i6 != 0) {
                return i6;
            }
            int i7 = task.distanceToItem - task2.distanceToItem;
            if (i7 != 0) {
                return i7;
            }
            return 0;
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<Task> mTasks = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z5) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (z5) {
                if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
            }
            int i6 = this.mCount;
            if (i6 > layoutManager.mPrefetchMaxCountObserved) {
                layoutManager.mPrefetchMaxCountObserved = i6;
                layoutManager.mPrefetchMaxObservedInInitialPrefetch = z5;
                recyclerView.mRecycler.updateViewCacheSize();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i6, int i7) {
            if (i6 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i7 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i8 = this.mCount;
            int i9 = i8 * 2;
            int[] iArr = this.mPrefetchArray;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.mPrefetchArray = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i9 >= iArr.length) {
                int[] iArr3 = new int[i8 * 4];
                this.mPrefetchArray = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.mPrefetchArray;
            iArr4[i9] = i6;
            iArr4[i9 + 1] = i7;
            this.mCount++;
        }

        void clearPrefetchPositions() {
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mCount = 0;
        }

        boolean lastPrefetchIncludedPosition(int i6) {
            if (this.mPrefetchArray != null) {
                int i7 = this.mCount * 2;
                for (int i8 = 0; i8 < i7; i8 += 2) {
                    if (this.mPrefetchArray[i8] == i6) {
                        return true;
                    }
                }
            }
            return false;
        }

        void setPrefetchVector(int i6, int i7) {
            this.mPrefetchDx = i6;
            this.mPrefetchDy = i7;
        }

        LayoutPrefetchRegistryImpl() {
        }
    }

    private void flushTasksWithDeadline(long j6) {
        for (int i6 = 0; i6 < this.mTasks.size(); i6++) {
            Task task = this.mTasks.get(i6);
            if (task.view == null) {
                return;
            }
            flushTaskWithDeadline(task, j6);
            task.clear();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }

        Task() {
        }
    }

    private void buildTaskList() {
        Task task;
        int size = this.mRecyclerViews.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i7);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i6 += recyclerView.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i9);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                for (int i10 = 0; i10 < layoutPrefetchRegistryImpl.mCount * 2; i10 += 2) {
                    if (i8 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i8);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                    int i11 = iArr[i10 + 1];
                    task.immediate = i11 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i11;
                    task.view = recyclerView2;
                    task.position = iArr[i10];
                    i8++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task task, long j6) {
        RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, task.immediate ? Long.MAX_VALUE : j6);
        if (prefetchPositionWithDeadline == null || prefetchPositionWithDeadline.mNestedRecyclerView == null || !prefetchPositionWithDeadline.isBound() || prefetchPositionWithDeadline.isInvalid()) {
            return;
        }
        prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j6);
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i6) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i7 = 0; i7 < unfilteredChildCount; i7++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i7));
            if (childViewHolderInt.mPosition == i6 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j6) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
        if (layoutPrefetchRegistryImpl.mCount != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.mCount * 2; i6 += 2) {
                    prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i6], j6);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j6 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i6);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j6 = Math.max(recyclerView.getDrawingTime(), j6);
                    }
                }
                if (j6 != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(j6) + this.mFrameIntervalNs);
                }
            }
        } finally {
            this.mPostTimeNs = 0L;
            TraceCompat.endSection();
        }
    }

    GapWorker() {
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i6, long j6) {
        if (isPrefetchPositionAttached(recyclerView, i6)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i6, false, j6);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (tryGetViewHolderForPositionByDeadline.isBound() && !tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                } else {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return tryGetViewHolderForPositionByDeadline;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    void postFromTraversal(RecyclerView recyclerView, int i6, int i7) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i6, i7);
    }

    void prefetch(long j6) {
        buildTaskList();
        flushTasksWithDeadline(j6);
    }
}
