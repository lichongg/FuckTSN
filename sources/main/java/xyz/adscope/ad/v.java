package xyz.adscope.ad;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final u f56013a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static v f56014a = new v(null);
    }

    /* synthetic */ v(a aVar) {
        this();
    }

    private v() {
        if (b.f56014a != null) {
            throw new RuntimeException("Singleton ...");
        }
        this.f56013a = new u();
    }

    public o3 b() {
        return this.f56013a;
    }

    public static v a() {
        return b.f56014a;
    }
}
