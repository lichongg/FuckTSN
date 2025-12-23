package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class r {
    private static final Object amu = new Object();
    private static final Object amw = new Object();
    private w amv;
    private volatile v amx;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final r amy = new r();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwad.framework.filedownloader.f.c.aI(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        com.kwad.framework.filedownloader.download.b.yc().a(bVar);
    }

    public static com.kwad.framework.filedownloader.a bm(String str) {
        return new c(str);
    }

    final w xL() {
        if (this.amv == null) {
            synchronized (amu) {
                try {
                    if (this.amv == null) {
                        this.amv = new ab();
                    }
                } finally {
                }
            }
        }
        return this.amv;
    }

    final v xM() {
        if (this.amx == null) {
            synchronized (amw) {
                try {
                    if (this.amx == null) {
                        this.amx = new z();
                        a((e) this.amx);
                    }
                } finally {
                }
            }
        }
        return this.amx;
    }

    public static void aH(Context context) {
        com.kwad.framework.filedownloader.f.c.aI(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    private int bz(int i6) {
        List<a.InterfaceC0653a> bu = h.xp().bu(i6);
        if (bu.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i6));
            return 0;
        }
        Iterator<a.InterfaceC0653a> it = bu.iterator();
        while (it.hasNext()) {
            it.next().wR().pause();
        }
        return bu.size();
    }

    public static r xI() {
        return a.amy;
    }

    public static boolean xK() {
        return n.xA().isConnected();
    }

    public final boolean q(int i6, String str) {
        bz(i6);
        if (n.xA().by(i6)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(com.kwad.framework.filedownloader.f.f.bD(str));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            return true;
        }
        return false;
    }

    public final void xJ() {
        if (!xK()) {
            n.xA().aG(com.kwad.framework.filedownloader.f.c.zz());
        }
    }

    private static void a(e eVar) {
        f.xn().a("event.service.connect.changed", eVar);
    }
}
