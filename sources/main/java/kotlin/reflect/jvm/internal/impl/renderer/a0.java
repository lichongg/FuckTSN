package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRenderingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,78:1\n1088#2,2:79\n*S KotlinDebug\n*F\n+ 1 RenderingUtils.kt\norg/jetbrains/kotlin/renderer/RenderingUtilsKt\n*L\n30#1:79,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 {
    @NotNull
    public static final String a(@NotNull kotlin.reflect.jvm.internal.impl.name.d dVar) {
        g0.p(dVar, "<this>");
        return c(dVar.h());
    }

    @NotNull
    public static final String b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        g0.p(fVar, "<this>");
        if (!e(fVar)) {
            String b6 = fVar.b();
            g0.o(b6, "asString(...)");
            return b6;
        }
        StringBuilder sb = new StringBuilder();
        String b7 = fVar.b();
        g0.o(b7, "asString(...)");
        sb.append('`' + b7);
        sb.append('`');
        return sb.toString();
    }

    @NotNull
    public static final String c(@NotNull List<kotlin.reflect.jvm.internal.impl.name.f> pathSegments) {
        g0.p(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (kotlin.reflect.jvm.internal.impl.name.f fVar : pathSegments) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(fVar));
        }
        return sb.toString();
    }

    @Nullable
    public static final String d(@NotNull String lowerRendered, @NotNull String lowerPrefix, @NotNull String upperRendered, @NotNull String upperPrefix, @NotNull String foldedPrefix) {
        g0.p(lowerRendered, "lowerRendered");
        g0.p(lowerPrefix, "lowerPrefix");
        g0.p(upperRendered, "upperRendered");
        g0.p(upperPrefix, "upperPrefix");
        g0.p(foldedPrefix, "foldedPrefix");
        if (kotlin.text.u.H2(lowerRendered, lowerPrefix, false, 2, null) && kotlin.text.u.H2(upperRendered, upperPrefix, false, 2, null)) {
            String substring = lowerRendered.substring(lowerPrefix.length());
            g0.o(substring, "substring(...)");
            String substring2 = upperRendered.substring(upperPrefix.length());
            g0.o(substring2, "substring(...)");
            String str = foldedPrefix + substring;
            if (g0.g(substring, substring2)) {
                return str;
            }
            if (f(substring, substring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean f(@NotNull String lower, @NotNull String upper) {
        g0.p(lower, "lower");
        g0.p(upper, "upper");
        if (g0.g(lower, kotlin.text.u.x2(upper, "?", "", false, 4, null))) {
            return true;
        }
        if (kotlin.text.u.Z1(upper, "?", false, 2, null)) {
            if (g0.g(lower + '?', upper)) {
                return true;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(lower);
        sb.append(")?");
        return g0.g(sb.toString(), upper);
    }

    private static final boolean e(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        String b6 = fVar.b();
        g0.o(b6, "asString(...)");
        if (!z.f46631a.contains(b6)) {
            for (int i6 = 0; i6 < b6.length(); i6++) {
                char charAt = b6.charAt(i6);
                if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                    return true;
                }
            }
            if (b6.length() != 0 && Character.isJavaIdentifierStart(b6.codePointAt(0))) {
                return false;
            }
            return true;
        }
        return true;
    }
}
