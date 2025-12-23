package rx.schedulers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final long f54486a;

    /* renamed from: b, reason: collision with root package name */
    private final T f54487b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f54486a != eVar.f54486a) {
            return false;
        }
        T t5 = this.f54487b;
        if (t5 == null) {
            if (eVar.f54487b != null) {
                return false;
            }
        } else if (!t5.equals(eVar.f54487b)) {
            return false;
        }
        return true;
    }

    public long a() {
        return this.f54486a;
    }

    public T b() {
        return this.f54487b;
    }

    public int hashCode() {
        long j6 = this.f54486a;
        int i6 = (((int) (j6 ^ (j6 >>> 32))) + 31) * 31;
        T t5 = this.f54487b;
        return i6 + (t5 == null ? 0 : t5.hashCode());
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.f54486a + ", value=" + this.f54487b + "]";
    }

    public e(long j6, T t5) {
        this.f54487b = t5;
        this.f54486a = j6;
    }
}
