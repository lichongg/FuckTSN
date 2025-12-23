package kotlin.time;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "2.1")
@SourceDebugExtension({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/Instant\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/InstantKt\n+ 4 Duration.kt\nkotlin/time/Duration\n*L\n1#1,864:1\n1#2:865\n803#3,14:866\n786#3,6:880\n803#3,14:886\n786#3,6:900\n786#3,6:907\n548#4:906\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/Instant\n*L\n150#1:866,14\n153#1:880,6\n161#1:886,14\n164#1:900,6\n188#1:907,6\n184#1:906\n*E\n"})
@ExperimentalTime
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Instant implements Comparable<Instant>, Serializable {
    private final long epochSeconds;
    private final int nanosecondsOfSecond;

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final Instant MIN = new Instant(-31557014167219200L, 0);

    @NotNull
    private static final Instant MAX = new Instant(31556889864403199L, 999999999);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/Instant$Companion\n+ 2 Instant.kt\nkotlin/time/InstantKt\n*L\n1#1,864:1\n786#2,6:865\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/Instant$Companion\n*L\n312#1:865,6\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        @NotNull
        public final Instant b(long j6, int i6) {
            return c(j6, i6);
        }

        private a() {
        }

        public static /* synthetic */ Instant d(a aVar, long j6, long j7, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                j7 = 0;
            }
            return aVar.c(j6, j7);
        }

        @NotNull
        public final Instant a(long j6) {
            long j7 = j6 / 1000;
            if ((j6 ^ 1000) < 0 && j7 * 1000 != j6) {
                j7--;
            }
            long j8 = j6 % 1000;
            return j7 < -31557014167219200L ? h() : j7 > 31556889864403199L ? g() : b(j7, (int) ((j8 + (1000 & (((j8 ^ 1000) & ((-j8) | j8)) >> 63))) * 1000000));
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Clock.System.now() instead", replaceWith = @ReplaceWith(expression = "Clock.System.now()", imports = {"kotlin.time.Clock"}))
        @NotNull
        public final Instant i() {
            throw new NotImplementedError(null, 1, null);
        }

        @NotNull
        public final Instant j(@NotNull CharSequence input) {
            w r5;
            kotlin.jvm.internal.g0.p(input, "input");
            r5 = v.r(input);
            return r5.toInstant();
        }

        @SinceKotlin(version = "2.2")
        @Nullable
        public final Instant k(@NotNull CharSequence input) {
            w r5;
            kotlin.jvm.internal.g0.p(input, "input");
            r5 = v.r(input);
            return r5.a();
        }

        @NotNull
        public final Instant c(long j6, long j7) {
            long j8 = j7 / C.NANOS_PER_SECOND;
            if ((j7 ^ C.NANOS_PER_SECOND) < 0 && j8 * C.NANOS_PER_SECOND != j7) {
                j8--;
            }
            long j9 = j6 + j8;
            if ((j6 ^ j9) < 0 && (j8 ^ j6) >= 0) {
                a aVar = Instant.Companion;
                if (j6 > 0) {
                    return aVar.g();
                }
                return aVar.h();
            }
            if (j9 < -31557014167219200L) {
                return h();
            }
            if (j9 > 31556889864403199L) {
                return g();
            }
            long j10 = j7 % C.NANOS_PER_SECOND;
            return new Instant(j9, (int) (j10 + ((((j10 ^ C.NANOS_PER_SECOND) & ((-j10) | j10)) >> 63) & C.NANOS_PER_SECOND)));
        }

        @NotNull
        public final Instant g() {
            return Instant.MAX;
        }

        @NotNull
        public final Instant h() {
            return Instant.MIN;
        }

        @NotNull
        public final Instant e() {
            return b(3093527980800L, 0);
        }

        @NotNull
        public final Instant f() {
            return b(-3217862419201L, 999999999);
        }
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Instant other) {
        kotlin.jvm.internal.g0.p(other, "other");
        int u5 = kotlin.jvm.internal.g0.u(this.epochSeconds, other.epochSeconds);
        return u5 != 0 ? u5 : kotlin.jvm.internal.g0.t(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.epochSeconds == instant.epochSeconds && this.nanosecondsOfSecond == instant.nanosecondsOfSecond;
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public int hashCode() {
        return androidx.camera.camera2.internal.compat.params.e.a(this.epochSeconds) + (this.nanosecondsOfSecond * 51);
    }

    /* renamed from: minus-UwyO8pc, reason: not valid java name */
    public final long m142minusUwyO8pc(@NotNull Instant other) {
        kotlin.jvm.internal.g0.p(other, "other");
        h.a aVar = h.f48019b;
        return h.Y(j.x(this.epochSeconds - other.epochSeconds, DurationUnit.SECONDS), j.w(this.nanosecondsOfSecond - other.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    public final long toEpochMilliseconds() {
        long j6 = this.epochSeconds;
        long j7 = 1000;
        if (j6 >= 0) {
            if (j6 != 1) {
                if (j6 != 0) {
                    long j8 = j6 * 1000;
                    if (j8 / 1000 != j6) {
                        return Long.MAX_VALUE;
                    }
                    j7 = j8;
                } else {
                    j7 = 0;
                }
            }
            long j9 = this.nanosecondsOfSecond / 1000000;
            long j10 = j7 + j9;
            if ((j7 ^ j10) >= 0 || (j9 ^ j7) < 0) {
                return j10;
            }
            return Long.MAX_VALUE;
        }
        long j11 = j6 + 1;
        if (j11 != 1) {
            if (j11 != 0) {
                long j12 = j11 * 1000;
                if (j12 / 1000 != j11) {
                    return Long.MIN_VALUE;
                }
                j7 = j12;
            } else {
                j7 = 0;
            }
        }
        long j13 = (this.nanosecondsOfSecond / 1000000) - 1000;
        long j14 = j7 + j13;
        if ((j7 ^ j14) >= 0 || (j13 ^ j7) < 0) {
            return j14;
        }
        return Long.MIN_VALUE;
    }

    public Instant(long j6, int i6) {
        this.epochSeconds = j6;
        this.nanosecondsOfSecond = i6;
        if (-31557014167219200L <= j6 && j6 < 31556889864403200L) {
        } else {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant");
        }
    }

    private final Object writeReplace() {
        return o.b(this);
    }

    @NotNull
    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m141minusLRDsOJo(long j6) {
        return m143plusLRDsOJo(h.n0(j6));
    }

    @NotNull
    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m143plusLRDsOJo(long j6) {
        long C = h.C(j6);
        int I = h.I(j6);
        if (C == 0 && I == 0) {
            return this;
        }
        long j7 = this.epochSeconds;
        long j8 = j7 + C;
        if ((j7 ^ j8) < 0 && (C ^ j7) >= 0) {
            if (h.W(j6)) {
                return MAX;
            }
            return MIN;
        }
        return Companion.b(j8, this.nanosecondsOfSecond + I);
    }

    @NotNull
    public String toString() {
        String j6;
        j6 = v.j(this);
        return j6;
    }
}
