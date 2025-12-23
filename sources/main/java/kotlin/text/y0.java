package kotlin.text;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y0 {
    @NotNull
    public static final String a(char c6) {
        String valueOf = String.valueOf(c6);
        kotlin.jvm.internal.g0.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
        if (upperCase.length() > 1) {
            if (c6 == 329) {
                return upperCase;
            }
            char charAt = upperCase.charAt(0);
            kotlin.jvm.internal.g0.n(upperCase, "null cannot be cast to non-null type java.lang.String");
            String substring = upperCase.substring(1);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            kotlin.jvm.internal.g0.n(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(locale);
            kotlin.jvm.internal.g0.o(lowerCase, "toLowerCase(...)");
            return charAt + lowerCase;
        }
        return String.valueOf(Character.toTitleCase(c6));
    }
}
