package kotlin.reflect.jvm.internal.impl.name;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f46429a = new k("BEGINNING", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final k f46430b = new k("MIDDLE", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final k f46431c = new k("AFTER_DOT", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ k[] f46432d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ kotlin.enums.a f46433e;

    private static final /* synthetic */ k[] a() {
        return new k[]{f46429a, f46430b, f46431c};
    }

    static {
        k[] a6 = a();
        f46432d = a6;
        f46433e = kotlin.enums.c.c(a6);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f46432d.clone();
    }

    private k(String str, int i6) {
    }
}
