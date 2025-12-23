package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class g implements y {
    private final h aps = new h(com.kwad.framework.filedownloader.download.b.yc().yf());

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean cd = this.aps.cd(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.bY(cVar.wJ())) {
            return cd;
        }
        if (cd) {
            return true;
        }
        com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.wJ()));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0175 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0026, B:10:0x0037, B:12:0x0045, B:14:0x004f, B:16:0x0053, B:17:0x0066, B:19:0x0071, B:21:0x0077, B:23:0x007b, B:28:0x008c, B:30:0x0099, B:32:0x009f, B:34:0x00a3, B:39:0x00b6, B:41:0x00bf, B:43:0x00cb, B:45:0x00d1, B:47:0x00d5, B:49:0x00e6, B:53:0x00f0, B:55:0x00f7, B:57:0x00fe, B:59:0x0104, B:61:0x010b, B:63:0x0111, B:65:0x0117, B:67:0x012d, B:68:0x0131, B:70:0x0137, B:74:0x0175, B:75:0x0178, B:78:0x0146, B:80:0x0150, B:82:0x0156, B:83:0x015b, B:84:0x00c6, B:86:0x0094), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b(java.lang.String r19, java.lang.String r20, boolean r21, int r22, int r23, int r24, boolean r25, com.kwad.framework.filedownloader.d.b r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.services.g.b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwad.framework.filedownloader.d.b, boolean):void");
    }

    public final synchronized boolean bQ(int i6) {
        return this.aps.bQ(i6);
    }

    public final boolean by(int i6) {
        if (i6 == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i6));
            return false;
        }
        if (cb(i6)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i6));
            return false;
        }
        com.kwad.framework.filedownloader.b.a zr = zr();
        zr.bG(i6);
        zr.bF(i6);
        return true;
    }

    public final boolean bw(int i6) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i6));
        }
        com.kwad.framework.filedownloader.d.c bD = zr().bD(i6);
        if (bD == null) {
            return false;
        }
        bD.d((byte) -2);
        this.aps.cancel(i6);
        return true;
    }

    public final boolean isIdle() {
        return this.aps.zu() <= 0;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int o(String str, int i6) {
        return this.aps.o(str, i6);
    }

    public final void zs() {
        List<Integer> zv = this.aps.zv();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(zv.size()));
        }
        Iterator<Integer> it = zv.iterator();
        while (it.hasNext()) {
            bw(it.next().intValue());
        }
    }

    g() {
    }

    private boolean cb(int i6) {
        return a(zr().bD(i6));
    }

    private static com.kwad.framework.filedownloader.b.a zr() {
        return com.kwad.framework.filedownloader.download.b.yc().ye();
    }

    public final long bS(int i6) {
        com.kwad.framework.filedownloader.d.c bD = zr().bD(i6);
        if (bD == null) {
            return 0L;
        }
        return bD.getTotal();
    }

    public final byte bx(int i6) {
        com.kwad.framework.filedownloader.d.c bD = zr().bD(i6);
        if (bD == null) {
            return (byte) 0;
        }
        return bD.wJ();
    }

    public final long cc(int i6) {
        com.kwad.framework.filedownloader.b.a zr = zr();
        com.kwad.framework.filedownloader.d.c bD = zr.bD(i6);
        if (bD == null) {
            return 0L;
        }
        int zc = bD.zc();
        if (zc <= 1) {
            return bD.yZ();
        }
        List<com.kwad.framework.filedownloader.d.a> bE = zr.bE(i6);
        if (bE == null || bE.size() != zc) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.s(bE);
    }

    public final void yJ() {
        zr().clear();
    }

    public final boolean z(String str, String str2) {
        return cb(com.kwad.framework.filedownloader.f.f.B(str, str2));
    }
}
