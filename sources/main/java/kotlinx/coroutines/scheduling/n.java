package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlin.ranges.t;
import kotlinx.coroutines.internal.v0;
import kotlinx.coroutines.internal.x0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final String f49507a = v0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public static final long f49508b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    public static final int f49509c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    public static final int f49510d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    public static final long f49511e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static i f49512f = null;

    /* renamed from: g, reason: collision with root package name */
    public static final int f49513g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final int f49514h = 1;

    /* renamed from: i, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final k f49515i;

    /* renamed from: j, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final k f49516j;

    static {
        long f6;
        int e6;
        int e7;
        long f7;
        f6 = x0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f49508b = f6;
        e6 = x0.e("kotlinx.coroutines.scheduler.core.pool.size", t.u(v0.a(), 2), 1, 0, 8, null);
        f49509c = e6;
        e7 = x0.e("kotlinx.coroutines.scheduler.max.pool.size", CoroutineScheduler.f49462v, 0, CoroutineScheduler.f49462v, 4, null);
        f49510d = e7;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f7 = x0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f49511e = timeUnit.toNanos(f7);
        f49512f = g.f49497a;
        f49515i = new l(0);
        f49516j = new l(1);
    }

    public static final boolean a(@NotNull j jVar) {
        return jVar.f49504b.q() == 1;
    }
}
