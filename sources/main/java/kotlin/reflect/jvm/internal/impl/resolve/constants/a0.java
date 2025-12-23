package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 extends b {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final t0 f46661c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(@NotNull List<? extends g<?>> value, @NotNull t0 type) {
        super(value, new z(type));
        g0.p(value, "value");
        g0.p(type, "type");
        this.f46661c = type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 b(t0 t0Var, kotlin.reflect.jvm.internal.impl.descriptors.f0 it) {
        g0.p(it, "it");
        return t0Var;
    }

    @NotNull
    public final t0 getType() {
        return this.f46661c;
    }
}
