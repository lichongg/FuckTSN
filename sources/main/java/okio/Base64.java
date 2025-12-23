package okio;

import java.util.Arrays;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-Base64")
/* renamed from: okio.-Base64, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Base64 {

    @NotNull
    private static final byte[] BASE64;

    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String str) {
        int i6;
        char charAt;
        g0.p(str, "<this>");
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i7 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i7];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt2 = str.charAt(i11);
            if ('A' <= charAt2 && charAt2 < '[') {
                i6 = charAt2 - 'A';
            } else if ('a' <= charAt2 && charAt2 < '{') {
                i6 = charAt2 - 'G';
            } else if ('0' <= charAt2 && charAt2 < ':') {
                i6 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i6 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i6 = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i9 = (i9 << 6) | i6;
            i8++;
            if (i8 % 4 == 0) {
                bArr[i10] = (byte) (i9 >> 16);
                int i12 = i10 + 2;
                bArr[i10 + 1] = (byte) (i9 >> 8);
                i10 += 3;
                bArr[i12] = (byte) i9;
            }
        }
        int i13 = i8 % 4;
        if (i13 == 1) {
            return null;
        }
        if (i13 == 2) {
            bArr[i10] = (byte) ((i9 << 12) >> 16);
            i10++;
        } else if (i13 == 3) {
            int i14 = i9 << 6;
            int i15 = i10 + 1;
            bArr[i10] = (byte) (i14 >> 16);
            i10 += 2;
            bArr[i15] = (byte) (i14 >> 8);
        }
        if (i10 == i7) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i10);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] bArr, @NotNull byte[] map) {
        g0.p(bArr, "<this>");
        g0.p(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            byte b6 = bArr[i6];
            int i8 = i6 + 2;
            byte b7 = bArr[i6 + 1];
            i6 += 3;
            byte b8 = bArr[i8];
            bArr2[i7] = map[(b6 & 255) >> 2];
            bArr2[i7 + 1] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            int i9 = i7 + 3;
            bArr2[i7 + 2] = map[((b7 & 15) << 2) | ((b8 & 255) >> 6)];
            i7 += 4;
            bArr2[i9] = map[b8 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b9 = bArr[i6];
            bArr2[i7] = map[(b9 & 255) >> 2];
            bArr2[i7 + 1] = map[(b9 & 3) << 4];
            bArr2[i7 + 2] = 61;
            bArr2[i7 + 3] = 61;
        } else if (length2 == 2) {
            int i10 = i6 + 1;
            byte b10 = bArr[i6];
            byte b11 = bArr[i10];
            bArr2[i7] = map[(b10 & 255) >> 2];
            bArr2[i7 + 1] = map[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            bArr2[i7 + 2] = map[(b11 & 15) << 2];
            bArr2[i7 + 3] = 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
