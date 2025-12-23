package master.flame.danmaku.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.LinkedList;
import java.util.Locale;
import master.flame.danmaku.controller.c;
import master.flame.danmaku.controller.d;
import master.flame.danmaku.controller.f;
import master.flame.danmaku.controller.g;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class DanmakuSurfaceView extends SurfaceView implements f, g, SurfaceHolder.Callback {

    /* renamed from: o, reason: collision with root package name */
    public static final String f50208o = "DanmakuSurfaceView";

    /* renamed from: p, reason: collision with root package name */
    private static final int f50209p = 50;

    /* renamed from: q, reason: collision with root package name */
    private static final int f50210q = 1000;

    /* renamed from: a, reason: collision with root package name */
    private c.d f50211a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceHolder f50212b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f50213c;

    /* renamed from: d, reason: collision with root package name */
    private c f50214d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f50215e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f50216f;

    /* renamed from: g, reason: collision with root package name */
    private f.a f50217g;

    /* renamed from: h, reason: collision with root package name */
    private float f50218h;

    /* renamed from: i, reason: collision with root package name */
    private float f50219i;

    /* renamed from: j, reason: collision with root package name */
    private a f50220j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f50221k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f50222l;

    /* renamed from: m, reason: collision with root package name */
    protected int f50223m;

    /* renamed from: n, reason: collision with root package name */
    private LinkedList<Long> f50224n;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.f50216f = true;
        this.f50222l = true;
        this.f50223m = 0;
        r();
    }

    private void r() {
        setZOrderMediaOverlay(true);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        SurfaceHolder holder = getHolder();
        this.f50212b = holder;
        holder.addCallback(this);
        this.f50212b.setFormat(-2);
        d.f(true, true);
        this.f50220j = a.j(this);
    }

    private synchronized void u() {
        try {
            c cVar = this.f50214d;
            if (cVar != null) {
                cVar.O();
                this.f50214d = null;
            }
            HandlerThread handlerThread = this.f50213c;
            this.f50213c = null;
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

    @Override // master.flame.danmaku.controller.f
    public long h() {
        this.f50222l = false;
        c cVar = this.f50214d;
        if (cVar == null) {
            return 0L;
        }
        return cVar.E(true);
    }

    @Override // master.flame.danmaku.controller.f
    public void hide() {
        this.f50222l = false;
        c cVar = this.f50214d;
        if (cVar == null) {
            return;
        }
        cVar.E(false);
    }

    @Override // android.view.View, master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public void j(Long l6) {
        this.f50222l = true;
        c cVar = this.f50214d;
        if (cVar == null) {
            return;
        }
        cVar.Z(l6);
    }

    protected synchronized Looper q(int i6) {
        try {
            HandlerThread handlerThread = this.f50213c;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f50213c = null;
            }
            if (i6 == 1) {
                return Looper.getMainLooper();
            }
            int i7 = i6 != 2 ? i6 != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i7, i7);
            this.f50213c = handlerThread2;
            handlerThread2.start();
            return this.f50213c.getLooper();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void show() {
        j(null);
    }

    @Override // master.flame.danmaku.controller.f
    public void start() {
        start(0L);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f50215e = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.a(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f50215e = false;
    }

    private void s() {
        if (this.f50214d == null) {
            this.f50214d = new c(q(this.f50223m), this, this.f50222l);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.t(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.G(dVar, z5);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void c(boolean z5) {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.S(z5);
        }
    }

    @Override // master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean d() {
        return this.f50216f;
    }

    @Override // master.flame.danmaku.controller.f
    public void e() {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.T();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void f(boolean z5) {
        this.f50221k = z5;
    }

    @Override // master.flame.danmaku.controller.f
    public DanmakuContext getConfig() {
        c cVar = this.f50214d;
        if (cVar == null) {
            return null;
        }
        return cVar.z();
    }

    @Override // master.flame.danmaku.controller.f
    public long getCurrentTime() {
        c cVar = this.f50214d;
        if (cVar != null) {
            return cVar.A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public m getCurrentVisibleDanmakus() {
        c cVar = this.f50214d;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.f
    public f.a getOnDanmakuClickListener() {
        return this.f50217g;
    }

    @Override // master.flame.danmaku.controller.f
    public float getXOff() {
        return this.f50218h;
    }

    @Override // master.flame.danmaku.controller.f
    public float getYOff() {
        return this.f50219i;
    }

    @Override // master.flame.danmaku.controller.g
    public long i() {
        if (!this.f50215e) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long b6 = w4.c.b();
        Canvas lockCanvas = this.f50212b.lockCanvas();
        if (lockCanvas != null) {
            c cVar = this.f50214d;
            if (cVar != null) {
                a.c x5 = cVar.x(lockCanvas);
                if (this.f50221k) {
                    if (this.f50224n == null) {
                        this.f50224n = new LinkedList<>();
                    }
                    w4.c.b();
                    d.d(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(p()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(x5.f54730r), Long.valueOf(x5.f54731s)));
                }
            }
            if (this.f50215e) {
                this.f50212b.unlockCanvasAndPost(lockCanvas);
            }
        }
        return w4.c.b() - b6;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPaused() {
        c cVar = this.f50214d;
        if (cVar != null) {
            return cVar.I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPrepared() {
        c cVar = this.f50214d;
        return cVar != null && cVar.H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f
    public boolean isShown() {
        return this.f50222l && super.isShown();
    }

    @Override // master.flame.danmaku.controller.f
    public void k() {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // master.flame.danmaku.controller.g
    public boolean l() {
        return this.f50215e;
    }

    @Override // master.flame.danmaku.controller.f
    public void m(Long l6) {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.V(l6);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void n(f.a aVar, float f6, float f7) {
        this.f50217g = aVar;
        this.f50218h = f6;
        this.f50219i = f7;
    }

    @Override // master.flame.danmaku.controller.f
    public void o(boolean z5) {
        this.f50216f = z5;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean k6 = this.f50220j.k(motionEvent);
        return !k6 ? super.onTouchEvent(motionEvent) : k6;
    }

    @Override // master.flame.danmaku.controller.f
    public void pause() {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.L();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void resume() {
        c cVar = this.f50214d;
        if (cVar != null && cVar.H()) {
            this.f50214d.U();
        } else if (this.f50214d == null) {
            t();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setCallback(c.d dVar) {
        this.f50211a = dVar;
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.W(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setDrawingThreadType(int i6) {
        this.f50223m = i6;
    }

    @Override // master.flame.danmaku.controller.f
    public void setOnDanmakuClickListener(f.a aVar) {
        this.f50217g = aVar;
    }

    @Override // master.flame.danmaku.controller.f
    public void start(long j6) {
        c cVar = this.f50214d;
        if (cVar == null) {
            s();
        } else {
            cVar.removeCallbacksAndMessages(null);
        }
        this.f50214d.obtainMessage(1, Long.valueOf(j6)).sendToTarget();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        c cVar = this.f50214d;
        if (cVar != null) {
            cVar.J(i7, i8);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void toggle() {
        if (this.f50215e) {
            c cVar = this.f50214d;
            if (cVar == null) {
                start();
            } else if (cVar.I()) {
                resume();
            } else {
                pause();
            }
        }
    }

    private float p() {
        long b6 = w4.c.b();
        this.f50224n.addLast(Long.valueOf(b6));
        Long peekFirst = this.f50224n.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = b6 - peekFirst.longValue();
        if (this.f50224n.size() > 50) {
            this.f50224n.removeFirst();
        }
        if (longValue <= 0.0f) {
            return 0.0f;
        }
        return (this.f50224n.size() * 1000) / longValue;
    }

    @Override // master.flame.danmaku.controller.g
    public void clear() {
        Canvas lockCanvas;
        if (l() && (lockCanvas = this.f50212b.lockCanvas()) != null) {
            d.a(lockCanvas);
            this.f50212b.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void g(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext) {
        s();
        this.f50214d.X(danmakuContext);
        this.f50214d.Y(aVar);
        this.f50214d.W(this.f50211a);
        this.f50214d.M();
    }

    @Override // master.flame.danmaku.controller.f
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f50224n;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void stop() {
        u();
    }

    public void t() {
        stop();
        start();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50216f = true;
        this.f50222l = true;
        this.f50223m = 0;
        r();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f50216f = true;
        this.f50222l = true;
        this.f50223m = 0;
        r();
    }

    @Override // master.flame.danmaku.controller.f
    public View getView() {
        return this;
    }
}
