package rx.plugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f54436a = ".errorRendering";

    protected String c(Object obj) throws InterruptedException {
        return null;
    }

    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + f54436a;
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            return obj.getClass().getName() + f54436a;
        }
    }

    @Deprecated
    public void a(Throwable th) {
    }
}
