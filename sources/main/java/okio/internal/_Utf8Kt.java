package okio.internal;

import java.util.Arrays;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n-Utf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n+ 2 Utf8.kt\nokio/Utf8\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,60:1\n260#2,16:61\n277#2:78\n397#2,9:79\n127#2:88\n406#2,20:90\n279#2,3:110\n440#2,4:113\n127#2:117\n446#2,10:118\n127#2:128\n456#2,5:129\n127#2:134\n461#2,24:135\n283#2,3:159\n500#2,3:162\n286#2,12:165\n503#2:177\n127#2:178\n506#2,2:179\n127#2:181\n510#2,10:182\n127#2:192\n520#2,5:193\n127#2:198\n525#2,5:199\n127#2:204\n530#2,28:205\n302#2,6:233\n138#2,67:239\n67#3:77\n73#3:89\n*S KotlinDebug\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n*L\n34#1:61,16\n34#1:78\n34#1:79,9\n34#1:88\n34#1:90,20\n34#1:110,3\n34#1:113,4\n34#1:117\n34#1:118,10\n34#1:128\n34#1:129,5\n34#1:134\n34#1:135,24\n34#1:159,3\n34#1:162,3\n34#1:165,12\n34#1:177\n34#1:178\n34#1:179,2\n34#1:181\n34#1:182,10\n34#1:192\n34#1:193,5\n34#1:198\n34#1:199,5\n34#1:204\n34#1:205,28\n34#1:233,6\n50#1:239,67\n34#1:77\n34#1:89\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        int i6;
        char charAt;
        g0.p(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            char charAt2 = str.charAt(i7);
            if (g0.t(charAt2, 128) >= 0) {
                int length2 = str.length();
                int i8 = i7;
                while (i7 < length2) {
                    char charAt3 = str.charAt(i7);
                    if (g0.t(charAt3, 128) < 0) {
                        int i9 = i8 + 1;
                        bArr[i8] = (byte) charAt3;
                        i7++;
                        while (true) {
                            i8 = i9;
                            if (i7 < length2 && g0.t(str.charAt(i7), 128) < 0) {
                                i9 = i8 + 1;
                                bArr[i8] = (byte) str.charAt(i7);
                                i7++;
                            }
                        }
                    } else {
                        if (g0.t(charAt3, 2048) < 0) {
                            bArr[i8] = (byte) ((charAt3 >> 6) | 192);
                            i8 += 2;
                            bArr[i8 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || charAt3 >= 57344) {
                            bArr[i8] = (byte) ((charAt3 >> '\f') | 224);
                            bArr[i8 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i8 += 3;
                            bArr[i8 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (g0.t(charAt3, 56319) > 0 || length2 <= (i6 = i7 + 1) || 56320 > (charAt = str.charAt(i6)) || charAt >= 57344) {
                            bArr[i8] = Utf8.REPLACEMENT_BYTE;
                            i7++;
                            i8++;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i6)) - 56613888;
                            bArr[i8] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i8 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i8 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i8 += 4;
                            bArr[i8 + 3] = (byte) ((charAt4 & 63) | 128);
                            i7 += 2;
                        }
                        i7++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i8);
                g0.o(copyOf, "copyOf(...)");
                return copyOf;
            }
            bArr[i7] = (byte) charAt2;
            i7++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        g0.o(copyOf2, "copyOf(...)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0106, code lost:
    
        if ((r16[r5] & 192) == 128) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0095, code lost:
    
        if ((r16[r5] & 192) == 128) goto L42;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = bArr.length;
        }
        return commonToUtf8String(bArr, i6, i7);
    }
}
