package kotlin.collections;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a1<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f43599a;

    /* renamed from: b, reason: collision with root package name */
    private final T f43600b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return this.f43599a == a1Var.f43599a && kotlin.jvm.internal.g0.g(this.f43600b, a1Var.f43600b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a1 d(a1 a1Var, int i6, Object obj, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            i6 = a1Var.f43599a;
        }
        if ((i7 & 2) != 0) {
            obj = a1Var.f43600b;
        }
        return a1Var.c(i6, obj);
    }

    public final int a() {
        return this.f43599a;
    }

    public final T b() {
        return this.f43600b;
    }

    @NotNull
    public final a1<T> c(int i6, T t5) {
        return new a1<>(i6, t5);
    }

    public final int e() {
        return this.f43599a;
    }

    public final T f() {
        return this.f43600b;
    }

    public int hashCode() {
        int i6 = this.f43599a * 31;
        T t5 = this.f43600b;
        return i6 + (t5 == null ? 0 : t5.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.f43599a + ", value=" + this.f43600b + ')';
    }

    public a1(int i6, T t5) {
        this.f43599a = i6;
        this.f43600b = t5;
    }
}
