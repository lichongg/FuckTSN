package okhttp3.internal.idn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.ranges.k;
import kotlin.ranges.t;
import kotlin.text.b;
import kotlin.text.u;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPunycode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Punycode.kt\nokhttp3/internal/idn/Punycode\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,329:1\n2393#2,14:330\n*S KotlinDebug\n*F\n+ 1 Punycode.kt\nokhttp3/internal/idn/Punycode\n*L\n108#1:330,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Punycode {
    private static final int BASE = 36;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final int SKEW = 38;
    private static final int TMAX = 26;
    private static final int TMIN = 1;

    @NotNull
    public static final Punycode INSTANCE = new Punycode();

    @NotNull
    private static final String PREFIX_STRING = "xn--";

    @NotNull
    private static final ByteString PREFIX = ByteString.Companion.encodeUtf8("xn--");

    private final boolean decodeLabel(String str, int i6, int i7, Buffer buffer) {
        int i8;
        int i9;
        if (!u.q2(str, i6, PREFIX_STRING, 0, 4, true)) {
            buffer.writeUtf8(str, i6, i7);
            return true;
        }
        int i10 = i6 + 4;
        ArrayList arrayList = new ArrayList();
        int V3 = u.V3(str, '-', i7, false, 4, null);
        char c6 = '0';
        char c7 = '[';
        char c8 = '{';
        if (V3 >= i10) {
            while (i10 < V3) {
                int i11 = i10 + 1;
                char charAt = str.charAt(i10);
                if (('a' > charAt || charAt >= '{') && (('A' > charAt || charAt >= '[') && (('0' > charAt || charAt >= ':') && charAt != '-'))) {
                    return false;
                }
                arrayList.add(Integer.valueOf(charAt));
                i10 = i11;
            }
            i10++;
        }
        int i12 = 128;
        int i13 = 72;
        int i14 = 0;
        while (i10 < i7) {
            k B1 = t.B1(t.W1(36, Integer.MAX_VALUE), 36);
            int e6 = B1.e();
            int f6 = B1.f();
            int g6 = B1.g();
            if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
                i8 = i14;
                int i15 = 1;
                while (i10 != i7) {
                    int i16 = i10 + 1;
                    char charAt2 = str.charAt(i10);
                    if ('a' <= charAt2 && charAt2 < c8) {
                        i9 = charAt2 - 'a';
                    } else if ('A' <= charAt2 && charAt2 < c7) {
                        i9 = charAt2 - 'A';
                    } else {
                        if (c6 > charAt2 || charAt2 >= ':') {
                            return false;
                        }
                        i9 = charAt2 - 22;
                    }
                    int i17 = i15;
                    int i18 = i9 * i17;
                    int i19 = i8;
                    if (i19 > Integer.MAX_VALUE - i18) {
                        return false;
                    }
                    i8 = i19 + i18;
                    int i20 = e6 <= i13 ? 1 : e6 >= i13 + 26 ? 26 : e6 - i13;
                    if (i9 >= i20) {
                        int i21 = 36 - i20;
                        if (i17 > Integer.MAX_VALUE / i21) {
                            return false;
                        }
                        i15 = i17 * i21;
                        if (e6 != f6) {
                            e6 += g6;
                            i10 = i16;
                            c6 = '0';
                            c7 = '[';
                            c8 = '{';
                        }
                    }
                    i10 = i16;
                }
                return false;
            }
            i8 = i14;
            i13 = adapt(i8 - i14, arrayList.size() + 1, i14 == 0);
            int size = i8 / (arrayList.size() + 1);
            if (i12 > Integer.MAX_VALUE - size) {
                return false;
            }
            i12 += size;
            int size2 = i8 % (arrayList.size() + 1);
            if (i12 > 1114111) {
                return false;
            }
            arrayList.add(size2, Integer.valueOf(i12));
            i14 = size2 + 1;
            c6 = '0';
            c7 = '[';
            c8 = '{';
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            buffer.writeUtf8CodePoint(((Number) it.next()).intValue());
        }
        return true;
    }

    private final int adapt(int i6, int i7, boolean z5) {
        int i8 = z5 ? i6 / 700 : i6 / 2;
        int i9 = i8 + (i8 / i7);
        int i10 = 0;
        while (i9 > 455) {
            i9 /= 35;
            i10 += 36;
        }
        return i10 + ((i9 * 36) / (i9 + 38));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [char] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    private final List<Integer> codePoints(String str, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        while (i6 < i7) {
            int charAt = str.charAt(i6);
            if (b.L(charAt)) {
                int i8 = i6 + 1;
                char charAt2 = i8 < i7 ? str.charAt(i8) : (char) 0;
                if (Character.isLowSurrogate(charAt) || !Character.isLowSurrogate(charAt2)) {
                    charAt = 63;
                } else {
                    charAt = 65536 + (((charAt & 1023) << 10) | (charAt2 & 1023));
                    i6 = i8;
                }
            }
            arrayList.add(Integer.valueOf(charAt));
            i6++;
        }
        return arrayList;
    }

    private final boolean encodeLabel(String str, int i6, int i7, Buffer buffer) {
        int i8;
        int i9;
        int i10 = 1;
        if (!requiresEncode(str, i6, i7)) {
            buffer.writeUtf8(str, i6, i7);
            return true;
        }
        buffer.write(PREFIX);
        List<Integer> codePoints = codePoints(str, i6, i7);
        Iterator<Integer> it = codePoints.iterator();
        int i11 = 0;
        while (true) {
            i8 = 128;
            if (!it.hasNext()) {
                break;
            }
            int intValue = it.next().intValue();
            if (intValue < 128) {
                buffer.writeByte(intValue);
                i11++;
            }
        }
        if (i11 > 0) {
            buffer.writeByte(45);
        }
        int i12 = 72;
        int i13 = i11;
        int i14 = 0;
        while (i13 < codePoints.size()) {
            Iterator<T> it2 = codePoints.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int intValue2 = ((Number) next).intValue();
                if (intValue2 < i8) {
                    intValue2 = Integer.MAX_VALUE;
                }
                do {
                    Object next2 = it2.next();
                    int intValue3 = ((Number) next2).intValue();
                    if (intValue3 < i8) {
                        intValue3 = Integer.MAX_VALUE;
                    }
                    if (intValue2 > intValue3) {
                        next = next2;
                        intValue2 = intValue3;
                    }
                } while (it2.hasNext());
            }
            int intValue4 = ((Number) next).intValue();
            int i15 = (intValue4 - i8) * (i13 + 1);
            if (i14 > Integer.MAX_VALUE - i15) {
                return false;
            }
            int i16 = i14 + i15;
            Iterator<Integer> it3 = codePoints.iterator();
            while (it3.hasNext()) {
                int intValue5 = it3.next().intValue();
                if (intValue5 < intValue4) {
                    if (i16 == Integer.MAX_VALUE) {
                        return false;
                    }
                    i16++;
                } else if (intValue5 == intValue4) {
                    k B1 = t.B1(t.W1(36, Integer.MAX_VALUE), 36);
                    int e6 = B1.e();
                    int f6 = B1.f();
                    int g6 = B1.g();
                    if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
                        i9 = i16;
                        while (true) {
                            if (e6 > i12) {
                                i10 = e6 >= i12 + 26 ? 26 : e6 - i12;
                            }
                            if (i9 < i10) {
                                break;
                            }
                            int i17 = i9 - i10;
                            int i18 = 36 - i10;
                            buffer.writeByte(getPunycodeDigit(i10 + (i17 % i18)));
                            i9 = i17 / i18;
                            if (e6 == f6) {
                                break;
                            }
                            e6 += g6;
                            i10 = 1;
                        }
                    } else {
                        i9 = i16;
                    }
                    buffer.writeByte(getPunycodeDigit(i9));
                    int i19 = i13 + 1;
                    i12 = adapt(i16, i19, i13 == i11);
                    i13 = i19;
                    i10 = 1;
                    i16 = 0;
                }
            }
            i14 = i16 + 1;
            i8 = intValue4 + 1;
            i10 = 1;
        }
        return true;
    }

    private final int getPunycodeDigit(int i6) {
        if (i6 < 26) {
            return i6 + 97;
        }
        if (i6 < 36) {
            return i6 + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i6).toString());
    }

    private final boolean requiresEncode(String str, int i6, int i7) {
        while (i6 < i7) {
            if (str.charAt(i6) >= 128) {
                return true;
            }
            i6++;
        }
        return false;
    }

    @Nullable
    public final String decode(@NotNull String string) {
        g0.p(string, "string");
        int length = string.length();
        Buffer buffer = new Buffer();
        int i6 = 0;
        while (i6 < length) {
            String str = string;
            int G3 = u.G3(str, '.', i6, false, 4, null);
            if (G3 == -1) {
                G3 = length;
            }
            if (!decodeLabel(str, i6, G3, buffer)) {
                return null;
            }
            if (G3 >= length) {
                break;
            }
            buffer.writeByte(46);
            i6 = G3 + 1;
            string = str;
        }
        return buffer.readUtf8();
    }

    @Nullable
    public final String encode(@NotNull String string) {
        g0.p(string, "string");
        int length = string.length();
        Buffer buffer = new Buffer();
        int i6 = 0;
        while (i6 < length) {
            String str = string;
            int G3 = u.G3(str, '.', i6, false, 4, null);
            if (G3 == -1) {
                G3 = length;
            }
            if (!encodeLabel(str, i6, G3, buffer)) {
                return null;
            }
            if (G3 >= length) {
                break;
            }
            buffer.writeByte(46);
            i6 = G3 + 1;
            string = str;
        }
        return buffer.readUtf8();
    }

    @NotNull
    public final ByteString getPREFIX() {
        return PREFIX;
    }

    @NotNull
    public final String getPREFIX_STRING() {
        return PREFIX_STRING;
    }

    private Punycode() {
    }
}
