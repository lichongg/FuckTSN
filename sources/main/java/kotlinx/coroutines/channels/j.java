package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.c0;
import kotlinx.coroutines.internal.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface j<E> extends c0<E>, b0<E> {

    /* renamed from: t0, reason: collision with root package name */
    @NotNull
    public static final b f48222t0 = b.f48229a;

    /* renamed from: u0, reason: collision with root package name */
    public static final int f48223u0 = Integer.MAX_VALUE;

    /* renamed from: v0, reason: collision with root package name */
    public static final int f48224v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public static final int f48225w0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    public static final int f48226x0 = -2;

    /* renamed from: y0, reason: collision with root package name */
    public static final int f48227y0 = -3;

    /* renamed from: z0, reason: collision with root package name */
    @NotNull
    public static final String f48228z0 = "kotlinx.coroutines.channels.defaultBuffer";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final int f48230b = Integer.MAX_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public static final int f48231c = 0;

        /* renamed from: d, reason: collision with root package name */
        public static final int f48232d = -1;

        /* renamed from: e, reason: collision with root package name */
        public static final int f48233e = -2;

        /* renamed from: f, reason: collision with root package name */
        public static final int f48234f = -3;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        public static final String f48235g = "kotlinx.coroutines.channels.defaultBuffer";

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f48229a = new b();

        /* renamed from: h, reason: collision with root package name */
        private static final int f48236h = v0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        public final int a() {
            return f48236h;
        }

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @NotNull
        public static <E> kotlinx.coroutines.selects.g<E> b(@NotNull j<E> jVar) {
            return b0.a.d(jVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@NotNull j<E> jVar, E e6) {
            return c0.a.c(jVar, e6);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @Nullable
        public static <E> E d(@NotNull j<E> jVar) {
            return (E) b0.a.h(jVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @LowPriorityInOverloadResolution
        @Nullable
        public static <E> Object e(@NotNull j<E> jVar, @NotNull kotlin.coroutines.e<? super E> eVar) {
            return b0.a.i(jVar, eVar);
        }
    }
}
