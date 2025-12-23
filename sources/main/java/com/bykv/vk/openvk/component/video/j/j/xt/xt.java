package com.bykv.vk.openvk.component.video.j.j.xt;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.up.j;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private Context f22994j;

    /* renamed from: r, reason: collision with root package name */
    private File f22996r;
    private File up;
    private r xt;
    private volatile boolean cw = false;

    /* renamed from: m, reason: collision with root package name */
    private final List<j.InterfaceC0307j> f22995m = new ArrayList();
    private volatile boolean ae = false;

    private void cw() {
        vl.j xt = com.bykv.vk.openvk.component.video.api.cw.cw() != null ? com.bykv.vk.openvk.component.video.api.cw.cw().xt() : new vl.j("v_preload");
        long mi = this.xt.mi();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        xt.j(mi, timeUnit).xt(this.xt.kt(), timeUnit).cw(this.xt.tj(), timeUnit);
        vl j6 = xt.j();
        ws.j jVar = new ws.j();
        final long length = this.f22996r.length();
        int m6 = this.xt.m();
        boolean jy = this.xt.jy();
        int xt2 = this.xt.xt();
        if (xt2 > 0) {
            if (xt2 >= this.xt.vl()) {
                jy = true;
            } else {
                m6 = xt2;
            }
        }
        if (jy) {
            jVar.j("RANGE", "bytes=" + length + "-").j(this.xt.av()).j().xt();
        } else {
            jVar.j("RANGE", "bytes=" + length + "-" + m6).j(this.xt.av()).j().xt();
        }
        j6.j(jVar.xt()).j(new com.bytedance.sdk.component.xt.j.cw() { // from class: com.bykv.vk.openvk.component.video.j.j.xt.xt.1
            @Override // com.bytedance.sdk.component.xt.j.cw
            public void onFailure(com.bytedance.sdk.component.xt.j.xt xtVar, IOException iOException) {
                xt xtVar2 = xt.this;
                xtVar2.j(xtVar2.xt, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                cw.j(xt.this.xt);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0250 A[Catch: all -> 0x0255, TryCatch #2 {all -> 0x0255, blocks: (B:18:0x0240, B:20:0x0250, B:21:0x0259), top: B:17:0x0240 }] */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0257  */
            /* JADX WARN: Type inference failed for: r6v6 */
            @Override // com.bytedance.sdk.component.xt.j.cw
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.xt.j.xt r26, com.bytedance.sdk.component.xt.j.av r27) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 736
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.j.xt.xt.AnonymousClass1.onResponse(com.bytedance.sdk.component.xt.j.xt, com.bytedance.sdk.component.xt.j.av):void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            this.up.delete();
            this.f22996r.delete();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        try {
            if (this.f22996r.renameTo(this.up)) {
                return;
            }
            throw new IOException("Error renaming file " + this.f22996r + " to " + this.up + " for completion!");
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            com.bykv.vk.openvk.component.video.api.m.cw.j("VideoPreload", th.getMessage());
        }
    }

    public xt(Context context, r rVar) {
        this.f22996r = null;
        this.up = null;
        this.f22994j = context;
        this.xt = rVar;
        this.f22996r = com.bykv.vk.openvk.component.video.j.up.cw.xt(rVar.up(), rVar.i());
        this.up = com.bykv.vk.openvk.component.video.j.up.cw.cw(rVar.up(), rVar.i());
    }

    private boolean xt() {
        if (this.up.exists()) {
            return true;
        }
        if (!this.xt.jy()) {
            if (this.f22996r.length() >= this.xt.m()) {
                return true;
            }
            if (this.xt.xt() > 0 && this.f22996r.length() >= this.xt.xt()) {
                return true;
            }
        }
        return false;
    }

    public void j(j.InterfaceC0307j interfaceC0307j) {
        if (this.ae) {
            synchronized (j.InterfaceC0307j.class) {
                this.f22995m.add(interfaceC0307j);
            }
            return;
        }
        this.f22995m.add(interfaceC0307j);
        if (xt()) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("VideoPreload", "Cache file is exist");
            this.xt.g(1);
            j(this.xt, 200);
            cw.j(this.xt);
            return;
        }
        this.ae = true;
        this.xt.g(0);
        cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(r rVar, int i6) {
        synchronized (j.InterfaceC0307j.class) {
            try {
                for (j.InterfaceC0307j interfaceC0307j : this.f22995m) {
                    if (interfaceC0307j != null) {
                        interfaceC0307j.xt(rVar, i6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public r j() {
        return this.xt;
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(r rVar, int i6) {
        synchronized (j.InterfaceC0307j.class) {
            try {
                for (j.InterfaceC0307j interfaceC0307j : this.f22995m) {
                    if (interfaceC0307j != null) {
                        interfaceC0307j.j(rVar, i6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(r rVar, int i6, String str) {
        synchronized (j.InterfaceC0307j.class) {
            try {
                for (j.InterfaceC0307j interfaceC0307j : this.f22995m) {
                    if (interfaceC0307j != null) {
                        interfaceC0307j.j(rVar, i6, str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
