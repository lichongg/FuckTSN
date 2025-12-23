package com.bykv.vk.openvk.component.video.j.xt;

import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bykv.vk.openvk.component.video.j.xt.vl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes3.dex */
abstract class j implements qv {
    private static final AtomicLong jy = new AtomicLong();
    protected volatile String ae;

    /* renamed from: g, reason: collision with root package name */
    protected volatile g f23052g;

    /* renamed from: j, reason: collision with root package name */
    protected volatile com.bykv.vk.openvk.component.video.j.xt.j.j f23053j;

    /* renamed from: m, reason: collision with root package name */
    protected volatile List<g.xt> f23054m;
    protected volatile vl oq;
    protected volatile String tl;
    protected com.bykv.vk.openvk.component.video.j.xt.r.j up;
    protected final com.bykv.vk.openvk.component.video.j.xt.xt.cw xt;
    protected final AtomicInteger cw = new AtomicInteger();

    /* renamed from: r, reason: collision with root package name */
    protected final AtomicLong f23055r = new AtomicLong();
    protected volatile boolean qv = false;
    public final long vl = jy.incrementAndGet();
    private final AtomicInteger ws = new AtomicInteger(0);
    private int az = -1;

    protected void cw() {
        this.ws.compareAndSet(0, 2);
    }

    public void j() {
        this.ws.compareAndSet(0, 1);
    }

    protected int m() {
        return this.f23052g != null ? this.f23052g.cw.f23048j : this.f23053j instanceof com.bykv.vk.openvk.component.video.j.xt.j.xt ? 1 : 0;
    }

    public boolean r() {
        return this.ws.get() == 2;
    }

    public boolean xt() {
        return this.ws.get() == 1;
    }

    public j(com.bykv.vk.openvk.component.video.j.xt.j.j jVar, com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar) {
        this.f23053j = jVar;
        this.xt = cwVar;
    }

    protected boolean ae() {
        if (m() == 1) {
            return true;
        }
        return false;
    }

    protected com.bykv.vk.openvk.component.video.j.xt.up.j j(vl.j jVar, int i6, int i7, String str) throws IOException {
        com.bykv.vk.openvk.component.video.j.xt.up.xt xt = com.bykv.vk.openvk.component.video.j.xt.up.cw.j().xt();
        com.bykv.vk.openvk.component.video.j.xt.up.up upVar = new com.bykv.vk.openvk.component.video.j.xt.up.up();
        HashMap hashMap = new HashMap();
        upVar.xt = jVar.f23114j;
        upVar.f23109j = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            upVar.f23109j = 4;
        }
        List<g.xt> list = this.f23054m;
        if (list != null && !list.isEmpty()) {
            for (g.xt xtVar : list) {
                if (!"Range".equalsIgnoreCase(xtVar.f23051j) && !"Connection".equalsIgnoreCase(xtVar.f23051j) && !"Proxy-Connection".equalsIgnoreCase(xtVar.f23051j) && !"Host".equalsIgnoreCase(xtVar.f23051j)) {
                    hashMap.put(xtVar.f23051j, xtVar.xt);
                }
            }
        }
        String j6 = com.bykv.vk.openvk.component.video.j.cw.j.j(i6, i7);
        if (j6 != null) {
            hashMap.put("Range", j6);
        }
        if (up.f23104m) {
            hashMap.put("Cache-Control", "no-cache");
        }
        r cw = r.cw();
        m j7 = m.j();
        boolean z5 = this.f23052g == null;
        cw j8 = z5 ? cw.j() : j7.xt();
        cw xt2 = z5 ? cw.xt() : j7.cw();
        if (j8 != null || xt2 != null) {
            if (j8 != null) {
                upVar.cw = j8.j(jVar.xt);
            }
            if (xt2 != null) {
                upVar.f23110r = xt2.j(jVar.xt);
            }
        }
        upVar.up = hashMap;
        if (this.qv) {
            this.qv = false;
            return null;
        }
        return xt.j(upVar);
    }

    protected void up() throws com.bykv.vk.openvk.component.video.j.xt.cw.j {
        if (!xt()) {
        } else {
            throw new com.bykv.vk.openvk.component.video.j.xt.cw.j();
        }
    }

    protected void j(int i6, int i7) {
        if (i6 <= 0 || i7 < 0) {
            return;
        }
        int i8 = up.ae;
        int m6 = m();
        if (i8 == 1 || (i8 == 2 && m6 == 1)) {
            int i9 = (int) ((i7 / i6) * 100.0f);
            if (i9 > 100) {
                i9 = 100;
            }
            synchronized (this) {
                try {
                    if (i9 <= this.az) {
                        return;
                    }
                    this.az = i9;
                    com.bykv.vk.openvk.component.video.j.cw.j.j(new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.xt.j.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j jVar = j.this;
                            if (jVar.up != null) {
                                vl vlVar = jVar.oq;
                                int unused = j.this.az;
                            }
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
