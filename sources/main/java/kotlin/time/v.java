package kotlin.time;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.bugly.BuglyStrategy;
import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/UnboundLocalDateTime\n*L\n1#1,864:1\n1#2:865\n479#3,28:866\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n*L\n689#1:866,28\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private static final long f48033a = -3217862419201L;

    /* renamed from: b, reason: collision with root package name */
    private static final long f48034b = 3093527980800L;

    /* renamed from: c, reason: collision with root package name */
    private static final long f48035c = -31557014167219200L;

    /* renamed from: d, reason: collision with root package name */
    private static final long f48036d = 31556889864403199L;

    /* renamed from: e, reason: collision with root package name */
    private static final int f48037e = 146097;

    /* renamed from: f, reason: collision with root package name */
    private static final int f48038f = 719528;

    /* renamed from: g, reason: collision with root package name */
    private static final int f48039g = 3600;

    /* renamed from: h, reason: collision with root package name */
    private static final int f48040h = 60;

    /* renamed from: i, reason: collision with root package name */
    private static final int f48041i = 24;

    /* renamed from: j, reason: collision with root package name */
    private static final int f48042j = 86400;

    /* renamed from: k, reason: collision with root package name */
    public static final int f48043k = 1000000000;

    /* renamed from: l, reason: collision with root package name */
    private static final int f48044l = 1000000;

    /* renamed from: m, reason: collision with root package name */
    private static final int f48045m = 1000;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final int[] f48046n = {1, 10, 100, 1000, 10000, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final int[] f48047o = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final int[] f48048p = {3, 6};

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final int[] f48049q = {1, 2, 4, 5, 7, 8};

    private static final int q(int i6, boolean z5) {
        return i6 != 2 ? (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) ? 30 : 31 : z5 ? 29 : 28;
    }

    private static final long B(long j6, long j7, Function0 function0) {
        long j8 = j6 + j7;
        if ((j6 ^ j8) >= 0 || (j6 ^ j7) < 0) {
            return j8;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    private static final long C(long j6, long j7, Function0 function0) {
        if (j7 == 1) {
            return j6;
        }
        if (j6 == 1) {
            return j7;
        }
        if (j6 == 0 || j7 == 0) {
            return 0L;
        }
        long j8 = j6 * j7;
        if (j8 / j7 == j6 && ((j6 != Long.MIN_VALUE || j7 != -1) && (j7 != Long.MIN_VALUE || j6 != -1))) {
            return j8;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalTime
    public static final String j(Instant instant) {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        g0 a6 = g0.f48011h.a(instant);
        int g6 = a6.g();
        int i6 = 0;
        if (Math.abs(g6) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (g6 >= 0) {
                sb2.append(g6 + 10000);
                kotlin.jvm.internal.g0.o(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(g6 - 10000);
                kotlin.jvm.internal.g0.o(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (g6 >= 10000) {
                sb.append('+');
            }
            sb.append(g6);
        }
        sb.append('-');
        k(sb, sb, a6.d());
        sb.append('-');
        k(sb, sb, a6.a());
        sb.append('T');
        k(sb, sb, a6.b());
        sb.append(':');
        k(sb, sb, a6.c());
        sb.append(':');
        k(sb, sb, a6.f());
        if (a6.e() != 0) {
            sb.append('.');
            while (true) {
                int e6 = a6.e();
                iArr = f48046n;
                int i7 = i6 + 1;
                if (e6 % iArr[i7] != 0) {
                    break;
                }
                i6 = i7;
            }
            int i8 = i6 - (i6 % 3);
            String valueOf = String.valueOf((a6.e() / iArr[i8]) + iArr[9 - i8]);
            kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
            String substring = valueOf.substring(1);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            sb.append(substring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void k(Appendable appendable, StringBuilder sb, int i6) {
        if (i6 < 10) {
            appendable.append('0');
        }
        sb.append(i6);
    }

    private static final boolean l(Instant instant) {
        kotlin.jvm.internal.g0.p(instant, "<this>");
        return instant.compareTo(Instant.Companion.e()) >= 0;
    }

    private static final boolean n(Instant instant) {
        kotlin.jvm.internal.g0.p(instant, "<this>");
        return instant.compareTo(Instant.Companion.f()) <= 0;
    }

    public static final boolean p(int i6) {
        if ((i6 & 3) == 0) {
            return i6 % 100 != 0 || i6 % 400 == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalTime
    public static final w r(CharSequence charSequence) {
        int i6;
        int i7;
        int i8;
        int i9;
        char charAt;
        char charAt2;
        if (charSequence.length() == 0) {
            return new w.a("An empty string is not a valid Instant", charSequence);
        }
        char charAt3 = charSequence.charAt(0);
        if (charAt3 == '+' || charAt3 == '-') {
            i6 = 1;
        } else {
            charAt3 = ' ';
            i6 = 0;
        }
        int i10 = i6;
        int i11 = 0;
        while (i10 < charSequence.length() && '0' <= (charAt2 = charSequence.charAt(i10)) && charAt2 < ':') {
            i11 = (i11 * 10) + (charSequence.charAt(i10) - '0');
            i10++;
        }
        int i12 = i10 - i6;
        if (i12 > 10) {
            return z(charSequence, "Expected at most 10 digits for the year number, got " + i12 + " digits");
        }
        if (i12 == 10 && kotlin.jvm.internal.g0.t(charSequence.charAt(i6), 50) >= 0) {
            return z(charSequence, "Expected at most 9 digits for the year number or year 1000000000, got " + i12 + " digits");
        }
        if (i12 < 4) {
            return z(charSequence, "The year number must be padded to 4 digits, got " + i12 + " digits");
        }
        if (charAt3 == '+' && i12 == 4) {
            return z(charSequence, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
        }
        if (charAt3 == ' ' && i12 != 4) {
            return z(charSequence, "A '+' or '-' sign is required for year numbers longer than 4 digits");
        }
        if (charAt3 == '-') {
            i11 = -i11;
        }
        int i13 = i11;
        int i14 = i10 + 16;
        if (charSequence.length() < i14) {
            return z(charSequence, "The input string is too short");
        }
        w.a s5 = s(charSequence, "'-'", i10, new Function1() { // from class: kotlin.time.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean t5;
                t5 = v.t(((Character) obj).charValue());
                return Boolean.valueOf(t5);
            }
        });
        if (s5 != null) {
            return s5;
        }
        w.a s6 = s(charSequence, "'-'", i10 + 3, new Function1() { // from class: kotlin.time.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean v5;
                v5 = v.v(((Character) obj).charValue());
                return Boolean.valueOf(v5);
            }
        });
        if (s6 != null) {
            return s6;
        }
        w.a s7 = s(charSequence, "'T' or 't'", i10 + 6, new Function1() { // from class: kotlin.time.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean w5;
                w5 = v.w(((Character) obj).charValue());
                return Boolean.valueOf(w5);
            }
        });
        if (s7 != null) {
            return s7;
        }
        w.a s8 = s(charSequence, "':'", i10 + 9, new Function1() { // from class: kotlin.time.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean x5;
                x5 = v.x(((Character) obj).charValue());
                return Boolean.valueOf(x5);
            }
        });
        if (s8 != null) {
            return s8;
        }
        w.a s9 = s(charSequence, "':'", i10 + 12, new Function1() { // from class: kotlin.time.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean y5;
                y5 = v.y(((Character) obj).charValue());
                return Boolean.valueOf(y5);
            }
        });
        if (s9 != null) {
            return s9;
        }
        for (int i15 : f48047o) {
            w.a s10 = s(charSequence, "an ASCII digit", i15 + i10, new Function1() { // from class: kotlin.time.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean u5;
                    u5 = v.u(((Character) obj).charValue());
                    return Boolean.valueOf(u5);
                }
            });
            if (s10 != null) {
                return s10;
            }
        }
        int A = A(charSequence, i10 + 1);
        int A2 = A(charSequence, i10 + 4);
        int A3 = A(charSequence, i10 + 7);
        int A4 = A(charSequence, i10 + 10);
        int A5 = A(charSequence, i10 + 13);
        int i16 = i10 + 15;
        if (charSequence.charAt(i16) == '.') {
            i16 = i14;
            int i17 = 0;
            while (i16 < charSequence.length() && '0' <= (charAt = charSequence.charAt(i16)) && charAt < ':') {
                i17 = (i17 * 10) + (charSequence.charAt(i16) - '0');
                i16++;
            }
            int i18 = i16 - i14;
            if (1 > i18 || i18 >= 10) {
                return z(charSequence, "1..9 digits are supported for the fraction of the second, got " + i18 + " digits");
            }
            i7 = i17 * f48046n[9 - i18];
        } else {
            i7 = 0;
        }
        if (i16 >= charSequence.length()) {
            return z(charSequence, "The UTC offset at the end of the string is missing");
        }
        char charAt4 = charSequence.charAt(i16);
        if (charAt4 == '+' || charAt4 == '-') {
            int length = charSequence.length() - i16;
            if (length > 9) {
                return z(charSequence, "The UTC offset string \"" + D(charSequence.subSequence(i16, charSequence.length()).toString(), 16) + "\" is too long");
            }
            if (length % 3 != 0) {
                return z(charSequence, "Invalid UTC offset string \"" + charSequence.subSequence(i16, charSequence.length()).toString() + '\"');
            }
            for (int i19 : f48048p) {
                int i20 = i16 + i19;
                if (i20 >= charSequence.length()) {
                    break;
                }
                if (charSequence.charAt(i20) != ':') {
                    return z(charSequence, "Expected ':' at index " + i20 + ", got '" + charSequence.charAt(i20) + '\'');
                }
            }
            int[] iArr = f48049q;
            int length2 = iArr.length;
            int i21 = 0;
            while (i21 < length2) {
                int i22 = iArr[i21] + i16;
                if (i22 >= charSequence.length()) {
                    break;
                }
                char charAt5 = charSequence.charAt(i22);
                int[] iArr2 = iArr;
                if ('0' > charAt5 || charAt5 >= ':') {
                    return z(charSequence, "Expected an ASCII digit at index " + i22 + ", got '" + charSequence.charAt(i22) + '\'');
                }
                i21++;
                iArr = iArr2;
            }
            int A6 = A(charSequence, i16 + 1);
            i8 = 3;
            int A7 = length > 3 ? A(charSequence, i16 + 4) : 0;
            int A8 = length > 6 ? A(charSequence, i16 + 7) : 0;
            if (A7 > 59) {
                return z(charSequence, "Expected offset-minute-of-hour in 0..59, got " + A7);
            }
            if (A8 > 59) {
                return z(charSequence, "Expected offset-second-of-minute in 0..59, got " + A8);
            }
            if (A6 > 17 && (A6 != 18 || A7 != 0 || A8 != 0)) {
                return z(charSequence, "Expected an offset in -18:00..+18:00, got " + charSequence.subSequence(i16, charSequence.length()).toString());
            }
            i9 = (charAt4 == '-' ? -1 : 1) * ((A6 * 3600) + (A7 * 60) + A8);
        } else {
            if (charAt4 != 'Z' && charAt4 != 'z') {
                return z(charSequence, "Expected the UTC offset at position " + i16 + ", got '" + charAt4 + '\'');
            }
            int i23 = i16 + 1;
            if (charSequence.length() != i23) {
                return z(charSequence, "Extra text after the instant at position " + i23);
            }
            i9 = 0;
            i8 = 3;
        }
        if (1 > A || A >= 13) {
            return z(charSequence, "Expected a month number in 1..12, got " + A);
        }
        if (1 > A2 || A2 > q(A, p(i13))) {
            return z(charSequence, "Expected a valid day-of-month for month " + A + " of year " + i13 + ", got " + A2);
        }
        if (A3 > 23) {
            return z(charSequence, "Expected hour in 0..23, got " + A3);
        }
        if (A4 > 59) {
            return z(charSequence, "Expected minute-of-hour in 0..59, got " + A4);
        }
        if (A5 > 59) {
            return z(charSequence, "Expected second-of-minute in 0..59, got " + A5);
        }
        g0 g0Var = new g0(i13, A, A2, A3, A4, A5, i7);
        long g6 = g0Var.g();
        long j6 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME * g6;
        long d6 = (g6 >= 0 ? j6 + (((i8 + g6) / 4) - ((99 + g6) / 100)) + ((g6 + 399) / 400) : j6 - (((g6 / (-4)) - (g6 / (-100))) + (g6 / (-400)))) + (((g0Var.d() * MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME) - 362) / 12) + (g0Var.a() - 1);
        if (g0Var.d() > 2) {
            d6 = !p(g0Var.g()) ? d6 - 2 : (-1) + d6;
        }
        return new w.b((((d6 - f48038f) * 86400) + (((g0Var.b() * 3600) + (g0Var.c() * 60)) + g0Var.f())) - i9, g0Var.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(char c6) {
        return c6 == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(char c6) {
        return '0' <= c6 && c6 < ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(char c6) {
        return c6 == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(char c6) {
        return c6 == 'T' || c6 == 't';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(char c6) {
        return c6 == ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(char c6) {
        return c6 == ':';
    }

    private static final w.a z(CharSequence charSequence, String str) {
        return new w.a(str + " when parsing an Instant from \"" + D(charSequence, 64) + '\"', charSequence);
    }

    private static final int A(CharSequence charSequence, int i6) {
        return ((charSequence.charAt(i6) - '0') * 10) + (charSequence.charAt(i6 + 1) - '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String D(CharSequence charSequence, int i6) {
        if (charSequence.length() <= i6) {
            return charSequence.toString();
        }
        return charSequence.subSequence(0, i6).toString() + "...";
    }

    private static final w.a s(CharSequence charSequence, String str, int i6, Function1<? super Character, Boolean> function1) {
        char charAt = charSequence.charAt(i6);
        if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
            return null;
        }
        return z(charSequence, "Expected " + str + ", but got '" + charAt + "' at position " + i6);
    }

    @SinceKotlin(version = "2.1")
    @InlineOnly
    @ExperimentalTime
    public static /* synthetic */ void m(Instant instant) {
    }

    @SinceKotlin(version = "2.1")
    @InlineOnly
    @ExperimentalTime
    public static /* synthetic */ void o(Instant instant) {
    }
}
