package master.flame.danmaku.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
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
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class DanmakuTextureView extends TextureView implements f, g, TextureView.SurfaceTextureListener {

    /* renamed from: n, reason: collision with root package name */
    public static final String f50225n = "DanmakuTextureView";

    /* renamed from: o, reason: collision with root package name */
    private static final int f50226o = 50;

    /* renamed from: p, reason: collision with root package name */
    private static final int f50227p = 1000;

    /* renamed from: a, reason: collision with root package name */
    private c.d f50228a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f50229b;

    /* renamed from: c, reason: collision with root package name */
    private c f50230c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50231d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f50232e;

    /* renamed from: f, reason: collision with root package name */
    private f.a f50233f;

    /* renamed from: g, reason: collision with root package name */
    private float f50234g;

    /* renamed from: h, reason: collision with root package name */
    private float f50235h;

    /* renamed from: i, reason: collision with root package name */
    private a f50236i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f50237j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f50238k;

    /* renamed from: l, reason: collision with root package name */
    protected int f50239l;

    /* renamed from: m, reason: collision with root package name */
    private LinkedList<Long> f50240m;

    public DanmakuTextureView(Context context) {
        super(context);
        this.f50232e = true;
        this.f50238k = true;
        this.f50239l = 0;
        r();
    }

    @TargetApi(11)
    private void r() {
        setLayerType(2, null);
        setOpaque(false);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        setSurfaceTextureListener(this);
        d.f(true, true);
        this.f50236i = a.j(this);
    }

    private synchronized void u() {
        try {
            c cVar = this.f50230c;
            if (cVar != null) {
                cVar.O();
                this.f50230c = null;
            }
            HandlerThread handlerThread = this.f50229b;
            this.f50229b = null;
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

    @Override // master.flame.danmaku.controller.g
    public synchronized void clear() {
        if (l()) {
            Canvas lockCanvas = lockCanvas();
            if (lockCanvas != null) {
                d.a(lockCanvas);
                unlockCanvasAndPost(lockCanvas);
            }
        }
    }

    @Override // master.flame.danmaku.controller.f
    public long h() {
        this.f50238k = false;
        c cVar = this.f50230c;
        if (cVar == null) {
            return 0L;
        }
        return cVar.E(true);
    }

    @Override // master.flame.danmaku.controller.f
    public void hide() {
        this.f50238k = false;
        c cVar = this.f50230c;
        if (cVar == null) {
            return;
        }
        cVar.E(false);
    }

    @Override // master.flame.danmaku.controller.g
    public synchronized long i() {
        try {
            if (!this.f50231d) {
                return 0L;
            }
            long b6 = w4.c.b();
            if (!isShown()) {
                return -1L;
            }
            Canvas lockCanvas = lockCanvas();
            if (lockCanvas != null) {
                c cVar = this.f50230c;
                if (cVar != null) {
                    a.c x5 = cVar.x(lockCanvas);
                    if (this.f50237j) {
                        if (this.f50240m == null) {
                            this.f50240m = new LinkedList<>();
                        }
                        w4.c.b();
                        d.d(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(p()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(x5.f54730r), Long.valueOf(x5.f54731s)));
                    }
                }
                if (this.f50231d) {
                    unlockCanvasAndPost(lockCanvas);
                }
            }
            return w4.c.b() - b6;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View, master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public void j(Long l6) {
        this.f50238k = true;
        c cVar = this.f50230c;
        if (cVar == null) {
            return;
        }
        cVar.Z(l6);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        this.f50231d = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f50231d = false;
        return true;
    }

    protected synchronized Looper q(int i6) {
        try {
            HandlerThread handlerThread = this.f50229b;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f50229b = null;
            }
            if (i6 == 1) {
                return Looper.getMainLooper();
            }
            int i7 = i6 != 2 ? i6 != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i7, i7);
            this.f50229b = handlerThread2;
            handlerThread2.start();
            return this.f50229b.getLooper();
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

    private void s() {
        if (this.f50230c == null) {
            this.f50230c = new c(q(this.f50239l), this, this.f50238k);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.t(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.G(dVar, z5);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void c(boolean z5) {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.S(z5);
        }
    }

    @Override // master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean d() {
        return this.f50232e;
    }

    @Override // master.flame.danmaku.controller.f
    public void e() {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.T();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void f(boolean z5) {
        this.f50237j = z5;
    }

    @Override // master.flame.danmaku.controller.f
    public DanmakuContext getConfig() {
        c cVar = this.f50230c;
        if (cVar == null) {
            return null;
        }
        return cVar.z();
    }

    @Override // master.flame.danmaku.controller.f
    public long getCurrentTime() {
        c cVar = this.f50230c;
        if (cVar != null) {
            return cVar.A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public m getCurrentVisibleDanmakus() {
        c cVar = this.f50230c;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.f
    public f.a getOnDanmakuClickListener() {
        return this.f50233f;
    }

    @Override // master.flame.danmaku.controller.f
    public float getXOff() {
        return this.f50234g;
    }

    @Override // master.flame.danmaku.controller.f
    public float getYOff() {
        return this.f50235h;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPaused() {
        c cVar = this.f50230c;
        if (cVar != null) {
            return cVar.I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPrepared() {
        c cVar = this.f50230c;
        return cVar != null && cVar.H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f
    public boolean isShown() {
        return this.f50238k && super.isShown();
    }

    @Override // master.flame.danmaku.controller.f
    public void k() {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // master.flame.danmaku.controller.g
    public boolean l() {
        return this.f50231d;
    }

    @Override // master.flame.danmaku.controller.f
    public void m(Long l6) {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.V(l6);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void n(f.a aVar, float f6, float f7) {
        this.f50233f = aVar;
        this.f50234g = f6;
        this.f50235h = f7;
    }

    @Override // master.flame.danmaku.controller.f
    public void o(boolean z5) {
        this.f50232e = z5;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.J(i6, i7);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean k6 = this.f50236i.k(motionEvent);
        return !k6 ? super.onTouchEvent(motionEvent) : k6;
    }

    @Override // master.flame.danmaku.controller.f
    public void pause() {
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.L();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void resume() {
        c cVar = this.f50230c;
        if (cVar != null && cVar.H()) {
            this.f50230c.U();
        } else if (this.f50230c == null) {
            t();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setCallback(c.d dVar) {
        this.f50228a = dVar;
        c cVar = this.f50230c;
        if (cVar != null) {
            cVar.W(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setDrawingThreadType(int i6) {
        this.f50239l = i6;
    }

    @Override // master.flame.danmaku.controller.f
    public void setOnDanmakuClickListener(f.a aVar) {
        this.f50233f = aVar;
    }

    @Override // master.flame.danmaku.controller.f
    public void start(long j6) {
        c cVar = this.f50230c;
        if (cVar == null) {
            s();
        } else {
            cVar.removeCallbacksAndMessages(null);
        }
        this.f50230c.obtainMessage(1, Long.valueOf(j6)).sendToTarget();
    }

    @Override // master.flame.danmaku.controller.f
    public void toggle() {
        if (this.f50231d) {
            c cVar = this.f50230c;
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
        this.f50240m.addLast(Long.valueOf(b6));
        Long peekFirst = this.f50240m.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = b6 - peekFirst.longValue();
        if (this.f50240m.size() > 50) {
            this.f50240m.removeFirst();
        }
        if (longValue <= 0.0f) {
            return 0.0f;
        }
        return (this.f50240m.size() * 1000) / longValue;
    }

    @Override // master.flame.danmaku.controller.f
    public void g(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext) {
        s();
        this.f50230c.X(danmakuContext);
        this.f50230c.Y(aVar);
        this.f50230c.W(this.f50228a);
        this.f50230c.M();
    }

    @Override // master.flame.danmaku.controller.f
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f50240m;
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

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50232e = true;
        this.f50238k = true;
        this.f50239l = 0;
        r();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f50232e = true;
        this.f50238k = true;
        this.f50239l = 0;
        r();
    }

    @Override // master.flame.danmaku.controller.f
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
