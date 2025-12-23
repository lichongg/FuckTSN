package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.d<? extends e> f45187a;

    public f(@NotNull kotlin.reflect.d<? extends e> klass) {
        g0.p(klass, "klass");
        this.f45187a = klass;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof f) && g0.g(this.f45187a, ((f) obj).f45187a);
    }

    public int hashCode() {
        return this.f45187a.hashCode();
    }

    @NotNull
    public String toString() {
        String name = l3.a.e(this.f45187a).getName();
        g0.o(name, "getName(...)");
        return name;
    }
}
