package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class v {
    @NotNull
    public static final <T extends Appendable> T a(@NotNull T t5, @NotNull CharSequence... value) {
        kotlin.jvm.internal.g0.p(t5, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        for (CharSequence charSequence : value) {
            t5.append(charSequence);
        }
        return t5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(@NotNull Appendable appendable, T t5, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        if (function1 != null) {
            appendable.append(function1.invoke(t5));
            return;
        }
        if (t5 == 0 ? true : t5 instanceof CharSequence) {
            appendable.append((CharSequence) t5);
        } else if (t5 instanceof Character) {
            appendable.append(((Character) t5).charValue());
        } else {
            appendable.append(t5.toString());
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Appendable c(Appendable appendable) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        return appendable.append('\n');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Appendable d(Appendable appendable, char c6) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        return appendable.append(c6).append('\n');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Appendable e(Appendable appendable, CharSequence charSequence) {
        kotlin.jvm.internal.g0.p(appendable, "<this>");
        return appendable.append(charSequence).append('\n');
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T extends Appendable> T f(@NotNull T t5, @NotNull CharSequence value, int i6, int i7) {
        kotlin.jvm.internal.g0.p(t5, "<this>");
        kotlin.jvm.internal.g0.p(value, "value");
        T t6 = (T) t5.append(value, i6, i7);
        kotlin.jvm.internal.g0.n(t6, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t6;
    }
}
