package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d0 extends c0 {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String A0(int i6, Function1<? super StringBuilder, n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i6);
        builderAction.invoke(sb);
        return sb.toString();
    }

    @InlineOnly
    private static final String B0(Function1<? super StringBuilder, n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        return sb.toString();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    private static final StringBuilder p0(StringBuilder sb, Object obj) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(obj);
        return sb;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    @InlineOnly
    private static final StringBuilder q0(StringBuilder sb, char[] str, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(str, "str");
        throw new NotImplementedError(null, 1, null);
    }

    @NotNull
    public static final StringBuilder r0(@NotNull StringBuilder sb, @NotNull Object... value) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        for (Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    @NotNull
    public static StringBuilder s0(@NotNull StringBuilder sb, @NotNull String... value) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder t0(StringBuilder sb) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder u0(StringBuilder sb, char c6) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(c6);
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder v0(StringBuilder sb, CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(charSequence);
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder w0(StringBuilder sb, Object obj) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(obj);
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder x0(StringBuilder sb, String str) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder y0(StringBuilder sb, boolean z5) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        sb.append(z5);
        sb.append('\n');
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final StringBuilder z0(StringBuilder sb, char[] value) {
        kotlin.jvm.internal.g0.p(sb, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        sb.append(value);
        sb.append('\n');
        return sb;
    }
}
