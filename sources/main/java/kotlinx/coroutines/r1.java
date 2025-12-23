package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r1 {

    /* renamed from: b, reason: collision with root package name */
    private static final int f49436b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f49437c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f49438d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final long f49439e = 1000000;

    /* renamed from: f, reason: collision with root package name */
    private static final long f49440f = 9223372036854L;

    /* renamed from: g, reason: collision with root package name */
    private static final long f49441g = 4611686018427387903L;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.s0 f49435a = new kotlinx.coroutines.internal.s0("REMOVED_TASK");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final kotlinx.coroutines.internal.s0 f49442h = new kotlinx.coroutines.internal.s0("CLOSED_EMPTY");

    public static final long d(long j6) {
        if (j6 <= 0) {
            return 0L;
        }
        if (j6 >= f49440f) {
            return Long.MAX_VALUE;
        }
        return j6 * 1000000;
    }

    public static final long c(long j6) {
        return j6 / 1000000;
    }
}
