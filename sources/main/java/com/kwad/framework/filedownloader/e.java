package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus alR;

    public abstract void xk();

    public abstract void xl();

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus yH = ((DownloadServiceConnectChangedEvent) bVar).yH();
        this.alR = yH;
        if (yH == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            xk();
            return false;
        }
        xl();
        return false;
    }

    public final DownloadServiceConnectChangedEvent.ConnectStatus xm() {
        return this.alR;
    }
}
