package master.flame.danmaku.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;
import java.util.Locale;
import master.flame.danmaku.controller.c;
import master.flame.danmaku.controller.f;
import master.flame.danmaku.controller.g;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.m;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class DanmakuView extends View implements f, g {

    /* renamed from: v, reason: collision with root package name */
    public static final String f50241v = "DanmakuView";

    /* renamed from: w, reason: collision with root package name */
    private static final int f50242w = 50;

    /* renamed from: x, reason: collision with root package name */
    private static final int f50243x = 1000;

    /* renamed from: a, reason: collision with root package name */
    private c.d f50244a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f50245b;

    /* renamed from: c, reason: collision with root package name */
    private c f50246c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50247d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f50248e;

    /* renamed from: f, reason: collision with root package name */
    private f.a f50249f;

    /* renamed from: g, reason: collision with root package name */
    private float f50250g;

    /* renamed from: h, reason: collision with root package name */
    private float f50251h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f50252i;

    /* renamed from: j, reason: collision with root package name */
    private master.flame.danmaku.ui.widget.a f50253j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f50254k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f50255l;

    /* renamed from: m, reason: collision with root package name */
    protected int f50256m;

    /* renamed from: n, reason: collision with root package name */
    private Object f50257n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f50258o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f50259p;

    /* renamed from: q, reason: collision with root package name */
    private long f50260q;

    /* renamed from: r, reason: collision with root package name */
    private LinkedList<Long> f50261r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f50262s;

    /* renamed from: t, reason: collision with root package name */
    private int f50263t;

    /* renamed from: u, reason: collision with root package name */
    private Runnable f50264u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DanmakuView.this.f50246c == null) {
                return;
            }
            DanmakuView.r(DanmakuView.this);
            if (DanmakuView.this.f50263t > 4 || DanmakuView.super.isShown()) {
                DanmakuView.this.f50246c.U();
            } else {
                DanmakuView.this.f50246c.postDelayed(this, DanmakuView.this.f50263t * 100);
            }
        }
    }

    public DanmakuView(Context context) {
        super(context);
        this.f50248e = true;
        this.f50255l = true;
        this.f50256m = 0;
        this.f50257n = new Object();
        this.f50258o = false;
        this.f50259p = false;
        this.f50263t = 0;
        this.f50264u = new a();
        v();
    }

    private synchronized void B() {
        try {
            c cVar = this.f50246c;
            if (cVar == null) {
                return;
            }
            this.f50246c = null;
            C();
            if (cVar != null) {
                cVar.O();
            }
            HandlerThread handlerThread = this.f50245b;
            this.f50245b = null;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
                handlerThread.quit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void x() {
        this.f50262s = true;
        w();
    }

    @SuppressLint({"NewApi"})
    private void y() {
        this.f50259p = true;
        postInvalidateOnAnimation();
    }

    @Override // master.flame.danmaku.controller.f
    public long h() {
        this.f50255l = false;
        c cVar = this.f50246c;
        if (cVar == null) {
            return 0L;
        }
        return cVar.E(true);
    }

    @Override // master.flame.danmaku.controller.f
    public void hide() {
        this.f50255l = false;
        c cVar = this.f50246c;
        if (cVar == null) {
            return;
        }
        cVar.E(false);
    }

    @Override // master.flame.danmaku.controller.f
    public void j(Long l6) {
        this.f50255l = true;
        this.f50262s = false;
        c cVar = this.f50246c;
        if (cVar == null) {
            return;
        }
        cVar.Z(l6);
    }

    @Override // master.flame.danmaku.controller.f
    public void show() {
        j(null);
    }

    @Override // master.flame.danmaku.controller.f
    public void start() {
        start(0L);
    }

    protected synchronized Looper u(int i6) {
        try {
            HandlerThread handlerThread = this.f50245b;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f50245b = null;
            }
            if (i6 == 1) {
                return Looper.getMainLooper();
            }
            int i7 = i6 != 2 ? i6 != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i7, i7);
            this.f50245b = handlerThread2;
            handlerThread2.start();
            return this.f50245b.getLooper();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void C() {
        synchronized (this.f50257n) {
            this.f50258o = true;
            this.f50257n.notifyAll();
        }
    }

    static /* synthetic */ int r(DanmakuView danmakuView) {
        int i6 = danmakuView.f50263t;
        danmakuView.f50263t = i6 + 1;
        return i6;
    }

    private void w() {
        c cVar;
        if (this.f50255l) {
            y();
            synchronized (this.f50257n) {
                while (!this.f50258o && this.f50246c != null) {
                    try {
                        this.f50257n.wait(200L);
                    } catch (InterruptedException unused) {
                        if (!this.f50255l || (cVar = this.f50246c) == null || cVar.I()) {
                            break;
                        } else {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                this.f50258o = false;
            }
        }
    }

    private void z() {
        if (this.f50246c == null) {
            this.f50246c = new c(u(this.f50256m), this, this.f50255l);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void a(d dVar) {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.t(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void b(d dVar, boolean z5) {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.G(dVar, z5);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void c(boolean z5) {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.S(z5);
        }
    }

    @Override // master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean d() {
        return this.f50248e;
    }

    @Override // master.flame.danmaku.controller.f
    public void e() {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.T();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void f(boolean z5) {
        this.f50254k = z5;
    }

    @Override // master.flame.danmaku.controller.f
    public DanmakuContext getConfig() {
        c cVar = this.f50246c;
        if (cVar == null) {
            return null;
        }
        return cVar.z();
    }

    @Override // master.flame.danmaku.controller.f
    public long getCurrentTime() {
        c cVar = this.f50246c;
        if (cVar != null) {
            return cVar.A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public m getCurrentVisibleDanmakus() {
        c cVar = this.f50246c;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.f
    public f.a getOnDanmakuClickListener() {
        return this.f50249f;
    }

    @Override // master.flame.danmaku.controller.f
    public float getXOff() {
        return this.f50250g;
    }

    @Override // master.flame.danmaku.controller.f
    public float getYOff() {
        return this.f50251h;
    }

    @Override // master.flame.danmaku.controller.g
    public long i() {
        if (!this.f50247d) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long b6 = w4.c.b();
        w();
        return w4.c.b() - b6;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPaused() {
        c cVar = this.f50246c;
        if (cVar != null) {
            return cVar.I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPrepared() {
        c cVar = this.f50246c;
        return cVar != null && cVar.H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f
    public boolean isShown() {
        return this.f50255l && super.isShown();
    }

    @Override // master.flame.danmaku.controller.f
    public void k() {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // master.flame.danmaku.controller.g
    public boolean l() {
        return this.f50247d;
    }

    @Override // master.flame.danmaku.controller.f
    public void m(Long l6) {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.V(l6);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void n(f.a aVar, float f6, float f7) {
        this.f50249f = aVar;
        this.f50250g = f6;
        this.f50251h = f7;
    }

    @Override // master.flame.danmaku.controller.f
    public void o(boolean z5) {
        this.f50248e = z5;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f50255l && !this.f50259p) {
            super.onDraw(canvas);
            return;
        }
        if (this.f50262s) {
            master.flame.danmaku.controller.d.a(canvas);
            this.f50262s = false;
        } else {
            c cVar = this.f50246c;
            if (cVar != null) {
                a.c x5 = cVar.x(canvas);
                if (this.f50254k) {
                    if (this.f50261r == null) {
                        this.f50261r = new LinkedList<>();
                    }
                    master.flame.danmaku.controller.d.d(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(t()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(x5.f54730r), Long.valueOf(x5.f54731s)));
                }
            }
        }
        this.f50259p = false;
        C();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean k6 = this.f50253j.k(motionEvent);
        return !k6 ? super.onTouchEvent(motionEvent) : k6;
    }

    @Override // master.flame.danmaku.controller.f
    public void pause() {
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.removeCallbacks(this.f50264u);
            this.f50246c.L();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void resume() {
        c cVar = this.f50246c;
        if (cVar != null && cVar.H()) {
            this.f50263t = 0;
            this.f50246c.post(this.f50264u);
        } else if (this.f50246c == null) {
            A();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setCallback(c.d dVar) {
        this.f50244a = dVar;
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.W(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setDrawingThreadType(int i6) {
        this.f50256m = i6;
    }

    @Override // master.flame.danmaku.controller.f
    public void setOnDanmakuClickListener(f.a aVar) {
        this.f50249f = aVar;
    }

    @Override // master.flame.danmaku.controller.f
    public void start(long j6) {
        c cVar = this.f50246c;
        if (cVar == null) {
            z();
        } else {
            cVar.removeCallbacksAndMessages(null);
        }
        this.f50246c.obtainMessage(1, Long.valueOf(j6)).sendToTarget();
    }

    @Override // master.flame.danmaku.controller.f
    public void toggle() {
        if (this.f50247d) {
            c cVar = this.f50246c;
            if (cVar == null) {
                start();
            } else if (cVar.I()) {
                resume();
            } else {
                pause();
            }
        }
    }

    private float t() {
        long b6 = w4.c.b();
        this.f50261r.addLast(Long.valueOf(b6));
        Long peekFirst = this.f50261r.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = b6 - peekFirst.longValue();
        if (this.f50261r.size() > 50) {
            this.f50261r.removeFirst();
        }
        if (longValue <= 0.0f) {
            return 0.0f;
        }
        return (this.f50261r.size() * 1000) / longValue;
    }

    private void v() {
        this.f50260q = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        master.flame.danmaku.controller.d.f(true, false);
        this.f50253j = master.flame.danmaku.ui.widget.a.j(this);
    }

    public void A() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.g
    public void clear() {
        if (!l()) {
            return;
        }
        if (this.f50255l && Thread.currentThread().getId() != this.f50260q) {
            x();
        } else {
            this.f50262s = true;
            y();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void g(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext) {
        z();
        this.f50246c.X(danmakuContext);
        this.f50246c.Y(aVar);
        this.f50246c.W(this.f50244a);
        this.f50246c.M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        c cVar = this.f50246c;
        if (cVar != null) {
            cVar.J(i8 - i6, i9 - i7);
        }
        this.f50247d = true;
    }

    @Override // master.flame.danmaku.controller.f
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f50261r;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void stop() {
        B();
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50248e = true;
        this.f50255l = true;
        this.f50256m = 0;
        this.f50257n = new Object();
        this.f50258o = false;
        this.f50259p = false;
        this.f50263t = 0;
        this.f50264u = new a();
        v();
    }

    @Override // master.flame.danmaku.controller.f
    public View getView() {
        return this;
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f50248e = true;
        this.f50255l = true;
        this.f50256m = 0;
        this.f50257n = new Object();
        this.f50258o = false;
        this.f50259p = false;
        this.f50263t = 0;
        this.f50264u = new a();
        v();
    }
}
