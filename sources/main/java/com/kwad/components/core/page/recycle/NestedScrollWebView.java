package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.sdk.core.webview.KsAdWebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int UP;
    private int UQ;
    private final int[] UR;
    private final int[] US;
    private int UT;
    private boolean UU;
    private int UV;
    private int UW;
    private NestedScrollingChildHelper UX;
    private VelocityTracker UY;
    private int UZ;

    public NestedScrollWebView(Context context) {
        super(context);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    private void rF() {
        this.UZ = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.UX = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.UW = viewConfiguration.getScaledMaximumFlingVelocity();
        this.UV = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return this.UX.dispatchNestedFling(f6, f7, z5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return this.UX.dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return this.UX.dispatchNestedPreScroll(i6, i7, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return this.UX.dispatchNestedScroll(i6, i7, i8, i9, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.UX.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.UX.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (this.UZ != 0) {
            i7 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.g((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (com.kwad.components.core.t.d.tc() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.UZ, 1073741824);
        }
        super.onMeasure(i6, i7);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z5 = false;
        if (actionMasked == 0) {
            this.UT = 0;
        }
        if (this.UY == null) {
            this.UY = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y5 = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.UT);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i6 = this.UP - y5;
                    if (dispatchNestedPreScroll(0, i6, this.US, this.UR)) {
                        i6 -= this.US[1];
                        obtain.offsetLocation(0.0f, this.UR[1]);
                        this.UT += this.UR[1];
                    }
                    int scrollY = getScrollY();
                    this.UP = y5 - this.UR[1];
                    int max = Math.max(0, scrollY + i6);
                    int i7 = i6 - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i7, 0, i7, this.UR)) {
                        int i8 = this.UP;
                        int i9 = this.UR[1];
                        this.UP = i8 - i9;
                        obtain.offsetLocation(0.0f, i9);
                        this.UT += this.UR[1];
                    }
                    if (Math.abs(this.US[1]) >= 5 || Math.abs(this.UR[1]) >= 5) {
                        if (!this.UU) {
                            this.UU = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    } else {
                        if (this.UU) {
                            this.UU = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        stopNestedScroll();
                        onTouchEvent = super.onTouchEvent(motionEvent);
                    }
                    onTouchEvent = false;
                }
            }
            this.UY.addMovement(motionEvent);
            this.UY.computeCurrentVelocity(1000, this.UW);
            float f6 = -VelocityTrackerCompat.getYVelocity(this.UY, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f6) > this.UV && !dispatchNestedPreFling(0.0f, f6) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f6, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.UP) < 10.0f) {
                Math.abs(motionEvent.getX() - this.UQ);
            }
            onTouchEvent = onTouchEvent2;
            z5 = true;
        } else {
            this.UP = y5;
            this.UQ = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.US;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.UR;
            iArr2[0] = 0;
            iArr2[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.UU = false;
        }
        if (!z5) {
            this.UY.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z5) {
        this.UX.setNestedScrollingEnabled(z5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i6) {
        return this.UX.startNestedScroll(i6);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.UX.stopNestedScroll();
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        if (!hasFocus()) {
            requestFocus();
        }
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }
}
