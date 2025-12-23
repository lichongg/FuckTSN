package com.bytedance.sdk.component.cw.xt;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.cw.xt.j.xt.ae;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class oq {
    static final /* synthetic */ boolean cw = true;

    /* renamed from: r, reason: collision with root package name */
    private static final Executor f26337r = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.cw.xt.j.cw.j("OkHttp ConnectionPool", true));
    private List<String> ae;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f26338g;

    /* renamed from: j, reason: collision with root package name */
    final com.bytedance.sdk.component.cw.xt.j.xt.r f26339j;

    /* renamed from: m, reason: collision with root package name */
    private long f26340m;
    private final Deque<com.bytedance.sdk.component.cw.xt.j.xt.cw> oq;
    private long tl;
    private int up;
    boolean xt;

    public oq() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private boolean cw(com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar) {
        try {
            List<String> list = this.ae;
            if (list != null && !list.isEmpty() && cwVar.j() != null && cwVar.j().j() != null && cwVar.j().j().j() != null && cwVar.j().j().j().ae() != null) {
                String ae = cwVar.j().j().j().ae();
                if (!TextUtils.isEmpty(ae)) {
                    if (this.ae.contains(ae)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void j(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i6 = bundle.getInt("max_idle_cnt");
                    if (i6 <= 5) {
                        i6 = this.up;
                    }
                    this.up = i6;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j6 = bundle.getLong("max_idle_time");
                    this.f26340m = j6 > 5 ? TimeUnit.MINUTES.toNanos(j6) : this.f26340m;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.ae = bundle.getStringArrayList("white_hosts");
                    long j7 = bundle.getLong("white_extra_idle_time");
                    this.tl = j7 > 0 ? TimeUnit.MINUTES.toNanos(j7) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public oq(int i6, long j6, TimeUnit timeUnit) {
        this.f26338g = new Runnable() { // from class: com.bytedance.sdk.component.cw.xt.oq.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long j7 = oq.this.j(System.nanoTime());
                    if (j7 == -1) {
                        return;
                    }
                    if (j7 > 0) {
                        long j8 = j7 / C.MICROS_PER_SECOND;
                        long j9 = j7 - (C.MICROS_PER_SECOND * j8);
                        synchronized (oq.this) {
                            try {
                                oq.this.wait(j8, (int) j9);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.oq = new ArrayDeque();
        this.f26339j = new com.bytedance.sdk.component.cw.xt.j.xt.r();
        this.up = i6;
        this.f26340m = timeUnit.toNanos(j6);
        if (j6 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j6)));
        }
    }

    boolean xt(com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar) {
        if (!cw && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (cwVar.f26311j || this.up == 0) {
            this.oq.remove(cwVar);
            return true;
        }
        notifyAll();
        return false;
    }

    com.bytedance.sdk.component.cw.xt.j.xt.cw j(j jVar, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar, la laVar) {
        if (!cw && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar : this.oq) {
            if (cwVar.j(jVar, laVar)) {
                if (aeVar != null) {
                    aeVar.j(cwVar, true);
                }
                return cwVar;
            }
        }
        return null;
    }

    Socket j(j jVar, com.bytedance.sdk.component.cw.xt.j.xt.ae aeVar) {
        if (!cw && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar : this.oq) {
            if (cwVar.j(jVar, null) && cwVar.up() && cwVar != aeVar.xt()) {
                return aeVar.j(cwVar);
            }
        }
        return null;
    }

    void j(com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar) {
        if (!cw && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.xt) {
            this.xt = true;
            f26337r.execute(this.f26338g);
        }
        this.oq.add(cwVar);
    }

    long j(long j6) {
        try {
            synchronized (this) {
                try {
                    com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar = null;
                    long j7 = Long.MIN_VALUE;
                    int i6 = 0;
                    int i7 = 0;
                    for (com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar2 : this.oq) {
                        if (j(cwVar2, j6) > 0) {
                            i7++;
                        } else {
                            i6++;
                            long j8 = j6 - cwVar2.up;
                            if (this.tl > 0 && cw(cwVar2)) {
                                j8 -= this.tl;
                            }
                            if (j8 > j7) {
                                cwVar = cwVar2;
                                j7 = j8;
                            }
                        }
                    }
                    long j9 = this.f26340m;
                    if (j7 < j9 && i6 <= this.up) {
                        if (i6 > 0) {
                            return j9 - j7;
                        }
                        if (i7 > 0) {
                            return j9;
                        }
                        this.xt = false;
                        com.bytedance.sdk.component.utils.vl.j("ConnectionPool", "cleanup: ");
                        return -1L;
                    }
                    this.oq.remove(cwVar);
                    com.bytedance.sdk.component.cw.xt.j.cw.j(cwVar.cw());
                    return 0L;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (OutOfMemoryError unused) {
            return this.f26340m;
        }
    }

    private int j(com.bytedance.sdk.component.cw.xt.j.xt.cw cwVar, long j6) {
        List<Reference<com.bytedance.sdk.component.cw.xt.j.xt.ae>> list = cwVar.f26312r;
        int i6 = 0;
        while (i6 < list.size()) {
            Reference<com.bytedance.sdk.component.cw.xt.j.xt.ae> reference = list.get(i6);
            if (reference.get() != null) {
                i6++;
            } else {
                com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j("A connection to " + cwVar.j().j().j() + " was leaked. Did you forget to close a response body?", ((ae.j) reference).f26309j);
                list.remove(i6);
                cwVar.f26311j = true;
                if (list.isEmpty()) {
                    cwVar.up = j6 - this.f26340m;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
