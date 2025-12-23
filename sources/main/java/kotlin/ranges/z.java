package kotlin.ranges;

import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.d1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
/* loaded from: D:\Downloads\app\classes8.dex */
public class z implements Iterable<d1>, m3.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f44209d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f44210a;

    /* renamed from: b, reason: collision with root package name */
    private final long f44211b;

    /* renamed from: c, reason: collision with root package name */
    private final long f44212c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final z a(long j6, long j7, long j8) {
            return new z(j6, j7, j8, null);
        }
    }

    public /* synthetic */ z(long j6, long j7, long j8, kotlin.jvm.internal.v vVar) {
        this(j6, j7, j8);
    }

    private z(long j6, long j7, long j8) {
        if (j8 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j8 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f44210a = j6;
        this.f44211b = kotlin.internal.e.c(j6, j7, j8);
        this.f44212c = j8;
    }

    public final long e() {
        return this.f44210a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        if (isEmpty() && ((z) obj).isEmpty()) {
            return true;
        }
        z zVar = (z) obj;
        return this.f44210a == zVar.f44210a && this.f44211b == zVar.f44211b && this.f44212c == zVar.f44212c;
    }

    public final long f() {
        return this.f44211b;
    }

    public final long g() {
        return this.f44212c;
    }

    public boolean isEmpty() {
        int compare;
        long j6 = this.f44212c;
        compare = Long.compare(this.f44210a ^ Long.MIN_VALUE, this.f44211b ^ Long.MIN_VALUE);
        return j6 > 0 ? compare > 0 : compare < 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<d1> iterator() {
        return new a0(this.f44210a, this.f44211b, this.f44212c, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j6;
        if (this.f44212c > 0) {
            sb = new StringBuilder();
            sb.append((Object) d1.l0(this.f44210a));
            sb.append("..");
            sb.append((Object) d1.l0(this.f44211b));
            sb.append(" step ");
            j6 = this.f44212c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) d1.l0(this.f44210a));
            sb.append(" downTo ");
            sb.append((Object) d1.l0(this.f44211b));
            sb.append(" step ");
            j6 = -this.f44212c;
        }
        sb.append(j6);
        return sb.toString();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j6 = this.f44210a;
        int k6 = ((int) d1.k(j6 ^ d1.k(j6 >>> 32))) * 31;
        long j7 = this.f44211b;
        int k7 = (k6 + ((int) d1.k(j7 ^ d1.k(j7 >>> 32)))) * 31;
        long j8 = this.f44212c;
        return k7 + ((int) (j8 ^ (j8 >>> 32)));
    }
}
