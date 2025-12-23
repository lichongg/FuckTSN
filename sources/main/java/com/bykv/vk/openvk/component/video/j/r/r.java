package com.bykv.vk.openvk.component.video.j.r;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.j;
import com.bykv.vk.openvk.component.video.j.r.cw;
import com.bytedance.sdk.component.utils.l;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements com.bykv.vk.openvk.component.video.api.j, cw.ae, cw.InterfaceC0308cw, cw.j, cw.m, cw.r, cw.up, cw.xt, l.j {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f23001j = new AtomicInteger(0);

    /* renamed from: s, reason: collision with root package name */
    private static final SparseIntArray f23002s = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    private boolean f23003a;
    private SurfaceHolder cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23005f;
    private volatile boolean gx;
    private boolean oq;
    private boolean qv;
    private int up;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<Runnable> f23014v;
    private volatile l ws;
    private SurfaceTexture xt;

    /* renamed from: r, reason: collision with root package name */
    private int f23013r = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f23010m = false;
    private volatile cw ae = null;
    private final boolean tl = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f23006g = false;
    private volatile int vl = 201;
    private long jy = -1;
    private volatile boolean az = false;
    private boolean av = false;

    /* renamed from: i, reason: collision with root package name */
    private long f23008i = 0;

    /* renamed from: w, reason: collision with root package name */
    private long f23015w = Long.MIN_VALUE;
    private long mi = 0;
    private long kt = 0;
    private long tj = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f23016x = 0;
    private String ch = "0";

    /* renamed from: l, reason: collision with root package name */
    private final List<WeakReference<j.InterfaceC0305j>> f23009l = new CopyOnWriteArrayList();

    /* renamed from: p, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.cw.r f23012p = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f23007h = false;
    private volatile int la = 200;
    private AtomicBoolean gq = new AtomicBoolean(false);
    private AtomicBoolean rn = new AtomicBoolean(false);
    private AtomicBoolean wq = new AtomicBoolean(false);
    private Surface uf = null;
    private final Runnable ed = new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.1
        @Override // java.lang.Runnable
        public void run() {
            if (r.this.ae == null) {
                return;
            }
            long mi = r.this.mi();
            if (mi > 0 && Build.VERSION.SDK_INT >= 23 && r.this.jy() && r.this.f23015w != Long.MIN_VALUE) {
                try {
                    if (r.this.f23015w == mi) {
                        if (!r.this.av && r.this.mi >= 400) {
                            r.this.xt(701, 800);
                            r.this.av = true;
                        }
                        r.this.mi += r.this.la;
                    } else {
                        if (r.this.av) {
                            r.this.f23008i += r.this.mi;
                            r.this.xt(702, 800);
                            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(r.this.f23008i), "  bufferCount =", Integer.valueOf(r.this.f23013r));
                        }
                        r.this.mi = 0L;
                        r.this.av = false;
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (r.this.w() > 0) {
                if (r.this.f23015w != mi) {
                    if (com.bykv.vk.openvk.component.video.api.cw.r()) {
                        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(r.this.f23015w), "  curPosition = ", Long.valueOf(mi));
                    }
                    r rVar = r.this;
                    rVar.j(mi, rVar.w());
                }
                r.this.f23015w = mi;
            }
            if (r.this.g()) {
                r rVar2 = r.this;
                rVar2.j(rVar2.w(), r.this.w());
            } else if (r.this.ws != null) {
                r.this.ws.postDelayed(this, r.this.la);
            }
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final j f23004c = new j();

    /* renamed from: n, reason: collision with root package name */
    private long f23011n = 0;
    private long nd = 0;
    private boolean rh = false;

    class j implements Runnable {
        private boolean cw;
        private long xt;

        public void j(boolean z5) {
            this.cw = z5;
        }

        j() {
        }

        public void j(long j6) {
            this.xt = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.ae != null) {
                try {
                    if (!this.cw) {
                        long g6 = r.this.ae.g();
                        r.this.jy = Math.max(this.xt, g6);
                    }
                    long unused = r.this.jy;
                } catch (Throwable unused2) {
                }
            }
            if (r.this.ws != null) {
                r.this.ws.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    private boolean j(int i6, int i7) {
        boolean z5 = i6 == -1010 || i6 == -1007 || i6 == -1004 || i6 == -110 || i6 == 100 || i6 == 200;
        if (i7 == 1 || i7 == 700 || i7 == 800) {
            return true;
        }
        return z5;
    }

    private void a() {
        SparseIntArray sparseIntArray = f23002s;
        sparseIntArray.put(this.f23016x, sparseIntArray.get(this.f23016x) + 1);
    }

    private void ch() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.ae == null) {
            return;
        }
        try {
            this.ae.vl();
        } catch (Throwable unused) {
        }
        this.ae.j((cw.xt) null);
        this.ae.j((cw.ae) null);
        this.ae.j((cw.j) null);
        this.ae.j((cw.r) null);
        this.ae.j((cw.InterfaceC0308cw) null);
        this.ae.j((cw.up) null);
        this.ae.j((cw.m) null);
        try {
            this.ae.qv();
        } catch (Throwable unused2) {
        }
    }

    private void f() {
        this.f23008i = 0L;
        this.f23013r = 0;
        this.mi = 0L;
        this.av = false;
        this.f23015w = Long.MIN_VALUE;
    }

    private void gq() {
        ArrayList<Runnable> arrayList = this.f23014v;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f23014v.clear();
    }

    private void h() {
        if (this.oq) {
            return;
        }
        this.oq = true;
        Iterator it = new ArrayList(this.f23014v).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f23014v.clear();
        this.oq = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        ArrayList<Runnable> arrayList = this.f23014v;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        h();
    }

    private void p() {
        if (this.ws != null) {
            this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        r.this.ae.ae();
                        r.this.vl = 207;
                        r.this.gx = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void s() {
        l lVar = this.ws;
        if (lVar == null || lVar.getLooper() == null) {
            return;
        }
        lVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.8
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.ws == null || r.this.ws.getLooper() == null) {
                    return;
                }
                try {
                    if (r.this.az) {
                        r.this.ws.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.oq.xt.j.j().j(r.this.ws);
                    }
                    r.this.ws = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.ws != null) {
            this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.12
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.ae == null) {
                        try {
                            r.this.ae = new xt();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (r.this.ae == null) {
                            return;
                        }
                        cw unused = r.this.ae;
                        r.this.ch = "0";
                        r.this.ae.j((cw.up) r.this);
                        r.this.ae.j((cw.xt) r.this);
                        r.this.ae.j((cw.InterfaceC0308cw) r.this);
                        r.this.ae.j((cw.j) r.this);
                        r.this.ae.j((cw.m) r.this);
                        r.this.ae.j((cw.r) r.this);
                        r.this.ae.j((cw.ae) r.this);
                        try {
                            r.this.ae.cw(false);
                        } catch (Throwable unused2) {
                        }
                        r.this.f23006g = false;
                    }
                }
            });
        }
    }

    private void x() {
        xt(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.2
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.ws != null) {
                    r.this.ws.sendEmptyMessage(104);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceHolder ae() {
        return this.cw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long av() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.nd;
        }
        if (this.av) {
            long j6 = this.mi;
            if (j6 > 0) {
                return this.f23008i + j6;
            }
        }
        return this.f23008i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean az() {
        return this.qv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean g() {
        return this.vl == 209;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int i() {
        return this.f23013r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean jy() {
        return (this.vl == 206 || (this.ws != null && this.ws.hasMessages(100))) && !this.gx;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean m() {
        return this.f23010m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean oq() {
        return tj() || jy() || ws();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int qv() {
        if (this.ae == null || az()) {
            return 0;
        }
        return this.ae.jy();
    }

    public boolean tj() {
        return this.vl == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceTexture tl() {
        return this.xt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void up() {
        if (az()) {
            return;
        }
        this.qv = true;
        gq();
        if (this.ws != null) {
            try {
                this.ws.removeCallbacksAndMessages(null);
                if (this.ae != null) {
                    this.ws.sendEmptyMessage(103);
                }
                s();
            } catch (Throwable unused) {
                s();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int vl() {
        if (this.ae == null || az()) {
            return 0;
        }
        return this.ae.ws();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long w() {
        long j6 = this.kt;
        if (j6 != 0) {
            return j6;
        }
        if (this.vl == 206 || this.vl == 207) {
            try {
                this.kt = this.ae.oq();
            } catch (Throwable unused) {
            }
        }
        return this.kt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean ws() {
        return ((this.vl != 207 && !this.gx) || this.ws == null || this.ws.hasMessages(100)) ? false : true;
    }

    public r(String str) {
        j("mda_" + str + "_" + f23001j.addAndGet(1), (Looper) null);
    }

    private void l() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.tj;
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().j(this, elapsedRealtime);
            }
        }
        this.f23010m = true;
    }

    public int kt() {
        if (az()) {
            return 203;
        }
        return this.vl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long mi() {
        if (az()) {
            return 0L;
        }
        if (this.vl == 206 || this.vl == 207) {
            try {
                return this.ae.g();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw() {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (az() || this.ws == null) {
            return;
        }
        this.ws.removeMessages(100);
        this.gx = true;
        if (!this.rh) {
            if (!this.f23005f && !xt(this.f23012p)) {
                j(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (r.this.ws != null) {
                            r.this.ws.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            } else {
                if (this.ws != null) {
                    this.ws.sendEmptyMessage(101);
                    return;
                }
                return;
            }
        }
        if (!this.f23010m && !xt(this.f23012p)) {
            j(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.17
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.ws != null) {
                        r.this.ws.sendEmptyMessage(101);
                    }
                }
            });
        } else if (this.ws != null) {
            this.ws.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void r() {
        if (az()) {
            return;
        }
        xt(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.3
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.ws != null) {
                    r.this.ws.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(final boolean z5) {
        if (az()) {
            return;
        }
        this.f23003a = z5;
        if (this.ae != null) {
            this.ae.j(z5);
        } else if (this.ws != null) {
            this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.11
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.ae != null) {
                        r.this.ae.j(z5);
                    }
                }
            });
        }
    }

    private void xt(long j6) {
        this.f23004c.j(j6);
        if (this.f23003a) {
            xt(this.f23004c);
        } else if (xt(this.f23012p)) {
            xt(this.f23004c);
        } else {
            j(this.f23004c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6, long j7) {
        long j8;
        long j9;
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference == null || weakReference.get() == null) {
                j8 = j6;
                j9 = j7;
            } else {
                j8 = j6;
                j9 = j7;
                weakReference.get().j(this, j8, j9);
            }
            j6 = j8;
            j7 = j9;
        }
    }

    private void j(String str, Looper looper) {
        this.f23016x = 0;
        if (looper != null) {
            this.az = true;
            this.ws = new l(looper, this);
        } else if (this.ws == null) {
            this.ws = com.bytedance.sdk.component.oq.xt.j.j().j(this, "csj_" + str);
        }
        this.rh = true;
        v();
    }

    private boolean xt(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        return rVar != null && rVar.ae();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt() {
        if (az() || this.ws == null) {
            return;
        }
        this.gq.set(true);
        this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.15
            @Override // java.lang.Runnable
            public void run() {
                if (!r.this.ws() || r.this.ae == null) {
                    return;
                }
                try {
                    r.this.ae.up();
                    com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : r.this.f23009l) {
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    r.this.vl = 206;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.m
    public void cw(cw cwVar) {
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().j((com.bykv.vk.openvk.component.video.api.j) this, true);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw(boolean z5) {
        if (az()) {
            return;
        }
        this.ae.up(z5);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j() {
        if (az() || this.ae == null) {
            return;
        }
        if (this.vl != 206) {
            f();
            this.gx = false;
            this.f23004c.j(true);
            xt(0L);
            if (this.ws != null) {
                this.ws.removeCallbacks(this.ed);
                this.ws.postDelayed(this.ed, this.la);
            }
        }
        this.gq.set(true);
        if ((this.rn.get() || this.wq.get()) && this.ws != null) {
            this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.13
                @Override // java.lang.Runnable
                public void run() {
                    r.this.la();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.r
    public boolean xt(cw cwVar, int i6, int i7) {
        com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", "what,extra:" + i6 + "," + i7);
        if (this.ae != cwVar) {
            return false;
        }
        if (i7 == -1004) {
            com.bykv.vk.openvk.component.video.api.cw.xt xtVar = new com.bykv.vk.openvk.component.video.api.cw.xt(i6, i7);
            for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().j(this, xtVar);
                }
            }
        }
        xt(i6, i7);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i6, int i7) {
        if (i6 == 701) {
            this.f23011n = SystemClock.elapsedRealtime();
            this.f23013r++;
            for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().j(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.f23013r));
            return;
        }
        if (i6 == 702) {
            if (this.f23011n > 0) {
                this.nd += SystemClock.elapsedRealtime() - this.f23011n;
                this.f23011n = 0L;
            }
            for (WeakReference<j.InterfaceC0305j> weakReference2 : this.f23009l) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().j((com.bykv.vk.openvk.component.video.api.j) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.f23013r), " mBufferTotalTime = ", Long.valueOf(this.nd));
            return;
        }
        if (this.rh && i6 == 3) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.gx);
            la();
            l();
            j(this.f23007h);
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5, long j6, boolean z6) {
        if (az()) {
            return;
        }
        v();
        this.f23007h = z6;
        this.gx = false;
        j(z6);
        if (z5) {
            this.jy = j6;
            x();
        } else {
            xt(j6);
        }
        if (this.ws != null) {
            this.ws.removeCallbacks(this.ed);
            this.ws.postDelayed(this.ed, this.la);
        }
        this.gq.set(true);
        if ((this.rn.get() || this.wq.get()) && this.ws != null) {
            this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.14
                @Override // java.lang.Runnable
                public void run() {
                    r.this.la();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final long j6) {
        if (az()) {
            return;
        }
        if (this.vl == 207 || this.vl == 206 || this.vl == 209) {
            xt(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.4
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.ws != null) {
                        r.this.ws.obtainMessage(106, Long.valueOf(j6)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.up
    public void xt(cw cwVar) {
        if (az()) {
            return;
        }
        this.vl = 205;
        try {
            com.bykv.vk.openvk.component.video.api.cw.r rVar = this.f23012p;
            if (rVar != null) {
                float az = rVar.az();
                if (az > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.xt xtVar = new com.bykv.vk.openvk.component.video.api.xt();
                    xtVar.j(az);
                    this.ae.j(xtVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.ws != null) {
            if (this.gx) {
                p();
            } else {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.ws.sendMessage(this.ws.obtainMessage(100, -1, -1));
            }
        }
        f23002s.delete(this.f23016x);
        com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", "onPrepared:" + this.rh + " " + this.f23005f);
        if (!this.rh && !this.f23005f) {
            l();
            this.f23005f = true;
        }
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xt(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final SurfaceTexture surfaceTexture) {
        if (az()) {
            return;
        }
        this.xt = surfaceTexture;
        xt(true);
        xt(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.5
            @Override // java.lang.Runnable
            public void run() {
                r.this.v();
                if (r.this.ws != null) {
                    r.this.ws.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final SurfaceHolder surfaceHolder) {
        if (az()) {
            return;
        }
        this.cw = surfaceHolder;
        xt(true);
        xt(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.6
            @Override // java.lang.Runnable
            public void run() {
                r.this.v();
                if (r.this.ws != null) {
                    r.this.ws.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        if (az()) {
            return;
        }
        this.f23012p = rVar;
        if (rVar != null) {
            this.rh = this.rh && !rVar.ae();
        }
        xt(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.7
            @Override // java.lang.Runnable
            public void run() {
                r.this.v();
                if (r.this.ws != null) {
                    r.this.ws.obtainMessage(107, rVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = this.vl;
        int i7 = message.what;
        if (this.ae != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.vl == 205 || this.vl == 207 || this.vl == 209) {
                            this.ae.up();
                            this.tj = SystemClock.elapsedRealtime();
                            this.vl = 206;
                            if (this.jy > 0) {
                                this.ae.j(this.jy, this.up);
                                this.jy = -1L;
                            }
                            if (this.f23012p != null) {
                                j(this.f23007h);
                                return;
                            }
                            return;
                        }
                        break;
                    case 101:
                        if (this.av) {
                            this.f23008i += this.mi;
                        }
                        this.av = false;
                        this.mi = 0L;
                        this.f23015w = Long.MIN_VALUE;
                        if (this.vl == 206 || this.vl == 207 || this.vl == 209) {
                            this.ae.ae();
                            this.vl = 207;
                            this.gx = false;
                            for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            return;
                        }
                        break;
                    case 102:
                        this.ae.vl();
                        this.vl = 201;
                        return;
                    case 103:
                        try {
                            ch();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th);
                        }
                        for (WeakReference<j.InterfaceC0305j> weakReference2 : this.f23009l) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().cw(this);
                            }
                        }
                        this.vl = 203;
                        return;
                    case 104:
                        if (this.vl == 202 || this.vl == 208) {
                            try {
                                this.ae.tl();
                                return;
                            } catch (Throwable th2) {
                                com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th2);
                                return;
                            }
                        }
                        break;
                    case 105:
                        if (this.vl == 205 || this.vl == 206 || this.vl == 208 || this.vl == 207 || this.vl == 209) {
                            this.ae.m();
                            this.vl = 208;
                            return;
                        }
                        break;
                    case 106:
                        if (this.vl == 206 || this.vl == 207 || this.vl == 209) {
                            this.ae.j(((Long) message.obj).longValue(), this.up);
                            return;
                        }
                        break;
                    case 107:
                        f();
                        if (this.vl == 201 || this.vl == 203) {
                            com.bykv.vk.openvk.component.video.api.cw.r rVar = (com.bykv.vk.openvk.component.video.api.cw.r) message.obj;
                            if (TextUtils.isEmpty(rVar.up())) {
                                rVar.j(com.bykv.vk.openvk.component.video.api.cw.j());
                            }
                            File file = new File(rVar.up(), rVar.i());
                            if (file.exists()) {
                                file.getAbsolutePath();
                                if (com.bykv.vk.openvk.component.video.api.cw.xt()) {
                                    j(file.getAbsolutePath());
                                } else {
                                    this.ae.j(file.getAbsolutePath());
                                }
                            } else {
                                rVar.av();
                                if (rVar.xt == 1 && Build.VERSION.SDK_INT < 23) {
                                    this.ae.j(rVar.av());
                                    rVar.av();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.ae.j(rVar);
                                    rVar.av();
                                } else {
                                    String xt = com.bykv.vk.openvk.component.video.j.xt.m.j.j().xt(rVar);
                                    if (xt != null && com.bykv.vk.openvk.component.video.api.cw.xt() && xt.startsWith(master.flame.danmaku.danmaku.parser.b.f50156c)) {
                                        j(Uri.parse(xt).getPath());
                                    } else {
                                        this.ae.j(xt);
                                    }
                                }
                            }
                            this.vl = 202;
                            return;
                        }
                        break;
                    case 108:
                    case 109:
                    default:
                        return;
                    case 110:
                        this.ae.j((SurfaceHolder) message.obj);
                        this.ae.xt(true);
                        this.rn.set(true);
                        if (this.gq.get()) {
                            la();
                            return;
                        }
                        return;
                    case 111:
                        this.uf = new Surface((SurfaceTexture) message.obj);
                        this.ae.j(this.uf);
                        this.ae.xt(true);
                        this.wq.set(true);
                        if (this.gq.get()) {
                            la();
                            return;
                        }
                        return;
                }
                this.vl = 200;
                if (this.f23006g) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.cw.xt xtVar = new com.bykv.vk.openvk.component.video.api.cw.xt(308, i7);
                xtVar.j(i6 + "," + i7);
                for (WeakReference<j.InterfaceC0305j> weakReference3 : this.f23009l) {
                    if (weakReference3 != null && weakReference3.get() != null) {
                        weakReference3.get().j(this, xtVar);
                    }
                }
                this.f23006g = true;
            } catch (Throwable unused) {
            }
        }
    }

    private void xt(Runnable runnable) {
        if (runnable == null || az()) {
            return;
        }
        if (!this.qv) {
            runnable.run();
        } else {
            j(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(int i6) {
        if (az()) {
            return;
        }
        this.la = i6;
    }

    private void j(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.ae.j(fileInputStream.getFD());
        fileInputStream.close();
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.j
    public void j(cw cwVar, int i6) {
        if (this.ae != cwVar) {
            return;
        }
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().xt(this, i6);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.xt
    public void j(cw cwVar) {
        this.vl = 209;
        f23002s.delete(this.f23016x);
        if (this.ws != null) {
            this.ws.removeCallbacks(this.ed);
        }
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().j(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.InterfaceC0308cw
    public boolean j(cw cwVar, int i6, int i7) {
        com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", "what=" + i6 + "extra=" + i7);
        a();
        this.vl = 200;
        if (this.ws != null) {
            this.ws.removeCallbacks(this.ed);
        }
        if (j(i6, i7)) {
            s();
        }
        if (!this.gq.get()) {
            return true;
        }
        this.gq.set(false);
        com.bykv.vk.openvk.component.video.api.cw.xt xtVar = new com.bykv.vk.openvk.component.video.api.cw.xt(i6, i7);
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().j(this, xtVar);
            }
        }
        return true;
    }

    private void j(Runnable runnable) {
        try {
            if (this.f23014v == null) {
                this.f23014v = new ArrayList<>();
            }
            this.f23014v.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final boolean z5) {
        if (az()) {
            return;
        }
        if (this.ws == null) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            this.ws.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.r.r.10
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.az() || r.this.ae == null) {
                        return;
                    }
                    try {
                        r.this.f23007h = z5;
                        r.this.ae.r(z5);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.r.cw.ae
    public void j(cw cwVar, int i6, int i7, int i8, int i9) {
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().j((com.bykv.vk.openvk.component.video.api.j) this, i6, i7);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(j.InterfaceC0305j interfaceC0305j) {
        if (interfaceC0305j == null) {
            return;
        }
        for (WeakReference<j.InterfaceC0305j> weakReference : this.f23009l) {
            if (weakReference != null && weakReference.get() == interfaceC0305j) {
                return;
            }
        }
        this.f23009l.add(new WeakReference<>(interfaceC0305j));
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(int i6) {
        this.up = i6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(float f6) {
        try {
            com.bykv.vk.openvk.component.video.api.xt xtVar = new com.bykv.vk.openvk.component.video.api.xt();
            xtVar.j(f6);
            this.ae.j(xtVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
