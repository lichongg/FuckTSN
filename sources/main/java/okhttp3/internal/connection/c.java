package okhttp3.internal.connection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ boolean a(RoutePlanner routePlanner, RealConnection realConnection, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasNext");
        }
        if ((i6 & 1) != 0) {
            realConnection = null;
        }
        return routePlanner.hasNext(realConnection);
    }
}
