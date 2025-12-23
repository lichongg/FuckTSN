package com.mcxtzhang.swipemenulib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CstViewPager extends ViewPager {

    /* renamed from: k, reason: collision with root package name */
    private static final String f36354k = "zxt/CstViewPager";

    /* renamed from: i, reason: collision with root package name */
    private int f36355i;

    /* renamed from: j, reason: collision with root package name */
    private int f36356j;

    public CstViewPager(Context context) {
        super(context);
    }

    public CstViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean b(int i6, int i7) {
        return Math.abs(i7 - this.f36356j) < Math.abs(i6 - this.f36355i);
    }

    private boolean j(int i6) {
        return i6 - this.f36355i < 0;
    }

    private boolean k(int i6) {
        return i6 - this.f36355i > 0;
    }

    private boolean h() {
        PagerAdapter adapter = getAdapter();
        if (adapter != null && adapter.getCount() - 1 == getCurrentItem()) {
            return true;
        }
        return false;
    }

    private boolean i() {
        if (getCurrentItem() == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        int x5 = (int) motionEvent.getX();
        int y5 = (int) motionEvent.getY();
        if (motionEvent.getAction() != 2 || !b(x5, y5) || ((i() && k(x5)) || (h() && j(x5)))) {
            z5 = false;
        } else {
            z5 = true;
        }
        this.f36355i = x5;
        this.f36356j = y5;
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (z5 || onInterceptTouchEvent) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
