package okio;

import java.util.zip.Inflater;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-InflaterSourceExtensions")
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source source, @NotNull Inflater inflater) {
        g0.p(source, "<this>");
        g0.p(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            inflater = new Inflater();
        }
        g0.p(source, "<this>");
        g0.p(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
