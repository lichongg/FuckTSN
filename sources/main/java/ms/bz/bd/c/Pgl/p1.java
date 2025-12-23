package ms.bz.bd.c.Pgl;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class p1 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile p1 f50317b;

    /* renamed from: a, reason: collision with root package name */
    private Throwable f50318a = null;

    public final synchronized Throwable b() {
        return this.f50318a;
    }

    public static p1 a() {
        if (f50317b == null) {
            synchronized (p1.class) {
                try {
                    if (f50317b == null) {
                        f50317b = new p1();
                    }
                } finally {
                }
            }
        }
        return f50317b;
    }

    private p1() {
    }
}
