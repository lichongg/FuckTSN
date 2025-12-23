package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48030a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f48030a = iArr;
        }
    }

    @SinceKotlin(version = "1.3")
    public static final double a(double d6, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        kotlin.jvm.internal.g0.p(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.g0.p(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        return convert > 0 ? d6 * convert : d6 / sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.5")
    public static final long b(long j6, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        kotlin.jvm.internal.g0.p(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.g0.p(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j6, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.5")
    public static final long c(long j6, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        kotlin.jvm.internal.g0.p(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.g0.p(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j6, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static final DurationUnit d(@NotNull TimeUnit timeUnit) {
        kotlin.jvm.internal.g0.p(timeUnit, "<this>");
        switch (a.f48030a[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @NotNull
    public static TimeUnit e(@NotNull DurationUnit durationUnit) {
        kotlin.jvm.internal.g0.p(durationUnit, "<this>");
        return durationUnit.getTimeUnit$kotlin_stdlib();
    }
}
