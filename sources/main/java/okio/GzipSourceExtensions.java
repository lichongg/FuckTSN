package okio;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-GzipSourceExtensions")
/* renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int i6, int i7) {
        return ((i6 >> i7) & 1) == 1;
    }

    @NotNull
    public static final GzipSource gzip(@NotNull Source source) {
        g0.p(source, "<this>");
        return new GzipSource(source);
    }
}
