package retrofit2.adapter.rxjava;

import javax.annotation.Nullable;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final c0<T> f52037a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Throwable f52038b;

    public static <T> e<T> b(Throwable th) {
        if (th != null) {
            return new e<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> e<T> e(c0<T> c0Var) {
        if (c0Var != null) {
            return new e<>(c0Var, null);
        }
        throw new NullPointerException("response == null");
    }

    @Nullable
    public Throwable a() {
        return this.f52038b;
    }

    public boolean c() {
        return this.f52038b != null;
    }

    @Nullable
    public c0<T> d() {
        return this.f52037a;
    }

    public String toString() {
        if (this.f52038b != null) {
            return "Result{isError=true, error=\"" + this.f52038b + "\"}";
        }
        return "Result{isError=false, response=" + this.f52037a + '}';
    }

    private e(@Nullable c0<T> c0Var, @Nullable Throwable th) {
        this.f52037a = c0Var;
        this.f52038b = th;
    }
}
