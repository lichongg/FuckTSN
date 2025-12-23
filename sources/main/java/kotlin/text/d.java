package kotlin.text;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class d extends c {
    @SinceKotlin(version = "1.5")
    public static final char E(int i6, int i7) {
        if (2 > i7 || i7 >= 37) {
            throw new IllegalArgumentException("Invalid radix: " + i7 + ". Valid radix values are in range 2..36");
        }
        if (i6 >= 0 && i6 < i7) {
            return (char) (i6 < 10 ? i6 + 48 : ((char) (i6 + 65)) - '\n');
        }
        throw new IllegalArgumentException("Digit " + i6 + " does not represent a valid digit in radix " + i7);
    }

    public static final boolean J(char c6, char c7, boolean z5) {
        if (c6 == c7) {
            return true;
        }
        if (!z5) {
            return false;
        }
        char upperCase = Character.toUpperCase(c6);
        char upperCase2 = Character.toUpperCase(c7);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    @SinceKotlin(version = "1.5")
    public static final char D(int i6) {
        if (i6 >= 0 && i6 < 10) {
            return (char) (i6 + 48);
        }
        throw new IllegalArgumentException("Int " + i6 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    public static final int F(char c6) {
        int b6 = c.b(c6, 10);
        if (b6 >= 0) {
            return b6;
        }
        throw new IllegalArgumentException("Char " + c6 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Integer H(char c6) {
        Integer valueOf = Integer.valueOf(c.b(c6, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static /* synthetic */ boolean K(char c6, char c7, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return J(c6, c7, z5);
    }

    @InlineOnly
    private static final String M(char c6, String other) {
        kotlin.jvm.internal.g0.p(other, "other");
        return c6 + other;
    }

    @SinceKotlin(version = "1.5")
    public static final int G(char c6, int i6) {
        Integer I = I(c6, i6);
        if (I != null) {
            return I.intValue();
        }
        throw new IllegalArgumentException("Char " + c6 + " is not a digit in the given radix=" + i6);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Integer I(char c6, int i6) {
        c.a(i6);
        Integer valueOf = Integer.valueOf(c.b(c6, i6));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static boolean L(char c6) {
        if (55296 > c6 || c6 >= 57344) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String N(char c6) {
        return y0.a(c6);
    }
}
