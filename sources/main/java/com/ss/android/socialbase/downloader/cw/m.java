package com.ss.android.socialbase.downloader.cw;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.cw.cw;
import com.ss.android.socialbase.downloader.cw.xt;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.downloader.tj;
import com.ss.android.socialbase.downloader.qv.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes6.dex */
public class m implements ServiceConnection, tj {
    private static int cw;

    /* renamed from: r, reason: collision with root package name */
    private static long f38695r;
    private static boolean xt;
    private cw.j.InterfaceC0780j ae;

    /* renamed from: g, reason: collision with root package name */
    private Future<?> f38696g;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private cw f38697j;
    private Handler up = new Handler(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    private xt f38698m = null;
    private Runnable tl = new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.m.1
        @Override // java.lang.Runnable
        public void run() {
            if (!m.xt && m.this.ae != null) {
                m.this.ae.j();
            }
        }
    };
    private CountDownLatch oq = new CountDownLatch(1);

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ArrayList<g> ws(int i6) {
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        xt = true;
        this.up.removeCallbacks(this.tl);
        try {
            this.f38697j = cw.j.j(iBinder);
        } catch (Throwable th) {
            vl.j(th);
        }
        this.f38696g = com.ss.android.socialbase.downloader.downloader.cw.qv().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.m.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (m.this.f38698m != null && m.this.f38697j != null) {
                                m.this.f38697j.j(m.this.f38698m);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.cw.m.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = m.xt = false;
                                    if (m.this.ae() || m.this.ae == null) {
                                        return;
                                    }
                                    m.this.up.postDelayed(m.this.tl, 2000L);
                                }
                            };
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th2) {
                        try {
                            com.ss.android.socialbase.downloader.m.j.xt("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                            if (m.this.ae != null) {
                                m.this.ae.j();
                            }
                            m.this.oq.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.cw.m.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = m.xt = false;
                                    if (m.this.ae() || m.this.ae == null) {
                                        return;
                                    }
                                    m.this.up.postDelayed(m.this.tl, 2000L);
                                }
                            };
                        } finally {
                            m.this.oq.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.cw.m.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused2 = m.xt = false;
                                        if (m.this.ae() || m.this.ae == null) {
                                            return;
                                        }
                                        m.this.up.postDelayed(m.this.tl, 2000L);
                                    }
                                }, 0);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    iBinder2.linkToDeath(deathRecipient, 0);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f38697j = null;
        xt = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public Map<Long, g> vl(int i6) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ae() {
        if (Build.VERSION.SDK_INT >= 26 || xt) {
            return false;
        }
        if (cw > 5) {
            com.ss.android.socialbase.downloader.m.j.r("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f38695r < 15000) {
            com.ss.android.socialbase.downloader.m.j.r("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        cw++;
        f38695r = currentTimeMillis;
        this.up.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.m.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.j(com.ss.android.socialbase.downloader.downloader.cw.nd(), m.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.cw(str);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw g(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.g(i6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean j(int i6, Map<Long, g> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw oq(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.oq(i6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.r(str);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.tl(i6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean up(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.up(i6);
            }
            return false;
        } catch (RemoteException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.xt(i6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    public m() {
        SqlDownloadCacheService.j(com.ss.android.socialbase.downloader.downloader.cw.nd(), this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean m(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.m(i6);
            }
            return false;
        } catch (RemoteException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.xt> cw(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.cw(i6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    public void j(cw.j.InterfaceC0780j interfaceC0780j) {
        this.ae = interfaceC0780j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void r(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.r(i6);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean up() {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.up();
            }
            return false;
        } catch (RemoteException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.xt(str);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tj
    public void j(final SparseArray<com.ss.android.socialbase.downloader.ae.cw> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.ae.xt>> sparseArray2, final r rVar) {
        com.ss.android.socialbase.downloader.downloader.cw.qv().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.cw.m.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z5;
                r rVar2;
                Future future;
                m.this.j(new xt.j() { // from class: com.ss.android.socialbase.downloader.cw.m.4.1
                    @Override // com.ss.android.socialbase.downloader.cw.xt
                    public void j(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.az.m.j(sparseArray, map);
                        com.ss.android.socialbase.downloader.az.m.j(sparseArray2, map2);
                        rVar.j();
                        m.this.j((xt) null);
                    }
                });
                try {
                    z5 = !m.this.oq.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    vl.j(th);
                    z5 = false;
                }
                if (z5 && (future = m.this.f38696g) != null) {
                    future.cancel(true);
                }
                m.this.j();
                if (!z5 || (rVar2 = rVar) == null) {
                    return;
                }
                rVar2.j();
            }
        });
    }

    public void j(xt xtVar) {
        synchronized (this) {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                try {
                    cwVar.j(xtVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            } else {
                this.f38698m = xtVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void cw() {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.cw();
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw r(int i6, long j6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.r(i6, j6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> xt() {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.xt();
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw cw(int i6, long j6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.cw(i6, j6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean r() {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.r();
            }
            return false;
        } catch (RemoteException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.xt(xtVar);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw ae(int i6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.ae(i6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    public void j() {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.j();
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw xt(int i6, long j6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.xt(i6, j6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.j(str);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        try {
            cw cwVar2 = this.f38697j;
            if (cwVar2 != null) {
                cwVar2.xt(cwVar);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(com.ss.android.socialbase.downloader.ae.xt xtVar) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.j(xtVar);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void xt(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.xt(i6, list);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, long j6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.j(i6, i7, j6);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void jy(int i6) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, int i8, long j6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.j(i6, i7, i8, j6);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, int i7, int i8, int i9) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.j(i6, i7, i8, i9);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, int i7) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.j(i6, i7);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        try {
            cw cwVar2 = this.f38697j;
            if (cwVar2 != null) {
                return cwVar2.j(cwVar);
            }
            return false;
        } catch (RemoteException e6) {
            vl.j(e6);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6, String str, String str2) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.j(i6, j6, str, str2);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public com.ss.android.socialbase.downloader.ae.cw j(int i6, long j6) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                return cwVar.j(i6, j6);
            }
            return null;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.vl
    public void j(int i6, List<com.ss.android.socialbase.downloader.ae.xt> list) {
        try {
            cw cwVar = this.f38697j;
            if (cwVar != null) {
                cwVar.j(i6, list);
            }
        } catch (RemoteException e6) {
            vl.j(e6);
        }
    }
}
