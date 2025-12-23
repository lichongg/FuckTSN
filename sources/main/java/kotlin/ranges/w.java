package kotlin.ranges;

import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
/* loaded from: D:\Downloads\app\classes8.dex */
public class w implements Iterable<z0>, m3.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f44199d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f44200a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44201b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44202c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final w a(int i6, int i7, int i8) {
            return new w(i6, i7, i8, null);
        }
    }

    public /* synthetic */ w(int i6, int i7, int i8, kotlin.jvm.internal.v vVar) {
        this(i6, i7, i8);
    }

    private w(int i6, int i7, int i8) {
        if (i8 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i8 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f44200a = i6;
        this.f44201b = kotlin.internal.e.d(i6, i7, i8);
        this.f44202c = i8;
    }

    public final int e() {
        return this.f44200a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        if (isEmpty() && ((w) obj).isEmpty()) {
            return true;
        }
        w wVar = (w) obj;
        return this.f44200a == wVar.f44200a && this.f44201b == wVar.f44201b && this.f44202c == wVar.f44202c;
    }

    public final int f() {
        return this.f44201b;
    }

    public final int g() {
        return this.f44202c;
    }

    public boolean isEmpty() {
        int compare;
        int compare2;
        if (this.f44202c > 0) {
            compare2 = Integer.compare(this.f44200a ^ Integer.MIN_VALUE, this.f44201b ^ Integer.MIN_VALUE);
            return compare2 > 0;
        }
        compare = Integer.compare(this.f44200a ^ Integer.MIN_VALUE, this.f44201b ^ Integer.MIN_VALUE);
        return compare < 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<z0> iterator() {
        return new x(this.f44200a, this.f44201b, this.f44202c, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i6;
        if (this.f44202c > 0) {
            sb = new StringBuilder();
            sb.append((Object) z0.l0(this.f44200a));
            sb.append("..");
            sb.append((Object) z0.l0(this.f44201b));
            sb.append(" step ");
            i6 = this.f44202c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) z0.l0(this.f44200a));
            sb.append(" downTo ");
            sb.append((Object) z0.l0(this.f44201b));
            sb.append(" step ");
            i6 = -this.f44202c;
        }
        sb.append(i6);
        return sb.toString();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f44200a * 31) + this.f44201b) * 31) + this.f44202c;
    }
}
