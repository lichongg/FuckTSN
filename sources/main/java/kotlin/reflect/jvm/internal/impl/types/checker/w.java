package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final t0 f47198a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final w f47199b;

    public w(@NotNull t0 type, @Nullable w wVar) {
        g0.p(type, "type");
        this.f47198a = type;
        this.f47199b = wVar;
    }

    @Nullable
    public final w a() {
        return this.f47199b;
    }

    @NotNull
    public final t0 getType() {
        return this.f47198a;
    }
}
