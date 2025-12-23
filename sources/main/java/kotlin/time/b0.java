package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.time.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0 implements e0.c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b0 f47990b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private static final long f47991c = System.nanoTime();

    @Override // kotlin.time.e0.c, kotlin.time.e0
    public /* bridge */ /* synthetic */ g a() {
        return e0.b.a.d(e());
    }

    @Override // kotlin.time.e0
    public /* bridge */ /* synthetic */ d0 a() {
        return e0.b.a.d(e());
    }

    public final long b(long j6, long j7) {
        return e0.b.a.j(y.d(j6, DurationUnit.NANOSECONDS, j7));
    }

    public final long c(long j6, long j7) {
        return y.h(j6, j7, DurationUnit.NANOSECONDS);
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    private b0() {
    }

    private final long f() {
        return System.nanoTime() - f47991c;
    }

    public final long d(long j6) {
        return y.f(f(), j6, DurationUnit.NANOSECONDS);
    }

    public long e() {
        return e0.b.a.j(f());
    }
}
