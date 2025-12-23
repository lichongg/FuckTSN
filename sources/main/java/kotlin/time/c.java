package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.e0;
import kotlin.time.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c implements e0.c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final DurationUnit f47992b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.s f47993c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,210:1\n80#2:211\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:211\n*E\n"})
    private static final class a implements g {

        /* renamed from: a, reason: collision with root package name */
        private final long f47994a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final c f47995b;

        /* renamed from: c, reason: collision with root package name */
        private final long f47996c;

        public /* synthetic */ a(long j6, c cVar, long j7, kotlin.jvm.internal.v vVar) {
            this(j6, cVar, j7);
        }

        @Override // kotlin.time.d0
        @NotNull
        public /* bridge */ g f(long j6) {
            return g.a.d(this, j6);
        }

        private a(long j6, c timeSource, long j7) {
            kotlin.jvm.internal.g0.p(timeSource, "timeSource");
            this.f47994a = j6;
            this.f47995b = timeSource;
            this.f47996c = j7;
        }

        @Override // kotlin.time.d0
        public long a() {
            return h.X(y.h(this.f47995b.d(), this.f47994a, this.f47995b.e()), this.f47996c);
        }

        @Override // kotlin.time.d0
        @NotNull
        public g e(long j6) {
            DurationUnit e6 = this.f47995b.e();
            if (h.U(j6)) {
                return new a(y.d(this.f47994a, e6, j6), this.f47995b, h.f48019b.T(), null);
            }
            long m02 = h.m0(j6, e6);
            long Y = h.Y(h.X(j6, m02), this.f47996c);
            long d6 = y.d(this.f47994a, e6, m02);
            long m03 = h.m0(Y, e6);
            long d7 = y.d(d6, e6, m03);
            long X = h.X(Y, m03);
            long z5 = h.z(X);
            if (d7 != 0 && z5 != 0 && (d7 ^ z5) < 0) {
                long w5 = j.w(kotlin.math.b.V(z5), e6);
                d7 = y.d(d7, e6, w5);
                X = h.X(X, w5);
            }
            if ((1 | (d7 - 1)) == Long.MAX_VALUE) {
                X = h.f48019b.T();
            }
            return new a(d7, this.f47995b, X, null);
        }

        @Override // kotlin.time.g
        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.g0.g(this.f47995b, ((a) obj).f47995b) && h.q(g((g) obj), h.f48019b.T());
        }

        @Override // kotlin.time.g
        public long g(@NotNull g other) {
            kotlin.jvm.internal.g0.p(other, "other");
            if (other instanceof a) {
                a aVar = (a) other;
                if (kotlin.jvm.internal.g0.g(this.f47995b, aVar.f47995b)) {
                    return h.Y(y.h(this.f47994a, aVar.f47994a, this.f47995b.e()), h.X(this.f47996c, aVar.f47996c));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.g
        public int hashCode() {
            return (h.Q(this.f47996c) * 37) + androidx.camera.camera2.internal.compat.params.e.a(this.f47994a);
        }

        @NotNull
        public String toString() {
            return "LongTimeMark(" + this.f47994a + m.h(this.f47995b.e()) + " + " + ((Object) h.j0(this.f47996c)) + ", " + this.f47995b + ')';
        }

        @Override // java.lang.Comparable
        /* renamed from: N */
        public /* bridge */ int compareTo(@NotNull g gVar) {
            return g.a.a(this, gVar);
        }

        @Override // kotlin.time.d0
        public /* bridge */ boolean b() {
            return g.a.b(this);
        }

        @Override // kotlin.time.d0
        public /* bridge */ boolean c() {
            return g.a.c(this);
        }
    }

    protected abstract long g();

    public c(@NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        this.f47992b = unit;
        this.f47993c = kotlin.t.c(new Function0() { // from class: kotlin.time.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long h6;
                h6 = c.h(c.this);
                return Long.valueOf(h6);
            }
        });
    }

    private final long f() {
        return ((Number) this.f47993c.getValue()).longValue();
    }

    @Override // kotlin.time.e0
    @NotNull
    public g a() {
        return new a(d(), this, h.f48019b.T(), null);
    }

    @NotNull
    protected final DurationUnit e() {
        return this.f47992b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long d() {
        return g() - f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h(c cVar) {
        return cVar.g();
    }
}
