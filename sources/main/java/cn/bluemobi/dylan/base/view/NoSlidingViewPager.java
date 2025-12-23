package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NoSlidingViewPager extends ViewPager {
    private boolean isCanScroll;

    public NoSlidingViewPager(Context context) {
        super(context);
        this.isCanScroll = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i6, boolean z5) {
        super.setCurrentItem(i6, z5);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isCanScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isCanScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i6) {
        super.setCurrentItem(i6);
    }

    public void setScanScroll(boolean z5) {
        this.isCanScroll = z5;
    }

    public NoSlidingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isCanScroll = false;
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        super.scrollTo(i6, i7);
    }
}
