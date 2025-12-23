package okio.internal;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-ByteStringNonJs")
@SourceDebugExtension({"SMAP\nByteStringNonJs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteStringNonJs.kt\nokio/internal/-ByteStringNonJs\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
/* renamed from: okio.internal.-ByteStringNonJs, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ByteStringNonJs {
    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String str) {
        g0.p(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) ((decodeHexDigit(str.charAt(i7)) << 4) + decodeHexDigit(str.charAt(i7 + 1)));
        }
        return new ByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c6) {
        if ('0' <= c6 && c6 < ':') {
            return c6 - '0';
        }
        if ('a' <= c6 && c6 < 'g') {
            return c6 - 'W';
        }
        if ('A' <= c6 && c6 < 'G') {
            return c6 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c6);
    }
}
