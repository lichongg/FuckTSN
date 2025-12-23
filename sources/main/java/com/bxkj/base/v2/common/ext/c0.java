package com.bxkj.base.v2.common.ext;

import java.text.SimpleDateFormat;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c0 {
    private static final void a(StringBuilder sb, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append('\t');
        }
    }

    @NotNull
    public static final String b(@Nullable String str) {
        if (str == null || g0.g("", str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i6 = 0;
        char c6 = 0;
        int i7 = 0;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    sb.append('\n');
                    i7--;
                    a(sb, i7);
                    sb.append(charAt);
                }
                sb.append(charAt);
                sb.append('\n');
                i7++;
                a(sb, i7);
            } else {
                sb.append(charAt);
                if (c6 != '\\') {
                    sb.append('\n');
                    a(sb, i7);
                }
            }
            i6++;
            c6 = charAt;
        }
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    public static final long c(@NotNull String str, @Nullable String str2) {
        g0.p(str, "<this>");
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static /* synthetic */ long d(String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        return c(str, str2);
    }
}
