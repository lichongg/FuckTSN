package com.bytedance.sdk.component.adexpress.j.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.j.cw.j;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends cw {

    /* renamed from: j, reason: collision with root package name */
    private static File f25831j;
    private static volatile up xt;
    private AtomicBoolean cw = new AtomicBoolean(true);

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f25833r = new AtomicBoolean(false);
    private boolean up = false;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f25832m = new AtomicBoolean(false);
    private AtomicInteger ae = new AtomicInteger(0);
    private AtomicLong tl = new AtomicLong();

    public void m() {
        j(false);
    }

    public static File ae() {
        if (f25831j == null) {
            try {
                File file = new File(new File(r.j(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                f25831j = file;
            } catch (Throwable th) {
                vl.cw("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f25831j;
    }

    private void g() {
        if (this.ae.getAndSet(0) <= 0 || System.currentTimeMillis() - this.tl.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
            return;
        }
        m();
    }

    private void tl() {
        com.bytedance.sdk.component.adexpress.r.up.xt(new g("init") { // from class: com.bytedance.sdk.component.adexpress.j.xt.up.1
            @Override // java.lang.Runnable
            public void run() {
                tl.j();
                up.this.cw.set(false);
                up.this.cw();
                up.this.m();
                if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null && i.j(com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext())) {
                    com.bytedance.sdk.component.adexpress.j.j.j.j().cw().xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.j.xt.up.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null) {
                                com.bytedance.sdk.component.adexpress.j.j.j.j();
                            }
                        }
                    });
                }
            }
        }, 10);
    }

    public static up xt() {
        if (xt == null) {
            synchronized (up.class) {
                try {
                    if (xt == null) {
                        xt = new up();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public boolean j(com.bytedance.sdk.component.adexpress.j.cw.j jVar) {
        if (jVar == null) {
            return false;
        }
        return j(jVar.j()) || j(jVar.up()) || j(jVar.getResources());
    }

    public boolean r() {
        return this.up;
    }

    private up() {
        tl();
    }

    public void cw() {
        com.bytedance.sdk.component.adexpress.j.cw.j xt2 = tl.xt();
        if (xt2 != null && xt2.m()) {
            boolean j6 = j(xt2);
            if (!j6) {
                tl.r();
            }
            this.up = j6;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.j.xt.cw
    public File j() {
        return ae();
    }

    public com.bytedance.sdk.component.adexpress.j.cw.j up() {
        return tl.xt();
    }

    public void j(boolean z5) {
        List<j.C0397j> list;
        boolean z6;
        if (this.cw.get()) {
            return;
        }
        try {
            if (this.f25833r.get()) {
                if (z5) {
                    this.ae.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z7 = true;
            this.f25833r.set(true);
            com.bytedance.sdk.component.adexpress.j.cw.j cw = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().cw();
            com.bytedance.sdk.component.adexpress.j.cw.j xt2 = tl.xt();
            if (cw != null && cw.m()) {
                if (!tl.xt(cw)) {
                    this.f25833r.set(false);
                    this.tl.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null) {
                    com.bytedance.sdk.component.adexpress.j.j.j.j().cw().xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.j.xt.up.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.up.up.j().xt();
                        }
                    });
                }
                tl.j(cw);
                boolean j6 = (cw.up() == null || TextUtils.isEmpty(cw.up().j())) ? false : j(cw.up().j());
                if (cw.j().size() != 0) {
                    list = j(cw, xt2);
                    z6 = list != null;
                } else {
                    list = null;
                    z6 = j6;
                }
                if (!j6) {
                    List<j.C0397j> xt3 = xt(cw, xt2);
                    if (list == null || xt3 == null) {
                        list = xt3;
                    } else {
                        list.addAll(xt3);
                    }
                    if (xt3 == null) {
                        z7 = false;
                    }
                    if (xt3 == null) {
                        this.f25833r.set(false);
                    }
                    z6 = z7;
                }
                if (z6 && j(cw)) {
                    tl.j(cw);
                    tl.cw();
                    xt(list);
                }
                cw();
                this.f25833r.set(false);
                this.tl.set(System.currentTimeMillis());
                g();
                return;
            }
            this.f25833r.set(false);
            j(109);
        } catch (Throwable unused) {
        }
    }
}
