package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.t.p;
import com.kwad.sdk.utils.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DetailWebRecycleView extends b {
    private int UF;
    private boolean UG;
    private boolean UH;
    private int UI;
    private int UJ;
    private boolean UK;
    a UL;
    private Runnable UM;
    private p UN;
    private int oC;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean rE();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.UL;
        if (aVar != null && aVar.rE()) {
            return true;
        }
        this.UJ = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.UI - this.UJ) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i6) {
        return (i6 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.UH) {
            this.UH = false;
        } else {
            if (this.UG) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z5) {
        this.UG = z5;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z5) {
        this.UH = z5;
    }

    public void setInterceptTouchListener(a aVar) {
        this.UL = aVar;
    }

    public void setTopViewHeight(int i6) {
        this.UI = i6;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.UF = 1000;
        this.UG = false;
        this.UH = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = z.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        z.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.UF));
                    }
                } catch (RuntimeException e6) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                }
            }
        };
        this.UM = runnable;
        this.UN = new p(runnable);
        if (context instanceof Activity) {
            this.oC = com.kwad.sdk.c.a.a.g((Activity) context);
        } else {
            this.oC = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.UN, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.UN);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f6, float f7) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.UJ = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.UI) {
            return false;
        }
        fling((int) f6, (int) f7);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i6, int i7, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.UJ = computeVerticalScrollOffset;
        if (i7 > 0 && computeVerticalScrollOffset < this.UI && !this.UK && computeVerticalScrollOffset < this.oC) {
            scrollBy(0, i7);
            iArr[1] = i7;
        }
        if (i7 < 0 && this.UJ > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i7);
            iArr[1] = i7;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i6) {
        super.onScrollStateChanged(i6);
        if (i6 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.UK = true;
                    return;
                }
            }
            this.UK = false;
        }
    }
}
