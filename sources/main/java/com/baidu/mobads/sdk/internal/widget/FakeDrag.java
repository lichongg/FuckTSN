package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class FakeDrag {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager2 f11105a;

    /* renamed from: b, reason: collision with root package name */
    private final ScrollEventAdapter f11106b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView f11107c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f11108d;

    /* renamed from: e, reason: collision with root package name */
    private int f11109e;

    /* renamed from: f, reason: collision with root package name */
    private float f11110f;

    /* renamed from: g, reason: collision with root package name */
    private int f11111g;

    /* renamed from: h, reason: collision with root package name */
    private long f11112h;

    boolean a() {
        return this.f11106b.g();
    }

    private void d() {
        VelocityTracker velocityTracker = this.f11108d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f11108d = VelocityTracker.obtain();
            this.f11109e = ViewConfiguration.get(this.f11105a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    @UiThread
    boolean a(float f6) {
        if (!this.f11106b.g()) {
            return false;
        }
        float f7 = this.f11110f - f6;
        this.f11110f = f7;
        int round = Math.round(f7 - this.f11111g);
        this.f11111g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z5 = this.f11105a.getOrientation() == 0;
        int i6 = z5 ? round : 0;
        int i7 = z5 ? 0 : round;
        float f8 = z5 ? this.f11110f : 0.0f;
        float f9 = z5 ? 0.0f : this.f11110f;
        this.f11107c.scrollBy(i6, i7);
        a(uptimeMillis, 2, f8, f9);
        return true;
    }

    @UiThread
    boolean b() {
        if (this.f11106b.f()) {
            return false;
        }
        this.f11111g = 0;
        this.f11110f = 0;
        this.f11112h = SystemClock.uptimeMillis();
        d();
        this.f11106b.b();
        if (!this.f11106b.e()) {
            this.f11107c.stopScroll();
        }
        a(this.f11112h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    boolean c() {
        if (!this.f11106b.g()) {
            return false;
        }
        this.f11106b.c();
        VelocityTracker velocityTracker = this.f11108d;
        velocityTracker.computeCurrentVelocity(1000, this.f11109e);
        if (this.f11107c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f11105a.d();
        return true;
    }

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f11105a = viewPager2;
        this.f11106b = scrollEventAdapter;
        this.f11107c = recyclerView;
    }

    private void a(long j6, int i6, float f6, float f7) {
        MotionEvent obtain = MotionEvent.obtain(this.f11112h, j6, i6, f6, f7, 0);
        this.f11108d.addMovement(obtain);
        obtain.recycle();
    }
}
