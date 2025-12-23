package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,210:1\n80#2:211\n80#2:212\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n*L\n184#1:211\n191#1:212\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c0 extends c {

    /* renamed from: d, reason: collision with root package name */
    private long f47997d;

    public c0() {
        super(DurationUnit.NANOSECONDS);
        a();
    }

    private final void i(long j6) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f47997d + m.h(e()) + " is advanced by " + ((Object) h.j0(j6)) + '.');
    }

    @Override // kotlin.time.c
    protected long g() {
        return this.f47997d;
    }

    public final void j(long j6) {
        long i02 = h.i0(j6, e());
        if (((i02 - 1) | 1) == Long.MAX_VALUE) {
            long o5 = h.o(j6, 2);
            if ((1 | (h.i0(o5, e()) - 1)) == Long.MAX_VALUE) {
                i(j6);
                return;
            }
            long j7 = this.f47997d;
            try {
                j(o5);
                j(h.X(j6, o5));
                return;
            } catch (IllegalStateException e6) {
                this.f47997d = j7;
                throw e6;
            }
        }
        long j8 = this.f47997d;
        long j9 = j8 + i02;
        if ((i02 ^ j8) >= 0 && (j8 ^ j9) < 0) {
            i(j6);
        }
        this.f47997d = j9;
    }
}
