package okhttp3.internal;

import java.io.EOFException;
import kotlin.jvm.internal.g0;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class IsProbablyUtf8Kt {
    public static final boolean isProbablyUtf8(@NotNull BufferedSource bufferedSource, long j6) {
        g0.p(bufferedSource, "<this>");
        try {
            BufferedSource peek = bufferedSource.peek();
            for (long j7 = 0; j7 < j6; j7++) {
                if (peek.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = peek.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean isProbablyUtf8$default(BufferedSource bufferedSource, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = Long.MAX_VALUE;
        }
        return isProbablyUtf8(bufferedSource, j6);
    }
}
