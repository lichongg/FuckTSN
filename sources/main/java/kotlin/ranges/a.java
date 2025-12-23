package kotlin.ranges;

import kotlin.collections.e0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a implements Iterable<Character>, m3.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0870a f44151d = new C0870a(null);

    /* renamed from: a, reason: collision with root package name */
    private final char f44152a;

    /* renamed from: b, reason: collision with root package name */
    private final char f44153b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44154c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.ranges.a$a, reason: collision with other inner class name */
    public static final class C0870a {
        public /* synthetic */ C0870a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private C0870a() {
        }

        @NotNull
        public final a a(char c6, char c7, int i6) {
            return new a(c6, c7, i6);
        }
    }

    public final char e() {
        return this.f44152a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f44152a == aVar.f44152a && this.f44153b == aVar.f44153b && this.f44154c == aVar.f44154c;
    }

    public final char f() {
        return this.f44153b;
    }

    public final int g() {
        return this.f44154c;
    }

    public boolean isEmpty() {
        return this.f44154c > 0 ? g0.t(this.f44152a, this.f44153b) > 0 : g0.t(this.f44152a, this.f44153b) < 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public e0 iterator() {
        return new b(this.f44152a, this.f44153b, this.f44154c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i6;
        if (this.f44154c > 0) {
            sb = new StringBuilder();
            sb.append(this.f44152a);
            sb.append("..");
            sb.append(this.f44153b);
            sb.append(" step ");
            i6 = this.f44154c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f44152a);
            sb.append(" downTo ");
            sb.append(this.f44153b);
            sb.append(" step ");
            i6 = -this.f44154c;
        }
        sb.append(i6);
        return sb.toString();
    }

    public a(char c6, char c7, int i6) {
        if (i6 != 0) {
            if (i6 != Integer.MIN_VALUE) {
                this.f44152a = c6;
                this.f44153b = (char) kotlin.internal.c.c(c6, c7, i6);
                this.f44154c = i6;
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
        return (((this.f44152a * 31) + this.f44153b) * 31) + this.f44154c;
    }
}
