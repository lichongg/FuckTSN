package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.c2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final g f45041a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<c2> f45042b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final u0 f45043c;

    /* JADX WARN: Multi-variable type inference failed */
    public u0(@NotNull g classifierDescriptor, @NotNull List<? extends c2> arguments, @Nullable u0 u0Var) {
        kotlin.jvm.internal.g0.p(classifierDescriptor, "classifierDescriptor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        this.f45041a = classifierDescriptor;
        this.f45042b = arguments;
        this.f45043c = u0Var;
    }

    @NotNull
    public final List<c2> a() {
        return this.f45042b;
    }

    @NotNull
    public final g b() {
        return this.f45041a;
    }

    @Nullable
    public final u0 c() {
        return this.f45043c;
    }
}
