package f4;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ncapitalizeDecapitalize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 capitalizeDecapitalize.kt\norg/jetbrains/kotlin/util/capitalizeDecapitalize/CapitalizeDecapitalizeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1#2:148\n295#3,2:149\n295#3,2:151\n774#3:153\n865#3,2:154\n1878#3,3:156\n*S KotlinDebug\n*F\n+ 1 capitalizeDecapitalize.kt\norg/jetbrains/kotlin/util/capitalizeDecapitalize/CapitalizeDecapitalizeKt\n*L\n34#1:149,2\n57#1:151,2\n72#1:153\n72#1:154,2\n78#1:156,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull String str) {
        g0.p(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' > charAt || charAt >= '{') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(charAt));
        sb.append((CharSequence) str, 1, str.length());
        return sb.toString();
    }

    @NotNull
    public static final String b(@NotNull String str) {
        g0.p(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' > charAt || charAt >= '[') {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        g0.o(substring, "substring(...)");
        return lowerCase + substring;
    }

    @NotNull
    public static final String c(@NotNull String str, boolean z5) {
        Integer num;
        g0.p(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        if (!d(str, 0, z5)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z5)) {
            if (z5) {
                return b(str);
            }
            if (str.length() <= 0) {
                return str;
            }
            char lowerCase = Character.toLowerCase(str.charAt(0));
            String substring = str.substring(1);
            g0.o(substring, "substring(...)");
            return lowerCase + substring;
        }
        Iterator<Integer> it = u.x3(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!d(str, num.intValue(), z5)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return e(str, z5);
        }
        int intValue = num2.intValue() - 1;
        StringBuilder sb = new StringBuilder();
        String substring2 = str.substring(0, intValue);
        g0.o(substring2, "substring(...)");
        sb.append(e(substring2, z5));
        String substring3 = str.substring(intValue);
        g0.o(substring3, "substring(...)");
        sb.append(substring3);
        return sb.toString();
    }

    private static final String e(String str, boolean z5) {
        if (z5) {
            return f(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        g0.o(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @NotNull
    public static final String f(@NotNull String str) {
        g0.p(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    private static final boolean d(String str, int i6, boolean z5) {
        char charAt = str.charAt(i6);
        if (z5) {
            if ('A' > charAt || charAt >= '[') {
                return false;
            }
            return true;
        }
        return Character.isUpperCase(charAt);
    }
}
