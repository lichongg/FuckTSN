package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.time.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public interface e0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f48003a = a.f48004a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements c {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f48005b = new b();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SinceKotlin(version = "1.9")
        @JvmInline
        @WasExperimental(markerClass = {ExperimentalTime.class})
        public static final class a implements g {

            /* renamed from: a, reason: collision with root package name */
            private final long f48006a;

            @Override // kotlin.time.g, kotlin.time.d0
            public /* bridge */ /* synthetic */ g e(long j6) {
                return d(u(j6));
            }

            @Override // kotlin.time.g, kotlin.time.d0
            public /* bridge */ /* synthetic */ g f(long j6) {
                return d(r(j6));
            }

            public static final /* synthetic */ a d(long j6) {
                return new a(j6);
            }

            public static int i(long j6, @NotNull g other) {
                kotlin.jvm.internal.g0.p(other, "other");
                return d(j6).compareTo(other);
            }

            public static long k(long j6) {
                return b0.f47990b.d(j6);
            }

            public static boolean l(long j6, Object obj) {
                return (obj instanceof a) && j6 == ((a) obj).x();
            }

            public static final boolean m(long j6, long j7) {
                return j6 == j7;
            }

            public static final long q(long j6, long j7) {
                return b0.f47990b.c(j6, j7);
            }

            public static long s(long j6, long j7) {
                return b0.f47990b.b(j6, h.n0(j7));
            }

            public static long t(long j6, @NotNull g other) {
                kotlin.jvm.internal.g0.p(other, "other");
                if (other instanceof a) {
                    return q(j6, ((a) other).x());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) w(j6)) + " and " + other);
            }

            public static long v(long j6, long j7) {
                return b0.f47990b.b(j6, j7);
            }

            public static String w(long j6) {
                return "ValueTimeMark(reading=" + j6 + ')';
            }

            @Override // kotlin.time.d0
            public long a() {
                return k(this.f48006a);
            }

            @Override // kotlin.time.d0
            public boolean b() {
                return n(this.f48006a);
            }

            @Override // kotlin.time.d0
            public boolean c() {
                return o(this.f48006a);
            }

            @Override // kotlin.time.d0
            public /* bridge */ /* synthetic */ d0 e(long j6) {
                return d(u(j6));
            }

            @Override // kotlin.time.g
            public boolean equals(Object obj) {
                return l(this.f48006a, obj);
            }

            @Override // kotlin.time.d0
            public /* bridge */ /* synthetic */ d0 f(long j6) {
                return d(r(j6));
            }

            @Override // kotlin.time.g
            public long g(@NotNull g other) {
                kotlin.jvm.internal.g0.p(other, "other");
                return t(this.f48006a, other);
            }

            @Override // kotlin.time.g
            public int hashCode() {
                return p(this.f48006a);
            }

            public long r(long j6) {
                return s(this.f48006a, j6);
            }

            public String toString() {
                return w(this.f48006a);
            }

            public long u(long j6) {
                return v(this.f48006a, j6);
            }

            public final /* synthetic */ long x() {
                return this.f48006a;
            }

            private /* synthetic */ a(long j6) {
                this.f48006a = j6;
            }

            public static final int h(long j6, long j7) {
                return h.k(q(j6, j7), h.f48019b.T());
            }

            public static boolean n(long j6) {
                return h.V(k(j6));
            }

            public static boolean o(long j6) {
                return !h.V(k(j6));
            }

            public static int p(long j6) {
                return androidx.camera.camera2.internal.compat.params.e.a(j6);
            }

            @Override // java.lang.Comparable
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            public /* bridge */ int compareTo(@NotNull g gVar) {
                return g.a.a(this, gVar);
            }

            public static long j(long j6) {
                return j6;
            }
        }

        @Override // kotlin.time.e0.c, kotlin.time.e0
        public /* bridge */ /* synthetic */ g a() {
            return a.d(b());
        }

        @Override // kotlin.time.e0
        public /* bridge */ /* synthetic */ d0 a() {
            return a.d(b());
        }

        public long b() {
            return b0.f47990b.e();
        }

        @NotNull
        public String toString() {
            return b0.f47990b.toString();
        }

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public interface c extends e0 {
        @Override // kotlin.time.e0
        @NotNull
        g a();
    }

    @NotNull
    d0 a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f48004a = new a();

        private a() {
        }
    }
}
