package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y implements e1 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d0 f46008b;

    public y(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d0 packageFragment) {
        kotlin.jvm.internal.g0.p(packageFragment, "packageFragment");
        this.f46008b = packageFragment;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    @NotNull
    public f1 b() {
        f1 NO_SOURCE_FILE = f1.f44684a;
        kotlin.jvm.internal.g0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public String toString() {
        return this.f46008b + ": " + this.f46008b.J0().keySet();
    }
}
