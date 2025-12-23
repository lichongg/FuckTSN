package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private com.kwad.sdk.a arM;
    private d arO;
    private Context mContext;
    private final Map<Integer, DownloadTask> arK = new ConcurrentHashMap();
    private final Map<String, Integer> arL = new ConcurrentHashMap();
    private boolean arN = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final c arR = new c();
    }

    private void AE() {
        k.a aVar;
        try {
            aVar = new k.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.yc().b(new c.b().ca(Integer.MAX_VALUE).a(aVar));
            this.arN = true;
        }
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            AE();
        } else if (this.arN) {
            AF();
        }
        if (this.arK.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            cm(downloadTask.getId());
        } else {
            this.arK.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.arL.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.arM);
        return downloadTask.getId();
    }

    public final void resume(int i6) {
        a(i6, (DownloadTask.DownloadRequest) null);
    }

    public static boolean AD() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void AF() {
        k.a aVar;
        try {
            aVar = new k.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.yc().b(new c.b().ca(Integer.MAX_VALUE).a(aVar));
        }
    }

    public static void cc(String str) {
        if (str == null) {
            return;
        }
        w.delete(com.kwad.framework.filedownloader.f.f.bD(str));
        w.delete(str);
    }

    private void cm(int i6) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i6));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    private void h(@NonNull DownloadTask downloadTask) {
        this.arK.remove(Integer.valueOf(downloadTask.getId()));
        this.arL.remove(downloadTask.getUrl());
    }

    public final File AB() {
        return be.dF(this.mContext);
    }

    public final d AC() {
        if (this.arO == null) {
            this.arO = new com.kwad.sdk.core.download.b.a();
        }
        return this.arO;
    }

    public final boolean AG() {
        Iterator<Map.Entry<Integer, DownloadTask>> it = this.arK.entrySet().iterator();
        while (true) {
            boolean z5 = false;
            while (it.hasNext()) {
                DownloadTask value = it.next().getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                        z5 = true;
                    }
                }
            }
            return z5;
        }
    }

    public final void cancel(int i6) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i6));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final DownloadTask cl(int i6) {
        return this.arK.get(Integer.valueOf(i6));
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        r.a(context, new c.b().ca(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b yi() {
                try {
                    k.a aVar = new k.a(false);
                    aVar.bo("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i6) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i6));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public static c AA() {
        return a.arR;
    }

    public final void cn(int i6) {
        DownloadTask cl = cl(i6);
        if (cl == null) {
            return;
        }
        if (cl.isUserPause()) {
            cl.downloadType = 2;
            resume(i6);
        } else {
            pause(i6);
        }
    }

    public final void g(DownloadTask downloadTask) {
        final String md5 = al.md5(downloadTask.getUrl());
        as.a(downloadTask.getTargetFilePath(), new as.a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.as.a
            public final void d(Throwable th) {
                com.kwad.sdk.core.download.b.GR().g(md5, th);
            }

            @Override // com.kwad.sdk.utils.as.a
            public final void pR() {
                com.kwad.sdk.core.download.b.GR().dT(md5);
            }
        });
    }

    private void a(int i6, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i6));
        if (downloadTask != null) {
            for (int i7 = 0; i7 < 2; i7++) {
                com.kwad.sdk.a aVar = aVarArr[i7];
                if (aVar != null) {
                    aVar.setId(i6);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.arM = aVar;
    }

    private void a(int i6, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i6));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }
}
