package com.bytedance.adsdk.j.j.j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.j.j.xt.ae;
import com.bytedance.adsdk.j.j.xt.m;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class g<R extends com.bytedance.adsdk.j.j.xt.m, W extends com.bytedance.adsdk.j.j.xt.ae> {
    private static final String ae = "g";
    private static final Rect ws = new Rect();
    private final Set<Bitmap> av;
    private final Runnable az;
    protected int cw;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f23140g;

    /* renamed from: i, reason: collision with root package name */
    private final Object f23141i;
    private final AtomicBoolean jy;
    private boolean kt;

    /* renamed from: m, reason: collision with root package name */
    protected volatile Rect f23143m;
    private R mi;
    private int oq;

    /* renamed from: r, reason: collision with root package name */
    protected Map<Bitmap, Canvas> f23144r;
    private volatile xt tj;
    private final com.bytedance.adsdk.j.j.cw.xt tl;
    protected ByteBuffer up;
    private final Set<j> vl;

    /* renamed from: w, reason: collision with root package name */
    private W f23145w;

    /* renamed from: j, reason: collision with root package name */
    protected List<tl<R, W>> f23142j = new ArrayList();
    protected int xt = -1;
    private Integer qv = null;

    public interface j {
        void j();

        void xt();

        void xt(ByteBuffer byteBuffer);
    }

    private enum xt {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    protected abstract R cw(com.bytedance.adsdk.j.j.xt.m mVar);

    protected abstract void cw();

    protected abstract void j(tl<R, W> tlVar);

    protected abstract W r();

    protected abstract int xt();

    protected abstract Rect xt(R r5) throws IOException;

    private int av() {
        Integer num = this.qv;
        return num != null ? num.intValue() : xt();
    }

    private String az() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public long w() {
        int i6 = this.xt + 1;
        this.xt = i6;
        if (i6 >= ae()) {
            this.xt = 0;
            this.oq++;
        }
        tl<R, W> j6 = j(this.xt);
        if (j6 == null) {
            return 0L;
        }
        j(j6);
        return j6.vl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void ws() {
        this.f23140g.removeCallbacks(this.az);
        this.f23142j.clear();
        synchronized (this.f23141i) {
            try {
                for (Bitmap bitmap : this.av) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
                this.av.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.up != null) {
            this.up = null;
        }
        this.f23144r.clear();
        try {
            if (this.mi != null) {
                this.mi = null;
            }
        } catch (IOException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        cw();
        this.tj = xt.IDLE;
        Iterator<j> it = this.vl.iterator();
        while (it.hasNext()) {
            it.next().xt();
        }
    }

    public int ae() {
        return this.f23142j.size();
    }

    protected int cw(int i6, int i7) {
        int i8 = 1;
        if (i6 != 0 && i7 != 0) {
            int min = Math.min(m().width() / i6, m().height() / i7);
            while (true) {
                int i9 = i8 * 2;
                if (i9 > min) {
                    break;
                }
                i8 = i9;
            }
        }
        return i8;
    }

    public void g() {
        if (this.f23143m == ws) {
            return;
        }
        xt xtVar = this.tj;
        xt xtVar2 = xt.FINISHING;
        if (xtVar == xtVar2 || this.tj == xt.IDLE) {
            com.bytedance.sdk.component.utils.vl.j(ae, az() + "No need to stop");
            return;
        }
        if (this.tj == xt.INITIALIZING) {
            com.bytedance.sdk.component.utils.vl.r(ae, az() + "Processing,wait for finish at " + this.tj);
        }
        this.tj = xtVar2;
        if (Looper.myLooper() == this.f23140g.getLooper()) {
            ws();
        } else {
            this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.ws();
                }
            });
        }
    }

    public Rect m() {
        if (this.f23143m == null) {
            if (this.tj == xt.FINISHING) {
                com.bytedance.sdk.component.utils.vl.r(ae, "In finishing,do not interrupt");
            }
            final Thread currentThread = Thread.currentThread();
            this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (g.this.f23143m == null) {
                                if (g.this.mi == null) {
                                    g gVar = g.this;
                                    gVar.mi = gVar.cw(gVar.tl.xt());
                                } else {
                                    g.this.mi.d_();
                                }
                                g gVar2 = g.this;
                                gVar2.j(gVar2.xt((g) gVar2.mi));
                            }
                        } catch (Exception e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                            g.this.f23143m = g.ws;
                        }
                        LockSupport.unpark(currentThread);
                    } catch (Throwable th) {
                        LockSupport.unpark(currentThread);
                        throw th;
                    }
                }
            });
            LockSupport.park(currentThread);
        }
        return this.f23143m == null ? ws : this.f23143m;
    }

    public boolean oq() {
        return this.tj == xt.RUNNING || this.tj == xt.INITIALIZING;
    }

    public void qv() {
        this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.8
            @Override // java.lang.Runnable
            public void run() {
                g.this.oq = 0;
                g gVar = g.this;
                gVar.xt = -1;
                gVar.kt = false;
            }
        });
    }

    public void tl() {
        if (this.f23143m == ws) {
            return;
        }
        if (this.tj != xt.RUNNING) {
            xt xtVar = this.tj;
            xt xtVar2 = xt.INITIALIZING;
            if (xtVar != xtVar2) {
                if (this.tj == xt.FINISHING) {
                    com.bytedance.sdk.component.utils.vl.r(ae, az() + " Processing,wait for finish at " + this.tj);
                }
                this.tj = xtVar2;
                if (Looper.myLooper() == this.f23140g.getLooper()) {
                    j();
                    return;
                } else {
                    this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.6
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.j();
                        }
                    });
                    return;
                }
            }
        }
        com.bytedance.sdk.component.utils.vl.j(ae, az() + " Already started");
    }

    public void up() {
        this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.4
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.vl.size() == 0) {
                    g.this.g();
                }
            }
        });
    }

    public int vl() {
        return this.cw;
    }

    public void xt(final j jVar) {
        this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.vl.remove(jVar);
            }
        });
    }

    public g(com.bytedance.adsdk.j.j.cw.xt xtVar, j jVar) {
        HashSet hashSet = new HashSet();
        this.vl = hashSet;
        this.jy = new AtomicBoolean(true);
        this.az = new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.jy.get()) {
                    return;
                }
                if (!g.this.i()) {
                    g.this.g();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                g.this.f23140g.postDelayed(this, Math.max(0L, g.this.w() - (System.currentTimeMillis() - currentTimeMillis)));
                Iterator it = g.this.vl.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).xt(g.this.up);
                }
            }
        };
        this.cw = 1;
        this.av = new HashSet();
        this.f23141i = new Object();
        this.f23144r = new WeakHashMap();
        this.f23145w = r();
        this.mi = null;
        this.kt = false;
        this.tj = xt.IDLE;
        this.tl = xtVar;
        if (jVar != null) {
            hashSet.add(jVar);
        }
        this.f23140g = com.bytedance.sdk.component.oq.xt.j.j().xt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        if (!oq() || this.f23142j.size() == 0) {
            return false;
        }
        if (av() <= 0 || this.oq < av() - 1) {
            return true;
        }
        if (this.oq == av() - 1 && this.xt < ae() - 1) {
            return true;
        }
        this.kt = true;
        return false;
    }

    public boolean xt(int i6, int i7) {
        final int cw = cw(i6, i7);
        if (cw == this.cw) {
            return false;
        }
        final boolean oq = oq();
        this.f23140g.removeCallbacks(this.az);
        this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                g.this.ws();
                try {
                    g gVar = g.this;
                    gVar.cw = cw;
                    gVar.j(gVar.xt((g) gVar.cw(gVar.tl.xt())));
                    if (oq) {
                        g.this.j();
                    }
                } catch (IOException e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
        });
        return true;
    }

    protected Bitmap j(int i6, int i7) {
        synchronized (this.f23141i) {
            try {
                Iterator<Bitmap> it = this.av.iterator();
                Bitmap bitmap = null;
                while (it.hasNext()) {
                    int i8 = i6 * i7 * 4;
                    Bitmap next = it.next();
                    if (next != null && next.getAllocationByteCount() >= i8) {
                        it.remove();
                        if (next.getWidth() == i6) {
                            if (next.getHeight() != i7) {
                            }
                            next.eraseColor(0);
                            return next;
                        }
                        if (i6 > 0 && i7 > 0) {
                            next.reconfigure(i6, i7, Bitmap.Config.ARGB_4444);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                    bitmap = next;
                }
                if (i6 <= 0 || i7 <= 0) {
                    return null;
                }
                try {
                    try {
                        bitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_4444);
                    } catch (OutOfMemoryError e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                } catch (Exception e7) {
                    com.bytedance.sdk.component.utils.vl.j(e7);
                }
                return bitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void j(Bitmap bitmap) {
        synchronized (this.f23141i) {
            if (bitmap != null) {
                try {
                    this.av.add(bitmap);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void j(final j jVar) {
        this.f23140g.post(new Runnable() { // from class: com.bytedance.adsdk.j.j.j.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.vl.add(jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Rect rect) {
        this.f23143m = rect;
        int width = rect.width() * rect.height();
        int i6 = this.cw;
        this.up = ByteBuffer.allocate(((width / (i6 * i6)) + 1) * 4);
        if (this.f23145w == null) {
            this.f23145w = r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void j() {
        this.jy.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f23142j.size() == 0) {
                try {
                    R r5 = this.mi;
                    if (r5 == null) {
                        this.mi = cw(this.tl.xt());
                    } else {
                        r5.d_();
                    }
                    j(xt((g<R, W>) this.mi));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
            String str = ae;
            com.bytedance.sdk.component.utils.vl.j(str, az() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.tj = xt.RUNNING;
            if (av() != 0 && this.kt) {
                com.bytedance.sdk.component.utils.vl.j(str, az() + " No need to started");
                return;
            }
            this.xt = -1;
            this.az.run();
            Iterator<j> it = this.vl.iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.j(ae, az() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.tj = xt.RUNNING;
            throw th2;
        }
    }

    public tl<R, W> j(int i6) {
        if (i6 < 0 || i6 >= this.f23142j.size()) {
            return null;
        }
        return this.f23142j.get(i6);
    }
}
