package kotlin.ranges;

import kotlin.collections.e1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class n implements Iterable<Long>, m3.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f44185d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f44186a;

    /* renamed from: b, reason: collision with root package name */
    private final long f44187b;

    /* renamed from: c, reason: collision with root package name */
    private final long f44188c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final n a(long j6, long j7, long j8) {
            return new n(j6, j7, j8);
        }
    }

    public final long e() {
        return this.f44186a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (isEmpty() && ((n) obj).isEmpty()) {
            return true;
        }
        n nVar = (n) obj;
        return this.f44186a == nVar.f44186a && this.f44187b == nVar.f44187b && this.f44188c == nVar.f44188c;
    }

    public final long f() {
        return this.f44187b;
    }

    public final long g() {
        return this.f44188c;
    }

    public boolean isEmpty() {
        long j6 = this.f44188c;
        long j7 = this.f44186a;
        long j8 = this.f44187b;
        return j6 > 0 ? j7 > j8 : j7 < j8;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public e1 iterator() {
        return new o(this.f44186a, this.f44187b, this.f44188c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j6;
        if (this.f44188c > 0) {
            sb = new StringBuilder();
            sb.append(this.f44186a);
            sb.append("..");
            sb.append(this.f44187b);
            sb.append(" step ");
            j6 = this.f44188c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f44186a);
            sb.append(" downTo ");
            sb.append(this.f44187b);
            sb.append(" step ");
            j6 = -this.f44188c;
        }
        sb.append(j6);
        return sb.toString();
    }

    public n(long j6, long j7, long j8) {
        if (j8 != 0) {
            if (j8 != Long.MIN_VALUE) {
                this.f44186a = j6;
                this.f44187b = kotlin.internal.c.d(j6, j7, j8);
                this.f44188c = j8;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j6 = 31;
        long j7 = this.f44186a;
        long j8 = this.f44187b;
        long j9 = j6 * (((j7 ^ (j7 >>> 32)) * j6) + (j8 ^ (j8 >>> 32)));
        long j10 = this.f44188c;
        return (int) (j9 + (j10 ^ (j10 >>> 32)));
    }
}
