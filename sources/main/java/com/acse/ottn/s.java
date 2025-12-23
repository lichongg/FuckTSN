package com.acse.ottn;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s extends ViewPager {

    /* renamed from: g, reason: collision with root package name */
    public static final String f5070g = "AutoViewPager";

    /* renamed from: h, reason: collision with root package name */
    public static final int f5071h = 3000;

    /* renamed from: a, reason: collision with root package name */
    public Timer f5072a;

    /* renamed from: b, reason: collision with root package name */
    public c f5073b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5074c;

    /* renamed from: d, reason: collision with root package name */
    public int f5075d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f5076e;

    /* renamed from: f, reason: collision with root package name */
    public b f5077f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends Handler {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends TimerTask {
        public c() {
        }

        public /* synthetic */ c(s sVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            s.this.f5077f.post(s.this.f5076e);
        }
    }

    public s(Context context) {
        this(context, null);
    }

    public void f() {
        this.f5074c = false;
        Timer timer = this.f5072a;
        if (timer != null) {
            timer.cancel();
            this.f5072a = null;
        }
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5076e = new a();
        this.f5077f = new b(null);
    }

    public void a(s sVar, d0 d0Var) {
        d0Var.a(sVar, d0Var);
    }

    public final void b() {
        this.f5074c = true;
        if (this.f5072a == null) {
            this.f5072a = new Timer();
        }
        this.f5072a.schedule(new c(this, null), 3000L, 3000L);
    }

    public boolean c() {
        return this.f5074c;
    }

    public final void a() {
        int currentItem = getCurrentItem();
        this.f5075d = currentItem;
        if (currentItem == getAdapter().getCount() - 1) {
            this.f5075d = 0;
        } else {
            this.f5075d++;
        }
        setCurrentItem(this.f5075d);
        a(this.f5075d % ((d0) getAdapter()).a());
    }

    public void d() {
        f();
    }

    public void e() {
        g();
    }

    public void g() {
        if (((d0) getAdapter()).a() == 0) {
            return;
        }
        f();
        b();
    }

    public TextView getSubTitle() {
        if (getParent() instanceof AutoScrollViewPager) {
            return ((AutoScrollViewPager) getParent()).getSubTitle();
        }
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            f();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            e();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void b(int i6) {
        a(i6, 0);
    }

    public void a(int i6, int i7) {
        if (getParent() instanceof AutoScrollViewPager) {
            ((AutoScrollViewPager) getParent()).a(i6, i7);
        }
    }

    public void a(int i6) {
        if (getParent() != null && (getParent() instanceof AutoScrollViewPager)) {
            ((AutoScrollViewPager) getParent()).b(i6);
        }
    }
}
