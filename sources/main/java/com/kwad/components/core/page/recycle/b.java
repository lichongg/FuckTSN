package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends g {
    private boolean UA;
    private int UB;
    private a UC;
    private boolean UD;
    private boolean UE;
    private Rect Ux;
    private int Uy;
    private int Uz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean rD();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i6, int i7, int i8) {
        while (true) {
            if (this.UB == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.UB = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i6 >= findFirstVisibleItemPosition && i6 <= findLastVisibleItemPosition) {
                int i9 = i6 - findFirstVisibleItemPosition;
                if (getChildCount() > i9) {
                    int[] iArr2 = new int[2];
                    getChildAt(i9).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.UB) - i8);
                    return;
                }
                return;
            }
            if (i6 > findLastVisibleItemPosition) {
                scrollBy(0, i7);
                a(i6, i7, i8);
                return;
            }
            scrollBy(0, -i7);
        }
    }

    private void rB() {
        Rect rect = this.Ux;
        if (rect == null) {
            this.Ux = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0) {
                this.Ux.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Uy != 0) {
            rB();
            Rect rect = this.Ux;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Ux);
                canvas.drawColor(this.Uy);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.UD) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.UE) {
            stopScroll();
        }
        a aVar = this.UC;
        if (aVar == null || !aVar.rD()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.UD) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i6) {
        if (this.UA) {
            scrollToPositionWithOffset(i6, 0);
        } else {
            super.scrollToPosition(i6);
        }
    }

    public void setDisableScroll(boolean z5) {
        this.UD = z5;
    }

    public void setDownStop(boolean z5) {
        this.UE = z5;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.UC = aVar;
    }

    public void setUnderneathColor(int i6) {
        this.Uy = i6;
        rB();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z5) {
        this.UA = z5;
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.UB = Integer.MIN_VALUE;
        this.UE = false;
    }

    private void rC() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).rG();
        }
    }

    private void scrollToPositionWithOffset(int i6, int i7) {
        a(i6, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rC();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i6, int i7) {
        int size = View.MeasureSpec.getSize(i7);
        int i8 = this.Uz;
        if (i8 > 0 && i8 < size) {
            i7 = View.MeasureSpec.makeMeasureSpec(this.Uz, View.MeasureSpec.getMode(i7));
        }
        super.onMeasure(i6, i7);
    }
}
