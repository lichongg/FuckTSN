package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class q<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final t<T> f45981a;

    /* renamed from: b, reason: collision with root package name */
    private int f45982b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private T f45983c;

    public void b() {
        if (this.f45983c == null) {
            this.f45982b++;
        }
    }

    public void c(@NotNull T objectType) {
        kotlin.jvm.internal.g0.p(objectType, "objectType");
        d(objectType);
    }

    protected final void d(@NotNull T type) {
        kotlin.jvm.internal.g0.p(type, "type");
        if (this.f45983c == null) {
            if (this.f45982b > 0) {
                type = this.f45981a.a(kotlin.text.u.t2("[", this.f45982b) + this.f45981a.e(type));
            }
            this.f45983c = type;
        }
    }

    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull T type) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(type, "type");
        d(type);
    }

    public void a() {
    }
}
