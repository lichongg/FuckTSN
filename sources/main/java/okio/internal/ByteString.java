package okio.internal;

import java.util.Arrays;
import kotlin.collections.n;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-ByteString")
@SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utf8.kt\nokio/Utf8\n*L\n1#1,342:1\n129#1,2:348\n131#1,9:351\n67#2:343\n73#2:344\n73#2:346\n73#2:347\n67#2:375\n73#2:387\n1#3:345\n1#3:350\n212#4,7:360\n122#4:367\n219#4,5:368\n122#4:373\n226#4:374\n228#4:376\n397#4,2:377\n122#4:379\n400#4,6:380\n127#4:386\n406#4:388\n122#4:389\n407#4,13:390\n122#4:403\n422#4:404\n122#4:405\n425#4:406\n230#4,3:407\n440#4,3:410\n122#4:413\n443#4:414\n127#4:415\n446#4,10:416\n127#4:426\n456#4:427\n122#4:428\n457#4,4:429\n127#4:433\n461#4:434\n122#4:435\n462#4,14:436\n122#4:450\n477#4,2:451\n122#4:453\n481#4:454\n122#4:455\n484#4:456\n234#4,3:457\n500#4,3:460\n122#4:463\n503#4:464\n127#4:465\n506#4,2:466\n127#4:468\n510#4,10:469\n127#4:479\n520#4:480\n122#4:481\n521#4,4:482\n127#4:486\n525#4:487\n122#4:488\n526#4,4:489\n127#4:493\n530#4:494\n122#4:495\n531#4,15:496\n122#4:511\n547#4,2:512\n122#4:514\n550#4,2:515\n122#4:517\n554#4:518\n122#4:519\n557#4:520\n241#4:521\n122#4:522\n242#4,5:523\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n*L\n308#1:348,2\n308#1:351,9\n65#1:343\n66#1:344\n256#1:346\n257#1:347\n327#1:375\n327#1:387\n308#1:350\n327#1:360,7\n332#1:367\n327#1:368,5\n332#1:373\n327#1:374\n327#1:376\n327#1:377,2\n332#1:379\n327#1:380,6\n327#1:386\n327#1:388\n332#1:389\n327#1:390,13\n332#1:403\n327#1:404\n332#1:405\n327#1:406\n327#1:407,3\n327#1:410,3\n332#1:413\n327#1:414\n327#1:415\n327#1:416,10\n327#1:426\n327#1:427\n332#1:428\n327#1:429,4\n327#1:433\n327#1:434\n332#1:435\n327#1:436,14\n332#1:450\n327#1:451,2\n332#1:453\n327#1:454\n332#1:455\n327#1:456\n327#1:457,3\n327#1:460,3\n332#1:463\n327#1:464\n327#1:465\n327#1:466,2\n327#1:468\n327#1:469,10\n327#1:479\n327#1:480\n332#1:481\n327#1:482,4\n327#1:486\n327#1:487\n332#1:488\n327#1:489,4\n327#1:493\n327#1:494\n332#1:495\n327#1:496,15\n332#1:511\n327#1:512,2\n332#1:514\n327#1:515,2\n332#1:517\n327#1:518\n332#1:519\n327#1:520\n327#1:521\n332#1:522\n327#1:523,5\n*E\n"})
/* renamed from: okio.internal.-ByteString, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ByteString {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final boolean commonEndsWith(@NotNull okio.ByteString byteString, @NotNull okio.ByteString suffix) {
        g0.p(byteString, "<this>");
        g0.p(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final int commonLastIndexOf(@NotNull okio.ByteString byteString, @NotNull okio.ByteString other, int i6) {
        g0.p(byteString, "<this>");
        g0.p(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i6);
    }

    public static final boolean commonRangeEquals(@NotNull okio.ByteString byteString, int i6, @NotNull okio.ByteString other, int i7, int i8) {
        g0.p(byteString, "<this>");
        g0.p(other, "other");
        return other.rangeEquals(i7, byteString.getData$okio(), i6, i8);
    }

    public static final boolean commonStartsWith(@NotNull okio.ByteString byteString, @NotNull okio.ByteString prefix) {
        g0.p(byteString, "<this>");
        g0.p(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0065, code lost:
    
        r6 = kotlin.n1.f44123a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x01af, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteString.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull okio.ByteString byteString, @NotNull okio.ByteString other) {
        g0.p(byteString, "<this>");
        g0.p(other, "other");
        int size = byteString.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i6 = 0; i6 < min; i6++) {
            int i7 = byteString.getByte(i6) & 255;
            int i8 = other.getByte(i6) & 255;
            if (i7 != i8) {
                return i7 < i8 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final void commonCopyInto(@NotNull okio.ByteString byteString, int i6, @NotNull byte[] target, int i7, int i8) {
        g0.p(byteString, "<this>");
        g0.p(target, "target");
        n.v0(byteString.getData$okio(), target, i7, i6, i8 + i6);
    }

    @Nullable
    public static final okio.ByteString commonDecodeBase64(@NotNull String str) {
        g0.p(str, "<this>");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new okio.ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final okio.ByteString commonEncodeUtf8(@NotNull String str) {
        g0.p(str, "<this>");
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull okio.ByteString byteString, @NotNull byte[] suffix) {
        g0.p(byteString, "<this>");
        g0.p(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final boolean commonEquals(@NotNull okio.ByteString byteString, @Nullable Object obj) {
        g0.p(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString2 = (okio.ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull okio.ByteString byteString, int i6) {
        g0.p(byteString, "<this>");
        return byteString.getData$okio()[i6];
    }

    public static final int commonGetSize(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i6 = 0;
        for (byte b6 : byteString.getData$okio()) {
            int i7 = i6 + 1;
            cArr[i6] = getHEX_DIGIT_CHARS()[(b6 >> 4) & 15];
            i6 += 2;
            cArr[i7] = getHEX_DIGIT_CHARS()[b6 & 15];
        }
        return u.J1(cArr);
    }

    public static final int commonIndexOf(@NotNull okio.ByteString byteString, @NotNull byte[] other, int i6) {
        g0.p(byteString, "<this>");
        g0.p(other, "other");
        int length = byteString.getData$okio().length - other.length;
        int max = Math.max(i6, 0);
        if (max > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), max, other, 0, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull okio.ByteString byteString, @NotNull byte[] other, int i6) {
        g0.p(byteString, "<this>");
        g0.p(other, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(byteString, i6), byteString.getData$okio().length - other.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    @NotNull
    public static final okio.ByteString commonOf(@NotNull byte[] data) {
        g0.p(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        g0.o(copyOf, "copyOf(...)");
        return new okio.ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull okio.ByteString byteString, int i6, @NotNull byte[] other, int i7, int i8) {
        g0.p(byteString, "<this>");
        g0.p(other, "other");
        return i6 >= 0 && i6 <= byteString.getData$okio().length - i8 && i7 >= 0 && i7 <= other.length - i8 && SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), i6, other, i7, i8);
    }

    public static final boolean commonStartsWith(@NotNull okio.ByteString byteString, @NotNull byte[] prefix) {
        g0.p(byteString, "<this>");
        g0.p(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }

    @NotNull
    public static final okio.ByteString commonSubstring(@NotNull okio.ByteString byteString, int i6, int i7) {
        g0.p(byteString, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i7);
        if (i6 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (resolveDefaultParameter <= byteString.getData$okio().length) {
            if (resolveDefaultParameter - i6 >= 0) {
                return (i6 == 0 && resolveDefaultParameter == byteString.getData$okio().length) ? byteString : new okio.ByteString(n.f1(byteString.getData$okio(), i6, resolveDefaultParameter));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
    }

    @NotNull
    public static final okio.ByteString commonToAsciiLowercase(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        for (int i6 = 0; i6 < byteString.getData$okio().length; i6++) {
            byte b6 = byteString.getData$okio()[i6];
            if (b6 >= 65 && b6 <= 90) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                g0.o(copyOf, "copyOf(...)");
                copyOf[i6] = (byte) (b6 + 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b7 = copyOf[i7];
                    if (b7 >= 65 && b7 <= 90) {
                        copyOf[i7] = (byte) (b7 + 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final okio.ByteString commonToAsciiUppercase(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        for (int i6 = 0; i6 < byteString.getData$okio().length; i6++) {
            byte b6 = byteString.getData$okio()[i6];
            if (b6 >= 97 && b6 <= 122) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                g0.o(copyOf, "copyOf(...)");
                copyOf[i6] = (byte) (b6 - 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b7 = copyOf[i7];
                    if (b7 >= 97 && b7 <= 122) {
                        copyOf[i7] = (byte) (b7 - 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @NotNull
    public static final okio.ByteString commonToByteString(@NotNull byte[] bArr, int i6, int i7) {
        g0.p(bArr, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i7);
        SegmentedByteString.checkOffsetAndCount(bArr.length, i6, resolveDefaultParameter);
        return new okio.ByteString(n.f1(bArr, i6, resolveDefaultParameter + i6));
    }

    @NotNull
    public static final String commonToString(@NotNull okio.ByteString byteString) {
        okio.ByteString byteString2 = byteString;
        g0.p(byteString2, "<this>");
        if (byteString2.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString2.getData$okio(), 64);
        if (codePointIndexToCharIndex != -1) {
            String utf8 = byteString2.utf8();
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            g0.o(substring, "substring(...)");
            String x22 = u.x2(u.x2(u.x2(substring, "\\", "\\\\", false, 4, null), com.snail.antifake.deviceid.e.f37542d, "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (codePointIndexToCharIndex >= utf8.length()) {
                return "[text=" + x22 + ']';
            }
            return "[size=" + byteString2.getData$okio().length + " text=" + x22 + "…]";
        }
        if (byteString2.getData$okio().length <= 64) {
            return "[hex=" + byteString2.hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(byteString2.getData$okio().length);
        sb.append(" hex=");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString2, 64);
        if (resolveDefaultParameter > byteString2.getData$okio().length) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString2.getData$okio().length + ')').toString());
        }
        if (resolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (resolveDefaultParameter != byteString2.getData$okio().length) {
            byteString2 = new okio.ByteString(n.f1(byteString2.getData$okio(), 0, resolveDefaultParameter));
        }
        sb.append(byteString2.hex());
        sb.append("…]");
        return sb.toString();
    }

    @NotNull
    public static final String commonUtf8(@NotNull okio.ByteString byteString) {
        g0.p(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull okio.ByteString byteString, @NotNull Buffer buffer, int i6, int i7) {
        g0.p(byteString, "<this>");
        g0.p(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i6, i7);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }
}
