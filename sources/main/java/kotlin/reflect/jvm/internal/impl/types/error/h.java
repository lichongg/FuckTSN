package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h implements w1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ErrorTypeKind f47229a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String[] f47230b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f47231c;

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public boolean d() {
        return false;
    }

    public h(@NotNull ErrorTypeKind kind, @NotNull String... formatParams) {
        g0.p(kind, "kind");
        g0.p(formatParams, "formatParams");
        this.f47229a = kind;
        this.f47230b = formatParams;
        String debugText = ErrorEntity.ERROR_TYPE.getDebugText();
        String debugMessage = kind.getDebugMessage();
        Object[] copyOf = Arrays.copyOf(formatParams, formatParams.length);
        String format = String.format(debugMessage, Arrays.copyOf(copyOf, copyOf.length));
        g0.o(format, "format(...)");
        String format2 = String.format(debugText, Arrays.copyOf(new Object[]{format}, 1));
        g0.o(format2, "format(...)");
        this.f47231c = format2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public w1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.f c() {
        return i.f47232a.h();
    }

    @NotNull
    public final ErrorTypeKind e() {
        return this.f47229a;
    }

    @NotNull
    public final String f(int i6) {
        return this.f47230b[i6];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        return kotlin.reflect.jvm.internal.impl.builtins.g.f44434i.a();
    }

    @NotNull
    public String toString() {
        return this.f47231c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<j1> getParameters() {
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public Collection<t0> i() {
        return f0.J();
    }
}
