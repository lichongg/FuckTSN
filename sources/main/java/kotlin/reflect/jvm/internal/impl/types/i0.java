package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nErasureTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasureTypeAttributes.kt\norg/jetbrains/kotlin/types/ErasureTypeAttributes\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final TypeUsage f47272a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Set<kotlin.reflect.jvm.internal.impl.descriptors.j1> f47273b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final e1 f47274c;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(@NotNull TypeUsage howThisTypeIsUsed, @Nullable Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.j1> set, @Nullable e1 e1Var) {
        kotlin.jvm.internal.g0.p(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.f47272a = howThisTypeIsUsed;
        this.f47273b = set;
        this.f47274c = e1Var;
    }

    @Nullable
    public e1 a() {
        return this.f47274c;
    }

    @NotNull
    public TypeUsage b() {
        return this.f47272a;
    }

    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.j1> c() {
        return this.f47273b;
    }

    @NotNull
    public i0 d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 typeParameter) {
        Set f6;
        kotlin.jvm.internal.g0.p(typeParameter, "typeParameter");
        TypeUsage b6 = b();
        Set<kotlin.reflect.jvm.internal.impl.descriptors.j1> c6 = c();
        if (c6 == null || (f6 = kotlin.collections.u1.D(c6, typeParameter)) == null) {
            f6 = kotlin.collections.u1.f(typeParameter);
        }
        return new i0(b6, f6, a());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return kotlin.jvm.internal.g0.g(i0Var.a(), a()) && i0Var.b() == b();
    }

    public int hashCode() {
        int i6;
        e1 a6 = a();
        if (a6 != null) {
            i6 = a6.hashCode();
        } else {
            i6 = 0;
        }
        return i6 + (i6 * 31) + b().hashCode();
    }
}
