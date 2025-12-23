package androidx.camera.core.processing;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f497a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f497a.disconnectWithoutCheckingClosed();
    }

    public /* synthetic */ t(SurfaceEdge surfaceEdge) {
        this.f497a = surfaceEdge;
    }
}
