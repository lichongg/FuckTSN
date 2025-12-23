package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.qv;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.h;
import com.ss.android.socialbase.downloader.r.n;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.socialbase.downloader.r.wq;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class az implements com.ss.android.socialbase.downloader.downloader.av, com.ss.android.socialbase.downloader.downloader.az {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38837j = "az";
    private com.ss.android.socialbase.downloader.downloader.i<CSJIndependentProcessDownloadService> cw;

    /* renamed from: r, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.az f38838r = new av();
    private volatile com.ss.android.socialbase.downloader.downloader.qv xt;

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean ae(int i6) {
        if (this.xt == null) {
            return false;
        }
        try {
            return this.xt.ae(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void cw(int i6) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.cw(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.j(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public int m(int i6) {
        if (this.xt == null) {
            return 0;
        }
        try {
            return this.xt.m(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void r(int i6) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.r(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        if (this.xt == null) {
            return this.f38838r.tl(i6);
        }
        try {
            return this.xt.tl(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public long up(int i6) {
        if (this.xt == null) {
            return 0L;
        }
        try {
            return this.xt.up(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean av(int i6) {
        if (this.xt == null) {
            return this.f38838r.av(i6);
        }
        try {
            return this.xt.av(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void az(int i6) {
        if (this.xt == null) {
            this.f38838r.az(i6);
            return;
        }
        try {
            this.xt.az(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.xt> g(int i6) {
        if (this.xt == null) {
            return this.f38838r.g(i6);
        }
        try {
            return this.xt.g(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public h i(int i6) {
        if (this.xt == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.az.ae.j(this.xt.i(i6));
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public int jy(int i6) {
        if (this.xt == null) {
            return com.ss.android.socialbase.downloader.downloader.r.j().xt(i6);
        }
        try {
            return this.xt.jy(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public tj mi(int i6) {
        if (this.xt == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.az.ae.j(this.xt.mi(i6));
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void oq(int i6) {
        if (this.xt == null) {
            this.f38838r.oq(i6);
            return;
        }
        try {
            this.xt.oq(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void qv(int i6) {
        com.ss.android.socialbase.downloader.downloader.i<CSJIndependentProcessDownloadService> iVar = this.cw;
        if (iVar != null) {
            iVar.j(i6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.i<CSJIndependentProcessDownloadService> iVar = this.cw;
        if (iVar != null) {
            iVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean vl(int i6) {
        if (this.xt == null) {
            return false;
        }
        try {
            return this.xt.qv(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public wq w(int i6) {
        if (this.xt == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.az.ae.j(this.xt.w(i6));
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean ws(int i6) {
        if (this.xt == null) {
            return this.f38838r.ws(i6);
        }
        try {
            return this.xt.ws(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean xt(int i6) {
        if (this.xt == null) {
            return false;
        }
        try {
            return this.xt.xt(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    public az() {
        com.ss.android.socialbase.downloader.downloader.i<CSJIndependentProcessDownloadService> s5 = com.ss.android.socialbase.downloader.downloader.cw.s();
        this.cw = s5;
        s5.j(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean ae() {
        return this.xt != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        if (this.xt == null) {
            return this.f38838r.cw(str);
        }
        try {
            return this.xt.cw(str);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, boolean z5) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.j(i6, z5);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void m() {
        if (this.xt == null) {
            this.f38838r.m();
            return;
        }
        try {
            this.xt.up();
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> r() {
        if (this.xt == null) {
            return this.f38838r.r();
        }
        try {
            return this.xt.xt();
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> up(String str) {
        if (this.xt == null) {
            return null;
        }
        try {
            return this.xt.r(str);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.av
    public void tl() {
        this.xt = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public com.ss.android.socialbase.downloader.ae.cw xt(String str, String str2) {
        return tl(j(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j() {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.j();
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean up() {
        if (this.xt == null) {
            return this.f38838r.up();
        }
        try {
            return this.xt.r();
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        if (this.xt == null) {
            return this.f38838r.xt(str);
        }
        try {
            return this.xt.xt(str);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean cw() {
        return com.ss.android.socialbase.downloader.downloader.cw.rh();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        if (this.xt == null) {
            return this.f38838r.r(str);
        }
        try {
            return this.xt.up(str);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void cw(int i6, boolean z5) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.r(i6, z5);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        if (this.xt == null) {
            return this.f38838r.j(str);
        }
        try {
            return this.xt.j(str);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(List<String> list) {
        if (this.xt == null) {
            this.f38838r.xt(list);
            return;
        }
        try {
            this.xt.xt(list);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (this.xt == null) {
            return this.f38838r.cw(cwVar);
        }
        try {
            return this.xt.xt(cwVar);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public int j(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.cw.j(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(List<String> list) {
        if (this.xt == null) {
            this.f38838r.j(list);
            return;
        }
        try {
            this.xt.j(list);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(int i6, boolean z5) {
        if (this.xt == null) {
            this.f38838r.xt(i6, z5);
            return;
        }
        try {
            this.xt.xt(i6, z5);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.xt(i6, i7, com.ss.android.socialbase.downloader.az.ae.j(aVar, tlVar != com.ss.android.socialbase.downloader.xt.tl.SUB), tlVar.ordinal(), z5);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.j(i6, i7, com.ss.android.socialbase.downloader.az.ae.j(aVar, tlVar != com.ss.android.socialbase.downloader.xt.tl.SUB), tlVar.ordinal(), z5);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, a aVar, com.ss.android.socialbase.downloader.xt.tl tlVar, boolean z5, boolean z6) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.j(i6, i7, com.ss.android.socialbase.downloader.az.ae.j(aVar, tlVar != com.ss.android.socialbase.downloader.xt.tl.SUB), tlVar.ordinal(), z5, z6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean xt() {
        if (this.xt == null) {
            com.ss.android.socialbase.downloader.m.j.r(f38837j, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.m.j.cw(f38837j, "aidlService.isServiceForeground");
        try {
            return this.xt.m();
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (this.xt == null) {
            return this.f38838r.j(cwVar);
        }
        try {
            this.xt.j(cwVar);
            return false;
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(com.ss.android.socialbase.downloader.ae.r rVar) {
        com.ss.android.socialbase.downloader.downloader.i<CSJIndependentProcessDownloadService> iVar;
        if (rVar == null || (iVar = this.cw) == null) {
            return;
        }
        iVar.cw(rVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, Notification notification) {
        if (this.xt == null) {
            com.ss.android.socialbase.downloader.m.j.r(f38837j, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.m.j.cw(f38837j, "aidlService.startForeground, id = ".concat(String.valueOf(i6)));
        try {
            this.xt.j(i6, notification);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        if (this.xt == null) {
            this.f38838r.xt(i6, list);
            return;
        }
        try {
            this.xt.j(i6, list);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(boolean z5, boolean z6) {
        if (this.xt == null) {
            com.ss.android.socialbase.downloader.m.j.r(f38837j, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.m.j.cw(f38837j, "aidlService.stopForeground");
        try {
            this.xt.j(z6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(com.ss.android.socialbase.downloader.ae.r rVar) {
        com.ss.android.socialbase.downloader.downloader.i<CSJIndependentProcessDownloadService> iVar;
        if (rVar == null || (iVar = this.cw) == null) {
            return;
        }
        iVar.xt(rVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.xt(i6, list);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        if (this.xt == null) {
            this.f38838r.j(xtVar);
            return;
        }
        try {
            this.xt.j(xtVar);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, long j6) {
        if (this.xt == null) {
            this.f38838r.j(i6, i7, j6);
            return;
        }
        try {
            this.xt.j(i6, i7, j6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, int i8, long j6) {
        if (this.xt == null) {
            this.f38838r.j(i6, i7, i8, j6);
            return;
        }
        try {
            this.xt.j(i6, i7, i8, j6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7, int i8, int i9) {
        if (this.xt == null) {
            this.f38838r.j(i6, i7, i8, i9);
            return;
        }
        try {
            this.xt.j(i6, i7, i8, i9);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(n nVar) {
        if (this.xt != null) {
            try {
                this.xt.j(com.ss.android.socialbase.downloader.az.ae.j(nVar));
            } catch (RemoteException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, int i7) {
        if (this.xt != null) {
            try {
                this.xt.j(i6, i7);
            } catch (RemoteException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, h hVar) {
        if (this.xt != null) {
            try {
                this.xt.j(i6, com.ss.android.socialbase.downloader.az.ae.j(hVar));
            } catch (RemoteException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.av
    public void j(IBinder iBinder) {
        this.xt = qv.j.j(iBinder);
        if (com.ss.android.socialbase.downloader.az.m.j()) {
            j(new n() { // from class: com.ss.android.socialbase.downloader.impls.az.1
                @Override // com.ss.android.socialbase.downloader.r.n
                public void j(int i6, int i7) {
                    if (i7 != 1) {
                        if (i7 == 2) {
                            com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).xt(i6);
                        }
                    } else {
                        com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).j(i6);
                        List<com.ss.android.socialbase.downloader.ae.xt> g6 = vl.j(false).g(i6);
                        if (g6 != null) {
                            vl.j(true).j(i6, com.ss.android.socialbase.downloader.az.m.j(g6));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.az
    public void j(int i6, long j6) {
        if (this.xt == null) {
            return;
        }
        try {
            this.xt.j(i6, j6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }
}
