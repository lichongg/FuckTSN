package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c ank;
    private c.a anl;
    private c.b anm;
    private c.e ann;
    private volatile com.kwad.framework.filedownloader.b.a ano;
    private c.d anp;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final b anq = new b();
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.ank = new com.kwad.framework.filedownloader.services.c(bVar);
            this.anm = null;
            this.ann = null;
            this.ano = null;
            this.anp = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.ank = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final synchronized com.kwad.framework.filedownloader.b.a ye() {
        if (this.ano != null) {
            return this.ano;
        }
        this.ano = yk().zf();
        a(this.ano.xT());
        return this.ano;
    }

    private c.a yh() {
        c.a aVar = this.anl;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            try {
                if (this.anl == null) {
                    this.anl = yk().zi();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.anl;
    }

    private c.b yi() {
        c.b bVar = this.anm;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            try {
                if (this.anm == null) {
                    this.anm = yk().zh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.anm;
    }

    private c.e yj() {
        c.e eVar = this.ann;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            try {
                if (this.ann == null) {
                    this.ann = yk().zg();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.ann;
    }

    private com.kwad.framework.filedownloader.services.c yk() {
        com.kwad.framework.filedownloader.services.c cVar = this.ank;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            try {
                if (this.ank == null) {
                    this.ank = new com.kwad.framework.filedownloader.services.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.ank;
    }

    public final c.d yd() {
        c.d dVar = this.anp;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            try {
                if (this.anp == null) {
                    this.anp = yk().zj();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.anp;
    }

    public static b yc() {
        return a.anq;
    }

    public final com.kwad.framework.filedownloader.a.b br(String str) {
        try {
            return yi().bo(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.anm = bVar;
            return bVar.bo(str);
        }
    }

    public final int yf() {
        return yk().yf();
    }

    public final boolean yg() {
        yj();
        return true;
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return yj().c(file);
    }

    public final int a(int i6, String str, String str2, long j6) {
        return yh().V(j6);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a A[Catch: all -> 0x0056, TryCatch #1 {all -> 0x0056, blocks: (B:4:0x0021, B:6:0x0027, B:8:0x0038, B:10:0x003f, B:12:0x0046, B:14:0x004d, B:17:0x005e, B:19:0x006a, B:21:0x0075, B:71:0x005b), top: B:3:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0066 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0654a r29) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
