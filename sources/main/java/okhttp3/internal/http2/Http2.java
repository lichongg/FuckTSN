package okhttp3.internal.http2;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okhttp3.internal._UtilJvmKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Http2 {

    @NotNull
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    @NotNull
    public static final Http2 INSTANCE = new Http2();

    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    @NotNull
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    @NotNull
    private static final String[] FLAGS = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i6 = 0; i6 < 256; i6++) {
            String binaryString = Integer.toBinaryString(i6);
            g0.o(binaryString, "toBinaryString(...)");
            strArr[i6] = u.w2(_UtilJvmKt.format("%8s", binaryString), ' ', '0', false, 4, null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i7 = iArr[0];
        strArr2[i7 | 8] = strArr2[i7] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            int i10 = iArr[0];
            String[] strArr3 = FLAGS;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            strArr3[i11 | 8] = strArr3[i10] + '|' + strArr3[i9] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i12 = 0; i12 < length; i12++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i12] == null) {
                strArr4[i12] = BINARY[i12];
            }
        }
    }

    @NotNull
    public final String formatFlags(int i6, int i7) {
        String str;
        if (i7 == 0) {
            return "";
        }
        if (i6 != 2 && i6 != 3) {
            if (i6 == 4 || i6 == 6) {
                return i7 == 1 ? "ACK" : BINARY[i7];
            }
            if (i6 != 7 && i6 != 8) {
                String[] strArr = FLAGS;
                if (i7 < strArr.length) {
                    str = strArr[i7];
                    g0.m(str);
                } else {
                    str = BINARY[i7];
                }
                String str2 = str;
                return (i6 != 5 || (i7 & 4) == 0) ? (i6 != 0 || (i7 & 32) == 0) ? str2 : u.x2(str2, "PRIORITY", "COMPRESSED", false, 4, null) : u.x2(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return BINARY[i7];
    }

    @NotNull
    public final String formattedType$okhttp(int i6) {
        String[] strArr = FRAME_NAMES;
        return i6 < strArr.length ? strArr[i6] : _UtilJvmKt.format("0x%02x", Integer.valueOf(i6));
    }

    @NotNull
    public final String frameLogWindowUpdate(boolean z5, int i6, int i7, long j6) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", z5 ? "<<" : ">>", Integer.valueOf(i6), Integer.valueOf(i7), formattedType$okhttp(8), Long.valueOf(j6));
    }

    private Http2() {
    }

    @NotNull
    public final String frameLog(boolean z5, int i6, int i7, int i8, int i9) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(i8);
        String formatFlags = formatFlags(i8, i9);
        if (z5) {
            str = "<<";
        } else {
            str = ">>";
        }
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i6), Integer.valueOf(i7), formattedType$okhttp, formatFlags);
    }
}
