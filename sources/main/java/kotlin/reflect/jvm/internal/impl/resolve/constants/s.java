package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s implements w1 {

    /* renamed from: a, reason: collision with root package name */
    private final long f46685a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f46686b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final ArrayList<t0> f46687c;

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public boolean d() {
        return false;
    }

    @Nullable
    public Void e() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public w1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public Collection<t0> i() {
        return this.f46687c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        return this.f46686b.p();
    }

    @NotNull
    public String toString() {
        return "IntegerValueType(" + this.f46685a + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f c() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<j1> getParameters() {
        return kotlin.collections.f0.J();
    }
}
