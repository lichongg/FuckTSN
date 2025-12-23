package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class s {
    @NotNull
    public abstract v1 b();

    @NotNull
    public abstract String c();

    public abstract boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull k kVar, boolean z5);

    @NotNull
    public abstract s f();

    @Nullable
    public final Integer a(@NotNull s visibility) {
        kotlin.jvm.internal.g0.p(visibility, "visibility");
        return b().a(visibility.b());
    }

    protected s() {
    }

    public final boolean d() {
        return b().c();
    }

    @NotNull
    public final String toString() {
        return b().toString();
    }
}
