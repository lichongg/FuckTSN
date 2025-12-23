package p4;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.n3;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    private static final long a(Duration duration) {
        Duration duration2;
        int compareTo;
        ChronoUnit chronoUnit;
        Duration duration3;
        int compareTo2;
        long seconds;
        long millis;
        long seconds2;
        int nano;
        duration2 = Duration.ZERO;
        compareTo = duration.compareTo(duration2);
        if (compareTo > 0) {
            chronoUnit = ChronoUnit.MILLIS;
            duration3 = chronoUnit.getDuration();
            compareTo2 = duration.compareTo(duration3);
            if (compareTo2 > 0) {
                seconds = duration.getSeconds();
                if (seconds >= 9223372036854775L) {
                    seconds2 = duration.getSeconds();
                    if (seconds2 == 9223372036854775L) {
                        nano = duration.getNano();
                        if (nano >= 807000000) {
                            return Long.MAX_VALUE;
                        }
                    } else {
                        return Long.MAX_VALUE;
                    }
                }
                millis = duration.toMillis();
                return millis;
            }
            return 1L;
        }
        return 0L;
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> b(@NotNull i<? extends T> iVar, @NotNull Duration duration) {
        return k.a0(iVar, a(duration));
    }

    @Nullable
    public static final Object c(@NotNull Duration duration, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object b6 = a1.b(a(duration), eVar);
        if (b6 == kotlin.coroutines.intrinsics.a.l()) {
            return b6;
        }
        return n1.f44123a;
    }

    public static final <R> void d(@NotNull kotlinx.coroutines.selects.c<? super R> cVar, @NotNull Duration duration, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
        kotlinx.coroutines.selects.b.a(cVar, a(duration), function1);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> e(@NotNull i<? extends T> iVar, @NotNull Duration duration) {
        return k.B1(iVar, a(duration));
    }

    @Nullable
    public static final <T> Object f(@NotNull Duration duration, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return n3.c(a(duration), function2, eVar);
    }

    @Nullable
    public static final <T> Object g(@NotNull Duration duration, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return n3.e(a(duration), function2, eVar);
    }
}
