package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f extends ViewPager {
    private int bdE;
    private boolean bdF;

    public f(@NonNull Context context) {
        super(context);
        this.bdF = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i6) {
        if (this.bdF) {
            return super.canScrollHorizontally(i6);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.bdF) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x5 = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int i6 = x5 - this.bdE;
            if (getCurrentItem() == 0 && i6 > 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.bdE = x5;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.bdF && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.bdF && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z5) {
        this.bdF = z5;
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdF = false;
    }
}
