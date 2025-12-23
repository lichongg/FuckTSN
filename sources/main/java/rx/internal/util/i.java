package rx.internal.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f54160a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f54161b;

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f54162c;

    public static int a() {
        return f54161b;
    }

    public static boolean b() {
        return f54162c;
    }

    private static int c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    static {
        boolean z5;
        int c6 = c();
        f54161b = c6;
        if (c6 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        f54162c = z5;
    }

    private i() {
        throw new IllegalStateException("No instances!");
    }
}
