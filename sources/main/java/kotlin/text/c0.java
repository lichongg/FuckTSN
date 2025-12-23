package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStringBuilderJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringBuilderJVM.kt\nkotlin/text/StringsKt__StringBuilderJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,417:1\n1#2:418\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class c0 extends b0 {
    @SinceKotlin(version = "1.9")
    @InlineOnly
    private static final StringBuilder insert(StringBuilder sb, int i6, byte b6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        StringBuilder insert = sb.insert(i6, (int) b6);
        kotlin.jvm.internal.g0.o(insert, "insert(...)");
        return insert;
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    private static final StringBuilder C(StringBuilder sb, byte b6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((int) b6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return sb;
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    private static final StringBuilder D(StringBuilder sb, short s5) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((int) s5);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder E(StringBuilder sb, byte b6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((int) b6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder F(StringBuilder sb, double d6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(d6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder G(StringBuilder sb, float f6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(f6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder H(StringBuilder sb, int i6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(i6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder I(StringBuilder sb, long j6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(j6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder J(StringBuilder sb, StringBuffer stringBuffer) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(stringBuffer);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder K(StringBuilder sb, StringBuilder sb2) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((CharSequence) sb2);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder L(StringBuilder sb, short s5) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((int) s5);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder M(StringBuilder sb, CharSequence value, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        sb.append(value, i6, i7);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder N(StringBuilder sb, char[] value, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        sb.append(value, i6, i7 - i6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return sb;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @NotNull
    public static final Appendable O(@NotNull Appendable appendable) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        Appendable append = appendable.append(t0.f47956b);
        kotlin.jvm.internal.g0.o(append, "append(...)");
        return append;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Appendable P(Appendable appendable, char c6) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        Appendable append = appendable.append(c6);
        kotlin.jvm.internal.g0.o(append, "append(...)");
        return O(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Appendable Q(Appendable appendable, CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        kotlin.jvm.internal.g0.o(append, "append(...)");
        return O(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @NotNull
    public static final StringBuilder R(@NotNull StringBuilder sb) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(t0.f47956b);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return sb;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder S(StringBuilder sb, byte b6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((int) b6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder T(StringBuilder sb, char c6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(c6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder U(StringBuilder sb, double d6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(d6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder V(StringBuilder sb, float f6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(f6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder W(StringBuilder sb, int i6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(i6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder X(StringBuilder sb, long j6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(j6);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder Y(StringBuilder sb, CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(charSequence);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder Z(StringBuilder sb, Object obj) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(obj);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder a0(StringBuilder sb, String str) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(str);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder b0(StringBuilder sb, StringBuffer stringBuffer) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(stringBuffer);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder c0(StringBuilder sb, StringBuilder sb2) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((CharSequence) sb2);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder d0(StringBuilder sb, short s5) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append((int) s5);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder e0(StringBuilder sb, boolean z5) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(z5);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder f0(StringBuilder sb, char[] value) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        sb.append(value);
        kotlin.jvm.internal.g0.o(sb, "append(...)");
        return R(sb);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final StringBuilder g0(@NotNull StringBuilder sb) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder h0(StringBuilder sb, int i6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        StringBuilder deleteCharAt = sb.deleteCharAt(i6);
        kotlin.jvm.internal.g0.o(deleteCharAt, "deleteCharAt(...)");
        return deleteCharAt;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder i0(StringBuilder sb, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        StringBuilder delete = sb.delete(i6, i7);
        kotlin.jvm.internal.g0.o(delete, "delete(...)");
        return delete;
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    private static final StringBuilder insert(StringBuilder sb, int i6, short s5) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        StringBuilder insert = sb.insert(i6, (int) s5);
        kotlin.jvm.internal.g0.o(insert, "insert(...)");
        return insert;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder j0(StringBuilder sb, int i6, CharSequence value, int i7, int i8) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        StringBuilder insert = sb.insert(i6, value, i7, i8);
        kotlin.jvm.internal.g0.o(insert, "insert(...)");
        return insert;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder k0(StringBuilder sb, int i6, char[] value, int i7, int i8) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        StringBuilder insert = sb.insert(i6, value, i7, i8 - i7);
        kotlin.jvm.internal.g0.o(insert, "insert(...)");
        return insert;
    }

    @InlineOnly
    private static final void l0(StringBuilder sb, int i6, char c6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.setCharAt(i6, c6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder m0(StringBuilder sb, int i6, int i7, String value) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        StringBuilder replace = sb.replace(i6, i7, value);
        kotlin.jvm.internal.g0.o(replace, "replace(...)");
        return replace;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final void n0(StringBuilder sb, char[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        sb.getChars(i7, i8, destination, i6);
    }

    static /* synthetic */ void o0(StringBuilder sb, char[] destination, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = sb.length();
        }
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        sb.getChars(i7, i8, destination, i6);
    }
}
