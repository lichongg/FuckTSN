package kotlin.uuid;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.d1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import kotlin.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "2.0")
@ExperimentalUuidApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Uuid implements Comparable<Uuid>, Serializable {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final Uuid NIL = new Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final Uuid a(@NotNull byte[] byteArray) {
            String v5;
            g0.p(byteArray, "byteArray");
            if (byteArray.length == 16) {
                return b(c.b(byteArray, 0), c.b(byteArray, 8));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected exactly 16 bytes, but was ");
            v5 = d.v(byteArray, 32);
            sb.append(v5);
            sb.append(" of size ");
            sb.append(byteArray.length);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        @NotNull
        public final Uuid b(long j6, long j7) {
            return (j6 == 0 && j7 == 0) ? g() : new Uuid(j6, j7, null);
        }

        @SinceKotlin(version = "2.1")
        @ExperimentalUnsignedTypes
        @NotNull
        public final Uuid c(@NotNull byte[] bArr) {
            g0.p(bArr, "$v$c$kotlin-UByteArray$-ubyteArray$0");
            return a(bArr);
        }

        @NotNull
        public final Uuid h(@NotNull String uuidString) {
            String u5;
            g0.p(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return c.m(uuidString);
            }
            if (length == 36) {
                return c.n(uuidString);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
            u5 = d.u(uuidString, 64);
            sb.append(u5);
            sb.append("\" of length ");
            sb.append(uuidString.length());
            throw new IllegalArgumentException(sb.toString());
        }

        @NotNull
        public final Uuid i(@NotNull String hexString) {
            String u5;
            g0.p(hexString, "hexString");
            if (hexString.length() == 32) {
                return c.m(hexString);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a 32-char hexadecimal string, but was \"");
            u5 = d.u(hexString, 64);
            sb.append(u5);
            sb.append("\" of length ");
            sb.append(hexString.length());
            throw new IllegalArgumentException(sb.toString().toString());
        }

        @SinceKotlin(version = "2.1")
        @NotNull
        public final Uuid j(@NotNull String hexDashString) {
            String u5;
            g0.p(hexDashString, "hexDashString");
            if (hexDashString.length() == 36) {
                return c.n(hexDashString);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a 36-char string in the standard hex-and-dash UUID format, but was \"");
            u5 = d.u(hexDashString, 64);
            sb.append(u5);
            sb.append("\" of length ");
            sb.append(hexDashString.length());
            throw new IllegalArgumentException(sb.toString().toString());
        }

        @NotNull
        public final Uuid d(long j6, long j7) {
            return b(j6, j7);
        }

        @NotNull
        public final Comparator<Uuid> e() {
            return kotlin.comparisons.a.q();
        }

        @NotNull
        public final Uuid g() {
            return Uuid.NIL;
        }

        @NotNull
        public final Uuid k() {
            return c.h();
        }

        @Deprecated(message = "Use naturalOrder<Uuid>() instead", replaceWith = @ReplaceWith(expression = "naturalOrder<Uuid>()", imports = {"kotlin.comparisons.naturalOrder"}))
        @DeprecatedSinceKotlin(warningSince = "2.1")
        public static /* synthetic */ void f() {
        }
    }

    public /* synthetic */ Uuid(long j6, long j7, v vVar) {
        this(j6, j7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    private Uuid(long j6, long j7) {
        this.mostSignificantBits = j6;
        this.leastSignificantBits = j7;
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @InlineOnly
    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        g0.p(action, "action");
        return action.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    @InlineOnly
    private final <T> T toULongs(Function2<? super d1, ? super d1, ? extends T> action) {
        g0.p(action, "action");
        return action.invoke(d1.b(d1.k(getMostSignificantBits())), d1.b(d1.k(getLeastSignificantBits())));
    }

    @Override // java.lang.Comparable
    @SinceKotlin(version = "2.1")
    public int compareTo(@NotNull Uuid other) {
        int compare;
        int compare2;
        g0.p(other, "other");
        long j6 = this.mostSignificantBits;
        if (j6 != other.mostSignificantBits) {
            compare2 = Long.compare(d1.k(j6) ^ Long.MIN_VALUE, d1.k(other.mostSignificantBits) ^ Long.MIN_VALUE);
            return compare2;
        }
        compare = Long.compare(d1.k(this.leastSignificantBits) ^ Long.MIN_VALUE, d1.k(other.leastSignificantBits) ^ Long.MIN_VALUE);
        return compare;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public int hashCode() {
        return androidx.camera.camera2.internal.compat.params.e.a(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    @NotNull
    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        c.j(bArr, 0, this.mostSignificantBits);
        c.j(bArr, 8, this.leastSignificantBits);
        return bArr;
    }

    @SinceKotlin(version = "2.1")
    @NotNull
    public final String toHexDashString() {
        byte[] bArr = new byte[36];
        c.a(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        c.a(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        c.a(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        c.a(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        c.a(this.leastSignificantBits, bArr, 24, 2, 8);
        return u.S1(bArr);
    }

    @NotNull
    public final String toHexString() {
        byte[] bArr = new byte[32];
        c.a(this.mostSignificantBits, bArr, 0, 0, 8);
        c.a(this.leastSignificantBits, bArr, 16, 0, 8);
        return u.S1(bArr);
    }

    private final Object writeReplace() {
        return c.i(this);
    }

    @NotNull
    public String toString() {
        return toHexDashString();
    }

    @SinceKotlin(version = "2.1")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toUByteArray-TcUX1vc, reason: not valid java name */
    public final byte[] m144toUByteArrayTcUX1vc() {
        return w0.f(toByteArray());
    }

    @PublishedApi
    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }
}
