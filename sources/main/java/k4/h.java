package k4;

import java.time.Instant;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.time.ExperimentalTime;
import kotlin.time.Instant;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "InstantConversionsJDK8Kt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {
    @SinceKotlin(version = "2.1")
    @ExperimentalTime
    @NotNull
    public static final Instant a(@NotNull kotlin.time.Instant instant) {
        Instant ofEpochSecond;
        g0.p(instant, "<this>");
        ofEpochSecond = Instant.ofEpochSecond(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
        g0.o(ofEpochSecond, "ofEpochSecond(...)");
        return ofEpochSecond;
    }

    @SinceKotlin(version = "2.1")
    @ExperimentalTime
    @NotNull
    public static final kotlin.time.Instant b(@NotNull Instant instant) {
        long epochSecond;
        int nano;
        g0.p(instant, "<this>");
        Instant.a aVar = kotlin.time.Instant.Companion;
        epochSecond = instant.getEpochSecond();
        nano = instant.getNano();
        return aVar.b(epochSecond, nano);
    }
}
