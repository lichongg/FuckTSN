package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements e {

        /* renamed from: b, reason: collision with root package name */
        private final d0 f48007b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Instant f48008c;

        a(e0 e0Var, Instant instant) {
            this.f48008c = instant;
            this.f48007b = e0Var.a();
        }

        @Override // kotlin.time.e
        public Instant a() {
            return this.f48008c.m143plusLRDsOJo(this.f48007b.a());
        }
    }

    @SinceKotlin(version = "2.2")
    @JvmName(name = "fromTimeSource")
    @NotNull
    @ExperimentalTime
    public static final e a(@NotNull e0 e0Var, @NotNull Instant origin) {
        kotlin.jvm.internal.g0.p(e0Var, "<this>");
        kotlin.jvm.internal.g0.p(origin, "origin");
        return new a(e0Var, origin);
    }
}
