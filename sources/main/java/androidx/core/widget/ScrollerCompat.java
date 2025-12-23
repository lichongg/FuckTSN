package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes.dex */
public final class ScrollerCompat {
    OverScroller mScroller;

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    @Deprecated
    public void fling(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.mScroller.fling(i6, i7, i8, i9, i10, i11, i12, i13);
    }

    @Deprecated
    public void startScroll(int i6, int i7, int i8, int i9) {
        this.mScroller.startScroll(i6, i7, i8, i9);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.mScroller.fling(i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i6, int i7, int i8) {
        this.mScroller.notifyHorizontalEdgeReached(i6, i7, i8);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i6, int i7, int i8) {
        this.mScroller.notifyVerticalEdgeReached(i6, i7, i8);
    }

    @Deprecated
    public boolean springBack(int i6, int i7, int i8, int i9, int i10, int i11) {
        return this.mScroller.springBack(i6, i7, i8, i9, i10, i11);
    }

    @Deprecated
    public void startScroll(int i6, int i7, int i8, int i9, int i10) {
        this.mScroller.startScroll(i6, i7, i8, i9, i10);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator != null) {
            overScroller = new OverScroller(context, interpolator);
        } else {
            overScroller = new OverScroller(context);
        }
        this.mScroller = overScroller;
    }
}
