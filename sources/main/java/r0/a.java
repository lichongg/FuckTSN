package r0;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f51979b;

    /* renamed from: a, reason: collision with root package name */
    private int f51980a;

    public static a a() {
        if (f51979b == null) {
            synchronized (a.class) {
                try {
                    if (f51979b == null) {
                        f51979b = new a();
                    }
                } finally {
                }
            }
        }
        return f51979b;
    }

    public void b(int i6) {
        if (i6 <= 0) {
            return;
        }
        this.f51980a = i6;
    }

    public int c() {
        return this.f51980a;
    }

    private a() {
    }
}
