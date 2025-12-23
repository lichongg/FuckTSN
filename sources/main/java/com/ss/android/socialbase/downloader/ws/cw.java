package com.ss.android.socialbase.downloader.ws;

import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.ae.xt;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.kt;
import com.ss.android.socialbase.downloader.downloader.oq;
import com.ss.android.socialbase.downloader.downloader.vl;
import com.ss.android.socialbase.downloader.impls.i;
import com.ss.android.socialbase.downloader.impls.w;
import com.ss.android.socialbase.downloader.qv.qv;
import com.ss.android.socialbase.downloader.qv.ws;
import com.ss.android.socialbase.downloader.r.ch;
import com.ss.android.socialbase.downloader.r.l;
import com.ss.android.socialbase.downloader.r.mi;
import com.ss.android.socialbase.downloader.r.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw implements m, Runnable {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38995j = "cw";

    /* renamed from: a, reason: collision with root package name */
    private mi f38996a;
    private volatile com.ss.android.socialbase.downloader.downloader.up ae;
    private com.ss.android.socialbase.downloader.ae.cw av;
    private final vl az;
    private com.ss.android.socialbase.downloader.g.ae ch;
    private final com.ss.android.socialbase.downloader.ae.r cw;

    /* renamed from: f, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.m f38998f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38999g;

    /* renamed from: i, reason: collision with root package name */
    private oq f39001i;
    private final AtomicBoolean jy;
    private final g kt;
    private String la;
    private g mi;
    private boolean oq;
    private boolean qv;
    private long rn;

    /* renamed from: s, reason: collision with root package name */
    private ch f39006s;
    private kt tj;
    private boolean tl;
    private final com.ss.android.socialbase.downloader.jy.j uf;
    private AtomicInteger up;

    /* renamed from: v, reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.up.j f39007v;
    private boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private final oq f39008w;
    private long wq;

    /* renamed from: x, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.g.g f39009x;
    private Future xt;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f39005r = false;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<xt> f39003m = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.xt.oq ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_NONE;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f39002l = 5;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39004p = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f39000h = false;
    private boolean gq = false;
    private int ed = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile qv f38997c = null;

    private boolean c() {
        return false;
    }

    public com.ss.android.socialbase.downloader.ae.r cw() {
        return this.cw;
    }

    public boolean r() {
        return this.jy.get();
    }

    public void xt() {
        com.ss.android.socialbase.downloader.xt.oq oqVar = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED;
        this.ws = oqVar;
        if (this.f38997c != null) {
            this.f38997c.j();
        }
        if (this.ae != null) {
            this.ae.cw();
        }
        if (this.f38997c == null && this.ae == null) {
            mi();
            this.ws = oqVar;
            av();
        }
        uf();
    }

    private long a() {
        return this.tj.j(this.av.nd(), this.av.n());
    }

    private void av() {
        boolean z5;
        boolean z6;
        com.ss.android.socialbase.downloader.m.j.xt(f38995j, "endDownloadRunnable::runStatus=" + this.ws);
        boolean z7 = (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE || this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED) ? false : true;
        try {
            z5 = v();
            z6 = false;
        } catch (Exception e6) {
            if (e6 instanceof com.ss.android.socialbase.downloader.up.j) {
                this.f38998f.j((com.ss.android.socialbase.downloader.up.j) e6);
            } else {
                this.f38998f.j(new com.ss.android.socialbase.downloader.up.j(1046, e6));
            }
            z5 = true;
            z6 = true;
        }
        if (!z5 && !z6) {
            this.f39004p = true;
            com.ss.android.socialbase.downloader.m.j.xt(f38995j, "jump to restart");
            return;
        }
        this.jy.set(false);
        if (z7) {
            try {
                com.ss.android.socialbase.downloader.impls.j p5 = com.ss.android.socialbase.downloader.downloader.cw.p();
                if (p5 != null) {
                    p5.j(this);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
                l up = this.cw.up();
                com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
                com.ss.android.socialbase.downloader.up.j jVar = new com.ss.android.socialbase.downloader.up.j(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, com.ss.android.socialbase.downloader.az.m.xt(th, "removeDownloadRunnable"));
                com.ss.android.socialbase.downloader.ae.cw cwVar2 = this.av;
                com.ss.android.socialbase.downloader.tl.j.j(up, cwVar, jVar, cwVar2 != null ? cwVar2.i() : 0);
            }
        }
    }

    private void az() {
        if (com.ss.android.socialbase.downloader.jy.j.j(this.av.ae()).j("reset_retain_retry_times", 0) != 1 || this.ed >= 3) {
            return;
        }
        this.up.set(this.av.hh() ? this.av.gx() : this.av.c());
        this.ed++;
    }

    private boolean ch() {
        if (this.av.zk()) {
            com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
            cwVar.ae(cwVar.uq());
        }
        com.ss.android.socialbase.downloader.m.j.cw(f38995j, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.av.uq() + ",  downloadInfo.getTotalBytes() = " + this.av.ka());
        if (this.av.uq() > 0) {
            if (this.av.nt()) {
                return true;
            }
            if (this.av.ka() > 0 && this.av.uq() == this.av.ka()) {
                return true;
            }
        }
        this.av.j(com.ss.android.socialbase.downloader.xt.xt.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.av.so();
        this.az.j(this.av);
        this.az.r(this.av.ae());
        this.az.jy(this.av.ae());
        com.ss.android.socialbase.downloader.az.m.j(this.av);
        return false;
    }

    private boolean g() {
        int i6 = this.av.i();
        if (i6 == 1 || this.av.ig()) {
            return true;
        }
        if (i6 == -2 || i6 == -4) {
            return false;
        }
        xt(new com.ss.android.socialbase.downloader.up.j(1000, "The download Task can't start, because its status is not prepare:" + i6));
        return false;
    }

    private void gq() throws com.ss.android.socialbase.downloader.up.j {
        if (TextUtils.isEmpty(this.av.qv())) {
            throw new com.ss.android.socialbase.downloader.up.j(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.av.tl())) {
            throw new com.ss.android.socialbase.downloader.up.j(1029, "download name can not be empty");
        }
        File file = new File(this.av.qv());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.ss.android.socialbase.downloader.az.r.xt(this.av)) {
                throw new com.ss.android.socialbase.downloader.up.j(1031, "download savePath is not a directory:" + this.av.qv());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new com.ss.android.socialbase.downloader.up.j(1031, "download savePath is not directory:path=" + this.av.qv());
        }
        boolean mkdirs = file.mkdirs();
        if (mkdirs || file.exists()) {
            return;
        }
        int i6 = 0;
        if (com.ss.android.socialbase.downloader.jy.j.j(this.av.ae()).j("opt_mkdir_failed", 0) != 1) {
            throw new com.ss.android.socialbase.downloader.up.j(1030, "download savePath directory can not created:" + this.av.qv());
        }
        while (!mkdirs) {
            int i7 = i6 + 1;
            if (i6 >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                mkdirs = file.mkdirs();
                i6 = i7;
            } catch (InterruptedException unused) {
            }
        }
        if (mkdirs || file.exists()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.az.m.r(this.av.qv()) < 16384) {
            throw new com.ss.android.socialbase.downloader.up.j(1006, "download savePath directory can not created:" + this.av.qv());
        }
        throw new com.ss.android.socialbase.downloader.up.j(1030, "download savePath directory can not created:" + this.av.qv());
    }

    private void h() throws com.ss.android.socialbase.downloader.up.j {
        long j6;
        int j7;
        try {
            j6 = com.ss.android.socialbase.downloader.az.m.r(this.av.vl());
        } catch (com.ss.android.socialbase.downloader.up.j unused) {
            j6 = 0;
        }
        String str = f38995j;
        com.ss.android.socialbase.downloader.m.j.cw(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.az.m.j(j6) + "MB");
        if (j6 > 0) {
            long ka = this.av.ka() - this.av.uq();
            if (j6 < ka && (j7 = com.ss.android.socialbase.downloader.jy.j.j(this.av.ae()).j("space_fill_min_keep_mb", 100)) > 0) {
                long j8 = j6 - (j7 * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                com.ss.android.socialbase.downloader.m.j.cw(str, "checkSpaceOverflowInProgress: minKeep  = " + j7 + "MB, canDownload = " + com.ss.android.socialbase.downloader.az.m.j(j8) + "MB");
                if (j8 > 0) {
                    this.rn = this.av.uq() + j8 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    return;
                } else {
                    this.rn = 0L;
                    throw new com.ss.android.socialbase.downloader.up.up(j6, ka);
                }
            }
        }
        this.rn = 0L;
    }

    private void i() {
        com.ss.android.socialbase.downloader.g.ae aeVar = this.ch;
        if (aeVar != null) {
            aeVar.cw();
            this.ch = null;
        }
    }

    private void jy() {
        com.ss.android.socialbase.downloader.m.j.xt(f38995j, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.jy.j.cw().xt("fix_end_for_file_exist_error", true)) {
            if (this.la.equals(this.av.tl())) {
                this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.la.equals(this.av.ws())) {
            this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private void kt() throws com.ss.android.socialbase.downloader.up.j {
        if (this.ae != null) {
            if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED) {
                this.av.r(-4);
                this.ae.cw();
            } else if (this.ws != com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
                this.ae.r();
            } else {
                this.av.r(-2);
                this.ae.xt();
            }
        }
    }

    private void l() throws com.ss.android.socialbase.downloader.up.oq, com.ss.android.socialbase.downloader.up.j {
        com.ss.android.socialbase.downloader.impls.j p5;
        int ae = this.av.ae();
        int j6 = com.ss.android.socialbase.downloader.downloader.cw.j(this.av);
        if (this.av.m126if() && !this.av.ki() && !this.gq) {
            throw new com.ss.android.socialbase.downloader.up.j(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.ae.cw xt = this.az.xt(j6);
        if (xt == null || (p5 = com.ss.android.socialbase.downloader.downloader.cw.p()) == null || xt.ae() == ae || !xt.xt(this.av)) {
            return;
        }
        if (p5.j(xt.ae())) {
            this.az.m(ae);
            throw new com.ss.android.socialbase.downloader.up.j(1025, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.ae.xt> cw = this.az.cw(j6);
        com.ss.android.socialbase.downloader.az.m.j(this.av);
        this.az.m(j6);
        if (xt.xj()) {
            this.av.j(xt, false);
            this.az.j(this.av);
            if (cw != null) {
                for (com.ss.android.socialbase.downloader.ae.xt xtVar : cw) {
                    xtVar.xt(ae);
                    this.az.j(xtVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.up.oq("retry task because id generator changed");
        }
    }

    private void la() throws com.ss.android.socialbase.downloader.up.ae {
        if (this.av.x() && !com.ss.android.socialbase.downloader.az.m.j(com.ss.android.socialbase.downloader.downloader.cw.nd(), com.kuaishou.weapon.p0.g.f36042b)) {
            throw new com.ss.android.socialbase.downloader.up.ae(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", com.kuaishou.weapon.p0.g.f36042b));
        }
        if (!this.av.dj()) {
            throw new com.ss.android.socialbase.downloader.up.r();
        }
        if (!this.av.kk()) {
            throw new com.ss.android.socialbase.downloader.up.m();
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00f4: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:91:0x0101 (LINE:246), block:B:90:0x00f4 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3 A[Catch: all -> 0x00d4, TryCatch #8 {all -> 0x00d4, blocks: (B:33:0x00af, B:35:0x00b3, B:37:0x00b7, B:71:0x00f1), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void oq() throws com.ss.android.socialbase.downloader.up.xt {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.cw.oq():void");
    }

    private boolean p() {
        com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
        return (cwVar == null || cwVar.ki() || (this.f38999g && this.av.kj() <= 1) || this.av.qg() || !this.oq || this.vl) ? false : true;
    }

    private void qv() {
        Process.setThreadPriority(10);
        try {
            com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
            if (cwVar != null && this.wq > 0) {
                cwVar.cw(System.currentTimeMillis() - this.wq);
            }
        } catch (Throwable unused) {
        }
        try {
            s cw = this.cw.cw();
            if (cw != null) {
                if (cw.j()) {
                    this.f38998f.up();
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        if (!g()) {
            l up = this.cw.up();
            com.ss.android.socialbase.downloader.ae.cw cwVar2 = this.av;
            com.ss.android.socialbase.downloader.up.j jVar = new com.ss.android.socialbase.downloader.up.j(1003, "task status is invalid");
            com.ss.android.socialbase.downloader.ae.cw cwVar3 = this.av;
            com.ss.android.socialbase.downloader.tl.j.j(up, cwVar2, jVar, cwVar3 != null ? cwVar3.i() : 0);
            return;
        }
        while (true) {
            vl();
            if (!this.f39004p) {
                return;
            }
            if (this.f39002l > 0) {
                this.f39002l--;
            } else {
                if (this.av.uq() != this.av.ka()) {
                    com.ss.android.socialbase.downloader.m.j.xt(f38995j, this.av.r());
                    this.f38998f.j(new com.ss.android.socialbase.downloader.up.ae(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.av.ik()));
                    return;
                }
                if (this.av.uq() <= 0) {
                    com.ss.android.socialbase.downloader.m.j.xt(f38995j, this.av.r());
                    this.f38998f.j(new com.ss.android.socialbase.downloader.up.ae(1026, "curBytes is 0, bytes invalid retry status is : " + this.av.ik()));
                    return;
                }
                if (this.av.ka() <= 0) {
                    com.ss.android.socialbase.downloader.m.j.xt(f38995j, this.av.r());
                    this.f38998f.j(new com.ss.android.socialbase.downloader.up.ae(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.av.ik()));
                    return;
                }
            }
        }
    }

    private boolean r(com.ss.android.socialbase.downloader.up.j jVar) {
        AtomicInteger atomicInteger = this.up;
        boolean z5 = true;
        if (atomicInteger == null) {
            xt(new com.ss.android.socialbase.downloader.up.j(1043, "retry for exception, but retain retry time is null, last error is :" + jVar.xt()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (jVar != null && jVar.j() == 1070)) {
            if (this.av.os()) {
                this.up.set(this.av.gx());
                this.av.g(this.up.get());
            } else {
                if (jVar == null || ((jVar.j() != 1011 && (jVar.getCause() == null || !(jVar.getCause() instanceof SSLHandshakeException))) || !this.av.ej())) {
                    xt(new com.ss.android.socialbase.downloader.up.j(jVar.j(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.up), String.valueOf(this.av.c()), jVar.xt())));
                    return true;
                }
                this.up.set(this.av.c());
                this.av.g(this.up.get());
                this.av.jy(true);
            }
            z5 = false;
        }
        if (this.ws != com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_RETRY_DELAY && z5) {
            this.av.g(this.up.decrementAndGet());
        }
        return false;
    }

    private void rn() {
        long m6 = com.ss.android.socialbase.downloader.az.m.m(this.av);
        long uq = this.av.uq();
        if (m6 != uq) {
            com.ss.android.socialbase.downloader.m.j.r(f38995j, "checkTaskCanResume: offset = " + m6 + ", curBytes = " + uq);
        }
        this.av.up(m6);
        boolean z5 = m6 > 0;
        this.f38999g = z5;
        if (z5 || this.gq) {
            return;
        }
        com.ss.android.socialbase.downloader.m.j.cw(f38995j, "checkTaskCanResume: deleteAllDownloadFiles");
        this.az.r(this.av.ae());
        this.az.jy(this.av.ae());
        com.ss.android.socialbase.downloader.az.m.j(this.av);
    }

    private void s() {
        this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_NONE;
    }

    private boolean tj() {
        return this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED || this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE;
    }

    private void tl() {
        com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
        if (cwVar == null) {
            return;
        }
        int c6 = cwVar.c() - this.av.fx();
        if (c6 < 0) {
            c6 = 0;
        }
        AtomicInteger atomicInteger = this.up;
        if (atomicInteger == null) {
            this.up = new AtomicInteger(c6);
        } else {
            atomicInteger.set(c6);
        }
    }

    private void uf() {
        try {
            Iterator it = ((ArrayList) this.f39003m.clone()).iterator();
            while (it.hasNext()) {
                xt xtVar = (xt) it.next();
                if (xtVar != null) {
                    xtVar.xt();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.j.cw(f38995j, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private boolean v() {
        if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_ERROR) {
            this.f38998f.j(this.f39007v);
        } else if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED) {
            this.f38998f.cw();
        } else if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
            this.f38998f.r();
        } else if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.f38998f.ae();
            } catch (com.ss.android.socialbase.downloader.up.j e6) {
                this.f38998f.j(e6);
            }
        } else if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.f38998f.j(this.la);
            } catch (com.ss.android.socialbase.downloader.up.j e7) {
                this.f38998f.j(e7);
            }
        } else {
            if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.f38998f.j(this.f39007v, false);
                return false;
            }
            if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.xt.oq oqVar = this.ws;
            com.ss.android.socialbase.downloader.xt.oq oqVar2 = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_RETRY_DELAY;
            if (oqVar == oqVar2 && !x()) {
                com.ss.android.socialbase.downloader.m.j.xt(f38995j, "doTaskStatusHandle retryDelay");
                s();
                return this.ws == oqVar2;
            }
            try {
                if (!ch()) {
                    return false;
                }
                this.f38998f.m();
                w.j().r();
            } catch (Throwable th) {
                xt(new com.ss.android.socialbase.downloader.up.j(1008, com.ss.android.socialbase.downloader.az.m.xt(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private void vl() {
        boolean z5;
        char c6;
        List<com.ss.android.socialbase.downloader.ae.xt> cw;
        com.ss.android.socialbase.downloader.ae.xt j6;
        List<com.ss.android.socialbase.downloader.ae.up> j7;
        long currentTimeMillis;
        try {
            this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_NONE;
            this.av.z();
            this.av.wf();
            long currentTimeMillis2 = System.currentTimeMillis();
            this.av.j(-1L);
            int i6 = 0;
            try {
                oq();
                z5 = false;
            } catch (com.ss.android.socialbase.downloader.up.xt e6) {
                com.ss.android.socialbase.downloader.m.j.xt(f38995j, "file exist " + e6.r());
                this.la = e6.r();
                z5 = true;
            }
            if (!this.f39004p) {
                this.f38998f.xt();
            }
            this.f39004p = false;
            if (f()) {
                return;
            }
            if (!TextUtils.isEmpty(this.la) && z5) {
                if (this.av.ki()) {
                    this.gq = com.ss.android.socialbase.downloader.az.m.r(this.av);
                }
                if (!this.gq) {
                    jy();
                    return;
                }
            }
            while (!f()) {
                try {
                    try {
                        try {
                            gq();
                            l();
                            la();
                            cw = this.az.cw(this.av.ae());
                            rn();
                        } catch (com.ss.android.socialbase.downloader.up.j e7) {
                            e = e7;
                            c6 = 0;
                        } catch (com.ss.android.socialbase.downloader.up.oq e8) {
                            e = e8;
                            c6 = 0;
                        }
                    } catch (com.ss.android.socialbase.downloader.up.xt unused) {
                        jy();
                    }
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.m.j.r(f38995j, "downloadInner: throwable =  " + th);
                    if (this.ws != com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
                        xt(new com.ss.android.socialbase.downloader.up.j(1045, th));
                    }
                }
                if (ws()) {
                    com.ss.android.socialbase.downloader.m.j.cw(f38995j, "downloadSegments return");
                    mi();
                    return;
                }
                String ol = this.av.ol();
                if (f()) {
                    mi();
                    return;
                }
                long up = this.f38999g ? com.ss.android.socialbase.downloader.az.m.up(this.av) : 0L;
                try {
                    j6 = j(this.av, up);
                    j7 = j(j6);
                    com.ss.android.socialbase.downloader.az.m.j(j7, this.av);
                    com.ss.android.socialbase.downloader.az.m.xt(j7, this.av);
                    this.av.az(i6);
                    currentTimeMillis = System.currentTimeMillis();
                } catch (com.ss.android.socialbase.downloader.up.j e9) {
                    e = e9;
                    com.ss.android.socialbase.downloader.m.j.r(f38995j, "downloadInner: baseException = " + e);
                    if (this.ws != com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
                        if (e.j() != 1025 && e.j() != 1009) {
                            if (j(e)) {
                                if (com.ss.android.socialbase.downloader.az.m.j(e)) {
                                    wq();
                                }
                                if (j(e, 0L) == com.ss.android.socialbase.downloader.up.g.RETURN) {
                                    mi();
                                    return;
                                }
                                mi();
                                i6 = 0;
                            } else {
                                xt(e);
                            }
                        }
                        this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_END_RIGHT_NOW;
                        mi();
                        return;
                    }
                    mi();
                    return;
                } catch (com.ss.android.socialbase.downloader.up.oq e10) {
                    e = e10;
                    try {
                        com.ss.android.socialbase.downloader.m.j.r(f38995j, "downloadInner: retry throwable for " + e.j());
                        if (this.ws != com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
                            AtomicInteger atomicInteger = this.up;
                            if (atomicInteger != null && atomicInteger.get() > 0) {
                                this.av.g(this.up.decrementAndGet());
                                this.av.r(5);
                            } else if (this.up == null) {
                                xt(new com.ss.android.socialbase.downloader.up.j(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e.j()));
                            } else if (this.av.os()) {
                                this.av.r(5);
                                this.up.set(this.av.c());
                                this.av.g(this.up.get());
                            } else {
                                String valueOf = String.valueOf(this.av.c());
                                String j8 = e.j();
                                Object[] objArr = new Object[2];
                                objArr[c6] = valueOf;
                                objArr[1] = j8;
                                xt(new com.ss.android.socialbase.downloader.up.j(PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", objArr)));
                            }
                            mi();
                            i6 = 0;
                        }
                        mi();
                        return;
                    } catch (Throwable th2) {
                        mi();
                        throw th2;
                    }
                }
                try {
                    j(ol, j7, up);
                    this.av.xt(System.currentTimeMillis() - currentTimeMillis);
                    if (f()) {
                        mi();
                        return;
                    }
                    long ka = this.av.ka();
                    j(ka);
                    int j9 = j(ka, cw);
                    if (f()) {
                        mi();
                        return;
                    }
                    if (j9 <= 0) {
                        throw new com.ss.android.socialbase.downloader.up.j(1032, "chunkCount is 0");
                    }
                    boolean z6 = j9 == 1;
                    this.tl = z6;
                    if (z6) {
                        if (this.f39009x == null) {
                            try {
                                currentTimeMillis = System.currentTimeMillis();
                                j(ol, j7);
                                this.av.xt(System.currentTimeMillis() - currentTimeMillis);
                            } finally {
                                this.av.xt(System.currentTimeMillis() - currentTimeMillis);
                            }
                        }
                        if (f()) {
                            mi();
                            return;
                        } else {
                            this.av.j(System.currentTimeMillis() - currentTimeMillis2);
                            az();
                            j(j6, ol, this.f39009x);
                        }
                    } else {
                        if (!this.av.ln()) {
                            w();
                        }
                        if (f()) {
                            mi();
                            return;
                        }
                        az();
                        this.av.j(System.currentTimeMillis() - currentTimeMillis2);
                        if (this.f38999g) {
                            j(j9, cw);
                        } else {
                            j(ka, j9);
                        }
                    }
                    mi();
                    return;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        } finally {
            av();
        }
    }

    private void w() {
        com.ss.android.socialbase.downloader.g.g gVar = this.f39009x;
        if (gVar != null) {
            gVar.r();
            this.f39009x = null;
        }
    }

    private void wq() {
        com.ss.android.socialbase.downloader.m.j.r(f38995j, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.az.r(this.av.ae());
            this.az.jy(this.av.ae());
            com.ss.android.socialbase.downloader.az.m.j(this.av);
            this.f38999g = false;
            this.av.vl("");
            this.az.j(this.av);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private boolean ws() throws com.ss.android.socialbase.downloader.up.j, InterruptedException {
        if (this.av.ki() || this.av.kj() != 1 || this.av.sh() > 0) {
            return false;
        }
        JSONObject r5 = com.ss.android.socialbase.downloader.jy.j.j(this.av.ae()).r("segment_config");
        List<com.ss.android.socialbase.downloader.qv.g> ws = this.az.ws(this.av.ae());
        if (this.av.uq() > 0) {
            if (ws == null || ws.isEmpty()) {
                return false;
            }
            if (r5 == null) {
                r5 = new JSONObject();
            }
        }
        if (r5 == null) {
            return false;
        }
        this.f38997c = new qv(this.av, ws.j(r5), this);
        if (!f()) {
            return this.f38997c.j(ws);
        }
        com.ss.android.socialbase.downloader.m.j.cw(f38995j, "downloadSegments: is stopped by user");
        if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED) {
            this.f38997c.j();
        } else {
            this.f38997c.xt();
        }
        return true;
    }

    private boolean x() {
        if (this.av.kj() <= 1) {
            return this.av.uq() > 0 && this.av.uq() == this.av.ka();
        }
        List<com.ss.android.socialbase.downloader.ae.xt> cw = this.az.cw(this.av.ae());
        if (cw == null || cw.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.ae.xt xtVar : cw) {
            if (xtVar == null || !xtVar.g()) {
                return false;
            }
        }
        return true;
    }

    public Future ae() {
        return this.xt;
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public void cw(com.ss.android.socialbase.downloader.up.j jVar) {
        com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
        if (cwVar != null) {
            cwVar.ws(true);
        }
        j(jVar, false);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.cw.j(this.cw, 3);
        try {
            com.ss.android.socialbase.downloader.g.xt.j().xt();
            qv();
            com.ss.android.socialbase.downloader.g.xt.j().cw();
            com.ss.android.socialbase.downloader.downloader.cw.xt(this.cw, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.g.xt.j().cw();
            throw th;
        }
    }

    public int up() {
        com.ss.android.socialbase.downloader.ae.cw cwVar = this.av;
        if (cwVar != null) {
            return cwVar.ae();
        }
        return 0;
    }

    public cw(com.ss.android.socialbase.downloader.ae.r rVar, Handler handler) {
        this.cw = rVar;
        if (rVar != null) {
            this.av = rVar.j();
            this.f39001i = rVar.m();
            this.mi = rVar.kt();
            this.f39006s = rVar.tl();
            this.f38996a = rVar.g();
            this.tj = j(rVar);
            this.uf = com.ss.android.socialbase.downloader.jy.j.j(this.av.ae());
        } else {
            this.uf = com.ss.android.socialbase.downloader.jy.j.cw();
        }
        tl();
        this.az = com.ss.android.socialbase.downloader.downloader.cw.x();
        this.f39008w = com.ss.android.socialbase.downloader.downloader.cw.uf();
        this.kt = com.ss.android.socialbase.downloader.downloader.cw.c();
        this.f38998f = new com.ss.android.socialbase.downloader.downloader.m(rVar, handler);
        this.jy = new AtomicBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed() {
        com.ss.android.socialbase.downloader.impls.j p5;
        if (!f() && (p5 = com.ss.android.socialbase.downloader.downloader.cw.p()) != null) {
            p5.vl(this.av.ae());
        }
    }

    private boolean f() {
        if (!tj() && this.av.i() != -2) {
            return false;
        }
        if (!tj()) {
            if (this.av.i() == -2) {
                this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE;
                return true;
            }
            if (this.av.i() == -4) {
                this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED;
                return true;
            }
            return true;
        }
        return true;
    }

    private void mi() {
        i();
        w();
    }

    public void j() {
        com.ss.android.socialbase.downloader.xt.oq oqVar = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE;
        this.ws = oqVar;
        if (this.f38997c != null) {
            this.f38997c.xt();
        }
        if (this.ae != null) {
            this.ae.xt();
        }
        if (this.f38997c == null && this.ae == null) {
            mi();
            this.ws = oqVar;
            av();
        }
        try {
            Iterator it = ((ArrayList) this.f39003m.clone()).iterator();
            while (it.hasNext()) {
                xt xtVar = (xt) it.next();
                if (xtVar != null) {
                    xtVar.j();
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void m() {
        this.wq = System.currentTimeMillis();
        this.f38998f.j();
    }

    private void xt(String str, List<com.ss.android.socialbase.downloader.ae.up> list, long j6) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        com.ss.android.socialbase.downloader.g.j.cw j7;
        boolean z5 = true;
        if (this.av.kj() == 1 && (j7 = com.ss.android.socialbase.downloader.g.j.j.j().j(str, list)) != null) {
            this.ch = j7;
            this.av.az(1);
        }
        if (this.ch == null && !this.f39000h && this.av.y()) {
            try {
                int xt = this.uf.xt("net_lib_strategy");
                if (this.uf.j("monitor_download_connect", 0) <= 0) {
                    z5 = false;
                }
                this.ch = com.ss.android.socialbase.downloader.downloader.cw.j(str, list, xt, z5, this.av);
            } catch (Throwable th) {
                this.av.j(com.ss.android.socialbase.downloader.az.m.oq(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
    
        if (r9 <= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int j(long r7, java.util.List<com.ss.android.socialbase.downloader.ae.xt> r9) {
        /*
            r6 = this;
            boolean r0 = r6.p()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.f38999g
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.ae.cw r9 = r6.av
            int r9 = r9.kj()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.oq r9 = r6.f39001i
            if (r9 == 0) goto L23
            int r9 = r9.j(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.oq r9 = r6.f39008w
            int r9 = r9.j(r7)
        L29:
            com.ss.android.socialbase.downloader.g.vl r0 = com.ss.android.socialbase.downloader.g.vl.j()
            com.ss.android.socialbase.downloader.g.jy r0 = r0.xt()
            java.lang.String r3 = com.ss.android.socialbase.downloader.ws.cw.f38995j
            java.lang.String r4 = r0.name()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r4
            java.lang.String r4 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r4, r5)
            com.ss.android.socialbase.downloader.m.j.xt(r3, r4)
            com.ss.android.socialbase.downloader.ae.cw r3 = r6.av
            java.lang.String r4 = r0.name()
            r3.tl(r4)
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.mi
            if (r3 == 0) goto L56
            int r9 = r3.j(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.kt
            int r9 = r3.j(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.m.j.j()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.ws.cw.f38995j
            java.lang.String r3 = java.lang.String.valueOf(r9)
            com.ss.android.socialbase.downloader.ae.cw r4 = r6.av
            java.lang.String r4 = r4.tl()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r3
            r8[r2] = r4
            r1 = 2
            r8[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r8)
            com.ss.android.socialbase.downloader.m.j.xt(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.cw.j(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public boolean xt(long j6) throws com.ss.android.socialbase.downloader.up.j {
        if (this.rn > 0 && this.av.uq() > this.rn) {
            h();
        }
        return this.f38998f.j(j6);
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public void xt(com.ss.android.socialbase.downloader.up.j jVar) {
        com.ss.android.socialbase.downloader.m.j.xt(f38995j, "onError:" + jVar.getMessage());
        this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_ERROR;
        this.f39007v = jVar;
        uf();
    }

    private void j(String str, List<com.ss.android.socialbase.downloader.ae.up> list, long j6) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        xt(str, list, j6);
        com.ss.android.socialbase.downloader.g.ae aeVar = this.ch;
        if (aeVar != null) {
            try {
                j(str, aeVar, j6);
            } catch (Throwable unused) {
                this.f39000h = true;
            }
        }
        if (this.ch == null || this.f39000h) {
            j(str, list);
            j(str, this.f39009x, j6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(java.lang.String r11, java.util.List<com.ss.android.socialbase.downloader.ae.up> r12) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.cw.j(java.lang.String, java.util.List):void");
    }

    public static com.ss.android.socialbase.downloader.ae.xt j(com.ss.android.socialbase.downloader.ae.cw cwVar, long j6) {
        return new xt.j(cwVar.ae()).j(-1).j(0L).up(j6).xt(j6).cw(0L).r(cwVar.ka() - j6).j();
    }

    private List<com.ss.android.socialbase.downloader.ae.up> j(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        List<com.ss.android.socialbase.downloader.ae.up> j6 = com.ss.android.socialbase.downloader.az.m.j(this.av.uf(), this.av.u(), xtVar);
        if (this.av.ki() && this.gq && this.av.zz() != null) {
            j6.add(new com.ss.android.socialbase.downloader.ae.up("if-modified-since", this.av.zz()));
            j6.add(new com.ss.android.socialbase.downloader.ae.up("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.m.j.xt(f38995j, "dcache::add head IF_MODIFIED_SINCE=" + this.av.zz());
        }
        return j6;
    }

    private void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) throws com.ss.android.socialbase.downloader.up.j {
        if (list.size() == i6) {
            j(list, this.av.ka());
            return;
        }
        throw new com.ss.android.socialbase.downloader.up.j(1033, new IllegalArgumentException());
    }

    private void j(long j6, int i6) throws com.ss.android.socialbase.downloader.up.j {
        long j7 = j6 / i6;
        int ae = this.av.ae();
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        long j8 = 0;
        while (i7 < i6) {
            com.ss.android.socialbase.downloader.ae.xt j9 = new xt.j(ae).j(i7).j(j8).up(j8).xt(j8).cw(i7 == i6 + (-1) ? 0L : (j8 + j7) - 1).j();
            arrayList.add(j9);
            this.az.j(j9);
            j8 += j7;
            i7++;
        }
        this.av.up(i6);
        this.az.j(ae, i6);
        j(arrayList, j6);
    }

    private void j(List<com.ss.android.socialbase.downloader.ae.xt> list, long j6) throws com.ss.android.socialbase.downloader.up.j {
        long av;
        for (com.ss.android.socialbase.downloader.ae.xt xtVar : list) {
            if (xtVar != null) {
                if (xtVar.av() == 0) {
                    av = j6 - xtVar.ws();
                } else {
                    av = (xtVar.av() - xtVar.ws()) + 1;
                }
                if (av > 0) {
                    xtVar.j(av);
                    if (this.av.ln() && this.f39009x != null && (!this.av.y() || this.f39000h)) {
                        if (xtVar.mi() == 0) {
                            this.f39003m.add(new xt(xtVar, this.cw, this.f39009x, this));
                        } else if (xtVar.mi() > 0) {
                            this.f39003m.add(new xt(xtVar, this.cw, this));
                        }
                    } else {
                        this.f39003m.add(new xt(xtVar, this.cw, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.az.j.j(64)) {
            ArrayList arrayList = new ArrayList(this.f39003m.size());
            Iterator<xt> it = this.f39003m.iterator();
            while (it.hasNext()) {
                xt next = it.next();
                if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED) {
                    next.xt();
                } else if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
                    next.j();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> r5 = com.ss.android.socialbase.downloader.impls.up.r(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.up.up(r5)) {
                    if (f()) {
                        return;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.vl.j(th);
                    }
                }
                if (r5 == null || r5.isEmpty()) {
                    return;
                }
                for (Future future : r5) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f39003m.size());
        Iterator<xt> it2 = this.f39003m.iterator();
        while (it2.hasNext()) {
            xt next2 = it2.next();
            if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_CANCELED) {
                next2.xt();
            } else if (this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_PAUSE) {
                next2.j();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (f()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.up.cw(arrayList2);
        } catch (InterruptedException e6) {
            throw new com.ss.android.socialbase.downloader.up.j(PointerIconCompat.TYPE_GRAB, e6);
        }
    }

    private void j(com.ss.android.socialbase.downloader.ae.xt xtVar, String str, com.ss.android.socialbase.downloader.g.g gVar) throws com.ss.android.socialbase.downloader.up.j {
        xtVar.j(this.av.ka() - xtVar.ws());
        this.av.up(1);
        this.az.j(this.av.ae(), 1);
        this.ae = new com.ss.android.socialbase.downloader.downloader.up(this.av, str, gVar, xtVar, this);
        kt();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|8|(4:10|(1:12)(1:68)|13|(2:15|(12:17|(2:19|(1:21)(2:22|23))|24|(1:26)|56|28|29|30|31|32|33|34)(2:57|(6:59|30|31|32|33|34)(4:60|(1:62)(1:65)|63|64)))(1:66))(2:69|(4:71|(1:73)(1:76)|74|75)(2:77|(2:79|80)))|67|29|30|31|32|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0103, code lost:
    
        if (r10 > r26) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x016c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x016d, code lost:
    
        com.ss.android.socialbase.downloader.m.j.up(com.ss.android.socialbase.downloader.ws.cw.f38995j, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x018a, code lost:
    
        if (r10 >= r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0194, code lost:
    
        r7.xt(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0198, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0199, code lost:
    
        com.ss.android.socialbase.downloader.m.j.up(com.ss.android.socialbase.downloader.ws.cw.f38995j, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01b2, code lost:
    
        if (r2 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ba, code lost:
    
        throw new com.ss.android.socialbase.downloader.up.j(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.KeyIsPreloadWaitListType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01bb, code lost:
    
        if (r2 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01cd, code lost:
    
        throw new com.ss.android.socialbase.downloader.up.j(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.KeyIsPreloadWaitListType, r0);
     */
    @Override // com.ss.android.socialbase.downloader.ws.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(long r26) throws com.ss.android.socialbase.downloader.up.j {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.cw.j(long):void");
    }

    private boolean j(int i6, String str, String str2) {
        if (i6 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.qv || this.oq)) {
            return (i6 == 201 || i6 == 416) && this.av.uq() > 0;
        }
        return true;
    }

    private void j(String str, String str2) throws com.ss.android.socialbase.downloader.up.oq {
        this.az.r(this.av.ae());
        this.az.jy(this.av.ae());
        com.ss.android.socialbase.downloader.az.m.j(this.av);
        this.f38999g = false;
        this.av.vl(str);
        this.az.j(this.av);
        throw new com.ss.android.socialbase.downloader.up.oq(str2);
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public void j(String str, com.ss.android.socialbase.downloader.g.ae aeVar, long j6) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        String str2;
        long j7;
        long j8;
        if (aeVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.ae.m mVar = new com.ss.android.socialbase.downloader.ae.m(str, aeVar);
            int i6 = mVar.cw;
            String r5 = mVar.r();
            if (TextUtils.isEmpty(this.av.xw()) && !TextUtils.isEmpty(r5)) {
                this.av.oq(r5);
            }
            boolean xt = mVar.xt();
            this.oq = xt;
            this.av.qv(xt);
            this.qv = mVar.j();
            String u5 = this.av.u();
            String cw = mVar.cw();
            String m6 = mVar.m();
            String ae = mVar.ae();
            String str3 = f38995j;
            StringBuilder sb = new StringBuilder("dcache=responseCode=");
            sb.append(i6);
            sb.append(" last_modified=");
            sb.append(m6);
            sb.append(" CACHE_CONTROL=");
            sb.append(ae);
            sb.append(" max-age=");
            String str4 = cw;
            sb.append(mVar.qv());
            sb.append(" isDeleteCacheIfCheckFailed=");
            sb.append(this.av.im());
            com.ss.android.socialbase.downloader.m.j.xt(str3, sb.toString());
            com.ss.android.socialbase.downloader.m.j.xt(str3, "dcache=firstOffset=" + j6 + " cur=" + m6 + " before=" + this.av.zz() + " cur=" + mVar.oq() + " before=" + this.av.ka());
            if (!TextUtils.isEmpty(ae)) {
                this.av.cw(ae);
                if (mVar.qv() > 0) {
                    this.av.r(System.currentTimeMillis() + (mVar.qv() * 1000));
                }
            }
            if (this.av.ki() && this.gq && !TextUtils.isEmpty(this.la)) {
                if (i6 == 304 || ((!TextUtils.isEmpty(this.av.zz()) || !this.av.im()) && TextUtils.equals(m6, this.av.zz()))) {
                    com.ss.android.socialbase.downloader.m.j.xt(str3, "dcache=responseCode=" + i6 + " lastModified not changed, use local file  " + m6);
                    throw new com.ss.android.socialbase.downloader.up.xt(this.la);
                }
                com.ss.android.socialbase.downloader.az.m.j(this.av);
            }
            if (j6 > 0 && this.av.ki() && !TextUtils.equals(m6, this.av.zz())) {
                com.ss.android.socialbase.downloader.m.j.xt(str3, "dcache cdn file change, so retry");
                j("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(m6)) {
                this.av.r(m6);
            }
            if (j(i6, u5, str4)) {
                if (aeVar instanceof com.ss.android.socialbase.downloader.g.g) {
                    if (!TextUtils.isEmpty(u5) && u5.equals(str4)) {
                        str4 = "";
                    }
                    j(str4, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.up.cw(1002, i6, "");
                }
            }
            if (!this.oq && !this.qv) {
                if (i6 == 403) {
                    throw new com.ss.android.socialbase.downloader.up.j(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.up.cw(1004, i6, "response code error : " + i6);
            }
            if (this.qv && j6 > 0) {
                if (aeVar instanceof com.ss.android.socialbase.downloader.g.g) {
                    j("", "http head request not support");
                } else {
                    throw new com.ss.android.socialbase.downloader.up.j(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long tl = mVar.tl();
            if (!(aeVar instanceof com.ss.android.socialbase.downloader.g.g) && tl < 0 && com.ss.android.socialbase.downloader.az.r.j(this.av)) {
                throw new com.ss.android.socialbase.downloader.up.j(1004, "");
            }
            if (!TextUtils.isEmpty(this.av.tl())) {
                str2 = "";
            } else {
                str2 = com.ss.android.socialbase.downloader.az.m.j(aeVar, this.av.oq());
            }
            boolean g6 = mVar.g();
            this.vl = g6;
            if (!g6 && tl == 0 && !(aeVar instanceof com.ss.android.socialbase.downloader.g.g)) {
                throw new com.ss.android.socialbase.downloader.up.j(1004, "");
            }
            if (g6) {
                j7 = 0;
                j8 = -1;
            } else {
                String xt2 = com.ss.android.socialbase.downloader.az.m.xt(aeVar, "Content-Range");
                com.ss.android.socialbase.downloader.m.j.cw(str3, "firstConnection: contentRange = " + xt2);
                if (!TextUtils.isEmpty(xt2) && this.uf.xt("fix_get_total_bytes", true)) {
                    j8 = com.ss.android.socialbase.downloader.az.m.xt(xt2);
                    com.ss.android.socialbase.downloader.m.j.cw(str3, "firstConnection: 1 totalLength = " + j8);
                    j7 = 0L;
                } else {
                    j7 = 0;
                    long j9 = j6 + tl;
                    com.ss.android.socialbase.downloader.m.j.up(str3, "firstConnection: 2 totalLength = " + j9 + ", contentLength = " + tl);
                    j8 = j9;
                }
            }
            if (!TextUtils.isEmpty(this.av.s()) && this.av.ka() > j7 && j8 != this.av.ka()) {
                if (aeVar instanceof com.ss.android.socialbase.downloader.g.g) {
                    j("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.up.cw(1002, i6, "");
                }
            }
            if (f()) {
                return;
            }
            if (this.av.wq() > j7 && com.ss.android.socialbase.downloader.jy.j.j(this.av.ae()).xt("force_check_file_length") == 1 && this.av.wq() != j8) {
                throw new com.ss.android.socialbase.downloader.up.j(1070, "expectFileLength = " + this.av.wq() + " , totalLength = " + j8);
            }
            this.f38998f.j(j8, str4, str2);
        } catch (com.ss.android.socialbase.downloader.up.j e6) {
            throw e6;
        } catch (com.ss.android.socialbase.downloader.up.oq e7) {
            throw e7;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.az.m.j(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public void j(xt xtVar) {
        if (this.tl) {
            return;
        }
        synchronized (this) {
            this.f39003m.remove(xtVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public boolean j(com.ss.android.socialbase.downloader.up.j jVar) {
        if (this.f38997c != null && com.ss.android.socialbase.downloader.az.m.g(jVar) && this.up.get() < this.av.c()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.az.m.xt(jVar)) {
            if (this.tl && !this.f39005r) {
                com.ss.android.socialbase.downloader.az.m.j(this.av);
                this.f39005r = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.up;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.av.to() || (jVar != null && ((jVar.j() == 1011 || (jVar.getCause() != null && (jVar.getCause() instanceof SSLHandshakeException))) && this.av.ej()))) && !(jVar instanceof com.ss.android.socialbase.downloader.up.ae);
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public void j(com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        com.ss.android.socialbase.downloader.m.j.xt(f38995j, "onAllChunkRetryWithReset");
        this.ws = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.f39007v = jVar;
        uf();
        if (z5 ? r(jVar) : false) {
            return;
        }
        wq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.av.j(list, this.ws == com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.j p5 = com.ss.android.socialbase.downloader.downloader.cw.p();
        if (p5 != null) {
            p5.vl(this.av.ae());
        }
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public com.ss.android.socialbase.downloader.up.g j(com.ss.android.socialbase.downloader.ae.xt xtVar, com.ss.android.socialbase.downloader.up.j jVar, long j6) {
        if (tj()) {
            return com.ss.android.socialbase.downloader.up.g.RETURN;
        }
        if (jVar != null && (jVar.j() == 1047 || com.ss.android.socialbase.downloader.az.m.tl(jVar))) {
            return j(jVar, j6);
        }
        this.f39007v = jVar;
        this.av.m(-j6);
        this.az.j(this.av);
        if (r(jVar)) {
            return com.ss.android.socialbase.downloader.up.g.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.m mVar = this.f38998f;
        com.ss.android.socialbase.downloader.xt.oq oqVar = this.ws;
        com.ss.android.socialbase.downloader.xt.oq oqVar2 = com.ss.android.socialbase.downloader.xt.oq.RUN_STATUS_RETRY_DELAY;
        mVar.j(xtVar, jVar, oqVar == oqVar2);
        if (this.ws != oqVar2 && this.av.wi()) {
            long a6 = a();
            if (a6 > 0) {
                com.ss.android.socialbase.downloader.m.j.cw(f38995j, "onSingleChunkRetry with delay time " + a6);
                try {
                    Thread.sleep(a6);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.m.j.r(f38995j, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.up.g.CONTINUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    @Override // com.ss.android.socialbase.downloader.ws.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.android.socialbase.downloader.up.g j(com.ss.android.socialbase.downloader.up.j r7, long r8) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.cw.j(com.ss.android.socialbase.downloader.up.j, long):com.ss.android.socialbase.downloader.up.g");
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public synchronized com.ss.android.socialbase.downloader.ae.xt j(int i6) {
        com.ss.android.socialbase.downloader.ae.xt j6;
        if (this.av.kj() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.ae.xt> cw = this.az.cw(this.av.ae());
        if (cw != null && !cw.isEmpty()) {
            for (int i7 = 0; i7 < cw.size(); i7++) {
                com.ss.android.socialbase.downloader.ae.xt xtVar = cw.get(i7);
                if (xtVar != null && (j6 = j(xtVar, i6)) != null) {
                    return j6;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.ws.m
    public void j(com.ss.android.socialbase.downloader.g.ae aeVar) {
        if (aeVar != null) {
            try {
                int xt = aeVar.xt();
                this.av.ae(xt);
                this.av.g(com.ss.android.socialbase.downloader.az.xt.j(xt));
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
        this.av.ae(-1);
        this.av.g("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
    
        if (r9.m() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.ae.xt j(com.ss.android.socialbase.downloader.ae.xt r9, int r10) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ws.cw.j(com.ss.android.socialbase.downloader.ae.xt, int):com.ss.android.socialbase.downloader.ae.xt");
    }

    private kt j(com.ss.android.socialbase.downloader.ae.r rVar) {
        kt ae = rVar.ae();
        if (ae != null) {
            return ae;
        }
        com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
        if (j6 != null) {
            String tk = j6.tk();
            if (!TextUtils.isEmpty(tk)) {
                return new i(tk);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.cw.gx();
    }

    public void j(Future future) {
        this.xt = future;
    }
}
