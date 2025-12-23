package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n1#2:29\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f48024a = false;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<DecimalFormat>[] f48025b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i6 = 0; i6 < 4; i6++) {
            threadLocalArr[i6] = new ThreadLocal<>();
        }
        f48025b = threadLocalArr;
    }

    private static final DecimalFormat a(int i6) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i6 > 0) {
            decimalFormat.setMinimumFractionDigits(i6);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @NotNull
    public static final String b(double d6, int i6) {
        DecimalFormat a6;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f48025b;
        if (i6 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i6];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = a(i6);
                threadLocal.set(decimalFormat);
            }
            a6 = decimalFormat;
        } else {
            a6 = a(i6);
        }
        String format = a6.format(d6);
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    public static final boolean c() {
        return f48024a;
    }
}
