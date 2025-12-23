package kotlin.ranges;

import kotlin.collections.d1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k implements Iterable<Integer>, m3.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f44175d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f44176a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44177b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44178c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final k a(int i6, int i7, int i8) {
            return new k(i6, i7, i8);
        }
    }

    public final int e() {
        return this.f44176a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (isEmpty() && ((k) obj).isEmpty()) {
            return true;
        }
        k kVar = (k) obj;
        return this.f44176a == kVar.f44176a && this.f44177b == kVar.f44177b && this.f44178c == kVar.f44178c;
    }

    public final int f() {
        return this.f44177b;
    }

    public final int g() {
        return this.f44178c;
    }

    public boolean isEmpty() {
        return this.f44178c > 0 ? this.f44176a > this.f44177b : this.f44176a < this.f44177b;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public d1 iterator() {
        return new l(this.f44176a, this.f44177b, this.f44178c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i6;
        if (this.f44178c > 0) {
            sb = new StringBuilder();
            sb.append(this.f44176a);
            sb.append("..");
            sb.append(this.f44177b);
            sb.append(" step ");
            i6 = this.f44178c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f44176a);
            sb.append(" downTo ");
            sb.append(this.f44177b);
            sb.append(" step ");
            i6 = -this.f44178c;
        }
        sb.append(i6);
        return sb.toString();
    }

    public k(int i6, int i7, int i8) {
        if (i8 != 0) {
            if (i8 != Integer.MIN_VALUE) {
                this.f44176a = i6;
                this.f44177b = kotlin.internal.c.c(i6, i7, i8);
                this.f44178c = i8;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f44176a * 31) + this.f44177b) * 31) + this.f44178c;
    }
}
