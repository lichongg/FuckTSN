package kotlin.math;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44114a = new a();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public static final double f44115b = Math.log(2.0d);

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    public static final double f44116c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    public static final double f44117d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    public static final double f44118e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    public static final double f44119f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    public static final double f44120g;

    static {
        double ulp = Math.ulp(1.0d);
        f44116c = ulp;
        double sqrt = Math.sqrt(ulp);
        f44117d = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f44118e = sqrt2;
        double d6 = 1;
        f44119f = d6 / sqrt;
        f44120g = d6 / sqrt2;
    }

    private a() {
    }
}
