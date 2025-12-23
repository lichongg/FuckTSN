package okhttp3.internal.ws;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWebSocketProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketProtocol.kt\nokhttp3/internal/ws/WebSocketProtocol\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n1#2:153\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class WebSocketProtocol {

    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;

    @NotNull
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    @NotNull
    public final String acceptHeader(@NotNull String key) {
        g0.p(key, "key");
        return ByteString.Companion.encodeUtf8(key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int i6) {
        if (i6 < 1000 || i6 >= 5000) {
            return "Code must be in range [1000,5000): " + i6;
        }
        if ((1004 > i6 || i6 >= 1007) && (1015 > i6 || i6 >= 3000)) {
            return null;
        }
        return "Code " + i6 + " is reserved and may not be used.";
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor cursor, @NotNull byte[] key) {
        g0.p(cursor, "cursor");
        g0.p(key, "key");
        int length = key.length;
        int i6 = 0;
        do {
            byte[] bArr = cursor.data;
            int i7 = cursor.start;
            int i8 = cursor.end;
            if (bArr != null) {
                while (i7 < i8) {
                    int i9 = i6 % length;
                    bArr[i7] = (byte) (bArr[i7] ^ key[i9]);
                    i7++;
                    i6 = i9 + 1;
                }
            }
        } while (cursor.next() != -1);
    }

    private WebSocketProtocol() {
    }

    public final void validateCloseCode(int i6) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i6);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        g0.m(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
