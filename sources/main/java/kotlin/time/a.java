package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.SinceKotlin;
import kotlin.time.e0;
import kotlin.time.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(level = DeprecationLevel.ERROR, message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements e0.c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final DurationUnit f47985b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.time.a$a, reason: collision with other inner class name */
    private static final class C0928a implements g {

        /* renamed from: a, reason: collision with root package name */
        private final double f47986a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final a f47987b;

        /* renamed from: c, reason: collision with root package name */
        private final long f47988c;

        public /* synthetic */ C0928a(double d6, a aVar, long j6, kotlin.jvm.internal.v vVar) {
            this(d6, aVar, j6);
        }

        @Override // kotlin.time.d0
        @NotNull
        public /* bridge */ g f(long j6) {
            return g.a.d(this, j6);
        }

        private C0928a(double d6, a timeSource, long j6) {
            kotlin.jvm.internal.g0.p(timeSource, "timeSource");
            this.f47986a = d6;
            this.f47987b = timeSource;
            this.f47988c = j6;
        }

        @Override // kotlin.time.d0
        public long a() {
            return h.X(j.v(this.f47987b.c() - this.f47986a, this.f47987b.b()), this.f47988c);
        }

        @Override // kotlin.time.d0
        @NotNull
        public g e(long j6) {
            return new C0928a(this.f47986a, this.f47987b, h.Y(this.f47988c, j6), null);
        }

        @Override // kotlin.time.g
        public boolean equals(@Nullable Object obj) {
            return (obj instanceof C0928a) && kotlin.jvm.internal.g0.g(this.f47987b, ((C0928a) obj).f47987b) && h.q(g((g) obj), h.f48019b.T());
        }

        @Override // kotlin.time.g
        public long g(@NotNull g other) {
            kotlin.jvm.internal.g0.p(other, "other");
            if (other instanceof C0928a) {
                C0928a c0928a = (C0928a) other;
                if (kotlin.jvm.internal.g0.g(this.f47987b, c0928a.f47987b)) {
                    if (h.q(this.f47988c, c0928a.f47988c) && h.U(this.f47988c)) {
                        return h.f48019b.T();
                    }
                    long X = h.X(this.f47988c, c0928a.f47988c);
                    long v5 = j.v(this.f47986a - c0928a.f47986a, this.f47987b.b());
                    return h.q(v5, h.n0(X)) ? h.f48019b.T() : h.Y(v5, X);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.g
        public int hashCode() {
            return h.Q(h.Y(j.v(this.f47986a, this.f47987b.b()), this.f47988c));
        }

        @NotNull
        public String toString() {
            return "DoubleTimeMark(" + this.f47986a + m.h(this.f47987b.b()) + " + " + ((Object) h.j0(this.f47988c)) + ", " + this.f47987b + ')';
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

    protected abstract double c();

    public a(@NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        this.f47985b = unit;
    }

    @Override // kotlin.time.e0
    @NotNull
    public g a() {
        return new C0928a(c(), this, h.f48019b.T(), null);
    }

    @NotNull
    protected final DurationUnit b() {
        return this.f47985b;
    }
}
