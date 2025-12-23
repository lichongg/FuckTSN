package kotlin.uuid;

import com.google.common.primitives.SignedBytes;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.i;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nUuid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uuid.kt\nkotlin/uuid/UuidKt__UuidKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,648:1\n1#2:649\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class d extends c {
    public static final void q(@NotNull String str, int i6) {
        g0.p(str, "<this>");
        if (str.charAt(i6) == '-') {
            return;
        }
        throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i6 + ", but was '" + str.charAt(i6) + '\'').toString());
    }

    @ExperimentalUuidApi
    public static final void r(long j6, @NotNull byte[] dst, int i6, int i7, int i8) {
        g0.p(dst, "dst");
        int i9 = 7 - i7;
        int i10 = 8 - i8;
        if (i10 > i9) {
            return;
        }
        while (true) {
            int i11 = i.m()[(int) ((j6 >> (i9 << 3)) & 255)];
            int i12 = i6 + 1;
            dst[i6] = (byte) (i11 >> 8);
            i6 += 2;
            dst[i12] = (byte) i11;
            if (i9 == i10) {
                return;
            } else {
                i9--;
            }
        }
    }

    public static final long s(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "<this>");
        return (bArr[i6 + 7] & 255) | ((bArr[i6] & 255) << 56) | ((bArr[i6 + 1] & 255) << 48) | ((bArr[i6 + 2] & 255) << 40) | ((bArr[i6 + 3] & 255) << 32) | ((bArr[i6 + 4] & 255) << 24) | ((bArr[i6 + 5] & 255) << 16) | ((bArr[i6 + 6] & 255) << 8);
    }

    public static final void t(@NotNull byte[] bArr, int i6, long j6) {
        g0.p(bArr, "<this>");
        int i7 = 7;
        while (-1 < i7) {
            bArr[i6] = (byte) (j6 >> (i7 << 3));
            i7--;
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v(byte[] bArr, int i6) {
        return n.yh(bArr, null, "[", "]", i6, null, null, 49, null);
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Uuid w(@NotNull byte[] randomBytes) {
        g0.p(randomBytes, "randomBytes");
        byte b6 = (byte) (randomBytes[6] & 15);
        randomBytes[6] = b6;
        randomBytes[6] = (byte) (b6 | SignedBytes.MAX_POWER_OF_TWO);
        byte b7 = (byte) (randomBytes[8] & Utf8.REPLACEMENT_BYTE);
        randomBytes[8] = b7;
        randomBytes[8] = (byte) (b7 | 128);
        return Uuid.Companion.a(randomBytes);
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Uuid x(@NotNull String hexString) {
        g0.p(hexString, "hexString");
        return Uuid.Companion.b(i.G(hexString, 0, 16, null, 4, null), i.G(hexString, 16, 32, null, 4, null));
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Uuid y(@NotNull String hexDashString) {
        g0.p(hexDashString, "hexDashString");
        long G = i.G(hexDashString, 0, 8, null, 4, null);
        q(hexDashString, 8);
        long G2 = i.G(hexDashString, 9, 13, null, 4, null);
        q(hexDashString, 13);
        long G3 = i.G(hexDashString, 14, 18, null, 4, null);
        q(hexDashString, 18);
        long G4 = i.G(hexDashString, 19, 23, null, 4, null);
        q(hexDashString, 23);
        return Uuid.Companion.b((G2 << 16) | (G << 32) | G3, (G4 << 48) | i.G(hexDashString, 24, 36, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(String str, int i6) {
        if (str.length() <= i6) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        g0.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, i6);
        g0.o(substring, "substring(...)");
        sb.append(substring);
        sb.append("...");
        return sb.toString();
    }
}
