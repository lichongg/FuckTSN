package kotlin.reflect.jvm.internal.impl.name;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f implements Comparable<f> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f46350a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f46351b;

    private static /* synthetic */ void a(int i6) {
        String str = (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) ? 2 : 3];
        if (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = CommonNetImpl.NAME;
        }
        if (i6 == 1) {
            objArr[1] = "asString";
        } else if (i6 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i6 == 3 || i6 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i6) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "identifierIfValid";
                break;
            case 8:
                objArr[2] = "special";
                break;
            case 9:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 1 && i6 != 2 && i6 != 3 && i6 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f46351b == fVar.f46351b && this.f46350a.equals(fVar.f46350a);
    }

    private f(@NotNull String str, boolean z5) {
        if (str == null) {
            a(0);
        }
        this.f46350a = str;
        this.f46351b = z5;
    }

    @NotNull
    public static f d(@NotNull String str) {
        if (str == null) {
            a(9);
        }
        return str.startsWith("<") ? k(str) : h(str);
    }

    @NotNull
    public static f h(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        return new f(str, false);
    }

    public static boolean j(@NotNull String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static f k(@NotNull String str) {
        if (str == null) {
            a(8);
        }
        if (str.startsWith("<")) {
            return new f(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    @NotNull
    public String b() {
        String str = this.f46350a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return this.f46350a.compareTo(fVar.f46350a);
    }

    @NotNull
    public String getIdentifier() {
        if (this.f46351b) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String b6 = b();
        if (b6 == null) {
            a(2);
        }
        return b6;
    }

    public int hashCode() {
        return (this.f46350a.hashCode() * 31) + (this.f46351b ? 1 : 0);
    }

    public boolean i() {
        return this.f46351b;
    }

    public String toString() {
        return this.f46350a;
    }
}
