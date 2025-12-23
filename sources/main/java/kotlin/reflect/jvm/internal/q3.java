package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class q3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final WeakReference<ClassLoader> f47565a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47566b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private ClassLoader f47567c;

    public q3(@NotNull ClassLoader classLoader) {
        kotlin.jvm.internal.g0.p(classLoader, "classLoader");
        this.f47565a = new WeakReference<>(classLoader);
        this.f47566b = System.identityHashCode(classLoader);
        this.f47567c = classLoader;
    }

    public final void a(@Nullable ClassLoader classLoader) {
        this.f47567c = classLoader;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof q3) && this.f47565a.get() == ((q3) obj).f47565a.get();
    }

    public int hashCode() {
        return this.f47566b;
    }

    @NotNull
    public String toString() {
        String obj;
        ClassLoader classLoader = this.f47565a.get();
        return (classLoader == null || (obj = classLoader.toString()) == null) ? "<null>" : obj;
    }
}
