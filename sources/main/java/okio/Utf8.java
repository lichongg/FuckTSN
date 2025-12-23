package okio;

import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "Utf8")
@SourceDebugExtension({"SMAP\nUtf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utf8.kt\nokio/Utf8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,559:1\n397#1,9:563\n127#1:572\n406#1,20:574\n440#1,4:595\n127#1:599\n446#1,10:601\n127#1:611\n456#1,5:612\n127#1:617\n461#1,24:618\n500#1,4:643\n127#1:647\n506#1,2:649\n127#1:651\n510#1,10:652\n127#1:662\n520#1,5:663\n127#1:668\n525#1,5:669\n127#1:674\n530#1,28:675\n397#1,9:704\n127#1:713\n406#1,20:715\n440#1,4:736\n127#1:740\n446#1,10:742\n127#1:752\n456#1,5:753\n127#1:758\n461#1,24:759\n500#1,4:784\n127#1:788\n506#1,2:790\n127#1:792\n510#1,10:793\n127#1:803\n520#1,5:804\n127#1:809\n525#1,5:810\n127#1:815\n530#1,28:816\n127#1:844\n127#1:846\n127#1:848\n127#1:850\n127#1:852\n127#1:854\n127#1:856\n127#1:858\n127#1:860\n1#2:560\n73#3:561\n67#3:562\n73#3:573\n67#3:594\n73#3:600\n67#3:642\n73#3:648\n67#3:703\n73#3:714\n67#3:735\n73#3:741\n67#3:783\n73#3:789\n73#3:845\n73#3:847\n73#3:849\n73#3:851\n73#3:853\n73#3:855\n73#3:857\n73#3:859\n73#3:861\n*S KotlinDebug\n*F\n+ 1 Utf8.kt\nokio/Utf8\n*L\n228#1:563,9\n228#1:572\n228#1:574,20\n232#1:595,4\n232#1:599\n232#1:601,10\n232#1:611\n232#1:612,5\n232#1:617\n232#1:618,24\n236#1:643,4\n236#1:647\n236#1:649,2\n236#1:651\n236#1:652,10\n236#1:662\n236#1:663,5\n236#1:668\n236#1:669,5\n236#1:674\n236#1:675,28\n277#1:704,9\n277#1:713\n277#1:715,20\n281#1:736,4\n281#1:740\n281#1:742,10\n281#1:752\n281#1:753,5\n281#1:758\n281#1:759,24\n285#1:784,4\n285#1:788\n285#1:790,2\n285#1:792\n285#1:793,10\n285#1:803\n285#1:804,5\n285#1:809\n285#1:810,5\n285#1:815\n285#1:816,28\n405#1:844\n443#1:846\n455#1:848\n460#1:850\n503#1:852\n507#1:854\n519#1:856\n524#1:858\n529#1:860\n127#1:561\n226#1:562\n228#1:573\n230#1:594\n232#1:600\n234#1:642\n236#1:648\n275#1:703\n277#1:714\n279#1:735\n281#1:741\n283#1:783\n285#1:789\n405#1:845\n443#1:847\n455#1:849\n460#1:851\n503#1:853\n507#1:855\n519#1:857\n524#1:859\n529#1:861\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f1, code lost:
    
        if ((r12[r2] & 192) == 128) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0088, code lost:
    
        if ((r12[r2] & 192) == 128) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf16Chars(@org.jetbrains.annotations.NotNull byte[] r12, int r13, int r14, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.n1> r15) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dc, code lost:
    
        if ((r11[r1] & 192) == 128) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007d, code lost:
    
        if ((r11[r1] & 192) == 128) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf8CodePoints(@org.jetbrains.annotations.NotNull byte[] r11, int r12, int r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.n1> r14) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        g0.p(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static final boolean isIsoControl(int i6) {
        if (i6 < 0 || i6 >= 32) {
            return 127 <= i6 && i6 < 160;
        }
        return true;
    }

    public static final boolean isUtf8Continuation(byte b6) {
        return (b6 & 192) == 128;
    }

    public static final void processUtf8Bytes(@NotNull String str, int i6, int i7, @NotNull Function1<? super Byte, n1> yield) {
        int i8;
        char charAt;
        g0.p(str, "<this>");
        g0.p(yield, "yield");
        while (i6 < i7) {
            char charAt2 = str.charAt(i6);
            if (g0.t(charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i6++;
                while (i6 < i7 && g0.t(str.charAt(i6), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) str.charAt(i6)));
                    i6++;
                }
            } else {
                if (g0.t(charAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 > charAt2 || charAt2 >= 57344) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (g0.t(charAt2, 56319) > 0 || i7 <= (i8 = i6 + 1) || 56320 > (charAt = str.charAt(i8)) || charAt >= 57344) {
                    yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int charAt3 = ((charAt2 << '\n') + str.charAt(i8)) - 56613888;
                    yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                    yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i6 += 2;
                }
                i6++;
            }
        }
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i6) {
        g0.p(str, "<this>");
        return size$default(str, i6, 0, 2, null);
    }

    public static /* synthetic */ long size$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return size(str, i6, i7);
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i6, int i7, @NotNull Function1<? super Integer, n1> yield) {
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        g0.p(bArr, "<this>");
        g0.p(yield, "yield");
        int i8 = i6 + 1;
        if (i7 <= i8) {
            yield.invoke(valueOf);
            return 1;
        }
        byte b6 = bArr[i6];
        byte b7 = bArr[i8];
        if ((b7 & 192) == 128) {
            int i9 = (b7 ^ 3968) ^ (b6 << 6);
            if (i9 < 128) {
                yield.invoke(valueOf);
                return 2;
            }
            yield.invoke(Integer.valueOf(i9));
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i6, int i7, @NotNull Function1<? super Integer, n1> yield) {
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        g0.p(bArr, "<this>");
        g0.p(yield, "yield");
        int i8 = i6 + 2;
        if (i7 <= i8) {
            yield.invoke(valueOf);
            int i9 = i6 + 1;
            if (i7 <= i9 || (bArr[i9] & 192) != 128) {
                return 1;
            }
            return 2;
        }
        byte b6 = bArr[i6];
        byte b7 = bArr[i6 + 1];
        if ((b7 & 192) == 128) {
            byte b8 = bArr[i8];
            if ((b8 & 192) == 128) {
                int i10 = ((b8 ^ (-123008)) ^ (b7 << 6)) ^ (b6 << 12);
                if (i10 < 2048) {
                    yield.invoke(valueOf);
                    return 3;
                }
                if (55296 <= i10 && i10 < 57344) {
                    yield.invoke(valueOf);
                    return 3;
                }
                yield.invoke(Integer.valueOf(i10));
                return 3;
            }
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i6, int i7, @NotNull Function1<? super Integer, n1> yield) {
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        g0.p(bArr, "<this>");
        g0.p(yield, "yield");
        int i8 = i6 + 3;
        if (i7 <= i8) {
            yield.invoke(valueOf);
            int i9 = i6 + 1;
            if (i7 <= i9 || (bArr[i9] & 192) != 128) {
                return 1;
            }
            int i10 = i6 + 2;
            if (i7 <= i10 || (bArr[i10] & 192) != 128) {
                return 2;
            }
            return 3;
        }
        byte b6 = bArr[i6];
        byte b7 = bArr[i6 + 1];
        if ((b7 & 192) == 128) {
            byte b8 = bArr[i6 + 2];
            if ((b8 & 192) == 128) {
                byte b9 = bArr[i8];
                if ((b9 & 192) == 128) {
                    int i11 = (((b9 ^ 3678080) ^ (b8 << 6)) ^ (b7 << 12)) ^ (b6 << 18);
                    if (i11 > 1114111) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    if (55296 <= i11 && i11 < 57344) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    if (i11 < 65536) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    yield.invoke(Integer.valueOf(i11));
                    return 4;
                }
                yield.invoke(valueOf);
                return 3;
            }
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i6, int i7) {
        int i8;
        g0.p(str, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (i7 >= i6) {
            if (i7 > str.length()) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + str.length()).toString());
            }
            long j6 = 0;
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (charAt < 128) {
                    j6++;
                } else {
                    if (charAt < 2048) {
                        i8 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i8 = 3;
                    } else {
                        int i9 = i6 + 1;
                        char charAt2 = i9 < i7 ? str.charAt(i9) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j6++;
                            i6 = i9;
                        } else {
                            j6 += 4;
                            i6 += 2;
                        }
                    }
                    j6 += i8;
                }
                i6++;
            }
            return j6;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
    }
}
