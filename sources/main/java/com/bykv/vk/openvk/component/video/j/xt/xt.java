package com.bykv.vk.openvk.component.video.j.xt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bykv.vk.openvk.component.video.j.xt.tl;
import com.bykv.vk.openvk.component.video.j.xt.vl;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
class xt extends com.bykv.vk.openvk.component.video.j.xt.j {
    private final InterfaceC0313xt av;
    private final int az;

    /* renamed from: i, reason: collision with root package name */
    private volatile tl.j f23115i;
    final Object jy;

    /* renamed from: w, reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.j.xt.cw.xt f23116w;
    final Object ws;

    /* renamed from: com.bykv.vk.openvk.component.video.j.xt.xt$xt, reason: collision with other inner class name */
    public interface InterfaceC0313xt {
        void j(xt xtVar);
    }

    static final class j {
        int ae;
        vl cw;

        /* renamed from: g, reason: collision with root package name */
        InterfaceC0313xt f23124g;

        /* renamed from: j, reason: collision with root package name */
        String f23125j;

        /* renamed from: m, reason: collision with root package name */
        List<g.xt> f23126m;
        Object oq;

        /* renamed from: r, reason: collision with root package name */
        com.bykv.vk.openvk.component.video.j.xt.j.j f23127r;
        g tl;
        com.bykv.vk.openvk.component.video.j.xt.xt.cw up;
        String xt;

        j j(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.f23125j = str;
            return this;
        }

        j() {
        }

        j xt(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.xt = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        j j(vl vlVar) {
            if (vlVar != null) {
                this.cw = vlVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        j j(com.bykv.vk.openvk.component.video.j.xt.j.j jVar) {
            if (jVar != null) {
                this.f23127r = jVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        j j(com.bykv.vk.openvk.component.video.j.xt.xt.cw cwVar) {
            if (cwVar != null) {
                this.up = cwVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        j j(List<g.xt> list) {
            this.f23126m = list;
            return this;
        }

        j j(int i6) {
            this.ae = i6;
            return this;
        }

        j j(InterfaceC0313xt interfaceC0313xt) {
            this.f23124g = interfaceC0313xt;
            return this;
        }

        j j(g gVar) {
            this.tl = gVar;
            return this;
        }

        j j(Object obj) {
            this.oq = obj;
            return this;
        }

        xt j() {
            if (this.f23127r != null && this.up != null && !TextUtils.isEmpty(this.f23125j) && !TextUtils.isEmpty(this.xt) && this.cw != null) {
                return new xt(this);
            }
            throw new IllegalArgumentException();
        }
    }

    xt(j jVar) {
        super(jVar.f23127r, jVar.up);
        this.az = jVar.ae;
        this.av = jVar.f23124g;
        this.jy = this;
        this.ae = jVar.f23125j;
        this.tl = jVar.xt;
        this.f23054m = jVar.f23126m;
        this.oq = jVar.cw;
        this.f23052g = jVar.tl;
        this.ws = jVar.oq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b9, code lost:
    
        cw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
    
        if (com.bykv.vk.openvk.component.video.j.xt.up.cw == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
    
        com.bytedance.sdk.component.utils.vl.j("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cc, code lost:
    
        com.bykv.vk.openvk.component.video.j.cw.j.j(r6.r());
        r4.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d6, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(com.bykv.vk.openvk.component.video.j.xt.vl.j r13) throws java.io.IOException, com.bykv.vk.openvk.component.video.j.xt.tl.j, com.bykv.vk.openvk.component.video.j.xt.cw.j, com.bykv.vk.openvk.component.video.j.xt.cw.xt {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.xt.xt.j(com.bykv.vk.openvk.component.video.j.xt.vl$j):void");
    }

    private boolean oq() throws com.bykv.vk.openvk.component.video.j.xt.cw.j {
        while (this.oq.j()) {
            up();
            vl.j xt = this.oq.xt();
            try {
                j(xt);
                return true;
            } catch (com.bykv.vk.openvk.component.video.j.xt.cw.cw unused) {
                xt.j();
                ae();
            } catch (com.bykv.vk.openvk.component.video.j.xt.cw.xt e6) {
                this.f23116w = e6;
                return false;
            } catch (tl.j e7) {
                this.f23115i = e7;
                ae();
                return false;
            } catch (IOException e8) {
                if (e8 instanceof SocketTimeoutException) {
                    xt.xt();
                }
                if (!xt()) {
                    ae();
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    com.bykv.vk.openvk.component.video.j.xt.cw.xt g() {
        return this.f23116w;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f23053j.j(this.tl);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            oq();
        } catch (Throwable unused) {
        }
        this.f23055r.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f23053j.xt(this.tl);
        InterfaceC0313xt interfaceC0313xt = this.av;
        if (interfaceC0313xt != null) {
            interfaceC0313xt.j(this);
        }
    }

    tl.j tl() {
        return this.f23115i;
    }
}
