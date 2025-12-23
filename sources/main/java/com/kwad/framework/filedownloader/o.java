package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class o implements e.a, u {
    private static Class<?> aml;
    private final ArrayList<Runnable> amm = new ArrayList<>();
    private com.kwad.framework.filedownloader.services.e amn;

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z5, int i6, int i7, int i8, boolean z6, com.kwad.framework.filedownloader.d.b bVar, boolean z7) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z5);
        }
        this.amn.b(str, str2, z5, i6, i7, i8, z6, bVar, z7);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aG(Context context) {
        a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.amn = null;
        f.xn().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, xD()));
    }

    private static Class<?> xD() {
        if (aml == null) {
            aml = FileDownloadService.SharedMainProcessService.class;
        }
        return aml;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.amn != null;
    }

    o() {
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bw(int i6) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bw(i6);
        }
        return this.amn.bw(i6);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bx(int i6) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bx(i6);
        }
        return this.amn.bx(i6);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean by(int i6) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.by(i6);
        }
        return this.amn.by(i6);
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, xD()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.amn = eVar;
        List list = (List) this.amm.clone();
        this.amm.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.xn().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, xD()));
    }
}
