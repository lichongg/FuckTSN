package okio;

import java.util.zip.Deflater;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-DeflaterSinkExtensions")
/* renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DeflaterSinkExtensions {
    @NotNull
    public static final DeflaterSink deflate(@NotNull Sink sink, @NotNull Deflater deflater) {
        g0.p(sink, "<this>");
        g0.p(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            deflater = new Deflater();
        }
        g0.p(sink, "<this>");
        g0.p(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
