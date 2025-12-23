package com.bykv.vk.openvk.component.video.j.xt;

import android.util.Log;
import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bykv.vk.openvk.component.video.j.xt.tl;
import com.bykv.vk.openvk.component.video.j.xt.vl;
import com.bykv.vk.openvk.component.video.j.xt.xt;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* loaded from: D:\Downloads\app\classes3.dex */
class ae extends com.bykv.vk.openvk.component.video.j.xt.j {
    private volatile com.bykv.vk.openvk.component.video.j.xt.xt av;
    private final r az;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f23039i;
    private final Socket jy;
    private final cw ws;

    public interface cw {
        void j(ae aeVar);

        void xt(ae aeVar);
    }

    private static class xt {
        private boolean cw;

        /* renamed from: j, reason: collision with root package name */
        private final OutputStream f23044j;
        private int xt;

        boolean j() {
            return this.cw;
        }

        void xt(byte[] bArr, int i6, int i7) throws com.bykv.vk.openvk.component.video.j.xt.cw.r {
            try {
                this.f23044j.write(bArr, i6, i7);
                this.xt += i7;
            } catch (IOException e6) {
                throw new com.bykv.vk.openvk.component.video.j.xt.cw.r(e6);
            }
        }

        void j(byte[] bArr, int i6, int i7) throws com.bykv.vk.openvk.component.video.j.xt.cw.r {
            if (this.cw) {
                return;
            }
            try {
                this.f23044j.write(bArr, i6, i7);
                this.cw = true;
            } catch (IOException e6) {
                throw new com.bykv.vk.openvk.component.video.j.xt.cw.r(e6);
            }
        }

        xt(OutputStream outputStream, int i6) {
            this.f23044j = outputStream;
            this.xt = i6;
        }

        int xt() {
            return this.xt;
        }
    }

    static final class j {
        Socket cw;

        /* renamed from: j, reason: collision with root package name */
        com.bykv.vk.openvk.component.video.j.xt.j.j f23042j;

        /* renamed from: r, reason: collision with root package name */
        cw f23043r;
        com.bykv.vk.openvk.component.video.j.xt.xt.cw xt;

        j j(com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar) {
            if (cwVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.xt = cwVar;
            return this;
        }

        j() {
        }

        j j(Socket socket) {
            if (socket != null) {
                this.cw = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        j j(cw cwVar) {
            this.f23043r = cwVar;
            return this;
        }

        ae j() {
            if (this.xt != null && this.cw != null) {
                return new ae(this);
            }
            throw new IllegalArgumentException();
        }
    }

    ae(j jVar) {
        super(jVar.f23042j, jVar.xt);
        this.f23039i = true;
        this.jy = jVar.cw;
        this.ws = jVar.f23043r;
        this.az = r.cw();
    }

    private void cw(xt xtVar, vl.j jVar) throws tl.j, com.bykv.vk.openvk.component.video.j.xt.cw.r, IOException, com.bykv.vk.openvk.component.video.j.xt.cw.j, com.bykv.vk.openvk.component.video.j.xt.cw.xt {
        if (this.f23039i) {
            File cw2 = this.f23053j.cw(this.tl);
            long length = cw2.length();
            com.bykv.vk.openvk.component.video.j.xt.xt.j query = this.xt.query(this.tl, this.f23052g.cw.f23048j);
            int xt2 = xtVar.xt();
            if (length > xtVar.xt()) {
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - xt2));
                }
                j(query, cw2, xtVar, jVar);
                return;
            }
        }
        r(xtVar, jVar);
    }

    private void g() {
        com.bykv.vk.openvk.component.video.j.xt.xt xtVar = this.av;
        this.av = null;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    private boolean j(xt xtVar) throws com.bykv.vk.openvk.component.video.j.xt.cw.j {
        while (this.oq.j()) {
            up();
            vl.j xt2 = this.oq.xt();
            try {
                j(xtVar, xt2);
                return true;
            } catch (com.bykv.vk.openvk.component.video.j.xt.cw.cw unused) {
                xt2.j();
                ae();
            } catch (com.bykv.vk.openvk.component.video.j.xt.cw.r e6) {
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
                return true;
            } catch (com.bykv.vk.openvk.component.video.j.xt.cw.xt e7) {
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                }
                return false;
            } catch (tl.j e8) {
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e8));
                }
                this.f23039i = false;
                ae();
            } catch (IOException e9) {
                if (e9 instanceof SocketTimeoutException) {
                    xt2.xt();
                }
                if (!xt()) {
                    ae();
                } else if (up.cw) {
                    if ("Canceled".equalsIgnoreCase(e9.getMessage())) {
                        com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e9));
                    }
                }
            } catch (Exception e10) {
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e10));
                }
            }
        }
        return false;
    }

    private xt tl() {
        try {
            this.f23052g = g.j(this.jy.getInputStream());
            OutputStream outputStream = this.jy.getOutputStream();
            com.bykv.vk.openvk.component.video.j.xt.j.j jVar = this.f23052g.cw.f23048j == 1 ? up.f23103j : up.xt;
            if (jVar == null) {
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.f23053j = jVar;
            this.ae = this.f23052g.cw.xt;
            this.tl = this.f23052g.cw.cw;
            this.oq = new vl(this.f23052g.cw.ae);
            this.f23054m = this.f23052g.xt;
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.f23052g.toString());
            }
            return new xt(outputStream, this.f23052g.cw.f23050r);
        } catch (g.r e6) {
            com.bykv.vk.openvk.component.video.j.cw.j.j(this.jy);
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
            }
            if (this.f23053j != null) {
                ae();
            }
            return null;
        } catch (IOException e7) {
            com.bykv.vk.openvk.component.video.j.cw.j.j(this.jy);
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
            }
            if (this.f23053j != null) {
                ae();
            }
            return null;
        }
    }

    private void xt(xt xtVar, vl.j jVar) throws IOException, com.bykv.vk.openvk.component.video.j.xt.cw.r {
        byte[] j6 = j(this.xt.query(this.tl, this.f23052g.cw.f23048j), xtVar, jVar);
        if (j6 == null) {
            return;
        }
        xtVar.j(j6, 0, j6.length);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.component.video.j.xt.xt.j query;
        xt tl = tl();
        if (tl == null) {
            return;
        }
        cw cwVar = this.ws;
        if (cwVar != null) {
            cwVar.j(this);
        }
        this.f23053j.j(this.tl);
        if (up.tl != 0 && ((query = this.xt.query(this.tl, this.f23052g.cw.f23048j)) == null || this.f23053j.cw(this.tl).length() < query.cw)) {
            this.az.j(ae(), this.tl);
        }
        try {
            j(tl);
        } catch (com.bykv.vk.openvk.component.video.j.xt.cw.j e6) {
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
            }
        } catch (Throwable th) {
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.f23053j.xt(this.tl);
        this.az.j(ae(), null);
        j();
        com.bykv.vk.openvk.component.video.j.cw.j.j(this.jy);
        cw cwVar2 = this.ws;
        if (cwVar2 != null) {
            cwVar2.xt(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0106 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #2 {all -> 0x00f6, blocks: (B:34:0x00ed, B:35:0x0102, B:37:0x0106, B:38:0x014a, B:41:0x015c, B:87:0x015a, B:90:0x00fe), top: B:33:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016b A[Catch: all -> 0x019d, TryCatch #6 {all -> 0x019d, blocks: (B:44:0x0165, B:46:0x016b, B:48:0x0170, B:51:0x01a0, B:58:0x017b, B:53:0x01a7, B:74:0x01ab, B:76:0x01af, B:77:0x01b4, B:55:0x0176), top: B:43:0x0165, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ab A[EDGE_INSN: B:73:0x01ab->B:74:0x01ab BREAK  A[LOOP:0: B:43:0x0165->B:53:0x01a7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01af A[Catch: all -> 0x019d, TryCatch #6 {all -> 0x019d, blocks: (B:44:0x0165, B:46:0x016b, B:48:0x0170, B:51:0x01a0, B:58:0x017b, B:53:0x01a7, B:74:0x01ab, B:76:0x01af, B:77:0x01b4, B:55:0x0176), top: B:43:0x0165, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015a A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:34:0x00ed, B:35:0x0102, B:37:0x0106, B:38:0x014a, B:41:0x015c, B:87:0x015a, B:90:0x00fe), top: B:33:0x00ed }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r(com.bykv.vk.openvk.component.video.j.xt.ae.xt r13, com.bykv.vk.openvk.component.video.j.xt.vl.j r14) throws com.bykv.vk.openvk.component.video.j.xt.cw.r, java.io.IOException, com.bykv.vk.openvk.component.video.j.xt.cw.j, com.bykv.vk.openvk.component.video.j.xt.cw.xt {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.xt.ae.r(com.bykv.vk.openvk.component.video.j.xt.ae$xt, com.bykv.vk.openvk.component.video.j.xt.vl$j):void");
    }

    private void j(xt xtVar, vl.j jVar) throws com.bykv.vk.openvk.component.video.j.xt.cw.r, IOException, tl.j, com.bykv.vk.openvk.component.video.j.xt.cw.j, com.bykv.vk.openvk.component.video.j.xt.cw.xt {
        if ("HEAD".equalsIgnoreCase(this.f23052g.f23046j.f23047j)) {
            xt(xtVar, jVar);
        } else {
            cw(xtVar, jVar);
        }
    }

    private byte[] j(com.bykv.vk.openvk.component.video.j.xt.xt.j jVar, xt xtVar, vl.j jVar2) throws IOException {
        if (jVar != null) {
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.j.cw.j.j(jVar, xtVar.xt()).getBytes(com.bykv.vk.openvk.component.video.j.cw.j.f22978j);
        }
        com.bykv.vk.openvk.component.video.j.xt.up.j j6 = j(jVar2, 0, -1, "HEAD");
        if (j6 == null) {
            return null;
        }
        try {
            String j7 = com.bykv.vk.openvk.component.video.j.cw.j.j(j6, false, false);
            if (j7 == null) {
                com.bykv.vk.openvk.component.video.j.xt.xt.j j8 = com.bykv.vk.openvk.component.video.j.cw.j.j(j6, this.xt, this.tl, this.f23052g.cw.f23048j);
                if (up.cw) {
                    com.bytedance.sdk.component.utils.vl.xt("TAG_PROXY_ProxyTask", "get header from network");
                }
                byte[] bytes = com.bykv.vk.openvk.component.video.j.cw.j.j(j8, xtVar.xt()).getBytes(com.bykv.vk.openvk.component.video.j.cw.j.f22978j);
                com.bykv.vk.openvk.component.video.j.cw.j.j(j6.r());
                return bytes;
            }
            throw new com.bykv.vk.openvk.component.video.j.xt.cw.cw(j7 + ", rawKey: " + this.ae + ", url: " + jVar2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.j.cw.j.j(j6.r());
            throw th;
        }
    }

    private void j(com.bykv.vk.openvk.component.video.j.xt.xt.j jVar, File file, xt xtVar, vl.j jVar2) throws IOException, com.bykv.vk.openvk.component.video.j.xt.cw.r, tl.j, com.bykv.vk.openvk.component.video.j.xt.cw.j, com.bykv.vk.openvk.component.video.j.xt.cw.xt {
        final com.bytedance.sdk.component.oq.tl tlVar;
        tl tlVar2;
        com.bykv.vk.openvk.component.video.j.xt.xt xtVar2;
        if (!xtVar.j()) {
            byte[] j6 = j(jVar, xtVar, jVar2);
            up();
            if (j6 == null) {
                return;
            } else {
                xtVar.j(j6, 0, j6.length);
            }
        }
        tl tlVar3 = null;
        if (jVar == null && (jVar = this.xt.query(this.tl, this.f23052g.cw.f23048j)) == null) {
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            j(null, xtVar, jVar2);
            jVar = this.xt.query(this.tl, this.f23052g.cw.f23048j);
            if (jVar == null) {
                throw new com.bykv.vk.openvk.component.video.j.xt.cw.cw("failed to get header, rawKey: " + this.ae + ", url: " + jVar2);
            }
        }
        if (file.length() >= jVar.cw || !((xtVar2 = this.av) == null || xtVar2.xt() || xtVar2.r())) {
            tlVar = null;
        } else {
            com.bykv.vk.openvk.component.video.j.xt.xt j7 = new xt.j().j(this.f23053j).j(this.xt).j(this.ae).xt(this.tl).j(new vl(jVar2.f23114j)).j(this.f23054m).j(this.f23052g).j(new xt.InterfaceC0313xt() { // from class: com.bykv.vk.openvk.component.video.j.xt.ae.1
                @Override // com.bykv.vk.openvk.component.video.j.xt.xt.InterfaceC0313xt
                public void j(com.bykv.vk.openvk.component.video.j.xt.xt xtVar3) {
                    ae.this.cw.addAndGet(xtVar3.cw.get());
                    ae.this.f23055r.addAndGet(xtVar3.f23055r.get());
                    synchronized (xtVar3.jy) {
                        xtVar3.jy.notifyAll();
                    }
                    if (xtVar3.r()) {
                        ae.this.az.j(ae.this.ae(), null);
                    }
                }
            }).j();
            this.av = j7;
            tlVar = new com.bytedance.sdk.component.oq.tl(j7, null, 10, 1);
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.component.video.j.xt.ae.2
                @Override // java.lang.Runnable
                public void run() {
                    tlVar.run();
                }
            });
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            tlVar2 = new tl(file, t.f36150k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            tlVar2.j(xtVar.xt());
            int min = this.f23052g.cw.up > 0 ? Math.min(jVar.cw, this.f23052g.cw.up) : jVar.cw;
            while (xtVar.xt() < min) {
                up();
                int j8 = tlVar2.j(bArr);
                if (j8 <= 0) {
                    com.bykv.vk.openvk.component.video.j.xt.xt xtVar3 = this.av;
                    if (xtVar3 != null) {
                        com.bykv.vk.openvk.component.video.j.xt.cw.xt g6 = xtVar3.g();
                        if (g6 == null) {
                            tl.j tl = xtVar3.tl();
                            if (tl != null) {
                                throw tl;
                            }
                        } else {
                            throw g6;
                        }
                    }
                    if (xtVar3 != null && !xtVar3.xt() && !xtVar3.r()) {
                        up();
                        synchronized (xtVar3.jy) {
                            try {
                                xtVar3.jy.wait(1000L);
                            } catch (InterruptedException e6) {
                                com.bytedance.sdk.component.utils.vl.j(e6);
                            }
                        }
                    }
                    if (up.cw) {
                        com.bytedance.sdk.component.utils.vl.r("TAG_PROXY_ProxyTask", "download task has finished!!!");
                    }
                    throw new com.bykv.vk.openvk.component.video.j.xt.cw.cw("illegal state download task has finished, rawKey: " + this.ae + ", url: " + jVar2);
                }
                xtVar.xt(bArr, 0, j8);
                up();
            }
            if (up.cw) {
                com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_ProxyTask", "read cache file complete: " + xtVar.xt() + ", " + min);
            }
            cw();
            tlVar2.j();
            if (tlVar != null) {
                try {
                    tlVar.get();
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.vl.j(th2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            tlVar3 = tlVar2;
            if (tlVar3 != null) {
                tlVar3.j();
            }
            if (tlVar != null) {
                try {
                    tlVar.get();
                } catch (Throwable th4) {
                    com.bytedance.sdk.component.utils.vl.j(th4);
                }
            }
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j
    public void j() {
        super.j();
        g();
    }
}
