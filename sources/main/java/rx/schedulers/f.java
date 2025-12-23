package rx.schedulers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final long f54488a;

    /* renamed from: b, reason: collision with root package name */
    private final T f54489b;

    public boolean equals(Object obj) {
        T t5;
        T t6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f54488a == fVar.f54488a && ((t5 = this.f54489b) == (t6 = fVar.f54489b) || (t5 != null && t5.equals(t6)));
    }

    public long a() {
        return this.f54488a;
    }

    public T b() {
        return this.f54489b;
    }

    public int hashCode() {
        long j6 = this.f54488a;
        int i6 = (((int) (j6 ^ (j6 >>> 32))) + 31) * 31;
        T t5 = this.f54489b;
        return i6 + (t5 == null ? 0 : t5.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f54488a), this.f54489b.toString());
    }

    public f(long j6, T t5) {
        this.f54489b = t5;
        this.f54488a = j6;
    }
}
