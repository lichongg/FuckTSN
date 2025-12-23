package master.flame.danmaku.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import java.util.LinkedList;
import master.flame.danmaku.controller.h;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import tv.cjump.jni.DeviceUtils;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class c extends Handler {
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final int F = 4;
    public static final int G = 5;
    private static final int H = 6;
    private static final int I = 7;
    private static final int J = 8;
    private static final int K = 9;
    private static final int L = 10;
    private static final int M = 11;
    private static final int N = 12;
    private static final int O = 13;
    private static final long P = 10000000;
    private static final int Q = 500;
    private boolean A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    private DanmakuContext f49842a;

    /* renamed from: b, reason: collision with root package name */
    private e f49843b;

    /* renamed from: c, reason: collision with root package name */
    private long f49844c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f49845d;

    /* renamed from: e, reason: collision with root package name */
    private long f49846e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f49847f;

    /* renamed from: g, reason: collision with root package name */
    private d f49848g;

    /* renamed from: h, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.f f49849h;

    /* renamed from: i, reason: collision with root package name */
    private master.flame.danmaku.danmaku.parser.a f49850i;

    /* renamed from: j, reason: collision with root package name */
    public h f49851j;

    /* renamed from: k, reason: collision with root package name */
    private g f49852k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f49853l;

    /* renamed from: m, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.b f49854m;

    /* renamed from: n, reason: collision with root package name */
    private final a.c f49855n;

    /* renamed from: o, reason: collision with root package name */
    private LinkedList<Long> f49856o;

    /* renamed from: p, reason: collision with root package name */
    private i f49857p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f49858q;

    /* renamed from: r, reason: collision with root package name */
    private long f49859r;

    /* renamed from: s, reason: collision with root package name */
    private long f49860s;

    /* renamed from: t, reason: collision with root package name */
    private long f49861t;

    /* renamed from: u, reason: collision with root package name */
    private long f49862u;

    /* renamed from: v, reason: collision with root package name */
    private long f49863v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f49864w;

    /* renamed from: x, reason: collision with root package name */
    private long f49865x;

    /* renamed from: y, reason: collision with root package name */
    private long f49866y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f49867z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f49844c = 0L;
            c.this.f49847f = true;
            if (c.this.f49848g != null) {
                c.this.f49848g.d();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends i {
        b(String str) {
            super(str);
        }

        @Override // master.flame.danmaku.controller.i, java.lang.Thread, java.lang.Runnable
        public void run() {
            long b6 = w4.c.b();
            while (!a() && !c.this.f49845d) {
                long b7 = w4.c.b();
                if (c.this.f49861t - (w4.c.b() - b6) <= 1) {
                    long a02 = c.this.a0(b7);
                    if (a02 < 0) {
                        w4.c.a(60 - a02);
                    } else {
                        long i6 = c.this.f49852k.i();
                        if (i6 > c.this.f49860s) {
                            c.this.f49849h.a(i6);
                            c.this.f49856o.clear();
                        }
                        if (!c.this.f49853l) {
                            c.this.f0(c.P);
                        } else if (c.this.f49855n.f54728p && c.this.B) {
                            long j6 = c.this.f49855n.f54727o - c.this.f49849h.f50080a;
                            if (j6 > 500) {
                                c.this.K();
                                c.this.f0(j6 - 10);
                            }
                        }
                    }
                    b6 = b7;
                } else {
                    w4.c.a(1L);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.controller.c$c, reason: collision with other inner class name */
    class C0969c implements h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f49870a;

        C0969c(Runnable runnable) {
            this.f49870a = runnable;
        }

        @Override // master.flame.danmaku.controller.h.a
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (c.this.f49848g != null) {
                c.this.f49848g.a(dVar);
            }
        }

        @Override // master.flame.danmaku.controller.h.a
        public void c() {
            c.this.F();
            this.f49870a.run();
        }

        @Override // master.flame.danmaku.controller.h.a
        public void d() {
            if (c.this.f49848g != null) {
                c.this.f49848g.b();
            }
        }

        @Override // master.flame.danmaku.controller.h.a
        public void e() {
            c.this.R();
        }

        @Override // master.flame.danmaku.controller.h.a
        public void b(master.flame.danmaku.danmaku.model.d dVar) {
            if (!dVar.w()) {
                long b6 = dVar.b() - c.this.A();
                if (b6 < c.this.f49842a.D.f50009e && (c.this.A || c.this.f49855n.f54728p)) {
                    c.this.K();
                } else if (b6 > 0 && b6 <= c.this.f49842a.D.f50009e) {
                    c.this.sendEmptyMessageDelayed(11, b6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(master.flame.danmaku.danmaku.model.d dVar);

        void b();

        void c(master.flame.danmaku.danmaku.model.f fVar);

        void d();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(16)
    private class e implements Choreographer.FrameCallback {
        private e() {
        }

        /* synthetic */ e(c cVar, a aVar) {
            this();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j6) {
            c.this.sendEmptyMessage(2);
        }
    }

    private synchronized void Q() {
        this.f49856o.addLast(Long.valueOf(w4.c.b()));
        if (this.f49856o.size() > 500) {
            this.f49856o.removeFirst();
        }
    }

    private synchronized long y() {
        int size = this.f49856o.size();
        if (size <= 0) {
            return 0L;
        }
        Long peekFirst = this.f49856o.peekFirst();
        Long peekLast = this.f49856o.peekLast();
        if (peekFirst != null && peekLast != null) {
            return (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return 0L;
    }

    public void L() {
        removeMessages(3);
        b0();
        sendEmptyMessage(7);
    }

    public void M() {
        this.f49847f = false;
        if (this.f49842a.F == 0) {
            this.f49843b = new e(this, null);
        }
        this.f49858q = this.f49842a.F == 1;
        sendEmptyMessage(5);
    }

    public void O() {
        this.f49845d = true;
        sendEmptyMessage(6);
    }

    public void U() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void V(Long l6) {
        this.f49864w = true;
        this.f49865x = l6.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, l6).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        long max = Math.max(33L, (long) (16 * 2.5f));
        this.f49859r = max;
        this.f49860s = (long) (max * 2.5f);
        long max2 = Math.max(16L, 15L);
        this.f49861t = max2;
        this.f49862u = max2 + 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.A) {
            h hVar = this.f49851j;
            if (hVar != null) {
                hVar.i();
            }
            if (this.f49858q) {
                synchronized (this) {
                    this.f49856o.clear();
                }
                synchronized (this.f49851j) {
                    this.f49851j.notifyAll();
                }
            } else {
                this.f49856o.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.A = false;
        }
    }

    private void N(Runnable runnable) {
        if (this.f49851j == null) {
            this.f49851j = w(this.f49852k.d(), this.f49849h, this.f49852k.getContext(), this.f49852k.getWidth(), this.f49852k.getHeight(), this.f49852k.isHardwareAccelerated(), new C0969c(runnable));
        } else {
            runnable.run();
        }
    }

    private void P() {
        i iVar = this.f49857p;
        if (iVar != null) {
            this.f49857p = null;
            synchronized (this.f49851j) {
                this.f49851j.notifyAll();
            }
            iVar.b();
            try {
                iVar.join();
            } catch (InterruptedException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.f49845d && this.f49853l) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a0(long j6) {
        long j7 = 0;
        if (!this.f49864w && !this.f49867z) {
            this.f49867z = true;
            long j8 = j6 - this.f49846e;
            if (!this.f49853l || this.f49855n.f54728p || this.A) {
                this.f49849h.update(j8);
                this.f49866y = 0L;
            } else {
                long j9 = j8 - this.f49849h.f50080a;
                long max = Math.max(this.f49861t, y());
                if (j9 <= 2000) {
                    long j10 = this.f49855n.f54725m;
                    long j11 = this.f49859r;
                    if (j10 <= j11 && max <= j11) {
                        long j12 = this.f49861t;
                        long min = Math.min(this.f49859r, Math.max(j12, max + (j9 / j12)));
                        long j13 = this.f49863v;
                        long j14 = min - j13;
                        if (j14 > 3 && j14 < 8 && j13 >= this.f49861t && j13 <= this.f49859r) {
                            min = j13;
                        }
                        this.f49863v = min;
                        j7 = j9 - min;
                        j9 = min;
                    }
                }
                this.f49866y = j7;
                this.f49849h.a(j9);
                j7 = j9;
            }
            d dVar = this.f49848g;
            if (dVar != null) {
                dVar.c(this.f49849h);
            }
            this.f49867z = false;
        }
        return j7;
    }

    private void b0() {
        if (this.A) {
            a0(w4.c.b());
        }
    }

    @TargetApi(16)
    private void c0() {
        if (this.f49845d) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this.f49843b);
        if (a0(w4.c.b()) < 0) {
            removeMessages(2);
            return;
        }
        long i6 = this.f49852k.i();
        removeMessages(2);
        if (i6 > this.f49860s) {
            this.f49849h.a(i6);
            this.f49856o.clear();
        }
        if (!this.f49853l) {
            f0(P);
            return;
        }
        a.c cVar = this.f49855n;
        if (cVar.f54728p && this.B) {
            long j6 = cVar.f54727o - this.f49849h.f50080a;
            if (j6 > 500) {
                f0(j6 - 10);
            }
        }
    }

    private void d0() {
        if (this.f49845d) {
            return;
        }
        long a02 = a0(w4.c.b());
        if (a02 < 0) {
            removeMessages(2);
            sendEmptyMessageDelayed(2, 60 - a02);
            return;
        }
        long i6 = this.f49852k.i();
        removeMessages(2);
        if (i6 > this.f49860s) {
            this.f49849h.a(i6);
            this.f49856o.clear();
        }
        if (!this.f49853l) {
            f0(P);
            return;
        }
        a.c cVar = this.f49855n;
        if (cVar.f54728p && this.B) {
            long j6 = cVar.f54727o - this.f49849h.f50080a;
            if (j6 > 500) {
                f0(j6 - 10);
                return;
            }
        }
        long j7 = this.f49861t;
        if (i6 < j7) {
            sendEmptyMessageDelayed(2, j7 - i6);
        } else {
            sendEmptyMessage(2);
        }
    }

    private void e0() {
        if (this.f49857p != null) {
            return;
        }
        b bVar = new b("DFM Update");
        this.f49857p = bVar;
        bVar.start();
    }

    private void u(g gVar) {
        this.f49852k = gVar;
    }

    private h w(boolean z5, master.flame.danmaku.danmaku.model.f fVar, Context context, int i6, int i7, boolean z6, h.a aVar) {
        master.flame.danmaku.danmaku.model.b g6 = this.f49842a.g();
        this.f49854m = g6;
        g6.setSize(i6, i7);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f49854m.c(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.f49854m.a(this.f49842a.f49917c);
        this.f49854m.j(z6);
        h aVar2 = z5 ? new master.flame.danmaku.controller.a(fVar, this.f49842a, aVar) : new master.flame.danmaku.controller.e(fVar, this.f49842a, aVar);
        aVar2.f(this.f49850i);
        aVar2.prepare();
        obtainMessage(10, Boolean.FALSE).sendToTarget();
        return aVar2;
    }

    public long A() {
        long j6;
        long j7;
        if (!this.f49847f) {
            return 0L;
        }
        if (this.f49864w) {
            return this.f49865x;
        }
        if (this.f49845d || !this.A) {
            j6 = this.f49849h.f50080a;
            j7 = this.f49866y;
        } else {
            j6 = w4.c.b();
            j7 = this.f49846e;
        }
        return j6 - j7;
    }

    public m B() {
        h hVar = this.f49851j;
        if (hVar != null) {
            return hVar.d(A());
        }
        return null;
    }

    public n C() {
        return this.f49854m;
    }

    public boolean D() {
        return this.f49853l;
    }

    public long E(boolean z5) {
        if (!this.f49853l) {
            return this.f49849h.f50080a;
        }
        this.f49853l = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z5)).sendToTarget();
        return this.f49849h.f50080a;
    }

    public void G(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        h hVar = this.f49851j;
        if (hVar != null && dVar != null) {
            hVar.b(dVar, z5);
        }
        R();
    }

    public boolean H() {
        return this.f49847f;
    }

    public boolean I() {
        return this.f49845d;
    }

    public void J(int i6, int i7) {
        master.flame.danmaku.danmaku.model.b bVar = this.f49854m;
        if (bVar == null) {
            return;
        }
        if (bVar.getWidth() == i6 && this.f49854m.getHeight() == i7) {
            return;
        }
        this.f49854m.setSize(i6, i7);
        obtainMessage(10, Boolean.TRUE).sendToTarget();
    }

    public void S(boolean z5) {
        h hVar = this.f49851j;
        if (hVar != null) {
            hVar.c(z5);
        }
    }

    public void T() {
        h hVar = this.f49851j;
        if (hVar != null) {
            hVar.e();
        }
    }

    public void W(d dVar) {
        this.f49848g = dVar;
    }

    public void X(DanmakuContext danmakuContext) {
        this.f49842a = danmakuContext;
    }

    public void Y(master.flame.danmaku.danmaku.parser.a aVar) {
        this.f49850i = aVar;
    }

    public void Z(Long l6) {
        if (this.f49853l) {
            return;
        }
        this.f49853l = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l6).sendToTarget();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0158  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.controller.c.handleMessage(android.os.Message):void");
    }

    public void t(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.f49851j != null) {
            dVar.I = this.f49842a.B;
            dVar.F(this.f49849h);
            this.f49851j.a(dVar);
            obtainMessage(11).sendToTarget();
        }
    }

    public void v() {
        obtainMessage(13).sendToTarget();
    }

    public a.c x(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean d6;
        if (this.f49851j == null) {
            return this.f49855n;
        }
        if (!this.A && (aVar = this.f49842a.f49929o) != null && ((d6 = aVar.d()) || !this.f49845d)) {
            int a6 = aVar.a();
            if (a6 == 2) {
                long j6 = this.f49849h.f50080a;
                long c6 = aVar.c();
                long j7 = c6 - j6;
                if (Math.abs(j7) > aVar.b()) {
                    if (d6 && this.f49845d) {
                        U();
                    }
                    this.f49851j.h(j6, c6, j7);
                    this.f49849h.update(c6);
                    this.f49846e -= j7;
                    this.f49866y = 0L;
                }
            } else if (a6 == 1 && d6 && !this.f49845d) {
                L();
            }
        }
        this.f49854m.w(canvas);
        this.f49855n.f(this.f49851j.l(this.f49854m));
        Q();
        return this.f49855n;
    }

    public DanmakuContext z() {
        return this.f49842a;
    }

    public c(Looper looper, g gVar, boolean z5) {
        super(looper);
        this.f49844c = 0L;
        this.f49845d = true;
        this.f49849h = new master.flame.danmaku.danmaku.model.f();
        this.f49853l = true;
        this.f49855n = new a.c();
        this.f49856o = new LinkedList<>();
        this.f49859r = 30L;
        this.f49860s = 60L;
        this.f49861t = 16L;
        this.B = true ^ DeviceUtils.g();
        u(gVar);
        if (z5) {
            Z(null);
        } else {
            E(false);
        }
        this.f49853l = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(long j6) {
        if (!I() && H() && !this.f49864w) {
            this.f49855n.f54729q = w4.c.b();
            this.A = true;
            if (this.f49858q) {
                if (this.f49857p != null) {
                    try {
                        synchronized (this.f49851j) {
                            try {
                                if (j6 == P) {
                                    this.f49851j.wait();
                                } else {
                                    this.f49851j.wait(j6);
                                }
                                sendEmptyMessage(11);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return;
                    } catch (InterruptedException e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (j6 == P) {
                removeMessages(11);
                removeMessages(2);
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, j6);
            }
        }
    }
}
