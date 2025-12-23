package kotlin.time;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final e f48032a = kotlin.internal.b.f43804a.e();

    @ExperimentalTime
    @NotNull
    public static final Object b(@NotNull Instant instant) {
        kotlin.jvm.internal.g0.p(instant, "instant");
        return new x(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
    }

    @ExperimentalTime
    @NotNull
    public static final Instant c() {
        return f48032a.a();
    }

    @ExperimentalTime
    private static /* synthetic */ void a() {
    }
}
