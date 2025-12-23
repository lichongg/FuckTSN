package k4;

import java.time.Duration;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.time.DurationUnit;
import kotlin.time.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "DurationConversionsJDK8Kt")
@SourceDebugExtension({"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,33:1\n548#2:34\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n33#1:34\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {
    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final long b(Duration duration) {
        long seconds;
        int nano;
        g0.p(duration, "<this>");
        seconds = duration.getSeconds();
        long x5 = j.x(seconds, DurationUnit.SECONDS);
        nano = duration.getNano();
        return kotlin.time.h.Y(x5, j.w(nano, DurationUnit.NANOSECONDS));
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final Duration a(long j6) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(kotlin.time.h.C(j6), kotlin.time.h.I(j6));
        g0.o(ofSeconds, "toComponents-impl(...)");
        return ofSeconds;
    }
}
