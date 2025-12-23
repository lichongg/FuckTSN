package okio;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink sink) {
        g0.p(sink, "<this>");
        return new GzipSink(sink);
    }
}
