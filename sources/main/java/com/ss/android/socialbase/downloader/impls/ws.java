package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.qv;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ws extends com.ss.android.socialbase.downloader.downloader.j implements ServiceConnection {
    private static final String up = "ws";
    private com.ss.android.socialbase.downloader.downloader.av ae;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.qv f38875m;
    private int tl = -1;

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public IBinder j(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.bytedance.sdk.component.utils.vl.xt(up, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.jy.j.j("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.m.j.xt(up, "onBind IndependentDownloadBinder");
        return new jy();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f38875m = null;
        com.ss.android.socialbase.downloader.downloader.av avVar = this.ae;
        if (avVar != null) {
            avVar.tl();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.m.j.xt(up, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.az.m.j()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.jy.j.cw().j("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private void ae() {
        SparseArray<List<com.ss.android.socialbase.downloader.ae.r>> clone;
        try {
            synchronized (this.f38753j) {
                clone = this.f38753j.clone();
                this.f38753j.clear();
            }
            if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.cw.p() == null) {
                return;
            }
            for (int i6 = 0; i6 < clone.size(); i6++) {
                List<com.ss.android.socialbase.downloader.ae.r> list = clone.get(clone.keyAt(i6));
                if (list != null) {
                    Iterator<com.ss.android.socialbase.downloader.ae.r> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f38875m.j(com.ss.android.socialbase.downloader.az.ae.j(it.next()));
                        } catch (RemoteException e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.j.xt(up, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void cw(com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.r.j().j(rVar.i(), true);
        j p5 = com.ss.android.socialbase.downloader.downloader.cw.p();
        if (p5 != null) {
            p5.j(rVar);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = up;
        com.ss.android.socialbase.downloader.m.j.xt(str, "onServiceConnected ");
        this.f38875m = qv.j.j(iBinder);
        com.ss.android.socialbase.downloader.downloader.av avVar = this.ae;
        if (avVar != null) {
            avVar.j(iBinder);
        }
        StringBuilder sb = new StringBuilder("onServiceConnected aidlService!=null");
        sb.append(this.f38875m != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.f38753j.size());
        com.ss.android.socialbase.downloader.m.j.xt(str, sb.toString());
        if (this.f38875m != null) {
            com.ss.android.socialbase.downloader.downloader.r.j().xt();
            this.xt = true;
            this.f38755r = false;
            int i6 = this.tl;
            if (i6 != -1) {
                try {
                    this.f38875m.vl(i6);
                } catch (RemoteException e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                }
            }
            if (this.f38875m != null) {
                ae();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.m.j.xt(up, "onServiceDisconnected ");
        this.f38875m = null;
        this.xt = false;
        com.ss.android.socialbase.downloader.downloader.av avVar = this.ae;
        if (avVar != null) {
            avVar.tl();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.m.j.xt(up, "stopService");
        this.xt = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void xt(com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return;
        }
        String str = up;
        StringBuilder sb = new StringBuilder("tryDownload aidlService == null:");
        sb.append(this.f38875m == null);
        com.ss.android.socialbase.downloader.m.j.xt(str, sb.toString());
        if (this.f38875m == null) {
            j(rVar);
            startService(com.ss.android.socialbase.downloader.downloader.cw.nd(), this);
            return;
        }
        ae();
        try {
            this.f38875m.j(com.ss.android.socialbase.downloader.az.ae.j(rVar));
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void j(com.ss.android.socialbase.downloader.downloader.av avVar) {
        this.ae = avVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void j(int i6) {
        com.ss.android.socialbase.downloader.downloader.qv qvVar = this.f38875m;
        if (qvVar == null) {
            this.tl = i6;
            return;
        }
        try {
            qvVar.vl(i6);
        } catch (RemoteException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j, com.ss.android.socialbase.downloader.downloader.i
    public void startService() {
        if (this.f38875m == null) {
            startService(com.ss.android.socialbase.downloader.downloader.cw.nd(), this);
        }
    }
}
