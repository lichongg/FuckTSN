package com.kwad.framework.filedownloader.event;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aoy;
    private final Class<?> aoz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.aoy = connectStatus;
        this.aoz = cls;
    }

    public final ConnectStatus yH() {
        return this.aoy;
    }
}
