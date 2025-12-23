package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private final Class<?> aoz;
    private volatile INTERFACE ape;
    private final HashMap<String, Object> apf = new HashMap<>();
    private final List<Context> apg = new ArrayList();
    private final ArrayList<Runnable> amm = new ArrayList<>();
    private final CALLBACK apd = xF();

    private void a(Context context, Runnable runnable) {
        if (com.kwad.framework.filedownloader.f.f.aJ(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.aoz);
        if (!this.apg.contains(context)) {
            this.apg.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    protected abstract void a(INTERFACE r12, CALLBACK callback);

    @Override // com.kwad.framework.filedownloader.u
    public final void aG(Context context) {
        a(context, (Runnable) null);
    }

    protected abstract INTERFACE b(IBinder iBinder);

    protected abstract CALLBACK xF();

    private void bj(boolean z5) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.ape);
        }
        this.ape = null;
        com.kwad.framework.filedownloader.f.xn().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.aoz));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.ape);
        }
        bj(true);
    }

    protected final INTERFACE ze() {
        return this.ape;
    }

    protected a(Class<?> cls) {
        this.aoz = cls;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        if (ze() != null) {
            return true;
        }
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.ape = b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.ape);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.ape, (INTERFACE) this.apd);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
        List list = (List) this.amm.clone();
        this.amm.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.kwad.framework.filedownloader.f.xn().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.aoz));
    }
}
