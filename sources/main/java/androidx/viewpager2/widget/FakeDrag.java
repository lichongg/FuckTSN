package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    private void addFakeMotionEvent(long j6, int i6, float f6, float f7) {
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j6, i6, f6, f7, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    @UiThread
    boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging()) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (!this.mScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    boolean endFakeDrag() {
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.mViewPager.snapToPage();
        return true;
    }

    @UiThread
    boolean fakeDragBy(float f6) {
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        float f7 = this.mRequestedDragDistance - f6;
        this.mRequestedDragDistance = f7;
        int round = Math.round(f7 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z5 = this.mViewPager.getOrientation() == 0;
        int i6 = z5 ? round : 0;
        int i7 = z5 ? 0 : round;
        float f8 = z5 ? this.mRequestedDragDistance : 0.0f;
        float f9 = z5 ? 0.0f : this.mRequestedDragDistance;
        this.mRecyclerView.scrollBy(i6, i7);
        addFakeMotionEvent(uptimeMillis, 2, f8, f9);
        return true;
    }

    boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }
}
