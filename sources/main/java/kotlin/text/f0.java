package kotlin.text;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f0 extends e0 {
    @NotNull
    public static final Void k1(@NotNull String input) {
        kotlin.jvm.internal.g0.p(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte l1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return m1(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte m1(@NotNull String str, int i6) {
        int intValue;
        kotlin.jvm.internal.g0.p(str, "<this>");
        Integer o12 = o1(str, i6);
        if (o12 == null || (intValue = o12.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer n1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return o1(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer o1(@NotNull String str, int i6) {
        boolean z5;
        int i7;
        int i8;
        kotlin.jvm.internal.g0.p(str, "<this>");
        c.a(i6);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char charAt = str.charAt(0);
        int i10 = -2147483647;
        if (kotlin.jvm.internal.g0.t(charAt, 48) < 0) {
            i7 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z5 = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i10 = Integer.MIN_VALUE;
                z5 = true;
            }
        } else {
            z5 = false;
            i7 = 0;
        }
        int i11 = -59652323;
        while (i7 < length) {
            int b6 = c.b(str.charAt(i7), i6);
            if (b6 < 0) {
                return null;
            }
            if ((i9 < i11 && (i11 != -59652323 || i9 < (i11 = i10 / i6))) || (i8 = i9 * i6) < i10 + b6) {
                return null;
            }
            i9 = i8 - b6;
            i7++;
        }
        return z5 ? Integer.valueOf(i9) : Integer.valueOf(-i9);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long p1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return q1(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long q1(@org.jetbrains.annotations.NotNull java.lang.String r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.g0.p(r0, r2)
            kotlin.text.c.a(r1)
            int r2 = r0.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.g0.t(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L38
            r6 = 1
            if (r2 != r6) goto L2a
            return r3
        L2a:
            r9 = 43
            if (r5 == r9) goto L37
            r4 = 45
            if (r5 == r4) goto L33
            return r3
        L33:
            r7 = -9223372036854775808
            r4 = 1
            goto L39
        L37:
            r4 = 1
        L38:
            r6 = 0
        L39:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L41:
            if (r4 >= r2) goto L73
            char r5 = r0.charAt(r4)
            int r5 = kotlin.text.c.b(r5, r1)
            if (r5 >= 0) goto L4e
            return r3
        L4e:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L5e
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L62
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L5e
            return r3
        L5e:
            r15 = r3
            r16 = r4
            goto L63
        L62:
            return r3
        L63:
            long r3 = (long) r1
            long r11 = r11 * r3
            long r3 = (long) r5
            long r17 = r7 + r3
            int r5 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r5 >= 0) goto L6e
            return r15
        L6e:
            long r11 = r11 - r3
            int r4 = r16 + 1
            r3 = r15
            goto L41
        L73:
            if (r6 == 0) goto L7a
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            return r0
        L7a:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.f0.q1(java.lang.String, int):java.lang.Long");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short r1(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        return s1(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short s1(@NotNull String str, int i6) {
        int intValue;
        kotlin.jvm.internal.g0.p(str, "<this>");
        Integer o12 = o1(str, i6);
        if (o12 == null || (intValue = o12.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
